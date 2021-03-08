package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsFullScreenVideoAd;
/* loaded from: classes4.dex */
public class d implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public final /* synthetic */ KsFullScreenVideoAd Bi;
    public final /* synthetic */ c Bj;

    /* renamed from: a  reason: collision with root package name */
    public boolean f995a;
    public boolean b;
    public final /* synthetic */ String d;

    public d(c cVar, KsFullScreenVideoAd ksFullScreenVideoAd, String str) {
        this.Bj = cVar;
        this.Bi = ksFullScreenVideoAd;
        this.d = str;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.Bj.zk.a(this.b);
        this.b = true;
        this.Bj.e();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.v.d.a();
        this.Bj.zk.d();
        this.Bj.f();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.a();
        this.Bj.zk.m();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.v.d.a();
        this.Bj.zk.i();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        a.a.a.a.v.d.b("onVideoPlayError code:%d extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.Bj.zk.j();
        this.Bj.a(i, String.valueOf(i2));
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.v.d.a();
        this.Bj.zk.n();
        this.Bj.zk.b(this.f995a);
        this.f995a = true;
        this.Bj.a((c) this.Bi, this.d);
    }
}
