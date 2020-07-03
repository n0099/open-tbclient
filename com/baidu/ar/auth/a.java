package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static com.baidu.ar.f.f<k> iY = new com.baidu.ar.f.f<>("com.baidu.ar.auth.ARAuthFacade");

    public static List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        k fm = iY.fm();
        return fm != null ? fm.checkAuth(context, bArr, iDuMixAuthCallback) : new ArrayList();
    }

    public static List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        k fm = iY.fm();
        return fm != null ? fm.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
    }

    public static boolean checkFeatureAuth(int i) {
        k fm = iY.fm();
        if (fm != null) {
            return fm.checkFeatureAuth(i);
        }
        return true;
    }

    public static Bitmap createTipBitmap(Context context) {
        k fm = iY.fm();
        if (fm != null) {
            return fm.createTipBitmap(context);
        }
        return null;
    }

    public static void doAuth(Context context, j jVar) {
        k fm = iY.fm();
        if (fm != null) {
            fm.doAuth(context, jVar);
        }
    }

    public static boolean enableFeature(int i) {
        k fm = iY.fm();
        if (fm != null) {
            return fm.enableFeature(i);
        }
        return true;
    }

    public static boolean isShowAuthTip() {
        k fm = iY.fm();
        if (fm != null) {
            return fm.isShowAuthTip();
        }
        return true;
    }

    public static void loadAuthInfo(Context context) {
        k fm = iY.fm();
        if (fm != null) {
            fm.loadAuthInfo(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void receiveAuthFailMessage(int i) {
        k fm = iY.fm();
        if (fm != null) {
            fm.receiveAuthFailMessage(i);
        }
    }

    public static void release() {
        k fn = iY.fn();
        if (fn != null) {
            fn.release();
        }
        iY.release();
    }

    public static void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        k fm = iY.fm();
        if (fm != null) {
            fm.setAuthLicense(bArr, str, str2, str3);
        }
    }
}
