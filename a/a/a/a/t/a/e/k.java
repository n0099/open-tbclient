package a.a.a.a.t.a.e;

import com.kwad.sdk.api.KsRewardVideoAd;
/* loaded from: classes.dex */
public class k implements KsRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1269a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1270b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsRewardVideoAd f1271c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1272d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j f1273e;

    public k(j jVar, KsRewardVideoAd ksRewardVideoAd, String str) {
        this.f1273e = jVar;
        this.f1271c = ksRewardVideoAd;
        this.f1272d = str;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.x.d.a();
        this.f1273e.f1013g.a(this.f1270b);
        this.f1270b = true;
        this.f1273e.e();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.x.d.a();
        this.f1273e.f1013g.d();
        this.f1273e.f();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        a.a.a.a.x.d.a();
        this.f1273e.f1013g.f();
        this.f1273e.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.x.d.a();
        this.f1273e.f1013g.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        a.a.a.a.x.d.a();
        this.f1273e.f1013g.b(i2);
        this.f1273e.a(i2, String.valueOf(i3));
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.x.d.a();
        this.f1273e.f1013g.n();
        this.f1273e.f1013g.b(this.f1269a);
        this.f1269a = true;
        this.f1273e.a((j) this.f1271c, this.f1272d);
    }
}
