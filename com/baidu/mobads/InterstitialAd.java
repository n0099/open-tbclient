package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();
    private AdSize aOP;
    private com.baidu.mobads.production.f.a aOQ;
    private InterstitialAdListener aOR;
    IOAdEventListener aOz;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.aOR = new m(this);
        this.aOz = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.aOP = adSize;
        if (a()) {
            this.aOQ = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.aOQ = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.aOQ.addEventListener(IXAdEvent.AD_LOADED, this.aOz);
        this.aOQ.addEventListener(IXAdEvent.AD_ERROR, this.aOz);
        this.aOQ.addEventListener(IXAdEvent.AD_STOPPED, this.aOz);
        this.aOQ.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOz);
        this.aOQ.addEventListener(IXAdEvent.AD_STARTED, this.aOz);
        this.aOQ.addEventListener("AdUserClick", this.aOz);
        this.aOQ.request();
    }

    private boolean a() {
        return this.aOP.getValue() <= AdSize.InterstitialOther.getValue() && this.aOP.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.aOP.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.aOP.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.aOQ.v();
    }

    public void loadAd() {
        this.aOQ.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.aOQ.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.aOR = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.aOQ.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.aOQ.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.aOQ.a(activity, relativeLayout);
    }
}
