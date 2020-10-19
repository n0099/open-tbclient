package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduNativeH5AdView f2346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f2346a = baiduNativeH5AdView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new i(this, iOAdEvent));
    }
}
