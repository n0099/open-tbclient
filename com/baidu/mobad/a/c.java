package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes10.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent brY;
    final /* synthetic */ a.C0206a brZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0206a c0206a, IOAdEvent iOAdEvent) {
        this.brZ = c0206a;
        this.brY = iOAdEvent;
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
        if (this.brY.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.brZ.brX;
            iXAdProd11 = this.brZ.brW;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.brY.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.brZ.brW;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.brZ.brW;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.brZ.brX;
            iXAdProd9 = this.brZ.brW;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.brY.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.brZ.brX;
            iXAdProd7 = this.brZ.brW;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.brY.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.brZ.brW;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.brZ.brW;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.brZ.brX;
            iXAdProd5 = this.brZ.brW;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.brY.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.brZ.brW;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.brZ.brW;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.brZ.brX;
            iXAdProd2 = this.brZ.brW;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
