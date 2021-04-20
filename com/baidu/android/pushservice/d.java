package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f2974a = "NotificationBuilderManager";

    /* renamed from: b  reason: collision with root package name */
    public static String f2975b = "notification_builder_storage";

    /* renamed from: c  reason: collision with root package name */
    public static Object f2976c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static int f2977d;

    public static Notification a(Context context, int i, int i2, String str, String str2, boolean z) {
        Notification construct;
        synchronized (f2976c) {
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

    public static Notification a(Context context, int i, String str, String str2, boolean z) {
        Notification construct;
        synchronized (f2976c) {
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

    public static PushNotificationBuilder a(Context context) {
        BasicPushNotificationBuilder basicPushNotificationBuilder = new BasicPushNotificationBuilder();
        basicPushNotificationBuilder.setNotificationFlags(16);
        basicPushNotificationBuilder.setNotificationDefaults(3);
        basicPushNotificationBuilder.setStatusbarIcon(context.getApplicationInfo().icon);
        return basicPushNotificationBuilder;
    }

    public static PushNotificationBuilder a(Context context, int i) {
        PushNotificationBuilder pushNotificationBuilder = null;
        String string = context.getSharedPreferences(f2975b, 0).getString("" + i, null);
        if (string == null) {
            return b(context);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string.getBytes(), 2));
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            PushNotificationBuilder pushNotificationBuilder2 = (PushNotificationBuilder) objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                return pushNotificationBuilder2;
            } catch (Exception e2) {
                e = e2;
                pushNotificationBuilder = pushNotificationBuilder2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return pushNotificationBuilder;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void a(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (f2976c) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                SharedPreferences.Editor edit = context.getSharedPreferences(f2975b, 0).edit();
                edit.putString("" + i, encodeToString);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (f2976c) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                SharedPreferences.Editor edit = context.getSharedPreferences(f2975b, 0).edit();
                edit.putString("" + f2977d, encodeToString);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static PushNotificationBuilder b(Context context) {
        ObjectInputStream objectInputStream;
        PushNotificationBuilder pushNotificationBuilder;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f2975b, 0);
        PushNotificationBuilder pushNotificationBuilder2 = null;
        String string = sharedPreferences.getString("" + f2977d, null);
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
}
