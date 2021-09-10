package c.a.p0.a.i1.c;

import android.text.TextUtils;
import c.a.p0.a.k;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6583a;

    /* renamed from: b  reason: collision with root package name */
    public String f6584b;

    /* renamed from: c  reason: collision with root package name */
    public String f6585c;

    /* renamed from: d  reason: collision with root package name */
    public int f6586d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6587e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6588f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6589g;

    /* renamed from: h  reason: collision with root package name */
    public int f6590h;

    /* renamed from: i  reason: collision with root package name */
    public float f6591i;

    /* renamed from: j  reason: collision with root package name */
    public String f6592j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2002882357, "Lc/a/p0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2002882357, "Lc/a/p0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f7077a;
    }

    public b() {
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
        this.f6583a = "";
        this.f6584b = "";
        this.f6585c = "";
        this.f6586d = 0;
        this.f6587e = false;
        this.f6588f = false;
        this.f6589g = true;
        this.f6590h = 0;
        this.f6591i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f6583a = jSONObject.optString("audioId", bVar.f6583a);
                bVar2.f6584b = jSONObject.optString("slaveId", bVar.f6584b);
                bVar2.f6587e = jSONObject.optBoolean("autoplay", bVar.f6587e);
                bVar2.f6588f = jSONObject.optBoolean("loop", bVar.f6588f);
                bVar2.f6585c = jSONObject.optString("src", bVar.f6585c);
                bVar2.f6586d = jSONObject.optInt("startTime", bVar.f6586d);
                bVar2.f6589g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6589g);
                bVar2.f6590h = jSONObject.optInt("position", bVar.f6590h);
                bVar2.f6591i = (float) jSONObject.optDouble("volume", bVar.f6591i);
                bVar2.f6592j = jSONObject.optString("cb", bVar.f6592j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f6583a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f6583a + "; slaveId : " + this.f6584b + "; url : " + this.f6585c + "; AutoPlay : " + this.f6587e + "; Loop : " + this.f6588f + "; startTime : " + this.f6586d + "; ObeyMute : " + this.f6589g + "; pos : " + this.f6590h;
        }
        return (String) invokeV.objValue;
    }
}
