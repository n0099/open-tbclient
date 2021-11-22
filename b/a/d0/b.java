package b.a.d0;

import android.app.Activity;
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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f1449a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1151384043, "Lb/a/d0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1151384043, "Lb/a/d0/b;");
        }
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

    public static synchronized b f() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b.class) {
                if (f1449a == null) {
                    synchronized (b.class) {
                        if (f1449a == null) {
                            f1449a = new b();
                        }
                    }
                }
                bVar = f1449a;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public boolean a(Activity activity, String str, b.a.d0.f.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, bVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            a.a().c(activity, str, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean b(Activity activity, String str, b.a.d0.f.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, bVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            a.a().e(activity, str, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(Activity activity, JSONObject jSONObject, b.a.d0.f.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                return false;
            }
            a.a().i(activity, jSONObject, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean d(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            a.a().f(context, jSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean e(Context context, JSONObject jSONObject, b.a.d0.f.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                return false;
            }
            a.a().d(context, jSONObject, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
