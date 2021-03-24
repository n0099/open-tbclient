package a.a.a.a.r.a.c;

import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes.dex */
public class r implements TTRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1150a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1151b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTRewardVideoAd f1152c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1153d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ q f1154e;

    public r(q qVar, TTRewardVideoAd tTRewardVideoAd, String str) {
        this.f1154e = qVar;
        this.f1152c = tTRewardVideoAd;
        this.f1153d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        a.a.a.a.v.d.a();
        this.f1154e.f1010g.d();
        this.f1154e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1154e.f1010g.b(this.f1150a);
        this.f1150a = true;
        this.f1154e.a((q) this.f1152c, this.f1153d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.v.d.a();
        this.f1154e.f1010g.a(this.f1151b);
        this.f1151b = true;
        this.f1154e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        a.a.a.a.v.d.a("onRewardVerify rewardVerify:%b rewardAmount:%d rewardName:%s errCode:%d errMsg:%s", Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        a.a.a.a.v.f.g.c.a(this.f1154e.f1010g.f1391a, "reward", "valid", Boolean.valueOf(z));
        this.f1154e.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.b("CSJRewardVideoAd onSkippedVideo", new Object[0]);
        this.f1154e.f1010g.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.f1154e.f1010g.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        a.a.a.a.v.d.a();
        this.f1154e.f1010g.j();
        this.f1154e.a(0, "F:onVideoError");
    }
}
