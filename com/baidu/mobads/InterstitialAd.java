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
    IOAdEventListener bkK;
    private AdSize bla;
    private com.baidu.mobads.production.f.a blb;
    private InterstitialAdListener blc;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.blc = new m(this);
        this.bkK = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bla = adSize;
        if (a()) {
            this.blb = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.blb = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.blb.addEventListener(IXAdEvent.AD_LOADED, this.bkK);
        this.blb.addEventListener(IXAdEvent.AD_ERROR, this.bkK);
        this.blb.addEventListener(IXAdEvent.AD_STOPPED, this.bkK);
        this.blb.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bkK);
        this.blb.addEventListener(IXAdEvent.AD_STARTED, this.bkK);
        this.blb.addEventListener("AdUserClick", this.bkK);
        this.blb.request();
    }

    private boolean a() {
        return this.bla.getValue() <= AdSize.InterstitialOther.getValue() && this.bla.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bla.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bla.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.blb.v();
    }

    public void loadAd() {
        this.blb.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.blb.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.blc = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.blb.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.blb.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.blb.a(activity, relativeLayout);
    }
}
