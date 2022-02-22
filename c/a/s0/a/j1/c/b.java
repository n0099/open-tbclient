package c.a.s0.a.j1.c;

import android.text.TextUtils;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
    public String f7534b;

    /* renamed from: c  reason: collision with root package name */
    public String f7535c;

    /* renamed from: d  reason: collision with root package name */
    public int f7536d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7537e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7538f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7539g;

    /* renamed from: h  reason: collision with root package name */
    public int f7540h;

    /* renamed from: i  reason: collision with root package name */
    public float f7541i;

    /* renamed from: j  reason: collision with root package name */
    public String f7542j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1017333101, "Lc/a/s0/a/j1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1017333101, "Lc/a/s0/a/j1/c/b;");
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
        this.f7534b = "";
        this.f7535c = "";
        this.f7536d = 0;
        this.f7537e = false;
        this.f7538f = false;
        this.f7539g = true;
        this.f7540h = 0;
        this.f7541i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f7534b = jSONObject.optString("slaveId", bVar.f7534b);
                bVar2.f7537e = jSONObject.optBoolean("autoplay", bVar.f7537e);
                bVar2.f7538f = jSONObject.optBoolean("loop", bVar.f7538f);
                bVar2.f7535c = jSONObject.optString("src", bVar.f7535c);
                bVar2.f7536d = jSONObject.optInt(FetchLog.START_TIME, bVar.f7536d);
                bVar2.f7539g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f7539g);
                bVar2.f7540h = jSONObject.optInt("position", bVar.f7540h);
                bVar2.f7541i = (float) jSONObject.optDouble("volume", bVar.f7541i);
                bVar2.f7542j = jSONObject.optString("cb", bVar.f7542j);
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
            return "playerId : " + this.a + "; slaveId : " + this.f7534b + "; url : " + this.f7535c + "; AutoPlay : " + this.f7537e + "; Loop : " + this.f7538f + "; startTime : " + this.f7536d + "; ObeyMute : " + this.f7539g + "; pos : " + this.f7540h;
        }
        return (String) invokeV.objValue;
    }
}
