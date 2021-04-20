package com.baidu.fsg.base.restnet;
/* loaded from: classes2.dex */
public class RestRequestCallbacker {
    public static IRestRequestCallback mCallback;

    /* loaded from: classes2.dex */
    public interface IRestRequestCallback {
        boolean isSpecialUrl(String str);

        void onSuccess(String str, String str2);
    }

    public static IRestRequestCallback getRequestCallback() {
        return mCallback;
    }

    public static void setRequestCallback(IRestRequestCallback iRestRequestCallback) {
        mCallback = iRestRequestCallback;
    }
}
