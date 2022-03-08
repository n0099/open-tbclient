package c.a.q0.c1;

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
import java.util.List;
/* loaded from: classes2.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f12244b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(38256025, "Lc/a/q0/c1/y;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(38256025, "Lc/a/q0/c1/y;");
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
                List<ActivityManager.AppTask> appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks();
                c.a.q0.r.a0.a.u("AMNoTaskList", 100);
                for (ActivityManager.AppTask appTask : appTasks) {
                    if (appTask != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseIntent != null && !a) {
                        a = true;
                        String d2 = d(appTask.getTaskInfo().baseIntent);
                        c.a.q0.r.a0.a.t(d2, c.a.d.f.p.m.isEmpty(d2));
                        c.a.q0.r.a0.a.v();
                    }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Object d2 = c.a.d.f.b.a.a.d(Looper.myQueue(), "mMessages");
            c.a.q0.r.a0.a.u("MQNoMsg", 100);
            boolean z = false;
            if (d2 != null && (d2 instanceof Message)) {
                Message message = (Message) d2;
                int i2 = 0;
                while (message != null && !z && i2 < 10) {
                    i2++;
                    z = e(message);
                    Object d3 = c.a.d.f.b.a.a.d(message, "next");
                    message = d3 instanceof Message ? (Message) d3 : null;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String d(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (dataString == null || !dataString.startsWith("custom")) {
                return dataString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(dataString);
            sb.append(".action.");
            sb.append(intent.getAction());
            if (intent.getCategories() != null) {
                sb.append("categories.");
                for (String str : intent.getCategories()) {
                    sb.append(str);
                    sb.append(".");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static final boolean e(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, message)) == null) {
            if (message == null) {
                return false;
            }
            c.a.q0.r.a0.a.u("MQNoMsgObj", 100);
            Object obj = message.obj;
            if (obj != null) {
                Object d2 = c.a.d.f.b.a.a.d(obj, "intent");
                c.a.q0.r.a0.a.u("MQNoMsgIntent", 100);
                if (d2 instanceof Intent) {
                    c.a.q0.r.a0.a.u("MQNoMsgCompnent", 100);
                    Intent intent = (Intent) d2;
                    ComponentName component = intent.getComponent();
                    if (component != null) {
                        if (!a && !f12244b && "com.baidu.tieba".equals(component.getPackageName())) {
                            f12244b = true;
                            c.a.q0.r.a0.a.t(intent.getDataString(), c.a.d.f.p.m.isEmpty(intent.getDataString()));
                            c.a.q0.r.a0.a.v();
                        }
                        return SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(component.getClassName());
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
