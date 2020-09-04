package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();
    IOAdEventListener bDa;
    private AdSize bDq;
    private com.baidu.mobads.production.f.a bDr;
    private InterstitialAdListener bDs;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.bDs = new m(this);
        this.bDa = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bDq = adSize;
        if (a()) {
            this.bDr = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.bDr = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.bDr.addEventListener(IXAdEvent.AD_LOADED, this.bDa);
        this.bDr.addEventListener(IXAdEvent.AD_ERROR, this.bDa);
        this.bDr.addEventListener(IXAdEvent.AD_STOPPED, this.bDa);
        this.bDr.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bDa);
        this.bDr.addEventListener(IXAdEvent.AD_STARTED, this.bDa);
        this.bDr.addEventListener("AdUserClick", this.bDa);
        this.bDr.request();
    }

    private boolean a() {
        return this.bDq.getValue() <= AdSize.InterstitialOther.getValue() && this.bDq.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bDq.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bDq.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.bDr.v();
    }

    public void loadAd() {
        this.bDr.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.bDr.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.bDs = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.bDr.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.bDr.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.bDr.a(activity, relativeLayout);
    }
}
