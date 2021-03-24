package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes.dex */
public class k implements KsSplashScreenAd.SplashScreenAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1263a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f1265c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1266d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j f1267e;

    public k(j jVar, KsSplashScreenAd ksSplashScreenAd, String str) {
        this.f1267e = jVar;
        this.f1265c = ksSplashScreenAd;
        this.f1266d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1267e.f1010g.a(this.f1264b);
        this.f1264b = true;
        this.f1267e.e();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        a.a.a.a.v.d.a();
        this.f1267e.f1010g.d();
        this.f1267e.f();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i, String str) {
        a.a.a.a.v.d.b("onAdShowError code: " + i + ", message: " + str, new Object[0]);
        this.f1267e.f1010g.b(Integer.valueOf(i));
        this.f1267e.a(i, str);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        a.a.a.a.v.d.a();
        this.f1267e.f1010g.b(this.f1263a);
        this.f1263a = true;
        this.f1267e.a((j) this.f1265c, this.f1266d);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1267e.f1010g.f1391a, "splash_skip", new Object[0]);
        this.f1267e.f();
    }
}
