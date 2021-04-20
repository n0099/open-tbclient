package com.baidu.mobads.container.gray;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.jar.JarFile;
/* loaded from: classes2.dex */
public class RemoteVersionUtil {
    public static volatile RemoteVersionUtil instance;
    public Context mAppContext;
    public String __DIR_OF_DOWNLOAD_XAD_APK__ = "baidu_sdk_remote";
    public String XAD_APK_NAME_PREFIX = "__xadsdk__remote__final__";
    public String XAD_APK_NAME_DOWNLOADED = this.XAD_APK_NAME_PREFIX + "downloaded__.jar";
    public String XAD_APK_NAME_RUNNING = this.XAD_APK_NAME_PREFIX + "running__.jar";
    public String mApkSaveDir = null;

    public RemoteVersionUtil(Context context) {
        this.mAppContext = context;
        initDownloadedPath();
    }

    private String getDownloadedApkPath() {
        return this.mApkSaveDir + this.XAD_APK_NAME_DOWNLOADED;
    }

    public static RemoteVersionUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (RemoteVersionUtil.class) {
                if (instance == null) {
                    instance = new RemoteVersionUtil(context);
                }
            }
        }
        return instance;
    }

    private double getRemoteVersion(String str) {
        try {
            File file = new File(str);
            if (isFileExistsAndCanRead(file)) {
                JarFile jarFile = new JarFile(file);
                double parseDouble = Double.parseDouble(jarFile.getManifest().getMainAttributes().getValue("Implementation-Version"));
                jarFile.close();
                if (parseDouble > 0.0d) {
                    return parseDouble;
                }
            }
        } catch (Throwable unused) {
        }
        return 0.0d;
    }

    private String getRunningApkPath() {
        return this.mApkSaveDir + this.XAD_APK_NAME_RUNNING;
    }

    private void initDownloadedPath() {
        try {
            if (TextUtils.isEmpty(this.mApkSaveDir)) {
                File dir = this.mAppContext.getDir(this.__DIR_OF_DOWNLOAD_XAD_APK__, 0);
                this.mApkSaveDir = dir.getAbsolutePath() + "/";
            }
        } catch (Throwable unused) {
        }
    }

    private boolean isFileExistsAndCanRead(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public double getDownloadedVersion() {
        return getRemoteVersion(getDownloadedApkPath());
    }

    public double getRunningVersion() {
        return getRemoteVersion(getRunningApkPath());
    }
}
