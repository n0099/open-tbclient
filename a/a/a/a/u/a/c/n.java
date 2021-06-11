package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends a.a.a.a.c<UnifiedBannerView> {
    public final HashMap<UnifiedBannerView, String> n;

    /* loaded from: classes.dex */
    public class a implements UnifiedBannerADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1213a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1214b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedBannerView[] f1215c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1216d;

        public a(UnifiedBannerView[] unifiedBannerViewArr, FunAdSlot funAdSlot) {
            this.f1215c = unifiedBannerViewArr;
            this.f1216d = funAdSlot;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            a.a.a.a.y.d.a();
            n.this.f1014h.a(this.f1214b);
            this.f1214b = true;
            n.this.e();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            a.a.a.a.y.d.a();
            a.a.a.a.y.f.g.c.a(n.this.f1014h.f1406a, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            a.a.a.a.y.d.b();
            n.this.f1014h.d();
            n.this.f();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            a.a.a.a.y.d.a();
            n.this.f1014h.b(this.f1213a);
            this.f1213a = true;
            UnifiedBannerView unifiedBannerView = this.f1215c[0];
            n nVar = n.this;
            nVar.a((n) unifiedBannerView, nVar.n.remove(unifiedBannerView));
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            a.a.a.a.y.d.a();
            n.this.f1014h.a();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            a.a.a.a.y.d.b();
            a.a.a.a.y.f.g.c.a(n.this.f1014h.f1406a, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            a.a.a.a.y.d.a();
            n.this.f1014h.b();
            UnifiedBannerView unifiedBannerView = this.f1215c[0];
            n.this.n.put(unifiedBannerView, this.f1216d.getSid());
            n nVar = n.this;
            nVar.a((n) unifiedBannerView);
            nVar.h();
            n.this.l.b(unifiedBannerView, this.f1216d.getSid());
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            n.this.f1014h.a(Integer.valueOf(adError.getErrorCode()));
            n.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public n(e.a aVar) {
        super(aVar, false);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.k(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.f1014h.g();
        if (unifiedBannerView2.getParent() != null) {
            ((ViewGroup) unifiedBannerView2.getParent()).removeView(unifiedBannerView2);
        }
        this.n.put(unifiedBannerView2, str);
        viewGroup.removeAllViews();
        int width = viewGroup.getWidth();
        viewGroup.addView(unifiedBannerView2, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        this.f1014h.a(funAdSlot, this.f1015i);
        if (!(context instanceof Activity)) {
            this.f1014h.a("NoA");
            b(0, "Not Activity");
            return;
        }
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.f1015i.f1342c, new a(r0, funAdSlot));
        unifiedBannerView.setRefresh(0);
        unifiedBannerView.loadAD();
        UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.n.remove(unifiedBannerView2);
        if (unifiedBannerView2 != null) {
            unifiedBannerView2.destroy();
        }
    }
}
