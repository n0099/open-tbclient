package c.a.t0.d1;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(972643286, "Lc/a/t0/d1/z;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(972643286, "Lc/a/t0/d1/z;");
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                boolean b2 = b(context);
                return !b2 ? c() : b2;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                for (ActivityManager.AppTask appTask : ((ActivityManager) context.getSystemService("activity")).getAppTasks()) {
                    if (appTask != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseActivity != null) {
                        if (appTask.getTaskInfo().baseIntent != null && !a) {
                            a = true;
                            c.a.t0.s.a0.a.s(appTask.getTaskInfo().baseIntent.getDataString(), c.a.d.f.p.m.isEmpty(appTask.getTaskInfo().baseIntent.getDataString()));
                            c.a.t0.s.a0.a.t();
                        }
                        if (SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) && SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Object d2 = c.a.d.f.b.a.a.d(Looper.myQueue(), "mMessages");
            boolean z = false;
            if (d2 != null && (d2 instanceof Message)) {
                Message message = (Message) d2;
                int i2 = 0;
                while (message != null && !z && i2 < 10) {
                    i2++;
                    z = d(message);
                    Object d3 = c.a.d.f.b.a.a.d(message, "next");
                    message = d3 instanceof Message ? (Message) d3 : null;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static final boolean d(Message message) {
        InterceptResult invokeL;
        Object obj;
        Intent intent;
        ComponentName component;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, message)) == null) {
            if (message != null && (obj = message.obj) != null) {
                Object d2 = c.a.d.f.b.a.a.d(obj, "intent");
                if ((d2 instanceof Intent) && (component = (intent = (Intent) d2).getComponent()) != null) {
                    c.a.t0.s.a0.a.s(intent.getDataString(), c.a.d.f.p.m.isEmpty(intent.getDataString()));
                    c.a.t0.s.a0.a.t();
                    return SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(component.getClassName());
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
