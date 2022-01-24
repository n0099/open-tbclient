package c.a.s0.t.c;

import c.a.t0.y1.o.h.b;
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
/* loaded from: classes6.dex */
public class g implements c.a.t0.y1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f13972e;

    /* renamed from: f  reason: collision with root package name */
    public String f13973f;

    /* renamed from: g  reason: collision with root package name */
    public String f13974g;

    /* renamed from: h  reason: collision with root package name */
    public String f13975h;

    /* renamed from: i  reason: collision with root package name */
    public String f13976i;

    /* renamed from: j  reason: collision with root package name */
    public String f13977j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public b.a t;
    public int u;
    public String v;

    public g() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNull(this.f13972e) && StringUtils.isNull(this.n) && StringUtils.isNull(this.p)) {
                return true;
            }
            if (c()) {
                return StringUtils.isNull(this.f13974g) || StringUtils.isNull(this.f13975h);
            }
            return StringUtils.isNull(this.f13973f);
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !"0".equals(this.v) : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "dynamic".equals(this.f13976i) : invokeV.booleanValue;
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
        this.f13972e = jSONObject.optString("url");
        this.f13973f = jSONObject.optString("icon_url");
        this.f13974g = jSONObject.optString("fold_lottie");
        this.f13975h = jSONObject.optString("unfold_lottie");
        this.f13976i = jSONObject.optString("float_type");
        jSONObject.optString("fold_name");
        jSONObject.optString("unfold_name");
        this.l = jSONObject.optString("view_statistics_url");
        this.m = jSONObject.optString("click_statistics_url");
        this.n = jSONObject.optString("scheme");
        this.o = jSONObject.optString("package_name");
        this.p = jSONObject.optString("deeplink");
        this.r = jSONObject.optInt("source", 1);
        this.q = jSONObject.optString("ext_info");
        this.s = jSONObject.optString(LegoListActivityConfig.AD_ID);
        this.v = jSONObject.optString("display_ad_icon");
        b.a aVar = new b.a();
        this.t = aVar;
        aVar.a = jSONObject.optString("parallel_charge_url");
        this.t.f25444c = f(d(jSONObject, "show_urls"));
        this.t.f25445d = f(d(jSONObject, "click_urls"));
        String c2 = c.a.d.f.p.t.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        sb.append(c2 == null ? "" : c2.toLowerCase());
        sb.append("&OAID=");
        sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.l)) {
            this.l += sb2;
        }
        if (StringUtils.isNull(this.m)) {
            return;
        }
        this.m += sb2;
    }

    public final ArrayList<String> f(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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

    @Override // c.a.t0.y1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : (b.a) invokeV.objValue;
    }
}
