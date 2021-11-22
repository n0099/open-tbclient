package b.a.p0.a.w0;

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

    /* renamed from: a  reason: collision with root package name */
    public String f9179a;

    /* renamed from: b  reason: collision with root package name */
    public String f9180b;

    /* renamed from: c  reason: collision with root package name */
    public String f9181c;

    /* renamed from: d  reason: collision with root package name */
    public String f9182d;

    /* renamed from: e  reason: collision with root package name */
    public long f9183e;

    /* renamed from: f  reason: collision with root package name */
    public int f9184f;

    /* renamed from: g  reason: collision with root package name */
    public String f9185g;

    /* renamed from: h  reason: collision with root package name */
    public int f9186h;

    /* renamed from: i  reason: collision with root package name */
    public String f9187i;
    public String j;

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
    public static c a(@NonNull b.a.p0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.f9179a = bVar.H();
            cVar.f9181c = bVar.K();
            cVar.f9182d = bVar.Q();
            cVar.f9184f = bVar.G();
            cVar.f9187i = bVar.T();
            cVar.f9186h = bVar.p1();
            cVar.f9183e = System.currentTimeMillis();
            cVar.f9185g = String.valueOf(bVar.getType());
            cVar.f9180b = bVar.I();
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
            cVar.f9179a = jSONObject.optString("bundle_id");
            cVar.f9183e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f9180b = optJSONObject.optString("appkey");
                cVar.f9185g = optJSONObject.optString("pkg_type");
                cVar.f9181c = optJSONObject.optString("app_name");
                cVar.f9182d = optJSONObject.optString("app_icon");
                cVar.j = optJSONObject.optString("version_code");
                cVar.f9184f = optJSONObject.optInt("frame_type");
                cVar.f9186h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
