package com.baidu.android.pushservice.ach.e;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15995, null, context) : invokeL.intValue;
    }

    public static NotificationChannel a(NotificationManager notificationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, notificationManager)) == null) ? (NotificationChannel) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15990, null, notificationManager) : (NotificationChannel) invokeL.objValue;
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, intent) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15989, null, context, intent);
        }
    }

    public static void a(Context context, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, cls) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15992, null, context, cls);
        }
    }

    public static NotificationChannel b(NotificationManager notificationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, notificationManager)) == null) ? (NotificationChannel) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15991, null, notificationManager) : (NotificationChannel) invokeL.objValue;
    }

    public static NotificationChannel b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? (NotificationChannel) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15986, null, context) : (NotificationChannel) invokeL.objValue;
    }

    public static Notification c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? (Notification) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15985, null, context) : (Notification) invokeL.objValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15988, null, context) : invokeL.booleanValue;
    }
}
