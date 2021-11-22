package b.a.q0.s.q;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes4.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14099a;

    /* renamed from: b  reason: collision with root package name */
    public String f14100b;

    /* renamed from: c  reason: collision with root package name */
    public String f14101c;

    /* renamed from: d  reason: collision with root package name */
    public int f14102d;

    /* renamed from: e  reason: collision with root package name */
    public String f14103e;

    /* renamed from: f  reason: collision with root package name */
    public String f14104f;

    /* renamed from: g  reason: collision with root package name */
    public String f14105g;

    /* renamed from: h  reason: collision with root package name */
    public float f14106h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14107i;

    public g0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14107i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14099a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14100b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14104f : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14101c : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (StringUtils.isNull(this.f14101c)) {
                return false;
            }
            int i2 = this.f14102d;
            if (i2 != 1) {
                return i2 == 2 && !StringUtils.isNull(this.f14103e);
            }
            int i3 = this.f14099a;
            return i3 == 1 || i3 == 4 || i3 == 2 || i3 == 3;
        }
        return invokeV.booleanValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split == null || split.length < 2) {
                return;
            }
            int e2 = b.a.e.f.m.b.e(split[0], 1);
            int e3 = b.a.e.f.m.b.e(split[1], 1);
            if (e3 != 0) {
                this.f14106h = e2 / e3;
            }
        } catch (Exception e4) {
            BdLog.e(e4.getMessage());
        }
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14099a = jSONObject.optInt("bannerType");
            this.f14100b = jSONObject.optString("bannerUrl");
            this.f14101c = jSONObject.optString("value");
            this.f14102d = jSONObject.optInt("type");
            this.f14103e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f14104f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f14105g = jSONObject.optString("tag_name_url");
            f(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14102d : invokeV.intValue;
    }

    public void h(Banner banner) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, banner) == null) || banner == null) {
            return;
        }
        this.f14099a = banner.banner_type.intValue();
        this.f14100b = banner.banner_url;
        this.f14101c = banner.value;
        this.f14102d = banner.type.intValue();
        this.f14103e = banner.desc;
        banner.template_id.intValue();
        this.f14104f = banner.obj_id;
        String str = banner.tag_name;
        this.f14105g = banner.tag_name_url;
        f(banner.tag_name_wh);
    }
}
