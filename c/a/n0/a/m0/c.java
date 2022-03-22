package c.a.n0.a.m0;

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
    public String f5429b;

    /* renamed from: c  reason: collision with root package name */
    public String f5430c;

    /* renamed from: d  reason: collision with root package name */
    public String f5431d;

    /* renamed from: e  reason: collision with root package name */
    public long f5432e;

    /* renamed from: f  reason: collision with root package name */
    public int f5433f;

    /* renamed from: g  reason: collision with root package name */
    public String f5434g;

    /* renamed from: h  reason: collision with root package name */
    public int f5435h;
    public String i;
    public String j;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static c a(@NonNull c.a.n0.a.v0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.a = bVar.H();
            cVar.f5430c = bVar.K();
            cVar.f5431d = bVar.Q();
            cVar.f5433f = bVar.G();
            cVar.i = bVar.T();
            cVar.f5435h = bVar.p1();
            cVar.f5432e = System.currentTimeMillis();
            cVar.f5434g = String.valueOf(bVar.getType());
            cVar.f5429b = bVar.I();
            cVar.j = bVar.v1();
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
            cVar.f5432e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f5429b = optJSONObject.optString("appkey");
                cVar.f5434g = optJSONObject.optString("pkg_type");
                cVar.f5430c = optJSONObject.optString("app_name");
                cVar.f5431d = optJSONObject.optString("app_icon");
                cVar.j = optJSONObject.optString("version_code");
                cVar.f5433f = optJSONObject.optInt("frame_type");
                cVar.f5435h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
