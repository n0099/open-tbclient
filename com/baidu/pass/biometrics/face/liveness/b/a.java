package com.baidu.pass.biometrics.face.liveness.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.LiveStatService;
import com.baidu.pass.biometrics.base.utils.NetworkUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final String S = "a";

    /* renamed from: T  reason: collision with root package name */
    public static final String f1053T = "living_recog";
    public static final int U = 1;
    public static final int V = 0;
    public static final int W = -1;
    public static final int X = 1;
    public static final int Y = 0;
    public static final String Z = "-1";
    public static final String a0 = "eye";
    public static final String b0 = "mouth";
    public static final String c0 = "find_face";
    public static final String d0 = "find_eye";
    public static final String e0 = "find_mouth";
    public static final String f0 = "pass";
    public static final String g0 = "fail";
    public long E;
    public String c;
    public String a = "";
    public String b = "";
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public String k = "-1";
    public int l = -1;
    public float m = -1.0f;
    public int n = -1;
    public int o = 0;
    public String p = "-1";
    public int q = -1;
    public String r = "-1";
    public String s = "-1";
    public String t = "-1";
    public int u = 0;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public int y = 0;
    public int z = -1;
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public int D = -1;
    public long F = 0;
    public long G = 0;
    public long H = 0;
    public int I = 0;
    public long J = 0;
    public long K = 0;
    public long L = 0;
    public long M = 0;
    public long N = 0;
    public long O = 0;
    public long P = 0;
    public int Q = 0;
    public boolean R = false;

    public void a() {
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.O = 0L;
    }

    public void a(Context context) {
        HashMap hashMap = new HashMap();
        Log.w(S, "onStat");
        if (this.d != -1) {
            hashMap.put("camera_with_per", this.d + "");
        }
        if (this.e != -1) {
            hashMap.put("camera_open_per", this.e + "");
        }
        if (this.f != -1) {
            hashMap.put("net_get_potrt", this.f + "");
        }
        if (this.g != -1) {
            hashMap.put("find_face_last", this.g + "");
        }
        if (this.h != 0) {
            hashMap.put("find_face_num", this.h + "");
        }
        if (this.i != 0) {
            hashMap.put("living_pass_eye_num", this.i + "");
        }
        if (this.j != 0) {
            hashMap.put("living_pass_mouth_num", this.j + "");
        }
        if (this.k != "-1" && this.R) {
            hashMap.put("living_pass_type", this.k + "");
        }
        if (this.p != "-1") {
            hashMap.put("living_pass_period", this.p + "");
        }
        if (this.q != -1) {
            hashMap.put("get_idl_pic", this.q + "");
        }
        if (this.r != "-1") {
            hashMap.put("face_match_type", this.r + "");
        }
        if (this.s != "-1") {
            hashMap.put("click_close_type", this.s + "");
        }
        if (this.t != "-1") {
            hashMap.put("click_voice_type", this.t + "");
        }
        if (this.y != 0) {
            hashMap.put("tip_light_low_num", this.y + "");
        }
        if (this.u != 0) {
            hashMap.put("tip_distance_near_num", this.u + "");
        }
        if (this.v != 0) {
            hashMap.put("tip_distance_far_num", this.v + "");
        }
        if (this.w != 0) {
            hashMap.put("tip_eye_slope_num", this.w + "");
        }
        if (this.x != 0) {
            hashMap.put("tip_put_face_round_num", this.x + "");
        }
        if (this.z != -1) {
            hashMap.put("tip_overtime", this.z + "");
        }
        if (this.A != -1) {
            hashMap.put("tip_overtime_cancel", this.A + "");
        }
        if (this.B != -1) {
            hashMap.put("tip_overtime_retry", this.B + "");
        }
        if (this.C != -1) {
            hashMap.put("tip_overtime_again", this.C + "");
        }
        if (this.D != -1) {
            hashMap.put("tip_overtime_sure", this.D + "");
        }
        if (this.G != 0) {
            hashMap.put("time_camera_ready", (this.G - this.F) + "");
        }
        if (this.K != 0) {
            hashMap.put("time_find_face", (this.K - this.J) + "");
        }
        if (this.N != 0 && this.O != 0) {
            hashMap.put("time_mouth_pass", (this.O - this.N) + "");
        } else if (this.L != 0 && this.M != 0) {
            String str = S;
            Log.w(str, "timePointLivingEyePass:" + this.M + ",timePointStartFindFace" + this.L);
            StringBuilder sb = new StringBuilder();
            sb.append(this.M - this.L);
            sb.append("");
            hashMap.put("time_eyes_pass", sb.toString());
        }
        if (this.H != 0 && this.I != 0) {
            hashMap.put("time_idl_face_track", (this.H / this.I) + "");
        }
        if (this.O != 0) {
            hashMap.put("time_contrast", (this.P - this.O) + "");
        } else if (this.M != 0) {
            hashMap.put("time_contrast", (this.P - this.M) + "");
        }
        if (this.l != -1) {
            hashMap.put("white_bg", this.l + "");
        }
        hashMap.put("illum", this.m + "");
        hashMap.put("abtest_illum", this.n + "");
        hashMap.put("time_whole", (this.P - this.E) + "");
        hashMap.put("error_code", this.Q + "");
        hashMap.put("error_code_server", this.Q + "");
        hashMap.put("recog_type", this.a);
        hashMap.put("guide_liveness", this.o + "");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        hashMap.put("screen_size", i2 + "," + i);
        hashMap.put("os_ver", PassBiometricUtil.getOSVersion());
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("subpro", this.b);
        }
        hashMap.put("net_type", NetworkUtils.getNetworkClass(context));
        if (!TextUtils.isEmpty(this.c)) {
            hashMap.put("pre_size", this.c);
        }
        String str2 = S;
        Log.w(str2, "onStat|map|" + new JSONObject(hashMap));
        LiveStatService.onEvent(context, "living_recog", hashMap);
    }
}
