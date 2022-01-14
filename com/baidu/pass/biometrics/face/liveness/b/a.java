package com.baidu.pass.biometrics.face.liveness.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.LiveStatService;
import com.baidu.pass.biometrics.base.utils.NetworkUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String S = "a";
    public static final String T = "living_recog";
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
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public long E;
    public long F;
    public long G;
    public long H;
    public int I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public int Q;
    public boolean R;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f37560b;

    /* renamed from: c  reason: collision with root package name */
    public String f37561c;

    /* renamed from: d  reason: collision with root package name */
    public int f37562d;

    /* renamed from: e  reason: collision with root package name */
    public int f37563e;

    /* renamed from: f  reason: collision with root package name */
    public int f37564f;

    /* renamed from: g  reason: collision with root package name */
    public int f37565g;

    /* renamed from: h  reason: collision with root package name */
    public int f37566h;

    /* renamed from: i  reason: collision with root package name */
    public int f37567i;

    /* renamed from: j  reason: collision with root package name */
    public int f37568j;
    public String k;
    public int l;
    public float m;
    public int n;
    public int o;
    public String p;
    public int q;
    public String r;
    public String s;
    public String t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1791470533, "Lcom/baidu/pass/biometrics/face/liveness/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1791470533, "Lcom/baidu/pass/biometrics/face/liveness/b/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f37560b = "";
        this.f37562d = -1;
        this.f37563e = -1;
        this.f37564f = -1;
        this.f37565g = -1;
        this.f37566h = 0;
        this.f37567i = 0;
        this.f37568j = 0;
        this.k = "-1";
        this.l = -1;
        this.m = -1.0f;
        this.n = -1;
        this.o = 0;
        this.p = "-1";
        this.q = -1;
        this.r = "-1";
        this.s = "-1";
        this.t = "-1";
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.Q = 0;
        this.R = false;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.J = 0L;
            this.K = 0L;
            this.L = 0L;
            this.M = 0L;
            this.N = 0L;
            this.O = 0L;
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            HashMap hashMap = new HashMap();
            Log.w(S, "onStat");
            if (this.f37562d != -1) {
                hashMap.put("camera_with_per", this.f37562d + "");
            }
            if (this.f37563e != -1) {
                hashMap.put("camera_open_per", this.f37563e + "");
            }
            if (this.f37564f != -1) {
                hashMap.put("net_get_potrt", this.f37564f + "");
            }
            if (this.f37565g != -1) {
                hashMap.put("find_face_last", this.f37565g + "");
            }
            if (this.f37566h != 0) {
                hashMap.put("find_face_num", this.f37566h + "");
            }
            if (this.f37567i != 0) {
                hashMap.put("living_pass_eye_num", this.f37567i + "");
            }
            if (this.f37568j != 0) {
                hashMap.put("living_pass_mouth_num", this.f37568j + "");
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
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            int i3 = displayMetrics.widthPixels;
            hashMap.put("screen_size", i3 + "," + i2);
            hashMap.put("os_ver", PassBiometricUtil.getOSVersion());
            if (!TextUtils.isEmpty(this.f37560b)) {
                hashMap.put("subpro", this.f37560b);
            }
            hashMap.put("net_type", NetworkUtils.getNetworkClass(context));
            if (!TextUtils.isEmpty(this.f37561c)) {
                hashMap.put("pre_size", this.f37561c);
            }
            String str2 = S;
            Log.w(str2, "onStat|map|" + new JSONObject(hashMap));
            LiveStatService.onEvent(context, "living_recog", hashMap);
        }
    }
}
