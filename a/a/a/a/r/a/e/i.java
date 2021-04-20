package a.a.a.a.r.a.e;

import com.kwad.sdk.api.KsRewardVideoAd;
/* loaded from: classes.dex */
public class i implements KsRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1248a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1249b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsRewardVideoAd f1250c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1251d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f1252e;

    public i(h hVar, KsRewardVideoAd ksRewardVideoAd, String str) {
        this.f1252e = hVar;
        this.f1250c = ksRewardVideoAd;
        this.f1251d = str;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1252e.f1010g.a(this.f1249b);
        this.f1249b = true;
        this.f1252e.e();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        a.a.a.a.v.d.a();
        this.f1252e.f1010g.d();
        this.f1252e.f();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        a.a.a.a.v.d.a();
        this.f1252e.f1010g.f();
        this.f1252e.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        a.a.a.a.v.d.a();
        this.f1252e.f1010g.i();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        a.a.a.a.v.d.a();
        this.f1252e.f1010g.b(i);
        this.f1252e.a(i, String.valueOf(i2));
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        a.a.a.a.v.d.a();
        this.f1252e.f1010g.n();
        this.f1252e.f1010g.b(this.f1248a);
        this.f1248a = true;
        this.f1252e.a((h) this.f1250c, this.f1251d);
    }
}
