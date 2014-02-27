package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends Handler {
    final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.a = gVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        e eVar;
        c cVar;
        a aVar;
        String str;
        a aVar2;
        String str2;
        String str3;
        c cVar2;
        String str4;
        String str5;
        e eVar2;
        String str6;
        BdStatSwitchData bdStatSwitchData;
        BdStatSwitchData bdStatSwitchData2;
        long uploadMilliInterval;
        i iVar;
        i iVar2;
        i iVar3;
        c cVar3;
        c cVar4;
        c cVar5;
        a aVar3;
        a aVar4;
        a aVar5;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        a aVar6;
        c cVar6;
        switch (message.what) {
            case 1:
                g gVar = this.a;
                cVar6 = this.a.v;
                g.a(gVar, cVar6);
                return;
            case 2:
                g gVar2 = this.a;
                aVar6 = this.a.u;
                g.a(gVar2, aVar6);
                return;
            case 3:
                g gVar3 = this.a;
                eVar6 = this.a.t;
                g.a(gVar3, eVar6);
                return;
            case 4:
                cVar3 = this.a.v;
                if (cVar3 != null) {
                    cVar4 = this.a.v;
                    if (!cVar4.h()) {
                        g gVar4 = this.a;
                        cVar5 = this.a.v;
                        g.b(gVar4, cVar5);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                aVar3 = this.a.u;
                if (aVar3 != null) {
                    aVar4 = this.a.u;
                    if (!aVar4.h()) {
                        g gVar5 = this.a;
                        aVar5 = this.a.u;
                        g.b(gVar5, aVar5);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                eVar3 = this.a.t;
                if (eVar3 != null) {
                    eVar4 = this.a.t;
                    if (!eVar4.h()) {
                        g gVar6 = this.a;
                        eVar5 = this.a.t;
                        g.b(gVar6, eVar5);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                this.a.b();
                synchronized (BdStatSwitchData.class) {
                    bdStatSwitchData = this.a.w;
                    if (bdStatSwitchData == null) {
                        this.a.w = new BdStatSwitchData();
                    }
                    bdStatSwitchData2 = this.a.w;
                    uploadMilliInterval = bdStatSwitchData2.getUploadMilliInterval();
                }
                iVar = g.s;
                iVar.removeMessages(7);
                iVar2 = g.s;
                iVar3 = g.s;
                iVar2.sendMessageDelayed(iVar3.obtainMessage(7), uploadMilliInterval);
                return;
            case 8:
                eVar = this.a.t;
                if (eVar != null) {
                    k a = k.a();
                    str5 = this.a.g;
                    long a2 = a.a(str5);
                    if (a2 <= 0) {
                        a2 = System.currentTimeMillis();
                        k a3 = k.a();
                        str6 = this.a.g;
                        a3.a(a2, str6);
                    }
                    eVar2 = this.a.t;
                    eVar2.a(a2);
                }
                cVar = this.a.v;
                if (cVar != null) {
                    k a4 = k.a();
                    str3 = this.a.g;
                    long c = a4.c(str3);
                    if (c <= 0) {
                        c = System.currentTimeMillis();
                        k a5 = k.a();
                        str4 = this.a.g;
                        a5.c(c, str4);
                    }
                    cVar2 = this.a.v;
                    cVar2.a(c);
                }
                aVar = this.a.u;
                if (aVar != null) {
                    k a6 = k.a();
                    str = this.a.g;
                    long b = a6.b(str);
                    if (b <= 0) {
                        b = System.currentTimeMillis();
                        k a7 = k.a();
                        str2 = this.a.g;
                        a7.b(b, str2);
                    }
                    aVar2 = this.a.u;
                    aVar2.a(b);
                }
                g.g(this.a);
                g.a(this.a);
                return;
            default:
                return;
        }
    }
}
