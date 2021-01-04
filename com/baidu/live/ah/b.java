package com.baidu.live.ah;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    public static String Tf() {
        return a.bCu;
    }

    public static String Tg() {
        return a.bCw;
    }

    public static String il(String str) {
        return !TextUtils.isEmpty(str) ? Tg() + "/" + str : "";
    }

    public static String im(String str) {
        return !TextUtils.isEmpty(str) ? il(str) + "/dest" : "";
    }

    public static String in(String str) {
        return !TextUtils.isEmpty(str) ? il(str) + "/video" : "";
    }

    public static String io(String str) {
        return !TextUtils.isEmpty(str) ? il(str) + "/frame" : "";
    }

    public static String Th() {
        return a.bCx;
    }

    public static String ip(String str) {
        return !TextUtils.isEmpty(str) ? Th() + "/" + str : "";
    }

    public static String iq(String str) {
        return !TextUtils.isEmpty(str) ? ip(str) + "/dest" : "";
    }

    public static String ir(String str) {
        return !TextUtils.isEmpty(str) ? ip(str) + "/video" : "";
    }

    public static String is(String str) {
        return !TextUtils.isEmpty(str) ? ip(str) + "/frame" : "";
    }

    public static String Ti() {
        return a.bCy;
    }

    public static String Tj() {
        return a.bCB;
    }

    public static String Tk() {
        return Ti() + "/start";
    }

    public static String Tl() {
        return Tj() + "/start";
    }

    public static String Tm() {
        return Tk() + "/dest";
    }

    public static String Tn() {
        return Tl() + "/dest";
    }

    public static String To() {
        return Tk() + "/video";
    }

    public static String it(String str) {
        return a.bCz + "/" + str + "/dest";
    }

    public static String iu(String str) {
        return a.bCA + "/" + str + "/dest";
    }

    public static String iv(String str) {
        return a.bCz + "/" + str;
    }

    public static String iw(String str) {
        return a.bCA + "/" + str;
    }

    public static String Tp() {
        return Tl() + "/video";
    }
}
