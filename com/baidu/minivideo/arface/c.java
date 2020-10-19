package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes15.dex */
public class c {
    private static String bLL;
    private static String bLM;
    private static String bLN;
    private static String bLO;
    private static String bLP;
    private static String bLQ;
    private static String bLS;
    private static String bLT;
    private static String bLU;
    private static String bLV;
    private static String bLW;
    private static String bLX;
    private static String bLY;
    private static String bLZ;
    private static String bMa;
    private static String bMb;
    private static String bMc;
    private static String bMd;
    private static String bMe;
    public static String bLI = "arface_main_res_version";
    public static int bLJ = 0;
    public static boolean bLK = true;
    public static String bLR = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DUAR_DuArResConfig", "setPath: " + str);
        }
        bLL = str + "/";
        bLM = bLL;
        bLN = bLL + "ext/";
        bLO = bLM + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bLX = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bLV = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bLW = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bLO = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bLY = str2 + "/makeup";
            bLZ = str2 + "/beauty";
            bMa = str2 + "/arFilterInit";
            bMb = str2 + "/arFilterEditInit";
            bMc = bLZ + "/liveVideoFace/live_face_knead.json";
            bMd = bLZ + "/liveVideoFace/goddess_face_knead.json";
            bMe = bLZ + "/liveVideoFace/baby_face_knead.json";
        } else {
            bLX = bLM + "filters/yuantu/yuantu.png";
            bLV = bLM + "filter/beauty_skin_stream.png";
            bLW = bLM + "filter/beauty_skin_small_video.png";
            bLY = bLL + "makeup/";
            bLZ = bLL + "beauty/";
            bMa = bLL + "arFilterInit/";
            bMb = bLL + "arFilterEditInit/";
            bMc = bLZ + "liveVideoFace/live_face_knead.json";
            bMd = bLZ + "liveVideoFace/goddess_face_knead.json";
            bMe = bLZ + "liveVideoFace/baby_face_knead.json";
        }
        bLQ = bLM + "global";
        bLU = bLM + "vip_list.json";
        bLT = bLM + "filters";
        bLP = bLM + "dlModels/";
        bLS = bLT + "/all";
        bLR = bLM + "global/res/filter";
    }

    public static String VN() {
        return bLX;
    }

    public static String VO() {
        return bLM;
    }

    public static String VP() {
        return bLO;
    }

    public static String VQ() {
        return bLQ;
    }

    public static String VR() {
        return "/filter_config.json";
    }

    public static String VS() {
        return gm(0);
    }

    public static String gm(int i) {
        if (i == 1) {
            return bMd;
        }
        if (i == 2) {
            return bMe;
        }
        return bMc;
    }

    public static String df(boolean z) {
        return z ? bMa : bMb;
    }
}
