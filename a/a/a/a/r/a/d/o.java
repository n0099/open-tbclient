package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class o extends a.a.a.a.c<UnifiedInterstitialAD> {
    public final HashMap<UnifiedInterstitialAD, String> m;

    /* loaded from: classes4.dex */
    public class a implements UnifiedInterstitialADListener {
        public final /* synthetic */ FunAdSlot AP;
        public final /* synthetic */ UnifiedInterstitialAD[] AW;

        /* renamed from: a  reason: collision with root package name */
        public boolean f989a;
        public boolean b;

        public a(UnifiedInterstitialAD[] unifiedInterstitialADArr, FunAdSlot funAdSlot) {
            this.AW = unifiedInterstitialADArr;
            this.AP = funAdSlot;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            o.this.zk.a(this.b);
            this.b = true;
            o.this.e();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            a.a.a.a.v.d.a();
            o.this.zk.d();
            o.this.f();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            a.a.a.a.v.d.a();
            o.this.zk.b(this.f989a);
            UnifiedInterstitialAD unifiedInterstitialAD = this.AW[0];
            this.f989a = true;
            o oVar = o.this;
            oVar.a((o) unifiedInterstitialAD, oVar.m.remove(unifiedInterstitialAD));
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            a.a.a.a.v.d.a();
            o.this.zk.a();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            a.a.a.a.v.d.a();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            a.a.a.a.v.d.a();
            o.this.zk.b();
            UnifiedInterstitialAD unifiedInterstitialAD = this.AW[0];
            o.this.m.put(unifiedInterstitialAD, this.AP.getSid());
            o oVar = o.this;
            oVar.a((o) unifiedInterstitialAD);
            oVar.h();
            o.this.zm.b(unifiedInterstitialAD, this.AP.getSid());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            o.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            o.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            a.a.a.a.v.d.a();
            o.this.zk.c();
        }
    }

    public o(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.l(aVar);
    }

    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.show(activity);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "NotActivity");
            return;
        }
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.zl.c, new a(r0, funAdSlot));
        UnifiedInterstitialAD[] unifiedInterstitialADArr = {unifiedInterstitialAD};
        unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(false).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
        unifiedInterstitialAD.setMinVideoDuration(0);
        unifiedInterstitialAD.setMaxVideoDuration(0);
        unifiedInterstitialAD.setVideoPlayPolicy(1);
        this.zk.a(funAdSlot, this.zl);
        h(unifiedInterstitialAD);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        UnifiedInterstitialAD unifiedInterstitialAD2 = unifiedInterstitialAD;
        this.zk.g();
        this.m.put(unifiedInterstitialAD2, str);
        a(activity, unifiedInterstitialAD2);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(UnifiedInterstitialAD unifiedInterstitialAD) {
        UnifiedInterstitialAD unifiedInterstitialAD2 = unifiedInterstitialAD;
        this.m.remove(unifiedInterstitialAD2);
        if (unifiedInterstitialAD2 != null) {
            try {
                unifiedInterstitialAD2.destroy();
            } catch (Exception e) {
            }
        }
    }

    public void h(UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.loadAD();
    }
}
