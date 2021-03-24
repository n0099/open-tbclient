package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsRewardVideoAd;
/* loaded from: classes.dex */
public class i implements KsRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1256a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsRewardVideoAd f1258c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1259d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f1260e;

    public i(h hVar, KsRewardVideoAd ksRewardVideoAd, String str) {
        this.f1260e = hVar;
        this.f1258c = ksRewardVideoAd;
        this.f1259d = str;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1260e.f1010g.a(this.f1257b);
        this.f1257b = true;
        this.f1260e.e();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.v.d.a();
        this.f1260e.f1010g.d();
        this.f1260e.f();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        a.a.a.a.v.d.a();
        this.f1260e.f1010g.f();
        this.f1260e.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.v.d.a();
        this.f1260e.f1010g.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        a.a.a.a.v.d.a();
        this.f1260e.f1010g.b(i);
        this.f1260e.a(i, String.valueOf(i2));
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.v.d.a();
        this.f1260e.f1010g.n();
        this.f1260e.f1010g.b(this.f1256a);
        this.f1256a = true;
        this.f1260e.a((h) this.f1258c, this.f1259d);
    }
}
