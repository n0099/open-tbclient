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
/* loaded from: classes2.dex */
public class v implements XAdView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8584a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ XAdView f8585b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8586c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f8587d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f8588e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ RequestParameters f8589f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SplashAd f8590g;

    public v(SplashAd splashAd, Context context, XAdView xAdView, String str, boolean z, int i, RequestParameters requestParameters) {
        this.f8590g = splashAd;
        this.f8584a = context;
        this.f8585b = xAdView;
        this.f8586c = str;
        this.f8587d = z;
        this.f8588e = i;
        this.f8589f = requestParameters;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8590g.f8151a;
        if (aVar != null) {
            aVar2 = this.f8590g.f8151a;
            aVar2.n();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8590g.f8151a;
        if (aVar != null) {
            aVar2 = this.f8590g.f8151a;
            aVar2.o();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        com.baidu.mobads.production.f.a aVar;
        Context context;
        RequestParameters requestParameters;
        SplashAdListener splashAdListener;
        int i3;
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
        aVar = this.f8590g.f8151a;
        if (aVar != null) {
            return;
        }
        com.baidu.mobads.utils.h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        context = this.f8590g.f8155e;
        float screenDensity = commonUtils.getScreenDensity(context);
        requestParameters = this.f8590g.f8158h;
        if (requestParameters != null) {
            requestParameters2 = this.f8590g.f8158h;
            if (requestParameters2.isCustomSize()) {
                requestParameters3 = this.f8590g.f8158h;
                if (requestParameters3.getWidth() > 0) {
                    requestParameters6 = this.f8590g.f8158h;
                    i = (int) (requestParameters6.getWidth() * screenDensity);
                }
                requestParameters4 = this.f8590g.f8158h;
                if (requestParameters4.getHeight() > 0) {
                    requestParameters5 = this.f8590g.f8158h;
                    i2 = (int) (requestParameters5.getHeight() * screenDensity);
                }
            }
        }
        int i4 = i;
        int i5 = i2;
        if (i4 >= 200.0f * screenDensity && i5 >= screenDensity * 150.0f) {
            SplashAd splashAd = this.f8590g;
            Context context2 = this.f8584a;
            XAdView xAdView = this.f8585b;
            String str = this.f8586c;
            boolean z = this.f8587d;
            i3 = this.f8590g.f8152b;
            splashAd.f8151a = new com.baidu.mobads.production.f.a(context2, xAdView, str, z, i4, i5, i3, this.f8588e);
            aVar2 = this.f8590g.f8151a;
            hashMap = this.f8590g.j;
            aVar2.a(hashMap);
            aVar3 = this.f8590g.f8151a;
            aVar3.A = false;
            if (this.f8589f != null) {
                aVar10 = this.f8590g.f8151a;
                aVar10.a(this.f8589f);
            }
            aVar4 = this.f8590g.f8151a;
            iOAdEventListener = this.f8590g.l;
            aVar4.addEventListener("AdUserClick", iOAdEventListener);
            aVar5 = this.f8590g.f8151a;
            iOAdEventListener2 = this.f8590g.l;
            aVar5.addEventListener(IXAdEvent.AD_LOADED, iOAdEventListener2);
            aVar6 = this.f8590g.f8151a;
            iOAdEventListener3 = this.f8590g.l;
            aVar6.addEventListener(IXAdEvent.AD_STARTED, iOAdEventListener3);
            aVar7 = this.f8590g.f8151a;
            iOAdEventListener4 = this.f8590g.l;
            aVar7.addEventListener(IXAdEvent.AD_STOPPED, iOAdEventListener4);
            aVar8 = this.f8590g.f8151a;
            iOAdEventListener5 = this.f8590g.l;
            aVar8.addEventListener(IXAdEvent.AD_ERROR, iOAdEventListener5);
            j.a().a(1002);
            aVar9 = this.f8590g.f8151a;
            aVar9.request();
            return;
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        splashAdListener = this.f8590g.k;
        splashAdListener.onAdDismissed();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8590g.f8151a;
        if (aVar != null) {
            aVar2 = this.f8590g.f8151a;
            aVar2.a(z);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8590g.f8151a;
        if (aVar != null) {
            aVar2 = this.f8590g.f8151a;
            aVar2.b(i);
        }
    }
}
