package com.baidu.searchbox.live.interfaces.yy;
/* loaded from: classes4.dex */
public interface YYEnvResultCallback {
    public static final int CODE_ENV_NOT_EXIST = -1;

    void onFail(int i, String str);

    void onSuccess();
}
