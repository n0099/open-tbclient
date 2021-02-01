package com.baidu.live.storage;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    public static String QL() {
        return a.bBl;
    }

    public static String QM() {
        return a.bBn;
    }

    public static String hw(String str) {
        return !TextUtils.isEmpty(str) ? QM() + "/" + str : "";
    }

    public static String hx(String str) {
        return !TextUtils.isEmpty(str) ? hw(str) + "/dest" : "";
    }

    public static String hy(String str) {
        return !TextUtils.isEmpty(str) ? hw(str) + "/video" : "";
    }

    public static String hz(String str) {
        return !TextUtils.isEmpty(str) ? hw(str) + "/frame" : "";
    }

    public static String QN() {
        return a.bBo;
    }

    public static String hA(String str) {
        return !TextUtils.isEmpty(str) ? QN() + "/" + str : "";
    }

    public static String hB(String str) {
        return !TextUtils.isEmpty(str) ? hA(str) + "/dest" : "";
    }

    public static String hC(String str) {
        return !TextUtils.isEmpty(str) ? hA(str) + "/video" : "";
    }

    public static String hD(String str) {
        return !TextUtils.isEmpty(str) ? hA(str) + "/frame" : "";
    }

    public static String QO() {
        return a.bBp;
    }

    public static String QP() {
        return a.bBs;
    }

    public static String QQ() {
        return QO() + "/start";
    }

    public static String QR() {
        return QO() + "/kill";
    }

    public static String QS() {
        return QO() + "/anti_kill";
    }

    public static String QT() {
        return QO() + "/task_bg";
    }

    public static String QU() {
        return QP() + "/start";
    }

    public static String QV() {
        return QQ() + "/dest";
    }

    public static String QW() {
        return QR() + "/dest";
    }

    public static String QX() {
        return QS() + "/dest";
    }

    public static String QY() {
        return QT() + "/dest";
    }

    public static String QZ() {
        return QU() + "/dest";
    }

    public static String Ra() {
        return QR() + "/video";
    }

    public static String Rb() {
        return QS() + "/video";
    }

    public static String Rc() {
        return QT() + "/video";
    }

    public static String Rd() {
        return QQ() + "/video";
    }

    public static String hE(String str) {
        return a.bBq + "/" + str + "/dest";
    }

    public static String hF(String str) {
        return a.bBr + "/" + str + "/dest";
    }

    public static String hG(String str) {
        return a.bBq + "/" + str;
    }

    public static String hH(String str) {
        return a.bBr + "/" + str;
    }

    public static String Re() {
        return QU() + "/video";
    }
}
