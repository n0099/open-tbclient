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
    IOAdEventListener aOO;
    private AdSize aPe;
    private com.baidu.mobads.production.f.a aPf;
    private InterstitialAdListener aPg;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.aPg = new m(this);
        this.aOO = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.aPe = adSize;
        if (a()) {
            this.aPf = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.aPf = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.aPf.addEventListener(IXAdEvent.AD_LOADED, this.aOO);
        this.aPf.addEventListener(IXAdEvent.AD_ERROR, this.aOO);
        this.aPf.addEventListener(IXAdEvent.AD_STOPPED, this.aOO);
        this.aPf.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOO);
        this.aPf.addEventListener(IXAdEvent.AD_STARTED, this.aOO);
        this.aPf.addEventListener("AdUserClick", this.aOO);
        this.aPf.request();
    }

    private boolean a() {
        return this.aPe.getValue() <= AdSize.InterstitialOther.getValue() && this.aPe.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.aPe.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.aPe.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.aPf.v();
    }

    public void loadAd() {
        this.aPf.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.aPf.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.aPg = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.aPf.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.aPf.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.aPf.a(activity, relativeLayout);
    }
}
