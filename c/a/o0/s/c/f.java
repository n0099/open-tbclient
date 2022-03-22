package c.a.o0.s.c;

import c.a.p0.b2.o.h.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements c.a.p0.b2.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11194b;

    /* renamed from: c  reason: collision with root package name */
    public String f11195c;

    /* renamed from: d  reason: collision with root package name */
    public String f11196d;

    /* renamed from: e  reason: collision with root package name */
    public String f11197e;

    /* renamed from: f  reason: collision with root package name */
    public String f11198f;

    /* renamed from: g  reason: collision with root package name */
    public String f11199g;

    /* renamed from: h  reason: collision with root package name */
    public String f11200h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public String o;
    public b.a p;
    public int q;
    public String r;

    public f() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNull(this.a) && StringUtils.isNull(this.j) && StringUtils.isNull(this.l)) {
                return true;
            }
            if (c()) {
                return StringUtils.isNull(this.f11195c) || StringUtils.isNull(this.f11196d);
            }
            return StringUtils.isNull(this.f11194b);
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !"0".equals(this.r) : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "dynamic".equals(this.f11197e) : invokeV.booleanValue;
    }

    public final JSONArray d(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("url");
        this.f11194b = jSONObject.optString("icon_url");
        this.f11195c = jSONObject.optString("fold_lottie");
        this.f11196d = jSONObject.optString("unfold_lottie");
        this.f11197e = jSONObject.optString("float_type");
        jSONObject.optString("fold_name");
        jSONObject.optString("unfold_name");
        this.f11200h = jSONObject.optString("view_statistics_url");
        this.i = jSONObject.optString("click_statistics_url");
        this.j = jSONObject.optString("scheme");
        this.k = jSONObject.optString("package_name");
        this.l = jSONObject.optString("deeplink");
        this.n = jSONObject.optInt("source", 1);
        this.m = jSONObject.optString("ext_info");
        this.o = jSONObject.optString(LegoListActivityConfig.AD_ID);
        this.r = jSONObject.optString("display_ad_icon");
        b.a aVar = new b.a();
        this.p = aVar;
        aVar.a = jSONObject.optString("parallel_charge_url");
        this.p.f12509c = f(d(jSONObject, "show_urls"));
        this.p.f12510d = f(d(jSONObject, "click_urls"));
        String c2 = c.a.d.f.p.t.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        sb.append(c2 == null ? "" : c2.toLowerCase());
        sb.append("&OAID=");
        sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.f11200h)) {
            this.f11200h += sb2;
        }
        if (StringUtils.isNull(this.i)) {
            return;
        }
        this.i += sb2;
    }

    public final ArrayList<String> f(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        if (!StringUtils.isNull(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
                return arrayList;
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // c.a.p0.b2.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (b.a) invokeV.objValue;
    }
}
