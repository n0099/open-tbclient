package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public class c {
    private static String cfA;
    private static String cfB;
    private static String cfC;
    private static String cfD;
    private static String cfE;
    private static String cfF;
    private static String cfH;
    private static String cfI;
    private static String cfJ;
    private static String cfK;
    private static String cfL;
    private static String cfM;
    private static String cfN;
    private static String cfO;
    private static String cfP;
    private static String cfQ;
    private static String cfR;
    private static String cfS;
    private static String cfT;
    public static String cfx = "arface_main_res_version";
    public static int cfy = 0;
    public static boolean cfz = true;
    public static String cfG = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DuAr_DuArResConfig", "setPath: " + str);
        }
        cfA = str + "/";
        cfB = cfA;
        cfC = cfA + "ext/";
        cfD = cfB + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            cfM = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            cfK = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            cfL = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            cfD = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            cfN = str2 + "/makeup";
            cfO = str2 + "/beauty";
            cfP = str2 + "/arFilterInit";
            cfQ = str2 + "/arFilterEditInit";
            cfR = cfO + "/liveVideoFace/live_face_knead.json";
            cfS = cfO + "/liveVideoFace/goddess_face_knead.json";
            cfT = cfO + "/liveVideoFace/baby_face_knead.json";
        } else {
            cfM = cfB + "filters/yuantu/yuantu.png";
            cfK = cfB + "filter/beauty_skin_stream.png";
            cfL = cfB + "filter/beauty_skin_small_video.png";
            cfN = cfA + "makeup/";
            cfO = cfA + "beauty/";
            cfP = cfA + "arFilterInit/";
            cfQ = cfA + "arFilterEditInit/";
            cfR = cfO + "liveVideoFace/live_face_knead.json";
            cfS = cfO + "liveVideoFace/goddess_face_knead.json";
            cfT = cfO + "liveVideoFace/baby_face_knead.json";
        }
        cfF = cfB + "global";
        cfJ = cfB + "vip_list.json";
        cfI = cfB + "filters";
        cfE = cfB + "dlModels/";
        cfH = cfI + "/all";
        cfG = cfB + "global/res/filter";
    }

    public static String aab() {
        return cfM;
    }

    public static String aac() {
        return cfA;
    }

    public static String aad() {
        return cfB;
    }

    public static String aae() {
        return cfD;
    }

    public static String aaf() {
        return cfF;
    }

    public static String aag() {
        return "/filter_config.json";
    }

    public static String aah() {
        return fu(0);
    }

    public static String fu(int i) {
        if (i == 1) {
            return cfS;
        }
        if (i == 2) {
            return cfT;
        }
        return cfR;
    }

    public static String dV(boolean z) {
        return z ? cfP : cfQ;
    }
}
