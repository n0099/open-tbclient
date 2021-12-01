package c.a.e0.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.c;
import c.a.p0.a.t1.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements c.a.e0.h.a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712189856, "Lc/a/e0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712189856, "Lc/a/e0/g/a;");
                return;
            }
        }
        a = SchemeConfig.getSchemeHead() + "://swan/";
    }

    public a() {
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

    @Override // c.a.e0.h.a
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            c.a.p0.a.c1.a.S().a(activity, str, str2);
        }
    }

    @Override // c.a.e0.h.a
    public void aLiAuth(Activity activity, String str, c.a.f0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, aVar) == null) {
            c.a.p0.a.c1.a.S().f(activity, str, aVar);
        }
    }

    @Override // c.a.e0.h.a
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? c.a.p0.a.c1.a.S().b(context) : invokeL.booleanValue;
    }

    @Override // c.a.e0.h.a
    public void c(Activity activity, String str, c.a.e0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, bVar) == null) {
            c.a.p0.a.c1.a.S().c(activity, str, bVar);
        }
    }

    @Override // c.a.e0.h.a
    public void d(Context context, JSONObject jSONObject, c.a.e0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, jSONObject, bVar) == null) {
            c.a.p0.a.c1.a.S().d(context, jSONObject, bVar);
        }
    }

    @Override // c.a.e0.h.a
    public void e(Activity activity, String str, c.a.e0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, bVar) == null) {
            c.a.p0.a.c1.a.S().e(activity, str, bVar);
        }
    }

    @Override // c.a.e0.h.a
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
            if (jSONObject == null) {
                PaymentManager.i(3, "支付信息不能为空");
                return;
            }
            String optString = jSONObject.optString("appKey");
            String optString2 = jSONObject.optString("redirectUrl");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SchemeRouter.invoke(context, a + optString + optString2);
                return;
            }
            PaymentManager.i(3, "支付信息不能为空");
        }
    }

    @Override // c.a.e0.h.a
    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            String str = d.b().a;
            if (TextUtils.isEmpty(str)) {
                c.a(bundle);
                return;
            }
            c.a.p0.a.y1.c.a e2 = c.a.p0.a.y1.c.a.e();
            c.a.p0.a.y1.c.c cVar = new c.a.p0.a.y1.c.c(119, bundle);
            cVar.c(str);
            cVar.p(true);
            e2.h(cVar);
        }
    }

    @Override // c.a.e0.h.a
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            d.b().a = str;
        }
    }

    @Override // c.a.e0.h.a
    public void i(Activity activity, JSONObject jSONObject, c.a.e0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, jSONObject, bVar) == null) {
        }
    }

    @Override // c.a.e0.h.a
    public String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? c.a.p0.a.c1.a.G0().a(context) : (String) invokeL.objValue;
    }
}
