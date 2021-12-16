package c.a.r0.t.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13668b;

    /* renamed from: c  reason: collision with root package name */
    public int f13669c;

    /* renamed from: d  reason: collision with root package name */
    public int f13670d;

    /* renamed from: e  reason: collision with root package name */
    public String f13671e;

    /* renamed from: f  reason: collision with root package name */
    public String f13672f;

    /* renamed from: g  reason: collision with root package name */
    public String f13673g;

    /* renamed from: h  reason: collision with root package name */
    public int f13674h;

    /* renamed from: i  reason: collision with root package name */
    public String f13675i;

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
        this.f13668b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f13669c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f13670d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f13671e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f13672f = jSONObject.optString("downloadNaniTxt", null);
        this.f13673g = jSONObject.optString("showNaniTailTxt", null);
        this.f13674h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f13675i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
