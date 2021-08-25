package c.a.o0.h.f0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11203a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.h.f0.i.d f11204b;

    /* renamed from: c  reason: collision with root package name */
    public int f11205c;

    /* renamed from: d  reason: collision with root package name */
    public long f11206d;

    public a(int i2, c.a.o0.h.f0.i.d dVar) {
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
        this.f11203a = i2;
        this.f11204b = dVar;
        this.f11205c = h.d() ? 20 : 10;
        this.f11206d = System.currentTimeMillis();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f11203a);
                jSONObject.put("stage", this.f11205c);
                jSONObject.put("ts", this.f11206d);
                if (this.f11204b != null) {
                    jSONObject.put("msg", this.f11204b.a());
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
