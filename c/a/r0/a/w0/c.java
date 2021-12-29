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
    public String f9703b;

    /* renamed from: c  reason: collision with root package name */
    public String f9704c;

    /* renamed from: d  reason: collision with root package name */
    public String f9705d;

    /* renamed from: e  reason: collision with root package name */
    public long f9706e;

    /* renamed from: f  reason: collision with root package name */
    public int f9707f;

    /* renamed from: g  reason: collision with root package name */
    public String f9708g;

    /* renamed from: h  reason: collision with root package name */
    public int f9709h;

    /* renamed from: i  reason: collision with root package name */
    public String f9710i;

    /* renamed from: j  reason: collision with root package name */
    public String f9711j;

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
            cVar.f9704c = bVar.K();
            cVar.f9705d = bVar.Q();
            cVar.f9707f = bVar.G();
            cVar.f9710i = bVar.T();
            cVar.f9709h = bVar.p1();
            cVar.f9706e = System.currentTimeMillis();
            cVar.f9708g = String.valueOf(bVar.getType());
            cVar.f9703b = bVar.I();
            cVar.f9711j = bVar.v1();
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
            cVar.f9706e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cVar.f9703b = optJSONObject.optString("appkey");
                cVar.f9708g = optJSONObject.optString("pkg_type");
                cVar.f9704c = optJSONObject.optString("app_name");
                cVar.f9705d = optJSONObject.optString("app_icon");
                cVar.f9711j = optJSONObject.optString("version_code");
                cVar.f9707f = optJSONObject.optInt("frame_type");
                cVar.f9709h = optJSONObject.optInt("pay_protected");
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
