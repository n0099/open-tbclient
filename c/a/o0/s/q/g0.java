package c.a.o0.s.q;

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
    public int f13927a;

    /* renamed from: b  reason: collision with root package name */
    public String f13928b;

    /* renamed from: c  reason: collision with root package name */
    public String f13929c;

    /* renamed from: d  reason: collision with root package name */
    public int f13930d;

    /* renamed from: e  reason: collision with root package name */
    public String f13931e;

    /* renamed from: f  reason: collision with root package name */
    public String f13932f;

    /* renamed from: g  reason: collision with root package name */
    public String f13933g;

    /* renamed from: h  reason: collision with root package name */
    public float f13934h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13935i;

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
        this.f13935i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13927a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13928b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13932f : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13930d : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13929c : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (StringUtils.isNull(this.f13929c)) {
                return false;
            }
            int i2 = this.f13930d;
            if (i2 != 1) {
                return i2 == 2 && !StringUtils.isNull(this.f13931e);
            }
            int i3 = this.f13927a;
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
            int d2 = c.a.e.e.m.b.d(split[0], 1);
            int d3 = c.a.e.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f13934h = d2 / d3;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f13927a = jSONObject.optInt("bannerType");
            this.f13928b = jSONObject.optString("bannerUrl");
            this.f13929c = jSONObject.optString("value");
            this.f13930d = jSONObject.optInt("type");
            this.f13931e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f13932f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f13933g = jSONObject.optString("tag_name_url");
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
        this.f13927a = banner.banner_type.intValue();
        this.f13928b = banner.banner_url;
        this.f13929c = banner.value;
        this.f13930d = banner.type.intValue();
        this.f13931e = banner.desc;
        banner.template_id.intValue();
        this.f13932f = banner.obj_id;
        String str = banner.tag_name;
        this.f13933g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
