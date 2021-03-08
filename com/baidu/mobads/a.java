package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AdView f2355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdView adView) {
        this.f2355a = adView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener;
        adViewListener = this.f2355a.d;
        if (adViewListener != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new b(this, iOAdEvent));
        }
    }
}
