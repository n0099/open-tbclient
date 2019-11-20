package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class h implements Runnable {
    final /* synthetic */ g aAl;
    final /* synthetic */ IOAdEvent azH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, IOAdEvent iOAdEvent) {
        this.aAl = gVar;
        this.azH = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        if (IXAdEvent.AD_LOADED.equals(this.azH.getType())) {
            aVar6 = this.aAl.aAk.azP;
            aVar6.b(this.aAl.aAk);
        } else if (IXAdEvent.AD_STARTED.equals(this.azH.getType())) {
            aVar4 = this.aAl.aAk.azP;
            aVar4.zp();
            aVar5 = this.aAl.aAk.azP;
            aVar5.M(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.azH.getType())) {
            aVar3 = this.aAl.aAk.azP;
            aVar3.dy(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.azH.getData()));
        } else if ("AdUserClick".equals(this.azH.getType())) {
            aVar2 = this.aAl.aAk.azP;
            aVar2.N(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.azH.getType())) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View) this.aAl.aAk);
            aVar = this.aAl.aAk.azP;
            aVar.O(new JSONObject());
        }
    }
}
