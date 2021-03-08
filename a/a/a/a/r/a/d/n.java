package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class n extends a.a.a.a.c<UnifiedBannerView> {
    public final HashMap<UnifiedBannerView, String> m;

    /* loaded from: classes4.dex */
    public class a implements UnifiedBannerADListener {
        public final /* synthetic */ FunAdSlot AP;
        public final /* synthetic */ UnifiedBannerView[] AU;

        /* renamed from: a  reason: collision with root package name */
        public boolean f988a;
        public boolean b;

        public a(UnifiedBannerView[] unifiedBannerViewArr, FunAdSlot funAdSlot) {
            this.AU = unifiedBannerViewArr;
            this.AP = funAdSlot;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            n.this.zk.a(this.b);
            this.b = true;
            n.this.e();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            a.a.a.a.v.d.a();
            a.a.a.a.v.f.g.c.a(n.this.zk.BU, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            a.a.a.a.v.d.b();
            n.this.zk.d();
            n.this.f();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            a.a.a.a.v.d.a();
            n.this.zk.b(this.f988a);
            this.f988a = true;
            UnifiedBannerView unifiedBannerView = this.AU[0];
            n nVar = n.this;
            nVar.a((n) unifiedBannerView, nVar.m.remove(unifiedBannerView));
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            a.a.a.a.v.d.a();
            n.this.zk.a();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            a.a.a.a.v.d.b();
            a.a.a.a.v.f.g.c.a(n.this.zk.BU, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            a.a.a.a.v.d.a();
            n.this.zk.b();
            UnifiedBannerView unifiedBannerView = this.AU[0];
            n.this.m.put(unifiedBannerView, this.AP.getSid());
            n nVar = n.this;
            nVar.a((n) unifiedBannerView);
            nVar.h();
            n.this.zm.b(unifiedBannerView, this.AP.getSid());
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            n.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            n.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public n(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.k(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "Not Activity");
            return;
        }
        this.zk.a(funAdSlot, this.zl);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.zl.c, new a(r0, funAdSlot));
        unifiedBannerView.setRefresh(0);
        unifiedBannerView.loadAD();
        UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.zk.g();
        if (unifiedBannerView2.getParent() != null) {
            ((ViewGroup) unifiedBannerView2.getParent()).removeView(unifiedBannerView2);
        }
        this.m.put(unifiedBannerView2, str);
        viewGroup.removeAllViews();
        int width = viewGroup.getWidth();
        viewGroup.addView(unifiedBannerView2, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.m.remove(unifiedBannerView2);
        if (unifiedBannerView2 != null) {
            unifiedBannerView2.destroy();
        }
    }
}
