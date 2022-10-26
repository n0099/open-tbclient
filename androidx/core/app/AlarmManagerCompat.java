package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AlarmManagerCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlarmManagerCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void setAlarmClock(AlarmManager alarmManager, long j, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{alarmManager, Long.valueOf(j), pendingIntent, pendingIntent2}) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j, pendingIntent), pendingIntent2);
            } else {
                setExact(alarmManager, 0, j, pendingIntent2);
            }
        }
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{alarmManager, Integer.valueOf(i), Long.valueOf(j), pendingIntent}) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setAndAllowWhileIdle(i, j, pendingIntent);
            } else {
                alarmManager.set(i, j, pendingIntent);
            }
        }
    }

    public static void setExact(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{alarmManager, Integer.valueOf(i), Long.valueOf(j), pendingIntent}) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(i, j, pendingIntent);
            } else {
                alarmManager.set(i, j, pendingIntent);
            }
        }
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{alarmManager, Integer.valueOf(i), Long.valueOf(j), pendingIntent}) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
            } else {
                setExact(alarmManager, i, j, pendingIntent);
            }
        }
    }
}
