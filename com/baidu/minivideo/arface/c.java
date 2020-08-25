package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class c {
    private static String bBJ;
    private static String bBK;
    private static String bBL;
    private static String bBM;
    private static String bBN;
    private static String bBO;
    private static String bBQ;
    private static String bBR;
    private static String bBS;
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
    public static String bBG = "arface_main_res_version";
    public static int bBH = 0;
    public static boolean bBI = true;
    public static String bBP = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bBJ = str + "/";
        bBK = bBJ;
        bBL = bBJ + "ext/";
        bBM = bBK + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bBV = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bBT = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bBU = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bBM = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bBW = str2 + "/makeup";
            bBX = str2 + "/beauty";
            bBY = str2 + "/arFilterInit";
            bBZ = str2 + "/arFilterEditInit";
            bCa = bBX + "/liveVideoFace/live_face_knead.json";
            bCb = bBX + "/liveVideoFace/goddess_face_knead.json";
            bCc = bBX + "/liveVideoFace/baby_face_knead.json";
        } else {
            bBV = bBK + "filters/yuantu/yuantu.png";
            bBT = bBK + "filter/beauty_skin_stream.png";
            bBU = bBK + "filter/beauty_skin_small_video.png";
            bBW = bBJ + "makeup/";
            bBX = bBJ + "beauty/";
            bBY = bBJ + "arFilterInit/";
            bBZ = bBJ + "arFilterEditInit/";
            bCa = bBX + "liveVideoFace/live_face_knead.json";
            bCb = bBX + "liveVideoFace/goddess_face_knead.json";
            bCc = bBX + "liveVideoFace/baby_face_knead.json";
        }
        bBO = bBK + "global";
        bBS = bBK + "vip_list.json";
        bBR = bBK + "filters";
        bBN = bBK + "dlModels/";
        bBQ = bBR + "/all";
        bBP = bBK + "global/res/filter";
    }

    public static String Td() {
        return bBV;
    }

    public static String Te() {
        return bBK;
    }

    public static String Tf() {
        return bBM;
    }

    public static String Tg() {
        return bBO;
    }

    public static String Th() {
        return "/filter_config.json";
    }

    public static String Ti() {
        return fK(0);
    }

    public static String fK(int i) {
        if (i == 1) {
            return bCb;
        }
        if (i == 2) {
            return bCc;
        }
        return bCa;
    }

    public static String cW(boolean z) {
        return z ? bBY : bBZ;
    }
}
