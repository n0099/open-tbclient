package com.baidu.live.adp.lib.util;

import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.util.devices.IDevices;
import com.baidu.fsg.face.base.b.c;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes10.dex */
public class BdLoadLibraryHelper {
    private static BdLoadLibraryHelper mInstance = null;

    public static BdLoadLibraryHelper getInstance() {
        BdLoadLibraryHelper bdLoadLibraryHelper;
        if (mInstance == null) {
            synchronized (BdLoadLibraryHelper.class) {
                if (mInstance == null) {
                    mInstance = new BdLoadLibraryHelper();
                }
                bdLoadLibraryHelper = mInstance;
            }
            return bdLoadLibraryHelper;
        }
        return mInstance;
    }

    public boolean loadLibrary(String str, int i, BdLoadLibraryHelperCallback bdLoadLibraryHelperCallback) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            z = false;
        } else {
            boolean z2 = false;
            for (int i2 = 0; i2 < i; i2++) {
                z2 = loadLibrary(str, sb);
                if (z2) {
                    break;
                }
            }
            if (z2) {
                z = z2;
            } else {
                String newLibFile = getNewLibFile(str);
                File file = new File(newLibFile);
                if (file.exists()) {
                    if (file.length() > 0) {
                        boolean loadSoLibrary = loadSoLibrary(newLibFile, sb);
                        if (loadSoLibrary) {
                            sb.append("-Succ2-");
                            z = loadSoLibrary;
                        } else {
                            sb.append("-Error7-");
                            z = loadSoLibrary;
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                        z = z2;
                    }
                } else {
                    LoadApkTask loadApkTask = new LoadApkTask(str, newLibFile, sb, bdLoadLibraryHelperCallback);
                    loadApkTask.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    loadApkTask.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", BdErrorInfo.ERR_SO_LOAD, sb.toString(), new Object[0]);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean loadLibrary(String str, int i) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z2 = loadLibrary(str, sb);
            if (z2) {
                break;
            }
        }
        if (!z2) {
            String newLibFile = getNewLibFile(str);
            File file = new File(newLibFile);
            if (file.exists()) {
                if (file.length() > 0) {
                    boolean loadSoLibrary = loadSoLibrary(newLibFile, sb);
                    if (loadSoLibrary) {
                        sb.append("-Succ2-");
                        z = loadSoLibrary;
                    } else {
                        sb.append("-Error7-");
                        z = loadSoLibrary;
                    }
                    if (sb.length() <= 0) {
                        BdStatisticsManager.getInstance().error("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", BdErrorInfo.ERR_SO_LOAD, sb.toString(), new Object[0]);
                        return z;
                    }
                    return z;
                }
                sb.append("-Error6:soSize1-");
            }
        }
        z = z2;
        if (sb.length() <= 0) {
        }
    }

    private boolean loadLibrary(String str, StringBuilder sb) {
        boolean loadSoLibrary = loadSoLibrary(getLibFile(str), sb);
        if (!loadSoLibrary) {
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(th.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                return loadSoLibrary;
            }
        }
        return loadSoLibrary;
    }

    private boolean loadSoLibrary(String str, StringBuilder sb) {
        if (!new File(str).exists()) {
            sb.append("-Error1:");
            sb.append(str);
            sb.append("_FileNotFound-");
            return false;
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th) {
            sb.append("-Error2:");
            sb.append(th.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return false;
        }
    }

    private String getLibFile(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    private String getNewLibFile(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + c.g + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [268=5, 281=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadFromApk(String str, String str2, StringBuilder sb) {
        ZipInputStream zipInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ZipInputStream zipInputStream2 = null;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add("lib" + File.separator + "x86" + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add("lib" + File.separator + IDevices.ABI_MIPS + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add("lib" + File.separator + "armeabi" + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        File file = new File(str);
        if (file.exists()) {
            try {
                try {
                    zipInputStream = new ZipInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (arrayList.contains(nextEntry.getName())) {
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } catch (Exception e2) {
                                    BdCloseHelper.close((OutputStream) byteArrayOutputStream2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                                    throw th;
                                }
                            }
                            byteArrayOutputStream2.flush();
                            String newLibFile = getNewLibFile(str2);
                            createLibFile(newLibFile, byteArrayOutputStream2.toByteArray(), sb);
                            if (loadSoLibrary(newLibFile, sb)) {
                                sb.append("-Succ5-");
                                z = true;
                                BdCloseHelper.close((OutputStream) byteArrayOutputStream2);
                                break;
                            }
                            BdCloseHelper.close((OutputStream) byteArrayOutputStream2);
                        } catch (Exception e3) {
                            byteArrayOutputStream2 = null;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayOutputStream = null;
                        }
                    }
                }
                BdCloseHelper.close((InputStream) zipInputStream);
            } catch (IOException e4) {
                e = e4;
                zipInputStream2 = zipInputStream;
                sb.append("-Error5:");
                sb.append(e.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                BdCloseHelper.close((InputStream) zipInputStream2);
                return z;
            } catch (Throwable th5) {
                th = th5;
                zipInputStream2 = zipInputStream;
                BdCloseHelper.close((InputStream) zipInputStream2);
                throw th;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLibFile(String str, byte[] bArr, StringBuilder sb) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    fileOutputStream.write(bArr);
                    BdCloseHelper.close((OutputStream) fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    sb.append("-Error4:");
                    sb.append(e.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    BdCloseHelper.close((OutputStream) fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                BdCloseHelper.close((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            BdCloseHelper.close((OutputStream) fileOutputStream);
            throw th;
        }
    }

    /* loaded from: classes10.dex */
    private class LoadApkTask extends BdAsyncTask<Object, Object, Object> {
        BdLoadLibraryHelperCallback mCallback;
        String mLibName;
        boolean mLoadSuccess = false;
        StringBuilder mLogContent;
        String mNewFileName;

        public LoadApkTask(String str, String str2, StringBuilder sb, BdLoadLibraryHelperCallback bdLoadLibraryHelperCallback) {
            this.mLibName = str;
            this.mNewFileName = str2;
            this.mLogContent = sb;
            this.mCallback = bdLoadLibraryHelperCallback;
        }

        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        protected Object doInBackground(Object... objArr) {
            this.mLoadSuccess = BdLoadLibraryHelper.this.loadFromApk(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.mLibName, this.mLogContent);
            if (!this.mLoadSuccess) {
                BdLoadLibraryHelper.this.createLibFile(this.mNewFileName, "".getBytes(), this.mLogContent);
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (this.mLogContent.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + this.mLibName + PluginInstallerService.APK_LIB_SUFFIX, "", BdErrorInfo.ERR_SO_LOAD, this.mLogContent.toString(), new Object[0]);
            }
            if (this.mCallback != null) {
                this.mCallback.callback(this.mLoadSuccess);
            }
        }
    }
}
