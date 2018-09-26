package cn.jiguang.a.a.c;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.d.d.aa;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class g {
    public static void a(Context context, int i) {
        boolean z;
        boolean z2;
        String str = (String) cn.jiguang.d.a.d.b(context, "report_notify_state", null);
        new g();
        boolean a = Build.VERSION.SDK_INT >= 24 ? a(context) : b(context);
        if (TextUtils.isEmpty(str)) {
            z2 = true;
        } else {
            if (TextUtils.equals("ON", str)) {
                z = true;
                z2 = false;
            } else if (TextUtils.equals("OFF", str)) {
                z = false;
                z2 = false;
            } else {
                z = false;
                z2 = true;
            }
            if (!z2) {
                z2 = z != a;
            }
        }
        if (z2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notification_state", a);
                jSONObject.put("imei", cn.jiguang.g.a.d(context, cn.jiguang.g.a.d(context, "")));
                jSONObject.put("device_id", cn.jiguang.g.a.i(context));
                jSONObject.put("trigger_scene", i);
                aa.a((Context) null, jSONObject, "android_notification_state");
                cn.jiguang.api.e.b(context, jSONObject, false);
                cn.jiguang.d.a.d.a(context, "report_notify_state", a ? "ON" : "OFF");
            } catch (Throwable th) {
            }
        }
    }

    @TargetApi(24)
    private static boolean a(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable th) {
            return true;
        }
    }

    private static boolean b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (IllegalAccessException e2) {
            return true;
        } catch (NoSuchFieldException e3) {
            return true;
        } catch (NoSuchMethodException e4) {
            return true;
        } catch (RuntimeException e5) {
            return true;
        } catch (InvocationTargetException e6) {
            return true;
        } catch (Throwable th) {
            return true;
        }
    }
}
