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
    IOAdEventListener bkF;
    private AdSize bkV;
    private com.baidu.mobads.production.f.a bkW;
    private InterstitialAdListener bkX;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.bkX = new m(this);
        this.bkF = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bkV = adSize;
        if (a()) {
            this.bkW = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.bkW = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.bkW.addEventListener(IXAdEvent.AD_LOADED, this.bkF);
        this.bkW.addEventListener(IXAdEvent.AD_ERROR, this.bkF);
        this.bkW.addEventListener(IXAdEvent.AD_STOPPED, this.bkF);
        this.bkW.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bkF);
        this.bkW.addEventListener(IXAdEvent.AD_STARTED, this.bkF);
        this.bkW.addEventListener("AdUserClick", this.bkF);
        this.bkW.request();
    }

    private boolean a() {
        return this.bkV.getValue() <= AdSize.InterstitialOther.getValue() && this.bkV.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bkV.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bkV.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.bkW.v();
    }

    public void loadAd() {
        this.bkW.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.bkW.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.bkX = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.bkW.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.bkW.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.bkW.a(activity, relativeLayout);
    }
}
