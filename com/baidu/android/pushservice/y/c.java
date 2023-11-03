package com.baidu.android.pushservice.y;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.y.e.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static void a(Context context, long j) {
        i.b(context, "push_sdk_pull_config_last_pull_time", j);
    }

    public static void a(Context context, com.baidu.android.pushservice.y.e.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.e()) {
            i.b(context, "push_sdk_pull_config_am_interval", bVar.c());
        }
        if (bVar.f()) {
            i.b(context, "push_sdk_pull_config_am_power_limit", bVar.d());
        }
    }

    public static void a(Context context, e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar.l()) {
            i.b(context, "push_sdk_pull_config_mode", eVar.g());
        }
        if (eVar.k()) {
            i.b(context, "push_sdk_pull_config_interval", eVar.f());
        }
        if (eVar.n()) {
            i.b(context, "push_sdk_pull_config_use_condition", eVar.i());
        }
        if (eVar.b().size() > 0) {
            i.b(context, "push_sdk_pull_config_action_list", TextUtils.join(",", eVar.b()));
        }
        if (eVar.m()) {
            i.b(context, "push_sdk_pull_config_power_limit", eVar.h());
        }
        if (eVar.j()) {
            i.b(context, "push_sdk_pull_config_foreground_start", eVar.e());
        }
    }

    public static void a(Context context, List<com.baidu.android.pushservice.y.e.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.baidu.android.pushservice.y.e.c cVar : list) {
            com.baidu.android.pushservice.m.a aVar = new com.baidu.android.pushservice.m.a();
            aVar.a(cVar.a());
            aVar.b(cVar.f());
            aVar.a(cVar.e());
            aVar.c(cVar.g());
            aVar.d(cVar.h());
            arrayList.add(aVar);
        }
        com.baidu.android.pushservice.m.d.a(context, (List<com.baidu.android.pushservice.m.a>) arrayList);
    }

    public static void a(Context context, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                com.baidu.android.pushservice.m.a aVar = new com.baidu.android.pushservice.m.a();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                aVar.a(jSONObject.optString("action"));
                aVar.b(jSONObject.optInt("interval"));
                aVar.a(jSONObject.optInt("foreground_start"));
                aVar.c(jSONObject.optInt("power_limit"));
                aVar.d(jSONObject.optInt("status"));
                arrayList.add(aVar);
            } catch (Exception unused) {
                return;
            }
        }
        com.baidu.android.pushservice.m.d.a(context, (List<com.baidu.android.pushservice.m.a>) arrayList);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("interval")) {
            i.b(context, "push_sdk_pull_config_am_interval", jSONObject.optInt("interval"));
        }
        if (jSONObject.has("power_limit")) {
            i.b(context, "push_sdk_pull_config_am_power_limit", jSONObject.optInt("power_limit"));
        }
    }

    public static boolean a(Context context) {
        return i.a(context, "push_sdk_pull_config_foreground_start", 0) == 1;
    }

    public static boolean a(Context context, ClientEventInfo clientEventInfo) {
        if (Utility.B(context) || a(context)) {
            return (!i(context) || e(context).contains(clientEventInfo.getAction())) && (System.currentTimeMillis() / 1000) - d(context) > ((long) f(context)) && Utility.s(context) >= h(context);
        }
        return false;
    }

    public static boolean a(Context context, ClientEventInfo clientEventInfo, com.baidu.android.pushservice.m.a aVar) {
        if (aVar.f() != 1) {
            return false;
        }
        return (Utility.B(context) || aVar.b() == 1) && (System.currentTimeMillis() / 1000) - aVar.d() > ((long) aVar.c()) && Utility.s(context) >= aVar.e();
    }

    public static boolean a(Context context, String str) {
        return com.baidu.android.pushservice.m.d.c(context, str).f() == 1;
    }

    public static int b(Context context) {
        return i.a(context, "push_sdk_pull_config_am_interval", -1);
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("mode")) {
            i.b(context, "push_sdk_pull_config_mode", jSONObject.optInt("mode"));
        }
        if (jSONObject.has("interval")) {
            i.b(context, "push_sdk_pull_config_interval", jSONObject.optInt("interval"));
        }
        if (jSONObject.has("use_condition")) {
            i.b(context, "push_sdk_pull_config_use_condition", jSONObject.optInt("use_condition"));
        }
        if (jSONObject.has("action_list")) {
            i.b(context, "push_sdk_pull_config_action_list", jSONObject.optString("action_list"));
        }
        if (jSONObject.has("power_limit")) {
            i.b(context, "push_sdk_pull_config_power_limit", jSONObject.optInt("power_limit"));
        }
        if (jSONObject.has("foreground_start")) {
            i.b(context, "push_sdk_pull_config_foreground_start", jSONObject.optInt("foreground_start"));
        }
        if (jSONObject.has("action_conf_list")) {
            a(context, jSONObject.optJSONArray("action_conf_list"));
        }
    }

    public static boolean b(Context context, ClientEventInfo clientEventInfo) {
        boolean a;
        if (clientEventInfo == null) {
            clientEventInfo = new ClientEventInfo();
        }
        com.baidu.android.pushservice.m.a c = com.baidu.android.pushservice.m.d.c(context, clientEventInfo.getAction());
        if (TextUtils.equals(clientEventInfo.getAction(), c.a())) {
            a = a(context, clientEventInfo, c);
            if (a) {
                com.baidu.android.pushservice.m.d.a(context, c, System.currentTimeMillis() / 1000);
            }
        } else {
            a = a(context, clientEventInfo);
            if (a) {
                a(context, System.currentTimeMillis() / 1000);
            }
        }
        return a;
    }

    public static int c(Context context) {
        return i.a(context, "push_sdk_pull_config_am_power_limit", 20);
    }

    public static long d(Context context) {
        return i.a(context, "push_sdk_pull_config_last_pull_time", 0L);
    }

    public static String e(Context context) {
        return i.c(context, "push_sdk_pull_config_action_list");
    }

    public static int f(Context context) {
        return i.a(context, "push_sdk_pull_config_interval", 1800);
    }

    public static int g(Context context) {
        return i.a(context, "push_sdk_pull_config_mode", 1);
    }

    public static int h(Context context) {
        return i.a(context, "push_sdk_pull_config_power_limit", 20);
    }

    public static boolean i(Context context) {
        return i.a(context, "push_sdk_pull_config_use_condition", 0) == 1;
    }
}
