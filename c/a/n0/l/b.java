package c.a.n0.l;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f4304a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public static long f4305b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(109937379, "Lc/a/n0/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(109937379, "Lc/a/n0/l/b;");
                return;
            }
        }
        f4305b = f4304a * 60;
    }

    public static void a(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65537, null, context, j2) == null) || j2 <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("sso_action_t_m");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
            alarmManager.cancel(broadcast);
            long currentTimeMillis = System.currentTimeMillis() + j2;
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis, broadcast);
            } else if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, broadcast);
            } else {
                alarmManager.set(0, currentTimeMillis, broadcast);
            }
        } catch (Throwable th) {
            c.d(th);
        }
    }
}
