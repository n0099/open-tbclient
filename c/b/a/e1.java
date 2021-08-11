package c.b.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
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
import com.bytedance.embedapplog.IPicker;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class e1 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static int f31118f;

    /* renamed from: g  reason: collision with root package name */
    public static w f31119g;

    /* renamed from: h  reason: collision with root package name */
    public static w f31120h;

    /* renamed from: i  reason: collision with root package name */
    public static long f31121i;

    /* renamed from: j  reason: collision with root package name */
    public static String f31122j;
    public static Object k;
    public static Object l;
    public static final HashSet<Integer> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final IPicker f31123e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074084804, "Lc/b/a/e1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074084804, "Lc/b/a/e1;");
                return;
            }
        }
        m = new HashSet<>(8);
    }

    public e1(IPicker iPicker) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iPicker};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31123e = iPicker;
    }

    public static w a(w wVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, wVar, j2)) == null) {
            w wVar2 = (w) wVar.clone();
            wVar2.f31176e = j2;
            long j3 = j2 - wVar.f31176e;
            if (j3 >= 0) {
                wVar2.m = j3;
            } else {
                h0.b(null);
            }
            j1.d(wVar2);
            return wVar2;
        }
        return (w) invokeLJ.objValue;
    }

    public static w b(String str, String str2, long j2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j2), str3})) == null) {
            w wVar = new w();
            if (!TextUtils.isEmpty(str2)) {
                wVar.o = str + ":" + str2;
            } else {
                wVar.o = str;
            }
            wVar.f31176e = j2;
            wVar.m = -1L;
            if (str3 == null) {
                str3 = "";
            }
            wVar.n = str3;
            j1.d(wVar);
            return wVar;
        }
        return (w) invokeCommon.objValue;
    }

    public static void c(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            m.add(Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            m.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            if (f31120h != null) {
                c(l);
            }
            w wVar = f31119g;
            if (wVar != null) {
                f31122j = wVar.o;
                long currentTimeMillis = System.currentTimeMillis();
                f31121i = currentTimeMillis;
                a(f31119g, currentTimeMillis);
                f31119g = null;
                activity.isChild();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            w b2 = b(activity.getClass().getName(), "", System.currentTimeMillis(), f31122j);
            f31119g = b2;
            b2.p = !m.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
            if (activity.isChild()) {
                return;
            }
            try {
                activity.getWindow().getDecorView().hashCode();
                k = activity;
            } catch (Exception e2) {
                h0.b(e2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        IPicker iPicker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            int i2 = f31118f + 1;
            f31118f = i2;
            if (i2 != 1 || (iPicker = this.f31123e) == null) {
                return;
            }
            iPicker.show(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, activity) == null) || f31122j == null) {
            return;
        }
        int i2 = f31118f - 1;
        f31118f = i2;
        if (i2 <= 0) {
            f31122j = null;
            f31121i = 0L;
            IPicker iPicker = this.f31123e;
            if (iPicker != null) {
                iPicker.show(false);
            }
        }
    }
}
