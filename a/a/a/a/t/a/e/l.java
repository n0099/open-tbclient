package a.a.a.a.t.a.e;

import a.a.a.a.u.e;
import a.a.a.a.w.o;
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
public class l extends a.a.a.a.c<KsSplashScreenAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.SplashScreenAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1274a;

        public a(FunAdSlot funAdSlot) {
            this.f1274a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("KSSplashAd onError code: " + i2 + ", message: " + str, new Object[0]);
            l.this.f1013g.a(Integer.valueOf(i2));
            l.this.b(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i2) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            a.a.a.a.x.d.b("KSSplashAd onSplashScreenAdLoad", new Object[0]);
            l.this.f1013g.b();
            l lVar = l.this;
            lVar.a((l) ksSplashScreenAd);
            lVar.h();
            l.this.k.b(ksSplashScreenAd, this.f1274a.getSid());
        }
    }

    public l(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new o(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsSplashScreenAd ksSplashScreenAd) {
        KsSplashScreenAd ksSplashScreenAd2 = ksSplashScreenAd;
        View view = ksSplashScreenAd2.getView(activity, new m(this, ksSplashScreenAd2, str));
        this.f1013g.g();
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1014h.f1334c)).build();
        this.f1013g.a(funAdSlot, this.f1014h);
        KsAdSDK.getLoadManager().loadSplashScreenAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsSplashScreenAd ksSplashScreenAd) {
    }
}
