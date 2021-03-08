package a.a.a.a.r.a.c;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes4.dex */
public class j implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public final /* synthetic */ TTFullScreenVideoAd Al;
    public final /* synthetic */ i Am;

    /* renamed from: a  reason: collision with root package name */
    public boolean f975a;
    public boolean b;
    public final /* synthetic */ String d;

    public j(i iVar, TTFullScreenVideoAd tTFullScreenVideoAd, String str) {
        this.Am = iVar;
        this.Al = tTFullScreenVideoAd;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        a.a.a.a.v.d.a();
        this.Am.zk.d();
        this.Am.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.Am.zk.b(this.f975a);
        this.f975a = true;
        this.Am.a((i) this.Al, this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        a.a.a.a.v.d.a();
        this.Am.zk.a(this.b);
        this.b = true;
        this.Am.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        a.a.a.a.v.d.a();
        this.Am.zk.m();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.Am.zk.i();
    }
}
