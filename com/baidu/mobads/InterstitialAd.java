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
    IOAdEventListener bxa;
    private AdSize bxq;
    private com.baidu.mobads.production.f.a bxr;
    private InterstitialAdListener bxs;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.bxs = new m(this);
        this.bxa = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bxq = adSize;
        if (a()) {
            this.bxr = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.bxr = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.bxr.addEventListener(IXAdEvent.AD_LOADED, this.bxa);
        this.bxr.addEventListener(IXAdEvent.AD_ERROR, this.bxa);
        this.bxr.addEventListener(IXAdEvent.AD_STOPPED, this.bxa);
        this.bxr.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bxa);
        this.bxr.addEventListener(IXAdEvent.AD_STARTED, this.bxa);
        this.bxr.addEventListener("AdUserClick", this.bxa);
        this.bxr.request();
    }

    private boolean a() {
        return this.bxq.getValue() <= AdSize.InterstitialOther.getValue() && this.bxq.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bxq.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bxq.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.bxr.v();
    }

    public void loadAd() {
        this.bxr.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.bxr.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.bxs = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.bxr.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.bxr.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.bxr.a(activity, relativeLayout);
    }
}
