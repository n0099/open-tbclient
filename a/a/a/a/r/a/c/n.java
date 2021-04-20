package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends a.a.a.a.b<UnifiedBannerView> {
    public final HashMap<UnifiedBannerView, String> m;

    /* loaded from: classes.dex */
    public class a implements UnifiedBannerADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1192a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedBannerView[] f1194c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1195d;

        public a(UnifiedBannerView[] unifiedBannerViewArr, FunAdSlot funAdSlot) {
            this.f1194c = unifiedBannerViewArr;
            this.f1195d = funAdSlot;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            n.this.f1010g.a(this.f1193b);
            this.f1193b = true;
            n.this.e();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            a.a.a.a.v.d.a();
            a.a.a.a.v.f.g.c.a(n.this.f1010g.f1377a, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            a.a.a.a.v.d.b();
            n.this.f1010g.d();
            n.this.f();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            a.a.a.a.v.d.a();
            n.this.f1010g.b(this.f1192a);
            this.f1192a = true;
            UnifiedBannerView unifiedBannerView = this.f1194c[0];
            n nVar = n.this;
            nVar.a((n) unifiedBannerView, nVar.m.remove(unifiedBannerView));
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            a.a.a.a.v.d.a();
            n.this.f1010g.a();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            a.a.a.a.v.d.b();
            a.a.a.a.v.f.g.c.a(n.this.f1010g.f1377a, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            a.a.a.a.v.d.a();
            n.this.f1010g.b();
            UnifiedBannerView unifiedBannerView = this.f1194c[0];
            n.this.m.put(unifiedBannerView, this.f1195d.getSid());
            n nVar = n.this;
            nVar.a((n) unifiedBannerView);
            nVar.h();
            n.this.k.b(unifiedBannerView, this.f1195d.getSid());
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            n.this.f1010g.a(Integer.valueOf(adError.getErrorCode()));
            n.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public n(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.j(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.f1010g.g();
        if (unifiedBannerView2.getParent() != null) {
            ((ViewGroup) unifiedBannerView2.getParent()).removeView(unifiedBannerView2);
        }
        this.m.put(unifiedBannerView2, str);
        viewGroup.removeAllViews();
        int width = viewGroup.getWidth();
        viewGroup.addView(unifiedBannerView2, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "Not Activity");
            return;
        }
        this.f1010g.a(funAdSlot, this.f1011h);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.f1011h.f1320c, new a(r0, funAdSlot));
        unifiedBannerView.setRefresh(0);
        unifiedBannerView.loadAD();
        UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.m.remove(unifiedBannerView2);
        if (unifiedBannerView2 != null) {
            unifiedBannerView2.destroy();
        }
    }
}
