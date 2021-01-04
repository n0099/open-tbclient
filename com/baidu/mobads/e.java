package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
class e implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduHybridAdManager f3354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaiduHybridAdManager baiduHybridAdManager) {
        this.f3354a = baiduHybridAdManager;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new f(this, iOAdEvent));
    }
}
