package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes10.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ a.C0152a bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0152a c0152a, IOAdEvent iOAdEvent) {
        this.bky = c0152a;
        this.bkx = iOAdEvent;
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
        if (this.bkx.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.bky.bkw;
            iXAdProd11 = this.bky.bkv;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.bkx.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.bky.bkv;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.bky.bkv;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.bky.bkw;
            iXAdProd9 = this.bky.bkv;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.bkx.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.bky.bkw;
            iXAdProd7 = this.bky.bkv;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.bkx.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.bky.bkv;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.bky.bkv;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.bky.bkw;
            iXAdProd5 = this.bky.bkv;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.bkx.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.bky.bkv;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.bky.bkv;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.bky.bkw;
            iXAdProd2 = this.bky.bkv;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
