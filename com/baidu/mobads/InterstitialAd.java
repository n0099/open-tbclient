package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();
    IOAdEventListener aJC;
    private AdSize aJS;
    private com.baidu.mobads.production.f.a aJT;
    private InterstitialAdListener aJU;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.aJU = new m(this);
        this.aJC = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.aJS = adSize;
        if (a()) {
            this.aJT = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.aJT = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.aJT.addEventListener(IXAdEvent.AD_LOADED, this.aJC);
        this.aJT.addEventListener(IXAdEvent.AD_ERROR, this.aJC);
        this.aJT.addEventListener(IXAdEvent.AD_STOPPED, this.aJC);
        this.aJT.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aJC);
        this.aJT.addEventListener(IXAdEvent.AD_STARTED, this.aJC);
        this.aJT.addEventListener("AdUserClick", this.aJC);
        this.aJT.request();
    }

    private boolean a() {
        return this.aJS.getValue() <= AdSize.InterstitialOther.getValue() && this.aJS.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.aJS.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.aJS.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.aJT.v();
    }

    public void loadAd() {
        this.aJT.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.aJT.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.aJU = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.aJT.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.aJT.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.aJT.a(activity, relativeLayout);
    }
}
