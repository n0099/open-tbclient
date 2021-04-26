package a.a.a.a.t.a.e;

import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes.dex */
public class b implements KsDrawAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1237a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsDrawAd f1239c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1240d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1241e;

    public b(a aVar, KsDrawAd ksDrawAd, String str) {
        this.f1241e = aVar;
        this.f1239c = ksDrawAd;
        this.f1240d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.x.d.a();
        this.f1241e.f1013g.a(this.f1238b);
        this.f1238b = true;
        this.f1241e.e();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.x.d.a();
        this.f1241e.f1013g.b(this.f1237a);
        this.f1237a = true;
        this.f1241e.a((a) this.f1239c, this.f1240d);
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        this.f1241e.f1013g.i();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        a.a.a.a.x.d.b();
        this.f1241e.f1013g.j();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        this.f1241e.f1013g.k();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        this.f1241e.f1013g.l();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        this.f1241e.f1013g.n();
    }
}
