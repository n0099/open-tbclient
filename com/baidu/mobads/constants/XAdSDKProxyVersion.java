package com.baidu.mobads.constants;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes2.dex */
public class XAdSDKProxyVersion {
    public static final String BAIDU_AD_SDK_VERSION = "";
    public static final Boolean DEBUG = Boolean.FALSE;
    public static final String RELEASE_TAG = "8.8448";

    public static int getMajorVersionNumber() {
        try {
            return Integer.valueOf(RELEASE_TAG.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)[0]).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static double getVersion() {
        try {
            return Double.parseDouble(RELEASE_TAG);
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
