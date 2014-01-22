package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.UnsupportedEncodingException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ h a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h hVar, Looper looper) {
        super(looper);
        this.a = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        l lVar;
        l lVar2;
        BdStatSwitchData bdStatSwitchData;
        BdStatSwitchData bdStatSwitchData2;
        long uploadMilliInterval;
        f fVar;
        d dVar;
        a aVar;
        l lVar3;
        l lVar4;
        a aVar2;
        a aVar3;
        d dVar2;
        d dVar3;
        f fVar2;
        f fVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        a aVar4;
        a aVar5;
        a aVar6;
        f fVar4;
        f fVar5;
        f fVar6;
        f fVar7;
        a aVar7;
        d dVar7;
        switch (message.what) {
            case 1:
                h hVar = this.a;
                dVar7 = this.a.v;
                hVar.b(dVar7);
                return;
            case 2:
                h hVar2 = this.a;
                aVar7 = this.a.u;
                hVar2.b(aVar7);
                return;
            case 3:
                h hVar3 = this.a;
                fVar7 = this.a.t;
                hVar3.b(fVar7);
                return;
            case 4:
                dVar4 = this.a.v;
                if (dVar4 != null) {
                    dVar5 = this.a.v;
                    if (!dVar5.g()) {
                        h hVar4 = this.a;
                        dVar6 = this.a.v;
                        hVar4.a(dVar6);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                aVar4 = this.a.u;
                if (aVar4 != null) {
                    aVar5 = this.a.u;
                    if (!aVar5.g()) {
                        h hVar5 = this.a;
                        aVar6 = this.a.u;
                        hVar5.a(aVar6);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                fVar4 = this.a.t;
                if (fVar4 != null) {
                    fVar5 = this.a.t;
                    if (!fVar5.g()) {
                        h hVar6 = this.a;
                        fVar6 = this.a.t;
                        hVar6.a(fVar6);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                lVar2 = h.s;
                lVar2.removeMessages(7);
                synchronized (BdStatSwitchData.class) {
                    bdStatSwitchData = this.a.w;
                    if (bdStatSwitchData == null) {
                        this.a.w = new BdStatSwitchData();
                    }
                    bdStatSwitchData2 = this.a.w;
                    uploadMilliInterval = bdStatSwitchData2.getUploadMilliInterval();
                }
                fVar = this.a.t;
                if (fVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    fVar2 = this.a.t;
                    if (currentTimeMillis - fVar2.f() >= uploadMilliInterval) {
                        fVar3 = this.a.t;
                        fVar3.c(true);
                    }
                }
                dVar = this.a.v;
                if (dVar != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    dVar2 = this.a.v;
                    if (currentTimeMillis2 - dVar2.f() >= uploadMilliInterval) {
                        dVar3 = this.a.v;
                        dVar3.c(true);
                    }
                }
                aVar = this.a.u;
                if (aVar != null) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    aVar2 = this.a.u;
                    if (currentTimeMillis3 - aVar2.f() >= uploadMilliInterval) {
                        aVar3 = this.a.u;
                        aVar3.c(true);
                    }
                }
                lVar3 = h.s;
                lVar4 = h.s;
                lVar3.sendMessageDelayed(lVar4.obtainMessage(7), uploadMilliInterval);
                return;
            case 9:
                n a = n.a();
                str = this.a.g;
                byte[] a2 = a.a(str);
                if (a2 != null && a2.length > 0) {
                    BdStatSwitchData bdStatSwitchData3 = new BdStatSwitchData();
                    try {
                        bdStatSwitchData3.parserJson(new String(a2, "utf-8"));
                        if (bdStatSwitchData3.getError_code() == 0) {
                            this.a.a(bdStatSwitchData3);
                            return;
                        }
                        return;
                    } catch (UnsupportedEncodingException e) {
                        com.baidu.adp.lib.g.e.a(getClass(), "handleMessage.GET_CACHE_SWITCH", e);
                        return;
                    }
                }
                return;
            case 3000:
                lVar = h.s;
                lVar.removeMessages(3000);
                this.a.c();
                return;
            default:
                return;
        }
    }
}
