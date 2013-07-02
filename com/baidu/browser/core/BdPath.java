package com.baidu.browser.core;

import android.content.Context;
import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public class BdPath {
    public static final String DIR_BBM = "/bbm";
    public static final String DIR_DATA = "/data";
    public static final String DIR_IMAGES = "/images";
    public static final String DIR_IMAGES_HOME = "/images/home";
    public static final String DIR_IMAGES_HOME_RSS = "/images/home_rss";
    public static final String DIR_IMAGES_HOME_USER = "/images/home_user";
    public static final String DIR_IMAGES_NAVI = "/images/navi";
    public static final String DIR_IMAGES_WALLPAPER = "/images/wallpaper";
    public static final String DIR_IMAGES_WEBAPP = "/images/webapp";
    public static final String DIR_IMAGES_WEBAPP_TOLAUNCHER = "/images/webapp_launcher";
    public static final String DIR_MISC = "/misc";
    public static final String DIR_PV = "/pv";
    public static final String DIR_SDCARD = "/baidu/flyflow";
    public static final String DIR_SPLASH = "/splash";
    public static final String DIR_VERSION = "/version";
    public static final String FILE_DEBUG = "debug.dat";
    public static final String FILE_HOME = "home.dat";
    public static final String FILE_HOMECONFIG = "flyflow_homeCache";
    public static final String FILE_HOME_RECOMMEND = "home_recommed.dat";
    public static final String FILE_HOME_RSS = "home_rss.dat";
    public static final String FILE_HOTSITE = "hotsite.dat";
    public static final String FILE_LOCAL_NAVI = "local_navi.dat";
    public static final String FILE_NAVI = "navi.dat";
    public static final String FILE_NOTIFICATION = "flyflow_notification.dat";
    public static final String FILE_PREF_SETTINGS = "flyflow_settings";
    public static final String FILE_SERVER_INTERFACE = "urls.dat";
    public static final String FILE_SHAKE = "shake.dat";
    public static final String FILE_TIMESTAMP = "flyflow_timestamp";
    public static final String FILE_USER_INFO = "user_info.dat";
    public static final String FILE_WEATHER = "weather.dat";
    public static final String FILE_WEBAPP = "webapp.dat";
    public static final String URI_PLUGIN_HOTSEARCH = "flyflow://hotsearch";
    public static final String URI_PLUGIN_NAVIGATE = "flyflow://navigate";
    private static BdPath sInstance;
    private String mDirCache;
    private String mDirFiles;
    private String mDirSd;

    private BdPath(Context context) {
        if (context.getFilesDir() != null) {
            this.mDirFiles = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            this.mDirCache = context.getCacheDir().getAbsolutePath();
        }
        this.mDirSd = Environment.getExternalStorageDirectory().getAbsolutePath();
        new File(String.valueOf(this.mDirFiles) + DIR_IMAGES).mkdir();
        new File(String.valueOf(this.mDirFiles) + DIR_DATA).mkdir();
        new File(String.valueOf(this.mDirFiles) + DIR_MISC).mkdir();
        new File(String.valueOf(this.mDirFiles) + DIR_IMAGES_NAVI).mkdir();
        new File(String.valueOf(this.mDirFiles) + DIR_IMAGES_HOME).mkdir();
        new File(String.valueOf(this.mDirFiles) + DIR_IMAGES_WEBAPP).mkdir();
        new File(String.valueOf(this.mDirFiles) + DIR_IMAGES_HOME_RSS).mkdir();
        new File(String.valueOf(this.mDirSd) + DIR_SDCARD).mkdirs();
        new File(String.valueOf(this.mDirFiles) + DIR_IMAGES_WEBAPP_TOLAUNCHER).mkdirs();
        new File(String.valueOf(this.mDirFiles) + DIR_SPLASH).mkdirs();
        new File(String.valueOf(this.mDirFiles) + DIR_BBM).mkdirs();
        new File(String.valueOf(this.mDirFiles) + DIR_VERSION).mkdirs();
        new File(String.valueOf(this.mDirFiles) + DIR_PV).mkdirs();
    }

    public static BdPath getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new BdPath(context);
        }
        return sInstance;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static void createDir(String str) {
        new File(str).mkdirs();
    }

    public String getDirFiles() {
        return this.mDirFiles;
    }

    public String getDirCache() {
        return this.mDirCache;
    }

    public String getDirSd() {
        return this.mDirSd;
    }

    public String getDirImages() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES;
    }

    public String getDirImagesWebApp() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES_WEBAPP;
    }

    public String getDirImagesNavi() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES_NAVI;
    }

    public String getDirImagesHome() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES_HOME;
    }

    public String getDirImagesWallpaper() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES_WALLPAPER;
    }

    public String getDirImagesHomeRss() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES_HOME_RSS;
    }

    public String getDirImagesHomeUser() {
        return String.valueOf(getDirFiles()) + DIR_IMAGES_HOME_USER;
    }

    public String getDirVersion() {
        return String.valueOf(getDirFiles()) + DIR_VERSION;
    }

    public String getDirPv() {
        return String.valueOf(getDirFiles()) + DIR_PV;
    }

    public String getDirData() {
        return String.valueOf(getDirFiles()) + DIR_DATA;
    }

    public String getDirMisc() {
        return String.valueOf(getDirFiles()) + DIR_MISC;
    }

    public String getDirSplash() {
        return String.valueOf(getDirFiles()) + DIR_SPLASH;
    }

    public String getDirBBM() {
        return String.valueOf(getDirFiles()) + DIR_BBM;
    }

    public String getFileHomeConfig() {
        return String.valueOf(getDirFiles()) + "/" + FILE_HOMECONFIG;
    }

    public String getFileHome() {
        return String.valueOf(getDirData()) + "/" + FILE_HOME;
    }

    public String getFileHotSite() {
        return String.valueOf(getDirData()) + "/" + FILE_HOTSITE;
    }

    public String getFileNavi() {
        return String.valueOf(getDirData()) + "/" + FILE_NAVI;
    }

    public String getFileWebApp() {
        return String.valueOf(getDirData()) + "/" + FILE_WEBAPP;
    }

    public String getDirSdBd() {
        return String.valueOf(getDirSd()) + DIR_SDCARD;
    }

    public String getFileDebug() {
        return String.valueOf(getDirSdBd()) + "/" + FILE_DEBUG;
    }

    public String getFileWeather() {
        return String.valueOf(getDirData()) + "/" + FILE_WEATHER;
    }

    public String getFileShake() {
        return String.valueOf(getDirData()) + "/" + FILE_SHAKE;
    }

    public String getFileHomeRss() {
        return String.valueOf(getDirData()) + "/" + FILE_HOME_RSS;
    }

    public String getNotificationCache() {
        return String.valueOf(getDirData()) + "/" + FILE_NOTIFICATION;
    }

    public String getFileServerInterface() {
        return String.valueOf(getDirVersion()) + "/" + FILE_SERVER_INTERFACE;
    }

    public String getFileUserInfo() {
        return String.valueOf(getDirData()) + "/" + FILE_USER_INFO;
    }

    public String getFileLocalNavi() {
        return String.valueOf(getDirData()) + "/" + FILE_LOCAL_NAVI;
    }

    public String getFileHomeRecommend() {
        return String.valueOf(getDirData()) + "/" + FILE_HOME_RECOMMEND;
    }
}
