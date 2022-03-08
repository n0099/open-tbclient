package c.a.q0.s.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13631b;

    /* renamed from: c  reason: collision with root package name */
    public int f13632c;

    /* renamed from: d  reason: collision with root package name */
    public int f13633d;

    /* renamed from: e  reason: collision with root package name */
    public String f13634e;

    /* renamed from: f  reason: collision with root package name */
    public String f13635f;

    /* renamed from: g  reason: collision with root package name */
    public String f13636g;

    /* renamed from: h  reason: collision with root package name */
    public int f13637h;

    /* renamed from: i  reason: collision with root package name */
    public String f13638i;

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
        this.a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f13631b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f13632c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f13633d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f13634e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f13635f = jSONObject.optString("downloadNaniTxt", null);
        this.f13636g = jSONObject.optString("showNaniTailTxt", null);
        this.f13637h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f13638i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
