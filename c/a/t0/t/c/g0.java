package c.a.t0.t.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14242b;

    /* renamed from: c  reason: collision with root package name */
    public int f14243c;

    /* renamed from: d  reason: collision with root package name */
    public int f14244d;

    /* renamed from: e  reason: collision with root package name */
    public String f14245e;

    /* renamed from: f  reason: collision with root package name */
    public String f14246f;

    /* renamed from: g  reason: collision with root package name */
    public String f14247g;

    /* renamed from: h  reason: collision with root package name */
    public int f14248h;

    /* renamed from: i  reason: collision with root package name */
    public String f14249i;

    public g0() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f14242b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f14243c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f14244d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f14245e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f14246f = jSONObject.optString("downloadNaniTxt", null);
        this.f14247g = jSONObject.optString("showNaniTailTxt", null);
        this.f14248h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f14249i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
