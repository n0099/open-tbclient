package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    IOAdEventListener f2350a;
    private AdSize b;
    private com.baidu.mobads.production.e.a c;
    private final IXAdLogger d;
    private InterstitialAdListener e;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.e = new n(this);
        this.f2350a = new o(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new q(this));
        this.b = adSize;
        if (a()) {
            this.c = new com.baidu.mobads.production.e.b(context, xAdView, true, str);
        } else if (b()) {
            this.c = new com.baidu.mobads.production.d.b(context, xAdView, true, adSize, str);
        }
        this.c.addEventListener(IXAdEvent.AD_LOADED, this.f2350a);
        this.c.addEventListener(IXAdEvent.AD_ERROR, this.f2350a);
        this.c.addEventListener(IXAdEvent.AD_STOPPED, this.f2350a);
        this.c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f2350a);
        this.c.addEventListener(IXAdEvent.AD_STARTED, this.f2350a);
        this.c.addEventListener("AdUserClick", this.f2350a);
        this.c.request();
    }

    private boolean a() {
        return this.b.getValue() <= AdSize.InterstitialOther.getValue() && this.b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.c.v();
    }

    public void loadAd() {
        this.c.a();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.c.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.e = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.c.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.c.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.c.a(activity, relativeLayout);
    }
}
