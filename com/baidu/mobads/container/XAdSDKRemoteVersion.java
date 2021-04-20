package com.baidu.mobads.container;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes2.dex */
public class XAdSDKRemoteVersion {
    public static final String BAIDU_AD_SDK_VERSION = "";
    public static final Boolean DEBUG = Boolean.FALSE;
    public static final String RELEASE_TAG = "9.041";

    public static int getMajorVersionNumber() {
        try {
            return Integer.valueOf("9.041".split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)[0]).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static double getVersion() {
        try {
            return Double.parseDouble("9.041");
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
