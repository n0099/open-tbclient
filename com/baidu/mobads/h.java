package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class h implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduNativeH5AdView f8312a;

    public h(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f8312a = baiduNativeH5AdView;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new i(this, iOAdEvent));
    }
}
