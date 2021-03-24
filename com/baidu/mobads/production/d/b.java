package com.baidu.mobads.production.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.mobads.production.a implements a {
    public final IXAdLogger A;
    public RelativeLayout B;
    public TextView C;
    public CountDownTimer D;
    public f E;
    public boolean F;
    public boolean G;
    public Activity H;
    public Boolean I;
    public final String z;

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        super(context);
        this.z = "html5_intersitial";
        this.F = false;
        this.G = false;
        this.A = XAdSDKFoundationFacade.getInstance().getAdLogger();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL;
        this.I = bool;
        f fVar = new f(getApplicationContext(), getActivity(), this.o, Boolean.TRUE);
        this.E = fVar;
        fVar.c(IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
        this.E.f(adSize.getValue());
        this.E.d(str);
        d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View x() {
        if (this.B == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f8438f);
            this.B = relativeLayout;
            relativeLayout.setBackgroundColor(Color.argb(42, 0, 0, 0));
            TextView textView = new TextView(this.f8438f);
            this.C = textView;
            textView.setTextColor(-65536);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.B.addView(this.C, layoutParams);
        }
        this.D = new e(this, 6000L, 1000L).start();
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.B.getParent()).removeView(this.B);
        }
        if (this.D != null) {
            this.A.d("cancel countDownTimer before it finished");
            try {
                this.D.cancel();
            } catch (Exception e2) {
                this.A.d(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelativeLayout.LayoutParams z() {
        int screenDensity = (int) (XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.f8438f) * 20.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenDensity, screenDensity);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        return layoutParams;
    }

    @Override // com.baidu.mobads.production.e.a
    public void a() {
    }

    @Override // com.baidu.mobads.production.e.a
    public void a(Activity activity) {
    }

    @Override // com.baidu.mobads.production.a, com.baidu.mobads.production.e.a
    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.E);
    }

    public boolean s() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == this.E.getApt();
    }

    @Override // com.baidu.mobads.production.a, com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        super.start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: t */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.E;
    }

    public void u() {
        Activity activity = this.H;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new d(this));
    }

    @Override // com.baidu.mobads.production.e.a
    public boolean v() {
        return this.F;
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        pVar.a(bVar, "{'ad':[{'id':99999999,'url':'" + this.E.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    public void b() {
        new Handler(Looper.getMainLooper()).post(new c(this));
    }

    @Override // com.baidu.mobads.production.a
    public void d() {
        this.m = 8000;
    }

    @Override // com.baidu.mobads.production.a
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        u();
        this.G = false;
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        b();
    }

    @Override // com.baidu.mobads.production.e.a
    public void a(int i, int i2) {
        if (this.F || this.G) {
            return;
        }
        this.E.d(i);
        this.E.e(i2);
        load();
    }

    @Override // com.baidu.mobads.production.e.a
    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.A.d("showInterstitialAdInit");
            if (this.F && !this.G) {
                this.G = true;
                this.F = false;
                this.H = activity;
                start();
                u();
                this.f8437e.setBackgroundColor(0);
                RelativeLayout relativeLayout2 = new RelativeLayout(activity);
                relativeLayout2.setBackgroundColor(0);
                relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
                this.f8437e.addView(this.f8440h.getAdView(), new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout2.addView(this.f8437e, new RelativeLayout.LayoutParams(-1, -1));
                this.f8440h.getAdView().setVisibility(4);
            } else if (this.G) {
                this.A.w("interstitial ad is showing now");
            } else if (this.F) {
            } else {
                this.A.w("interstitial ad is not ready");
            }
        } catch (Exception e2) {
            this.A.d(e2);
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.F = true;
    }
}
