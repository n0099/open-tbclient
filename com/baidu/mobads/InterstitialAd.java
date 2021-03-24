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
    public IOAdEventListener f8136a;

    /* renamed from: b  reason: collision with root package name */
    public AdSize f8137b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mobads.production.e.a f8138c;

    /* renamed from: d  reason: collision with root package name */
    public final IXAdLogger f8139d;

    /* renamed from: e  reason: collision with root package name */
    public InterstitialAdListener f8140e;

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
        this.f8138c.p();
    }

    public boolean isAdReady() {
        return this.f8138c.v();
    }

    public void loadAd() {
        this.f8138c.a();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.f8138c.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener != null) {
            this.f8140e = interstitialAdListener;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void showAd(Activity activity) {
        this.f8138c.a(activity);
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null && relativeLayout != null) {
            this.f8138c.a(activity, relativeLayout);
            return;
        }
        throw new IllegalArgumentException();
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.f8139d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.f8140e = new n(this);
        this.f8136a = new o(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new q(this));
        this.f8137b = adSize;
        if (a()) {
            this.f8138c = new com.baidu.mobads.production.e.b(context, xAdView, Boolean.TRUE, str);
        } else if (b()) {
            this.f8138c = new com.baidu.mobads.production.d.b(context, xAdView, Boolean.TRUE, adSize, str);
        }
        this.f8138c.addEventListener(IXAdEvent.AD_LOADED, this.f8136a);
        this.f8138c.addEventListener(IXAdEvent.AD_ERROR, this.f8136a);
        this.f8138c.addEventListener(IXAdEvent.AD_STOPPED, this.f8136a);
        this.f8138c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f8136a);
        this.f8138c.addEventListener(IXAdEvent.AD_STARTED, this.f8136a);
        this.f8138c.addEventListener("AdUserClick", this.f8136a);
        this.f8138c.request();
    }

    private boolean a() {
        return this.f8137b.getValue() <= AdSize.InterstitialOther.getValue() && this.f8137b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.f8137b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.f8137b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }
}
