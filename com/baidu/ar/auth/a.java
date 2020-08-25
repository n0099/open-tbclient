package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static com.baidu.ar.g.h<l> iH = new com.baidu.ar.g.h<>("com.baidu.ar.auth.ARAuthFacade");

    public static List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        l gA = iH.gA();
        return gA != null ? gA.checkAuth(context, bArr, iDuMixAuthCallback) : new ArrayList();
    }

    public static List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        l gA = iH.gA();
        return gA != null ? gA.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
    }

    public static boolean checkFeatureAuth(int i) {
        l gA = iH.gA();
        if (gA != null) {
            return gA.checkFeatureAuth(i);
        }
        return true;
    }

    public static boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        l gA = iH.gA();
        if (gA != null) {
            return gA.checkOfflineLicenseAuth(context, bArr);
        }
        return true;
    }

    public static Bitmap createTipBitmap(Context context) {
        l gA = iH.gA();
        if (gA != null) {
            return gA.createTipBitmap(context);
        }
        return null;
    }

    public static void doAuth(Context context, k kVar) {
        AuthJni.init();
        l gA = iH.gA();
        if (gA != null) {
            gA.doAuth(context, kVar);
        }
    }

    public static boolean enableFeature(int i) {
        l gA = iH.gA();
        if (gA != null) {
            return gA.enableFeature(i);
        }
        return true;
    }

    public static boolean isShowAuthTip() {
        l gA = iH.gA();
        if (gA != null) {
            return gA.isShowAuthTip();
        }
        return true;
    }

    public static void loadAuthInfo(Context context) {
        l gA = iH.gA();
        if (gA != null) {
            gA.loadAuthInfo(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void receiveAuthFailMessage(int i) {
        l gA = iH.gA();
        if (gA != null) {
            gA.receiveAuthFailMessage(i);
        }
    }

    public static void release() {
        l gB = iH.gB();
        if (gB != null) {
            gB.release();
        }
        iH.release();
        AuthJni.release();
    }

    public static void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        l gA = iH.gA();
        if (gA != null) {
            gA.setAuthLicense(bArr, str, str2, str3);
        }
    }
}
