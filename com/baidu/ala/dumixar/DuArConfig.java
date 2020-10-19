package com.baidu.ala.dumixar;

import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.c;
import java.io.File;
@Deprecated
/* loaded from: classes12.dex */
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

    @Deprecated
    public void setDuArSourcePath(String str) {
        this.sourcePath = str;
        b.a(null, "17", Config.apiKey, "", new c(str));
    }

    public String getDuArSourcePath() {
        return this.sourcePath;
    }
}
