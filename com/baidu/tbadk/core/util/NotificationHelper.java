package com.baidu.tbadk.core.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.aa5;
import com.baidu.tieba.he;
import com.baidu.tieba.qd;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NotificationHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean IS_SUPPORT_PROGRESS_NOTIFICATION = true;
    public static String OPPO_IM_CHANNEL = "private_channel";
    public static String PRIMARY_CHANNEL = "default";
    public static String PRIMARY_CHANNEL_2 = "default_2";
    public static String PRIMARY_CHANNEL_3 = "default_3";
    public static NotificationCompat.Builder PROGRESS_BUILDER;
    public static NotificationCompat.Builder PROGRESS_BUILDER_2;
    public static int lastProgressNotifiyId;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(712878082, "Lcom/baidu/tbadk/core/util/NotificationHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(712878082, "Lcom/baidu/tbadk/core/util/NotificationHelper;");
        }
    }

    /* loaded from: classes4.dex */
    public static class SwitchData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isLight;
        public boolean isSound;
        public boolean isVibrate;

        public SwitchData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isSound = false;
            this.isVibrate = false;
            this.isLight = false;
        }
    }

    public NotificationHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean canSupportClickPendingIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Build.VERSION.SDK_INT < 11) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static Bitmap getLargeIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            return BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.tb_launcher_icon, options);
        }
        return (Bitmap) invokeV.objValue;
    }

    public static void cancelAllNotification(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, context) != null) || context == null) {
            return;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancelAll();
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public static boolean cancelNotification(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (context == null) {
                return false;
            }
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(context.getPackageName(), i);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public static boolean cancelNotificationExceptSpecific(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, context, i, i2)) == null) {
            if (context != null && i != i2) {
                try {
                    ((NotificationManager) context.getSystemService("notification")).cancel(context.getPackageName(), i);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void createDefaultChannel2(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, context) == null) && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_2, he.a(R.string.notify_channel_primary), 3);
            notificationChannel.setLightColor(BaseAnimatedElement.DEBUG_PAINT_COLOR);
            notificationChannel.setLockscreenVisibility(0);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
    }

    public static void processNotificationIcon(NotificationCompat.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, null, builder) != null) || builder == null) {
            return;
        }
        if (RomTypeUtil.isOnePlus()) {
            builder.setSmallIcon(R.drawable.tb_launcher_icon_notify_oneplus).setColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0302));
        } else {
            builder.setSmallIcon(R.drawable.tb_launcher_icon_notify);
        }
    }

    public static void createIMChannel4Oppo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            if ((UtilHelper.isOppoDevice() || RomTypeUtil.isOnePlus()) && Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(OPPO_IM_CHANNEL, he.a(R.string.notify_channel_primary_oppo), 4);
                notificationChannel.setDescription(he.a(R.string.notify_channel_primary_oppo_desc));
                notificationChannel.enableLights(true);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
            }
        }
    }

    public static Notification notif_excption(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL);
            builder.setContentTitle(context.getString(R.string.notify_text));
            if (RomTypeUtil.isOnePlus()) {
                builder.setSmallIcon(R.drawable.tb_launcher_icon_notify_oneplus).setColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0302));
            } else {
                builder.setSmallIcon(R.drawable.tb_launcher_icon_notify);
            }
            return builder.build();
        }
        return (Notification) invokeL.objValue;
    }

    public static Notification createNotificationByAPI(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z, RemoteViews remoteViews, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3, pendingIntent, Boolean.valueOf(z), remoteViews, Boolean.valueOf(z2)})) == null) {
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    if (PROGRESS_BUILDER == null) {
                        PROGRESS_BUILDER = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL);
                    }
                    if (i != lastProgressNotifiyId) {
                        PROGRESS_BUILDER.setWhen(System.currentTimeMillis());
                    }
                    lastProgressNotifiyId = i;
                    PROGRESS_BUILDER.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i2, false).setLargeIcon(getLargeIcon());
                    PROGRESS_BUILDER.setContent(remoteViews);
                    Notification build = PROGRESS_BUILDER.build();
                    build.contentIntent = pendingIntent;
                    return build;
                }
                if (PROGRESS_BUILDER_2 == null) {
                    PROGRESS_BUILDER_2 = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL_2);
                }
                if (i != lastProgressNotifiyId) {
                    PROGRESS_BUILDER_2.setWhen(System.currentTimeMillis());
                }
                lastProgressNotifiyId = i;
                PROGRESS_BUILDER_2.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i2, false).setLargeIcon(getLargeIcon());
                PROGRESS_BUILDER_2.setContent(remoteViews);
                Notification build2 = PROGRESS_BUILDER_2.build();
                build2.contentIntent = pendingIntent;
                return build2;
            } catch (Exception unused) {
                return notif_excption(context);
            }
        }
        return (Notification) invokeCommon.objValue;
    }

    public static SwitchData getSwitchData(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            SwitchData switchData = new SwitchData();
            if (!y95.O() && y95.U()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - TbadkCoreApplication.getInst().getLastNotifyTime() >= 5000) {
                    AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                    if (audioManager.getRingerMode() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (audioManager.getRingerMode() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (aa5.e().C()) {
                        switchData.isSound = true;
                        if (z || z2) {
                            switchData.isSound = false;
                        }
                    }
                    if (aa5.e().D()) {
                        switchData.isVibrate = true;
                        if (z) {
                            switchData.isVibrate = false;
                        }
                        if (z2) {
                            switchData.isVibrate = true;
                        }
                    }
                    TbadkCoreApplication.getInst().setLastNotifyTime(currentTimeMillis);
                }
            }
            if (aa5.e().y()) {
                switchData.isLight = true;
            }
            return switchData;
        }
        return (SwitchData) invokeL.objValue;
    }

    public static boolean processNotification(Context context, int i, Notification notification) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, context, i, notification)) == null) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_2, he.a(R.string.notify_channel_primary), 3);
                    notificationChannel.setLightColor(BaseAnimatedElement.DEBUG_PAINT_COLOR);
                    notificationChannel.setLockscreenVisibility(0);
                    notificationChannel.enableVibration(false);
                    notificationChannel.setSound(null, null);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                if (notification == null || notificationManager == null) {
                    return false;
                }
                notificationManager.notify(context.getPackageName(), i, notification);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static boolean processNotificationWithSoundAndVibration(Context context, int i, Notification notification, SwitchData switchData) {
        InterceptResult invokeLILL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65550, null, context, i, notification, switchData)) == null) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (Build.VERSION.SDK_INT >= 26) {
                    if (switchData.isSound) {
                        str = PRIMARY_CHANNEL_3;
                    } else {
                        str = PRIMARY_CHANNEL_2;
                    }
                    NotificationChannel notificationChannel = new NotificationChannel(str, he.a(R.string.notify_channel_primary), 3);
                    notificationChannel.setLightColor(BaseAnimatedElement.DEBUG_PAINT_COLOR);
                    notificationChannel.setLockscreenVisibility(0);
                    notificationChannel.enableVibration(switchData.isVibrate);
                    if (!switchData.isSound) {
                        notificationChannel.setSound(null, null);
                    }
                    notificationChannel.enableLights(switchData.isLight);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                if (notification == null || notificationManager == null) {
                    return false;
                }
                notificationManager.notify(context.getPackageName(), i, notification);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLILL.booleanValue;
    }

    public static boolean showBaseNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, RemoteViews remoteViews, Bitmap bitmap, boolean z) {
        InterceptResult invokeCommon;
        Notification notif_excption;
        NotificationCompat.Builder builder;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, Integer.valueOf(i), str, str2, str3, pendingIntent, remoteViews, bitmap, Boolean.valueOf(z)})) == null) {
            if (pendingIntent == null) {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
            }
            SwitchData switchData = getSwitchData(context);
            if (switchData == null) {
                return false;
            }
            if (qd.isEmpty(str)) {
                str = context.getString(R.string.obfuscated_res_0x7f0f029e);
            }
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL);
                } else {
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    if (switchData.isSound) {
                        str4 = PRIMARY_CHANNEL_3;
                    } else {
                        str4 = PRIMARY_CHANNEL_2;
                    }
                    builder = new NotificationCompat.Builder(inst, str4);
                }
                builder.setContentTitle(str).setContentText(str2).setTicker(str3);
                processNotificationIcon(builder);
                if (bitmap != null) {
                    builder.setLargeIcon(bitmap);
                }
                builder.setContent(remoteViews);
                notif_excption = builder.build();
                notif_excption.contentIntent = pendingIntent;
            } catch (Exception unused) {
                notif_excption = notif_excption(context);
            }
            if (notif_excption == null) {
                return false;
            }
            notif_excption.defaults = -1;
            if (!switchData.isVibrate) {
                notif_excption.defaults = (-1) & (-3);
            }
            notif_excption.audioStreamType = 1;
            if (!switchData.isSound) {
                notif_excption.defaults &= -2;
            }
            if (z) {
                notif_excption.flags = 34;
            } else {
                notif_excption.flags |= 16;
            }
            if (switchData.isLight) {
                notif_excption.defaults &= -5;
                notif_excption.ledARGB = BaseAnimatedElement.DEBUG_PAINT_COLOR;
                notif_excption.ledOnMS = 400;
                notif_excption.ledOffMS = 700;
                notif_excption.flags = 1 | notif_excption.flags;
            }
            return processNotificationWithSoundAndVibration(context, i, notif_excption, switchData);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean showCustomViewNotification(Context context, int i, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Integer.valueOf(i), str, str2, pendingIntent, remoteViews, Boolean.valueOf(z)})) == null) {
            return showBaseNotification(context, i, str, null, str2, pendingIntent, remoteViews, null, z);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean showNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, Integer.valueOf(i), str, str2, str3, pendingIntent, Boolean.valueOf(z)})) == null) {
            return showBaseNotification(context, i, str, str2, str3, pendingIntent, null, null, z);
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        boolean showProgressNotification;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{context, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3, Boolean.valueOf(z)})) == null) {
            synchronized (NotificationHelper.class) {
                showProgressNotification = showProgressNotification(context, i, str, i2, str2, str3, null, z);
            }
            return showProgressNotification;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean showLargeIconNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, Bitmap bitmap, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, Integer.valueOf(i), str, str2, str3, pendingIntent, bitmap, Boolean.valueOf(z)})) == null) {
            return showBaseNotification(context, i, str, str2, str3, pendingIntent, null, bitmap, z);
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        InterceptResult invokeCommon;
        boolean showProgressNotification;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3, pendingIntent, Boolean.valueOf(z)})) == null) {
            synchronized (NotificationHelper.class) {
                showProgressNotification = showProgressNotification(context, i, str, i2, str2, str3, pendingIntent, z, null, true);
            }
            return showProgressNotification;
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z, RemoteViews remoteViews, boolean z2) {
        InterceptResult invokeCommon;
        PendingIntent activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{context, Integer.valueOf(i), str, Integer.valueOf(i2), str2, str3, pendingIntent, Boolean.valueOf(z), remoteViews, Boolean.valueOf(z2)})) == null) {
            synchronized (NotificationHelper.class) {
                if (pendingIntent == null) {
                    activity = PendingIntent.getActivity(context, 0, new Intent(), 0);
                } else {
                    activity = pendingIntent;
                }
                if (!IS_SUPPORT_PROGRESS_NOTIFICATION) {
                    return showNotification(context, i, str3, str3, str, activity, z);
                }
                Notification createNotificationByAPI = createNotificationByAPI(context, i, str, i2, str2, str3, activity, z, remoteViews, z2);
                if (createNotificationByAPI == null) {
                    return false;
                }
                if (z2) {
                    if (!z) {
                        createNotificationByAPI.flags = 16;
                    } else {
                        createNotificationByAPI.flags = 2;
                    }
                }
                return processNotification(context, i, createNotificationByAPI);
            }
        }
        return invokeCommon.booleanValue;
    }
}
