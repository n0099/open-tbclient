package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    IOAdEventListener f3278a;

    /* renamed from: b  reason: collision with root package name */
    private AdSize f3279b;
    private com.baidu.mobads.production.e.a c;
    private final IXAdLogger d;
    private InterstitialAdListener e;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.e = new n(this);
        this.f3278a = new o(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new q(this));
        this.f3279b = adSize;
        if (a()) {
            this.c = new com.baidu.mobads.production.e.b(context, xAdView, true, str);
        } else if (b()) {
            this.c = new com.baidu.mobads.production.d.b(context, xAdView, true, adSize, str);
        }
        this.c.addEventListener(IXAdEvent.AD_LOADED, this.f3278a);
        this.c.addEventListener(IXAdEvent.AD_ERROR, this.f3278a);
        this.c.addEventListener(IXAdEvent.AD_STOPPED, this.f3278a);
        this.c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f3278a);
        this.c.addEventListener(IXAdEvent.AD_STARTED, this.f3278a);
        this.c.addEventListener("AdUserClick", this.f3278a);
        this.c.request();
    }

    private boolean a() {
        return this.f3279b.getValue() <= AdSize.InterstitialOther.getValue() && this.f3279b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.f3279b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.f3279b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
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
