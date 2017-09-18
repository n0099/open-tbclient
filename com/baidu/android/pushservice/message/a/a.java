package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class a extends c {
    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        com.baidu.android.pushservice.message.g gVar;
        long b = kVar.b();
        long c = kVar.c();
        long d = kVar.d();
        l a = l.a(kVar.i());
        String h = kVar.h();
        String e = kVar.e();
        long j = c - b;
        long j2 = d - b;
        PublicMsg publicMsg = new PublicMsg();
        com.baidu.android.pushservice.g.a.c("AlarmMessageHandler", "Alarm Message Type = " + a);
        com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
        if (kVar.a() && (j > 0 || j2 <= 0)) {
            if (j2 <= 0) {
                publicMsg.handleAlarmMessage(this.a, "010704", h, e);
                com.baidu.android.pushservice.d.a.d(this.a, kVar.h());
                com.baidu.android.pushservice.g.a.c("AlarmMessageHandler", "alarm message is expired!");
                return gVar2;
            }
            kVar.b(System.currentTimeMillis() + (1000 * j));
            kVar.c(System.currentTimeMillis() + (1000 * j2));
            com.baidu.android.pushservice.g.a.c("AlarmMessageHandler", "lastshowtime = " + j + "   lastexpiretime = " + j2);
            p.a(this.a, kVar, bArr);
            gVar2.a(1);
            return gVar2;
        }
        if (a.equals(l.MSG_TYPE_ALARM_NOTIFICATION)) {
            a = l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION;
        } else if (a.equals(l.MSG_TYPE_ALARM_MESSAGE)) {
            a = l.MSG_TYPE_PRIVATE_MESSAGE;
        }
        c a2 = new k(this.a).a(a);
        if (a2 != null) {
            com.baidu.android.pushservice.message.g a3 = a2.a(kVar, bArr);
            com.baidu.android.pushservice.g.a.c("AlarmMessageHandler", "handle normal  message msgType = " + a);
            com.baidu.android.pushservice.d.a.d(this.a, kVar.h());
            if (a.equals(l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION)) {
                publicMsg.handleAlarmMessage(this.a, "010701", h, e);
                gVar = a3;
            } else if (a.equals(l.MSG_TYPE_PRIVATE_MESSAGE)) {
                publicMsg.handleAlarmMessage(this.a, "010702", h, e);
                gVar = a3;
            } else {
                gVar = a3;
            }
        } else {
            com.baidu.android.pushservice.g.a.b("AlarmMessageHandler", "message type invalid ");
            gVar = gVar2;
        }
        return gVar;
    }
}
