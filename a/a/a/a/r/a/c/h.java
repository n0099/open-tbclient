package a.a.a.a.r.a.c;

import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class h implements TTNativeExpressAd.ExpressVideoAdListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f1121a;

    public h(f fVar) {
        this.f1121a = fVar;
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
        this.f1121a.f1010g.i();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
        a.a.a.a.v.d.a();
        this.f1121a.f1010g.l();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
        a.a.a.a.v.d.a();
        this.f1121a.f1010g.k();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
        a.a.a.a.v.d.a();
        this.f1121a.f1010g.n();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i, int i2) {
        a.a.a.a.v.d.b("onVideoError errorCode: " + i + ", extraCode: " + i2, new Object[0]);
        this.f1121a.f1010g.b(i);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
        a.a.a.a.v.d.a();
    }
}
