package c.a.q0.a.j1.c;

import android.text.TextUtils;
import c.a.q0.a.k;
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
    public String f6722b;

    /* renamed from: c  reason: collision with root package name */
    public String f6723c;

    /* renamed from: d  reason: collision with root package name */
    public int f6724d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6725e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6726f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6727g;

    /* renamed from: h  reason: collision with root package name */
    public int f6728h;

    /* renamed from: i  reason: collision with root package name */
    public float f6729i;

    /* renamed from: j  reason: collision with root package name */
    public String f6730j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1275498539, "Lc/a/q0/a/j1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1275498539, "Lc/a/q0/a/j1/c/b;");
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
        this.f6722b = "";
        this.f6723c = "";
        this.f6724d = 0;
        this.f6725e = false;
        this.f6726f = false;
        this.f6727g = true;
        this.f6728h = 0;
        this.f6729i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f6722b = jSONObject.optString("slaveId", bVar.f6722b);
                bVar2.f6725e = jSONObject.optBoolean("autoplay", bVar.f6725e);
                bVar2.f6726f = jSONObject.optBoolean("loop", bVar.f6726f);
                bVar2.f6723c = jSONObject.optString("src", bVar.f6723c);
                bVar2.f6724d = jSONObject.optInt("startTime", bVar.f6724d);
                bVar2.f6727g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6727g);
                bVar2.f6728h = jSONObject.optInt("position", bVar.f6728h);
                bVar2.f6729i = (float) jSONObject.optDouble("volume", bVar.f6729i);
                bVar2.f6730j = jSONObject.optString("cb", bVar.f6730j);
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
            return "playerId : " + this.a + "; slaveId : " + this.f6722b + "; url : " + this.f6723c + "; AutoPlay : " + this.f6725e + "; Loop : " + this.f6726f + "; startTime : " + this.f6724d + "; ObeyMute : " + this.f6727g + "; pos : " + this.f6728h;
        }
        return (String) invokeV.objValue;
    }
}
