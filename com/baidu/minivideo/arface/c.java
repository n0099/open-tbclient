package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c {
    private static String bjA;
    private static String bjB;
    private static String bjC;
    private static String bjD;
    private static String bjE;
    private static String bjF;
    private static String bjG;
    private static String bjp;
    private static String bjq;
    private static String bjr;
    private static String bjs;
    private static String bjt;
    private static String bju;
    private static String bjw;
    private static String bjx;
    private static String bjy;
    private static String bjz;
    public static String bjm = "arface_main_res_version";
    public static int bjn = 0;
    public static boolean bjo = true;
    public static String bjv = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bjp = str + "/";
        bjq = bjp;
        bjr = bjp + "ext/";
        bjs = bjq + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bjB = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bjz = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bjA = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bjs = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bjC = str2 + "/makeup";
            bjD = str2 + "/beauty";
            bjE = str2 + "/arFilterInit";
            bjF = str2 + "/arFilterEditInit";
            bjG = bjD + "/liveVideoFace/face_knead.json";
        } else {
            bjB = bjq + "filters/yuantu/yuantu.png";
            bjz = bjq + "filter/beauty_skin_stream.png";
            bjA = bjq + "filter/beauty_skin_small_video.png";
            bjC = bjp + "makeup/";
            bjD = bjp + "beauty/";
            bjE = bjp + "arFilterInit/";
            bjF = bjp + "arFilterEditInit/";
            bjG = bjD + "liveVideoFace/face_knead.json";
        }
        bju = bjq + "global";
        bjy = bjq + "vip_list.json";
        bjx = bjq + "filters";
        bjt = bjq + "dlModels/";
        bjw = bjx + "/all";
        bjv = bjq + "global/res/filter";
    }

    public static String Ka() {
        return bjB;
    }

    public static String Kb() {
        return bjq;
    }

    public static String Kc() {
        return bjs;
    }

    public static String Kd() {
        return bju;
    }

    public static String Ke() {
        return "/filter_config.json";
    }

    public static String Kf() {
        return bjG;
    }

    public static String cv(boolean z) {
        return z ? bjE : bjF;
    }
}
