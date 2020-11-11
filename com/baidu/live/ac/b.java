package com.baidu.live.ac;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b {
    public static String Qq() {
        return a.bun;
    }

    public static String Qr() {
        return a.bup;
    }

    public static String ia(String str) {
        return !TextUtils.isEmpty(str) ? Qr() + "/" + str : "";
    }

    public static String ib(String str) {
        return !TextUtils.isEmpty(str) ? ia(str) + "/dest" : "";
    }

    public static String ic(String str) {
        return !TextUtils.isEmpty(str) ? ia(str) + "/video" : "";
    }

    public static String id(String str) {
        return !TextUtils.isEmpty(str) ? ia(str) + "/frame" : "";
    }

    public static String Qs() {
        return a.buq;
    }

    public static String ie(String str) {
        return !TextUtils.isEmpty(str) ? Qs() + "/" + str : "";
    }

    /* renamed from: if  reason: not valid java name */
    public static String m22if(String str) {
        return !TextUtils.isEmpty(str) ? ie(str) + "/dest" : "";
    }

    public static String ig(String str) {
        return !TextUtils.isEmpty(str) ? ie(str) + "/video" : "";
    }

    public static String ih(String str) {
        return !TextUtils.isEmpty(str) ? ie(str) + "/frame" : "";
    }

    public static String Qt() {
        return a.bur;
    }

    public static String Qu() {
        return Qt() + "/start";
    }

    public static String Qv() {
        return Qu() + "/dest";
    }

    public static String Qw() {
        return Qu() + "/video";
    }

    public static String ii(String str) {
        return a.bus + "/" + str + "/dest";
    }

    public static String ij(String str) {
        return a.bus + "/" + str;
    }
}
