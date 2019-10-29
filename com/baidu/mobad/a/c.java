package com.baidu.mobad.a;

import com.baidu.mobad.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
/* loaded from: classes5.dex */
class c implements Runnable {
    final /* synthetic */ IOAdEvent azY;
    final /* synthetic */ a.C0103a azZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0103a c0103a, IOAdEvent iOAdEvent) {
        this.azZ = c0103a;
        this.azY = iOAdEvent;
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
        if (this.azY.getType().equals(com.baidu.mobads.openad.c.b.COMPLETE)) {
            iOAdEventDispatcher5 = this.azZ.azX;
            iXAdProd11 = this.azZ.azW;
            iOAdEventDispatcher5.dispatchEvent(new d(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, iXAdProd11));
        }
        if (this.azY.getType().equals(IXAdEvent.AD_STARTED)) {
            iXAdProd8 = this.azZ.azW;
            if (iXAdProd8.getProdBase() != null) {
                iXAdProd10 = this.azZ.azW;
                iXAdProd10.getProdBase().setVisibility(0);
            }
            iOAdEventDispatcher4 = this.azZ.azX;
            iXAdProd9 = this.azZ.azW;
            iOAdEventDispatcher4.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_STARTED, iXAdProd9));
        }
        if (this.azY.getType().equals("AdUserClick")) {
            iOAdEventDispatcher3 = this.azZ.azX;
            iXAdProd7 = this.azZ.azW;
            iOAdEventDispatcher3.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_CLICKED, iXAdProd7));
        }
        if (this.azY.getType().equals(IXAdEvent.AD_STOPPED)) {
            iXAdProd4 = this.azZ.azW;
            if (iXAdProd4.getProdBase() != null) {
                iXAdProd6 = this.azZ.azW;
                iXAdProd6.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher2 = this.azZ.azX;
            iXAdProd5 = this.azZ.azW;
            iOAdEventDispatcher2.dispatchEvent(new d(IXAdConstants4PDK.EVENT_SLOT_ENDED, iXAdProd5));
        }
        if (this.azY.getType().equals(IXAdEvent.AD_ERROR)) {
            iXAdProd = this.azZ.azW;
            if (iXAdProd.getProdBase() != null) {
                iXAdProd3 = this.azZ.azW;
                iXAdProd3.getProdBase().setVisibility(4);
            }
            iOAdEventDispatcher = this.azZ.azX;
            iXAdProd2 = this.azZ.azW;
            iOAdEventDispatcher.dispatchEvent(new d(IXAdConstants4PDK.EVENT_ERROR, iXAdProd2));
        }
    }
}
