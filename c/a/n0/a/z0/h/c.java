package c.a.n0.a.z0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.s.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public b B;
    public boolean C;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376069853, "Lc/a/n0/a/z0/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-376069853, "Lc/a/n0/a/z0/h/c;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("vrvideo", "viewId");
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
        this.m = "0";
        this.n = false;
        this.o = false;
        this.p = 0;
        this.r = true;
        this.s = "";
        this.t = "";
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = true;
        this.A = true;
        this.B = new b();
        this.C = true;
    }

    public static c h(JSONObject jSONObject, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cVar)) == null) {
            c cVar2 = new c();
            if (jSONObject != null) {
                cVar2.e(jSONObject, cVar);
                cVar2.j = jSONObject.optString("videoId", cVar.j);
                cVar2.n = jSONObject.optBoolean("autoplay", cVar.n);
                cVar2.k = jSONObject.optBoolean("muted", cVar.k);
                cVar2.m = jSONObject.optString("initialTime", cVar.m);
                cVar2.l = jSONObject.optString("poster", cVar.l);
                cVar2.p = jSONObject.optInt("position", cVar.p);
                cVar2.q = jSONObject.optBoolean("fullScreen", cVar.q);
                cVar2.o = jSONObject.optBoolean("loop", cVar.o);
                cVar2.r = jSONObject.optBoolean("controls", cVar.r);
                cVar2.s = i(jSONObject.optString("src", cVar.s));
                cVar2.A = !c.a.n0.a.e2.b.E(jSONObject.optString("src", cVar.s));
                cVar2.u = jSONObject.optBoolean("showPlayBtn", cVar.u);
                cVar2.v = jSONObject.optBoolean("showMuteBtn", cVar.v);
                cVar2.w = jSONObject.optBoolean("showCenterPlayBtn", cVar.w);
                cVar2.x = jSONObject.optBoolean("showProgress", cVar.x);
                cVar2.z = jSONObject.optBoolean("showFullscreenBtn", cVar.z);
                cVar2.t = jSONObject.optString("sanId", cVar.t);
                cVar2.B = cVar2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                cVar2.C = jSONObject.optBoolean("showNoWifiTip", cVar.C);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!c.a.n0.a.e2.b.E(str) || e.L() == null) ? str : c.a.n0.a.e2.b.H(str, e.L()) : (String) invokeL.objValue;
    }

    @Override // c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s.b.b
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
