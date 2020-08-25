package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class e implements IOAdEventListener {
    final /* synthetic */ BaiduHybridAdManager bDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaiduHybridAdManager baiduHybridAdManager) {
        this.bDy = baiduHybridAdManager;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new f(this, iOAdEvent));
    }
}
