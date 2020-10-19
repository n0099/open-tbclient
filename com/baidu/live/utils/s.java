package com.baidu.live.utils;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class s {
    public static String QY() {
        return r.bxD;
    }

    public static String hX(String str) {
        return !TextUtils.isEmpty(str) ? QY() + "/" + str : "";
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

    public static String QZ() {
        return r.bxE;
    }

    public static String ib(String str) {
        return !TextUtils.isEmpty(str) ? QZ() + "/" + str : "";
    }

    public static String ic(String str) {
        return !TextUtils.isEmpty(str) ? ib(str) + "/dest" : "";
    }

    public static String id(String str) {
        return !TextUtils.isEmpty(str) ? ib(str) + "/video" : "";
    }

    public static String ie(String str) {
        return !TextUtils.isEmpty(str) ? ib(str) + "/frame" : "";
    }

    public static String Ra() {
        return r.bxF;
    }

    public static String Rb() {
        return Ra() + "/start";
    }

    public static String Rc() {
        return Rb() + "/dest";
    }

    public static String Rd() {
        return Rb() + "/video";
    }
}
