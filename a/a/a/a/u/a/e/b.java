package a.a.a.a.u.a.e;

import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes.dex */
public class b implements KsDrawAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1245a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsDrawAd f1247c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1248d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1249e;

    public b(a aVar, KsDrawAd ksDrawAd, String str) {
        this.f1249e = aVar;
        this.f1247c = ksDrawAd;
        this.f1248d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.y.d.a();
        this.f1249e.f1014h.a(this.f1246b);
        this.f1246b = true;
        this.f1249e.e();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.y.d.a();
        this.f1249e.f1014h.b(this.f1245a);
        this.f1245a = true;
        this.f1249e.a((a) this.f1247c, this.f1248d);
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        this.f1249e.f1014h.j();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        a.a.a.a.y.d.b();
        this.f1249e.f1014h.k();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        this.f1249e.f1014h.l();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        this.f1249e.f1014h.m();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        this.f1249e.f1014h.o();
    }
}
