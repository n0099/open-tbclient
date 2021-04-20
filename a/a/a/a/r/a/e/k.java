package a.a.a.a.r.a.e;

import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes.dex */
public class k implements KsSplashScreenAd.SplashScreenAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1255a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f1257c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1258d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j f1259e;

    public k(j jVar, KsSplashScreenAd ksSplashScreenAd, String str) {
        this.f1259e = jVar;
        this.f1257c = ksSplashScreenAd;
        this.f1258d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1259e.f1010g.a(this.f1256b);
        this.f1256b = true;
        this.f1259e.e();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        a.a.a.a.v.d.a();
        this.f1259e.f1010g.d();
        this.f1259e.f();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i, String str) {
        a.a.a.a.v.d.b("onAdShowError code: " + i + ", message: " + str, new Object[0]);
        this.f1259e.f1010g.b(Integer.valueOf(i));
        this.f1259e.a(i, str);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        a.a.a.a.v.d.a();
        this.f1259e.f1010g.b(this.f1255a);
        this.f1255a = true;
        this.f1259e.a((j) this.f1257c, this.f1258d);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1259e.f1010g.f1377a, "splash_skip", new Object[0]);
        this.f1259e.f();
    }
}
