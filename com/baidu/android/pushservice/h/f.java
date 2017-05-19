package com.baidu.android.pushservice.h;

import android.content.Context;
import android.os.Build;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.config.ModeConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f {
    public static void a(final Context context, final String str, final int i, final int i2, final String str2, final int i3) {
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("sendHttpACK", (short) 90) { // from class: com.baidu.android.pushservice.h.f.1
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                try {
                    com.baidu.android.pushservice.e.a.c("HttpMessageAction", "sendHttpACK, msgId: " + str + " ACK: " + i + " result: " + com.baidu.android.pushservice.d.b.a(i3 == 2 ? "https://hack.tuisong.baidu.com/statistics/xiaomi/msg_ack" : "https://hack.tuisong.baidu.com/statistics/msg_ack", "POST", f.b(context, str, i2, str2, true, i), "").b());
                } catch (Exception e) {
                    com.baidu.android.pushservice.e.a.e("HttpMessageAction", "sendHttpACK, Exception: " + e.getMessage());
                    com.baidu.android.pushservice.e.a.a("HttpMessageAction", e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final int i, final String str2) {
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("sendHttpNotificationDeleted", (short) 90) { // from class: com.baidu.android.pushservice.h.f.3
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                HashMap b = f.b(context, str, i, str2, false, 2);
                try {
                    f.b(context, str, "010202");
                    com.baidu.android.pushservice.e.a.c("HttpMessageAction", "sendHttpNotificationDeleted, msgId: " + str + " result: " + com.baidu.android.pushservice.d.b.a("https://hack.tuisong.baidu.com/statistics/msg_action", "POST", b, "BCCS_SDK/3.0").b());
                } catch (Exception e) {
                    com.baidu.android.pushservice.e.a.e("HttpMessageAction", "sendHttpNotificationDeleted, Exception: " + e.getMessage());
                    com.baidu.android.pushservice.e.a.a("HttpMessageAction", e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final int i, final String str2, final int i2) {
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("sendHttpNotificationClicked", (short) 90) { // from class: com.baidu.android.pushservice.h.f.2
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                HashMap b = f.b(context, str, i, str2, false, 1);
                f.b(context, str, "010201");
                try {
                    com.baidu.android.pushservice.e.a.c("HttpMessageAction", "sendHttpNotificationClicked, msgId: " + str + " result: " + com.baidu.android.pushservice.d.b.a(i2 == 2 ? "https://hack.tuisong.baidu.com/statistics/xiaomi/msg_action" : "https://hack.tuisong.baidu.com/statistics/msg_action", "POST", b, "BCCS_SDK/3.0").b());
                } catch (Exception e) {
                    com.baidu.android.pushservice.e.a.e("HttpMessageAction", "sendHttpNotificationClicked, Exception: " + e.getMessage());
                    com.baidu.android.pushservice.e.a.a("HttpMessageAction", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, String> b(Context context, String str, int i, String str2, boolean z, int i2) {
        HashMap<String, String> hashMap = new HashMap<>();
        com.baidu.android.pushservice.c.b.b(hashMap);
        hashMap.put("appid", PushSettings.b(context));
        hashMap.put("channelid", PushSettings.a(context));
        hashMap.put(PbActivityConfig.KEY_MSG_ID, str);
        hashMap.put("timestamp", System.currentTimeMillis() + "");
        hashMap.put("push_type", i + "");
        if (i == 2) {
            hashMap.put("gid", str2);
        }
        int currentMode = ModeConfig.getInstance(context).getCurrentMode();
        hashMap.put("cur_mode", ModeConfig.getInstance(context).getCurrentMode() + "");
        if (currentMode == ModeConfig.MODE_I_HW) {
            hashMap.put("platform", "HUAWEI");
            hashMap.put("token", n.a(context));
        } else if (currentMode == ModeConfig.MODE_I_XM) {
            hashMap.put("platform", "Xiaomi");
            hashMap.put("token", n.b(context));
        } else {
            hashMap.put("platform", Build.MANUFACTURER);
        }
        if (z) {
            hashMap.put("ack_value", i2 + "");
        } else {
            hashMap.put("action_value", i2 + "");
        }
        com.baidu.android.pushservice.e.a.c("HttpMessageAction", "buildHttpActionParams: " + hashMap.toString());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2) {
        com.baidu.android.pushservice.f.j jVar = new com.baidu.android.pushservice.f.j();
        jVar.d = str2;
        jVar.a = str;
        jVar.e = System.currentTimeMillis();
        jVar.f = com.baidu.android.pushservice.f.a.b.c(context);
        jVar.c = com.baidu.android.pushservice.message.a.l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a();
        jVar.h = PushSettings.b(context);
        com.baidu.android.pushservice.f.p.a(context, jVar);
    }
}
