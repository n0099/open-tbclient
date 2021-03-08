package com.baidu.live.storage;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class b {
    public static String QO() {
        return a.bCL;
    }

    public static String QP() {
        return a.bCN;
    }

    public static String hC(String str) {
        return !TextUtils.isEmpty(str) ? QP() + "/" + str : "";
    }

    public static String hD(String str) {
        return !TextUtils.isEmpty(str) ? hC(str) + "/dest" : "";
    }

    public static String hE(String str) {
        return !TextUtils.isEmpty(str) ? hC(str) + "/video" : "";
    }

    public static String hF(String str) {
        return !TextUtils.isEmpty(str) ? hC(str) + "/frame" : "";
    }

    public static String QQ() {
        return a.bCO;
    }

    public static String hG(String str) {
        return !TextUtils.isEmpty(str) ? QQ() + "/" + str : "";
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

    public static String QR() {
        return a.bCP;
    }

    public static String QS() {
        return a.bCS;
    }

    public static String QT() {
        return QR() + "/start";
    }

    public static String QU() {
        return QR() + "/kill";
    }

    public static String QV() {
        return QR() + "/anti_kill";
    }

    public static String QW() {
        return QR() + "/task_bg";
    }

    public static String QX() {
        return QS() + "/start";
    }

    public static String QY() {
        return QT() + "/dest";
    }

    public static String QZ() {
        return QU() + "/dest";
    }

    public static String Ra() {
        return QV() + "/dest";
    }

    public static String Rb() {
        return QW() + "/dest";
    }

    public static String Rc() {
        return QX() + "/dest";
    }

    public static String Rd() {
        return QU() + "/video";
    }

    public static String Re() {
        return QV() + "/video";
    }

    public static String Rf() {
        return QW() + "/video";
    }

    public static String Rg() {
        return QT() + "/video";
    }

    public static String hK(String str) {
        return a.bCQ + "/" + str + "/dest";
    }

    public static String hL(String str) {
        return a.bCR + "/" + str + "/dest";
    }

    public static String hM(String str) {
        return a.bCQ + "/" + str;
    }

    public static String hN(String str) {
        return a.bCR + "/" + str;
    }

    public static String Rh() {
        return QX() + "/video";
    }
}
