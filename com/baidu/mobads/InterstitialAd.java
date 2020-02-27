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
    private AdSize aOO;
    private com.baidu.mobads.production.f.a aOP;
    private InterstitialAdListener aOQ;
    IOAdEventListener aOy;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.aOQ = new m(this);
        this.aOy = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.aOO = adSize;
        if (a()) {
            this.aOP = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.aOP = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.aOP.addEventListener(IXAdEvent.AD_LOADED, this.aOy);
        this.aOP.addEventListener(IXAdEvent.AD_ERROR, this.aOy);
        this.aOP.addEventListener(IXAdEvent.AD_STOPPED, this.aOy);
        this.aOP.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOy);
        this.aOP.addEventListener(IXAdEvent.AD_STARTED, this.aOy);
        this.aOP.addEventListener("AdUserClick", this.aOy);
        this.aOP.request();
    }

    private boolean a() {
        return this.aOO.getValue() <= AdSize.InterstitialOther.getValue() && this.aOO.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.aOO.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.aOO.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.aOP.v();
    }

    public void loadAd() {
        this.aOP.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.aOP.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.aOQ = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.aOP.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.aOP.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.aOP.a(activity, relativeLayout);
    }
}
