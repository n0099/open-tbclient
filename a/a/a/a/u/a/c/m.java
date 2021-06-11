package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
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
    public final HashMap<SplashAD, String> n;

    /* loaded from: classes.dex */
    public class a implements SplashADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1208a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f1210c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1211d;

        public a(SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            this.f1210c = splashADArr;
            this.f1211d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            a.a.a.a.y.d.a();
            m.this.f1014h.a(this.f1209b);
            this.f1209b = true;
            m.this.e();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            a.a.a.a.y.d.a();
            m.this.f1014h.d();
            m.this.f();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            a.a.a.a.y.d.a();
            m.this.f1014h.b(this.f1208a);
            this.f1208a = true;
            SplashAD splashAD = this.f1210c[0];
            m mVar = m.this;
            mVar.a((m) splashAD, mVar.n.remove(splashAD));
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            a.a.a.a.y.d.a();
            m.this.f1014h.b();
            SplashAD splashAD = this.f1210c[0];
            m.this.n.put(splashAD, this.f1211d.getSid());
            m mVar = m.this;
            mVar.a((m) splashAD);
            mVar.h();
            m.this.l.b(splashAD, this.f1211d.getSid());
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            a.a.a.a.y.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            a.a.a.a.y.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            int errorCode = adError.getErrorCode();
            a.a.a.a.y.d.b("onNoAD code: " + errorCode + ", message: " + adError.getErrorMsg(), new Object[0]);
            if (errorCode == 4005) {
                m.this.f1014h.b(Integer.valueOf(errorCode));
                m.this.a(errorCode, adError.getErrorMsg());
                return;
            }
            m.this.f1014h.a(Integer.valueOf(errorCode));
            m.this.b(errorCode, adError.getErrorMsg());
        }
    }

    public m(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.j(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        SplashAD splashAD2 = splashAD;
        this.f1014h.g();
        this.n.put(splashAD2, str);
        splashAD2.showAd(viewGroup);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(r0, funAdSlot);
        this.f1014h.a(funAdSlot, this.f1015i);
        SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.f1015i.f1342c, aVar, 0);
        SplashAD[] splashADArr = {splashAD};
        splashAD.fetchAdOnly();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(SplashAD splashAD) {
        this.n.remove(splashAD);
    }
}
