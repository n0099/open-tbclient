package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes6.dex */
public class c {
    private static String a = "NotificationBuilderManager";
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
        String string = context.getSharedPreferences(b, 0).getString("" + i, null);
        if (string != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(com.baidu.android.pushservice.j.b.a(string.getBytes()));
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                PushNotificationBuilder pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pushNotificationBuilder;
                } catch (Exception e) {
                    return pushNotificationBuilder;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return b(context);
    }

    public static void a(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (c) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String a2 = com.baidu.android.pushservice.j.b.a(byteArrayOutputStream.toByteArray(), "US-ASCII");
                SharedPreferences.Editor edit = context.getSharedPreferences(b, 0).edit();
                edit.putString("" + i, a2);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (c) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String a2 = com.baidu.android.pushservice.j.b.a(byteArrayOutputStream.toByteArray(), "US-ASCII");
                SharedPreferences.Editor edit = context.getSharedPreferences(b, 0).edit();
                edit.putString("" + d, a2);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
            }
        }
    }

    private static PushNotificationBuilder b(Context context) {
        String string = context.getSharedPreferences(b, 0).getString("" + d, null);
        if (string != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(com.baidu.android.pushservice.j.b.a(string.getBytes()));
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                PushNotificationBuilder pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pushNotificationBuilder;
                } catch (Exception e) {
                    return pushNotificationBuilder;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return a(context);
    }

    public static void b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        a(context, 8888, pushNotificationBuilder);
    }
}
