package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public class c {
    private static String ckA;
    private static String ckB;
    private static String ckC;
    private static String ckD;
    private static String ckE;
    private static String ckF;
    private static String ckG;
    private static String ckn;
    private static String cko;
    private static String ckp;
    private static String ckq;
    private static String ckr;
    private static String cks;
    private static String cku;
    private static String ckv;
    private static String ckw;
    private static String ckx;
    private static String cky;
    private static String ckz;
    public static String ckk = "arface_main_res_version";
    public static int ckl = 0;
    public static boolean ckm = true;
    public static String ckt = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DuAr_DuArResConfig", "setPath: " + str);
        }
        ckn = str + "/";
        cko = ckn;
        ckp = ckn + "ext/";
        ckq = cko + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            ckz = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            ckx = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            cky = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            ckq = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            ckA = str2 + "/makeup";
            ckB = str2 + "/beauty";
            ckC = str2 + "/arFilterInit";
            ckD = str2 + "/arFilterEditInit";
            ckE = ckB + "/liveVideoFace/live_face_knead.json";
            ckF = ckB + "/liveVideoFace/goddess_face_knead.json";
            ckG = ckB + "/liveVideoFace/baby_face_knead.json";
        } else {
            ckz = cko + "filters/yuantu/yuantu.png";
            ckx = cko + "filter/beauty_skin_stream.png";
            cky = cko + "filter/beauty_skin_small_video.png";
            ckA = ckn + "makeup/";
            ckB = ckn + "beauty/";
            ckC = ckn + "arFilterInit/";
            ckD = ckn + "arFilterEditInit/";
            ckE = ckB + "liveVideoFace/live_face_knead.json";
            ckF = ckB + "liveVideoFace/goddess_face_knead.json";
            ckG = ckB + "liveVideoFace/baby_face_knead.json";
        }
        cks = cko + "global";
        ckw = cko + "vip_list.json";
        ckv = cko + "filters";
        ckr = cko + "dlModels/";
        cku = ckv + "/all";
        ckt = cko + "global/res/filter";
    }

    public static String adT() {
        return ckz;
    }

    public static String adU() {
        return ckn;
    }

    public static String adV() {
        return cko;
    }

    public static String adW() {
        return ckq;
    }

    public static String adX() {
        return cks;
    }

    public static String adY() {
        return "/filter_config.json";
    }

    public static String adZ() {
        return hb(0);
    }

    public static String hb(int i) {
        if (i == 1) {
            return ckF;
        }
        if (i == 2) {
            return ckG;
        }
        return ckE;
    }

    public static String dZ(boolean z) {
        return z ? ckC : ckD;
    }
}
