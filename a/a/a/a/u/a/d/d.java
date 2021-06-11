package a.a.a.a.u.a.d;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBSplash;
import com.win.opensdk.PBSplashListener;
/* loaded from: classes.dex */
public class d extends a.a.a.a.c<PBSplash> {

    /* loaded from: classes.dex */
    public class a implements PBSplashListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1238a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1239b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBSplash f1240c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1241d;

        public a(PBSplash pBSplash, FunAdSlot funAdSlot) {
            this.f1240c = pBSplash;
            this.f1241d = funAdSlot;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            a.a.a.a.y.d.a();
            d.this.f1014h.a(this.f1239b);
            this.f1239b = true;
            d.this.e();
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayError(PBError pBError) {
            a.a.a.a.y.d.a();
            d.this.f1014h.b(Integer.valueOf(pBError.getCode()));
            d.this.a(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onDisplayed() {
            a.a.a.a.y.d.a();
            d.this.f1014h.b(this.f1238a);
            this.f1238a = true;
            d.this.a((d) this.f1240c, this.f1241d.getSid());
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            a.a.a.a.y.d.b("JySplashAd onError code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            d.this.f1014h.a(Integer.valueOf(pBError.getCode()));
            d.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            a.a.a.a.y.d.a();
            d.this.f1014h.b();
            d dVar = d.this;
            dVar.a((d) this.f1240c);
            dVar.h();
            d.this.l.b(this.f1240c, this.f1241d.getSid());
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onSkip() {
            a.a.a.a.y.d.a();
            d.this.f1014h.h();
            d.this.f();
        }

        @Override // com.win.opensdk.PBSplashListener
        public void onTimeOver() {
            a.a.a.a.y.d.a();
            a.a.a.a.y.f.g.c.a(d.this.f1014h.f1406a, "splash_timeover", new Object[0]);
            d.this.f();
        }
    }

    public d(e.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBSplash pBSplash) {
        this.f1014h.g();
        pBSplash.show(viewGroup);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        this.f1014h.a(funAdSlot, this.f1015i);
        PBSplash pBSplash = new PBSplash(context.getApplicationContext(), this.f1015i.f1342c);
        pBSplash.setLoadTimeOut(5000L);
        pBSplash.setSplashListener(new a(pBSplash, funAdSlot));
        pBSplash.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBSplash pBSplash) {
        PBSplash pBSplash2 = pBSplash;
        if (pBSplash2 != null) {
            pBSplash2.destroy();
        }
    }
}
