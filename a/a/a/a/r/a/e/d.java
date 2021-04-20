package a.a.a.a.r.a.e;

import com.kwad.sdk.api.KsFullScreenVideoAd;
/* loaded from: classes.dex */
public class d implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1225a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1226b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFullScreenVideoAd f1227c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1228d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c f1229e;

    public d(c cVar, KsFullScreenVideoAd ksFullScreenVideoAd, String str) {
        this.f1229e = cVar;
        this.f1227c = ksFullScreenVideoAd;
        this.f1228d = str;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1229e.f1010g.a(this.f1226b);
        this.f1226b = true;
        this.f1229e.e();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.v.d.a();
        this.f1229e.f1010g.d();
        this.f1229e.f();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.a();
        this.f1229e.f1010g.m();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.v.d.a();
        this.f1229e.f1010g.i();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        a.a.a.a.v.d.b("onVideoPlayError code:%d extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.f1229e.f1010g.j();
        this.f1229e.a(i, String.valueOf(i2));
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.v.d.a();
        this.f1229e.f1010g.n();
        this.f1229e.f1010g.b(this.f1225a);
        this.f1225a = true;
        this.f1229e.a((c) this.f1227c, this.f1228d);
    }
}
