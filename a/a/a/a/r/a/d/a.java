package a.a.a.a.r.a.d;

import a.a.a.a.s.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes.dex */
public class a extends a.a.a.a.b<PBInterstitial> {

    /* renamed from: a.a.a.a.r.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a implements PBInterstitialListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1202a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1203b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBInterstitial f1204c;

        public C0001a(PBInterstitial pBInterstitial) {
            this.f1204c = pBInterstitial;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            d.a();
            a.this.f1010g.a(this.f1203b);
            this.f1203b = true;
            a.this.e();
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            a.this.f1010g.a(Integer.valueOf(pBError.getCode()));
            a.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            d.a();
            a.this.f1010g.d();
            a.this.f();
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            d.a();
            a.this.f1010g.b(this.f1202a);
            this.f1202a = true;
            a.this.a((a) null, (String) null);
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            d.a();
            a.this.f1010g.b((Object) 0);
            a.this.a(0, str);
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            d.a();
            a.this.f1010g.b();
            a aVar = a.this;
            aVar.a((a) this.f1204c);
            aVar.h();
        }
    }

    public a(e.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        this.f1010g.g();
        if (pBInterstitial2.isReady()) {
            pBInterstitial2.show();
            return true;
        }
        d.b("Ad isn't ready now", new Object[0]);
        return false;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.f1011h.f1320c);
        pBInterstitial.setInterstitialListener(new C0001a(pBInterstitial));
        this.f1010g.a(funAdSlot, this.f1011h);
        pBInterstitial.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        if (pBInterstitial2 != null) {
            pBInterstitial2.destroy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean c(PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        return pBInterstitial2 != null && pBInterstitial2.isReady();
    }
}
