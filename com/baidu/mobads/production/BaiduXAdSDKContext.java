package com.baidu.mobads.production;
/* loaded from: classes2.dex */
public class BaiduXAdSDKContext {
    public static Boolean isRemoteLoadSuccess = Boolean.FALSE;
    public static com.baidu.mobads.g.g mApkLoader;

    public static void exit() {
        mApkLoader = null;
        isRemoteLoadSuccess = Boolean.FALSE;
    }
}
