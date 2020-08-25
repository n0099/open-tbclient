package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes20.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ a.C0222a bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0222a c0222a, IOAdEvent iOAdEvent) {
        this.bCR = c0222a;
        this.bCQ = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        IXAdProd iXAdProd;
        IOAdEventDispatcher iOAdEventDispatcher;
        IXAdProd iXAdProd2;
        IXAdProd iXAdProd3;
        IXAdProd iXAdProd4;
        IOAdEventDispatcher iOAdEventDispatcher2;
        IXAdProd iXAdProd5;
        IXAdProd iXAdProd6;
        IOAdEventDispatcher iOAdEventDispatcher3;
        IXAdProd iXAdProd7;
        IXAdProd iXAdProd8;
        IOAdEventDispatcher iOAdEventDispatcher4;
        IXAdProd iXAdProd9;
        IXAdProd iXAdProd10;
        IOAdEventDispatcher iOAdEventDispatcher5;
        IXAdProd iXAdProd11;
        if (this.bCQ.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.bCR.bCP;
            iXAdProd11 = this.bCR.bCO;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.bCQ.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.bCR.bCO;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.bCR.bCO;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.bCR.bCP;
            iXAdProd9 = this.bCR.bCO;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.bCQ.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.bCR.bCP;
            iXAdProd7 = this.bCR.bCO;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.bCQ.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.bCR.bCO;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.bCR.bCO;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.bCR.bCP;
            iXAdProd5 = this.bCR.bCO;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.bCQ.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.bCR.bCO;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.bCR.bCO;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.bCR.bCP;
            iXAdProd2 = this.bCR.bCO;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
