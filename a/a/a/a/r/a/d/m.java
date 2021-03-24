package a.a.a.a.r.a.d;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m extends a.a.a.a.b<SplashAD> {
    public final HashMap<SplashAD, String> m;

    /* loaded from: classes.dex */
    public class a implements SplashADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1195a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1196b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f1197c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1198d;

        public a(SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            this.f1197c = splashADArr;
            this.f1198d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            m.this.f1010g.a(this.f1196b);
            this.f1196b = true;
            m.this.e();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            a.a.a.a.v.d.a();
            m.this.f1010g.d();
            m.this.f();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            a.a.a.a.v.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            a.a.a.a.v.d.a();
            m.this.f1010g.b();
            SplashAD splashAD = this.f1197c[0];
            m.this.m.put(splashAD, this.f1198d.getSid());
            m mVar = m.this;
            mVar.a((m) splashAD);
            mVar.h();
            m.this.k.b(splashAD, this.f1198d.getSid());
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            a.a.a.a.v.d.a();
            m.this.f1010g.b(this.f1195a);
            this.f1195a = true;
            SplashAD splashAD = this.f1197c[0];
            m mVar = m.this;
            mVar.a((m) splashAD, mVar.m.remove(splashAD));
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            a.a.a.a.v.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            m.this.f1010g.a(Integer.valueOf(adError.getErrorCode()));
            m.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public m(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.j(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        SplashAD splashAD2 = splashAD;
        this.f1010g.g();
        this.m.put(splashAD2, str);
        splashAD2.showAd(viewGroup);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "NotActivity");
            return;
        }
        a aVar = new a(r0, funAdSlot);
        this.f1010g.a(funAdSlot, this.f1011h);
        SplashAD splashAD = new SplashAD((Activity) context, this.f1011h.f1334c, aVar, 0);
        SplashAD[] splashADArr = {splashAD};
        splashAD.fetchAdOnly();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(SplashAD splashAD) {
        this.m.remove(splashAD);
    }
}
