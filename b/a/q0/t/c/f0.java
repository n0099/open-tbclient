package b.a.q0.t.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13772a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13773b;

    /* renamed from: c  reason: collision with root package name */
    public int f13774c;

    /* renamed from: d  reason: collision with root package name */
    public int f13775d;

    /* renamed from: e  reason: collision with root package name */
    public String f13776e;

    /* renamed from: f  reason: collision with root package name */
    public String f13777f;

    /* renamed from: g  reason: collision with root package name */
    public String f13778g;

    /* renamed from: h  reason: collision with root package name */
    public int f13779h;

    /* renamed from: i  reason: collision with root package name */
    public String f13780i;

    public f0() {
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
        this.f13772a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f13773b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f13774c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f13775d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f13776e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f13777f = jSONObject.optString("downloadNaniTxt", null);
        this.f13778g = jSONObject.optString("showNaniTailTxt", null);
        this.f13779h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f13780i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
