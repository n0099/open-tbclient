package a.a.a.a.u.a.d;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes.dex */
public class a extends a.a.a.a.c<PBInterstitial> {

    /* renamed from: a.a.a.a.u.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a implements PBInterstitialListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1223a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1224b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBInterstitial f1225c;

        public C0001a(PBInterstitial pBInterstitial) {
            this.f1225c = pBInterstitial;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            a.a.a.a.y.d.a();
            a.this.f1014h.a(this.f1224b);
            this.f1224b = true;
            a.this.e();
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            a.a.a.a.y.d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            a.this.f1014h.a(Integer.valueOf(pBError.getCode()));
            a.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            a.a.a.a.y.d.a();
            a.this.f1014h.d();
            a.this.f();
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            a.a.a.a.y.d.a();
            a.this.f1014h.b(this.f1223a);
            this.f1223a = true;
            a.this.a((a) null, (String) null);
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            a.a.a.a.y.d.a();
            a.this.f1014h.b((Object) 0);
            a.this.a(0, str);
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            a.a.a.a.y.d.a();
            a.this.f1014h.b();
            a aVar = a.this;
            aVar.a((a) this.f1225c);
            aVar.h();
        }
    }

    public a(e.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBInterstitial pBInterstitial) {
        PBInterstitial pBInterstitial2 = pBInterstitial;
        this.f1014h.g();
        if (pBInterstitial2.isReady()) {
            pBInterstitial2.show();
            return true;
        }
        a.a.a.a.y.d.b("Ad isn't ready now", new Object[0]);
        return false;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.f1015i.f1342c);
        pBInterstitial.setInterstitialListener(new C0001a(pBInterstitial));
        this.f1014h.a(funAdSlot, this.f1015i);
        pBInterstitial.load();
        g();
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
