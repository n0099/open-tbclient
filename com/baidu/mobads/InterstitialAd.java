package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes8.dex */
public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();
    private AdSize aKK;
    private com.baidu.mobads.production.f.a aKL;
    private InterstitialAdListener aKM;
    IOAdEventListener aKu;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.aKM = new m(this);
        this.aKu = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.aKK = adSize;
        if (a()) {
            this.aKL = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.aKL = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.aKL.addEventListener(IXAdEvent.AD_LOADED, this.aKu);
        this.aKL.addEventListener(IXAdEvent.AD_ERROR, this.aKu);
        this.aKL.addEventListener(IXAdEvent.AD_STOPPED, this.aKu);
        this.aKL.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aKu);
        this.aKL.addEventListener(IXAdEvent.AD_STARTED, this.aKu);
        this.aKL.addEventListener("AdUserClick", this.aKu);
        this.aKL.request();
    }

    private boolean a() {
        return this.aKK.getValue() <= AdSize.InterstitialOther.getValue() && this.aKK.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.aKK.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.aKK.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.aKL.v();
    }

    public void loadAd() {
        this.aKL.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.aKL.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.aKM = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.aKL.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.aKL.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.aKL.a(activity, relativeLayout);
    }
}
