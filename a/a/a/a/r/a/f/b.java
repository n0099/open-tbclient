package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes4.dex */
public class b implements KsDrawAd.AdInteractionListener {
    public final /* synthetic */ KsDrawAd Bf;
    public final /* synthetic */ a Bg;

    /* renamed from: a  reason: collision with root package name */
    public boolean f994a;
    public boolean b;
    public final /* synthetic */ String d;

    public b(a aVar, KsDrawAd ksDrawAd, String str) {
        this.Bg = aVar;
        this.Bf = ksDrawAd;
        this.d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.Bg.zk.a(this.b);
        this.b = true;
        this.Bg.e();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.Bg.zk.b(this.f994a);
        this.f994a = true;
        this.Bg.a((a) this.Bf, this.d);
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        this.Bg.zk.i();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        a.a.a.a.v.d.b();
        this.Bg.zk.j();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        this.Bg.zk.k();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        this.Bg.zk.l();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        this.Bg.zk.n();
    }
}
