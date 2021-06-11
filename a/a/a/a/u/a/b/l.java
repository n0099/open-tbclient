package a.a.a.a.u.a.b;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes.dex */
public class l implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1136a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1137b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTFullScreenVideoAd f1138c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1139d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1140e;

    public l(k kVar, TTFullScreenVideoAd tTFullScreenVideoAd, String str) {
        this.f1140e = kVar;
        this.f1138c = tTFullScreenVideoAd;
        this.f1139d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        a.a.a.a.y.d.a();
        this.f1140e.f1014h.d();
        this.f1140e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        a.a.a.a.y.d.a();
        this.f1140e.f1014h.b(this.f1136a);
        this.f1136a = true;
        this.f1140e.a((k) this.f1138c, this.f1139d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.y.d.a();
        this.f1140e.f1014h.a(this.f1137b);
        this.f1137b = true;
        this.f1140e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.y.d.a();
        this.f1140e.f1014h.n();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.y.d.a();
        this.f1140e.f1014h.j();
    }
}
