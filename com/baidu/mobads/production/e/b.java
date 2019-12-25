package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.internal.view.SupportMenu;
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
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b extends com.baidu.mobads.production.b implements a {
    private CountDownTimer A;
    private f B;
    private boolean C;
    private boolean D;
    private Activity E;
    private Boolean F;
    public final String w;
    protected final IXAdLogger x;
    private RelativeLayout y;
    private TextView z;

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        super(context);
        this.w = "html5_intersitial";
        this.C = false;
        this.D = false;
        this.x = XAdSDKFoundationFacade.getInstance().getAdLogger();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL;
        this.F = bool;
        this.B = new f(getApplicationContext(), getActivity(), this.o, true);
        this.B.c(IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
        this.B.f(adSize.getValue());
        this.B.d(str);
        e(str);
    }

    @Override // com.baidu.mobads.production.b
    public void g() {
    }

    @Override // com.baidu.mobads.production.b
    protected void h() {
        this.m = 8000;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.B);
    }

    @Override // com.baidu.mobads.production.b
    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        vVar.a(cVar, "{'ad':[{'id':99999999,'url':'" + this.B.b() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        super.start();
    }

    @Override // com.baidu.mobads.production.f.a
    public void q() {
    }

    @Override // com.baidu.mobads.production.f.a
    public void a(int i, int i2) {
        if (!this.C && !this.D) {
            this.B.d(i);
            this.B.e(i2);
            load();
        }
    }

    @Override // com.baidu.mobads.production.f.a
    public void a(Activity activity) {
    }

    @Override // com.baidu.mobads.production.f.a
    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.x.d("showInterstitialAdInit");
            if (this.C && !this.D) {
                this.D = true;
                this.C = false;
                this.E = activity;
                start();
                u();
                this.e.setBackgroundColor(0);
                RelativeLayout relativeLayout2 = new RelativeLayout(activity);
                relativeLayout2.setBackgroundColor(0);
                relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
                this.e.addView(this.h.getAdView(), new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout2.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
                this.h.getAdView().setVisibility(4);
            } else if (this.D) {
                this.x.w("interstitial ad is showing now");
            } else if (!this.C) {
                this.x.w("interstitial ad is not ready");
            }
        } catch (Exception e) {
            this.x.d(e);
        }
    }

    public void r() {
        new Handler(Looper.getMainLooper()).post(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == this.B.getApt();
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.C = true;
    }

    @Override // com.baidu.mobads.production.b
    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        r();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: t */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        if (this.E != null) {
            this.E.runOnUiThread(new d(this));
        }
    }

    @Override // com.baidu.mobads.production.f.a
    public boolean v() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.b
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        u();
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View x() {
        if (this.y == null) {
            this.y = new RelativeLayout(this.f);
            this.y.setBackgroundColor(Color.argb(42, 0, 0, 0));
            this.z = new TextView(this.f);
            this.z.setTextColor(SupportMenu.CATEGORY_MASK);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.y.addView(this.z, layoutParams);
        }
        this.A = new e(this, 6000L, 1000L).start();
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.y != null && this.y.getParent() != null) {
            ((ViewGroup) this.y.getParent()).removeView(this.y);
        }
        if (this.A != null) {
            this.x.d("cancel countDownTimer before it finished");
            try {
                this.A.cancel();
            } catch (Exception e) {
                this.x.d(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelativeLayout.LayoutParams z() {
        int screenDensity = (int) (20.0f * XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenDensity, screenDensity);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        return layoutParams;
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.production.f.a
    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }
}
