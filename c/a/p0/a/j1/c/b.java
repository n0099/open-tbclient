package c.a.p0.a.j1.c;

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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f6413b;

    /* renamed from: c  reason: collision with root package name */
    public String f6414c;

    /* renamed from: d  reason: collision with root package name */
    public int f6415d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6416e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6417f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6418g;

    /* renamed from: h  reason: collision with root package name */
    public int f6419h;

    /* renamed from: i  reason: collision with root package name */
    public float f6420i;

    /* renamed from: j  reason: collision with root package name */
    public String f6421j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1404581258, "Lc/a/p0/a/j1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1404581258, "Lc/a/p0/a/j1/c/b;");
                return;
            }
        }
        boolean z = k.a;
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
        this.a = "";
        this.f6413b = "";
        this.f6414c = "";
        this.f6415d = 0;
        this.f6416e = false;
        this.f6417f = false;
        this.f6418g = true;
        this.f6419h = 0;
        this.f6420i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f6413b = jSONObject.optString("slaveId", bVar.f6413b);
                bVar2.f6416e = jSONObject.optBoolean("autoplay", bVar.f6416e);
                bVar2.f6417f = jSONObject.optBoolean("loop", bVar.f6417f);
                bVar2.f6414c = jSONObject.optString("src", bVar.f6414c);
                bVar2.f6415d = jSONObject.optInt("startTime", bVar.f6415d);
                bVar2.f6418g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6418g);
                bVar2.f6419h = jSONObject.optInt("position", bVar.f6419h);
                bVar2.f6420i = (float) jSONObject.optDouble("volume", bVar.f6420i);
                bVar2.f6421j = jSONObject.optString("cb", bVar.f6421j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.a + "; slaveId : " + this.f6413b + "; url : " + this.f6414c + "; AutoPlay : " + this.f6416e + "; Loop : " + this.f6417f + "; startTime : " + this.f6415d + "; ObeyMute : " + this.f6418g + "; pos : " + this.f6419h;
        }
        return (String) invokeV.objValue;
    }
}
