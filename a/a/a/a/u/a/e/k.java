package a.a.a.a.u.a.e;

import com.kwad.sdk.api.KsRewardVideoAd;
/* loaded from: classes.dex */
public class k implements KsRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1277a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsRewardVideoAd f1279c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1280d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j f1281e;

    public k(j jVar, KsRewardVideoAd ksRewardVideoAd, String str) {
        this.f1281e = jVar;
        this.f1279c = ksRewardVideoAd;
        this.f1280d = str;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.y.d.a();
        this.f1281e.f1014h.a(this.f1278b);
        this.f1278b = true;
        this.f1281e.e();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.y.d.a();
        this.f1281e.f1014h.d();
        this.f1281e.f();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        a.a.a.a.y.d.a();
        this.f1281e.f1014h.f();
        this.f1281e.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.y.d.a();
        this.f1281e.f1014h.j();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        a.a.a.a.y.d.a();
        this.f1281e.f1014h.b(i2);
        this.f1281e.a(i2, String.valueOf(i3));
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.y.d.a();
        this.f1281e.f1014h.o();
        this.f1281e.f1014h.b(this.f1277a);
        this.f1277a = true;
        this.f1281e.a((j) this.f1279c, this.f1280d);
    }
}
