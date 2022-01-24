package c.a.r0.a.j1.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.r0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public String O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public String X;
    public boolean Y;
    public String Z;
    public String a0;
    public String n;
    public boolean o;
    public String p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1146296625, "Lc/a/r0/a/j1/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1146296625, "Lc/a/r0/a/j1/g/c;");
                return;
            }
        }
        b0 = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("video", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = "";
        this.o = false;
        this.p = "";
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = "";
        this.v = 0;
        this.x = "";
        this.y = "";
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = "";
        this.D = "";
        this.H = false;
        this.I = true;
        this.J = -1;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = "";
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = true;
        this.U = false;
        this.V = true;
        this.W = false;
        this.X = "";
        this.Y = true;
        this.Z = "";
        this.a0 = "";
    }

    public static c i(JSONObject jSONObject, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cVar)) == null) {
            c cVar2 = new c();
            if (jSONObject != null) {
                cVar2.f(jSONObject, cVar);
                cVar2.n = jSONObject.optString("componentId", cVar.n);
                cVar2.s = jSONObject.optBoolean("autoplay", cVar.s);
                cVar2.o = jSONObject.optBoolean("muted", cVar.o);
                cVar2.u = jSONObject.optString("objectFit", cVar.u);
                cVar2.q = jSONObject.optInt("initialTime", cVar.q);
                cVar2.p = jSONObject.optString("poster", cVar.p);
                cVar2.v = jSONObject.optInt("position", cVar.v);
                cVar2.w = jSONObject.optBoolean("fullScreen", cVar.w);
                cVar2.x = q(jSONObject);
                cVar2.y = jSONObject.optString("danmuList", cVar.y);
                cVar2.z = jSONObject.optBoolean("enableDanmu", cVar.z);
                cVar2.A = jSONObject.optBoolean("danmuBtn", cVar.A);
                cVar2.t = jSONObject.optBoolean("loop", cVar.t);
                cVar2.B = jSONObject.optBoolean("controls", cVar.B);
                cVar2.C = r(jSONObject.optString("src", cVar.C));
                cVar2.M = !c.a.r0.a.o2.b.E(jSONObject.optString("src", cVar.C));
                cVar2.E = jSONObject.optBoolean("showPlayBtn", cVar.E);
                cVar2.F = jSONObject.optBoolean("showMuteBtn", cVar.F);
                cVar2.G = jSONObject.optBoolean("showCenterPlayBtn", cVar.G);
                cVar2.H = jSONObject.optBoolean("pageGesture", cVar.H);
                cVar2.I = jSONObject.optBoolean("showProgress", cVar.I);
                cVar2.J = jSONObject.optInt("direction", cVar.J);
                cVar2.K = jSONObject.optBoolean("showFullscreenBtn", cVar.K);
                cVar2.L = jSONObject.optBoolean("enableProgressGesture", cVar.L);
                cVar2.D = jSONObject.optString("componentId", cVar.D);
                cVar2.N = jSONObject.optBoolean("showNoWifiTip", cVar.N);
                cVar2.O = jSONObject.optString("title", cVar.O);
                cVar2.P = jSONObject.optBoolean("enablePlayGesture", cVar.P);
                cVar2.Q = jSONObject.optBoolean("vslideGestureInFullscreen", cVar.Q);
                cVar2.R = jSONObject.optBoolean("customEnterExitFullScreen", cVar.R);
                cVar2.T = jSONObject.optBoolean("showRateBtn", cVar.T);
                cVar2.U = jSONObject.optBoolean("isFullscreen", cVar.U);
                cVar2.S = jSONObject.optBoolean("isAlwaysOnlyShowTopView", cVar.S);
                cVar2.V = jSONObject.optBoolean("showVslideBtnInFullscreen", cVar.V);
                cVar2.W = jSONObject.optBoolean("silentPlay", cVar.W);
                cVar2.X = jSONObject.optString("preload", cVar.X);
                cVar2.Y = jSONObject.optBoolean("showSilentPlayMutedIcon", cVar.Y);
                cVar2.Z = jSONObject.optString("silentPlayTips", cVar.Z);
                cVar2.a0 = jSONObject.optString("rate", cVar.a0);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    public static String q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("text", jSONObject.optString("text"));
                jSONObject2.putOpt("color", jSONObject.optString("color"));
                jSONObject2.putOpt("componentId", jSONObject.optString("componentId"));
            } catch (JSONException e2) {
                if (b0) {
                    e2.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (!c.a.r0.a.o2.b.E(str) || e.L() == null) ? str : c.a.r0.a.o2.b.H(str, e.L()) : (String) invokeL.objValue;
    }

    @Override // c.a.r0.a.c0.b.b, c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.n) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.equals("auto", this.X) : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.f5454j : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.c0.b.b
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.n + ExtendedMessageFormat.QUOTE + ", mMute=" + this.o + ", mPoster='" + this.p + ExtendedMessageFormat.QUOTE + ", mInitialTime=" + this.q + ", duration=" + this.r + ", mAutoPlay=" + this.s + ", mLoop=" + this.t + ", mObjectFit='" + this.u + ExtendedMessageFormat.QUOTE + ", mPos=" + this.v + ", mFullScreen=" + this.w + ", mDanmu='" + this.x + ExtendedMessageFormat.QUOTE + ", mDanmuList='" + this.y + ExtendedMessageFormat.QUOTE + ", mEnableDanmu=" + this.z + ", mShowDanmuBtn=" + this.A + ", mShowControlPanel=" + this.B + ", mSrc='" + this.C + ExtendedMessageFormat.QUOTE + ", mSanId='" + this.D + ExtendedMessageFormat.QUOTE + ", mShowPlayBtn=" + this.E + ", mShowMuteBtn=" + this.F + ", mShowCenterPlayBtn=" + this.G + ", mPageGesture=" + this.H + ", mShowProgress=" + this.I + ", mDirection=" + this.J + ", mShowFullscreenBtn=" + this.K + ", mEnableProgressGesture=" + this.L + ", mIsRemoteFile=" + this.M + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
