package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class InterstitialAd {
    public static final String TAG = "InterstitialAd";

    /* renamed from: a  reason: collision with root package name */
    public IOAdEventListener f8137a;

    /* renamed from: b  reason: collision with root package name */
    public AdSize f8138b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mobads.production.e.a f8139c;

    /* renamed from: d  reason: collision with root package name */
    public final IXAdLogger f8140d;

    /* renamed from: e  reason: collision with root package name */
    public InterstitialAdListener f8141e;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public void destroy() {
        this.f8139c.p();
    }

    public boolean isAdReady() {
        return this.f8139c.v();
    }

    public void loadAd() {
        this.f8139c.a();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.f8139c.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener != null) {
            this.f8141e = interstitialAdListener;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void showAd(Activity activity) {
        this.f8139c.a(activity);
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null && relativeLayout != null) {
            this.f8139c.a(activity, relativeLayout);
            return;
        }
        throw new IllegalArgumentException();
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.f8140d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.f8141e = new n(this);
        this.f8137a = new o(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new q(this));
        this.f8138b = adSize;
        if (a()) {
            this.f8139c = new com.baidu.mobads.production.e.b(context, xAdView, Boolean.TRUE, str);
        } else if (b()) {
            this.f8139c = new com.baidu.mobads.production.d.b(context, xAdView, Boolean.TRUE, adSize, str);
        }
        this.f8139c.addEventListener(IXAdEvent.AD_LOADED, this.f8137a);
        this.f8139c.addEventListener(IXAdEvent.AD_ERROR, this.f8137a);
        this.f8139c.addEventListener(IXAdEvent.AD_STOPPED, this.f8137a);
        this.f8139c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f8137a);
        this.f8139c.addEventListener(IXAdEvent.AD_STARTED, this.f8137a);
        this.f8139c.addEventListener("AdUserClick", this.f8137a);
        this.f8139c.request();
    }

    private boolean a() {
        return this.f8138b.getValue() <= AdSize.InterstitialOther.getValue() && this.f8138b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.f8138b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.f8138b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }
}
