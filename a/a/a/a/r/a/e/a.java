package a.a.a.a.r.a.e;

import a.a.a.a.a.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes4.dex */
public class a extends a.a.a.a.c<PBInterstitial> {

    /* renamed from: a.a.a.a.r.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0002a implements PBInterstitialListener {
        public final /* synthetic */ PBInterstitial AY;

        /* renamed from: a  reason: collision with root package name */
        public boolean f990a;
        public boolean b;

        public C0002a(PBInterstitial pBInterstitial) {
            this.AY = pBInterstitial;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            d.a();
            a.this.zk.a(this.b);
            this.b = true;
            a.this.e();
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            a.this.zk.a(Integer.valueOf(pBError.getCode()));
            a.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            d.a();
            a.this.zk.d();
            a.this.f();
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            d.a();
            a.this.zk.b(this.f990a);
            this.f990a = true;
            a.this.a((a) null, (String) null);
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            d.a();
            a.this.zk.b((Object) 0);
            a.this.a(0, str);
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            d.a();
            a.this.zk.b();
            a aVar = a.this;
            aVar.a((a) this.AY);
            aVar.h();
        }
    }

    public a(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.zl.c);
        pBInterstitial.setInterstitialListener(new C0002a(pBInterstitial));
        this.zk.a(funAdSlot, this.zl);
        pBInterstitial.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        this.zk.g();
        if (pBInterstitial2.isReady()) {
            pBInterstitial2.show();
            return true;
        }
        d.b("Ad isn't ready now", new Object[0]);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        if (pBInterstitial2 != null) {
            pBInterstitial2.destroy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        return pBInterstitial2 != null && pBInterstitial2.isReady();
    }
}
