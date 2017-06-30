package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.q;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends c {
    private static final String b = j.class.getSimpleName();
    private Context c;

    public j(Context context) {
        super(context);
        this.c = context.getApplicationContext();
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
        com.baidu.android.pushservice.j.i iVar = new com.baidu.android.pushservice.j.i(byteArrayInputStream);
        try {
            k kVar = new k();
            byte[] bArr2 = new byte[128];
            iVar.a(bArr2);
            String a = a(bArr2);
            kVar.a(a);
            long d = iVar.d();
            kVar.d(d);
            short c = iVar.c();
            kVar.a((int) c);
            int c2 = iVar.c();
            byte[] bArr3 = new byte[64];
            iVar.a(bArr3);
            kVar.a(bArr3);
            com.baidu.android.pushservice.g.a.c(b, "Message Received  appid = " + a + " msgid: " + d + " type: " + ((int) c));
            if (c2 > 0) {
                String str = "";
                byte[] bArr4 = new byte[c2];
                iVar.a(bArr4);
                String str2 = new String(bArr4);
                long j = 0;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (!jSONObject.isNull("package_name")) {
                        String string = jSONObject.getString("package_name");
                        if (!TextUtils.isEmpty(string)) {
                            kVar.b(string);
                            com.baidu.android.pushservice.g.a.c(b, "Message Has PackageName = " + string);
                        }
                    }
                    if (!jSONObject.isNull("expiretime")) {
                        j = jSONObject.getLong("expiretime");
                        kVar.c(j);
                    }
                    long j2 = j;
                    if (com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_NOTIFICATION.a() == c || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_MESSAGE.a() == c || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_AD_NOTIFICATION.a() == c) {
                        long j3 = 0;
                        long j4 = 0;
                        kVar.a(true);
                        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("deleteInvalidAlarmMsg", (short) 95) { // from class: com.baidu.android.pushservice.message.j.1
                            @Override // com.baidu.android.pushservice.i.c
                            public void a() {
                                com.baidu.android.pushservice.d.a.c(j.this.a);
                                com.baidu.android.pushservice.g.a.c(j.b, "deleteInvalidAlarmMsg");
                            }
                        });
                        if (!jSONObject.isNull("alarmmsgid")) {
                            str = jSONObject.getString("alarmmsgid");
                            if (!jSONObject.isNull("alarmmsgenable")) {
                                int i = jSONObject.getInt("alarmmsgenable");
                                int a2 = com.baidu.android.pushservice.d.a.a(this.a, str, i);
                                eVar.a(kVar);
                                com.baidu.android.pushservice.g.a.c(b, "Alarm Message Json setMsg MsgID = " + str + "  Enable  = " + i);
                                gVar2.a(a2 < 0 ? 3 : 0);
                                return gVar2;
                            }
                        }
                        if (!jSONObject.isNull("sendtime")) {
                            j3 = jSONObject.getLong("sendtime");
                            kVar.a(j3);
                        }
                        if (!jSONObject.isNull("showtime")) {
                            j4 = jSONObject.getLong("showtime");
                            kVar.b(j4);
                        }
                        com.baidu.android.pushservice.g.a.c(b, "Alarm Message  sendtime = " + j3 + "   showtime = " + j4 + "  expiretime =  " + j2 + "  mAlarmMsgId = " + str + " msgIDEnable =  0  msgid = " + kVar.h());
                    } else {
                        kVar.a(false);
                        com.baidu.android.pushservice.g.a.c(b, "Alarm Message Json = setIsAlarm false and message is not alarm Type!");
                    }
                } catch (JSONException e) {
                    com.baidu.android.pushservice.g.a.a(b, e);
                }
            } else {
                kVar.a(false);
                com.baidu.android.pushservice.g.a.c(b, "Message is not Alarm Message");
                com.baidu.android.pushservice.g.a.c(b, "Message NOT Has PackageName !");
            }
            byteArrayInputStream.close();
            iVar.a();
            eVar.a(kVar);
            if (c2 <= 0) {
                c2 = 0;
            }
            int i2 = c2 + 204;
            int length = bArr.length - i2;
            if (length <= 0) {
                length = 0;
            }
            byte[] bArr5 = new byte[length];
            System.arraycopy(bArr, i2, bArr5, 0, length);
            com.baidu.android.pushservice.g.a.b(b, "New MSG: " + kVar.toString());
            q.b("New MSG: " + kVar.toString(), this.a);
            if (com.baidu.android.pushservice.d.c.c(this.a, kVar.g())) {
                com.baidu.android.pushservice.g.b.a(b, "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.c);
                com.baidu.android.pushservice.h.k.a(this.a, kVar.e(), kVar.h(), kVar.i(), bArr5, 4, com.baidu.android.pushservice.h.i.a);
                gVar2.a(4);
                return gVar2;
            }
            com.baidu.android.pushservice.message.a.l a3 = com.baidu.android.pushservice.message.a.l.a(kVar.i());
            com.baidu.android.pushservice.message.a.c a4 = new com.baidu.android.pushservice.message.a.k(this.a).a(a3);
            if (a4 != null) {
                gVar = (com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_NOTIFICATION.a() == kVar.i() || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_MESSAGE.a() == kVar.i() || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_AD_NOTIFICATION.a() == kVar.i()) ? a4.a(kVar, bArr5) : a4.a(kVar.e(), kVar.h(), kVar.i(), kVar.j(), kVar.f(), bArr5);
            } else {
                gVar2.a(2);
                gVar = gVar2;
            }
            if (a3 == com.baidu.android.pushservice.message.a.l.MSG_TYPE_SINGLE_PRIVATE || a3 == com.baidu.android.pushservice.message.a.l.MSG_TYPE_MULTI_PRIVATE || a3 == com.baidu.android.pushservice.message.a.l.MSG_TYPE_PRIVATE_MESSAGE) {
                com.baidu.android.pushservice.d.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), bArr5, kVar.j(), kVar.d(), gVar.a());
            } else {
                com.baidu.android.pushservice.d.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), null, null, 0L, gVar.a());
            }
            com.baidu.android.pushservice.g.a.c(b, "insertMsgInfo  msgid: " + kVar.g() + " expiretime =  " + kVar.d());
            com.baidu.android.pushservice.g.a.b(b, "push message handle messageType = " + a3 + " msgId: " + kVar.g() + " result: " + gVar.a() + " socketversion = " + (q.E(this.a) ? "V3" : "V2") + " MessagePkgname = " + kVar.f());
            com.baidu.android.pushservice.h.k.a(this.a, kVar.e(), kVar.h(), kVar.i(), bArr5, gVar.a(), com.baidu.android.pushservice.h.i.a);
            return gVar;
        } catch (IOException e2) {
            com.baidu.android.pushservice.g.a.a(b, e2);
            return gVar2;
        }
    }
}
