package com.baidu.android.imsdk.account;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes3.dex */
public interface ILoginListener extends IMListener {
    void onLoginResult(int i2, String str);

    void onLogoutResult(int i2, String str, int i3);
}
