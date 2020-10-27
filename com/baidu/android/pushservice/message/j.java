package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j extends c {
    private Context b;

    public j(Context context) {
        super(context);
        this.b = context.getApplicationContext();
    }

    private static String a(byte[] bArr) {
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

    private static void a(Context context, com.baidu.android.pushservice.message.a.j jVar, String str, int i) {
        if (jVar == com.baidu.android.pushservice.message.a.j.MSG_TYPE_SINGLE_PRIVATE || jVar == com.baidu.android.pushservice.message.a.j.MSG_TYPE_MULTI_PRIVATE || jVar == com.baidu.android.pushservice.message.a.j.MSG_TYPE_PRIVATE_MESSAGE) {
            new b.a(context).a("0").b(str).a(System.currentTimeMillis()).c(i + "").b(601002L).a();
        } else {
            new b.a(context).a("0").b(str).a(System.currentTimeMillis()).c(i + "").b(601001L).a();
        }
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        g gVar;
        eVar.d = true;
        g gVar2 = new g();
        gVar2.a(-1);
        byte[] bArr = eVar.b;
        if (bArr == null) {
            return gVar2;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.baidu.android.pushservice.i.d dVar = new com.baidu.android.pushservice.i.d(byteArrayInputStream);
        try {
            k kVar = new k();
            byte[] bArr2 = new byte[128];
            dVar.a(bArr2);
            kVar.a(a(bArr2));
            kVar.b(dVar.d());
            kVar.a((int) dVar.c());
            int c = dVar.c();
            byte[] bArr3 = new byte[64];
            dVar.a(bArr3);
            kVar.a(bArr3);
            if (c > 0) {
                byte[] bArr4 = new byte[c];
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
                            kVar.b(string2);
                        }
                    }
                    if (!jSONObject.isNull("expiretime")) {
                        kVar.a(jSONObject.getLong("expiretime"));
                    }
                    kVar.a(false);
                } catch (JSONException e) {
                    new b.c(this.f1174a).a(Log.getStackTraceString(e)).a();
                }
            } else {
                kVar.a(false);
            }
            byteArrayInputStream.close();
            dVar.a();
            eVar.a(kVar);
            if (c <= 0) {
                c = 0;
            }
            int i = c + 204;
            int length = bArr.length - i;
            if (length <= 0) {
                length = 0;
            }
            byte[] bArr5 = new byte[length];
            System.arraycopy(bArr, i, bArr5, 0, length);
            m.a("New MSG: " + kVar.toString(), this.f1174a);
            com.baidu.android.pushservice.message.a.j a2 = com.baidu.android.pushservice.message.a.j.a(kVar.f());
            if (com.baidu.android.pushservice.c.c.c(this.f1174a, kVar.d())) {
                String str = "Message ID(" + kVar.e() + ") received duplicated, ack success to server directly.";
                com.baidu.android.pushservice.f.a.a("PushMessageHandler", str, this.b);
                m.a(str, this.b);
                a(this.f1174a, a2, kVar.e(), 4);
                gVar2.a(4);
                return gVar2;
            }
            com.baidu.android.pushservice.message.a.b a3 = new com.baidu.android.pushservice.message.a.i(this.f1174a).a(a2);
            if (a3 != null) {
                gVar = a3.a(kVar, bArr5);
            } else {
                gVar2.a(2);
                gVar = gVar2;
            }
            if (a2 == com.baidu.android.pushservice.message.a.j.MSG_TYPE_SINGLE_PRIVATE || a2 == com.baidu.android.pushservice.message.a.j.MSG_TYPE_MULTI_PRIVATE || a2 == com.baidu.android.pushservice.message.a.j.MSG_TYPE_PRIVATE_MESSAGE) {
                com.baidu.android.pushservice.c.c.a(this.f1174a, kVar.b(), kVar.f(), kVar.d(), bArr5, kVar.g(), kVar.a(), gVar.a());
            } else {
                com.baidu.android.pushservice.c.c.a(this.f1174a, kVar.b(), kVar.f(), kVar.d(), null, null, 0L, gVar.a());
            }
            if (m.o(this.f1174a)) {
            }
            a(this.f1174a, a2, kVar.e(), gVar.a());
            return gVar;
        } catch (IOException e2) {
            new b.c(this.f1174a).a(Log.getStackTraceString(e2)).a();
            return gVar2;
        }
    }
}
