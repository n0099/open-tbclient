package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.h.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends c {
    private static final String b = j.class.getSimpleName();
    private Context c;
    private long d;
    private long e;
    private long f;
    private int g;
    private String h;
    private short i;
    private final int j;
    private final int k;

    public j(Context context) {
        super(context);
        this.j = 140;
        this.k = 64;
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
        eVar.e = true;
        g gVar = new g();
        gVar.a(-1);
        byte[] bArr = eVar.c;
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            com.baidu.android.pushservice.h.i iVar = new com.baidu.android.pushservice.h.i(byteArrayInputStream);
            this.i = (short) 0;
            try {
                k kVar = new k();
                byte[] bArr2 = new byte[128];
                iVar.a(bArr2);
                kVar.a(a(bArr2));
                kVar.d(iVar.d());
                short c = iVar.c();
                kVar.a((int) c);
                this.i = iVar.c();
                byte[] bArr3 = new byte[64];
                iVar.a(bArr3);
                kVar.a(bArr3);
                com.baidu.android.pushservice.e.a.c(b, "Message Received  jsonlength = " + ((int) this.i));
                if (this.i > 0) {
                    byte[] bArr4 = new byte[this.i];
                    iVar.a(bArr4);
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr4));
                        if (!jSONObject.isNull("package_name")) {
                            String string = jSONObject.getString("package_name");
                            if (!TextUtils.isEmpty(string)) {
                                kVar.b(string);
                                com.baidu.android.pushservice.e.a.c(b, "Message Has PackageName = " + string);
                            }
                        }
                        if (com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_NOTIFICATION.a() == c || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_MESSAGE.a() == c || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_AD_NOTIFICATION.a() == c) {
                            kVar.a(true);
                            com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("deleteInvalidAlarmMsg", (short) 95) { // from class: com.baidu.android.pushservice.message.j.1
                                @Override // com.baidu.android.pushservice.g.c
                                public void a() {
                                    o.c(j.this.a);
                                    com.baidu.android.pushservice.e.a.c(j.b, "deleteInvalidAlarmMsg");
                                }
                            });
                            if (!jSONObject.isNull("alarmmsgid")) {
                                this.h = jSONObject.getString("alarmmsgid");
                                if (!jSONObject.isNull("alarmmsgenable")) {
                                    this.g = jSONObject.getInt("alarmmsgenable");
                                    int a = o.a(this.a, this.h, this.g);
                                    eVar.a(kVar);
                                    com.baidu.android.pushservice.e.a.c(b, "Alarm Message Json setMsg MsgID = " + this.h + "  Enable  = " + this.g);
                                    gVar.a(a < 0 ? 3 : 0);
                                }
                            }
                            if (!jSONObject.isNull("sendtime")) {
                                this.d = jSONObject.getLong("sendtime");
                                kVar.a(this.d);
                            }
                            if (!jSONObject.isNull("showtime")) {
                                this.e = jSONObject.getLong("showtime");
                                kVar.b(this.e);
                            }
                            if (!jSONObject.isNull("expiretime")) {
                                this.f = jSONObject.getLong("expiretime");
                                kVar.c(this.f);
                            }
                            com.baidu.android.pushservice.e.a.c(b, "Alarm Message  sendtime = " + this.d + "   showtime = " + this.e + "  expiretime =  " + this.f + "  mAlarmMsgId = " + this.h + " msgIDEnable =  " + this.g + "  msgid = " + kVar.h());
                        } else {
                            kVar.a(false);
                            com.baidu.android.pushservice.e.a.c(b, "Alarm Message Json = setIsAlarm false and message is not alarm Type!");
                        }
                    } catch (JSONException e) {
                        com.baidu.android.pushservice.e.a.a(b, e);
                    }
                } else {
                    kVar.a(false);
                    com.baidu.android.pushservice.e.a.c(b, "Message is not Alarm Message");
                    com.baidu.android.pushservice.e.a.c(b, "Message NOT Has PackageName !");
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (iVar != null) {
                    iVar.a();
                }
                eVar.a(kVar);
                this.i = this.i > 0 ? this.i : (short) 0;
                int i = this.i + 204;
                int length = bArr.length - i;
                if (length <= 0) {
                    length = 0;
                }
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr, i, bArr5, 0, length);
                com.baidu.android.pushservice.e.a.b(b, "New MSG: " + kVar.toString());
                u.b("New MSG: " + kVar.toString(), this.a);
                if (o.e(this.a, kVar.h())) {
                    com.baidu.android.pushservice.message.a.l a2 = com.baidu.android.pushservice.message.a.l.a(kVar.i());
                    com.baidu.android.pushservice.message.a.c a3 = new com.baidu.android.pushservice.message.a.k(this.a).a(a2);
                    if (a3 != null) {
                        gVar = (com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_NOTIFICATION.a() == kVar.i() || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_MESSAGE.a() == kVar.i() || com.baidu.android.pushservice.message.a.l.MSG_TYPE_ALARM_AD_NOTIFICATION.a() == kVar.i()) ? a3.a(kVar, bArr5) : a3.a(kVar.e(), kVar.h(), kVar.i(), kVar.j(), kVar.f(), bArr5);
                    } else {
                        gVar.a(2);
                    }
                    com.baidu.android.pushservice.e.a.b(b, "push message handle messageType = " + a2 + " msgId: " + kVar.g() + " result: " + gVar.a() + " socketversion = " + (u.E(this.a) ? "V3" : "V2") + " MessagePkgname = " + kVar.f());
                    com.baidu.android.pushservice.f.k.a(this.a, kVar.e(), kVar.h(), kVar.i(), bArr5, gVar.a(), com.baidu.android.pushservice.f.i.a);
                } else {
                    com.baidu.android.pushservice.e.b.a(b, "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.c);
                    com.baidu.android.pushservice.f.k.a(this.a, kVar.e(), kVar.h(), kVar.i(), bArr5, 4, com.baidu.android.pushservice.f.i.a);
                    gVar.a(4);
                }
            } catch (IOException e2) {
                com.baidu.android.pushservice.e.a.a(b, e2);
            }
        }
        return gVar;
    }
}
