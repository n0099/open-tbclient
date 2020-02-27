package com.baidu.searchbox.picture.component.listener;
/* loaded from: classes13.dex */
public interface OnBitmapLoadActionListener {
    public static final String FAILURE = "failure";
    public static final String RELEASE = "release";
    public static final String SUCCESS = "success";

    void onLoadComplete(String str, String str2);
}
