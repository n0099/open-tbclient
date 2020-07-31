package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class c {
    private static String bwa;
    private static String bwb;
    private static String bwc;
    private static String bwd;
    private static String bwe;
    private static String bwf;
    private static String bwh;
    private static String bwi;
    private static String bwj;
    private static String bwk;
    private static String bwl;
    private static String bwm;
    private static String bwn;
    private static String bwo;
    private static String bwp;
    private static String bwq;
    private static String bwr;
    private static String bws;
    private static String bwt;
    public static String bvX = "arface_main_res_version";
    public static int bvY = 0;
    public static boolean bvZ = true;
    public static String bwg = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        bwa = str + "/";
        bwb = bwa;
        bwc = bwa + "ext/";
        bwd = bwb + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bwm = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bwk = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bwl = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bwd = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bwn = str2 + "/makeup";
            bwo = str2 + "/beauty";
            bwp = str2 + "/arFilterInit";
            bwq = str2 + "/arFilterEditInit";
            bwr = bwo + "/liveVideoFace/live_face_knead.json";
            bws = bwo + "/liveVideoFace/goddess_face_knead.json";
            bwt = bwo + "/liveVideoFace/baby_face_knead.json";
        } else {
            bwm = bwb + "filters/yuantu/yuantu.png";
            bwk = bwb + "filter/beauty_skin_stream.png";
            bwl = bwb + "filter/beauty_skin_small_video.png";
            bwn = bwa + "makeup/";
            bwo = bwa + "beauty/";
            bwp = bwa + "arFilterInit/";
            bwq = bwa + "arFilterEditInit/";
            bwr = bwo + "liveVideoFace/live_face_knead.json";
            bws = bwo + "liveVideoFace/goddess_face_knead.json";
            bwt = bwo + "liveVideoFace/baby_face_knead.json";
        }
        bwf = bwb + "global";
        bwj = bwb + "vip_list.json";
        bwi = bwb + "filters";
        bwe = bwb + "dlModels/";
        bwh = bwi + "/all";
        bwg = bwb + "global/res/filter";
    }

    public static String Nj() {
        return bwm;
    }

    public static String Nk() {
        return bwb;
    }

    public static String Nl() {
        return bwd;
    }

    public static String Nm() {
        return bwf;
    }

    public static String Nn() {
        return "/filter_config.json";
    }

    public static String No() {
        return dO(0);
    }

    public static String dO(int i) {
        if (i == 1) {
            return bws;
        }
        if (i == 2) {
            return bwt;
        }
        return bwr;
    }

    public static String cO(boolean z) {
        return z ? bwp : bwq;
    }
}
