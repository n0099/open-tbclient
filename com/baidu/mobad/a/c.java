package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes10.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent bkC;
    final /* synthetic */ a.C0173a bkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0173a c0173a, IOAdEvent iOAdEvent) {
        this.bkD = c0173a;
        this.bkC = iOAdEvent;
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
        if (this.bkC.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.bkD.bkB;
            iXAdProd11 = this.bkD.bkA;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.bkC.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.bkD.bkA;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.bkD.bkA;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.bkD.bkB;
            iXAdProd9 = this.bkD.bkA;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.bkC.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.bkD.bkB;
            iXAdProd7 = this.bkD.bkA;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.bkC.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.bkD.bkA;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.bkD.bkA;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.bkD.bkB;
            iXAdProd5 = this.bkD.bkA;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.bkC.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.bkD.bkA;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.bkD.bkA;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.bkD.bkB;
            iXAdProd2 = this.bkD.bkA;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
