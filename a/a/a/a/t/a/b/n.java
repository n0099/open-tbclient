package a.a.a.a.t.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class n implements TTNativeExpressAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1140a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1141b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1142c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1143d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1144e;

    public n(m mVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1144e = mVar;
        this.f1142c = tTNativeExpressAd;
        this.f1143d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1144e.f1013g.a(this.f1141b);
        this.f1141b = true;
        this.f1144e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        a.a.a.a.x.d.a();
        this.f1144e.f1013g.d();
        this.f1144e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1144e.f1013g.b(this.f1140a);
        this.f1140a = true;
        m mVar = this.f1144e;
        TTNativeExpressAd tTNativeExpressAd = this.f1142c;
        mVar.a((m) tTNativeExpressAd, mVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.x.d.b("onRenderFail message: " + str + ", code: " + i2, new Object[0]);
        this.f1144e.f1013g.a(i2);
        this.f1144e.b(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.x.d.a();
        this.f1144e.f1013g.e();
        this.f1144e.n.put(this.f1142c, this.f1143d);
        m mVar = this.f1144e;
        mVar.a((m) this.f1142c);
        mVar.h();
    }
}
