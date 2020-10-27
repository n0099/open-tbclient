package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f1052a = "NotificationBuilderManager";
    private static String b = "notification_builder_storage";
    private static Object c = new Object();
    private static int d = 0;

    public static Notification a(Context context, int i, int i2, String str, String str2, boolean z) {
        Notification construct;
        synchronized (c) {
            PushNotificationBuilder a2 = a(context, i);
            a2.setNotificationTitle(str);
            a2.setNotificationText(str2);
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
                    construct.defaults |= 1;
                } else {
                    construct.defaults &= -2;
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

    public static Notification a(Context context, int i, String str, String str2, boolean z) {
        Notification construct;
        synchronized (c) {
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

    private static PushNotificationBuilder a(Context context) {
        BasicPushNotificationBuilder basicPushNotificationBuilder = new BasicPushNotificationBuilder();
        basicPushNotificationBuilder.setNotificationFlags(16);
        basicPushNotificationBuilder.setNotificationDefaults(3);
        basicPushNotificationBuilder.setStatusbarIcon(context.getApplicationInfo().icon);
        return basicPushNotificationBuilder;
    }

    private static PushNotificationBuilder a(Context context, int i) {
        PushNotificationBuilder pushNotificationBuilder;
        Exception e;
        String string = context.getSharedPreferences(b, 0).getString("" + i, null);
        if (string == null) {
            return b(context);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                return pushNotificationBuilder;
            } catch (Exception e2) {
                e = e2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return pushNotificationBuilder;
            }
        } catch (Exception e3) {
            pushNotificationBuilder = null;
            e = e3;
        }
    }

    public static void a(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (c) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                SharedPreferences.Editor edit = context.getSharedPreferences(b, 0).edit();
                edit.putString("" + i, encodeToString);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public static void a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (c) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                SharedPreferences.Editor edit = context.getSharedPreferences(b, 0).edit();
                edit.putString("" + d, encodeToString);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    private static PushNotificationBuilder b(Context context) {
        PushNotificationBuilder pushNotificationBuilder;
        Exception e;
        String string = context.getSharedPreferences(b, 0).getString("" + d, null);
        if (string == null) {
            return a(context);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                return pushNotificationBuilder;
            } catch (Exception e2) {
                e = e2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return pushNotificationBuilder;
            }
        } catch (Exception e3) {
            pushNotificationBuilder = null;
            e = e3;
        }
    }
}
