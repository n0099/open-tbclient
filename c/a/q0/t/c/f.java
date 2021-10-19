package c.a.q0.t.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14675a;

    /* renamed from: b  reason: collision with root package name */
    public String f14676b;

    /* renamed from: c  reason: collision with root package name */
    public String f14677c;

    /* renamed from: d  reason: collision with root package name */
    public String f14678d;

    /* renamed from: e  reason: collision with root package name */
    public String f14679e;

    /* renamed from: f  reason: collision with root package name */
    public String f14680f;

    /* renamed from: g  reason: collision with root package name */
    public String f14681g;

    /* renamed from: h  reason: collision with root package name */
    public String f14682h;

    /* renamed from: i  reason: collision with root package name */
    public String f14683i;

    /* renamed from: j  reason: collision with root package name */
    public String f14684j;
    public String k;
    public String l;

    public f() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14678d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14676b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14680f : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14679e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14675a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14677c : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14684j : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14682h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f14681g : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f14683i : (String) invokeV.objValue;
    }

    public void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f14675a = optJSONObject.optString("url");
            this.f14676b = optJSONObject.optString("icon_url");
            this.f14677c = optJSONObject.optString("view_statistics_url");
            this.f14678d = optJSONObject.optString("click_statistics_url");
            this.f14679e = optJSONObject.optString("scheme");
            this.f14680f = optJSONObject.optString("package_name");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f14681g = optJSONObject2.optString("url");
            this.f14682h = optJSONObject2.optString("icon_url");
            this.f14683i = optJSONObject2.optString("view_statistics_url");
            this.f14684j = optJSONObject2.optString("click_statistics_url");
            this.k = optJSONObject2.optString("scheme");
            this.l = optJSONObject2.optString("package_name");
        }
        String c2 = c.a.e.e.p.q.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        sb.append(c2 == null ? "" : c2.toLowerCase());
        sb.append("&OAID=");
        sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.f14677c)) {
            this.f14677c += sb2;
        }
        if (!StringUtils.isNull(this.f14678d)) {
            this.f14678d += sb2;
        }
        if (!StringUtils.isNull(this.f14683i)) {
            this.f14683i += sb2;
        }
        if (StringUtils.isNull(this.f14684j)) {
            return;
        }
        this.f14684j += sb2;
    }
}
