package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
class m implements IOAdEventListener {
    final /* synthetic */ VideoAdView aAq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(VideoAdView videoAdView) {
        this.aAq = videoAdView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new n(this, iOAdEvent));
    }
}
