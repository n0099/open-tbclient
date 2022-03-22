package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes3.dex */
public class NotificationBuilderManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "NotificationBuilderManager";

    /* renamed from: b  reason: collision with root package name */
    public static String f24132b = "notification_builder_storage";

    /* renamed from: c  reason: collision with root package name */
    public static Object f24133c;

    /* renamed from: d  reason: collision with root package name */
    public static int f24134d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1545201604, "Lcom/baidu/android/pushservice/NotificationBuilderManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1545201604, "Lcom/baidu/android/pushservice/NotificationBuilderManager;");
                return;
            }
        }
        f24133c = new Object();
    }

    public NotificationBuilderManager() {
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

    public static Notification a(Context context, int i, int i2, String str, String str2, boolean z, Bitmap bitmap) {
        InterceptResult invokeCommon;
        Notification construct;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), str, str2, Boolean.valueOf(z), bitmap})) == null) {
            synchronized (f24133c) {
                PushNotificationBuilder a2 = a(context, i);
                a2.setNotificationTitle(str);
                a2.setNotificationText(str2);
                a2.setLargeIcon(bitmap);
                construct = a2.construct(context);
                if ((i2 & 1) != 0) {
                    construct.flags &= -33;
                } else {
                    construct.flags |= 32;
                }
                if (z) {
                    construct.defaults = 0;
                } else {
                    construct.defaults = -1;
                    if ((i2 & 4) != 0) {
                        construct.defaults = (-1) | 1;
                    } else {
                        construct.defaults = (-1) & (-2);
                    }
                    if ((i2 & 2) != 0) {
                        construct.defaults |= 2;
                    } else {
                        construct.defaults &= -3;
                    }
                }
            }
            return construct;
        }
        return (Notification) invokeCommon.objValue;
    }

    public static Notification a(Context context, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Notification construct;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            synchronized (f24133c) {
                PushNotificationBuilder a2 = a(context, i);
                a2.setNotificationTitle(str);
                a2.setNotificationText(str2);
                construct = a2.construct(context);
                if (z) {
                    construct.defaults = -1;
                } else {
                    construct.defaults = 0;
                }
            }
            return construct;
        }
        return (Notification) invokeCommon.objValue;
    }

    public static PushNotificationBuilder a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            BasicPushNotificationBuilder basicPushNotificationBuilder = new BasicPushNotificationBuilder();
            basicPushNotificationBuilder.setNotificationFlags(16);
            basicPushNotificationBuilder.setNotificationDefaults(3);
            basicPushNotificationBuilder.setStatusbarIcon(context.getApplicationInfo().icon);
            return basicPushNotificationBuilder;
        }
        return (PushNotificationBuilder) invokeL.objValue;
    }

    public static PushNotificationBuilder a(Context context, int i) {
        InterceptResult invokeLI;
        ObjectInputStream objectInputStream;
        PushNotificationBuilder pushNotificationBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            PushNotificationBuilder pushNotificationBuilder2 = null;
            String string = context.getSharedPreferences(f24132b, 0).getString("" + i, null);
            if (string != null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pushNotificationBuilder;
                } catch (Exception e3) {
                    e = e3;
                    pushNotificationBuilder2 = pushNotificationBuilder;
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                    return pushNotificationBuilder2;
                }
            }
            return b(context);
        }
        return (PushNotificationBuilder) invokeLI.objValue;
    }

    public static void a(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, context, i, pushNotificationBuilder) == null) {
            synchronized (f24133c) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(pushNotificationBuilder);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    SharedPreferences.Editor edit = context.getSharedPreferences(f24132b, 0).edit();
                    edit.putString("" + i, encodeToString);
                    edit.commit();
                    byteArrayOutputStream.close();
                    objectOutputStream.close();
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static void a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, pushNotificationBuilder) == null) {
            synchronized (f24133c) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(pushNotificationBuilder);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    SharedPreferences.Editor edit = context.getSharedPreferences(f24132b, 0).edit();
                    edit.putString("" + f24134d, encodeToString);
                    edit.commit();
                    byteArrayOutputStream.close();
                    objectOutputStream.close();
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static PushNotificationBuilder b(Context context) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        PushNotificationBuilder pushNotificationBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f24132b, 0);
            PushNotificationBuilder pushNotificationBuilder2 = null;
            String string = sharedPreferences.getString("" + f24134d, null);
            if (string != null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pushNotificationBuilder;
                } catch (Exception e3) {
                    e = e3;
                    pushNotificationBuilder2 = pushNotificationBuilder;
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                    return pushNotificationBuilder2;
                }
            }
            return a(context);
        }
        return (PushNotificationBuilder) invokeL.objValue;
    }

    public static boolean showNotification(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, context, str, i)) == null) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                PublicMsg a2 = com.baidu.android.pushservice.message.a.i.a(context, "", "", str.getBytes());
                Bitmap a3 = TextUtils.isEmpty(a2.mImgUrl) ? null : com.baidu.android.pushservice.d.a.a().a(a2.mImgUrl);
                boolean h2 = m.h(context, a2.mPkgName);
                Notification a4 = a2.mNotificationBuilder == 0 ? a(context, a2.mNotificationBuilder, a2.mNotificationBasicStyle, a2.mTitle, a2.mDescription, h2, a3) : a(context, a2.mNotificationBuilder, a2.mTitle, a2.mDescription, h2);
                String b2 = m.b(context, context.getPackageName(), "com.baidu.android.pushservice.action.RECEIVE");
                Intent intent = new Intent("com.baidu.android.pushservice.action.pass_through_notify_CLICK");
                intent.setClassName(context.getPackageName(), b2);
                intent.putExtra("extra_extra_custom_content", a2.mCustomContent);
                intent.putExtra("notification_title", a2.mTitle);
                intent.putExtra("notification_content", a2.mDescription);
                a4.contentIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                notificationManager.notify(i, a4);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }
}
