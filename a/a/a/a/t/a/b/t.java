package a.a.a.a.t.a.b;

import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes.dex */
public class t implements TTRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1159a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTRewardVideoAd f1161c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1162d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f1163e;

    public t(s sVar, TTRewardVideoAd tTRewardVideoAd, String str) {
        this.f1163e = sVar;
        this.f1161c = tTRewardVideoAd;
        this.f1162d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        a.a.a.a.x.d.a();
        this.f1163e.f1013g.d();
        this.f1163e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        a.a.a.a.x.d.a();
        this.f1163e.f1013g.b(this.f1159a);
        this.f1159a = true;
        this.f1163e.a((s) this.f1161c, this.f1162d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.x.d.a();
        this.f1163e.f1013g.a(this.f1160b);
        this.f1160b = true;
        this.f1163e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
        a.a.a.a.x.d.a("onRewardVerify rewardVerify:%b rewardAmount:%d rewardName:%s errCode:%d errMsg:%s", Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2);
        a.a.a.a.x.f.g.c.a(this.f1163e.f1013g.f1393a, "reward", "valid", Boolean.valueOf(z));
        this.f1163e.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.x.d.b("CSJRewardVideoAd onSkippedVideo", new Object[0]);
        this.f1163e.f1013g.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.x.d.a();
        this.f1163e.f1013g.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        a.a.a.a.x.d.a();
        this.f1163e.f1013g.j();
        this.f1163e.a(0, "F:onVideoError");
    }
}
