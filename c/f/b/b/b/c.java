package c.f.b.b.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static c f28177f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f28178b;

    /* renamed from: c  reason: collision with root package name */
    public String f28179c;

    /* renamed from: d  reason: collision with root package name */
    public String f28180d;

    /* renamed from: e  reason: collision with root package name */
    public String f28181e;

    public c() {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f28177f == null) {
                f28177f = new c();
            }
            return f28177f;
        }
        return (c) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f28178b = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f28179c = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f28180d = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f28181e = str;
        }
    }

    @Override // c.f.b.b.b.a
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.isEmpty(this.a) ? "https://www.baifubao.com" : this.a : (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TextUtils.isEmpty(this.f28178b) ? "https://www.dxmpay.com" : this.f28178b : (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getAppPayHost() : (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getRtcHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "https";
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append("://");
            sb.append(TextUtils.isEmpty(this.f28180d) ? "ai.dxmpay.com" : this.f28180d);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getSpareInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.isEmpty(this.f28181e) ? "https://www.dxmpay.com" : this.f28181e : (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TextUtils.isEmpty(this.f28179c) ? com.baidu.wallet.core.domain.b.p : this.f28179c : (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public void setDomainConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString) && b.f28174d.matcher(optString).matches()) {
                this.a = optString;
            } else {
                this.a = "https://www.baifubao.com";
            }
            c.f.a.d.a.i().g(this.a);
            String optString2 = jSONObject.optString("rtc_host");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "ai.dxmpay.com";
            }
            this.f28180d = optString2;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.f.b.b.b.a
    public void setDxmPayContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
        }
    }
}
