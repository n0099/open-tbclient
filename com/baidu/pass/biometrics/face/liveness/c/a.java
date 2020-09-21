package com.baidu.pass.biometrics.face.liveness.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.NetworkUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.StatService;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static final String a = "a";
    public static final String b = "living_recog";
    public static final int c = 1;
    public static final int d = 0;
    public static final int e = -1;
    public static final int f = 0;
    public static final String g = "-1";
    public static final String h = "eye";
    public static final String i = "mouth";
    public static final String j = "find_face";
    public static final String k = "find_eye";
    public static final String l = "find_mouth";
    public static final String m = "close";
    public static final String n = "open";
    public static final String o = "pass";
    public static final String p = "fail";
    public long U;
    public String s;
    public String q = "";
    public String r = "";
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = 0;
    public int y = 0;
    public int z = 0;
    public String A = "-1";
    public int B = -1;
    public float C = -1.0f;
    public int D = -1;
    public int E = 0;
    public String F = "-1";
    public int G = -1;
    public String H = "-1";
    public String I = "-1";
    public String J = "-1";
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public int O = 0;
    public int P = -1;
    public int Q = -1;
    public int R = -1;
    public int S = -1;
    public int T = -1;
    public long V = 0;
    public long W = 0;
    public long X = 0;
    public int Y = 0;
    public long Z = 0;
    public long aa = 0;
    public long ba = 0;
    public long ca = 0;
    public long da = 0;
    public long ea = 0;
    public long fa = 0;
    public int ga = 0;
    public boolean ha = false;

    public void a() {
        this.Z = 0L;
        this.aa = 0L;
        this.ba = 0L;
        this.ca = 0L;
        this.da = 0L;
        this.ea = 0L;
    }

    public void a(Context context) {
        HashMap hashMap = new HashMap();
        Log.w(a, "onStat");
        if (this.t != -1) {
            hashMap.put("camera_with_per", this.t + "");
        }
        if (this.u != -1) {
            hashMap.put("camera_open_per", this.u + "");
        }
        if (this.v != -1) {
            hashMap.put("net_get_potrt", this.v + "");
        }
        if (this.w != -1) {
            hashMap.put("find_face_last", this.w + "");
        }
        if (this.x != 0) {
            hashMap.put("find_face_num", this.x + "");
        }
        if (this.y != 0) {
            hashMap.put("living_pass_eye_num", this.y + "");
        }
        if (this.z != 0) {
            hashMap.put("living_pass_mouth_num", this.z + "");
        }
        if (this.A != "-1" && this.ha) {
            hashMap.put("living_pass_type", this.A + "");
        }
        if (this.F != "-1") {
            hashMap.put("living_pass_period", this.F + "");
        }
        if (this.G != -1) {
            hashMap.put("get_idl_pic", this.G + "");
        }
        if (this.H != "-1") {
            hashMap.put("face_match_type", this.H + "");
        }
        if (this.I != "-1") {
            hashMap.put("click_close_type", this.I + "");
        }
        if (this.J != "-1") {
            hashMap.put("click_voice_type", this.J + "");
        }
        if (this.O != 0) {
            hashMap.put("tip_light_low_num", this.O + "");
        }
        if (this.K != 0) {
            hashMap.put("tip_distance_near_num", this.K + "");
        }
        if (this.L != 0) {
            hashMap.put("tip_distance_far_num", this.L + "");
        }
        if (this.M != 0) {
            hashMap.put("tip_eye_slope_num", this.M + "");
        }
        if (this.N != 0) {
            hashMap.put("tip_put_face_round_num", this.N + "");
        }
        if (this.P != -1) {
            hashMap.put("tip_overtime", this.P + "");
        }
        if (this.Q != -1) {
            hashMap.put("tip_overtime_cancel", this.Q + "");
        }
        if (this.R != -1) {
            hashMap.put("tip_overtime_retry", this.R + "");
        }
        if (this.S != -1) {
            hashMap.put("tip_overtime_again", this.S + "");
        }
        if (this.T != -1) {
            hashMap.put("tip_overtime_sure", this.T + "");
        }
        if (this.W != 0) {
            hashMap.put("time_camera_ready", (this.W - this.V) + "");
        }
        if (this.aa != 0) {
            hashMap.put("time_find_face", (this.aa - this.Z) + "");
        }
        if (this.da != 0 && this.ea != 0) {
            hashMap.put("time_mouth_pass", (this.ea - this.da) + "");
        } else if (this.ba != 0 && this.ca != 0) {
            Log.w(a, "timePointLivingEyePass:" + this.ca + ",timePointStartFindFace" + this.ba);
            hashMap.put("time_eyes_pass", (this.ca - this.ba) + "");
        }
        if (this.X != 0 && this.Y != 0) {
            hashMap.put("time_idl_face_track", (this.X / this.Y) + "");
        }
        if (this.ea != 0) {
            hashMap.put("time_contrast", (this.fa - this.ea) + "");
        } else if (this.ca != 0) {
            hashMap.put("time_contrast", (this.fa - this.ca) + "");
        }
        if (this.B != -1) {
            hashMap.put("white_bg", this.B + "");
        }
        hashMap.put("illum", this.C + "");
        hashMap.put("abtest_illum", this.D + "");
        hashMap.put("time_whole", (this.fa - this.U) + "");
        hashMap.put("error_code", this.ga + "");
        hashMap.put("recog_type", this.q);
        hashMap.put("guide_liveness", this.E + "");
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        hashMap.put("screen_size", defaultDisplay.getWidth() + Constants.ACCEPT_TIME_SEPARATOR_SP + defaultDisplay.getHeight());
        hashMap.put("os_ver", PassBiometricUtil.getOSVersion());
        if (!TextUtils.isEmpty(this.r)) {
            hashMap.put("subpro", this.r);
        }
        hashMap.put("net_type", NetworkUtils.getNetworkClass(context));
        if (!TextUtils.isEmpty(this.s)) {
            hashMap.put("pre_size", this.s);
        }
        Log.w(a, "onStat|map|" + new JSONObject(hashMap));
        StatService.onEvent(context, b, hashMap);
    }
}
