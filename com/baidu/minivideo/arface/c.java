package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c {
    private static String bFA;
    private static String bFB;
    private static String bFC;
    private static String bFj;
    private static String bFk;
    private static String bFl;
    private static String bFm;
    private static String bFn;
    private static String bFo;
    private static String bFq;
    private static String bFr;
    private static String bFs;
    private static String bFt;
    private static String bFu;
    private static String bFv;
    private static String bFw;
    private static String bFx;
    private static String bFy;
    private static String bFz;
    public static String bFg = "arface_main_res_version";
    public static int bFh = 0;
    public static boolean bFi = true;
    public static String bFp = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bFj = str + "/";
        bFk = bFj;
        bFl = bFj + "ext/";
        bFm = bFk + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bFv = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bFt = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bFu = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bFm = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bFw = str2 + "/makeup";
            bFx = str2 + "/beauty";
            bFy = str2 + "/arFilterInit";
            bFz = str2 + "/arFilterEditInit";
            bFA = bFx + "/liveVideoFace/live_face_knead.json";
            bFB = bFx + "/liveVideoFace/goddess_face_knead.json";
            bFC = bFx + "/liveVideoFace/baby_face_knead.json";
        } else {
            bFv = bFk + "filters/yuantu/yuantu.png";
            bFt = bFk + "filter/beauty_skin_stream.png";
            bFu = bFk + "filter/beauty_skin_small_video.png";
            bFw = bFj + "makeup/";
            bFx = bFj + "beauty/";
            bFy = bFj + "arFilterInit/";
            bFz = bFj + "arFilterEditInit/";
            bFA = bFx + "liveVideoFace/live_face_knead.json";
            bFB = bFx + "liveVideoFace/goddess_face_knead.json";
            bFC = bFx + "liveVideoFace/baby_face_knead.json";
        }
        bFo = bFk + "global";
        bFs = bFk + "vip_list.json";
        bFr = bFk + "filters";
        bFn = bFk + "dlModels/";
        bFq = bFr + "/all";
        bFp = bFk + "global/res/filter";
    }

    public static String TU() {
        return bFv;
    }

    public static String TV() {
        return bFk;
    }

    public static String TW() {
        return bFm;
    }

    public static String TX() {
        return bFo;
    }

    public static String TY() {
        return "/filter_config.json";
    }

    public static String TZ() {
        return fT(0);
    }

    public static String fT(int i) {
        if (i == 1) {
            return bFB;
        }
        if (i == 2) {
            return bFC;
        }
        return bFA;
    }

    public static String cY(boolean z) {
        return z ? bFy : bFz;
    }
}
