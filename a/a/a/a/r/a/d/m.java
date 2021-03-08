package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class m extends a.a.a.a.c<SplashAD> {
    public final HashMap<SplashAD, String> m;

    /* loaded from: classes4.dex */
    public class a implements SplashADListener {
        public final /* synthetic */ FunAdSlot AP;
        public final /* synthetic */ SplashAD[] AR;

        /* renamed from: a  reason: collision with root package name */
        public boolean f987a;
        public boolean b;

        public a(SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            this.AR = splashADArr;
            this.AP = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            m.this.zk.a(this.b);
            this.b = true;
            m.this.e();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            a.a.a.a.v.d.a();
            m.this.zk.d();
            m.this.f();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            a.a.a.a.v.d.a();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            a.a.a.a.v.d.a();
            m.this.zk.b();
            SplashAD splashAD = this.AR[0];
            m.this.m.put(splashAD, this.AP.getSid());
            m mVar = m.this;
            mVar.a((m) splashAD);
            mVar.h();
            m.this.zm.b(splashAD, this.AP.getSid());
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            a.a.a.a.v.d.a();
            m.this.zk.b(this.f987a);
            this.f987a = true;
            SplashAD splashAD = this.AR[0];
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
            m.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            m.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public m(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.j(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "NotActivity");
            return;
        }
        a aVar = new a(r0, funAdSlot);
        this.zk.a(funAdSlot, this.zl);
        SplashAD splashAD = new SplashAD((Activity) context, this.zl.c, aVar, 0);
        SplashAD[] splashADArr = {splashAD};
        splashAD.fetchAdOnly();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        SplashAD splashAD2 = splashAD;
        this.zk.g();
        this.m.put(splashAD2, str);
        splashAD2.showAd(viewGroup);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(SplashAD splashAD) {
        this.m.remove(splashAD);
    }
}
