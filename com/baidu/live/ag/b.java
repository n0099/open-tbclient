package com.baidu.live.ag;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b {
    public static String Sb() {
        return a.bxJ;
    }

    public static String Sc() {
        return a.bxL;
    }

    public static String iy(String str) {
        return !TextUtils.isEmpty(str) ? Sc() + "/" + str : "";
    }

    public static String iz(String str) {
        return !TextUtils.isEmpty(str) ? iy(str) + "/dest" : "";
    }

    public static String iA(String str) {
        return !TextUtils.isEmpty(str) ? iy(str) + "/video" : "";
    }

    public static String iB(String str) {
        return !TextUtils.isEmpty(str) ? iy(str) + "/frame" : "";
    }

    public static String Sd() {
        return a.bxM;
    }

    public static String iC(String str) {
        return !TextUtils.isEmpty(str) ? Sd() + "/" + str : "";
    }

    public static String iD(String str) {
        return !TextUtils.isEmpty(str) ? iC(str) + "/dest" : "";
    }

    public static String iE(String str) {
        return !TextUtils.isEmpty(str) ? iC(str) + "/video" : "";
    }

    public static String iF(String str) {
        return !TextUtils.isEmpty(str) ? iC(str) + "/frame" : "";
    }

    public static String Se() {
        return a.bxN;
    }

    public static String Sf() {
        return a.bxP;
    }

    public static String Sg() {
        return Se() + "/start";
    }

    public static String Sh() {
        return Sf() + "/start";
    }

    public static String Si() {
        return Sg() + "/dest";
    }

    public static String Sj() {
        return Sh() + "/dest";
    }

    public static String Sk() {
        return Sg() + "/video";
    }

    public static String iG(String str) {
        return a.bxO + "/" + str + "/dest";
    }

    public static String iH(String str) {
        return a.bxO + "/" + str;
    }

    public static String Sl() {
        return Sh() + "/video";
    }
}
