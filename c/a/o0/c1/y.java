package c.a.o0.c1;

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
import java.util.List;
/* loaded from: classes2.dex */
public class y {
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
                List<ActivityManager.AppTask> appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks();
                c.a.o0.r.a0.a.y("AMNoTaskList", 100);
                for (ActivityManager.AppTask appTask : appTasks) {
                    c.a.o0.r.a0.a.w(appTask);
                    c.a.o0.r.a0.b.a().c(appTask);
                    if (appTask != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseActivity != null && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
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
            c.a.o0.r.a0.a.y("MQNoMsg", 100);
            boolean z = false;
            if (d2 != null && (d2 instanceof Message)) {
                Message message = (Message) d2;
                int i = 0;
                while (message != null && !z && i < 10) {
                    i++;
                    c.a.o0.r.a0.a.x(message);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, message)) == null) {
            if (message != null && (obj = message.obj) != null) {
                Object d2 = c.a.d.f.b.a.a.d(obj, "intent");
                if (d2 instanceof Intent) {
                    Intent intent = (Intent) d2;
                    c.a.o0.r.a0.b.a().d(intent);
                    ComponentName component = intent.getComponent();
                    if (component != null) {
                        return SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(component.getClassName());
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
