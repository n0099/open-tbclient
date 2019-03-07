package cn.jpush.android.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a.l;
import cn.jpush.android.d.f;
import cn.jpush.android.d.j;
import cn.jpush.android.data.g;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.ui.PopWinActivity;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Adler32;
/* loaded from: classes3.dex */
public final class c {
    private static boolean a = false;

    public static int a(int i) {
        int i2;
        switch (i) {
            case -1:
                try {
                    i2 = a("R$drawable", new String[]{"jpush_notification_icon"}).get("jpush_notification_icon").intValue();
                } catch (Exception e) {
                    i2 = 0;
                }
                if (i2 <= 0) {
                    return 17301618;
                }
                return i2;
            case 0:
                return 17301647;
            case 1:
            default:
                return 17301586;
            case 2:
                return 17301618;
            case 3:
                return 17301567;
        }
    }

    private static int a(cn.jpush.android.data.b bVar, int i) {
        String str = bVar.c;
        if (!TextUtils.isEmpty(bVar.d)) {
            str = bVar.d;
        }
        return a(str, i);
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e) {
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            if (value < 0) {
                value = Math.abs(value);
            }
            int i2 = value + (13889152 * i);
            return i2 < 0 ? Math.abs(i2) : i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
        if (r1 > 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
        r2 = r8[0];
        r0.put(r2, java.lang.Integer.valueOf(r5.getDeclaredField(r2).getInt(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HashMap<String, Integer> a(String str, String[] strArr) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("parameter resType or fieldNames error.");
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            Class<?>[] declaredClasses = Class.forName(cn.jpush.android.a.e.getPackageName() + ".R").getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Class<?> cls = declaredClasses[i2];
                if (cls.getName().contains(str)) {
                    break;
                }
                i2++;
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x001f: IGET  (r3v0 int A[REMOVE]) = (r4v0 cn.jpush.android.data.b) cn.jpush.android.data.b.l int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x006d: IGET  (r3v1 int A[REMOVE]) = (r4v0 cn.jpush.android.data.b) cn.jpush.android.data.b.A int)] */
    public static Map<String, String> a(cn.jpush.android.data.b bVar) {
        HashMap hashMap = new HashMap();
        if (bVar != null) {
            hashMap.put(JPushInterface.EXTRA_MSG_ID, bVar.c);
            hashMap.put(JPushInterface.EXTRA_ALERT, bVar.v);
            hashMap.put(JPushInterface.EXTRA_ALERT_TYPE, new StringBuilder().append(bVar.l).toString());
            if (!TextUtils.isEmpty(bVar.u)) {
                hashMap.put(JPushInterface.EXTRA_NOTIFICATION_TITLE, bVar.u);
            }
            if (!TextUtils.isEmpty(bVar.n)) {
                hashMap.put(JPushInterface.EXTRA_EXTRA, bVar.n);
            }
            if (bVar.w == 1 && !TextUtils.isEmpty(bVar.x)) {
                hashMap.put(JPushInterface.EXTRA_BIG_TEXT, bVar.x);
            } else if (bVar.w == 2 && !TextUtils.isEmpty(bVar.z)) {
                hashMap.put(JPushInterface.EXTRA_INBOX, bVar.z);
            } else if (bVar.w == 3 && !TextUtils.isEmpty(bVar.y)) {
                hashMap.put(JPushInterface.EXTRA_BIG_PIC_PATH, bVar.y);
            }
            if (bVar.A != 0) {
                hashMap.put(JPushInterface.EXTRA_NOTI_PRIORITY, new StringBuilder().append(bVar.A).toString());
            }
            if (!TextUtils.isEmpty(bVar.B)) {
                hashMap.put(JPushInterface.EXTRA_NOTI_CATEGORY, bVar.B);
            }
        }
        return hashMap;
    }

    public static void a(Notification.Builder builder, String str, CharSequence charSequence, int i, int i2) {
        if (a(str, charSequence, i, i2)) {
            try {
                j.a(builder, "setChannelId", new Class[]{String.class}, new String[]{str});
            } catch (Throwable th) {
                f.c("NotificationHelper", "setChannelId error" + th);
            }
        }
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                Integer valueOf = Integer.valueOf(l.a());
                if (valueOf.intValue() != 0) {
                    b(context, valueOf.intValue());
                }
            }
        }
    }

    public static void a(Context context, int i, boolean z) {
        int a2;
        if (!l.b(i)) {
            l.a(i);
        }
        if (l.b() <= cn.jpush.android.b.a(context) || (a2 = l.a()) == 0) {
            return;
        }
        b(context, a2);
    }

    public static void a(Context context, cn.jpush.android.data.b bVar) {
        cn.jiguang.api.e.a(new d(context, bVar), new int[0]);
    }

    public static void a(Context context, cn.jpush.android.data.b bVar, int i) {
        if (context == null) {
            context = cn.jpush.android.a.e;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(a(bVar, 0));
    }

    public static void a(Context context, Map<String, String> map, int i, String str, String str2, cn.jpush.android.data.b bVar) {
        Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_RECEIVED);
        try {
            f.a("NotificationHelper", "Send push received broadcast to developer defined receiver");
            a(intent, map, i);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_DEVELOPER_ARG0, str);
            }
            if (bVar.a() && (bVar instanceof g)) {
                g gVar = (g) bVar;
                if (gVar.L != 0 && gVar.L != 4) {
                    if (gVar.Q != null && gVar.Q.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
                        gVar.Q = gVar.Q.replaceFirst(SkiaImageDecoder.FILE_PREFIX, "");
                        intent.putExtra(JPushInterface.EXTRA_RICHPUSH_HTML_PATH, gVar.Q);
                    }
                    if (gVar.N != null && gVar.N.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        String b = cn.jpush.android.d.c.b(context, bVar.c);
                        Iterator<String> it = gVar.N.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next.startsWith("http://")) {
                                next = cn.jpush.android.d.c.a(next);
                            }
                            if (TextUtils.isEmpty(sb.toString())) {
                                sb.append(b).append(next);
                            } else {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(b).append(next);
                            }
                        }
                        intent.putExtra(JPushInterface.EXTRA_RICHPUSH_HTML_RES, sb.toString());
                    }
                }
            }
            intent.addCategory(str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, str2 + ".permission.JPUSH_MESSAGE");
        } catch (Throwable th) {
            f.c("NotificationHelper", "sendNotificationReceivedBroadcast error:" + th.getMessage());
            cn.jpush.android.d.a.b(context, intent, str2 + ".permission.JPUSH_MESSAGE");
        }
    }

    public static void a(Context context, boolean z) {
        if (!z) {
            Bundle bundle = new Bundle();
            bundle.putString("action", "intent.MULTI_PROCESS");
            bundle.putInt("multi_type", 10);
            cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
            return;
        }
        while (true) {
            Integer valueOf = Integer.valueOf(l.a());
            if (valueOf.intValue() == 0) {
                return;
            }
            b(context, valueOf.intValue());
        }
    }

    public static void a(Intent intent, Map<String, String> map, int i) {
        for (String str : map.keySet()) {
            intent.putExtra(str, map.get(str));
        }
        if (i != 0) {
            intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_ID, i);
        }
    }

    private static boolean a(String str, CharSequence charSequence, int i, int i2) {
        Class<?> cls;
        Constructor<?> constructor;
        int i3 = 3;
        if (a) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (cn.jpush.android.a.e == null) {
            f.d("NotificationHelper", "ApplicationContext is null!");
            return false;
        } else if (cn.jpush.android.a.e.getApplicationInfo().targetSdkVersion < 26) {
            return false;
        } else {
            NotificationManager notificationManager = (NotificationManager) cn.jpush.android.a.e.getSystemService("notification");
            if (notificationManager == null) {
                f.d("NotificationHelper", "NotificationManager is null!");
                return false;
            }
            switch (i) {
                case -2:
                    i3 = 1;
                    break;
                case -1:
                    i3 = 2;
                    break;
                case 1:
                    i3 = 4;
                    break;
                case 2:
                    i3 = 5;
                    break;
            }
            try {
                cls = Class.forName("android.app.NotificationChannel");
                try {
                    try {
                        constructor = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE);
                        constructor.setAccessible(true);
                    } catch (InvocationTargetException e) {
                        f.d("NotificationHelper", "new NotificationChannel fail:" + e.toString());
                    }
                } catch (NoSuchMethodException e2) {
                    f.d("NotificationHelper", "new NotificationChannel fail:" + e2.toString());
                }
            } catch (Throwable th) {
                f.d("NotificationHelper", "new NotificationChannel fail:" + th.toString());
            }
            try {
                Object newInstance = constructor.newInstance(str, charSequence, Integer.valueOf(i3));
                if (newInstance == null) {
                    f.d("NotificationHelper", "new NotificationChannel fail, return");
                    return false;
                }
                Boolean[] boolArr = {true};
                Class[] clsArr = {Boolean.TYPE};
                if ((i2 & 4) != 0) {
                    try {
                        j.a(newInstance, "enableLights", clsArr, boolArr);
                    } catch (Exception e3) {
                        f.c("NotificationHelper", "enableLights fail:" + e3.toString());
                    }
                }
                if ((i2 & 2) != 0) {
                    try {
                        j.a(newInstance, "enableVibration", clsArr, boolArr);
                    } catch (Exception e4) {
                        f.c("NotificationHelper", "enableLights fail:" + e4.toString());
                    }
                }
                try {
                    j.a(notificationManager, "createNotificationChannel", new Class[]{cls}, new Object[]{newInstance});
                } catch (Exception e5) {
                    f.d("NotificationHelper", "createNotificationChannel fail:" + e5.toString());
                }
                a = true;
                return true;
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
                return false;
            } catch (InstantiationException e7) {
                e7.printStackTrace();
                return false;
            }
        }
    }

    private static void b(Context context, int i) {
        if (context == null) {
            context = cn.jpush.android.a.e;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00ab: IGET  (r11v2 int A[REMOVE]) = (r15v0 cn.jpush.android.data.b) cn.jpush.android.data.b.h int)] */
    public static void b(Context context, cn.jpush.android.data.b bVar) {
        PendingIntent activity;
        int i;
        Intent intent;
        int a2 = a(bVar, 0);
        if (bVar.i && bVar.f) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (bVar instanceof g) {
                Map<String, String> a3 = a(bVar);
                String packageName = TextUtils.isEmpty(bVar.o) ? context.getPackageName() : bVar.o;
                if (TextUtils.isEmpty(bVar.v)) {
                    a(context, a3, 0, "", packageName, bVar);
                    return;
                }
                PushNotificationBuilder b = JPushInterface.b(bVar.g);
                String developerArg0 = b.getDeveloperArg0();
                Notification buildNotification = b.buildNotification(a3);
                if (buildNotification == null || TextUtils.isEmpty(bVar.v)) {
                    f.c("NotificationHelper", "Got NULL notification. Give up to show.");
                    return;
                }
                if (bVar.a()) {
                    Intent c = c(context, bVar);
                    if (c == null) {
                        return;
                    }
                    activity = PendingIntent.getActivity(context, a2, c, 134217728);
                } else {
                    f.a("NotificationHelper", "running flag:" + cn.jiguang.api.e.bB());
                    if (cn.jpush.android.d.a.c(context, PushReceiver.class.getCanonicalName())) {
                        intent = new Intent("cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY." + UUID.randomUUID().toString());
                        intent.putExtra(JPushInterface.EXTRA_NOTI_TYPE, new StringBuilder().append(bVar.h).toString());
                        if (cn.jiguang.api.e.bB()) {
                            intent.setClass(context, PopWinActivity.class);
                            intent.putExtra("isNotification", true);
                        } else {
                            intent.setClass(context, PushReceiver.class);
                        }
                    } else {
                        Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
                        intent2.addCategory(packageName);
                        if ((Build.VERSION.SDK_INT >= 25 || Build.VERSION.SDK_INT < 21) && JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent2.getAction())) {
                            List<String> a4 = cn.jpush.android.d.a.a(context, intent2, (String) null);
                            if (!a4.isEmpty()) {
                                intent2.setComponent(new ComponentName(context, a4.get(0)));
                            }
                        }
                        intent = intent2;
                    }
                    intent.putExtra("sdktype", cn.jpush.android.a.a);
                    intent.putExtra("platform", bVar.e);
                    a(intent, a3, a2);
                    intent.putExtra("app", packageName);
                    if (!TextUtils.isEmpty(developerArg0)) {
                        intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_DEVELOPER_ARG0, developerArg0);
                    }
                    f.a("NotificationHelper", "notification intent component=" + intent.getComponent());
                    activity = cn.jiguang.api.e.bB() ? PendingIntent.getActivity(context, 0, intent, 1073741824) : PendingIntent.getBroadcast(context, 0, intent, 1073741824);
                }
                buildNotification.contentIntent = activity;
                if (!JPushInterface.a(bVar.g)) {
                    if (1 == bVar.h) {
                        bVar.t = 1;
                    }
                    switch (bVar.t) {
                        case 0:
                            i = 1;
                            break;
                        case 1:
                            i = 16;
                            break;
                        case 2:
                            i = 32;
                            break;
                        default:
                            i = 1;
                            break;
                    }
                    buildNotification.flags = i | 1;
                }
                if (cn.jpush.android.d.a.d(context)) {
                    buildNotification.defaults = 0;
                }
                if (buildNotification != null) {
                    notificationManager.notify(a2, buildNotification);
                }
                if (1 != bVar.h && bVar.e == 0) {
                    a(context, a2, true);
                    cn.jpush.android.a.e.a(bVar.c, PointerIconCompat.TYPE_ZOOM_IN, null, context);
                }
                if (bVar == null || bVar.e != 0) {
                    return;
                }
                a(context, a3, a2, developerArg0, packageName, bVar);
            }
        }
    }

    public static Intent c(Context context, cn.jpush.android.data.b bVar) {
        if (context == null) {
            f.c("NotificationHelper", "context was null");
            return null;
        }
        if (bVar != null) {
            if (3 == ((g) bVar).L || 4 == ((g) bVar).L || ((g) bVar).L == 0) {
                return cn.jpush.android.d.a.a(context, bVar, false);
            }
            if (2 == ((g) bVar).L) {
                Intent intent = new Intent(context, PopWinActivity.class);
                intent.putExtra("body", bVar);
                intent.addFlags(335544320);
                return intent;
            }
        }
        return cn.jpush.android.d.a.a(context, bVar, false);
    }
}
