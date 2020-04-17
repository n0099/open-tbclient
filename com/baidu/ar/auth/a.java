package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static com.baidu.ar.f.f<k> iJ = new com.baidu.ar.f.f<>("com.baidu.ar.auth.ARAuthFacade");

    public static List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        k eW = iJ.eW();
        return eW != null ? eW.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
    }

    public static boolean checkFeatureAuth(int i) {
        k eW = iJ.eW();
        if (eW != null) {
            return eW.checkFeatureAuth(i);
        }
        return true;
    }

    public static Bitmap createTipBitmap(Context context) {
        k eW = iJ.eW();
        if (eW != null) {
            return eW.createTipBitmap(context);
        }
        return null;
    }

    public static void doAuth(Context context, j jVar) {
        k eW = iJ.eW();
        if (eW != null) {
            eW.doAuth(context, jVar);
        }
    }

    public static boolean enableFeature(int i) {
        k eW = iJ.eW();
        if (eW != null) {
            return eW.enableFeature(i);
        }
        return true;
    }

    public static boolean isShowAuthTip() {
        k eW = iJ.eW();
        if (eW != null) {
            return eW.isShowAuthTip();
        }
        return true;
    }

    public static void loadAuthInfo(Context context) {
        k eW = iJ.eW();
        if (eW != null) {
            eW.loadAuthInfo(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void receiveAuthFailMessage(int i) {
        k eW = iJ.eW();
        if (eW != null) {
            eW.receiveAuthFailMessage(i);
        }
    }

    public static void release() {
        k eX = iJ.eX();
        if (eX != null) {
            eX.release();
        }
        iJ.release();
    }
}
