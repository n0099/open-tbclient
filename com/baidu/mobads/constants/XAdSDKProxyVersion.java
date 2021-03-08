package com.baidu.mobads.constants;
/* loaded from: classes4.dex */
public class XAdSDKProxyVersion {
    public static final String BAIDU_AD_SDK_VERSION = "";
    public static final int MAJOR_VERSION_NUMBER = 0;
    public static final int MINOR_VERSION_NUMBER = 0;
    public static final String REAL_RELEASE_TAG = "";
    public static final String RELEASE_TAG = "8.8451";
    public static final String SVN_REVISION_FINAL = "";
    public static final String SVN_TREE = "";
    public static final String TIME_STAMP = "";
    public static final String URL = "";
    public static final Boolean DEBUG = false;
    public static final Boolean MODIFIED = false;

    public static double getVersion() {
        try {
            return Double.parseDouble(RELEASE_TAG);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static int getMajorVersionNumber() {
        try {
            return Integer.valueOf(RELEASE_TAG.split("\\.")[0]).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
