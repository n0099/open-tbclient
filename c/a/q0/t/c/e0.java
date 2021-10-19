package c.a.q0.t.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14666a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14667b;

    /* renamed from: c  reason: collision with root package name */
    public int f14668c;

    /* renamed from: d  reason: collision with root package name */
    public int f14669d;

    /* renamed from: e  reason: collision with root package name */
    public String f14670e;

    /* renamed from: f  reason: collision with root package name */
    public String f14671f;

    /* renamed from: g  reason: collision with root package name */
    public String f14672g;

    /* renamed from: h  reason: collision with root package name */
    public int f14673h;

    /* renamed from: i  reason: collision with root package name */
    public String f14674i;

    public e0() {
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
        this.f14666a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f14667b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f14668c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f14669d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f14670e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f14671f = jSONObject.optString("downloadNaniTxt", null);
        this.f14672g = jSONObject.optString("showNaniTailTxt", null);
        this.f14673h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f14674i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
