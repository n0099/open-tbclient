package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
class k implements Runnable {
    final /* synthetic */ j agL;
    final /* synthetic */ IOAdEvent agf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IOAdEvent iOAdEvent) {
        this.agL = jVar;
        this.agf = iOAdEvent;
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
        if (IXAdEvent.AD_LOADED.equals(this.agf.getType())) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(this.agf);
            HashMap hashMap = (HashMap) this.agf.getData();
            if (hashMap != null) {
                eVar7 = this.agL.agK.agE;
                eVar7.l(hashMap);
            }
        } else if (IXAdEvent.AD_STARTED.equals(this.agf.getType())) {
            eVar6 = this.agL.agK.agE;
            eVar6.uv();
        } else if ("AdUserClick".equals(this.agf.getType())) {
            eVar5 = this.agL.agK.agE;
            eVar5.ux();
        } else if (IXAdEvent.AD_STOPPED.equals(this.agf.getType())) {
            aVar2 = this.agL.agK.a;
            aVar2.removeAllListeners();
            eVar4 = this.agL.agK.agE;
            eVar4.uw();
        } else if (IXAdEvent.AD_ERROR.equals(this.agf.getType())) {
            aVar = this.agL.agK.a;
            aVar.removeAllListeners();
            eVar3 = this.agL.agK.agE;
            eVar3.cM(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.agf.getData()));
        } else if ("AdTypeReady".equals(this.agf.getType())) {
            try {
                Map<String, Object> data = this.agf.getData();
                if (data != null && data.containsKey(com.baidu.mobads.a.a.s)) {
                    RsplashType rsplashType = (RsplashType) data.get(com.baidu.mobads.a.a.s);
                    if (rsplashType != RsplashType.VIDEO) {
                        eVar2 = this.agL.agK.agE;
                        eVar2.a(rsplashType, 0);
                    } else {
                        eVar = this.agL.agK.agE;
                        eVar.a(rsplashType, ((Integer) data.get(com.baidu.mobads.a.a.t)).intValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
