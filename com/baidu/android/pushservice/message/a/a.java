package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class a extends c {
    private static final String b = a.class.getSimpleName();

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        com.baidu.android.pushservice.message.g gVar;
        long b2 = kVar.b();
        long c = kVar.c();
        long d = kVar.d();
        l a = l.a(kVar.i());
        String h = kVar.h();
        String e = kVar.e();
        long j = c - b2;
        long j2 = d - b2;
        PublicMsg publicMsg = new PublicMsg();
        com.baidu.android.pushservice.e.a.c(b, "Alarm Message Type = " + a);
        com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
        if (kVar.a() && (j > 0 || j2 <= 0)) {
            if (j2 <= 0) {
                publicMsg.handleAlarmMessage(this.a, "010704", h, e);
                o.d(this.a, kVar.h());
                com.baidu.android.pushservice.e.a.c(b, "alarm message is expired!");
                return gVar2;
            }
            kVar.b(System.currentTimeMillis() + (1000 * j));
            kVar.c(System.currentTimeMillis() + (1000 * j2));
            com.baidu.android.pushservice.e.a.c(b, "lastshowtime = " + j + "   lastexpiretime = " + j2);
            u.a(this.a, kVar, bArr);
            gVar2.a(1);
            return gVar2;
        }
        l lVar = a.equals(l.MSG_TYPE_ALARM_NOTIFICATION) ? l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION : a.equals(l.MSG_TYPE_ALARM_MESSAGE) ? l.MSG_TYPE_PRIVATE_MESSAGE : a;
        c a2 = new k(this.a).a(lVar);
        if (a2 != null) {
            gVar = a2.a(kVar.e(), kVar.h(), lVar.a(), kVar.j(), kVar.f(), bArr);
            com.baidu.android.pushservice.e.a.c(b, "handle normal  message msgType = " + lVar);
            o.d(this.a, kVar.h());
            if (lVar.equals(l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION)) {
                publicMsg.handleAlarmMessage(this.a, "010701", h, e);
            } else if (lVar.equals(l.MSG_TYPE_PRIVATE_MESSAGE)) {
                publicMsg.handleAlarmMessage(this.a, "010702", h, e);
            }
        } else {
            com.baidu.android.pushservice.e.a.b(b, "message type invalid ");
            gVar = gVar2;
        }
        return gVar;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        return null;
    }
}
