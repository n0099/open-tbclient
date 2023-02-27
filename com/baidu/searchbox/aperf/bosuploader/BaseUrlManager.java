package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public class BaseUrlManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String ONLINE_URL = "https://mbd.baidu.com";
    public static final String TEST_URL = "http://10.104.73.35:8098";
    public static final String UPLOAD_URL_PATH = "/fetchlog/getbostoken";

    public static String getBaseUploadUrl() {
        if (DEBUG) {
            return "http://10.104.73.35:8098/fetchlog/getbostoken";
        }
        return "https://mbd.baidu.com/fetchlog/getbostoken";
    }
}
