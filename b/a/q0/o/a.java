package b.a.q0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12772a;

    /* renamed from: b  reason: collision with root package name */
    public int f12773b;

    /* renamed from: c  reason: collision with root package name */
    public int f12774c;

    /* renamed from: d  reason: collision with root package name */
    public int f12775d;

    /* renamed from: e  reason: collision with root package name */
    public int f12776e;

    /* renamed from: f  reason: collision with root package name */
    public int f12777f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12778g;

    public a() {
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
        this.f12772a = 300;
        this.f12773b = 5000;
        this.f12774c = 10000;
        this.f12775d = 1500;
        this.f12776e = 3000;
        this.f12777f = 6000;
        this.f12778g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("wifiSlow", -1);
            if (optInt > 0) {
                this.f12772a = optInt;
            }
            int optInt2 = jSONObject.optInt("threeGSlow", -1);
            if (optInt2 > 0) {
                this.f12773b = optInt2;
            }
            int optInt3 = jSONObject.optInt("twoGSlow", -1);
            if (optInt3 > 0) {
                this.f12774c = optInt3;
            }
            int optInt4 = jSONObject.optInt("wifiLog", -1);
            if (optInt4 > 0) {
                this.f12775d = optInt4;
            }
            int optInt5 = jSONObject.optInt("threeGLog", -1);
            if (optInt5 > 0) {
                this.f12776e = optInt5;
            }
            int optInt6 = jSONObject.optInt("twoGLog", -1);
            if (optInt6 > 0) {
                this.f12777f = optInt6;
            }
            boolean z = true;
            if (jSONObject.optInt("mobile_cdn_switch", 1) != 1) {
                z = false;
            }
            this.f12778g = z;
        } catch (Exception unused) {
        }
    }
}
