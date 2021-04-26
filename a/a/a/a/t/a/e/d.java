package a.a.a.a.t.a.e;

import com.kwad.sdk.api.KsFullScreenVideoAd;
/* loaded from: classes.dex */
public class d implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1244a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFullScreenVideoAd f1246c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1247d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c f1248e;

    public d(c cVar, KsFullScreenVideoAd ksFullScreenVideoAd, String str) {
        this.f1248e = cVar;
        this.f1246c = ksFullScreenVideoAd;
        this.f1247d = str;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.x.d.a();
        this.f1248e.f1013g.a(this.f1245b);
        this.f1245b = true;
        this.f1248e.e();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.x.d.a();
        this.f1248e.f1013g.d();
        this.f1248e.f();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.x.d.a();
        this.f1248e.f1013g.m();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.x.d.a();
        this.f1248e.f1013g.i();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        a.a.a.a.x.d.b("onVideoPlayError code:%d extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.f1248e.f1013g.j();
        this.f1248e.a(i2, String.valueOf(i3));
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.x.d.a();
        this.f1248e.f1013g.n();
        this.f1248e.f1013g.b(this.f1244a);
        this.f1244a = true;
        this.f1248e.a((c) this.f1246c, this.f1247d);
    }
}
