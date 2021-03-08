package a.a.a.a.r.a.f;

import com.kwad.sdk.api.KsRewardVideoAd;
/* loaded from: classes4.dex */
public class i implements KsRewardVideoAd.RewardAdInteractionListener {
    public final /* synthetic */ KsRewardVideoAd Br;
    public final /* synthetic */ h Bs;

    /* renamed from: a  reason: collision with root package name */
    public boolean f998a;
    public boolean b;
    public final /* synthetic */ String d;

    public i(h hVar, KsRewardVideoAd ksRewardVideoAd, String str) {
        this.Bs = hVar;
        this.Br = ksRewardVideoAd;
        this.d = str;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.Bs.zk.a(this.b);
        this.b = true;
        this.Bs.e();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.v.d.a();
        this.Bs.zk.d();
        this.Bs.f();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        a.a.a.a.v.d.a();
        this.Bs.zk.f();
        this.Bs.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.v.d.a();
        this.Bs.zk.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        a.a.a.a.v.d.a();
        this.Bs.zk.b(i);
        this.Bs.a(i, String.valueOf(i2));
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.v.d.a();
        this.Bs.zk.n();
        this.Bs.zk.b(this.f998a);
        this.f998a = true;
        this.Bs.a((h) this.Br, this.d);
    }
}
