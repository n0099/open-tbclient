package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes15.dex */
public class c {
    private static String bZS;
    private static String bZT;
    private static String bZU;
    private static String bZV;
    private static String bZW;
    private static String bZX;
    private static String bZZ;
    private static String caa;
    private static String cab;
    private static String cac;
    private static String cad;
    private static String cae;
    private static String caf;
    private static String cag;
    private static String cah;
    private static String cai;
    private static String caj;
    private static String cak;
    private static String cal;
    public static String bZP = "arface_main_res_version";
    public static int bZQ = 0;
    public static boolean bZR = true;
    public static String bZY = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DUAR_DuArResConfig", "setPath: " + str);
        }
        bZS = str + "/";
        bZT = bZS;
        bZU = bZS + "ext/";
        bZV = bZT + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            cae = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            cac = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            cad = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bZV = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            caf = str2 + "/makeup";
            cag = str2 + "/beauty";
            cah = str2 + "/arFilterInit";
            cai = str2 + "/arFilterEditInit";
            caj = cag + "/liveVideoFace/live_face_knead.json";
            cak = cag + "/liveVideoFace/goddess_face_knead.json";
            cal = cag + "/liveVideoFace/baby_face_knead.json";
        } else {
            cae = bZT + "filters/yuantu/yuantu.png";
            cac = bZT + "filter/beauty_skin_stream.png";
            cad = bZT + "filter/beauty_skin_small_video.png";
            caf = bZS + "makeup/";
            cag = bZS + "beauty/";
            cah = bZS + "arFilterInit/";
            cai = bZS + "arFilterEditInit/";
            caj = cag + "liveVideoFace/live_face_knead.json";
            cak = cag + "liveVideoFace/goddess_face_knead.json";
            cal = cag + "liveVideoFace/baby_face_knead.json";
        }
        bZX = bZT + "global";
        cab = bZT + "vip_list.json";
        caa = bZT + "filters";
        bZW = bZT + "dlModels/";
        bZZ = caa + "/all";
        bZY = bZT + "global/res/filter";
    }

    public static String aag() {
        return cae;
    }

    public static String aah() {
        return bZT;
    }

    public static String aai() {
        return bZV;
    }

    public static String aaj() {
        return bZX;
    }

    public static String aak() {
        return "/filter_config.json";
    }

    public static String aal() {
        return gI(0);
    }

    public static String gI(int i) {
        if (i == 1) {
            return cak;
        }
        if (i == 2) {
            return cal;
        }
        return caj;
    }

    public static String dA(boolean z) {
        return z ? cah : cai;
    }
}
