package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class t implements XAdView.Listener {
    final /* synthetic */ Context a;
    final /* synthetic */ XAdView bsS;
    final /* synthetic */ SplashAd bsT;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SplashAd splashAd, Context context, XAdView xAdView, String str, boolean z) {
        this.bsT = splashAd;
        this.a = context;
        this.bsS = xAdView;
        this.c = str;
        this.d = z;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.g.a aVar;
        com.baidu.mobads.production.g.a aVar2;
        aVar = this.bsT.a;
        if (aVar != null) {
            aVar2 = this.bsT.a;
            aVar2.a(i);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.g.a aVar;
        com.baidu.mobads.production.g.a aVar2;
        aVar = this.bsT.a;
        if (aVar != null) {
            aVar2 = this.bsT.a;
            aVar2.a(z);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        com.baidu.mobads.production.g.a aVar;
        SplashAdListener splashAdListener;
        int i3;
        com.baidu.mobads.production.g.a aVar2;
        IOAdEventListener iOAdEventListener;
        com.baidu.mobads.production.g.a aVar3;
        IOAdEventListener iOAdEventListener2;
        com.baidu.mobads.production.g.a aVar4;
        IOAdEventListener iOAdEventListener3;
        com.baidu.mobads.production.g.a aVar5;
        IOAdEventListener iOAdEventListener4;
        com.baidu.mobads.production.g.a aVar6;
        IOAdEventListener iOAdEventListener5;
        com.baidu.mobads.production.g.a aVar7;
        IOAdEventListener iOAdEventListener6;
        com.baidu.mobads.production.g.a aVar8;
        aVar = this.bsT.a;
        if (aVar == null) {
            float screenDensity = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.a);
            if (i < 200.0f * screenDensity || i2 < screenDensity * 150.0f) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                splashAdListener = this.bsT.bsz;
                splashAdListener.onAdDismissed();
                return;
            }
            SplashAd splashAd = this.bsT;
            Context context = this.a;
            XAdView xAdView = this.bsS;
            String str = this.c;
            boolean z = this.d;
            i3 = this.bsT.b;
            splashAd.a = new com.baidu.mobads.production.g.a(context, xAdView, str, z, i, i2, i3);
            aVar2 = this.bsT.a;
            iOAdEventListener = this.bsT.bsA;
            aVar2.addEventListener("AdUserClick", iOAdEventListener);
            aVar3 = this.bsT.a;
            iOAdEventListener2 = this.bsT.bsA;
            aVar3.addEventListener(IXAdEvent.AD_LOADED, iOAdEventListener2);
            aVar4 = this.bsT.a;
            iOAdEventListener3 = this.bsT.bsA;
            aVar4.addEventListener(IXAdEvent.AD_STARTED, iOAdEventListener3);
            aVar5 = this.bsT.a;
            iOAdEventListener4 = this.bsT.bsA;
            aVar5.addEventListener(IXAdEvent.AD_STOPPED, iOAdEventListener4);
            aVar6 = this.bsT.a;
            iOAdEventListener5 = this.bsT.bsA;
            aVar6.addEventListener(IXAdEvent.AD_ERROR, iOAdEventListener5);
            aVar7 = this.bsT.a;
            iOAdEventListener6 = this.bsT.bsA;
            aVar7.addEventListener("AdTypeReady", iOAdEventListener6);
            aVar8 = this.bsT.a;
            aVar8.request();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.g.a aVar;
        com.baidu.mobads.production.g.a aVar2;
        aVar = this.bsT.a;
        if (aVar != null) {
            aVar2 = this.bsT.a;
            aVar2.o();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.g.a aVar;
        com.baidu.mobads.production.g.a aVar2;
        aVar = this.bsT.a;
        if (aVar != null) {
            aVar2 = this.bsT.a;
            aVar2.n();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }
}
