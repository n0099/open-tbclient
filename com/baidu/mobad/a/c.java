package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes7.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent aJu;
    final /* synthetic */ a.C0119a aJv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0119a c0119a, IOAdEvent iOAdEvent) {
        this.aJv = c0119a;
        this.aJu = iOAdEvent;
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
        if (this.aJu.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.aJv.aJt;
            iXAdProd11 = this.aJv.aJs;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.aJu.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.aJv.aJs;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.aJv.aJs;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.aJv.aJt;
            iXAdProd9 = this.aJv.aJs;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.aJu.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.aJv.aJt;
            iXAdProd7 = this.aJv.aJs;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.aJu.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.aJv.aJs;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.aJv.aJs;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.aJv.aJt;
            iXAdProd5 = this.aJv.aJs;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.aJu.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.aJv.aJs;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.aJv.aJs;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.aJv.aJt;
            iXAdProd2 = this.aJv.aJs;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
