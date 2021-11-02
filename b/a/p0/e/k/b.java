package b.a.p0.e.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9632b;

    /* renamed from: c  reason: collision with root package name */
    public static SharedPreferences f9633c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9634a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-951044177, "Lb/a/p0/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-951044177, "Lb/a/p0/e/k/b;");
                return;
            }
        }
        f9632b = k.f6397a;
        f9633c = null;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9634a = null;
        this.f9634a = context;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                if (f9632b) {
                    String str = "error:" + e2.getMessage();
                    return -1;
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static SharedPreferences c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f9633c == null) {
                f9633c = context.getSharedPreferences("downgradefile", 0);
            }
            return f9633c;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static b d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
    }

    public static void j(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2) == null) {
            if (f9632b) {
                String str = "set last version code:" + i2;
            }
            SharedPreferences.Editor edit = c(context).edit();
            edit.putInt("last_versioncode_key", i2);
            edit.apply();
        }
    }

    public final int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            int i2 = c(context).getInt("old_versioncode_key", 0);
            if (f9632b) {
                String str = "get old versioncode:" + i2;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b.a.p0.a.t2.a.d(0, i2);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && f9632b) {
            String str = "新旧版本一样:" + b(this.f9634a);
        }
    }

    public final void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            b.a.p0.a.t2.a.d(i3, i2);
            b.a.p0.w.a.c();
            b.a.p0.a.n0.k.c.f6843d.u();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int a2 = a(this.f9634a);
            int b2 = b(this.f9634a);
            if (f9632b) {
                String str = "处理升级逻辑：newVersionCode=" + a2 + " /oldVersionCode=" + b2;
            }
            if (b2 == 0) {
                f(a2);
                k(this.f9634a, a2);
                j(this.f9634a, b2);
            } else if (a2 > b2) {
                h(a2, b2);
                k(this.f9634a, a2);
                j(this.f9634a, b2);
            } else if (a2 < b2) {
                e(a2, b2);
                k(this.f9634a, a2);
                j(this.f9634a, b2);
            } else {
                g();
            }
        }
    }

    public final void k(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i2) == null) {
            if (f9632b) {
                String str = "set new versioncode:" + i2;
            }
            SharedPreferences.Editor edit = c(context).edit();
            edit.putInt("old_versioncode_key", i2);
            edit.apply();
        }
    }
}
