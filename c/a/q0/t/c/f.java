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
    public String f14654a;

    /* renamed from: b  reason: collision with root package name */
    public String f14655b;

    /* renamed from: c  reason: collision with root package name */
    public String f14656c;

    /* renamed from: d  reason: collision with root package name */
    public String f14657d;

    /* renamed from: e  reason: collision with root package name */
    public String f14658e;

    /* renamed from: f  reason: collision with root package name */
    public String f14659f;

    /* renamed from: g  reason: collision with root package name */
    public String f14660g;

    /* renamed from: h  reason: collision with root package name */
    public String f14661h;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14657d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14655b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14654a : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14656c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14661h : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14659f : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14658e : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14660g : (String) invokeV.objValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f14654a = optJSONObject.optString("url");
            this.f14655b = optJSONObject.optString("icon_url");
            this.f14656c = optJSONObject.optString("view_statistics_url");
            this.f14657d = optJSONObject.optString("click_statistics_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f14658e = optJSONObject2.optString("url");
            this.f14659f = optJSONObject2.optString("icon_url");
            this.f14660g = optJSONObject2.optString("view_statistics_url");
            this.f14661h = optJSONObject2.optString("click_statistics_url");
        }
        String c2 = c.a.e.e.p.q.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        sb.append(c2 == null ? "" : c2.toLowerCase());
        sb.append("&OAID=");
        sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.f14656c)) {
            this.f14656c += sb2;
        }
        if (!StringUtils.isNull(this.f14657d)) {
            this.f14657d += sb2;
        }
        if (!StringUtils.isNull(this.f14660g)) {
            this.f14660g += sb2;
        }
        if (StringUtils.isNull(this.f14661h)) {
            return;
        }
        this.f14661h += sb2;
    }
}
