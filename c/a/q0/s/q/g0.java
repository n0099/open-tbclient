package c.a.q0.s.q;

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
/* loaded from: classes3.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14187a;

    /* renamed from: b  reason: collision with root package name */
    public String f14188b;

    /* renamed from: c  reason: collision with root package name */
    public String f14189c;

    /* renamed from: d  reason: collision with root package name */
    public int f14190d;

    /* renamed from: e  reason: collision with root package name */
    public String f14191e;

    /* renamed from: f  reason: collision with root package name */
    public String f14192f;

    /* renamed from: g  reason: collision with root package name */
    public String f14193g;

    /* renamed from: h  reason: collision with root package name */
    public float f14194h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14195i;

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
        this.f14195i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14187a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14188b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14192f : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14190d : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14189c : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (StringUtils.isNull(this.f14189c)) {
                return false;
            }
            int i2 = this.f14190d;
            if (i2 != 1) {
                return i2 == 2 && !StringUtils.isNull(this.f14191e);
            }
            int i3 = this.f14187a;
            return i3 == 1 || i3 == 4 || i3 == 2 || i3 == 3;
        }
        return invokeV.booleanValue;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split == null || split.length < 2) {
                return;
            }
            int e2 = c.a.e.e.m.b.e(split[0], 1);
            int e3 = c.a.e.e.m.b.e(split[1], 1);
            if (e3 != 0) {
                this.f14194h = e2 / e3;
            }
        } catch (Exception e4) {
            BdLog.e(e4.getMessage());
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14187a = jSONObject.optInt("bannerType");
            this.f14188b = jSONObject.optString("bannerUrl");
            this.f14189c = jSONObject.optString("value");
            this.f14190d = jSONObject.optInt("type");
            this.f14191e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f14192f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f14193g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, banner) == null) || banner == null) {
            return;
        }
        this.f14187a = banner.banner_type.intValue();
        this.f14188b = banner.banner_url;
        this.f14189c = banner.value;
        this.f14190d = banner.type.intValue();
        this.f14191e = banner.desc;
        banner.template_id.intValue();
        this.f14192f = banner.obj_id;
        String str = banner.tag_name;
        this.f14193g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
