package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes4.dex */
public class k implements KsSplashScreenAd.SplashScreenAdInteractionListener {
    public final /* synthetic */ KsSplashScreenAd Bu;
    public final /* synthetic */ j Bv;

    /* renamed from: a  reason: collision with root package name */
    public boolean f999a;
    public boolean b;
    public final /* synthetic */ String d;

    public k(j jVar, KsSplashScreenAd ksSplashScreenAd, String str) {
        this.Bv = jVar;
        this.Bu = ksSplashScreenAd;
        this.d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.Bv.zk.a(this.b);
        this.b = true;
        this.Bv.e();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        a.a.a.a.v.d.a();
        this.Bv.zk.d();
        this.Bv.f();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i, String str) {
        a.a.a.a.v.d.b("onAdShowError code: " + i + ", message: " + str, new Object[0]);
        this.Bv.zk.b(Integer.valueOf(i));
        this.Bv.a(i, str);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        a.a.a.a.v.d.a();
        this.Bv.zk.b(this.f999a);
        this.f999a = true;
        this.Bv.a((j) this.Bu, this.d);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.Bv.zk.BU, "splash_skip", new Object[0]);
        this.Bv.f();
    }
}
