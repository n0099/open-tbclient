package c.a.o0.a.i1.c;

import android.text.TextUtils;
import c.a.o0.a.k;
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
    public String f6555a;

    /* renamed from: b  reason: collision with root package name */
    public String f6556b;

    /* renamed from: c  reason: collision with root package name */
    public String f6557c;

    /* renamed from: d  reason: collision with root package name */
    public int f6558d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6561g;

    /* renamed from: h  reason: collision with root package name */
    public int f6562h;

    /* renamed from: i  reason: collision with root package name */
    public float f6563i;

    /* renamed from: j  reason: collision with root package name */
    public String f6564j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1873799638, "Lc/a/o0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1873799638, "Lc/a/o0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f7049a;
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
        this.f6555a = "";
        this.f6556b = "";
        this.f6557c = "";
        this.f6558d = 0;
        this.f6559e = false;
        this.f6560f = false;
        this.f6561g = true;
        this.f6562h = 0;
        this.f6563i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f6555a = jSONObject.optString("audioId", bVar.f6555a);
                bVar2.f6556b = jSONObject.optString("slaveId", bVar.f6556b);
                bVar2.f6559e = jSONObject.optBoolean("autoplay", bVar.f6559e);
                bVar2.f6560f = jSONObject.optBoolean("loop", bVar.f6560f);
                bVar2.f6557c = jSONObject.optString("src", bVar.f6557c);
                bVar2.f6558d = jSONObject.optInt("startTime", bVar.f6558d);
                bVar2.f6561g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6561g);
                bVar2.f6562h = jSONObject.optInt("position", bVar.f6562h);
                bVar2.f6563i = (float) jSONObject.optDouble("volume", bVar.f6563i);
                bVar2.f6564j = jSONObject.optString("cb", bVar.f6564j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f6555a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f6555a + "; slaveId : " + this.f6556b + "; url : " + this.f6557c + "; AutoPlay : " + this.f6559e + "; Loop : " + this.f6560f + "; startTime : " + this.f6558d + "; ObeyMute : " + this.f6561g + "; pos : " + this.f6562h;
        }
        return (String) invokeV.objValue;
    }
}
