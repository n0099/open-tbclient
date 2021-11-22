package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f36069a = "NotificationBuilderManager";

    /* renamed from: b  reason: collision with root package name */
    public static String f36070b = "notification_builder_storage";

    /* renamed from: c  reason: collision with root package name */
    public static Object f36071c;

    /* renamed from: d  reason: collision with root package name */
    public static int f36072d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840927047, "Lcom/baidu/android/pushservice/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840927047, "Lcom/baidu/android/pushservice/d;");
                return;
            }
        }
        f36071c = new Object();
    }

    public static Notification a(Context context, int i2, int i3, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Notification construct;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str, str2, Boolean.valueOf(z)})) == null) {
            synchronized (f36071c) {
                PushNotificationBuilder a2 = a(context, i2);
                a2.setNotificationTitle(str);
                a2.setNotificationText(str2);
                construct = a2.construct(context);
                if ((i3 & 1) != 0) {
                    construct.flags &= -33;
                } else {
                    construct.flags |= 32;
                }
                if (z) {
                    construct.defaults = 0;
                } else {
                    construct.defaults = -1;
                    if ((i3 & 4) != 0) {
                        construct.defaults = (-1) | 1;
                    } else {
                        construct.defaults = (-1) & (-2);
                    }
                    if ((i3 & 2) != 0) {
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

    public static Notification a(Context context, int i2, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Notification construct;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), str, str2, Boolean.valueOf(z)})) == null) {
            synchronized (f36071c) {
                PushNotificationBuilder a2 = a(context, i2);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            BasicPushNotificationBuilder basicPushNotificationBuilder = new BasicPushNotificationBuilder();
            basicPushNotificationBuilder.setNotificationFlags(16);
            basicPushNotificationBuilder.setNotificationDefaults(3);
            basicPushNotificationBuilder.setStatusbarIcon(context.getApplicationInfo().icon);
            return basicPushNotificationBuilder;
        }
        return (PushNotificationBuilder) invokeL.objValue;
    }

    public static PushNotificationBuilder a(Context context, int i2) {
        InterceptResult invokeLI;
        ObjectInputStream objectInputStream;
        PushNotificationBuilder pushNotificationBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            PushNotificationBuilder pushNotificationBuilder2 = null;
            String string = context.getSharedPreferences(f36070b, 0).getString("" + i2, null);
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

    public static void a(Context context, int i2, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, context, i2, pushNotificationBuilder) == null) {
            synchronized (f36071c) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(pushNotificationBuilder);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    SharedPreferences.Editor edit = context.getSharedPreferences(f36070b, 0).edit();
                    edit.putString("" + i2, encodeToString);
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, pushNotificationBuilder) == null) {
            synchronized (f36071c) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(pushNotificationBuilder);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    SharedPreferences.Editor edit = context.getSharedPreferences(f36070b, 0).edit();
                    edit.putString("" + f36072d, encodeToString);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f36070b, 0);
            PushNotificationBuilder pushNotificationBuilder2 = null;
            String string = sharedPreferences.getString("" + f36072d, null);
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
}
