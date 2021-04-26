package a.a.a.a.t.a.c;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m extends a.a.a.a.c<SplashAD> {
    public final HashMap<SplashAD, String> m;

    /* loaded from: classes.dex */
    public class a implements SplashADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1205a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f1207c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1208d;

        public a(SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            this.f1207c = splashADArr;
            this.f1208d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            a.a.a.a.x.d.a();
            m.this.f1013g.a(this.f1206b);
            this.f1206b = true;
            m.this.e();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            a.a.a.a.x.d.a();
            m.this.f1013g.d();
            m.this.f();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            a.a.a.a.x.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            a.a.a.a.x.d.a();
            m.this.f1013g.b();
            SplashAD splashAD = this.f1207c[0];
            m.this.m.put(splashAD, this.f1208d.getSid());
            m mVar = m.this;
            mVar.a((m) splashAD);
            mVar.h();
            m.this.k.b(splashAD, this.f1208d.getSid());
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            a.a.a.a.x.d.a();
            m.this.f1013g.b(this.f1205a);
            this.f1205a = true;
            SplashAD splashAD = this.f1207c[0];
            m mVar = m.this;
            mVar.a((m) splashAD, mVar.m.remove(splashAD));
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            a.a.a.a.x.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.x.d.b("onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            m.this.f1013g.a(Integer.valueOf(adError.getErrorCode()));
            m.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public m(e.a aVar) {
        super(aVar);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.j(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        SplashAD splashAD2 = splashAD;
        this.f1013g.g();
        this.m.put(splashAD2, str);
        splashAD2.showAd(viewGroup);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(r0, funAdSlot);
        this.f1013g.a(funAdSlot, this.f1014h);
        SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.f1014h.f1334c, aVar, 0);
        SplashAD[] splashADArr = {splashAD};
        splashAD.fetchAdOnly();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(SplashAD splashAD) {
        this.m.remove(splashAD);
    }
}
