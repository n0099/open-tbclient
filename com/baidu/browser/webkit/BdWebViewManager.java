package com.baidu.browser.webkit;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdMemUtil;
import com.baidu.browser.core.util.BdZipInputStream;
import com.baidu.browser.webkit.zeus.BdZeusCrashHandler;
import com.baidu.zeus.WebKitInit;
import com.baidu.zeus.WebView;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public final class BdWebViewManager extends Observable {
    private static final int LOAD_ZEUS_TTL = 60;
    public static final int MSG_ON_DELZEUS = 1;
    public static final int MSG_ON_UNZIPZEUS = 0;
    public static final int MSG_ON_ZEUS_INSTALL_FAILED = 3;
    public static final int MSG_ON_ZEUS_INSTALL_SUCCESSED = 2;
    public static final int SDK21 = 7;
    public static final int SDK22 = 8;
    public static final int SDK23 = 9;
    public static final int SDK23X = 10;
    public static final int SDK40 = 14;
    public static final int SDK403 = 15;
    public static final int SDK41 = 16;
    public static final int ZEUS_DOWNLOAD_FAILED = 1;
    public static final int ZEUS_INSTALL_FAILED = 2;
    public static final int ZEUS_INSTALL_SUCCESSED = 4;
    public static final int ZEUS_NOT_FIT = 3;
    public static final int ZEUS_NOT_INSTALL = 0;
    public static final boolean ZEUS_PACK_IN_APPS = false;
    private static BdWebViewManager sInstance;
    private Timer mDaemonTimer;
    private int mInitTime;
    private String mVersionZeusCode;
    private short mZeusFailStatus = 0;
    private String mZeusSdPath = "/baidu/flyflow/so/";
    private String mZeusDownPath = null;
    private String mZeusCode = "j2";
    private String mZeusVersion = null;
    private int mZeusImplVersion = 0;
    private boolean mIsZeusExist = false;
    private boolean mIsZeusIdMatch = false;
    private boolean mIsShowMismatchDialog = false;
    private boolean mIsUnzipFromSd = false;
    private boolean mIsLoadZeusWebkitOk = false;
    private boolean mIsZeusFinished = false;
    private ZipEntry mNextEntry = null;
    private boolean mIsEnableZeus = true;
    private WebViewType mWebViewType = WebViewType.TYPE_SYS;

    /* loaded from: classes.dex */
    public enum WebViewType {
        TYPE_SYS,
        TYPE_ZEUS;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static WebViewType[] valuesCustom() {
            WebViewType[] valuesCustom = values();
            int length = valuesCustom.length;
            WebViewType[] webViewTypeArr = new WebViewType[length];
            System.arraycopy(valuesCustom, 0, webViewTypeArr, 0, length);
            return webViewTypeArr;
        }
    }

    private BdWebViewManager() {
    }

    public static BdWebViewManager getInstance() {
        if (sInstance == null) {
            sInstance = new BdWebViewManager();
        }
        return sInstance;
    }

    public void setIsEnableZeus(boolean z) {
        this.mIsEnableZeus = z;
    }

    public boolean isEnableZeus() {
        return this.mIsEnableZeus;
    }

    public boolean isLoadFinished() {
        return this.mIsZeusFinished;
    }

    public void setVersionZeusCode(String str) {
        this.mVersionZeusCode = str;
    }

    public String getZeusDownPath() {
        return this.mZeusDownPath;
    }

    public void setZeusDownPath(String str) {
        this.mZeusDownPath = str;
    }

    public String getZeusCode() {
        return this.mZeusCode;
    }

    public void setZeusCode(String str) {
        this.mZeusCode = str;
    }

    public String getZeusVersion() {
        return this.mZeusVersion;
    }

    public void setZeusVersion(String str) {
        this.mZeusVersion = str;
    }

    public void setZeusSdPath(String str) {
        this.mZeusSdPath = str;
    }

    public int getZeusImplVersion() {
        return this.mZeusImplVersion;
    }

    public void setZeusImplVersion(int i) {
        this.mZeusImplVersion = i;
    }

    public void attach(Observer observer) {
        if (observer != null) {
            addObserver(observer);
        }
    }

    public void detach(Observer observer) {
        deleteObserver(observer);
    }

    private void notifyObservers(int i, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        setChanged();
        notifyObservers(obtain);
        obtain.recycle();
    }

    private String getZeusZipName() {
        switch (WebKitInit.getOSId()) {
            case 1:
                return "android2.1_NEON.zes";
            case 2:
                return "android2.1_AR.zes";
            case 3:
                return "android2.2_NEON.zes";
            case 4:
                return "android2.2_AR.zes";
            case 5:
                return "android2.3_NEON.zes";
            case 6:
                return "android2.3_AR.zes";
            case 7:
                return "android4.0_NEON.zes";
            case 8:
                return "android4.0_AR.zes";
            case 9:
                return "android4.1_NEON.zes";
            case 10:
                return "android4.1_AR.zes";
            default:
                return null;
        }
    }

    private void setSDKVersion() {
        int i = Build.VERSION.SDK_INT;
        boolean contains = fetchCpuInfo().toLowerCase().contains("neon");
        if (i == 7) {
            if (contains) {
                WebKitInit.setOSId(1);
                this.mZeusCode = "ze1";
                return;
            }
            WebKitInit.setOSId(2);
            this.mZeusCode = "ze2";
        } else if (i == 8) {
            if (contains) {
                WebKitInit.setOSId(3);
                this.mZeusCode = "ze3";
                return;
            }
            WebKitInit.setOSId(4);
            this.mZeusCode = "ze4";
        } else if (i == 9 || i == 10) {
            if (contains) {
                WebKitInit.setOSId(5);
                this.mZeusCode = "ze5";
                return;
            }
            WebKitInit.setOSId(6);
            this.mZeusCode = "ze6";
        } else if (i == 14 || i == 15) {
            if (contains) {
                WebKitInit.setOSId(7);
                this.mZeusCode = "ze7";
                return;
            }
            WebKitInit.setOSId(8);
            this.mZeusCode = "ze8";
        } else if (i == 16) {
            if (contains) {
                WebKitInit.setOSId(9);
                this.mZeusCode = "ze9";
                return;
            }
            WebKitInit.setOSId(10);
            this.mZeusCode = "ze10";
        }
    }

    public void loadZeusLibrary(final Context context) {
        String str;
        String str2;
        if (this.mIsEnableZeus) {
            this.mIsZeusFinished = false;
            String absolutePath = context.getFilesDir().getAbsolutePath();
            BdZeusCrashHandler bdZeusCrashHandler = new BdZeusCrashHandler();
            WebKitInit.setLibPath(absolutePath);
            this.mDaemonTimer = new Timer();
            this.mDaemonTimer.schedule(new TimerTask() { // from class: com.baidu.browser.webkit.BdWebViewManager.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    BdWebViewManager.this.mInitTime++;
                    if (BdWebViewManager.this.mInitTime > BdWebViewManager.LOAD_ZEUS_TTL && !BdWebViewManager.this.mIsZeusFinished) {
                        boolean deleteFile = context.deleteFile("config");
                        BdLog.d("config: " + deleteFile);
                        if (deleteFile) {
                            BdLog.d("libosruntime: " + context.deleteFile("libosruntime.so"));
                            BdLog.d("libzeus: " + context.deleteFile("libzeus.so"));
                            BdLog.d("libZeusJNI: " + context.deleteFile("libZeusJNI.so"));
                        }
                        if (BdWebViewManager.this.mDaemonTimer != null) {
                            BdWebViewManager.this.mDaemonTimer.cancel();
                            BdWebViewManager.this.mDaemonTimer = null;
                        }
                    }
                }
            }, 0L, 1000L);
            String absolutePath2 = context.getFilesDir().getAbsolutePath();
            setSDKVersion();
            File file = new File(String.valueOf(absolutePath2) + "/config");
            if (file.exists()) {
                this.mIsZeusExist = true;
                int readZeusId = readZeusId(file);
                BdLog.w("os id=" + WebKitInit.getOSId());
                if (WebKitInit.getOSId() == readZeusId) {
                    this.mIsZeusIdMatch = true;
                }
            }
            if (!this.mIsZeusIdMatch) {
                this.mZeusDownPath = String.valueOf(absolutePath2) + "/";
                String zeusZipName = getZeusZipName();
                String str3 = String.valueOf(str) + zeusZipName;
                if (str3.endsWith("zes") && new File(str3).exists()) {
                    BdLog.v("zeus zip file path1=" + str3);
                    notifyObservers(0, null);
                    if (unZip(str3, String.valueOf(absolutePath2) + "/", context)) {
                        context.deleteFile(zeusZipName);
                        notifyObservers(1, null);
                        if (file.exists()) {
                            this.mIsZeusExist = true;
                            if (WebKitInit.getOSId() == readZeusId(file)) {
                                this.mIsZeusIdMatch = true;
                                notifyObservers(2, null);
                            }
                        }
                    }
                }
                if (!this.mIsZeusIdMatch && Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    this.mZeusDownPath = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + this.mZeusSdPath;
                    String str4 = String.valueOf(str2) + getZeusZipName();
                    if (str4.endsWith("zes") && new File(str4).exists()) {
                        BdLog.v("zeus zip file path2=" + str4);
                        this.mIsUnzipFromSd = true;
                        notifyObservers(0, null);
                        if (unZip(str4, String.valueOf(absolutePath2) + "/", context) && file.exists()) {
                            this.mIsZeusExist = true;
                            if (WebKitInit.getOSId() == readZeusId(file)) {
                                this.mIsZeusIdMatch = true;
                                notifyObservers(2, null);
                            }
                        }
                    }
                }
            }
            if (this.mIsZeusIdMatch && WebKitInit.versionInit()) {
                this.mZeusVersion = WebKitInit.getVersion();
                BdLog.w("zeus version=" + this.mZeusVersion);
                if (this.mZeusVersion != null) {
                    this.mZeusImplVersion = (int) ipToLong(this.mZeusVersion);
                }
                if (frameZeusMatchCanUse(this.mVersionZeusCode, this.mZeusVersion)) {
                    WebKitInit.setLibPath(absolutePath2);
                    BdLog.v("init zeus begin");
                    this.mIsLoadZeusWebkitOk = WebKitInit.init();
                    BdLog.v("init zeus end");
                    if (this.mIsLoadZeusWebkitOk) {
                        this.mZeusFailStatus = (short) 4;
                    } else {
                        this.mZeusFailStatus = (short) 3;
                        notifyObservers(3, Short.valueOf(this.mZeusFailStatus));
                    }
                } else if (this.mIsUnzipFromSd) {
                    BdLog.w("delele wrong zeus");
                    uninstallZeus(context);
                    this.mZeusVersion = null;
                    this.mZeusImplVersion = 0;
                    notifyObservers(3, Short.valueOf(this.mZeusFailStatus));
                } else {
                    this.mIsShowMismatchDialog = true;
                }
            }
            if (this.mIsLoadZeusWebkitOk) {
                this.mWebViewType = WebViewType.TYPE_ZEUS;
                WebKitInit.setCrashHandler(bdZeusCrashHandler);
            }
            this.mInitTime = 0;
            this.mIsZeusFinished = true;
            if (this.mDaemonTimer != null) {
                this.mDaemonTimer.cancel();
                this.mDaemonTimer = null;
            }
        }
    }

    public boolean isZeusExist() {
        return this.mIsZeusExist;
    }

    public boolean isShowMismatchDialog() {
        return this.mIsShowMismatchDialog;
    }

    public boolean isZeusIdMatch() {
        return this.mIsZeusIdMatch;
    }

    public boolean isZeusLoaded() {
        return this.mWebViewType == WebViewType.TYPE_ZEUS;
    }

    public static int readZeusId(File file) {
        int i = -1;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[DERTags.TAGGED];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    String[] split = new String(byteArray, "UTF-8").split("\r\n")[0].split("=");
                    split[1] = split[1].replaceAll("\r\n", "").replaceAll("\n", "");
                    BdLog.e(String.valueOf(split[0]) + "=" + split[1]);
                    i = Integer.parseInt(split[1]);
                    return i;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return i;
        } catch (IOException e2) {
            e2.printStackTrace();
            return i;
        } catch (Exception e3) {
            e3.printStackTrace();
            return i;
        }
    }

    public boolean unZip(String str, String str2, Context context) {
        boolean z = false;
        try {
            BdZipInputStream bdZipInputStream = new BdZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            getNextEntry(bdZipInputStream);
            while (this.mNextEntry != null) {
                BdLog.i("Unzip=" + this.mNextEntry);
                byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
                String name = this.mNextEntry.getName();
                File file = new File(String.valueOf(str2) + name);
                BdLog.e("deleteFile ok=" + context.deleteFile(name));
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), LVBuffer.LENGTH_ALLOC_PER_NEW);
                for (int read = bdZipInputStream.read(bArr, 0, LVBuffer.LENGTH_ALLOC_PER_NEW); read > 0; read = bdZipInputStream.read(bArr, 0, LVBuffer.LENGTH_ALLOC_PER_NEW)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                getNextEntry(bdZipInputStream);
                bufferedOutputStream.close();
            }
            bdZipInputStream.close();
            z = true;
            return true;
        } catch (ZipException e) {
            BdLog.e("error: " + e.getMessage());
            e.printStackTrace();
            return z;
        } catch (IOException e2) {
            BdLog.e("error: " + e2.getMessage());
            e2.printStackTrace();
            return z;
        } catch (Exception e3) {
            e3.printStackTrace();
            BdLog.e("error: " + e3.getMessage());
            return z;
        }
    }

    private void getNextEntry(ZipInputStream zipInputStream) {
        try {
            try {
                this.mNextEntry = zipInputStream.getNextEntry();
                while (this.mNextEntry != null && this.mNextEntry.isDirectory()) {
                    this.mNextEntry = zipInputStream.getNextEntry();
                }
                if (this.mNextEntry == null) {
                    safeClose(zipInputStream);
                }
            } catch (IOException e) {
                throw new RuntimeException("could not get next zip entry", e);
            } catch (RuntimeException e2) {
                BdLog.e("error: " + e2.getMessage());
                if (this.mNextEntry == null) {
                    safeClose(zipInputStream);
                }
            }
        } catch (Throwable th) {
            if (this.mNextEntry == null) {
                safeClose(zipInputStream);
            }
            throw th;
        }
    }

    private void safeClose(ZipInputStream zipInputStream) {
        if (zipInputStream != null) {
            try {
                zipInputStream.close();
            } catch (IOException e) {
                BdLog.e("exception while trying to close ZIP input stream. " + e.getMessage());
            }
        }
    }

    public long ipToLong(String str) {
        String[] split = str.split("\\.", 4);
        long[] jArr = {Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2]), Long.parseLong(split[3])};
        return (jArr[0] << 24) | (jArr[1] << 16) | (jArr[2] << 8) | jArr[3];
    }

    public String longToIp(long j) {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(String.valueOf(j >>> 24));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf((16777215 & j) >>> 16));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf((65535 & j) >>> 8));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf(255 & j));
        return stringBuffer.toString();
    }

    public boolean frameZeusMatchCanUse(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String[] split = str.split("\\.", 4);
        String[] split2 = str2.split("\\.", 4);
        long[] jArr = {Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split2[0]), Long.parseLong(split2[1])};
        return jArr[0] == jArr[2] && jArr[1] == jArr[3];
    }

    public void uninstallZeus(Context context) {
        context.deleteFile("config");
        context.deleteFile("libosruntime.so");
        context.deleteFile("libzeus.so");
        context.deleteFile("libZeusJNI.so");
        context.deleteFile("libfileAPIPort.so");
        context.deleteFile("libwebsocket.so");
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteAll(new File(String.valueOf(absolutePath) + this.mZeusSdPath));
        }
    }

    public void deleteAll(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            for (File file2 : file.listFiles()) {
                deleteAll(file2);
            }
            file.delete();
        }
    }

    public static String fetchCpuInfo() {
        return readSysInfo("/proc/cpuinfo");
    }

    public static long fetchCpuMaxFreq() {
        String readSysInfo = readSysInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
        if (readSysInfo != null) {
            try {
                if (readSysInfo.length() > 0 && readSysInfo.charAt(readSysInfo.length() - 1) == '\n') {
                    readSysInfo = readSysInfo.substring(0, readSysInfo.length() - 1);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                BdLog.e("Num format Error");
                return 0L;
            }
        }
        return Long.parseLong(readSysInfo);
    }

    private static String readSysInfo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(str);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(String.valueOf(readLine) + "\n");
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    private static int getCpuCoresNum() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.browser.webkit.BdWebViewManager.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public boolean isHighSpeedPhone() {
        long fetchCpuMaxFreq = (fetchCpuMaxFreq() * getCpuCoresNum()) / 1000;
        boolean HasGPU = getInstance().isZeusLoaded() ? WebView.HasGPU() : true;
        BdLog.d("GFS info: " + String.valueOf(fetchCpuMaxFreq) + " " + String.valueOf(HasGPU));
        return fetchCpuMaxFreq >= 1433 && BdMemUtil.getSysMemoryInfo().get("MemTotal:").longValue() / 1000 >= 512 && HasGPU;
    }
}
