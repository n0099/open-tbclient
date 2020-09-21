package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class v implements IOAdEventListener {
    final /* synthetic */ VideoAdView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VideoAdView videoAdView) {
        this.a = videoAdView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new w(this, iOAdEvent));
    }
}
