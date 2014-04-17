package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends Handler {
    final /* synthetic */ i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, Looper looper) {
        super(looper);
        this.a = iVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        f fVar;
        c cVar;
        a aVar;
        String str;
        a aVar2;
        String str2;
        String str3;
        c cVar2;
        String str4;
        String str5;
        f fVar2;
        String str6;
        BdStatSwitchData bdStatSwitchData;
        BdStatSwitchData bdStatSwitchData2;
        long uploadMilliInterval;
        k kVar;
        k kVar2;
        k kVar3;
        c cVar3;
        c cVar4;
        c cVar5;
        a aVar3;
        a aVar4;
        a aVar5;
        f fVar3;
        f fVar4;
        f fVar5;
        f fVar6;
        a aVar6;
        c cVar6;
        switch (message.what) {
            case 1:
                i iVar = this.a;
                cVar6 = this.a.v;
                i.a(iVar, cVar6);
                return;
            case 2:
                i iVar2 = this.a;
                aVar6 = this.a.u;
                i.a(iVar2, aVar6);
                return;
            case 3:
                i iVar3 = this.a;
                fVar6 = this.a.t;
                i.a(iVar3, fVar6);
                return;
            case 4:
                cVar3 = this.a.v;
                if (cVar3 != null) {
                    cVar4 = this.a.v;
                    if (!cVar4.h()) {
                        i iVar4 = this.a;
                        cVar5 = this.a.v;
                        i.b(iVar4, cVar5);
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
                        i iVar5 = this.a;
                        aVar5 = this.a.u;
                        i.b(iVar5, aVar5);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                fVar3 = this.a.t;
                if (fVar3 != null) {
                    fVar4 = this.a.t;
                    if (!fVar4.h()) {
                        i iVar6 = this.a;
                        fVar5 = this.a.t;
                        i.b(iVar6, fVar5);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                this.a.c();
                synchronized (BdStatSwitchData.class) {
                    bdStatSwitchData = this.a.w;
                    if (bdStatSwitchData == null) {
                        this.a.w = new BdStatSwitchData();
                    }
                    bdStatSwitchData2 = this.a.w;
                    uploadMilliInterval = bdStatSwitchData2.getUploadMilliInterval();
                }
                kVar = i.s;
                kVar.removeMessages(7);
                kVar2 = i.s;
                kVar3 = i.s;
                kVar2.sendMessageDelayed(kVar3.obtainMessage(7), uploadMilliInterval);
                return;
            case 8:
                fVar = this.a.t;
                if (fVar != null) {
                    m a = m.a();
                    str5 = this.a.g;
                    long a2 = a.a(str5);
                    if (a2 <= 0) {
                        a2 = System.currentTimeMillis();
                        m a3 = m.a();
                        str6 = this.a.g;
                        a3.a(a2, str6);
                    }
                    fVar2 = this.a.t;
                    fVar2.a(a2);
                }
                cVar = this.a.v;
                if (cVar != null) {
                    m a4 = m.a();
                    str3 = this.a.g;
                    long c = a4.c(str3);
                    if (c <= 0) {
                        c = System.currentTimeMillis();
                        m a5 = m.a();
                        str4 = this.a.g;
                        a5.c(c, str4);
                    }
                    cVar2 = this.a.v;
                    cVar2.a(c);
                }
                aVar = this.a.u;
                if (aVar != null) {
                    m a6 = m.a();
                    str = this.a.g;
                    long b = a6.b(str);
                    if (b <= 0) {
                        b = System.currentTimeMillis();
                        m a7 = m.a();
                        str2 = this.a.g;
                        a7.b(b, str2);
                    }
                    aVar2 = this.a.u;
                    aVar2.a(b);
                }
                i.g(this.a);
                i.a(this.a);
                return;
            default:
                return;
        }
    }
}
