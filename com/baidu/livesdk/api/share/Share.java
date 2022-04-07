package com.baidu.livesdk.api.share;

import android.content.Context;
/* loaded from: classes2.dex */
public interface Share {
    public static final String BAIDUHI = "baiduhi";
    public static final String QQDENGLU = "qqdenglu";
    public static final String QQFRIEND = "qqfriend";
    public static final String QQWEIBO = "qqweibo";
    public static final String SINAWEIBO = "sinaweibo";
    public static final String WEIXIN_FRIEND = "weixin_friend";
    public static final String WEIXIN_TIMELINE = "weixin_timeline";

    /* loaded from: classes2.dex */
    public interface ShareResultListener {
        void onCancel(String str, String str2);

        void onComplete(String str, String str2);

        void onError(String str, String str2);

        void onItemClicked(String str, String str2);
    }

    void release();

    void share(Context context, String str, String str2, String str3, String str4, ShareResultListener shareResultListener, String str5);
}
