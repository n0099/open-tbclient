package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CustomNotification {
    public static /* synthetic */ Interceptable $ic = null;
    public static String mChannel = "down";
    @DrawableRes
    public static int mSmallIcon = 17301634;
    public transient /* synthetic */ FieldHolder $fh;
    public NotificationCompat.Style mStyle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-743886332, "Lcom/baidu/mobads/sdk/api/CustomNotification;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-743886332, "Lcom/baidu/mobads/sdk/api/CustomNotification;");
        }
    }

    public CustomNotification() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStyle = new NotificationCompat.DecoratedCustomViewStyle();
    }

    public static void initNotification(@DrawableRes int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i, str) == null) {
            mSmallIcon = i;
            if (!TextUtils.isEmpty(str)) {
                mChannel = str;
            }
        }
    }

    public static void setNotificationChannel(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && !TextUtils.isEmpty(str)) {
            mChannel = str;
        }
    }

    public static void setNotificationIcon(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            mSmallIcon = i;
        }
    }

    private void setRemoteViewText(RemoteViews remoteViews, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65541, this, remoteViews, i, str) == null) && remoteViews != null) {
            if (!TextUtils.isEmpty(str)) {
                remoteViews.setTextViewText(i, str);
                remoteViews.setViewVisibility(i, 0);
                return;
            }
            remoteViews.setViewVisibility(i, 8);
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i, int i2, String str6, PendingIntent pendingIntent) {
        InterceptResult invokeCommon;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, bitmap, str3, str4, str5, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str6, pendingIntent})) == null) {
            if (bj.a(context).a() < 26) {
                builder = new NotificationCompat.Builder(context);
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = "down";
                }
                try {
                    builder = new NotificationCompat.Builder(context, str);
                } catch (NoSuchMethodError unused) {
                    builder = new NotificationCompat.Builder(context);
                }
            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.obfuscated_res_0x7f0d062b);
            if (bitmap != null) {
                remoteViews.setImageViewBitmap(R.id.obfuscated_res_0x7f0914ff, bitmap);
            } else {
                remoteViews.setImageViewResource(R.id.obfuscated_res_0x7f0914ff, R.drawable.obfuscated_res_0x7f0807f8);
            }
            setRemoteViewText(remoteViews, R.id.obfuscated_res_0x7f0919e5, str3);
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f0907dd, 8);
            } else {
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f0907dd, 0);
                setRemoteViewText(remoteViews, R.id.obfuscated_res_0x7f0907e3, str4);
                setRemoteViewText(remoteViews, R.id.obfuscated_res_0x7f0907e2, str5);
            }
            if (i >= 0 && i <= 100) {
                remoteViews.setProgressBar(R.id.obfuscated_res_0x7f091da4, 100, i, false);
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f091da4, 0);
            } else {
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f091da4, 8);
            }
            remoteViews.setTextViewText(R.id.obfuscated_res_0x7f0904ad, str6);
            remoteViews.setOnClickPendingIntent(R.id.obfuscated_res_0x7f0904ad, pendingIntent);
            return builder.setSmallIcon(i2).setOngoing(false).setTicker(str2).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
        }
        return (Notification) invokeCommon.objValue;
    }

    @TargetApi(16)
    public Notification getNewNotification(Context context, String str, boolean z, Bitmap bitmap, String str2, String str3, int i, boolean z2, String str4, PendingIntent pendingIntent, String str5, PendingIntent pendingIntent2) {
        InterceptResult invokeCommon;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Boolean.valueOf(z), bitmap, str2, str3, Integer.valueOf(i), Boolean.valueOf(z2), str4, pendingIntent, str5, pendingIntent2})) == null) {
            if (bj.a(context).a() < 26) {
                builder = new NotificationCompat.Builder(context);
            } else {
                try {
                    builder = new NotificationCompat.Builder(context, mChannel);
                } catch (NoSuchMethodError unused) {
                    builder = new NotificationCompat.Builder(context);
                }
            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.obfuscated_res_0x7f0d0140);
            if (bitmap != null) {
                remoteViews.setImageViewBitmap(R.id.obfuscated_res_0x7f09100b, bitmap);
            } else {
                remoteViews.setImageViewResource(R.id.obfuscated_res_0x7f09100b, R.drawable.obfuscated_res_0x7f0807f8);
            }
            setRemoteViewText(remoteViews, R.id.obfuscated_res_0x7f0925a7, str2);
            setRemoteViewText(remoteViews, R.id.obfuscated_res_0x7f09088f, str3);
            if (i >= 0 && i <= 100) {
                remoteViews.setProgressBar(R.id.obfuscated_res_0x7f091d9d, 100, i, z2);
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f091d9d, 0);
            } else {
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f091d9d, 8);
            }
            remoteViews.setTextViewText(R.id.obfuscated_res_0x7f090525, str4);
            remoteViews.setOnClickPendingIntent(R.id.obfuscated_res_0x7f090525, pendingIntent);
            if (TextUtils.isEmpty(str5)) {
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f090526, 8);
            } else {
                remoteViews.setViewVisibility(R.id.obfuscated_res_0x7f090526, 0);
                remoteViews.setTextViewText(R.id.obfuscated_res_0x7f090526, str5);
                remoteViews.setOnClickPendingIntent(R.id.obfuscated_res_0x7f090526, pendingIntent2);
            }
            return builder.setStyle(this.mStyle).setSmallIcon(mSmallIcon).setOngoing(false).setTicker(str).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
        }
        return (Notification) invokeCommon.objValue;
    }
}
