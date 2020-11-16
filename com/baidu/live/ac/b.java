package com.baidu.live.ac;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b {
    public static String PH() {
        return a.bsA;
    }

    public static String PI() {
        return a.bsC;
    }

    public static String hU(String str) {
        return !TextUtils.isEmpty(str) ? PI() + "/" + str : "";
    }

    public static String hV(String str) {
        return !TextUtils.isEmpty(str) ? hU(str) + "/dest" : "";
    }

    public static String hW(String str) {
        return !TextUtils.isEmpty(str) ? hU(str) + "/video" : "";
    }

    public static String hX(String str) {
        return !TextUtils.isEmpty(str) ? hU(str) + "/frame" : "";
    }

    public static String PJ() {
        return a.bsD;
    }

    public static String hY(String str) {
        return !TextUtils.isEmpty(str) ? PJ() + "/" + str : "";
    }

    public static String hZ(String str) {
        return !TextUtils.isEmpty(str) ? hY(str) + "/dest" : "";
    }

    public static String ia(String str) {
        return !TextUtils.isEmpty(str) ? hY(str) + "/video" : "";
    }

    public static String ib(String str) {
        return !TextUtils.isEmpty(str) ? hY(str) + "/frame" : "";
    }

    public static String PK() {
        return a.bsE;
    }

    public static String PL() {
        return PK() + "/start";
    }

    public static String PM() {
        return PL() + "/dest";
    }

    public static String PN() {
        return PL() + "/video";
    }

    public static String ic(String str) {
        return a.bsF + "/" + str + "/dest";
    }

    public static String id(String str) {
        return a.bsF + "/" + str;
    }
}
