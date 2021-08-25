package c.a.p0.t.c;

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
    public int f14772a;

    /* renamed from: b  reason: collision with root package name */
    public int f14773b;

    /* renamed from: c  reason: collision with root package name */
    public int f14774c;

    /* renamed from: d  reason: collision with root package name */
    public int f14775d;

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
        this.f14772a = 0;
        this.f14773b = 0;
        this.f14774c = 0;
        this.f14775d = 0;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14772a = jSONObject.optInt("days_new_user", 0);
        this.f14773b = jSONObject.optInt("days_low_active", 0);
        this.f14774c = jSONObject.optInt("limit_day", 0);
        this.f14775d = jSONObject.optInt("limit_count", 0);
    }
}
