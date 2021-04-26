package a.a.a.a.t.a.e;

import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes.dex */
public class m implements KsSplashScreenAd.SplashScreenAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1276a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f1278c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1279d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1280e;

    public m(l lVar, KsSplashScreenAd ksSplashScreenAd, String str) {
        this.f1280e = lVar;
        this.f1278c = ksSplashScreenAd;
        this.f1279d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.x.d.a();
        this.f1280e.f1013g.a(this.f1277b);
        this.f1277b = true;
        this.f1280e.e();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        a.a.a.a.x.d.a();
        this.f1280e.f1013g.d();
        this.f1280e.f();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i2, String str) {
        a.a.a.a.x.d.b("onAdShowError code: " + i2 + ", message: " + str, new Object[0]);
        this.f1280e.f1013g.b(Integer.valueOf(i2));
        this.f1280e.a(i2, str);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        a.a.a.a.x.d.a();
        this.f1280e.f1013g.b(this.f1276a);
        this.f1276a = true;
        this.f1280e.a((l) this.f1278c, this.f1279d);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        a.a.a.a.x.d.a();
        a.a.a.a.x.f.g.c.a(this.f1280e.f1013g.f1393a, "splash_skip", new Object[0]);
        this.f1280e.f();
    }
}
