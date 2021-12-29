package c.a.r0.a.j1.c;

import android.text.TextUtils;
import c.a.r0.a.k;
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
    public String f7457b;

    /* renamed from: c  reason: collision with root package name */
    public String f7458c;

    /* renamed from: d  reason: collision with root package name */
    public int f7459d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7460e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7461f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7462g;

    /* renamed from: h  reason: collision with root package name */
    public int f7463h;

    /* renamed from: i  reason: collision with root package name */
    public float f7464i;

    /* renamed from: j  reason: collision with root package name */
    public String f7465j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1146415820, "Lc/a/r0/a/j1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1146415820, "Lc/a/r0/a/j1/c/b;");
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
        this.f7457b = "";
        this.f7458c = "";
        this.f7459d = 0;
        this.f7460e = false;
        this.f7461f = false;
        this.f7462g = true;
        this.f7463h = 0;
        this.f7464i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f7457b = jSONObject.optString("slaveId", bVar.f7457b);
                bVar2.f7460e = jSONObject.optBoolean("autoplay", bVar.f7460e);
                bVar2.f7461f = jSONObject.optBoolean("loop", bVar.f7461f);
                bVar2.f7458c = jSONObject.optString("src", bVar.f7458c);
                bVar2.f7459d = jSONObject.optInt("startTime", bVar.f7459d);
                bVar2.f7462g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f7462g);
                bVar2.f7463h = jSONObject.optInt("position", bVar.f7463h);
                bVar2.f7464i = (float) jSONObject.optDouble("volume", bVar.f7464i);
                bVar2.f7465j = jSONObject.optString("cb", bVar.f7465j);
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
            return "playerId : " + this.a + "; slaveId : " + this.f7457b + "; url : " + this.f7458c + "; AutoPlay : " + this.f7460e + "; Loop : " + this.f7461f + "; startTime : " + this.f7459d + "; ObeyMute : " + this.f7462g + "; pos : " + this.f7463h;
        }
        return (String) invokeV.objValue;
    }
}
