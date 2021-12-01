package c.a.q0.t.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13331b;

    /* renamed from: c  reason: collision with root package name */
    public int f13332c;

    /* renamed from: d  reason: collision with root package name */
    public int f13333d;

    /* renamed from: e  reason: collision with root package name */
    public String f13334e;

    /* renamed from: f  reason: collision with root package name */
    public String f13335f;

    /* renamed from: g  reason: collision with root package name */
    public String f13336g;

    /* renamed from: h  reason: collision with root package name */
    public int f13337h;

    /* renamed from: i  reason: collision with root package name */
    public String f13338i;

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
        this.a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f13331b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f13332c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f13333d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f13334e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f13335f = jSONObject.optString("downloadNaniTxt", null);
        this.f13336g = jSONObject.optString("showNaniTailTxt", null);
        this.f13337h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f13338i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
