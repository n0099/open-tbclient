package a.a.a.a.r.a.e;

import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes.dex */
public class b implements KsDrawAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1218a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1219b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsDrawAd f1220c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1221d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1222e;

    public b(a aVar, KsDrawAd ksDrawAd, String str) {
        this.f1222e = aVar;
        this.f1220c = ksDrawAd;
        this.f1221d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1222e.f1010g.a(this.f1219b);
        this.f1219b = true;
        this.f1222e.e();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1222e.f1010g.b(this.f1218a);
        this.f1218a = true;
        this.f1222e.a((a) this.f1220c, this.f1221d);
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        this.f1222e.f1010g.i();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        a.a.a.a.v.d.b();
        this.f1222e.f1010g.j();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        this.f1222e.f1010g.k();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        this.f1222e.f1010g.l();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        this.f1222e.f1010g.n();
    }
}
