package c.a.q0.a.w0;

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
    public String f8968b;

    /* renamed from: c  reason: collision with root package name */
    public String f8969c;

    /* renamed from: d  reason: collision with root package name */
    public String f8970d;

    /* renamed from: e  reason: collision with root package name */
    public long f8971e;

    /* renamed from: f  reason: collision with root package name */
    public int f8972f;

    /* renamed from: g  reason: collision with root package name */
    public String f8973g;

    /* renamed from: h  reason: collision with root package name */
    public int f8974h;

    /* renamed from: i  reason: collision with root package name */
    public String f8975i;

    /* renamed from: j  reason: collision with root package name */
    public String f8976j;

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
    public static c a(@NonNull c.a.q0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.a = bVar.H();
            cVar.f8969c = bVar.K();
            cVar.f8970d = bVar.Q();
            cVar.f8972f = bVar.G();
            cVar.f8975i = bVar.T();
            cVar.f8974h = bVar.p1();
            cVar.f8971e = System.currentTimeMillis();
            cVar.f8973g = String.valueOf(bVar.getType());
            cVar.f8968b = bVar.I();
            cVar.f8976j = bVar.v1();
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
            cVar.f8971e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f8968b = optJSONObject.optString("appkey");
                cVar.f8973g = optJSONObject.optString("pkg_type");
                cVar.f8969c = optJSONObject.optString("app_name");
                cVar.f8970d = optJSONObject.optString("app_icon");
                cVar.f8976j = optJSONObject.optString("version_code");
                cVar.f8972f = optJSONObject.optInt("frame_type");
                cVar.f8974h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
