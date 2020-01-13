package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements IOAdEventListener {
    final /* synthetic */ BaiduNativeH5AdView aKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.aKY = baiduNativeH5AdView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new i(this, iOAdEvent));
    }
}
