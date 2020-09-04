package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class c {
    private static String bBM;
    private static String bBN;
    private static String bBO;
    private static String bBP;
    private static String bBQ;
    private static String bBR;
    private static String bBT;
    private static String bBU;
    private static String bBV;
    private static String bBW;
    private static String bBX;
    private static String bBY;
    private static String bBZ;
    private static String bCa;
    private static String bCb;
    private static String bCc;
    private static String bCd;
    private static String bCe;
    private static String bCf;
    public static String bBJ = "arface_main_res_version";
    public static int bBK = 0;
    public static boolean bBL = true;
    public static String bBS = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bBM = str + "/";
        bBN = bBM;
        bBO = bBM + "ext/";
        bBP = bBN + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bBY = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bBW = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bBX = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bBP = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bBZ = str2 + "/makeup";
            bCa = str2 + "/beauty";
            bCb = str2 + "/arFilterInit";
            bCc = str2 + "/arFilterEditInit";
            bCd = bCa + "/liveVideoFace/live_face_knead.json";
            bCe = bCa + "/liveVideoFace/goddess_face_knead.json";
            bCf = bCa + "/liveVideoFace/baby_face_knead.json";
        } else {
            bBY = bBN + "filters/yuantu/yuantu.png";
            bBW = bBN + "filter/beauty_skin_stream.png";
            bBX = bBN + "filter/beauty_skin_small_video.png";
            bBZ = bBM + "makeup/";
            bCa = bBM + "beauty/";
            bCb = bBM + "arFilterInit/";
            bCc = bBM + "arFilterEditInit/";
            bCd = bCa + "liveVideoFace/live_face_knead.json";
            bCe = bCa + "liveVideoFace/goddess_face_knead.json";
            bCf = bCa + "liveVideoFace/baby_face_knead.json";
        }
        bBR = bBN + "global";
        bBV = bBN + "vip_list.json";
        bBU = bBN + "filters";
        bBQ = bBN + "dlModels/";
        bBT = bBU + "/all";
        bBS = bBN + "global/res/filter";
    }

    public static String Td() {
        return bBY;
    }

    public static String Te() {
        return bBN;
    }

    public static String Tf() {
        return bBP;
    }

    public static String Tg() {
        return bBR;
    }

    public static String Th() {
        return "/filter_config.json";
    }

    public static String Ti() {
        return fK(0);
    }

    public static String fK(int i) {
        if (i == 1) {
            return bCe;
        }
        if (i == 2) {
            return bCf;
        }
        return bCd;
    }

    public static String cX(boolean z) {
        return z ? bCb : bCc;
    }
}
