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
    private AdSize bxF;
    private com.baidu.mobads.production.f.a bxG;
    private InterstitialAdListener bxH;
    IOAdEventListener bxp;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.bxH = new m(this);
        this.bxp = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bxF = adSize;
        if (a()) {
            this.bxG = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.bxG = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.bxG.addEventListener(IXAdEvent.AD_LOADED, this.bxp);
        this.bxG.addEventListener(IXAdEvent.AD_ERROR, this.bxp);
        this.bxG.addEventListener(IXAdEvent.AD_STOPPED, this.bxp);
        this.bxG.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bxp);
        this.bxG.addEventListener(IXAdEvent.AD_STARTED, this.bxp);
        this.bxG.addEventListener("AdUserClick", this.bxp);
        this.bxG.request();
    }

    private boolean a() {
        return this.bxF.getValue() <= AdSize.InterstitialOther.getValue() && this.bxF.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bxF.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bxF.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.bxG.v();
    }

    public void loadAd() {
        this.bxG.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.bxG.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.bxH = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.bxG.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.bxG.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.bxG.a(activity, relativeLayout);
    }
}
