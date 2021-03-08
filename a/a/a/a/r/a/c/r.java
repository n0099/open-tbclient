package a.a.a.a.r.a.c;

import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes4.dex */
public class r implements TTRewardVideoAd.RewardAdInteractionListener {
    public final /* synthetic */ TTRewardVideoAd At;
    public final /* synthetic */ q Au;

    /* renamed from: a  reason: collision with root package name */
    public boolean f981a;
    public boolean b;
    public final /* synthetic */ String d;

    public r(q qVar, TTRewardVideoAd tTRewardVideoAd, String str) {
        this.Au = qVar;
        this.At = tTRewardVideoAd;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        a.a.a.a.v.d.a();
        this.Au.zk.d();
        this.Au.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.Au.zk.b(this.f981a);
        this.f981a = true;
        this.Au.a((q) this.At, this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.v.d.a();
        this.Au.zk.a(this.b);
        this.b = true;
        this.Au.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        a.a.a.a.v.d.a("onRewardVerify rewardVerify:%b rewardAmount:%d rewardName:%s errCode:%d errMsg:%s", Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        a.a.a.a.v.f.g.c.a(this.Au.zk.BU, "reward", CloudControlUBCUtils.KEY_VALID, Boolean.valueOf(z));
        this.Au.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.b("CSJRewardVideoAd onSkippedVideo", new Object[0]);
        this.Au.zk.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.Au.zk.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        a.a.a.a.v.d.a();
        this.Au.zk.j();
        this.Au.a(0, "F:onVideoError");
    }
}
