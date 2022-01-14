package com.baidu.android.pushservice.i;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, context) == null) || (notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)) == null) {
            return;
        }
        notificationManager.cancelAll();
    }

    public static void a(Context context, int i2) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, context, i2) == null) || (notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)) == null) {
            return;
        }
        notificationManager.cancel(i2);
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, String str) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) || (notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)) == null) {
            return;
        }
        notificationManager.deleteNotificationChannel(str);
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 3);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
            i.a(context, "notification_channel_id", str);
        }
    }

    @SuppressLint({"NewApi"})
    public static int b(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Class.forName(NotificationManagerCompat.class.getName()).getMethod("areNotificationsEnabled", new Class[0]);
                    z = true;
                } catch (Throwable unused) {
                    z = false;
                }
                if (z) {
                    try {
                        return NotificationManagerCompat.from(context).areNotificationsEnabled() ? 1 : 0;
                    } catch (Exception unused2) {
                        return 2;
                    }
                } else if (Build.VERSION.SDK_INT >= 28) {
                    return 2;
                }
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls.getMethod(NotificationManagerCompat.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField(NotificationManagerCompat.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0 ? 1 : 0;
            } catch (Throwable unused3) {
                return 2;
            }
        }
        return invokeL.intValue;
    }
}
