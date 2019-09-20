package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
class k implements Runnable {
    final /* synthetic */ IOAdEvent agB;
    final /* synthetic */ j ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IOAdEvent iOAdEvent) {
        this.ahh = jVar;
        this.agB = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        e eVar2;
        com.baidu.mobads.production.g.a aVar;
        e eVar3;
        com.baidu.mobads.production.g.a aVar2;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        if (IXAdEvent.AD_LOADED.equals(this.agB.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.agB);
            HashMap hashMap = (HashMap) this.agB.getData();
            if (hashMap != null) {
                eVar7 = this.ahh.ahg.aha;
                eVar7.l(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.agB.getType())) {
            eVar6 = this.ahh.ahg.aha;
            eVar6.uz();
        } else if ("AdUserClick".equals(this.agB.getType())) {
            eVar5 = this.ahh.ahg.aha;
            eVar5.uB();
        } else if (IXAdEvent.AD_STOPPED.equals(this.agB.getType())) {
            aVar2 = this.ahh.ahg.a;
            aVar2.removeAllListeners();
            eVar4 = this.ahh.ahg.aha;
            eVar4.uA();
        } else if (IXAdEvent.AD_ERROR.equals(this.agB.getType())) {
            aVar = this.ahh.ahg.a;
            aVar.removeAllListeners();
            eVar3 = this.ahh.ahg.aha;
            eVar3.cO(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.agB.getData()));
        } else if ("AdTypeReady".equals(this.agB.getType())) {
            try {
                Map<String, Object> data = this.agB.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        eVar2 = this.ahh.ahg.aha;
                        eVar2.a(rsplashType, 0);
                    } else {
                        eVar = this.ahh.ahg.aha;
                        eVar.a(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
