package com.baidu.mobads.sdk.internal;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes2.dex */
public class XAdSDKProxyVersion {
    public static final String BAIDU_AD_SDK_VERSION = "";
    public static final Boolean DEBUG;
    public static final int MAJOR_VERSION_NUMBER = 0;
    public static final int MINOR_VERSION_NUMBER = 0;
    public static final Boolean MODIFIED;
    public static final String REAL_RELEASE_TAG = "";
    public static final String RELEASE_TAG = "9.041";
    public static final String SVN_REVISION_FINAL = "";
    public static final String SVN_TREE = "";
    public static final String TIME_STAMP = "";
    public static final String URL = "";

    static {
        Boolean bool = Boolean.FALSE;
        DEBUG = bool;
        MODIFIED = bool;
    }

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
