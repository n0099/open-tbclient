package cn.jpush.android.c;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.f;
import cn.jpush.android.data.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0007 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    public static cn.jpush.android.data.b a(Context context, String str, String str2) {
        g gVar = null;
        g gVar2 = new g();
        try {
            JSONObject jSONObject = new JSONObject(str);
            gVar2.c = jSONObject.optString("_jmsgid_");
            if (gVar2.c.isEmpty()) {
                gVar2.c = jSONObject.optString("msg_id");
            }
            gVar2.e = (byte) jSONObject.optInt("rom_type");
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                gVar2.v = optJSONObject.optString("n_content");
                gVar2.u = optJSONObject.optString("n_title");
                gVar2.n = optJSONObject.optString("n_extras");
                gVar2.t = optJSONObject.optInt("n_flag", 1);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                if (optJSONObject2 != null) {
                    gVar2.a(true);
                    gVar2.a(optJSONObject2);
                    gVar2.b = 3;
                } else {
                    gVar2.b = 4;
                    gVar2.L = -1;
                }
            } else {
                gVar2.v = jSONObject.optString("n_content");
                gVar2.u = jSONObject.optString("n_title");
                gVar2.n = jSONObject.optString("n_extras");
                gVar2.e = (byte) jSONObject.optInt("rom_type");
            }
            if (optInt != -1) {
                gVar2.b = optInt;
            }
            gVar2.q = 0;
            gVar2.r = true;
            gVar = gVar2;
            return gVar;
        } catch (Throwable th) {
            String str3 = "NO MSGID";
            byte b = gVar;
            if (!TextUtils.isEmpty(gVar2.c)) {
                str3 = gVar2.c;
                b = gVar2.e;
            }
            cn.jpush.android.a.e.a(str3, str2, b, 996, context);
            return null;
        }
    }

    private static void a(Context context, cn.jpush.android.data.b bVar, String str, int i) {
        if (TextUtils.isEmpty(bVar.c)) {
            return;
        }
        Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
        try {
            cn.jpush.android.api.c.a(intent, cn.jpush.android.api.c.a(bVar), i);
            intent.putExtra("sdktype", cn.jpush.android.a.a);
            String packageName = TextUtils.isEmpty(bVar.o) ? context.getPackageName() : bVar.o;
            intent.addCategory(packageName);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, packageName + ".permission.JPUSH_MESSAGE");
            cn.jpush.android.a.e.a(bVar.c, str, bVar.e, 1000, context);
        } catch (Throwable th) {
            f.c("PluginPlatformsNotificationHelper", "onNotificationOpen sendBrocat error:" + th.getMessage());
            cn.jpush.android.d.a.b(context, intent, context.getPackageName() + ".permission.JPUSH_MESSAGE");
        }
    }

    public static void a(Context context, String str, String str2, int i, byte b, boolean z) {
        if (context == null) {
            f.c("PluginPlatformsNotificationHelper", "context was null");
        } else if (TextUtils.isEmpty(str)) {
            f.c("PluginPlatformsNotificationHelper", "content was null");
        } else {
            cn.jpush.android.data.b a = a(context, str, str2);
            if (a == null) {
                f.c("PluginPlatformsNotificationHelper", "entity was null");
            } else if (TextUtils.isEmpty(a.c)) {
                f.c("PluginPlatformsNotificationHelper", "message id was empty");
            } else {
                a.e = b;
                if (!z) {
                    if (a instanceof g) {
                        cn.jpush.android.api.c.a(context, cn.jpush.android.api.c.a(a), i, null, context.getPackageName(), a);
                        cn.jpush.android.a.e.a(a.c, str2, a.e, PointerIconCompat.TYPE_ZOOM_IN, context);
                    }
                } else if (a instanceof g) {
                    if (((g) a).L == -1) {
                        a(context, a, str2, i);
                        return;
                    }
                    Intent c = cn.jpush.android.api.c.c(context, a);
                    if (c != null) {
                        c.addFlags(268435456);
                        context.getApplicationContext().startActivity(c);
                    }
                }
            }
        }
    }
}
