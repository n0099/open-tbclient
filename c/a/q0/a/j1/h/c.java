package c.a.q0.a.j1.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.q0.a.d2.e;
import c.a.q0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.q0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public b F;
    public boolean G;
    public String n;
    public boolean o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public String w;
    public String x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1275349553, "Lc/a/q0/a/j1/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1275349553, "Lc/a/q0/a/j1/h/c;");
                return;
            }
        }
        boolean z = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("vrvideo", "viewId");
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
        this.q = "0";
        this.r = false;
        this.s = false;
        this.t = 0;
        this.v = true;
        this.w = "";
        this.x = "";
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.C = -1;
        this.D = true;
        this.E = true;
        this.F = new b();
        this.G = true;
    }

    public static c i(JSONObject jSONObject, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cVar)) == null) {
            c cVar2 = new c();
            if (jSONObject != null) {
                cVar2.f(jSONObject, cVar);
                cVar2.n = jSONObject.optString("videoId", cVar.n);
                cVar2.r = jSONObject.optBoolean("autoplay", cVar.r);
                cVar2.o = jSONObject.optBoolean("muted", cVar.o);
                cVar2.q = jSONObject.optString("initialTime", cVar.q);
                cVar2.p = jSONObject.optString("poster", cVar.p);
                cVar2.t = jSONObject.optInt("position", cVar.t);
                cVar2.u = jSONObject.optBoolean("fullScreen", cVar.u);
                cVar2.s = jSONObject.optBoolean("loop", cVar.s);
                cVar2.v = jSONObject.optBoolean("controls", cVar.v);
                cVar2.w = j(jSONObject.optString("src", cVar.w));
                cVar2.E = !c.a.q0.a.o2.b.E(jSONObject.optString("src", cVar.w));
                cVar2.y = jSONObject.optBoolean("showPlayBtn", cVar.y);
                cVar2.z = jSONObject.optBoolean("showMuteBtn", cVar.z);
                cVar2.A = jSONObject.optBoolean("showCenterPlayBtn", cVar.A);
                cVar2.B = jSONObject.optBoolean("showProgress", cVar.B);
                cVar2.D = jSONObject.optBoolean("showFullscreenBtn", cVar.D);
                cVar2.x = jSONObject.optString("sanId", cVar.x);
                cVar2.F = cVar2.F.a(jSONObject.optJSONObject("vrVideoMode"));
                cVar2.G = jSONObject.optBoolean("showNoWifiTip", cVar.G);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!c.a.q0.a.o2.b.E(str) || e.L() == null) ? str : c.a.q0.a.o2.b.H(str, e.L()) : (String) invokeL.objValue;
    }

    @Override // c.a.q0.a.c0.b.b, c.a.q0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.n) : invokeV.booleanValue;
    }

    @Override // c.a.q0.a.c0.b.b
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.n + ExtendedMessageFormat.QUOTE + ", mMute=" + this.o + ", mPoster='" + this.p + ExtendedMessageFormat.QUOTE + ", mInitialTime=" + this.q + ", mAutoPlay=" + this.r + ", mShowNoWifiTip=" + this.G + ", mLoop=" + this.s + ", mPos=" + this.t + ", mFullScreen=" + this.u + ", mShowControlPanel=" + this.v + ", mSrc='" + this.w + ExtendedMessageFormat.QUOTE + ", mSanId='" + this.x + ExtendedMessageFormat.QUOTE + ", mShowPlayBtn=" + this.y + ", mShowMuteBtn=" + this.z + ", mShowCenterPlayBtn=" + this.A + ", mShowProgress=" + this.B + ", mDirection=" + this.C + ", mShowFullscreenBtn=" + this.D + ", mIsRemoteFile=" + this.E + ", mVrVideoMode=" + this.F.toString() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
