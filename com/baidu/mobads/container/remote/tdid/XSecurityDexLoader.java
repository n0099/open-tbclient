package com.baidu.mobads.container.remote.tdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.NetUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XSecurityDexLoader implements Observer {
    public static final String SECURITY_SETTING_URL = "https://mobads.baidu.com/ads/sec.php";
    public static final String __DIR_OF_DOWNLOAD_XAD_APK__ = "baidu_ad_sdk";
    public static volatile XSecurityDexLoader instance;
    public File file;
    public Context mContext;
    public String mCurAppSid;
    public String mSecurityDexUrl;
    public String mSign;
    public AtomicBoolean mSecurityDownloading = new AtomicBoolean(false);
    public String mAppsid = "";
    public String fileName = "security_sdk_dex.jar";
    public DexClassLoader mClassLoader = null;
    public String outputFolder = null;
    public String optimizedDirectory = null;
    public String mZid = "";
    public String mTdid = "";

    /* loaded from: classes2.dex */
    public static class MyTask extends BaseTask {
        public XSecurityDexLoader mLoader;

        public MyTask(XSecurityDexLoader xSecurityDexLoader) {
            this.mLoader = xSecurityDexLoader;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            this.mLoader.loadSetting();
            return null;
        }
    }

    private String calcApkFileMD5Sum(File file) {
        byte[] digest;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (new DigestInputStream(fileInputStream2, messageDigest).read(new byte[4096]) != -1) {
                }
                String str = "";
                for (int i2 = 0; i2 < messageDigest.digest().length; i2++) {
                    str = str + Integer.toString((digest[i2] & 255) + 256, 16).substring(1);
                }
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (Exception unused3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean checkVrJarMd5() {
        File file = this.file;
        if (file == null || !file.exists()) {
            return false;
        }
        return this.mSign.equals(calcApkFileMD5Sum(this.file));
    }

    private void deleteFile() {
        File file = this.file;
        if (file == null || !file.exists()) {
            return;
        }
        this.file.delete();
    }

    private DexClassLoader getClassLoader(Context context) {
        if (this.mClassLoader == null) {
            initFile(context);
            loadVrDex();
        }
        return this.mClassLoader;
    }

    public static XSecurityDexLoader getInstance() {
        if (instance == null) {
            synchronized (XSecurityDexLoader.class) {
                if (instance == null) {
                    instance = new XSecurityDexLoader();
                }
            }
        }
        return instance;
    }

    private void getOutputFolderPath(Context context) {
        if (TextUtils.isEmpty(this.outputFolder)) {
            File dir = this.mContext.getDir(__DIR_OF_DOWNLOAD_XAD_APK__, 0);
            this.outputFolder = dir.getAbsolutePath() + "/";
        }
    }

    private String getTdid(Context context) {
        if (context == null) {
            return this.mTdid;
        }
        if (!TextUtils.isEmpty(this.mTdid)) {
            return this.mTdid;
        }
        DexClassLoader classLoader = getClassLoader(context);
        if (classLoader != null) {
            try {
                Method declaredMethod = classLoader.loadClass("com.sofire.zlu.FH").getDeclaredMethod("gd", Context.class);
                declaredMethod.setAccessible(true);
                this.mTdid = (String) declaredMethod.invoke(null, context.getApplicationContext());
            } catch (Exception unused) {
                this.mTdid = "";
            }
        }
        return this.mTdid;
    }

    private String getZid(Context context) {
        if (context == null) {
            return this.mZid;
        }
        if (!TextUtils.isEmpty(this.mZid)) {
            return this.mZid;
        }
        DexClassLoader classLoader = getClassLoader(context);
        if (classLoader != null) {
            try {
                Method declaredMethod = classLoader.loadClass("com.sofire.zlu.FH").getDeclaredMethod("gzfi", Context.class, String.class, Integer.TYPE, String.class);
                declaredMethod.setAccessible(true);
                this.mZid = (String) declaredMethod.invoke(null, context.getApplicationContext(), null, 0, null);
            } catch (Exception unused) {
                this.mZid = "";
            }
        }
        return this.mZid;
    }

    private void initFile(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.optimizedDirectory = applicationContext.getFilesDir().getAbsolutePath();
        getOutputFolderPath(context);
        this.file = new File(this.outputFolder + this.fileName);
    }

    private boolean isAppsidEnabled() {
        if (TextUtils.isEmpty(this.mCurAppSid) || TextUtils.isEmpty(this.mAppsid)) {
            return false;
        }
        return this.mAppsid.equals("all") || this.mAppsid.contains(this.mCurAppSid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSetting() {
        try {
            loadSettingJSON(NetUtils.doGet(AdURIUtils.replaceURLWithSupportProtocol(SECURITY_SETTING_URL)));
        } catch (Exception unused) {
        }
        if (CommonUtils.isWifi(this.mContext.getApplicationContext()) && isAppsidEnabled() && !checkVrJarMd5()) {
            deleteFile();
            startLoad(this.mSecurityDexUrl, this.fileName);
        }
    }

    private void loadSettingJSON(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mAppsid = jSONObject.optString("appsid");
            String optString = jSONObject.optString("url");
            this.mSecurityDexUrl = optString;
            this.mSecurityDexUrl = AdURIUtils.replaceURLWithSupportProtocol(optString);
            this.mSign = jSONObject.optString("sign");
        } catch (Exception unused) {
        }
    }

    private void loadVrDex() {
        try {
            synchronized (XSecurityDexLoader.class) {
                this.mClassLoader = new DexClassLoader(this.file.getAbsolutePath(), this.optimizedDirectory, null, this.mContext.getClass().getClassLoader());
            }
        } catch (Exception unused) {
            this.mClassLoader = null;
        }
    }

    private void startLoad(String str, String str2) {
        try {
            IDownloader createSimpleFileDownloader = OAdRemoteDownloadManager.getInstance(this.mContext).createSimpleFileDownloader(new URL(str), this.outputFolder, str2, true);
            createSimpleFileDownloader.addObserver(this);
            createSimpleFileDownloader.start();
        } catch (Exception unused) {
        }
    }

    public JSONObject getSecurityInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("zid", getZid(context));
            jSONObject.put("tdid", getTdid(context));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void startTdidUpgrade(Context context) {
        if (this.mSecurityDownloading.get()) {
            return;
        }
        this.mSecurityDownloading.set(true);
        this.mContext = context;
        this.mCurAppSid = DeviceUtils.getInstance().getAppId(this.mContext.getApplicationContext());
        getOutputFolderPath(this.mContext.getApplicationContext());
        this.file = new File(this.outputFolder + this.fileName);
        this.optimizedDirectory = this.mContext.getFilesDir().getAbsolutePath();
        TaskScheduler.getInstance().submitWithDelay(new MyTask(this), 1500L, TimeUnit.MILLISECONDS);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IDownloader iDownloader = (IDownloader) observable;
        if (iDownloader == null || TextUtils.isEmpty(this.mSecurityDexUrl) || !this.mSecurityDexUrl.equals(iDownloader.getURL())) {
            return;
        }
        if (iDownloader.getState() == IDownloader.DownloadStatus.COMPLETED) {
            if (checkVrJarMd5()) {
                loadVrDex();
            } else {
                deleteFile();
            }
        } else if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR) {
            deleteFile();
        }
    }
}
