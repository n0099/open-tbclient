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
    IOAdEventListener bCX;
    private AdSize bDn;
    private com.baidu.mobads.production.f.a bDo;
    private InterstitialAdListener bDp;
    private final IXAdLogger d;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.bDp = new m(this);
        this.bCX = new n(this);
        XAdView xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.bDn = adSize;
        if (a()) {
            this.bDo = new com.baidu.mobads.production.f.b(context, xAdView, true, str);
        } else if (b()) {
            this.bDo = new com.baidu.mobads.production.e.b(context, xAdView, true, adSize, str);
        }
        this.bDo.addEventListener(IXAdEvent.AD_LOADED, this.bCX);
        this.bDo.addEventListener(IXAdEvent.AD_ERROR, this.bCX);
        this.bDo.addEventListener(IXAdEvent.AD_STOPPED, this.bCX);
        this.bDo.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bCX);
        this.bDo.addEventListener(IXAdEvent.AD_STARTED, this.bCX);
        this.bDo.addEventListener("AdUserClick", this.bCX);
        this.bDo.request();
    }

    private boolean a() {
        return this.bDn.getValue() <= AdSize.InterstitialOther.getValue() && this.bDn.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.bDn.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.bDn.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.bDo.v();
    }

    public void loadAd() {
        this.bDo.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.bDo.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.bDp = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.bDo.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        this.bDo.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.bDo.a(activity, relativeLayout);
    }
}
