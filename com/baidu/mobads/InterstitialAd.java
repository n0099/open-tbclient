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
    IOAdEventListener aOA;
    private AdSize aOQ;
    private com.baidu.mobads.production.f.a aOR;
    private InterstitialAdListener aOS;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.aOS = new m(this);
        this.aOA = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.aOQ = adSize;
        if (a()) {
            this.aOR = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.aOR = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.aOR.addEventListener(IXAdEvent.AD_LOADED, this.aOA);
        this.aOR.addEventListener(IXAdEvent.AD_ERROR, this.aOA);
        this.aOR.addEventListener(IXAdEvent.AD_STOPPED, this.aOA);
        this.aOR.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOA);
        this.aOR.addEventListener(IXAdEvent.AD_STARTED, this.aOA);
        this.aOR.addEventListener("AdUserClick", this.aOA);
        this.aOR.request();
    }

    private boolean a() {
        return this.aOQ.getValue() <= AdSize.InterstitialOther.getValue() && this.aOQ.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.aOQ.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.aOQ.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.aOR.v();
    }

    public void loadAd() {
        this.aOR.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.aOR.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.aOS = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.aOR.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.aOR.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.aOR.a(activity, relativeLayout);
    }
}
