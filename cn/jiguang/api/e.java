package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cn.jiguang.d.d.aa;
import cn.jiguang.d.d.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static String a = "cn.jpush.android.intent.DaemonService";

    public static void F(String str) {
        cn.jiguang.d.h.i.a(str, 4, -1);
    }

    public static void a(Context context, String str, int i, byte[] bArr) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", str);
            bundle.putByteArray(IntentConfig.DATAS, bArr);
            bundle.putInt(IntentConfig.CMD, i);
            l.bI().d(context, "senddata.action", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "sendData failed", th);
        }
    }

    public static void a(Context context, String str, Bundle bundle, boolean z) {
        if (context == null) {
            cn.jiguang.e.c.c("JCoreInterface", "unexcepted - context was null");
            return;
        }
        try {
            bundle.putString("sdktype", str);
            l.bI().d(context, z ? "intent.RESTOREPUSH" : "intent.INIT", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "restart failed", th);
        }
    }

    public static void a(Runnable runnable, int... iArr) {
        a("ASYNC", runnable, iArr);
    }

    public static void a(String str, Runnable runnable, int... iArr) {
        cn.jiguang.d.h.i.a(str, runnable, (iArr == null || iArr.length <= 0) ? 4 : iArr[0]);
    }

    public static boolean a(Context context, Object obj, String str) {
        if (obj == null) {
            aa.a(context);
            return true;
        } else if (obj instanceof JSONObject) {
            aa.a(context, (JSONObject) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            aa.a(context, (JSONArray) obj);
            return true;
        } else {
            return true;
        }
    }

    public static Bundle b(Context context, int i, Bundle bundle) {
        return cn.jiguang.d.d.c(context, i, bundle);
    }

    public static void b(Context context, String str, int i, byte[] bArr) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", str);
            bundle.putByteArray(IntentConfig.DATAS, bArr);
            bundle.putInt("timeout", i);
            l.bI().d(context, "sendrequestdata.action", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "sendRequestData failed", th);
        }
    }

    public static void b(Context context, String str, Bundle bundle) {
        try {
            bundle.putString("sdktype", str);
            l.bI().d(context, "run.action", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "sendAction failed", th);
        }
    }

    public static void b(Context context, JSONObject jSONObject, boolean z) {
        aa.a(context, jSONObject);
    }

    public static void b(String str, Class<? extends b> cls) {
        cn.jiguang.d.d.e.a(str, cls.getName());
    }

    public static boolean bd() {
        try {
            if (cn.jiguang.g.a.a.c()) {
                return cn.jiguang.g.a.a.b().asBinder().pingBinder();
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean be() {
        return cn.jiguang.d.a.b;
    }

    public static boolean bf() {
        if (cn.jiguang.d.a.c(null)) {
            return cn.jiguang.d.a.d.d(null);
        }
        return false;
    }

    public static long bg() {
        return !cn.jiguang.d.a.c(null) ? System.currentTimeMillis() / 1000 : cn.jiguang.d.a.a.bp();
    }

    public static long bh() {
        if (cn.jiguang.d.a.c(null)) {
            return cn.jiguang.d.a.a.f();
        }
        return 0L;
    }

    public static boolean bi() {
        return cn.jiguang.d.a.d.d();
    }

    public static String bj() {
        if (cn.jiguang.d.a.c(null)) {
            return cn.jiguang.d.a.a.H("");
        }
        return null;
    }

    public static boolean bk() {
        return cn.jiguang.d.b.a.a();
    }

    public static String bl() {
        return a;
    }

    public static JSONObject c(JSONObject jSONObject, String str) {
        return aa.a(cn.jiguang.d.a.d, jSONObject, str);
    }

    public static void c(Context context, String str, Bundle bundle) {
        try {
            bundle.putString("sdktype", str);
            l.bI().d(context, "intent.STOPPUSH", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "stop failed", th);
        }
    }

    public static void c(String str, Class<? extends c> cls) {
        cn.jiguang.d.d.e.b(str, cls.getName());
    }

    public static void d(Context context, int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", cn.jiguang.d.a.a);
            bundle.putInt("key_trigger_scene", i);
            l.bI().d(context, "cn.jpush.android.intent.check.notification.state", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "triggerSceneCheck to pushservice error", th);
        }
    }

    public static String getAppKey() {
        return cn.jiguang.d.a.b(null);
    }

    public static boolean getConnectionState(Context context) {
        if (cn.jiguang.d.a.c(context)) {
            return cn.jiguang.d.a.d.d();
        }
        return false;
    }

    public static String getDeviceId(Context context) {
        return !cn.jiguang.d.a.c(context) ? "" : cn.jiguang.g.a.i(context);
    }

    public static String getRegistrationID(Context context) {
        return !cn.jiguang.d.a.c(context) ? "" : cn.jiguang.d.a.d.a(context);
    }

    public static int getSid() {
        if (cn.jiguang.d.a.c(null)) {
            return cn.jiguang.d.a.d.a();
        }
        return 0;
    }

    public static long getUid() {
        if (cn.jiguang.d.a.c(null)) {
            return cn.jiguang.d.a.d.c(null);
        }
        return 0L;
    }

    public static void h(boolean z) {
        cn.jiguang.d.i.f.bT().bU().a(z);
    }

    public static void initCrashHandler(Context context) {
        a("SDK_MAIN", new cn.jiguang.d.c(context, 2), new int[0]);
    }

    public static void j(int i) {
        cn.jiguang.a.c.a.a(i);
    }

    public static void onFragmentPause(Context context, String str) {
        cn.jiguang.d.a.c(context);
        cn.jiguang.a.a.d.b.ba().b(context, str);
    }

    public static void onFragmentResume(Context context, String str) {
        cn.jiguang.d.a.c(context);
        cn.jiguang.a.a.d.b.ba().a(context, str);
    }

    public static void onKillProcess(Context context) {
        cn.jiguang.d.a.c(context);
        cn.jiguang.a.a.d.b.ba().c(context);
    }

    public static void onPause(Context context) {
        boolean z = cn.jiguang.a.a.b;
        cn.jiguang.d.a.c(context);
        if (z) {
            cn.jiguang.a.a.d.b.ba().b(context);
        }
    }

    public static void onResume(Context context) {
        boolean z = cn.jiguang.a.a.b;
        cn.jiguang.d.a.c(context);
        if (z) {
            cn.jiguang.a.a.d.b.ba().a(context);
        }
    }

    public static void register(Context context) {
        l.bI().d(context, "intent.INIT", new Bundle());
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            cn.jiguang.e.c.c("JCoreInterface", "[requestPermission] context was null");
        } else if (!(context instanceof Activity)) {
            cn.jiguang.e.c.c("JCoreInterface", "[requestPermission] context must instanceof Activity");
        } else if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
        } else {
            try {
                List<String> b = cn.jiguang.g.a.b(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE"});
                if (b == null || b.isEmpty()) {
                    return;
                }
                Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, b.toArray(new String[b.size()]), 1);
            } catch (Exception e) {
                cn.jiguang.e.c.c("JCoreInterface", "#unexcepted - requestPermission e:" + e.getMessage());
            }
        }
    }

    public static void setDaemonAction(String str) {
        a = str;
        cn.jiguang.d.i.f.bT().bU().c(str);
    }

    public static void setDebugMode(boolean z) {
        cn.jiguang.d.a.b = z;
    }

    public static void setPowerSaveMode(Context context, boolean z) {
        if (!cn.jiguang.d.a.c(null)) {
            if (context == null) {
                cn.jiguang.e.c.c("JCoreInterface", "context is null,setDozeAndPowerEnable failed");
                return;
            } else {
                cn.jiguang.d.a.d.h(context, z);
                return;
            }
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", cn.jiguang.d.a.a);
            bundle.putBoolean("key_power_save", z);
            l.bI().d(context, "intent.power.save", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "setDozeAndPowerEnable to pushservice error", th);
        }
    }

    public static void stopCrashHandler(Context context) {
        a("SDK_MAIN", new cn.jiguang.d.c(context, 3), new int[0]);
    }
}
