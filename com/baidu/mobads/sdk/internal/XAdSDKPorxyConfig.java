package com.baidu.mobads.sdk.internal;
/* loaded from: classes2.dex */
public class XAdSDKPorxyConfig {
    public static final boolean DEBUG_MODE;
    public static final String DUMMY_ADSERV_VERSION = "4.1.30";
    public static final int LOG_LEVEL;
    public static String REMOTE_VERSION = null;
    public static final String REMOTE_VERSION_DEFAULT = "0.0";
    public static final boolean UNITTEST_MODE = false;

    static {
        boolean booleanValue = XAdSDKProxyVersion.DEBUG.booleanValue();
        DEBUG_MODE = booleanValue;
        LOG_LEVEL = booleanValue ? 2 : 4;
        REMOTE_VERSION = REMOTE_VERSION_DEFAULT;
    }
}
