package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public class BaseUrlManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String ONLINE_URL = "https://mbd.baidu.com";
    public static final String TEST_URL = "http://10.26.139.34:8092";
    public static final String UPLOAD_URL_PATH = "/fetchlog/getbostoken";

    public static String getBaseUploadUrl() {
        return DEBUG ? "http://10.26.139.34:8092/fetchlog/getbostoken" : "https://mbd.baidu.com/fetchlog/getbostoken";
    }
}
