package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
class g implements IOAdEventListener {
    final /* synthetic */ AdView ahe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AdView adView) {
        this.ahe = adView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        a aVar;
        aVar = this.ahe.agK;
        if (aVar != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new h(this, iOAdEvent));
        }
    }
}
