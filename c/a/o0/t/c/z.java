package c.a.o0.t.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14461a;

    /* renamed from: b  reason: collision with root package name */
    public int f14462b;

    /* renamed from: c  reason: collision with root package name */
    public int f14463c;

    /* renamed from: d  reason: collision with root package name */
    public int f14464d;

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14461a = 0;
        this.f14462b = 0;
        this.f14463c = 0;
        this.f14464d = 0;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14461a = jSONObject.optInt("days_new_user", 0);
        this.f14462b = jSONObject.optInt("days_low_active", 0);
        this.f14463c = jSONObject.optInt("limit_day", 0);
        this.f14464d = jSONObject.optInt("limit_count", 0);
    }
}
