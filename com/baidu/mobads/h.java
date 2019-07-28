package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class h implements Runnable {
    final /* synthetic */ g agJ;
    final /* synthetic */ IOAdEvent agf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, IOAdEvent iOAdEvent) {
        this.agJ = gVar;
        this.agf = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        if (IXAdEvent.AD_LOADED.equals(this.agf.getType())) {
            aVar6 = this.agJ.agI.ago;
            aVar6.b(this.agJ.agI);
        } else if (IXAdEvent.AD_STARTED.equals(this.agf.getType())) {
            aVar4 = this.agJ.agI.ago;
            aVar4.uq();
            aVar5 = this.agJ.agI.ago;
            aVar5.n(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.agf.getType())) {
            aVar3 = this.agJ.agI.ago;
            aVar3.cM(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.agf.getData()));
        } else if ("AdUserClick".equals(this.agf.getType())) {
            aVar2 = this.agJ.agI.ago;
            aVar2.o(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.agf.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.agJ.agI);
            aVar = this.agJ.agI.ago;
            aVar.p(new JSONObject());
        }
    }
}
