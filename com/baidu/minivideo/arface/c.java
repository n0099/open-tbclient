package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c {
    private static String bqK;
    private static String bqL;
    private static String bqM;
    private static String bqN;
    private static String bqO;
    private static String bqP;
    private static String bqR;
    private static String bqS;
    private static String bqT;
    private static String bqU;
    private static String bqV;
    private static String bqW;
    private static String bqX;
    private static String bqY;
    private static String bqZ;
    private static String bra;
    private static String brb;
    public static String bqH = "arface_main_res_version";
    public static int bqI = 0;
    public static boolean bqJ = true;
    public static String bqQ = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bqK = str + "/";
        bqL = bqK;
        bqM = bqK + "ext/";
        bqN = bqL + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bqW = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bqU = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bqV = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bqN = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bqX = str2 + "/makeup";
            bqY = str2 + "/beauty";
            bqZ = str2 + "/arFilterInit";
            bra = str2 + "/arFilterEditInit";
            brb = bqY + "/liveVideoFace/face_knead.json";
        } else {
            bqW = bqL + "filters/yuantu/yuantu.png";
            bqU = bqL + "filter/beauty_skin_stream.png";
            bqV = bqL + "filter/beauty_skin_small_video.png";
            bqX = bqK + "makeup/";
            bqY = bqK + "beauty/";
            bqZ = bqK + "arFilterInit/";
            bra = bqK + "arFilterEditInit/";
            brb = bqY + "liveVideoFace/face_knead.json";
        }
        bqP = bqL + "global";
        bqT = bqL + "vip_list.json";
        bqS = bqL + "filters";
        bqO = bqL + "dlModels/";
        bqR = bqS + "/all";
        bqQ = bqL + "global/res/filter";
    }

    public static String LT() {
        return bqW;
    }

    public static String LU() {
        return bqL;
    }

    public static String LV() {
        return bqN;
    }

    public static String LW() {
        return bqP;
    }

    public static String LX() {
        return "/filter_config.json";
    }

    public static String LY() {
        return brb;
    }

    public static String cH(boolean z) {
        return z ? bqZ : bra;
    }
}
