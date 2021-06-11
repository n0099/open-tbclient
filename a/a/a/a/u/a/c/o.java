package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
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
/* loaded from: classes.dex */
public class o extends a.a.a.a.c<UnifiedInterstitialAD> {
    public final HashMap<UnifiedInterstitialAD, String> n;

    /* loaded from: classes.dex */
    public class a implements UnifiedInterstitialADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1218a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1219b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedInterstitialAD[] f1220c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1221d;

        public a(UnifiedInterstitialAD[] unifiedInterstitialADArr, FunAdSlot funAdSlot) {
            this.f1220c = unifiedInterstitialADArr;
            this.f1221d = funAdSlot;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            a.a.a.a.y.d.a();
            o.this.f1014h.a(this.f1219b);
            this.f1219b = true;
            o.this.e();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            a.a.a.a.y.d.a();
            o.this.f1014h.d();
            o.this.f();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            a.a.a.a.y.d.a();
            o.this.f1014h.b(this.f1218a);
            UnifiedInterstitialAD unifiedInterstitialAD = this.f1220c[0];
            this.f1218a = true;
            o oVar = o.this;
            oVar.a((o) unifiedInterstitialAD, oVar.n.remove(unifiedInterstitialAD));
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            a.a.a.a.y.d.a();
            o.this.f1014h.a();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            a.a.a.a.y.d.a();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            a.a.a.a.y.d.a();
            o.this.f1014h.b();
            UnifiedInterstitialAD unifiedInterstitialAD = this.f1220c[0];
            o.this.n.put(unifiedInterstitialAD, this.f1221d.getSid());
            o oVar = o.this;
            oVar.a((o) unifiedInterstitialAD);
            oVar.h();
            o.this.l.b(unifiedInterstitialAD, this.f1221d.getSid());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.y.d.b("onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            o.this.f1014h.a(Integer.valueOf(adError.getErrorCode()));
            o.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            a.a.a.a.y.d.a();
            o.this.f1014h.c();
        }
    }

    public o(e.a aVar) {
        super(aVar, false);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.l(aVar);
    }

    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.show(activity);
    }

    public void a(UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.loadAD();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        UnifiedInterstitialAD unifiedInterstitialAD2 = unifiedInterstitialAD;
        this.f1014h.g();
        this.n.put(unifiedInterstitialAD2, str);
        a(activity, unifiedInterstitialAD2);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        this.f1014h.a(funAdSlot, this.f1015i);
        if (!(context instanceof Activity)) {
            this.f1014h.a("NoA");
            b(0, "NotActivity");
            return;
        }
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f1015i.f1342c, new a(r2, funAdSlot));
        UnifiedInterstitialAD[] unifiedInterstitialADArr = {unifiedInterstitialAD};
        unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(false).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
        unifiedInterstitialAD.setMinVideoDuration(0);
        unifiedInterstitialAD.setMaxVideoDuration(0);
        unifiedInterstitialAD.setVideoPlayPolicy(1);
        a(unifiedInterstitialAD);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(UnifiedInterstitialAD unifiedInterstitialAD) {
        UnifiedInterstitialAD unifiedInterstitialAD2 = unifiedInterstitialAD;
        this.n.remove(unifiedInterstitialAD2);
        if (unifiedInterstitialAD2 != null) {
            try {
                unifiedInterstitialAD2.destroy();
            } catch (Exception unused) {
            }
        }
    }
}
