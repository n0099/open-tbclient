package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
class k implements Runnable {
    final /* synthetic */ j aAn;
    final /* synthetic */ IOAdEvent azH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IOAdEvent iOAdEvent) {
        this.aAn = jVar;
        this.azH = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.azH.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.azH);
            HashMap hashMap = (HashMap) this.azH.getData();
            if (hashMap != null) {
                eVar7 = this.aAn.aAm.aAg;
                eVar7.l(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.azH.getType())) {
            eVar6 = this.aAn.aAm.aAg;
            eVar6.zu();
        } else if ("AdUserClick".equals(this.azH.getType())) {
            eVar5 = this.aAn.aAm.aAg;
            eVar5.zw();
        } else if (IXAdEvent.AD_STOPPED.equals(this.azH.getType())) {
            aVar2 = this.aAn.aAm.a;
            aVar2.removeAllListeners();
            eVar4 = this.aAn.aAm.aAg;
            eVar4.zv();
        } else if (IXAdEvent.AD_ERROR.equals(this.azH.getType())) {
            aVar = this.aAn.aAm.a;
            aVar.removeAllListeners();
            eVar3 = this.aAn.aAm.aAg;
            eVar3.dy(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.azH.getData()));
        } else if ("AdTypeReady".equals(this.azH.getType())) {
            try {
                Map<String, Object> data = this.azH.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        eVar2 = this.aAn.aAm.aAg;
                        eVar2.a(rsplashType, 0);
                    } else {
                        eVar = this.aAn.aAm.aAg;
                        eVar.a(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
