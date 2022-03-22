package com.baidu.sapi2.callback;
/* loaded from: classes4.dex */
public interface NetCallback {
    void onFailure(Throwable th, int i, String str);

    void onSuccess(int i, String str);
}
