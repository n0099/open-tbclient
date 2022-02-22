package c.a.s0.a.w0;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9735b;

    /* renamed from: c  reason: collision with root package name */
    public String f9736c;

    /* renamed from: d  reason: collision with root package name */
    public String f9737d;

    /* renamed from: e  reason: collision with root package name */
    public long f9738e;

    /* renamed from: f  reason: collision with root package name */
    public int f9739f;

    /* renamed from: g  reason: collision with root package name */
    public String f9740g;

    /* renamed from: h  reason: collision with root package name */
    public int f9741h;

    /* renamed from: i  reason: collision with root package name */
    public String f9742i;

    /* renamed from: j  reason: collision with root package name */
    public String f9743j;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static c a(@NonNull c.a.s0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.a = bVar.H();
            cVar.f9736c = bVar.K();
            cVar.f9737d = bVar.Q();
            cVar.f9739f = bVar.G();
            cVar.f9742i = bVar.T();
            cVar.f9741h = bVar.p1();
            cVar.f9738e = System.currentTimeMillis();
            cVar.f9740g = String.valueOf(bVar.getType());
            cVar.f9735b = bVar.I();
            cVar.f9743j = bVar.v1();
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.a = jSONObject.optString("bundle_id");
            cVar.f9738e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f9735b = optJSONObject.optString("appkey");
                cVar.f9740g = optJSONObject.optString("pkg_type");
                cVar.f9736c = optJSONObject.optString("app_name");
                cVar.f9737d = optJSONObject.optString("app_icon");
                cVar.f9743j = optJSONObject.optString("version_code");
                cVar.f9739f = optJSONObject.optInt("frame_type");
                cVar.f9741h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
