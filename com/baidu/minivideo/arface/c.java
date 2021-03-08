package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public class c {
    private static String clA;
    private static String clB;
    private static String clC;
    private static String clD;
    private static String clk;
    private static String cll;
    private static String clm;
    private static String cln;
    private static String clo;
    private static String clp;
    private static String clr;
    private static String cls;
    private static String clt;
    private static String clu;
    private static String clv;
    private static String clw;
    private static String clx;
    private static String cly;
    private static String clz;
    public static String clh = "arface_main_res_version";
    public static int cli = 0;
    public static boolean clj = true;
    public static String clq = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DuAr_DuArResConfig", "setPath: " + str);
        }
        clk = str + "/";
        cll = clk;
        clm = clk + "ext/";
        cln = cll + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            clw = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            clu = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            clv = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            cln = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            clx = str2 + "/makeup";
            cly = str2 + "/beauty";
            clz = str2 + "/arFilterInit";
            clA = str2 + "/arFilterEditInit";
            clB = cly + "/liveVideoFace/live_face_knead.json";
            clC = cly + "/liveVideoFace/goddess_face_knead.json";
            clD = cly + "/liveVideoFace/baby_face_knead.json";
        } else {
            clw = cll + "filters/yuantu/yuantu.png";
            clu = cll + "filter/beauty_skin_stream.png";
            clv = cll + "filter/beauty_skin_small_video.png";
            clx = clk + "makeup/";
            cly = clk + "beauty/";
            clz = clk + "arFilterInit/";
            clA = clk + "arFilterEditInit/";
            clB = cly + "liveVideoFace/live_face_knead.json";
            clC = cly + "liveVideoFace/goddess_face_knead.json";
            clD = cly + "liveVideoFace/baby_face_knead.json";
        }
        clp = cll + "global";
        clt = cll + "vip_list.json";
        cls = cll + "filters";
        clo = cll + "dlModels/";
        clr = cls + "/all";
        clq = cll + "global/res/filter";
    }

    public static String abS() {
        return clw;
    }

    public static String abT() {
        return clk;
    }

    public static String abU() {
        return cll;
    }

    public static String abV() {
        return cln;
    }

    public static String abW() {
        return clp;
    }

    public static String abX() {
        return "/filter_config.json";
    }

    public static String abY() {
        return fB(0);
    }

    public static String fB(int i) {
        if (i == 1) {
            return clC;
        }
        if (i == 2) {
            return clD;
        }
        return clB;
    }

    public static String ed(boolean z) {
        return z ? clz : clA;
    }
}
