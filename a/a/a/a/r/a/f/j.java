package a.a.a.a.r.a.f;

import a.a.a.a.a.e;
import a.a.a.a.c.o;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes4.dex */
public class j extends a.a.a.a.c<KsSplashScreenAd> {

    /* loaded from: classes4.dex */
    public class a implements KsLoadManager.SplashScreenAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("KSSplashAd onError code: " + i + ", message: " + str, new Object[0]);
            j.this.zk.a(Integer.valueOf(i));
            j.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            a.a.a.a.v.d.b("KSSplashAd onSplashScreenAdLoad", new Object[0]);
            j.this.zk.b();
            j jVar = j.this;
            jVar.a((j) ksSplashScreenAd);
            jVar.h();
            j.this.zm.b(ksSplashScreenAd, this.zR.getSid());
        }
    }

    public j(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new o(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.zl.c)).build();
        this.zk.a(funAdSlot, this.zl);
        KsAdSDK.getLoadManager().loadSplashScreenAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsSplashScreenAd ksSplashScreenAd) {
        KsSplashScreenAd ksSplashScreenAd2 = ksSplashScreenAd;
        View view = ksSplashScreenAd2.getView(activity, new k(this, ksSplashScreenAd2, str));
        this.zk.g();
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsSplashScreenAd ksSplashScreenAd) {
    }
}
