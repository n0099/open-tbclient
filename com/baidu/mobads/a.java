package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a implements IOAdEventListener {
    final /* synthetic */ AdView aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdView adView) {
        this.aKp = adView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener;
        adViewListener = this.aKp.aKw;
        if (adViewListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new b(this, iOAdEvent));
        }
    }
}
