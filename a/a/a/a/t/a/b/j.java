package a.a.a.a.t.a.b;

import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class j implements TTNativeExpressAd.ExpressVideoAdListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f1130a;

    public j(h hVar) {
        this.f1130a = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onClickRetry() {
        a.a.a.a.x.d.a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onProgressUpdate(long j, long j2) {
        a.a.a.a.x.d.a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdComplete() {
        a.a.a.a.x.d.a();
        this.f1130a.f1013g.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
        a.a.a.a.x.d.a();
        this.f1130a.f1013g.l();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
        a.a.a.a.x.d.a();
        this.f1130a.f1013g.k();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
        a.a.a.a.x.d.a();
        this.f1130a.f1013g.n();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i2, int i3) {
        a.a.a.a.x.d.b("onVideoError errorCode: " + i2 + ", extraCode: " + i3, new Object[0]);
        this.f1130a.f1013g.b(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
        a.a.a.a.x.d.a();
    }
}
