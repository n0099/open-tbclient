package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
class k implements Runnable {
    final /* synthetic */ j aAF;
    final /* synthetic */ IOAdEvent azY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IOAdEvent iOAdEvent) {
        this.aAF = jVar;
        this.azY = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.azY.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.azY);
            HashMap hashMap = (HashMap) this.azY.getData();
            if (hashMap != null) {
                eVar7 = this.aAF.aAE.aAy;
                eVar7.l(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.azY.getType())) {
            eVar6 = this.aAF.aAE.aAy;
            eVar6.zt();
        } else if ("AdUserClick".equals(this.azY.getType())) {
            eVar5 = this.aAF.aAE.aAy;
            eVar5.zv();
        } else if (IXAdEvent.AD_STOPPED.equals(this.azY.getType())) {
            aVar2 = this.aAF.aAE.a;
            aVar2.removeAllListeners();
            eVar4 = this.aAF.aAE.aAy;
            eVar4.zu();
        } else if (IXAdEvent.AD_ERROR.equals(this.azY.getType())) {
            aVar = this.aAF.aAE.a;
            aVar.removeAllListeners();
            eVar3 = this.aAF.aAE.aAy;
            eVar3.dy(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.azY.getData()));
        } else if ("AdTypeReady".equals(this.azY.getType())) {
            try {
                Map<String, Object> data = this.azY.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        eVar2 = this.aAF.aAE.aAy;
                        eVar2.a(rsplashType, 0);
                    } else {
                        eVar = this.aAF.aAE.aAy;
                        eVar.a(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
