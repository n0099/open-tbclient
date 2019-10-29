package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class h implements Runnable {
    final /* synthetic */ g aAD;
    final /* synthetic */ IOAdEvent azY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, IOAdEvent iOAdEvent) {
        this.aAD = gVar;
        this.azY = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        if (IXAdEvent.AD_LOADED.equals(this.azY.getType())) {
            aVar6 = this.aAD.aAC.aAh;
            aVar6.b(this.aAD.aAC);
        } else if (IXAdEvent.AD_STARTED.equals(this.azY.getType())) {
            aVar4 = this.aAD.aAC.aAh;
            aVar4.zo();
            aVar5 = this.aAD.aAC.aAh;
            aVar5.L(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.azY.getType())) {
            aVar3 = this.aAD.aAC.aAh;
            aVar3.dy(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.azY.getData()));
        } else if ("AdUserClick".equals(this.azY.getType())) {
            aVar2 = this.aAD.aAC.aAh;
            aVar2.M(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.azY.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aAD.aAC);
            aVar = this.aAD.aAC.aAh;
            aVar.N(new JSONObject());
        }
    }
}
