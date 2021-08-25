package c.a.p0.t.c;

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
    public String f14656a;

    /* renamed from: b  reason: collision with root package name */
    public String f14657b;

    /* renamed from: c  reason: collision with root package name */
    public String f14658c;

    /* renamed from: d  reason: collision with root package name */
    public String f14659d;

    /* renamed from: e  reason: collision with root package name */
    public String f14660e;

    /* renamed from: f  reason: collision with root package name */
    public String f14661f;

    /* renamed from: g  reason: collision with root package name */
    public String f14662g;

    /* renamed from: h  reason: collision with root package name */
    public String f14663h;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14659d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14657b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14656a : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14658c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14663h : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14661f : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14660e : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14662g : (String) invokeV.objValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f14656a = optJSONObject.optString("url");
            this.f14657b = optJSONObject.optString("icon_url");
            this.f14658c = optJSONObject.optString("view_statistics_url");
            this.f14659d = optJSONObject.optString("click_statistics_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f14660e = optJSONObject2.optString("url");
            this.f14661f = optJSONObject2.optString("icon_url");
            this.f14662g = optJSONObject2.optString("view_statistics_url");
            this.f14663h = optJSONObject2.optString("click_statistics_url");
        }
        String c2 = c.a.e.e.p.q.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        sb.append(c2 == null ? "" : c2.toLowerCase());
        sb.append("&OAID=");
        sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.f14658c)) {
            this.f14658c += sb2;
        }
        if (!StringUtils.isNull(this.f14659d)) {
            this.f14659d += sb2;
        }
        if (!StringUtils.isNull(this.f14662g)) {
            this.f14662g += sb2;
        }
        if (StringUtils.isNull(this.f14663h)) {
            return;
        }
        this.f14663h += sb2;
    }
}
