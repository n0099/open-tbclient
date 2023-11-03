package com.baidu.android.pushservice.w;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.message.LocalPushMsg;
import com.baidu.android.pushservice.util.Utility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c {
    public static int c;
    public Context b;

    public j(Context context) {
        super(context);
        this.b = context.getApplicationContext();
    }

    public static k a(Context context, k kVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("sign_info")) {
                String string = jSONObject.getString("sign_info");
                if (!TextUtils.isEmpty(string)) {
                    kVar.b(string.getBytes());
                }
            }
            if (!jSONObject.isNull("package_name")) {
                String string2 = jSONObject.getString("package_name");
                if (!TextUtils.isEmpty(string2)) {
                    kVar.d(string2);
                }
            }
            if (!jSONObject.isNull("expiretime")) {
                kVar.a(jSONObject.getLong("expiretime"));
            }
            int i = !jSONObject.isNull(Constants.EXTRA_NOTIFY_ID) ? jSONObject.getInt(Constants.EXTRA_NOTIFY_ID) : kVar.q() != com.baidu.android.pushservice.w.m.l.MSG_TYPE_CLEAR_MESSAGE.a() ? Utility.p(context, kVar.h()) : 0;
            if (!jSONObject.isNull("lt")) {
                com.baidu.android.pushservice.a0.i.b(context, "last_time", jSONObject.optLong("lt"));
            }
            if (!jSONObject.isNull("wbn")) {
                int optInt = jSONObject.optInt("wbn");
                int optInt2 = jSONObject.optInt("wbt");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("widget_badge_type", optInt2);
                jSONObject2.put("widget_badge_num", optInt);
                kVar.g(jSONObject2.toString());
            }
            if (!jSONObject.isNull("foreground_show")) {
                int i2 = jSONObject.getInt("foreground_show");
                kVar.a(i2 & 3);
                kVar.c(i2 & 2080374847);
            }
            if (!jSONObject.isNull("pop_duration")) {
                kVar.f(jSONObject.optInt("pop_duration", 5));
            }
            if (!jSONObject.isNull("show_params")) {
                kVar.e(jSONObject.optString("show_params"));
            }
            if (!jSONObject.isNull("log_ext")) {
                kVar.c(jSONObject.optString("log_ext"));
            }
            kVar.b(i);
            kVar.a(false);
        } catch (JSONException unused) {
        }
        return kVar;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            if (i >= bArr.length) {
                i = 0;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        return new String(bArr, 0, i);
    }

    public static void a(int i) {
        c = i;
    }

    @Override // com.baidu.android.pushservice.w.c
    public g a(e eVar) {
        eVar.d = true;
        g gVar = new g();
        gVar.a(-1);
        byte[] bArr = eVar.b;
        if (bArr == null) {
            return gVar;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.baidu.android.pushservice.a0.d dVar = new com.baidu.android.pushservice.a0.d(byteArrayInputStream);
        try {
            k kVar = new k();
            byte[] bArr2 = new byte[128];
            dVar.a(bArr2);
            kVar.a(a(bArr2));
            kVar.d(c);
            kVar.c(dVar.c());
            kVar.e(dVar.d());
            int d = dVar.d();
            byte[] bArr3 = new byte[64];
            dVar.a(bArr3);
            kVar.a(bArr3);
            if (d > 0) {
                byte[] bArr4 = new byte[d];
                dVar.a(bArr4);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr4));
                    if (!jSONObject.isNull("sign_info")) {
                        String string = jSONObject.getString("sign_info");
                        if (!TextUtils.isEmpty(string)) {
                            kVar.b(string.getBytes());
                        }
                    }
                    if (!jSONObject.isNull("package_name")) {
                        String string2 = jSONObject.getString("package_name");
                        if (!TextUtils.isEmpty(string2)) {
                            kVar.d(string2);
                        }
                    }
                    if (!jSONObject.isNull("expiretime")) {
                        kVar.a(jSONObject.getLong("expiretime"));
                    }
                    if (!jSONObject.isNull("start")) {
                        kVar.f(jSONObject.getString("start"));
                    }
                    if (!jSONObject.isNull("end")) {
                        kVar.b(jSONObject.getString("end"));
                    }
                    if (!jSONObject.isNull("interval")) {
                        kVar.b(jSONObject.getLong("interval"));
                    }
                    int i = !jSONObject.isNull(Constants.EXTRA_NOTIFY_ID) ? jSONObject.getInt(Constants.EXTRA_NOTIFY_ID) : kVar.q() != com.baidu.android.pushservice.w.m.l.MSG_TYPE_CLEAR_MESSAGE.a() ? Utility.p(this.b, kVar.h()) : 0;
                    if (!jSONObject.isNull("lt")) {
                        com.baidu.android.pushservice.a0.i.b(this.b, "last_time", jSONObject.optLong("lt"));
                    }
                    if (!jSONObject.isNull("wbn")) {
                        int optInt = jSONObject.optInt("wbn");
                        int optInt2 = jSONObject.optInt("wbt");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("widget_badge_type", optInt2);
                        jSONObject2.put("widget_badge_num", optInt);
                        kVar.g(jSONObject2.toString());
                    }
                    if (!jSONObject.isNull("foreground_show")) {
                        int i2 = jSONObject.getInt("foreground_show");
                        kVar.a(i2 & 3);
                        kVar.c(i2 & 2080374847);
                    }
                    if (!jSONObject.isNull("pop_duration")) {
                        kVar.f(jSONObject.optInt("pop_duration", 5));
                    }
                    if (!jSONObject.isNull("show_params")) {
                        kVar.e(jSONObject.optString("show_params"));
                    }
                    if (!jSONObject.isNull("log_ext")) {
                        kVar.c(jSONObject.optString("log_ext"));
                    }
                    kVar.b(i);
                    kVar.a(false);
                } catch (JSONException unused) {
                }
            } else {
                kVar.a(false);
            }
            byteArrayInputStream.close();
            dVar.a();
            eVar.a(kVar);
            if (d <= 0) {
                d = 0;
            }
            int i3 = d + 204;
            int length = bArr.length - i3;
            if (length <= 0) {
                length = 0;
            }
            byte[] bArr5 = new byte[length];
            System.arraycopy(bArr, i3, bArr5, 0, length);
            com.baidu.android.pushservice.w.m.l a = com.baidu.android.pushservice.w.m.l.a(kVar.q());
            if (a != com.baidu.android.pushservice.w.m.l.MSG_TYPE_APP_PRIORITY && com.baidu.android.pushservice.m.d.a(this.a, kVar.g())) {
                com.baidu.android.pushservice.u.a.a("PushMessageHandler", "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.b);
                gVar.a(4);
                return gVar;
            }
            g gVar2 = gVar;
            com.baidu.android.pushservice.w.m.c a2 = new com.baidu.android.pushservice.w.m.k(this.a).a(a);
            if (a2 != null) {
                gVar2 = a2.a(kVar, bArr5);
            } else {
                gVar2.a(2);
            }
            if (gVar2 == null) {
                return null;
            }
            if (a == com.baidu.android.pushservice.w.m.l.MSG_TYPE_SINGLE_PRIVATE || a == com.baidu.android.pushservice.w.m.l.MSG_TYPE_MULTI_PRIVATE || a == com.baidu.android.pushservice.w.m.l.MSG_TYPE_PRIVATE_MESSAGE) {
                com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), bArr5, kVar.k(), kVar.c(), gVar2.a(), kVar.i());
            } else if (a == com.baidu.android.pushservice.w.m.l.MSG_TYPE_LOCAL_PUSH_MESSAGE) {
                com.baidu.android.pushservice.n.c.a().a(this.a, new LocalPushMsg(kVar, new String(bArr5)));
            } else if (a != com.baidu.android.pushservice.w.m.l.MSG_TYPE_APP_PRIORITY) {
                com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), null, null, 0L, gVar2.a(), kVar.i());
            }
            Utility.D(this.a);
            return gVar2;
        } catch (IOException unused2) {
            return gVar;
        }
    }
}
