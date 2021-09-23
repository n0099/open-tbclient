package c.f.b.b.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f32366j;
    public static c k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f32367a;

    /* renamed from: b  reason: collision with root package name */
    public String f32368b;

    /* renamed from: c  reason: collision with root package name */
    public String f32369c;

    /* renamed from: d  reason: collision with root package name */
    public String f32370d;

    /* renamed from: e  reason: collision with root package name */
    public String f32371e;

    /* renamed from: f  reason: collision with root package name */
    public String f32372f;

    /* renamed from: g  reason: collision with root package name */
    public String f32373g;

    /* renamed from: h  reason: collision with root package name */
    public String f32374h;

    /* renamed from: i  reason: collision with root package name */
    public String f32375i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-790643744, "Lc/f/b/b/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-790643744, "Lc/f/b/b/b/c;");
                return;
            }
        }
        f32366j = Pattern.compile("^https://.*\\.com");
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32367a = "https://www.baifubao.com";
        this.f32368b = "https://www.dxmpay.com";
        this.f32369c = com.baidu.wallet.core.domain.b.p;
        this.f32370d = "wss://ai.dxmpay.com";
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (k == null) {
                k = new c();
            }
            return k;
        }
        return (c) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f32371e = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f32372f = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f32373g = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f32374h = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f32375i = str;
        }
    }

    @Override // c.f.b.b.b.a
    public String getAIHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!TextUtils.isEmpty(this.f32374h)) {
                return this.f32374h;
            }
            return this.f32370d;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!TextUtils.isEmpty(this.f32371e)) {
                return this.f32371e;
            }
            return this.f32367a;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TextUtils.isEmpty(this.f32372f)) {
                return this.f32372f;
            }
            return this.f32368b;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getAppPayHost() : (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getSpareInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!TextUtils.isEmpty(this.f32375i)) {
                return this.f32375i;
            }
            return this.f32368b;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.f.b.b.b.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!TextUtils.isEmpty(this.f32373g)) {
                return this.f32373g;
            }
            return this.f32369c;
        }
        return (String) invokeV.objValue;
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
            if (!TextUtils.isEmpty(optString) && f32366j.matcher(optString).matches()) {
                this.f32367a = optString;
                c.f.a.d.a.i().g(this.f32371e);
            } else {
                this.f32367a = "https://www.baifubao.com";
                c.f.a.d.a.i().g(this.f32367a);
            }
            String optString2 = jSONObject.optString("ai_host");
            if (!TextUtils.isEmpty(optString2) && f32366j.matcher(optString2).matches()) {
                this.f32370d = optString2;
            } else {
                this.f32370d = "wss://ai.dxmpay.com";
            }
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
