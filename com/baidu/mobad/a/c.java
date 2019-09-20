package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes5.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent agB;
    final /* synthetic */ a.C0071a agC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0071a c0071a, IOAdEvent iOAdEvent) {
        this.agC = c0071a;
        this.agB = iOAdEvent;
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
        if (this.agB.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.agC.agA;
            iXAdProd11 = this.agC.agz;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.agB.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.agC.agz;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.agC.agz;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.agC.agA;
            iXAdProd9 = this.agC.agz;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.agB.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.agC.agA;
            iXAdProd7 = this.agC.agz;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.agB.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.agC.agz;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.agC.agz;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.agC.agA;
            iXAdProd5 = this.agC.agz;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.agB.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.agC.agz;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.agC.agz;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.agC.agA;
            iXAdProd2 = this.agC.agz;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
