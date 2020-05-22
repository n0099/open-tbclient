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
    IOAdEventListener bsg;
    private AdSize bsw;
    private com.baidu.mobads.production.f.a bsx;
    private InterstitialAdListener bsy;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.bsy = new m(this);
        this.bsg = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bsw = adSize;
        if (a()) {
            this.bsx = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.bsx = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.bsx.addEventListener(IXAdEvent.AD_LOADED, this.bsg);
        this.bsx.addEventListener(IXAdEvent.AD_ERROR, this.bsg);
        this.bsx.addEventListener(IXAdEvent.AD_STOPPED, this.bsg);
        this.bsx.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bsg);
        this.bsx.addEventListener(IXAdEvent.AD_STARTED, this.bsg);
        this.bsx.addEventListener("AdUserClick", this.bsg);
        this.bsx.request();
    }

    private boolean a() {
        return this.bsw.getValue() <= AdSize.InterstitialOther.getValue() && this.bsw.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bsw.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bsw.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.bsx.v();
    }

    public void loadAd() {
        this.bsx.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.bsx.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.bsy = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.bsx.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.bsx.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.bsx.a(activity, relativeLayout);
    }
}
