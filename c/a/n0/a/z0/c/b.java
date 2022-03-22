package c.a.n0.a.z0.c;

import android.text.TextUtils;
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
    public String f7771b;

    /* renamed from: c  reason: collision with root package name */
    public String f7772c;

    /* renamed from: d  reason: collision with root package name */
    public int f7773d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7774e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7775f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7776g;

    /* renamed from: h  reason: collision with root package name */
    public int f7777h;
    public float i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376218839, "Lc/a/n0/a/z0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-376218839, "Lc/a/n0/a/z0/c/b;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f7771b = "";
        this.f7772c = "";
        this.f7773d = 0;
        this.f7774e = false;
        this.f7775f = false;
        this.f7776g = true;
        this.f7777h = 0;
        this.i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f7771b = jSONObject.optString("slaveId", bVar.f7771b);
                bVar2.f7774e = jSONObject.optBoolean("autoplay", bVar.f7774e);
                bVar2.f7775f = jSONObject.optBoolean("loop", bVar.f7775f);
                bVar2.f7772c = jSONObject.optString("src", bVar.f7772c);
                bVar2.f7773d = jSONObject.optInt(FetchLog.START_TIME, bVar.f7773d);
                bVar2.f7776g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f7776g);
                bVar2.f7777h = jSONObject.optInt("position", bVar.f7777h);
                bVar2.i = (float) jSONObject.optDouble("volume", bVar.i);
                bVar2.j = jSONObject.optString("cb", bVar.j);
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
            return "playerId : " + this.a + "; slaveId : " + this.f7771b + "; url : " + this.f7772c + "; AutoPlay : " + this.f7774e + "; Loop : " + this.f7775f + "; startTime : " + this.f7773d + "; ObeyMute : " + this.f7776g + "; pos : " + this.f7777h;
        }
        return (String) invokeV.objValue;
    }
}
