package com.baidu.live.utils;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class s {
    public static String PT() {
        return r.btQ;
    }

    public static String hG(String str) {
        return !TextUtils.isEmpty(str) ? PT() + "/" + str : "";
    }

    public static String hH(String str) {
        return !TextUtils.isEmpty(str) ? hG(str) + "/dest" : "";
    }

    public static String hI(String str) {
        return !TextUtils.isEmpty(str) ? hG(str) + "/video" : "";
    }

    public static String hJ(String str) {
        return !TextUtils.isEmpty(str) ? hG(str) + "/frame" : "";
    }

    public static String PU() {
        return r.btR;
    }

    public static String hK(String str) {
        return !TextUtils.isEmpty(str) ? PU() + "/" + str : "";
    }

    public static String hL(String str) {
        return !TextUtils.isEmpty(str) ? hK(str) + "/dest" : "";
    }

    public static String hM(String str) {
        return !TextUtils.isEmpty(str) ? hK(str) + "/video" : "";
    }

    public static String hN(String str) {
        return !TextUtils.isEmpty(str) ? hK(str) + "/frame" : "";
    }

    public static String PV() {
        return r.btS;
    }

    public static String PW() {
        return PV() + "/start";
    }

    public static String PX() {
        return PW() + "/dest";
    }

    public static String PY() {
        return PW() + "/video";
    }
}
