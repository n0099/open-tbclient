package a.a.a.a.r.a.b;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes.dex */
public class j implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1116a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1117b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTFullScreenVideoAd f1118c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1119d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f1120e;

    public j(i iVar, TTFullScreenVideoAd tTFullScreenVideoAd, String str) {
        this.f1120e = iVar;
        this.f1118c = tTFullScreenVideoAd;
        this.f1119d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        a.a.a.a.v.d.a();
        this.f1120e.f1010g.d();
        this.f1120e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1120e.f1010g.b(this.f1116a);
        this.f1116a = true;
        this.f1120e.a((i) this.f1118c, this.f1119d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.v.d.a();
        this.f1120e.f1010g.a(this.f1117b);
        this.f1117b = true;
        this.f1120e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.a();
        this.f1120e.f1010g.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.f1120e.f1010g.i();
    }
}
