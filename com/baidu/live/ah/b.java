package com.baidu.live.ah;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class b {
    public static String Pk() {
        return a.bxI;
    }

    public static String Pl() {
        return a.bxK;
    }

    public static String ha(String str) {
        return !TextUtils.isEmpty(str) ? Pl() + "/" + str : "";
    }

    public static String hb(String str) {
        return !TextUtils.isEmpty(str) ? ha(str) + "/dest" : "";
    }

    public static String hc(String str) {
        return !TextUtils.isEmpty(str) ? ha(str) + "/video" : "";
    }

    public static String hd(String str) {
        return !TextUtils.isEmpty(str) ? ha(str) + "/frame" : "";
    }

    public static String Pm() {
        return a.bxL;
    }

    public static String he(String str) {
        return !TextUtils.isEmpty(str) ? Pm() + "/" + str : "";
    }

    public static String hf(String str) {
        return !TextUtils.isEmpty(str) ? he(str) + "/dest" : "";
    }

    public static String hg(String str) {
        return !TextUtils.isEmpty(str) ? he(str) + "/video" : "";
    }

    public static String hh(String str) {
        return !TextUtils.isEmpty(str) ? he(str) + "/frame" : "";
    }

    public static String Pn() {
        return a.bxM;
    }

    public static String Po() {
        return a.bxP;
    }

    public static String Pp() {
        return Pn() + "/start";
    }

    public static String Pq() {
        return Po() + "/start";
    }

    public static String Pr() {
        return Pp() + "/dest";
    }

    public static String Ps() {
        return Pq() + "/dest";
    }

    public static String Pt() {
        return Pp() + "/video";
    }

    public static String hi(String str) {
        return a.bxN + "/" + str + "/dest";
    }

    public static String hj(String str) {
        return a.bxO + "/" + str + "/dest";
    }

    public static String hk(String str) {
        return a.bxN + "/" + str;
    }

    public static String hl(String str) {
        return a.bxO + "/" + str;
    }

    public static String Pu() {
        return Pq() + "/video";
    }
}
