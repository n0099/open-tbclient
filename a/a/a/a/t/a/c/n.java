package a.a.a.a.t.a.c;

import a.a.a.a.u.e;
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
    public final HashMap<UnifiedBannerView, String> m;

    /* loaded from: classes.dex */
    public class a implements UnifiedBannerADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1210a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1211b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedBannerView[] f1212c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1213d;

        public a(UnifiedBannerView[] unifiedBannerViewArr, FunAdSlot funAdSlot) {
            this.f1212c = unifiedBannerViewArr;
            this.f1213d = funAdSlot;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            a.a.a.a.x.d.a();
            n.this.f1013g.a(this.f1211b);
            this.f1211b = true;
            n.this.e();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            a.a.a.a.x.d.a();
            a.a.a.a.x.f.g.c.a(n.this.f1013g.f1393a, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            a.a.a.a.x.d.b();
            n.this.f1013g.d();
            n.this.f();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            a.a.a.a.x.d.a();
            n.this.f1013g.b(this.f1210a);
            this.f1210a = true;
            UnifiedBannerView unifiedBannerView = this.f1212c[0];
            n nVar = n.this;
            nVar.a((n) unifiedBannerView, nVar.m.remove(unifiedBannerView));
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            a.a.a.a.x.d.a();
            n.this.f1013g.a();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            a.a.a.a.x.d.b();
            a.a.a.a.x.f.g.c.a(n.this.f1013g.f1393a, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            a.a.a.a.x.d.a();
            n.this.f1013g.b();
            UnifiedBannerView unifiedBannerView = this.f1212c[0];
            n.this.m.put(unifiedBannerView, this.f1213d.getSid());
            n nVar = n.this;
            nVar.a((n) unifiedBannerView);
            nVar.h();
            n.this.k.b(unifiedBannerView, this.f1213d.getSid());
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            n.this.f1013g.a(Integer.valueOf(adError.getErrorCode()));
            n.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public n(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.k(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedBannerView unifiedBannerView) {
        UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
        this.f1013g.g();
        if (unifiedBannerView2.getParent() != null) {
            ((ViewGroup) unifiedBannerView2.getParent()).removeView(unifiedBannerView2);
        }
        this.m.put(unifiedBannerView2, str);
        viewGroup.removeAllViews();
        int width = viewGroup.getWidth();
        viewGroup.addView(unifiedBannerView2, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        this.f1013g.a(funAdSlot, this.f1014h);
        if (!(context instanceof Activity)) {
            this.f1013g.a("NoA");
            b(0, "Not Activity");
            return;
        }
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.f1014h.f1334c, new a(r0, funAdSlot));
        unifiedBannerView.setRefresh(0);
        unifiedBannerView.loadAD();
        UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
        g();
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
