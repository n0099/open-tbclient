package c.a.n0.a.z0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.s.b.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean X;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public String K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public String T;
    public boolean U;
    public String V;
    public String W;
    public String j;
    public boolean k;
    public String l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public int r;
    public boolean s;
    public String t;
    public String u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376099644, "Lc/a/n0/a/z0/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-376099644, "Lc/a/n0/a/z0/g/c;");
                return;
            }
        }
        X = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("video", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = "";
        this.k = false;
        this.l = "";
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = "";
        this.r = 0;
        this.t = "";
        this.u = "";
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = "";
        this.z = "";
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = "";
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static c h(JSONObject jSONObject, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cVar)) == null) {
            c cVar2 = new c();
            if (jSONObject != null) {
                cVar2.e(jSONObject, cVar);
                cVar2.j = jSONObject.optString("componentId", cVar.j);
                cVar2.o = jSONObject.optBoolean("autoplay", cVar.o);
                cVar2.k = jSONObject.optBoolean("muted", cVar.k);
                cVar2.q = jSONObject.optString("objectFit", cVar.q);
                cVar2.m = jSONObject.optInt("initialTime", cVar.m);
                cVar2.l = jSONObject.optString("poster", cVar.l);
                cVar2.r = jSONObject.optInt("position", cVar.r);
                cVar2.s = jSONObject.optBoolean("fullScreen", cVar.s);
                cVar2.t = p(jSONObject);
                cVar2.u = jSONObject.optString("danmuList", cVar.u);
                cVar2.v = jSONObject.optBoolean("enableDanmu", cVar.v);
                cVar2.w = jSONObject.optBoolean("danmuBtn", cVar.w);
                cVar2.p = jSONObject.optBoolean("loop", cVar.p);
                cVar2.x = jSONObject.optBoolean("controls", cVar.x);
                cVar2.y = q(jSONObject.optString("src", cVar.y));
                cVar2.I = !c.a.n0.a.e2.b.E(jSONObject.optString("src", cVar.y));
                cVar2.A = jSONObject.optBoolean("showPlayBtn", cVar.A);
                cVar2.B = jSONObject.optBoolean("showMuteBtn", cVar.B);
                cVar2.C = jSONObject.optBoolean("showCenterPlayBtn", cVar.C);
                cVar2.D = jSONObject.optBoolean("pageGesture", cVar.D);
                cVar2.E = jSONObject.optBoolean("showProgress", cVar.E);
                cVar2.F = jSONObject.optInt("direction", cVar.F);
                cVar2.G = jSONObject.optBoolean("showFullscreenBtn", cVar.G);
                cVar2.H = jSONObject.optBoolean("enableProgressGesture", cVar.H);
                cVar2.z = jSONObject.optString("componentId", cVar.z);
                cVar2.J = jSONObject.optBoolean("showNoWifiTip", cVar.J);
                cVar2.K = jSONObject.optString("title", cVar.K);
                cVar2.L = jSONObject.optBoolean("enablePlayGesture", cVar.L);
                cVar2.M = jSONObject.optBoolean("vslideGestureInFullscreen", cVar.M);
                cVar2.N = jSONObject.optBoolean("customEnterExitFullScreen", cVar.N);
                cVar2.P = jSONObject.optBoolean("showRateBtn", cVar.P);
                cVar2.Q = jSONObject.optBoolean("isFullscreen", cVar.Q);
                cVar2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", cVar.O);
                cVar2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", cVar.R);
                cVar2.S = jSONObject.optBoolean("silentPlay", cVar.S);
                cVar2.T = jSONObject.optString("preload", cVar.T);
                cVar2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", cVar.U);
                cVar2.V = jSONObject.optString("silentPlayTips", cVar.V);
                cVar2.W = jSONObject.optString("rate", cVar.W);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("text", jSONObject.optString("text"));
                jSONObject2.putOpt("color", jSONObject.optString("color"));
                jSONObject2.putOpt("componentId", jSONObject.optString("componentId"));
            } catch (JSONException e2) {
                if (X) {
                    e2.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (!c.a.n0.a.e2.b.E(str) || e.L() == null) ? str : c.a.n0.a.e2.b.H(str, e.L()) : (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.equals("auto", this.T) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.f6100f : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s.b.b
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
