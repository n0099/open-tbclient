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
    public String f9635b;

    /* renamed from: c  reason: collision with root package name */
    public String f9636c;

    /* renamed from: d  reason: collision with root package name */
    public String f9637d;

    /* renamed from: e  reason: collision with root package name */
    public long f9638e;

    /* renamed from: f  reason: collision with root package name */
    public int f9639f;

    /* renamed from: g  reason: collision with root package name */
    public String f9640g;

    /* renamed from: h  reason: collision with root package name */
    public int f9641h;

    /* renamed from: i  reason: collision with root package name */
    public String f9642i;

    /* renamed from: j  reason: collision with root package name */
    public String f9643j;

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
            cVar.f9636c = bVar.K();
            cVar.f9637d = bVar.Q();
            cVar.f9639f = bVar.G();
            cVar.f9642i = bVar.T();
            cVar.f9641h = bVar.p1();
            cVar.f9638e = System.currentTimeMillis();
            cVar.f9640g = String.valueOf(bVar.getType());
            cVar.f9635b = bVar.I();
            cVar.f9643j = bVar.v1();
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
            cVar.f9638e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f9635b = optJSONObject.optString("appkey");
                cVar.f9640g = optJSONObject.optString("pkg_type");
                cVar.f9636c = optJSONObject.optString("app_name");
                cVar.f9637d = optJSONObject.optString("app_icon");
                cVar.f9643j = optJSONObject.optString("version_code");
                cVar.f9639f = optJSONObject.optInt("frame_type");
                cVar.f9641h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
