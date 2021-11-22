package b.a.p0.j.g0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11152a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.j.g0.i.d f11153b;

    /* renamed from: c  reason: collision with root package name */
    public int f11154c;

    /* renamed from: d  reason: collision with root package name */
    public long f11155d;

    public a(int i2, b.a.p0.j.g0.i.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11152a = i2;
        this.f11153b = dVar;
        this.f11154c = h.d() ? 20 : 10;
        this.f11155d = System.currentTimeMillis();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f11152a);
                jSONObject.put("stage", this.f11154c);
                jSONObject.put("ts", this.f11155d);
                if (this.f11153b != null) {
                    jSONObject.put("msg", this.f11153b.a());
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
