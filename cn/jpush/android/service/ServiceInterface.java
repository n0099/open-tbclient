package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.i;
import cn.jpush.android.api.DefaultPushNotificationBuilder;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ServiceInterface {
    public static String a() {
        return "3.1.6";
    }

    public static void a(Context context) {
        if (d(context)) {
            return;
        }
        cn.jiguang.api.e.a(context, cn.jpush.android.a.a, new Bundle(), false);
        cn.jpush.android.c.d.a().a(context);
    }

    public static void a(Context context, int i) {
        i.d(context, "service_stoped", 1);
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.STOPPUSH");
        bundle.putString("app", context.getPackageName());
        cn.jiguang.api.e.c(context, cn.jpush.android.a.a, bundle);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 java.lang.Integer)] */
    public static void a(Context context, Integer num, DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        if (context == null) {
            cn.jpush.android.d.f.d("ServiceInterface", "Null context, please init JPush!");
        } else {
            cn.jpush.android.b.a(context, new StringBuilder().append(num).toString(), defaultPushNotificationBuilder.toString(), false);
        }
    }

    public static void a(Context context, String str) {
        if (context == null || d(context)) {
            return;
        }
        cn.jpush.android.b.a(context, str, false);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : ?: TERNARY(r0v6 int A[REMOVE]) = ((r10v0 cn.jpush.android.api.a) != (null cn.jpush.android.api.a)) ? (wrap: int : 0x0030: IGET  (r0v11 int A[REMOVE]) = (r10v0 cn.jpush.android.api.a) cn.jpush.android.api.a.e int) : (0 int))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : ?: TERNARY(r1v1 int A[REMOVE]) = ((r10v0 cn.jpush.android.api.a) != (null cn.jpush.android.api.a)) ? (wrap: int : 0x0047: IGET  (r1v4 int A[REMOVE]) = (r10v0 cn.jpush.android.api.a) cn.jpush.android.api.a.f int) : (0 int))] */
    public static void a(Context context, String str, Set<String> set, long j, cn.jpush.android.api.a aVar) {
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.ALIAS_TAGS");
        bundle.putString(CommandMessage.TYPE_ALIAS, str);
        bundle.putStringArrayList(CommandMessage.TYPE_TAGS, set != null ? new ArrayList<>(set) : null);
        bundle.putLong("seq_id", j);
        bundle.putString("proto_type", new StringBuilder().append(aVar != null ? aVar.e : 0).toString());
        bundle.putString("protoaction_type", new StringBuilder().append(aVar != null ? aVar.f : 0).toString());
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
    }

    public static boolean a(Context context, int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startHour", i);
            jSONObject.put("startMins", i2);
            jSONObject.put("endHour", i3);
            jSONObject.put("endtMins", i4);
            a(context, jSONObject.toString());
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static void b(Context context) {
        if (context == null) {
            cn.jpush.android.d.f.c("ServiceInterface", "clearAllNotification - context is null!");
        } else {
            cn.jpush.android.api.c.a(context.getApplicationContext(), false);
        }
    }

    public static void b(Context context, int i) {
        i.d(context, "service_stoped", 0);
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.RESTOREPUSH");
        bundle.putString("app", context.getPackageName());
        cn.jiguang.api.e.a(context, cn.jpush.android.a.a, bundle, true);
    }

    public static void c(Context context, int i) {
        if (context == null) {
            cn.jpush.android.d.f.c("ServiceInterface", "setNotificationNumber - context is null!");
        } else {
            cn.jpush.android.b.a(context, i, false);
        }
    }

    public static boolean c(Context context) {
        return i.getInt(context, "service_stoped", 0) > 0;
    }

    public static boolean d(Context context) {
        boolean c = c(context);
        if (c) {
            cn.jpush.android.d.f.a("ServiceInterface", "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.");
        }
        return c;
    }
}
