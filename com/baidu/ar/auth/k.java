package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.List;
/* loaded from: classes3.dex */
public interface k {
    List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2);

    boolean checkFeatureAuth(int i);

    Bitmap createTipBitmap(Context context);

    void doAuth(Context context, j jVar);

    boolean enableFeature(int i);

    boolean isShowAuthTip();

    void loadAuthInfo(Context context);

    void receiveAuthFailMessage(int i);

    void release();
}
