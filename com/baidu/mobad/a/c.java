package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes5.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent agf;
    final /* synthetic */ a.C0062a agg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0062a c0062a, IOAdEvent iOAdEvent) {
        this.agg = c0062a;
        this.agf = iOAdEvent;
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
        if (this.agf.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.agg.agd;
            iXAdProd11 = this.agg.agc;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.agf.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.agg.agc;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.agg.agc;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.agg.agd;
            iXAdProd9 = this.agg.agc;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.agf.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.agg.agd;
            iXAdProd7 = this.agg.agc;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.agf.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.agg.agc;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.agg.agc;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.agg.agd;
            iXAdProd5 = this.agg.agc;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.agf.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.agg.agc;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.agg.agc;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.agg.agd;
            iXAdProd2 = this.agg.agc;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
