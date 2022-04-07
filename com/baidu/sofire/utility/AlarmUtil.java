package com.baidu.sofire.utility;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.service.Service;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AlarmUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DAY = 86400000;
    public static final long HOUR = 3600000;
    public static final int REQUEST_CODE_CHECK_UPGRADE = 1000;
    public static final int REQUEST_CODE_PID_CHANGE = 1002;
    public static final int REQUEST_CODE_RETRY_CHECK_UPDATE = 1001;
    public static final long WEEK = 604800000;
    public transient /* synthetic */ FieldHolder $fh;

    public AlarmUtil() {
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

    public static void setCheckRTSDKUpgradeAlarm(Context context, boolean z) {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                long alarmCheckTime = sharedPreferenceManager.getAlarmCheckTime() * 3600000;
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                intent.setClass(context, MyService.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.baidu.category.SOFIRE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_package", context.getPackageName());
                intent.putExtra("target_class", U.class.getCanonicalName());
                intent.putExtra("target_method", "handleWork");
                intent.putExtra("from", 6);
                PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728);
                if (z) {
                    currentTimeMillis = sharedPreferenceManager.getNextPluginUpdateCheckTime();
                    if (currentTimeMillis <= 0) {
                        currentTimeMillis = System.currentTimeMillis() + alarmCheckTime;
                        sharedPreferenceManager.setNextPluginUpdateCheckTime(currentTimeMillis);
                    }
                } else {
                    currentTimeMillis = ((System.currentTimeMillis() + alarmCheckTime) - 600000) + ((long) (Math.random() * 1200000.0d));
                    sharedPreferenceManager.setNextPluginUpdateCheckTime(currentTimeMillis);
                }
                try {
                    alarmManager.cancel(service);
                } catch (Throwable unused) {
                }
                try {
                    alarmManager.set(1, currentTimeMillis, service);
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static void setCheckUpdateRetryAlarm(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                intent.setClass(context, MyService.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.baidu.category.SOFIRE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_package", context.getPackageName());
                intent.putExtra("target_class", U.class.getCanonicalName());
                intent.putExtra("target_method", "handleWork");
                intent.putExtra("from", 2);
                PendingIntent service = PendingIntent.getService(context, 1001, intent, 134217728);
                long j = 600000;
                if (i == 0) {
                    j = 30000;
                } else if (i == 1) {
                    j = Service.TRIGGER_INTERVAL;
                } else if (i == 2) {
                    j = 300000;
                }
                long currentTimeMillis = System.currentTimeMillis() + j;
                try {
                    alarmManager.cancel(service);
                } catch (Throwable unused) {
                }
                if (z) {
                    return;
                }
                try {
                    alarmManager.set(1, currentTimeMillis, service);
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
