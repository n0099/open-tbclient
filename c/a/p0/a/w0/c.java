package c.a.p0.a.w0;

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
    public String f8659b;

    /* renamed from: c  reason: collision with root package name */
    public String f8660c;

    /* renamed from: d  reason: collision with root package name */
    public String f8661d;

    /* renamed from: e  reason: collision with root package name */
    public long f8662e;

    /* renamed from: f  reason: collision with root package name */
    public int f8663f;

    /* renamed from: g  reason: collision with root package name */
    public String f8664g;

    /* renamed from: h  reason: collision with root package name */
    public int f8665h;

    /* renamed from: i  reason: collision with root package name */
    public String f8666i;

    /* renamed from: j  reason: collision with root package name */
    public String f8667j;

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
    public static c a(@NonNull c.a.p0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            c cVar = new c();
            cVar.a = bVar.H();
            cVar.f8660c = bVar.K();
            cVar.f8661d = bVar.Q();
            cVar.f8663f = bVar.G();
            cVar.f8666i = bVar.T();
            cVar.f8665h = bVar.p1();
            cVar.f8662e = System.currentTimeMillis();
            cVar.f8664g = String.valueOf(bVar.getType());
            cVar.f8659b = bVar.I();
            cVar.f8667j = bVar.v1();
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
            cVar.f8662e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f8659b = optJSONObject.optString("appkey");
                cVar.f8664g = optJSONObject.optString("pkg_type");
                cVar.f8660c = optJSONObject.optString("app_name");
                cVar.f8661d = optJSONObject.optString("app_icon");
                cVar.f8667j = optJSONObject.optString("version_code");
                cVar.f8663f = optJSONObject.optInt("frame_type");
                cVar.f8665h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
