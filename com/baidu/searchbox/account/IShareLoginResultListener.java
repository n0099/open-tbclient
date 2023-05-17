package com.baidu.searchbox.account;
/* loaded from: classes3.dex */
public interface IShareLoginResultListener extends ILoginResultListener {
    public static final int AUTHFAILED = -1001;
    public static final int AUTHSUCCESS = 1000;

    void onAuthResult(int i);
}
