package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes20.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent bCT;
    final /* synthetic */ a.C0222a bCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0222a c0222a, IOAdEvent iOAdEvent) {
        this.bCU = c0222a;
        this.bCT = iOAdEvent;
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
        if (this.bCT.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.bCU.bCS;
            iXAdProd11 = this.bCU.bCR;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.bCT.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.bCU.bCR;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.bCU.bCR;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.bCU.bCS;
            iXAdProd9 = this.bCU.bCR;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.bCT.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.bCU.bCS;
            iXAdProd7 = this.bCU.bCR;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.bCT.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.bCU.bCR;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.bCU.bCR;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.bCU.bCS;
            iXAdProd5 = this.bCU.bCR;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.bCT.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.bCU.bCR;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.bCU.bCR;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.bCU.bCS;
            iXAdProd2 = this.bCU.bCR;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
