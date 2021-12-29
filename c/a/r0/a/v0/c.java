package c.a.r0.a.v0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.k;
import c.a.r0.a.o2.g.g;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9680b;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* renamed from: c.a.r0.a.v0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0595c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(885054069, "Lc/a/r0/a/v0/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(885054069, "Lc/a/r0/a/v0/c$c;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438909332, "Lc/a/r0/a/v0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438909332, "Lc/a/r0/a/v0/c;");
                return;
            }
        }
        f9680b = k.a;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0595c.a : (c) invokeV.objValue;
    }

    public boolean a(@NonNull WeakReference<Activity> weakReference) {
        InterceptResult invokeL;
        e L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, weakReference)) == null) {
            if (!q0.G() || weakReference == null || weakReference.get() == null) {
                return false;
            }
            Activity activity = weakReference.get();
            if (TextUtils.equals("0", g()) || (L = e.L()) == null || L.T().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue()) {
                return false;
            }
            return i(activity) && !TextUtils.isEmpty(f());
        }
        return invokeL.booleanValue;
    }

    public final int b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            PackageInfo t = q0.t(context, context.getPackageName());
            if (t != null) {
                return t.versionCode;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? this.a.getInt("up_first_in", b(activity)) : invokeL.intValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getBoolean("new_first_in", true) : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getString("url", "") : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getString("switch", "1") : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e L = e.L();
            if (L == null) {
                return false;
            }
            return L.T().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean i(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
            boolean e2 = e();
            if (f9680b) {
                String str = "is first in " + e2;
            }
            if (e2) {
                return true;
            }
            int d2 = d(activity);
            int b2 = b(activity);
            if (f9680b) {
                String str2 = "version =" + d2 + " curVerCode" + b2;
            }
            return b2 > d2;
        }
        return invokeL.booleanValue;
    }

    public void j(@NonNull Activity activity, String str, String str2, c.a.r0.a.v0.b bVar, b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, str2, bVar, bVar2) == null) {
            c.a.r0.a.c1.a.l0().h(activity, str, str2, bVar, bVar2);
        }
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
        g gVar = new g("aiapps_guide_dialog_sp");
        this.a = gVar;
        gVar.edit();
    }
}
