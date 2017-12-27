package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
        com.baidu.android.pushservice.j.h hVar = new com.baidu.android.pushservice.j.h(byteArrayInputStream);
        try {
            k kVar = new k();
            byte[] bArr2 = new byte[128];
            hVar.a(bArr2);
            kVar.a(a(bArr2));
            kVar.d(hVar.d());
            short c = hVar.c();
            kVar.a((int) c);
            int c2 = hVar.c();
            byte[] bArr3 = new byte[64];
            hVar.a(bArr3);
            kVar.a(bArr3);
            if (c2 > 0) {
                byte[] bArr4 = new byte[c2];
                hVar.a(bArr4);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr4));
                    if (!jSONObject.isNull("package_name")) {
                        String string = jSONObject.getString("package_name");
                        if (!TextUtils.isEmpty(string)) {
                            kVar.b(string);
                        }
                    }
                    if (!jSONObject.isNull("expiretime")) {
                        kVar.c(jSONObject.getLong("expiretime"));
                    }
                    if (com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_NOTIFICATION.a() == c || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_MESSAGE.a() == c || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_AD_NOTIFICATION.a() == c) {
                        kVar.a(true);
                        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("deleteInvalidAlarmMsg", (short) 95) { // from class: com.baidu.android.pushservice.message.j.1
                            @Override // com.baidu.android.pushservice.i.c
                            public void a() {
                                com.baidu.android.pushservice.d.a.c(j.this.a);
                            }
                        });
                        if (!jSONObject.isNull("alarmmsgid")) {
                            String string2 = jSONObject.getString("alarmmsgid");
                            if (!jSONObject.isNull("alarmmsgenable")) {
                                int a = com.baidu.android.pushservice.d.a.a(this.a, string2, jSONObject.getInt("alarmmsgenable"));
                                eVar.a(kVar);
                                gVar2.a(a < 0 ? 3 : 0);
                                return gVar2;
                            }
                        }
                        if (!jSONObject.isNull("sendtime")) {
                            kVar.a(jSONObject.getLong("sendtime"));
                        }
                        if (!jSONObject.isNull("showtime")) {
                            kVar.b(jSONObject.getLong("showtime"));
                        }
                    } else {
                        kVar.a(false);
                    }
                } catch (JSONException e) {
                }
            } else {
                kVar.a(false);
            }
            byteArrayInputStream.close();
            hVar.a();
            eVar.a(kVar);
            if (c2 <= 0) {
                c2 = 0;
            }
            int i = c2 + HttpStatus.SC_NO_CONTENT;
            int length = bArr.length - i;
            if (length <= 0) {
                length = 0;
            }
            byte[] bArr5 = new byte[length];
            System.arraycopy(bArr, i, bArr5, 0, length);
            p.b("New MSG: " + kVar.toString(), this.a);
            if (com.baidu.android.pushservice.d.c.c(this.a, kVar.g())) {
                com.baidu.android.pushservice.g.a.a("PushMessageHandler", "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.b);
                com.baidu.android.pushservice.h.l.a(this.a, kVar.e(), kVar.h(), kVar.i(), bArr5, 4, com.baidu.android.pushservice.h.j.a);
                gVar2.a(4);
                return gVar2;
            }
            com.baidu.android.pushservice.message.a.l a2 = com.baidu.android.pushservice.message.a.l.a(kVar.i());
            com.baidu.android.pushservice.message.a.c a3 = new com.baidu.android.pushservice.message.a.k(this.a).a(a2);
            if (a3 != null) {
                gVar = a3.a(kVar, bArr5);
            } else {
                gVar2.a(2);
                gVar = gVar2;
            }
            if (a2 == com.baidu.android.pushservice.message.a.l.MSG_TYPE_SINGLE_PRIVATE || a2 == com.baidu.android.pushservice.message.a.l.MSG_TYPE_MULTI_PRIVATE || a2 == com.baidu.android.pushservice.message.a.l.MSG_TYPE_PRIVATE_MESSAGE) {
                com.baidu.android.pushservice.d.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), bArr5, kVar.j(), kVar.d(), gVar.a());
            } else {
                com.baidu.android.pushservice.d.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), null, null, 0L, gVar.a());
            }
            if (p.F(this.a)) {
            }
            com.baidu.android.pushservice.h.l.a(this.a, kVar.e(), kVar.h(), kVar.i(), bArr5, gVar.a(), com.baidu.android.pushservice.h.j.a);
            return gVar;
        } catch (IOException e2) {
            return gVar2;
        }
    }
}
