package com.baidu.android.imsdk.account;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes9.dex */
public interface ILoginListener extends IMListener {
    void onLoginResult(int i, String str);

    void onLogoutResult(int i, String str, int i2);
}
