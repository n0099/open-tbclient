package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes14.dex */
public class c {
    private static String bYA;
    private static String bYh;
    private static String bYi;
    private static String bYj;
    private static String bYk;
    private static String bYl;
    private static String bYm;
    private static String bYo;
    private static String bYp;
    private static String bYq;
    private static String bYr;
    private static String bYs;
    private static String bYt;
    private static String bYu;
    private static String bYv;
    private static String bYw;
    private static String bYx;
    private static String bYy;
    private static String bYz;
    public static String bYe = "arface_main_res_version";
    public static int bYf = 0;
    public static boolean bYg = true;
    public static String bYn = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DUAR_DuArResConfig", "setPath: " + str);
        }
        bYh = str + "/";
        bYi = bYh;
        bYj = bYh + "ext/";
        bYk = bYi + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bYt = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bYr = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bYs = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bYk = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bYu = str2 + "/makeup";
            bYv = str2 + "/beauty";
            bYw = str2 + "/arFilterInit";
            bYx = str2 + "/arFilterEditInit";
            bYy = bYv + "/liveVideoFace/live_face_knead.json";
            bYz = bYv + "/liveVideoFace/goddess_face_knead.json";
            bYA = bYv + "/liveVideoFace/baby_face_knead.json";
        } else {
            bYt = bYi + "filters/yuantu/yuantu.png";
            bYr = bYi + "filter/beauty_skin_stream.png";
            bYs = bYi + "filter/beauty_skin_small_video.png";
            bYu = bYh + "makeup/";
            bYv = bYh + "beauty/";
            bYw = bYh + "arFilterInit/";
            bYx = bYh + "arFilterEditInit/";
            bYy = bYv + "liveVideoFace/live_face_knead.json";
            bYz = bYv + "liveVideoFace/goddess_face_knead.json";
            bYA = bYv + "liveVideoFace/baby_face_knead.json";
        }
        bYm = bYi + "global";
        bYq = bYi + "vip_list.json";
        bYp = bYi + "filters";
        bYl = bYi + "dlModels/";
        bYo = bYp + "/all";
        bYn = bYi + "global/res/filter";
    }

    public static String Zx() {
        return bYt;
    }

    public static String Zy() {
        return bYi;
    }

    public static String Zz() {
        return bYk;
    }

    public static String ZA() {
        return bYm;
    }

    public static String ZB() {
        return "/filter_config.json";
    }

    public static String ZC() {
        return gE(0);
    }

    public static String gE(int i) {
        if (i == 1) {
            return bYz;
        }
        if (i == 2) {
            return bYA;
        }
        return bYy;
    }

    public static String dC(boolean z) {
        return z ? bYw : bYx;
    }
}
