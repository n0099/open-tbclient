package a.a.a.a.r.a.c;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes.dex */
public class j implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1124a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1125b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTFullScreenVideoAd f1126c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1127d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f1128e;

    public j(i iVar, TTFullScreenVideoAd tTFullScreenVideoAd, String str) {
        this.f1128e = iVar;
        this.f1126c = tTFullScreenVideoAd;
        this.f1127d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        a.a.a.a.v.d.a();
        this.f1128e.f1010g.d();
        this.f1128e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1128e.f1010g.b(this.f1124a);
        this.f1124a = true;
        this.f1128e.a((i) this.f1126c, this.f1127d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.v.d.a();
        this.f1128e.f1010g.a(this.f1125b);
        this.f1125b = true;
        this.f1128e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.a();
        this.f1128e.f1010g.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.f1128e.f1010g.i();
    }
}
