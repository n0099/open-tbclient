package c.a.s0.d1;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                for (ActivityManager.AppTask appTask : ((ActivityManager) context.getSystemService("activity")).getAppTasks()) {
                    if (appTask != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseActivity != null && SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) && SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
                        return true;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
        ComponentName component;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, message)) == null) {
            if (message != null && (obj = message.obj) != null) {
                Object d2 = c.a.d.f.b.a.a.d(obj, "intent");
                if ((d2 instanceof Intent) && (component = ((Intent) d2).getComponent()) != null) {
                    return SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(component.getClassName());
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
