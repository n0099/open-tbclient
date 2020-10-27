package com.baidu.minivideo.arface;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes15.dex */
public class c {
    private static String bUA;
    private static String bUB;
    private static String bUi;
    private static String bUj;
    private static String bUk;
    private static String bUl;
    private static String bUm;
    private static String bUn;
    private static String bUp;
    private static String bUq;
    private static String bUr;
    private static String bUs;
    private static String bUt;
    private static String bUu;
    private static String bUv;
    private static String bUw;
    private static String bUx;
    private static String bUy;
    private static String bUz;
    public static String bUf = "arface_main_res_version";
    public static int bUg = 0;
    public static boolean bUh = true;
    public static String bUo = "global/res/filter";

    public c(String str) {
        setPath(str);
    }

    private static void setPath(String str) {
        if (b.isDebug()) {
            Log.d("DUAR_DuArResConfig", "setPath: " + str);
        }
        bUi = str + "/";
        bUj = bUi;
        bUk = bUi + "ext/";
        bUl = bUj + "faceModels/";
        if (TextUtils.isEmpty(str)) {
            bUu = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
            bUs = "file:///android_asset/arsource/filter/beauty_skin_stream.png";
            bUt = "file:///android_asset/arsource/filter/beauty_skin_small_video.png";
            bUl = "file:///android_asset/arsource/faceModels/";
            String str2 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
            bUv = str2 + "/makeup";
            bUw = str2 + "/beauty";
            bUx = str2 + "/arFilterInit";
            bUy = str2 + "/arFilterEditInit";
            bUz = bUw + "/liveVideoFace/live_face_knead.json";
            bUA = bUw + "/liveVideoFace/goddess_face_knead.json";
            bUB = bUw + "/liveVideoFace/baby_face_knead.json";
        } else {
            bUu = bUj + "filters/yuantu/yuantu.png";
            bUs = bUj + "filter/beauty_skin_stream.png";
            bUt = bUj + "filter/beauty_skin_small_video.png";
            bUv = bUi + "makeup/";
            bUw = bUi + "beauty/";
            bUx = bUi + "arFilterInit/";
            bUy = bUi + "arFilterEditInit/";
            bUz = bUw + "liveVideoFace/live_face_knead.json";
            bUA = bUw + "liveVideoFace/goddess_face_knead.json";
            bUB = bUw + "liveVideoFace/baby_face_knead.json";
        }
        bUn = bUj + "global";
        bUr = bUj + "vip_list.json";
        bUq = bUj + "filters";
        bUm = bUj + "dlModels/";
        bUp = bUq + "/all";
        bUo = bUj + "global/res/filter";
    }

    public static String XH() {
        return bUu;
    }

    public static String XI() {
        return bUj;
    }

    public static String XJ() {
        return bUl;
    }

    public static String XK() {
        return bUn;
    }

    public static String XL() {
        return "/filter_config.json";
    }

    public static String XM() {
        return gy(0);
    }

    public static String gy(int i) {
        if (i == 1) {
            return bUA;
        }
        if (i == 2) {
            return bUB;
        }
        return bUz;
    }

    public static String dt(boolean z) {
        return z ? bUx : bUy;
    }
}
