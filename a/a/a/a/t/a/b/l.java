package a.a.a.a.t.a.b;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes.dex */
public class l implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1133a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTFullScreenVideoAd f1135c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1136d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1137e;

    public l(k kVar, TTFullScreenVideoAd tTFullScreenVideoAd, String str) {
        this.f1137e = kVar;
        this.f1135c = tTFullScreenVideoAd;
        this.f1136d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        a.a.a.a.x.d.a();
        this.f1137e.f1013g.d();
        this.f1137e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        a.a.a.a.x.d.a();
        this.f1137e.f1013g.b(this.f1133a);
        this.f1133a = true;
        this.f1137e.a((k) this.f1135c, this.f1136d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.x.d.a();
        this.f1137e.f1013g.a(this.f1134b);
        this.f1134b = true;
        this.f1137e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.x.d.a();
        this.f1137e.f1013g.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.x.d.a();
        this.f1137e.f1013g.i();
    }
}
