package b.a.p0.a.i1.c;

import android.text.TextUtils;
import b.a.p0.a.k;
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
    public String f5917a;

    /* renamed from: b  reason: collision with root package name */
    public String f5918b;

    /* renamed from: c  reason: collision with root package name */
    public String f5919c;

    /* renamed from: d  reason: collision with root package name */
    public int f5920d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5921e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5922f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5923g;

    /* renamed from: h  reason: collision with root package name */
    public int f5924h;

    /* renamed from: i  reason: collision with root package name */
    public float f5925i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781550762, "Lb/a/p0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781550762, "Lb/a/p0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f6397a;
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
        this.f5917a = "";
        this.f5918b = "";
        this.f5919c = "";
        this.f5920d = 0;
        this.f5921e = false;
        this.f5922f = false;
        this.f5923g = true;
        this.f5924h = 0;
        this.f5925i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f5917a = jSONObject.optString("audioId", bVar.f5917a);
                bVar2.f5918b = jSONObject.optString("slaveId", bVar.f5918b);
                bVar2.f5921e = jSONObject.optBoolean("autoplay", bVar.f5921e);
                bVar2.f5922f = jSONObject.optBoolean("loop", bVar.f5922f);
                bVar2.f5919c = jSONObject.optString("src", bVar.f5919c);
                bVar2.f5920d = jSONObject.optInt("startTime", bVar.f5920d);
                bVar2.f5923g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f5923g);
                bVar2.f5924h = jSONObject.optInt("position", bVar.f5924h);
                bVar2.f5925i = (float) jSONObject.optDouble("volume", bVar.f5925i);
                bVar2.j = jSONObject.optString("cb", bVar.j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f5917a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f5917a + "; slaveId : " + this.f5918b + "; url : " + this.f5919c + "; AutoPlay : " + this.f5921e + "; Loop : " + this.f5922f + "; startTime : " + this.f5920d + "; ObeyMute : " + this.f5923g + "; pos : " + this.f5924h;
        }
        return (String) invokeV.objValue;
    }
}
