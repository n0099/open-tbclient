package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes8.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent aKm;
    final /* synthetic */ a.C0121a aKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0121a c0121a, IOAdEvent iOAdEvent) {
        this.aKn = c0121a;
        this.aKm = iOAdEvent;
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
        if (this.aKm.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.aKn.aKl;
            iXAdProd11 = this.aKn.aKk;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.aKm.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.aKn.aKk;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.aKn.aKk;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.aKn.aKl;
            iXAdProd9 = this.aKn.aKk;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.aKm.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.aKn.aKl;
            iXAdProd7 = this.aKn.aKk;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.aKm.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.aKn.aKk;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.aKn.aKk;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.aKn.aKl;
            iXAdProd5 = this.aKn.aKk;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.aKm.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.aKn.aKk;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.aKn.aKk;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.aKn.aKl;
            iXAdProd2 = this.aKn.aKk;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
