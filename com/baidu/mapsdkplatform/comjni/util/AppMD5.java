package com.baidu.mapsdkplatform.comjni.util;

import com.baidu.platform.comapi.util.h;
/* loaded from: classes15.dex */
public class AppMD5 {
    public static String encodeUrlParamsValue(String str) {
        return JNIMD5.encodeUrlParamsValue(str);
    }

    public static String getSignMD5String(String str) {
        return h.a(str);
    }

    public static String getUrlNeedInfo() {
        return JNIMD5.getUrlNeedInfo();
    }
}
