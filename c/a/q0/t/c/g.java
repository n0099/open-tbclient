package c.a.q0.t.c;

import c.a.r0.w1.o.h.b;
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
/* loaded from: classes5.dex */
public class g implements c.a.r0.w1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f13339e;

    /* renamed from: f  reason: collision with root package name */
    public String f13340f;

    /* renamed from: g  reason: collision with root package name */
    public String f13341g;

    /* renamed from: h  reason: collision with root package name */
    public String f13342h;

    /* renamed from: i  reason: collision with root package name */
    public String f13343i;

    /* renamed from: j  reason: collision with root package name */
    public String f13344j;

    /* renamed from: k  reason: collision with root package name */
    public String f13345k;
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
            if (StringUtils.isNull(this.f13339e) && StringUtils.isNull(this.n) && StringUtils.isNull(this.p)) {
                return true;
            }
            if (b()) {
                return StringUtils.isNull(this.f13341g) || StringUtils.isNull(this.f13342h);
            }
            return StringUtils.isNull(this.f13340f);
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "dynamic".equals(this.f13343i) : invokeV.booleanValue;
    }

    public final JSONArray c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f13339e = jSONObject.optString("url");
        this.f13340f = jSONObject.optString("icon_url");
        this.f13341g = jSONObject.optString("fold_lottie");
        this.f13342h = jSONObject.optString("unfold_lottie");
        this.f13343i = jSONObject.optString("float_type");
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
        b.a aVar = new b.a();
        this.t = aVar;
        aVar.a = jSONObject.optString("parallel_charge_url");
        this.t.f25079c = e(c(jSONObject, "show_urls"));
        this.t.f25080d = e(c(jSONObject, "click_urls"));
        String c2 = c.a.d.f.p.q.c(TbadkApplication.getInst().getAndroidId());
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

    public final ArrayList<String> e(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONArray)) == null) {
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

    @Override // c.a.r0.w1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.t : (b.a) invokeV.objValue;
    }
}
