package com.baidu.mobads.production;
/* loaded from: classes14.dex */
public class BaiduXAdSDKContext {
    protected static Boolean isRemoteLoadSuccess = false;
    public static com.baidu.mobads.g.g mApkLoader;

    public static void exit() {
        mApkLoader = null;
        isRemoteLoadSuccess = false;
    }
}
