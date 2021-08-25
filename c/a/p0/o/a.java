package c.a.p0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13664a;

    /* renamed from: b  reason: collision with root package name */
    public int f13665b;

    /* renamed from: c  reason: collision with root package name */
    public int f13666c;

    /* renamed from: d  reason: collision with root package name */
    public int f13667d;

    /* renamed from: e  reason: collision with root package name */
    public int f13668e;

    /* renamed from: f  reason: collision with root package name */
    public int f13669f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13670g;

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
        this.f13664a = 300;
        this.f13665b = 5000;
        this.f13666c = 10000;
        this.f13667d = 1500;
        this.f13668e = 3000;
        this.f13669f = 6000;
        this.f13670g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("wifiSlow", -1);
            if (optInt > 0) {
                this.f13664a = optInt;
            }
            int optInt2 = jSONObject.optInt("threeGSlow", -1);
            if (optInt2 > 0) {
                this.f13665b = optInt2;
            }
            int optInt3 = jSONObject.optInt("twoGSlow", -1);
            if (optInt3 > 0) {
                this.f13666c = optInt3;
            }
            int optInt4 = jSONObject.optInt("wifiLog", -1);
            if (optInt4 > 0) {
                this.f13667d = optInt4;
            }
            int optInt5 = jSONObject.optInt("threeGLog", -1);
            if (optInt5 > 0) {
                this.f13668e = optInt5;
            }
            int optInt6 = jSONObject.optInt("twoGLog", -1);
            if (optInt6 > 0) {
                this.f13669f = optInt6;
            }
            boolean z = true;
            if (jSONObject.optInt("mobile_cdn_switch", 1) != 1) {
                z = false;
            }
            this.f13670g = z;
        } catch (Exception unused) {
        }
    }
}
