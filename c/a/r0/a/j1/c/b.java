package c.a.r0.a.j1.c;

import android.text.TextUtils;
import c.a.r0.a.k;
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
    public String f7434b;

    /* renamed from: c  reason: collision with root package name */
    public String f7435c;

    /* renamed from: d  reason: collision with root package name */
    public int f7436d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7437e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7438f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7439g;

    /* renamed from: h  reason: collision with root package name */
    public int f7440h;

    /* renamed from: i  reason: collision with root package name */
    public float f7441i;

    /* renamed from: j  reason: collision with root package name */
    public String f7442j;

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
        this.f7434b = "";
        this.f7435c = "";
        this.f7436d = 0;
        this.f7437e = false;
        this.f7438f = false;
        this.f7439g = true;
        this.f7440h = 0;
        this.f7441i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f7434b = jSONObject.optString("slaveId", bVar.f7434b);
                bVar2.f7437e = jSONObject.optBoolean("autoplay", bVar.f7437e);
                bVar2.f7438f = jSONObject.optBoolean("loop", bVar.f7438f);
                bVar2.f7435c = jSONObject.optString("src", bVar.f7435c);
                bVar2.f7436d = jSONObject.optInt(FetchLog.START_TIME, bVar.f7436d);
                bVar2.f7439g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f7439g);
                bVar2.f7440h = jSONObject.optInt("position", bVar.f7440h);
                bVar2.f7441i = (float) jSONObject.optDouble("volume", bVar.f7441i);
                bVar2.f7442j = jSONObject.optString("cb", bVar.f7442j);
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
            return "playerId : " + this.a + "; slaveId : " + this.f7434b + "; url : " + this.f7435c + "; AutoPlay : " + this.f7437e + "; Loop : " + this.f7438f + "; startTime : " + this.f7436d + "; ObeyMute : " + this.f7439g + "; pos : " + this.f7440h;
        }
        return (String) invokeV.objValue;
    }
}
