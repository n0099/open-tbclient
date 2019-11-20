package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes5.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent azH;
    final /* synthetic */ a.C0103a azI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0103a c0103a, IOAdEvent iOAdEvent) {
        this.azI = c0103a;
        this.azH = iOAdEvent;
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
        if (this.azH.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.azI.azG;
            iXAdProd11 = this.azI.azF;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.azH.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.azI.azF;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.azI.azF;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.azI.azG;
            iXAdProd9 = this.azI.azF;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.azH.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.azI.azG;
            iXAdProd7 = this.azI.azF;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.azH.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.azI.azF;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.azI.azF;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.azI.azG;
            iXAdProd5 = this.azI.azF;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.azH.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.azI.azF;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.azI.azF;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.azI.azG;
            iXAdProd2 = this.azI.azF;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
