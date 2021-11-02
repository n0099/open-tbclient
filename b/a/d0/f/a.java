package b.a.d0.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.d0.d;
import b.a.p0.a.v1.c.c;
import com.baidu.android.imsdk.internal.Constants;
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
public class a implements b.a.d0.g.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1457a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1621607743, "Lb/a/d0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1621607743, "Lb/a/d0/f/a;");
                return;
            }
        }
        f1457a = SchemeConfig.getSchemeHead() + "://swan/";
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

    @Override // b.a.d0.g.a
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? b.a.p0.a.c1.a.N().a(context) : invokeL.booleanValue;
    }

    @Override // b.a.d0.g.a
    public void b(Activity activity, String str, b.a.d0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, aVar) == null) {
            b.a.p0.a.c1.a.N().b(activity, str, aVar);
        }
    }

    @Override // b.a.d0.g.a
    public void c(Context context, JSONObject jSONObject, b.a.d0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, aVar) == null) {
            b.a.p0.a.c1.a.N().c(context, jSONObject, aVar);
        }
    }

    @Override // b.a.d0.g.a
    public void d(Activity activity, String str, b.a.d0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, aVar) == null) {
            b.a.p0.a.c1.a.N().d(activity, str, aVar);
        }
    }

    @Override // b.a.d0.g.a
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? b.a.p0.a.c1.a.u0().a(context) : (String) invokeL.objValue;
    }

    @Override // b.a.d0.g.a
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, jSONObject) == null) {
            if (jSONObject == null) {
                b.a.d0.a.h(3, "支付信息不能为空");
                return;
            }
            String optString = jSONObject.optString("appKey");
            String optString2 = jSONObject.optString("redirectUrl");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SchemeRouter.invoke(context, f1457a + optString + optString2);
                return;
            }
            b.a.d0.a.h(3, "支付信息不能为空");
        }
    }

    @Override // b.a.d0.g.a
    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            String str = b.a.p0.a.q1.a.b().f7360a;
            if (TextUtils.isEmpty(str)) {
                d.a(bundle);
                return;
            }
            b.a.p0.a.v1.c.a e2 = b.a.p0.a.v1.c.a.e();
            c cVar = new c(119, bundle);
            cVar.c(str);
            cVar.p(true);
            e2.h(cVar);
        }
    }

    @Override // b.a.d0.g.a
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            b.a.p0.a.q1.a.b().f7360a = str;
        }
    }
}
