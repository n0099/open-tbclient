package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.List;
/* loaded from: classes9.dex */
public interface j {
    List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback);

    List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2);

    boolean checkFeatureAuth(int i2);

    boolean checkOfflineLicenseAuth(Context context, byte[] bArr);

    Bitmap createTipBitmap(Context context);

    void doAuth(Context context, IAuthCallback iAuthCallback);

    boolean enableFeature(int i2);

    boolean isShowAuthTip();

    void loadAuthInfo(Context context);

    void receiveAuthFailMessage(int i2);

    void release();

    void setAuthLicense(byte[] bArr, String str, String str2, String str3);
}
