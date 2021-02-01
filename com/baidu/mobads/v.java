package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class v implements XAdView.Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3516a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ XAdView f3517b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ int e;
    final /* synthetic */ RequestParameters f;
    final /* synthetic */ SplashAd g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SplashAd splashAd, Context context, XAdView xAdView, String str, boolean z, int i, RequestParameters requestParameters) {
        this.g = splashAd;
        this.f3516a = context;
        this.f3517b = xAdView;
        this.c = str;
        this.d = z;
        this.e = i;
        this.f = requestParameters;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.g.f3285a;
        if (aVar != null) {
            aVar2 = this.g.f3285a;
            aVar2.b(i);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.g.f3285a;
        if (aVar != null) {
            aVar2 = this.g.f3285a;
            aVar2.a(z);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        com.baidu.mobads.production.f.a aVar;
        Context context;
        RequestParameters requestParameters;
        int i3;
        int i4;
        SplashAdListener splashAdListener;
        int i5;
        com.baidu.mobads.production.f.a aVar2;
        HashMap<String, String> hashMap;
        com.baidu.mobads.production.f.a aVar3;
        com.baidu.mobads.production.f.a aVar4;
        IOAdEventListener iOAdEventListener;
        com.baidu.mobads.production.f.a aVar5;
        IOAdEventListener iOAdEventListener2;
        com.baidu.mobads.production.f.a aVar6;
        IOAdEventListener iOAdEventListener3;
        com.baidu.mobads.production.f.a aVar7;
        IOAdEventListener iOAdEventListener4;
        com.baidu.mobads.production.f.a aVar8;
        IOAdEventListener iOAdEventListener5;
        com.baidu.mobads.production.f.a aVar9;
        com.baidu.mobads.production.f.a aVar10;
        RequestParameters requestParameters2;
        RequestParameters requestParameters3;
        RequestParameters requestParameters4;
        RequestParameters requestParameters5;
        RequestParameters requestParameters6;
        aVar = this.g.f3285a;
        if (aVar == null) {
            com.baidu.mobads.utils.h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            context = this.g.d;
            float screenDensity = commonUtils.getScreenDensity(context);
            requestParameters = this.g.g;
            if (requestParameters != null) {
                requestParameters2 = this.g.g;
                if (requestParameters2.isCustomSize()) {
                    requestParameters3 = this.g.g;
                    if (requestParameters3.getWidth() > 0) {
                        requestParameters6 = this.g.g;
                        i = (int) (requestParameters6.getWidth() * screenDensity);
                    }
                    requestParameters4 = this.g.g;
                    if (requestParameters4.getHeight() > 0) {
                        requestParameters5 = this.g.g;
                        i3 = (int) (requestParameters5.getHeight() * screenDensity);
                        i4 = i;
                        if (i4 >= 200.0f * screenDensity || i3 < screenDensity * 150.0f) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                            splashAdListener = this.g.j;
                            splashAdListener.onAdDismissed();
                        }
                        SplashAd splashAd = this.g;
                        Context context2 = this.f3516a;
                        XAdView xAdView = this.f3517b;
                        String str = this.c;
                        boolean z = this.d;
                        i5 = this.g.f3286b;
                        splashAd.f3285a = new com.baidu.mobads.production.f.a(context2, xAdView, str, z, i4, i3, i5, this.e);
                        aVar2 = this.g.f3285a;
                        hashMap = this.g.i;
                        aVar2.a(hashMap);
                        aVar3 = this.g.f3285a;
                        aVar3.A = false;
                        if (this.f != null) {
                            aVar10 = this.g.f3285a;
                            aVar10.a(this.f);
                        }
                        aVar4 = this.g.f3285a;
                        iOAdEventListener = this.g.k;
                        aVar4.addEventListener("AdUserClick", iOAdEventListener);
                        aVar5 = this.g.f3285a;
                        iOAdEventListener2 = this.g.k;
                        aVar5.addEventListener(IXAdEvent.AD_LOADED, iOAdEventListener2);
                        aVar6 = this.g.f3285a;
                        iOAdEventListener3 = this.g.k;
                        aVar6.addEventListener(IXAdEvent.AD_STARTED, iOAdEventListener3);
                        aVar7 = this.g.f3285a;
                        iOAdEventListener4 = this.g.k;
                        aVar7.addEventListener(IXAdEvent.AD_STOPPED, iOAdEventListener4);
                        aVar8 = this.g.f3285a;
                        iOAdEventListener5 = this.g.k;
                        aVar8.addEventListener(IXAdEvent.AD_ERROR, iOAdEventListener5);
                        j.a().a(1002);
                        aVar9 = this.g.f3285a;
                        aVar9.request();
                        return;
                    }
                }
            }
            i3 = i2;
            i4 = i;
            if (i4 >= 200.0f * screenDensity) {
            }
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            splashAdListener = this.g.j;
            splashAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.g.f3285a;
        if (aVar != null) {
            aVar2 = this.g.f3285a;
            aVar2.o();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.g.f3285a;
        if (aVar != null) {
            aVar2 = this.g.f3285a;
            aVar2.n();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }
}
