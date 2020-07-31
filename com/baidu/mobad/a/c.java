package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes20.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent bxh;
    final /* synthetic */ a.C0213a bxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0213a c0213a, IOAdEvent iOAdEvent) {
        this.bxi = c0213a;
        this.bxh = iOAdEvent;
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
        if (this.bxh.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.bxi.bxg;
            iXAdProd11 = this.bxi.bxf;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.bxh.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.bxi.bxf;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.bxi.bxf;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.bxi.bxg;
            iXAdProd9 = this.bxi.bxf;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.bxh.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.bxi.bxg;
            iXAdProd7 = this.bxi.bxf;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.bxh.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.bxi.bxf;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.bxi.bxf;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.bxi.bxg;
            iXAdProd5 = this.bxi.bxf;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.bxh.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.bxi.bxf;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.bxi.bxf;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.bxi.bxg;
            iXAdProd2 = this.bxi.bxf;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
