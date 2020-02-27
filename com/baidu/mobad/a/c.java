package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes10.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent aOq;
    final /* synthetic */ a.C0129a aOr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0129a c0129a, IOAdEvent iOAdEvent) {
        this.aOr = c0129a;
        this.aOq = iOAdEvent;
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
        if (this.aOq.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.aOr.aOp;
            iXAdProd11 = this.aOr.aOo;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.aOq.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.aOr.aOo;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.aOr.aOo;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.aOr.aOp;
            iXAdProd9 = this.aOr.aOo;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.aOq.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.aOr.aOp;
            iXAdProd7 = this.aOr.aOo;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.aOq.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.aOr.aOo;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.aOr.aOo;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.aOr.aOp;
            iXAdProd5 = this.aOr.aOo;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.aOq.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.aOr.aOo;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.aOr.aOo;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.aOr.aOp;
            iXAdProd2 = this.aOr.aOo;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
