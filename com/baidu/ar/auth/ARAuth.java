package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ARAuth {
    public static com.baidu.ar.h.h<j> iW = new com.baidu.ar.h.h<>("com.baidu.ar.auth.ARAuthFacade");

    public static List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        j gA = iW.gA();
        return gA != null ? gA.checkAuth(context, bArr, iDuMixAuthCallback) : new ArrayList();
    }

    public static List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        j gA = iW.gA();
        return gA != null ? gA.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
    }

    public static boolean checkFeatureAuth(int i) {
        j gA = iW.gA();
        if (gA != null) {
            return gA.checkFeatureAuth(i);
        }
        return true;
    }

    public static boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        j gA = iW.gA();
        if (gA != null) {
            return gA.checkOfflineLicenseAuth(context, bArr);
        }
        return true;
    }

    public static Bitmap createTipBitmap(Context context) {
        j gA = iW.gA();
        if (gA != null) {
            return gA.createTipBitmap(context);
        }
        return null;
    }

    public static void doAuth(Context context, IAuthCallback iAuthCallback) {
        AuthJni.init();
        j gA = iW.gA();
        if (gA != null) {
            gA.doAuth(context, iAuthCallback);
        }
    }

    public static boolean enableFeature(int i) {
        j gA = iW.gA();
        if (gA != null) {
            return gA.enableFeature(i);
        }
        return true;
    }

    public static boolean isShowAuthTip() {
        j gA = iW.gA();
        if (gA != null) {
            return gA.isShowAuthTip();
        }
        return true;
    }

    public static void loadAuthInfo(Context context) {
        j gA = iW.gA();
        if (gA != null) {
            gA.loadAuthInfo(context);
        }
    }

    public static void receiveAuthFailMessage(int i) {
        j gA = iW.gA();
        if (gA != null) {
            gA.receiveAuthFailMessage(i);
        }
    }

    public static void release() {
        j gB = iW.gB();
        if (gB != null) {
            gB.release();
        }
        iW.release();
        AuthJni.release();
    }

    public static void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        j gA = iW.gA();
        if (gA != null) {
            gA.setAuthLicense(bArr, str, str2, str3);
        }
    }
}
