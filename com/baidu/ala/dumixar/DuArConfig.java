package com.baidu.ala.dumixar;

import java.io.File;
/* loaded from: classes3.dex */
public class DuArConfig {
    private static DuArConfig sInstance;
    public String apiKey;
    public String appId;
    public File arFilterFolder;
    public String secretKey;
    private String sourcePath;

    private DuArConfig(String str, String str2, String str3, File file) {
        this.appId = str;
        this.apiKey = str2;
        this.secretKey = str3;
        this.arFilterFolder = file;
    }

    public static DuArConfig instance() {
        if (sInstance == null) {
            synchronized (DuArConfig.class) {
                if (sInstance == null) {
                    sInstance = new DuArConfig("17", Config.apiKey, "", Config.folder);
                }
            }
        }
        return sInstance;
    }

    public void setDuArSourcePath(String str) {
        this.sourcePath = str;
    }

    public String getDuArSourcePath() {
        return this.sourcePath;
    }
}
