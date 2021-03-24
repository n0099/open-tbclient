package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes.dex */
public class b implements KsDrawAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1226a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsDrawAd f1228c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1229d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1230e;

    public b(a aVar, KsDrawAd ksDrawAd, String str) {
        this.f1230e = aVar;
        this.f1228c = ksDrawAd;
        this.f1229d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1230e.f1010g.a(this.f1227b);
        this.f1227b = true;
        this.f1230e.e();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1230e.f1010g.b(this.f1226a);
        this.f1226a = true;
        this.f1230e.a((a) this.f1228c, this.f1229d);
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        this.f1230e.f1010g.i();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        a.a.a.a.v.d.b();
        this.f1230e.f1010g.j();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        this.f1230e.f1010g.k();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        this.f1230e.f1010g.l();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        this.f1230e.f1010g.n();
    }
}
