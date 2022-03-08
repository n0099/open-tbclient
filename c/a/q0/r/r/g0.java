package c.a.q0.r.r;

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
/* loaded from: classes2.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f13274b;

    /* renamed from: c  reason: collision with root package name */
    public String f13275c;

    /* renamed from: d  reason: collision with root package name */
    public int f13276d;

    /* renamed from: e  reason: collision with root package name */
    public String f13277e;

    /* renamed from: f  reason: collision with root package name */
    public String f13278f;

    /* renamed from: g  reason: collision with root package name */
    public String f13279g;

    /* renamed from: h  reason: collision with root package name */
    public float f13280h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13281i;

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
        this.f13281i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13274b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13278f : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13275c : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (StringUtils.isNull(this.f13275c)) {
                return false;
            }
            int i2 = this.f13276d;
            if (i2 != 1) {
                return i2 == 2 && !StringUtils.isNull(this.f13277e);
            }
            int i3 = this.a;
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
            int e2 = c.a.d.f.m.b.e(split[0], 1);
            int e3 = c.a.d.f.m.b.e(split[1], 1);
            if (e3 != 0) {
                this.f13280h = e2 / e3;
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
            this.a = jSONObject.optInt("bannerType");
            this.f13274b = jSONObject.optString("bannerUrl");
            this.f13275c = jSONObject.optString("value");
            this.f13276d = jSONObject.optInt("type");
            this.f13277e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f13278f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f13279g = jSONObject.optString("tag_name_url");
            f(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13276d : invokeV.intValue;
    }

    public void h(Banner banner) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, banner) == null) || banner == null) {
            return;
        }
        this.a = banner.banner_type.intValue();
        this.f13274b = banner.banner_url;
        this.f13275c = banner.value;
        this.f13276d = banner.type.intValue();
        this.f13277e = banner.desc;
        banner.template_id.intValue();
        this.f13278f = banner.obj_id;
        String str = banner.tag_name;
        this.f13279g = banner.tag_name_url;
        f(banner.tag_name_wh);
    }
}
