package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes10.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent aOs;
    final /* synthetic */ a.C0129a aOt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0129a c0129a, IOAdEvent iOAdEvent) {
        this.aOt = c0129a;
        this.aOs = iOAdEvent;
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
        if (this.aOs.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.aOt.aOr;
            iXAdProd11 = this.aOt.aOq;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.aOs.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.aOt.aOq;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.aOt.aOq;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.aOt.aOr;
            iXAdProd9 = this.aOt.aOq;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.aOs.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.aOt.aOr;
            iXAdProd7 = this.aOt.aOq;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.aOs.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.aOt.aOq;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.aOt.aOq;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.aOt.aOr;
            iXAdProd5 = this.aOt.aOq;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.aOs.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.aOt.aOq;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.aOt.aOq;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.aOt.aOr;
            iXAdProd2 = this.aOt.aOq;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
