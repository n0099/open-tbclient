package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes3.dex */
public class c {
    private static String cjK;
    private static String cjL;
    private static String cjM;
    private static String cjN;
    private static String cjO;
    private static String cjP;
    private static String cjR;
    private static String cjS;
    private static String cjT;
    private static String cjU;
    private static String cjV;
    private static String cjW;
    private static String cjX;
    private static String cjY;
    private static String cjZ;
    private static String cka;
    private static String ckb;
    private static String ckc;
    private static String ckd;
    public static String cjH = "arface_main_res_version";
    public static int cjI = 0;
    public static boolean cjJ = true;
    public static String cjQ = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DuAr_DuArResConfig", "setPath: " + str);
        }
        cjK = str + "/";
        cjL = cjK;
        cjM = cjK + "ext/";
        cjN = cjL + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            cjW = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            cjU = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            cjV = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            cjN = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            cjX = str2 + "/makeup";
            cjY = str2 + "/beauty";
            cjZ = str2 + "/arFilterInit";
            cka = str2 + "/arFilterEditInit";
            ckb = cjY + "/liveVideoFace/live_face_knead.json";
            ckc = cjY + "/liveVideoFace/goddess_face_knead.json";
            ckd = cjY + "/liveVideoFace/baby_face_knead.json";
        } else {
            cjW = cjL + "filters/yuantu/yuantu.png";
            cjU = cjL + "filter/beauty_skin_stream.png";
            cjV = cjL + "filter/beauty_skin_small_video.png";
            cjX = cjK + "makeup/";
            cjY = cjK + "beauty/";
            cjZ = cjK + "arFilterInit/";
            cka = cjK + "arFilterEditInit/";
            ckb = cjY + "liveVideoFace/live_face_knead.json";
            ckc = cjY + "liveVideoFace/goddess_face_knead.json";
            ckd = cjY + "liveVideoFace/baby_face_knead.json";
        }
        cjP = cjL + "global";
        cjT = cjL + "vip_list.json";
        cjS = cjL + "filters";
        cjO = cjL + "dlModels/";
        cjR = cjS + "/all";
        cjQ = cjL + "global/res/filter";
    }

    public static String abP() {
        return cjW;
    }

    public static String abQ() {
        return cjK;
    }

    public static String abR() {
        return cjL;
    }

    public static String abS() {
        return cjN;
    }

    public static String abT() {
        return cjP;
    }

    public static String abU() {
        return "/filter_config.json";
    }

    public static String abV() {
        return fA(0);
    }

    public static String fA(int i) {
        if (i == 1) {
            return ckc;
        }
        if (i == 2) {
            return ckd;
        }
        return ckb;
    }

    public static String ed(boolean z) {
        return z ? cjZ : cka;
    }
}
