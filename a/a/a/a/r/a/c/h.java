package a.a.a.a.r.a.c;

import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes4.dex */
public class h implements TTNativeExpressAd.ExpressVideoAdListener {
    public final /* synthetic */ f Aj;

    public h(f fVar) {
        this.Aj = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onClickRetry() {
        a.a.a.a.v.d.a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onProgressUpdate(long j, long j2) {
        a.a.a.a.v.d.a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdComplete() {
        a.a.a.a.v.d.a();
        this.Aj.zk.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
        a.a.a.a.v.d.a();
        this.Aj.zk.l();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
        a.a.a.a.v.d.a();
        this.Aj.zk.k();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
        a.a.a.a.v.d.a();
        this.Aj.zk.n();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i, int i2) {
        a.a.a.a.v.d.b("onVideoError errorCode: " + i + ", extraCode: " + i2, new Object[0]);
        this.Aj.zk.b(i);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
        a.a.a.a.v.d.a();
    }
}
