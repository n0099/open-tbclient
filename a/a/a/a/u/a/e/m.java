package a.a.a.a.u.a.e;

import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes.dex */
public class m implements KsSplashScreenAd.SplashScreenAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1284a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1285b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f1286c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1287d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1288e;

    public m(l lVar, KsSplashScreenAd ksSplashScreenAd, String str) {
        this.f1288e = lVar;
        this.f1286c = ksSplashScreenAd;
        this.f1287d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.y.d.a();
        this.f1288e.f1014h.a(this.f1285b);
        this.f1285b = true;
        this.f1288e.e();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        a.a.a.a.y.d.a();
        this.f1288e.f1014h.d();
        this.f1288e.f();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i2, String str) {
        a.a.a.a.y.d.b("onAdShowError code: " + i2 + ", message: " + str, new Object[0]);
        this.f1288e.f1014h.b(Integer.valueOf(i2));
        this.f1288e.a(i2, str);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        a.a.a.a.y.d.a();
        this.f1288e.f1014h.b(this.f1284a);
        this.f1284a = true;
        this.f1288e.a((l) this.f1286c, this.f1287d);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        a.a.a.a.y.d.a();
        this.f1288e.f1014h.h();
        this.f1288e.f();
    }
}
