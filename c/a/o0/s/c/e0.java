package c.a.o0.s.c;

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
    public boolean f11187b;

    /* renamed from: c  reason: collision with root package name */
    public int f11188c;

    /* renamed from: d  reason: collision with root package name */
    public int f11189d;

    /* renamed from: e  reason: collision with root package name */
    public String f11190e;

    /* renamed from: f  reason: collision with root package name */
    public String f11191f;

    /* renamed from: g  reason: collision with root package name */
    public String f11192g;

    /* renamed from: h  reason: collision with root package name */
    public int f11193h;
    public String i;

    public e0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f11187b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f11188c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f11189d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f11190e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f11191f = jSONObject.optString("downloadNaniTxt", null);
        this.f11192g = jSONObject.optString("showNaniTailTxt", null);
        this.f11193h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
