package c.a.r0.a.w0;

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
    public String f9493b;

    /* renamed from: c  reason: collision with root package name */
    public String f9494c;

    /* renamed from: d  reason: collision with root package name */
    public String f9495d;

    /* renamed from: e  reason: collision with root package name */
    public long f9496e;

    /* renamed from: f  reason: collision with root package name */
    public int f9497f;

    /* renamed from: g  reason: collision with root package name */
    public String f9498g;

    /* renamed from: h  reason: collision with root package name */
    public int f9499h;

    /* renamed from: i  reason: collision with root package name */
    public String f9500i;

    /* renamed from: j  reason: collision with root package name */
    public String f9501j;

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
    public static c a(@NonNull c.a.r0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.a = bVar.H();
            cVar.f9494c = bVar.K();
            cVar.f9495d = bVar.Q();
            cVar.f9497f = bVar.G();
            cVar.f9500i = bVar.T();
            cVar.f9499h = bVar.p1();
            cVar.f9496e = System.currentTimeMillis();
            cVar.f9498g = String.valueOf(bVar.getType());
            cVar.f9493b = bVar.I();
            cVar.f9501j = bVar.v1();
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
            cVar.f9496e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f9493b = optJSONObject.optString("appkey");
                cVar.f9498g = optJSONObject.optString("pkg_type");
                cVar.f9494c = optJSONObject.optString("app_name");
                cVar.f9495d = optJSONObject.optString("app_icon");
                cVar.f9501j = optJSONObject.optString("version_code");
                cVar.f9497f = optJSONObject.optInt("frame_type");
                cVar.f9499h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
