package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    private static String cdI;
    private static String cdJ;
    private static String cdK;
    private static String cdL;
    private static String cdM;
    private static String cdN;
    private static String cdP;
    private static String cdQ;
    private static String cdR;
    private static String cdS;
    private static String cdT;
    private static String cdU;
    private static String cdV;
    private static String cdW;
    private static String cdX;
    private static String cdY;
    private static String cdZ;
    private static String cea;
    private static String ceb;
    public static String cdF = "arface_main_res_version";
    public static int cdG = 0;
    public static boolean cdH = true;
    public static String cdO = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DuAr_DuArResConfig", "setPath: " + str);
        }
        cdI = str + "/";
        cdJ = cdI;
        cdK = cdI + "ext/";
        cdL = cdJ + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            cdU = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            cdS = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            cdT = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            cdL = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            cdV = str2 + "/makeup";
            cdW = str2 + "/beauty";
            cdX = str2 + "/arFilterInit";
            cdY = str2 + "/arFilterEditInit";
            cdZ = cdW + "/liveVideoFace/live_face_knead.json";
            cea = cdW + "/liveVideoFace/goddess_face_knead.json";
            ceb = cdW + "/liveVideoFace/baby_face_knead.json";
        } else {
            cdU = cdJ + "filters/yuantu/yuantu.png";
            cdS = cdJ + "filter/beauty_skin_stream.png";
            cdT = cdJ + "filter/beauty_skin_small_video.png";
            cdV = cdI + "makeup/";
            cdW = cdI + "beauty/";
            cdX = cdI + "arFilterInit/";
            cdY = cdI + "arFilterEditInit/";
            cdZ = cdW + "liveVideoFace/live_face_knead.json";
            cea = cdW + "liveVideoFace/goddess_face_knead.json";
            ceb = cdW + "liveVideoFace/baby_face_knead.json";
        }
        cdN = cdJ + "global";
        cdR = cdJ + "vip_list.json";
        cdQ = cdJ + "filters";
        cdM = cdJ + "dlModels/";
        cdP = cdQ + "/all";
        cdO = cdJ + "global/res/filter";
    }

    public static String acf() {
        return cdU;
    }

    public static String acg() {
        return cdI;
    }

    public static String ach() {
        return cdJ;
    }

    public static String aci() {
        return cdL;
    }

    public static String acj() {
        return cdN;
    }

    public static String ack() {
        return "/filter_config.json";
    }

    public static String acl() {
        return hc(0);
    }

    public static String hc(int i) {
        if (i == 1) {
            return cea;
        }
        if (i == 2) {
            return ceb;
        }
        return cdZ;
    }

    public static String dS(boolean z) {
        return z ? cdX : cdY;
    }
}
