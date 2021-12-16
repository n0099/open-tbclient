package c.a.s0.j0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f18173b;

    /* renamed from: c  reason: collision with root package name */
    public int f18174c;

    /* renamed from: d  reason: collision with root package name */
    public long f18175d;

    /* renamed from: e  reason: collision with root package name */
    public long f18176e;

    /* renamed from: f  reason: collision with root package name */
    public String f18177f;

    /* renamed from: g  reason: collision with root package name */
    public long f18178g;

    /* renamed from: h  reason: collision with root package name */
    public String f18179h;

    /* renamed from: i  reason: collision with root package name */
    public String f18180i;

    /* renamed from: j  reason: collision with root package name */
    public String f18181j;

    /* renamed from: k  reason: collision with root package name */
    public String f18182k;
    public String l;
    public int m;
    public double n;

    public a() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18181j : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18179h : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18180i : (String) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18175d : invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.intValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18176e : invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18178g : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public double i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : invokeV.doubleValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? StringUtils.isNull(this.l) ? this.f18182k : this.l : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f18174c : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f18177f : (String) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f18173b : invokeV.longValue;
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f18173b = jSONObject.optLong("scores");
        this.f18174c = jSONObject.optInt("status");
        this.f18175d = jSONObject.optLong("create_time");
        this.f18176e = jSONObject.optLong("finish_time");
        this.f18177f = jSONObject.optString("title");
        this.f18178g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.f18182k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f18179h = jSONObject.optString("activity_desc");
        this.f18180i = jSONObject.optString("activity_url");
        this.f18181j = jSONObject.optString("button_name");
        this.m = jSONObject.optInt("price_type", 0);
        this.n = jSONObject.optDouble("order_yy_amount", 0.0d);
        jSONObject.optDouble("order_amount", 0.0d);
    }
}
