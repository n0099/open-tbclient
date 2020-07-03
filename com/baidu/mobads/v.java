package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class v implements IOAdEventListener {
    final /* synthetic */ VideoAdView bxO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VideoAdView videoAdView) {
        this.bxO = videoAdView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new w(this, iOAdEvent));
    }
}
