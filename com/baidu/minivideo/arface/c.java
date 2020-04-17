package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c {
    private static String bjA;
    private static String bjB;
    private static String bjk;
    private static String bjl;
    private static String bjm;
    private static String bjn;
    private static String bjo;
    private static String bjp;
    private static String bjr;
    private static String bjs;
    private static String bjt;
    private static String bju;
    private static String bjv;
    private static String bjw;
    private static String bjx;
    private static String bjy;
    private static String bjz;
    public static String bjh = "arface_main_res_version";
    public static int bji = 0;
    public static boolean bjj = true;
    public static String bjq = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bjk = str + "/";
        bjl = bjk;
        bjm = bjk + "ext/";
        bjn = bjl + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bjw = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bju = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bjv = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bjn = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bjx = str2 + "/makeup";
            bjy = str2 + "/beauty";
            bjz = str2 + "/arFilterInit";
            bjA = str2 + "/arFilterEditInit";
            bjB = bjy + "/liveVideoFace/face_knead.json";
        } else {
            bjw = bjl + "filters/yuantu/yuantu.png";
            bju = bjl + "filter/beauty_skin_stream.png";
            bjv = bjl + "filter/beauty_skin_small_video.png";
            bjx = bjk + "makeup/";
            bjy = bjk + "beauty/";
            bjz = bjk + "arFilterInit/";
            bjA = bjk + "arFilterEditInit/";
            bjB = bjy + "liveVideoFace/face_knead.json";
        }
        bjp = bjl + "global";
        bjt = bjl + "vip_list.json";
        bjs = bjl + "filters";
        bjo = bjl + "dlModels/";
        bjr = bjs + "/all";
        bjq = bjl + "global/res/filter";
    }

    public static String Kb() {
        return bjw;
    }

    public static String Kc() {
        return bjl;
    }

    public static String Kd() {
        return bjn;
    }

    public static String Ke() {
        return bjp;
    }

    public static String Kf() {
        return "/filter_config.json";
    }

    public static String Kg() {
        return bjB;
    }

    public static String cv(boolean z) {
        return z ? bjz : bjA;
    }
}
