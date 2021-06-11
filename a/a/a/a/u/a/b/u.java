package a.a.a.a.u.a.b;

import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes.dex */
public class u implements TTRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1162a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1163b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTRewardVideoAd f1164c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1165d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t f1166e;

    public u(t tVar, TTRewardVideoAd tTRewardVideoAd, String str) {
        this.f1166e = tVar;
        this.f1164c = tTRewardVideoAd;
        this.f1165d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        a.a.a.a.y.d.a();
        this.f1166e.f1014h.d();
        this.f1166e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        a.a.a.a.y.d.a();
        this.f1166e.f1014h.b(this.f1162a);
        this.f1162a = true;
        this.f1166e.a((t) this.f1164c, this.f1165d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.y.d.a();
        this.f1166e.f1014h.a(this.f1163b);
        this.f1163b = true;
        this.f1166e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
        a.a.a.a.y.d.a("onRewardVerify rewardVerify:%b rewardAmount:%d rewardName:%s errCode:%d errMsg:%s", Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2);
        a.a.a.a.y.f.g.c.a(this.f1166e.f1014h.f1406a, "reward", "valid", Boolean.valueOf(z));
        this.f1166e.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.y.d.b("CSJRewardVideoAd onSkippedVideo", new Object[0]);
        this.f1166e.f1014h.n();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.y.d.a();
        this.f1166e.f1014h.j();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        a.a.a.a.y.d.a();
        this.f1166e.f1014h.k();
        this.f1166e.a(0, "F:onVideoError");
    }
}
