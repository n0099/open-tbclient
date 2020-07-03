package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c {
    private static String bvL;
    private static String bvM;
    private static String bvN;
    private static String bvO;
    private static String bvP;
    private static String bvQ;
    private static String bvS;
    private static String bvT;
    private static String bvU;
    private static String bvV;
    private static String bvW;
    private static String bvX;
    private static String bvY;
    private static String bvZ;
    private static String bwa;
    private static String bwb;
    private static String bwc;
    private static String bwd;
    private static String bwe;
    public static String bvI = "arface_main_res_version";
    public static int bvJ = 0;
    public static boolean bvK = true;
    public static String bvR = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bvL = str + "/";
        bvM = bvL;
        bvN = bvL + "ext/";
        bvO = bvM + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bvX = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bvV = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bvW = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bvO = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bvY = str2 + "/makeup";
            bvZ = str2 + "/beauty";
            bwa = str2 + "/arFilterInit";
            bwb = str2 + "/arFilterEditInit";
            bwc = bvZ + "/liveVideoFace/live_face_knead.json";
            bwd = bvZ + "/liveVideoFace/goddess_face_knead.json";
            bwe = bvZ + "/liveVideoFace/baby_face_knead.json";
        } else {
            bvX = bvM + "filters/yuantu/yuantu.png";
            bvV = bvM + "filter/beauty_skin_stream.png";
            bvW = bvM + "filter/beauty_skin_small_video.png";
            bvY = bvL + "makeup/";
            bvZ = bvL + "beauty/";
            bwa = bvL + "arFilterInit/";
            bwb = bvL + "arFilterEditInit/";
            bwc = bvZ + "liveVideoFace/live_face_knead.json";
            bwd = bvZ + "liveVideoFace/goddess_face_knead.json";
            bwe = bvZ + "liveVideoFace/baby_face_knead.json";
        }
        bvQ = bvM + "global";
        bvU = bvM + "vip_list.json";
        bvT = bvM + "filters";
        bvP = bvM + "dlModels/";
        bvS = bvT + "/all";
        bvR = bvM + "global/res/filter";
    }

    public static String Ne() {
        return bvX;
    }

    public static String Nf() {
        return bvM;
    }

    public static String Ng() {
        return bvO;
    }

    public static String Nh() {
        return bvQ;
    }

    public static String Ni() {
        return "/filter_config.json";
    }

    public static String Nj() {
        return dO(0);
    }

    public static String dO(int i) {
        if (i == 1) {
            return bwd;
        }
        if (i == 2) {
            return bwe;
        }
        return bwc;
    }

    public static String cM(boolean z) {
        return z ? bwa : bwb;
    }
}
