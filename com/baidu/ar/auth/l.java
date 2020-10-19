package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.List;
/* loaded from: classes14.dex */
public interface l {
    List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback);

    List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2);

    boolean checkFeatureAuth(int i);

    boolean checkOfflineLicenseAuth(Context context, byte[] bArr);

    Bitmap createTipBitmap(Context context);

    void doAuth(Context context, k kVar);

    boolean enableFeature(int i);

    boolean isShowAuthTip();

    void loadAuthInfo(Context context);

    void receiveAuthFailMessage(int i);

    void release();

    void setAuthLicense(byte[] bArr, String str, String str2, String str3);
}
