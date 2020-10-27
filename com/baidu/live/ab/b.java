package com.baidu.live.ab;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b {
    public static String PQ() {
        return a.bsR;
    }

    public static String PR() {
        return a.bsT;
    }

    public static String hT(String str) {
        return !TextUtils.isEmpty(str) ? PR() + "/" + str : "";
    }

    public static String hU(String str) {
        return !TextUtils.isEmpty(str) ? hT(str) + "/dest" : "";
    }

    public static String hV(String str) {
        return !TextUtils.isEmpty(str) ? hT(str) + "/video" : "";
    }

    public static String hW(String str) {
        return !TextUtils.isEmpty(str) ? hT(str) + "/frame" : "";
    }

    public static String PS() {
        return a.bsU;
    }

    public static String hX(String str) {
        return !TextUtils.isEmpty(str) ? PS() + "/" + str : "";
    }

    public static String hY(String str) {
        return !TextUtils.isEmpty(str) ? hX(str) + "/dest" : "";
    }

    public static String hZ(String str) {
        return !TextUtils.isEmpty(str) ? hX(str) + "/video" : "";
    }

    public static String ia(String str) {
        return !TextUtils.isEmpty(str) ? hX(str) + "/frame" : "";
    }

    public static String PT() {
        return a.bsV;
    }

    public static String PU() {
        return PT() + "/start";
    }

    public static String PV() {
        return PU() + "/dest";
    }

    public static String PW() {
        return PU() + "/video";
    }
}
