package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j extends c {
    private Context b;

    public j(Context context) {
        super(context);
        this.b = context.getApplicationContext();
    }

    private String a(byte[] bArr) {
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

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        g gVar;
        eVar.e = true;
        g gVar2 = new g();
        gVar2.a(-1);
        byte[] bArr = eVar.c;
        if (bArr == null) {
            return gVar2;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.baidu.android.pushservice.i.e eVar2 = new com.baidu.android.pushservice.i.e(byteArrayInputStream);
        try {
            k kVar = new k();
            byte[] bArr2 = new byte[128];
            eVar2.a(bArr2);
            kVar.a(a(bArr2));
            kVar.b(eVar2.d());
            kVar.a((int) eVar2.c());
            int c = eVar2.c();
            byte[] bArr3 = new byte[64];
            eVar2.a(bArr3);
            kVar.a(bArr3);
            if (c > 0) {
                byte[] bArr4 = new byte[c];
                eVar2.a(bArr4);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr4));
                    if (!jSONObject.isNull("package_name")) {
                        String string = jSONObject.getString("package_name");
                        if (!TextUtils.isEmpty(string)) {
                            kVar.b(string);
                        }
                    }
                    if (!jSONObject.isNull("expiretime")) {
                        kVar.a(jSONObject.getLong("expiretime"));
                    }
                    kVar.a(false);
                } catch (JSONException e) {
                }
            } else {
                kVar.a(false);
            }
            byteArrayInputStream.close();
            eVar2.a();
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
            com.baidu.android.pushservice.i.l.b("New MSG: " + kVar.toString(), this.a);
            if (com.baidu.android.pushservice.c.c.c(this.a, kVar.d())) {
                com.baidu.android.pushservice.f.a.a("PushMessageHandler", "Message ID(" + kVar.e() + ") received duplicated, ack success to server directly.", this.b);
                com.baidu.android.pushservice.g.i.a(this.a, kVar.b(), kVar.e(), kVar.f(), bArr5, 4, com.baidu.android.pushservice.g.g.a);
                gVar2.a(4);
                return gVar2;
            }
            com.baidu.android.pushservice.message.a.k a = com.baidu.android.pushservice.message.a.k.a(kVar.f());
            com.baidu.android.pushservice.message.a.b a2 = new com.baidu.android.pushservice.message.a.j(this.a).a(a);
            if (a2 != null) {
                gVar = a2.a(kVar, bArr5);
            } else {
                gVar2.a(2);
                gVar = gVar2;
            }
            if (a == com.baidu.android.pushservice.message.a.k.MSG_TYPE_SINGLE_PRIVATE || a == com.baidu.android.pushservice.message.a.k.MSG_TYPE_MULTI_PRIVATE || a == com.baidu.android.pushservice.message.a.k.MSG_TYPE_PRIVATE_MESSAGE) {
                com.baidu.android.pushservice.c.c.a(this.a, kVar.b(), kVar.f(), kVar.d(), bArr5, kVar.g(), kVar.a(), gVar.a());
            } else {
                com.baidu.android.pushservice.c.c.a(this.a, kVar.b(), kVar.f(), kVar.d(), null, null, 0L, gVar.a());
            }
            if (com.baidu.android.pushservice.i.l.D(this.a)) {
            }
            com.baidu.android.pushservice.g.i.a(this.a, kVar.b(), kVar.e(), kVar.f(), bArr5, gVar.a(), com.baidu.android.pushservice.g.g.a);
            return gVar;
        } catch (IOException e2) {
            return gVar2;
        }
    }
}
