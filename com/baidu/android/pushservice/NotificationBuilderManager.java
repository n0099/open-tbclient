package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.x.k;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
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
/* loaded from: classes.dex */
public class NotificationBuilderManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "notification_builder_storage";
    public static Object b;
    public static int c;
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
        b = new Object();
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

    public static Notification a(Context context, int i, int i2, String str, String str2, boolean z, Bitmap bitmap, String str3, String str4) {
        InterceptResult invokeCommon;
        Notification construct;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), str, str2, Boolean.valueOf(z), bitmap, str3, str4})) == null) {
            synchronized (b) {
                PushNotificationBuilder a2 = a(context, i);
                a2.setNotificationTitle(str);
                a2.setNotificationText(str2);
                a2.setLargeIcon(bitmap);
                a2.setNotificationGroup(str3);
                a2.setChannelId(str4);
                construct = a2.construct(context);
                construct.flags = (i2 & 1) != 0 ? construct.flags & (-33) : construct.flags | 32;
                if (z) {
                    construct.defaults = 0;
                } else {
                    int i3 = -1;
                    construct.defaults = -1;
                    int i4 = i2 & 4;
                    if (i4 == 0) {
                        i3 = -2;
                    }
                    construct.defaults = i3;
                    int i5 = i2 & 2;
                    construct.defaults = i5 != 0 ? i3 | 2 : i3 & (-3);
                    if (i4 == 0 && i5 == 0) {
                        construct = a(context, construct);
                    }
                }
            }
            return construct;
        }
        return (Notification) invokeCommon.objValue;
    }

    public static Notification a(Context context, int i, String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Notification construct;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), str, str2, Boolean.valueOf(z), str3, str4, str5, str6})) == null) {
            synchronized (b) {
                PushNotificationBuilder a2 = a(context, i);
                a2.setNotificationTitle(str);
                a2.setNotificationText(str2);
                a2.setNotificationBuilderId(i);
                a2.setNotificationBuilderRes(str3);
                a2.setLargeIconUrl(str4);
                a2.setSummary(str5);
                a2.setNotificationGroup(str6);
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

    public static Notification a(Context context, Notification notification) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, notification)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return notification;
            }
            try {
                Class.forName("androidx.core.app.NotificationCompat");
                return new NotificationCompat.Builder(context, notification).setSilent(true).build();
            } catch (Throwable unused) {
                return notification;
            }
        }
        return (Notification) invokeLL.objValue;
    }

    public static Notification a(Context context, Notification notification, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, notification, str)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return null;
            }
            try {
                Class.forName("androidx.core.app.NotificationCompat");
                NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context, notification).setGroupSummary(true);
                if (!TextUtils.isEmpty(str)) {
                    groupSummary.setSubText(str);
                }
                return groupSummary.build();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Notification) invokeLLL.objValue;
    }

    public static PushNotificationBuilder a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            if (i < 100 && i > c) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
                String string = sharedPreferences.getString("" + i, null);
                if (string != null) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        PushNotificationBuilder pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
                        objectInputStream.close();
                        byteArrayInputStream.close();
                        return pushNotificationBuilder;
                    } catch (Exception unused) {
                    }
                }
            } else if (i >= 100) {
                return b(context);
            }
            return c(context);
        }
        return (PushNotificationBuilder) invokeLI.objValue;
    }

    public static void a(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, context, i, pushNotificationBuilder) == null) {
            synchronized (b) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(pushNotificationBuilder);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    SharedPreferences.Editor edit = context.getSharedPreferences(a, 0).edit();
                    edit.putString("" + i, encodeToString);
                    edit.commit();
                    byteArrayOutputStream.close();
                    objectOutputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, pushNotificationBuilder) == null) {
            synchronized (b) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(pushNotificationBuilder);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    SharedPreferences.Editor edit = context.getSharedPreferences(a, 0).edit();
                    edit.putString("" + c, encodeToString);
                    edit.commit();
                    byteArrayOutputStream.close();
                    objectOutputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(Context context, PublicMsg publicMsg, Notification notification) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, context, publicMsg, notification) == null) || Build.VERSION.SDK_INT < 24 || TextUtils.isEmpty(notification.getGroup()) || publicMsg == null || !TextUtils.equals(publicMsg.mGroup, notification.getGroup())) {
            return;
        }
        Notification a2 = a(context, notification, publicMsg.mSummary);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null || a2 == null) {
            return;
        }
        try {
            notificationManager.notify(publicMsg.mGroupNotifyId, a2);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, PublicMsg publicMsg, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, publicMsg, pushCallBackExtra) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.pass_through_notify_ARRIVE");
            intent.setClassName(context.getPackageName(), Utility.b(context, context.getPackageName(), "com.baidu.android.pushservice.action.RECEIVE"));
            intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
            intent.putExtra("notification_title", publicMsg.mTitle);
            intent.putExtra("notification_content", publicMsg.mDescription);
            if (pushCallBackExtra != null) {
                intent.putExtra("extra_extra_push_call_back", Utility.a(pushCallBackExtra));
            }
            context.sendBroadcast(intent);
        }
    }

    public static boolean a(Context context, String str, int i, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65548, null, context, str, i, pushCallBackExtra)) == null) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                PublicMsg a2 = com.baidu.android.pushservice.w.m.j.a(context, "", "", str.getBytes());
                Bitmap a3 = TextUtils.isEmpty(a2.mImgUrl) ? null : com.baidu.android.pushservice.q.a.a().a(a2.mImgUrl);
                boolean o = Utility.o(context, a2.mPkgName);
                Notification a4 = a2.mNotificationBuilder == 0 ? a(context, a2.mNotificationBuilder, a2.mNotificationBasicStyle, a2.mTitle, a2.mDescription, o, a3, a2.mGroup, "") : a(context, a2.mNotificationBuilder, a2.mTitle, a2.mDescription, o, a2.mBuilderRes, a2.mImgUrl, a2.mSummary, a2.mGroup);
                if (pushCallBackExtra != null && k.a && a2.mNotificationBuilder >= 100) {
                    pushCallBackExtra.logExt = com.baidu.android.pushservice.w.m.e.a(pushCallBackExtra.logExt, "c_downgrade", 1);
                }
                Intent intent = new Intent("com.baidu.android.pushservice.action.pass_through_notify_CLICK");
                intent.setClassName(context.getPackageName(), PushNotifyDispatchActivity.class.getName());
                intent.putExtra("extra_extra_custom_content", a2.mCustomContent);
                intent.putExtra("notification_title", a2.mTitle);
                intent.putExtra("notification_content", a2.mDescription);
                if (pushCallBackExtra != null) {
                    intent.putExtra("extra_extra_push_call_back", Utility.a(pushCallBackExtra));
                }
                a4.contentIntent = PendingIntent.getActivity(context, 0, intent, Utility.a((int) LaunchTaskConstants.OTHER_PROCESS));
                notificationManager.notify(i, a4);
                a(context, a2, a4);
                a(context, a2, pushCallBackExtra);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLIL.booleanValue;
    }

    public static PushNotificationBuilder b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            k kVar = new k();
            kVar.setNotificationFlags(16);
            kVar.setNotificationDefaults(3);
            kVar.setStatusbarIcon(context.getApplicationInfo().icon);
            return kVar;
        }
        return (PushNotificationBuilder) invokeL.objValue;
    }

    public static PushNotificationBuilder c(Context context) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        PushNotificationBuilder pushNotificationBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            PushNotificationBuilder pushNotificationBuilder2 = null;
            String string = sharedPreferences.getString("" + c, null);
            if (string != null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
                } catch (Exception unused) {
                }
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pushNotificationBuilder;
                } catch (Exception unused2) {
                    pushNotificationBuilder2 = pushNotificationBuilder;
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
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65551, null, context, str, i)) == null) ? a(context, str, i, null) : invokeLLI.booleanValue;
    }
}
