package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes10.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent aOr;
    final /* synthetic */ a.C0129a aOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0129a c0129a, IOAdEvent iOAdEvent) {
        this.aOs = c0129a;
        this.aOr = iOAdEvent;
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
        if (this.aOr.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.aOs.aOq;
            iXAdProd11 = this.aOs.aOp;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.aOr.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.aOs.aOp;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.aOs.aOp;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.aOs.aOq;
            iXAdProd9 = this.aOs.aOp;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.aOr.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.aOs.aOq;
            iXAdProd7 = this.aOs.aOp;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.aOr.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.aOs.aOp;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.aOs.aOp;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.aOs.aOq;
            iXAdProd5 = this.aOs.aOp;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.aOr.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.aOs.aOp;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.aOs.aOp;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.aOs.aOq;
            iXAdProd2 = this.aOs.aOp;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
