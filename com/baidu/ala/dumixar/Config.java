package com.baidu.ala.dumixar;

import com.baidu.minivideo.arface.bean.Sticker;
import java.io.File;
/* loaded from: classes2.dex */
public class Config {
    public static final String apiKey = "45961827c395b92a2b7b86f531bdc4bf";
    public static final String appId = "17";
    public static final File folder = new File("/alalive/");
    private static Config sInstance = null;
    public static final String secretKey = "";
    private Sticker mDuSticker;

    public static Config getInstance() {
        if (sInstance == null) {
            sInstance = syncInit();
        }
        return sInstance;
    }

    private static synchronized Config syncInit() {
        Config config;
        synchronized (Config.class) {
            if (sInstance == null) {
                sInstance = new Config();
            }
            config = sInstance;
        }
        return config;
    }

    private Config() {
    }

    public void setDuSticker(Sticker sticker) {
        this.mDuSticker = sticker;
    }

    public Sticker getDuSticker() {
        return this.mDuSticker;
    }

    public static String getDuFilterItemPath(String str) {
        return "file:///android_asset/arfilters/" + str;
    }
}
