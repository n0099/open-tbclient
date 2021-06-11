package a.a.a.a.u.a.e;

import com.kwad.sdk.api.KsFullScreenVideoAd;
/* loaded from: classes.dex */
public class d implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1252a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1253b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFullScreenVideoAd f1254c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1255d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c f1256e;

    public d(c cVar, KsFullScreenVideoAd ksFullScreenVideoAd, String str) {
        this.f1256e = cVar;
        this.f1254c = ksFullScreenVideoAd;
        this.f1255d = str;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.y.d.a();
        this.f1256e.f1014h.a(this.f1253b);
        this.f1253b = true;
        this.f1256e.e();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.y.d.a();
        this.f1256e.f1014h.d();
        this.f1256e.f();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.y.d.a();
        this.f1256e.f1014h.n();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.y.d.a();
        this.f1256e.f1014h.j();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        a.a.a.a.y.d.b("onVideoPlayError code:%d extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.f1256e.f1014h.k();
        this.f1256e.a(i2, String.valueOf(i3));
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.y.d.a();
        this.f1256e.f1014h.o();
        this.f1256e.f1014h.b(this.f1252a);
        this.f1252a = true;
        this.f1256e.a((c) this.f1254c, this.f1255d);
    }
}
