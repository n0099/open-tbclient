package a.a.a.a.r.a.f;

import a.a.a.a.s.e;
import a.a.a.a.u.o;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes.dex */
public class j extends a.a.a.a.b<KsSplashScreenAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.SplashScreenAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1261a;

        public a(FunAdSlot funAdSlot) {
            this.f1261a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("KSSplashAd onError code: " + i + ", message: " + str, new Object[0]);
            j.this.f1010g.a(Integer.valueOf(i));
            j.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            a.a.a.a.v.d.b("KSSplashAd onSplashScreenAdLoad", new Object[0]);
            j.this.f1010g.b();
            j jVar = j.this;
            jVar.a((j) ksSplashScreenAd);
            jVar.h();
            j.this.k.b(ksSplashScreenAd, this.f1261a.getSid());
        }
    }

    public j(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new o(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsSplashScreenAd ksSplashScreenAd) {
        KsSplashScreenAd ksSplashScreenAd2 = ksSplashScreenAd;
        View view = ksSplashScreenAd2.getView(activity, new k(this, ksSplashScreenAd2, str));
        this.f1010g.g();
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1011h.f1334c)).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        KsAdSDK.getLoadManager().loadSplashScreenAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(KsSplashScreenAd ksSplashScreenAd) {
    }
}
