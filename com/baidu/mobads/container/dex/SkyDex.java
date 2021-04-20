package com.baidu.mobads.container.dex;

import android.content.Context;
/* loaded from: classes2.dex */
public class SkyDex {
    public static final String METHOD_NAME_SETAPPSID = "setAppSid";
    public static final String PATH_FeedAd = "com.baidu.mobad.feeds.BaiduNative";
    public static final String PATH_FeedBuilder = "com.baidu.mobad.feeds.RequestParameters$Builder";
    public static final String PATH_FeedListener = "com.baidu.mobad.feeds.BaiduNative$BaiduNativeNetworkListener";
    public static final String PATH_FeedRequestParams = "com.baidu.mobad.feeds.RequestParameters";
    public static final String getMaterialType = "getAdMaterialType";
    public Context mContext;

    public SkyDex(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void setId(Context context, String str, String str2) throws Exception {
        Class.forName(str).getMethod(METHOD_NAME_SETAPPSID, Context.class, String.class).invoke(null, context, str2);
    }
}
