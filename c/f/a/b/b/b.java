package c.f.a.b.b;

import android.content.Context;
import android.text.TextUtils;
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
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f28218d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f28219b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28220c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1761513186, "Lc/f/a/b/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1761513186, "Lc/f/a/b/b/b;");
                return;
            }
        }
        f28218d = Pattern.compile("^https://.*\\.com");
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.f.a.b.b.a
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.a) ? "https://www.baifubao.com" : this.a : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f28220c == null) {
                return "https://www.dxmpay.com";
            }
            String appPayHost = SdkInitResponse.getInstance().getAppPayHost(this.f28220c);
            return TextUtils.isEmpty(appPayHost) ? "https://www.dxmpay.com" : appPayHost;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://www.dxmpay.com" : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getRtcHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "https";
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append("://");
            sb.append(TextUtils.isEmpty(this.f28219b) ? "ai.dxmpay.com" : this.f28219b);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getSpareInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "https://www.paydxm.com" : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f28220c == null) {
                return com.baidu.wallet.core.domain.b.p;
            }
            String polymerHost = SdkInitResponse.getInstance().getPolymerHost(this.f28220c);
            return TextUtils.isEmpty(polymerHost) ? com.baidu.wallet.core.domain.b.p : polymerHost;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public void setDomainConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString) && f28218d.matcher(optString).matches()) {
                this.a = optString;
                com.dxmpay.apollon.heartbeat.a.b().a(this.a);
            } else {
                this.a = "";
                com.dxmpay.apollon.heartbeat.a.b().a("https://www.baifubao.com");
            }
            String optString2 = jSONObject.optString("rtc_host");
            if (!TextUtils.isEmpty(optString2)) {
                this.f28219b = optString2;
            } else {
                this.f28219b = "";
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.f.a.b.b.a
    public void setDxmPayContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f28220c = context;
        }
    }
}
