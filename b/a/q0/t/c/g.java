package b.a.q0.t.c;

import b.a.r0.q1.o.h.b;
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
/* loaded from: classes4.dex */
public class g implements b.a.r0.q1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f14549e;

    /* renamed from: f  reason: collision with root package name */
    public String f14550f;

    /* renamed from: g  reason: collision with root package name */
    public String f14551g;

    /* renamed from: h  reason: collision with root package name */
    public String f14552h;

    /* renamed from: i  reason: collision with root package name */
    public String f14553i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;
    public b.a o;
    public int p;

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
            if (this.m == 2 || StringUtils.isNull(this.f14550f)) {
                return true;
            }
            return StringUtils.isNull(this.f14549e) && StringUtils.isNull(this.f14553i) && StringUtils.isNull(this.k);
        }
        return invokeV.booleanValue;
    }

    public final JSONArray b(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14549e = jSONObject.optString("url");
        this.f14550f = jSONObject.optString("icon_url");
        this.f14551g = jSONObject.optString("view_statistics_url");
        this.f14552h = jSONObject.optString("click_statistics_url");
        this.f14553i = jSONObject.optString("scheme");
        this.j = jSONObject.optString("package_name");
        this.k = jSONObject.optString("deeplink");
        this.m = jSONObject.optInt("source", 1);
        this.l = jSONObject.optString("ext_info");
        this.n = jSONObject.optString(LegoListActivityConfig.AD_ID);
        b.a aVar = new b.a();
        this.o = aVar;
        aVar.f24145a = jSONObject.optString("parallel_charge_url");
        this.o.f24147c = d(b(jSONObject, "show_urls"));
        this.o.f24148d = d(b(jSONObject, "click_urls"));
        String c2 = b.a.e.f.p.q.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        sb.append(c2 == null ? "" : c2.toLowerCase());
        sb.append("&OAID=");
        sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.f14551g)) {
            this.f14551g += sb2;
        }
        if (StringUtils.isNull(this.f14552h)) {
            return;
        }
        this.f14552h += sb2;
    }

    public final ArrayList<String> d(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
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

    @Override // b.a.r0.q1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : (b.a) invokeV.objValue;
    }
}
