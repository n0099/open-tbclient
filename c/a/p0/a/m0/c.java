package c.a.p0.a.m0;

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
    public String f6463b;

    /* renamed from: c  reason: collision with root package name */
    public String f6464c;

    /* renamed from: d  reason: collision with root package name */
    public String f6465d;

    /* renamed from: e  reason: collision with root package name */
    public long f6466e;

    /* renamed from: f  reason: collision with root package name */
    public int f6467f;

    /* renamed from: g  reason: collision with root package name */
    public String f6468g;

    /* renamed from: h  reason: collision with root package name */
    public int f6469h;

    /* renamed from: i  reason: collision with root package name */
    public String f6470i;

    /* renamed from: j  reason: collision with root package name */
    public String f6471j;

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
    public static c a(@NonNull c.a.p0.a.v0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.a = bVar.H();
            cVar.f6464c = bVar.K();
            cVar.f6465d = bVar.Q();
            cVar.f6467f = bVar.G();
            cVar.f6470i = bVar.T();
            cVar.f6469h = bVar.p1();
            cVar.f6466e = System.currentTimeMillis();
            cVar.f6468g = String.valueOf(bVar.getType());
            cVar.f6463b = bVar.I();
            cVar.f6471j = bVar.v1();
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
            cVar.f6466e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f6463b = optJSONObject.optString("appkey");
                cVar.f6468g = optJSONObject.optString("pkg_type");
                cVar.f6464c = optJSONObject.optString("app_name");
                cVar.f6465d = optJSONObject.optString("app_icon");
                cVar.f6471j = optJSONObject.optString("version_code");
                cVar.f6467f = optJSONObject.optInt("frame_type");
                cVar.f6469h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
