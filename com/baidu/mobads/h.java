package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class h implements Runnable {
    final /* synthetic */ IOAdEvent agB;
    final /* synthetic */ g ahf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, IOAdEvent iOAdEvent) {
        this.ahf = gVar;
        this.agB = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        if (IXAdEvent.AD_LOADED.equals(this.agB.getType())) {
            aVar6 = this.ahf.ahe.agK;
            aVar6.b(this.ahf.ahe);
        } else if (IXAdEvent.AD_STARTED.equals(this.agB.getType())) {
            aVar4 = this.ahf.ahe.agK;
            aVar4.uu();
            aVar5 = this.ahf.ahe.agK;
            aVar5.n(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.agB.getType())) {
            aVar3 = this.ahf.ahe.agK;
            aVar3.cO(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.agB.getData()));
        } else if ("AdUserClick".equals(this.agB.getType())) {
            aVar2 = this.ahf.ahe.agK;
            aVar2.o(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.agB.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.ahf.ahe);
            aVar = this.ahf.ahe.agK;
            aVar.p(new JSONObject());
        }
    }
}
