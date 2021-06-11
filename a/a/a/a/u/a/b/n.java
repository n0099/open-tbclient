package a.a.a.a.u.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class n implements TTNativeExpressAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1143a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1145c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1146d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1147e;

    public n(m mVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1147e = mVar;
        this.f1145c = tTNativeExpressAd;
        this.f1146d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1147e.f1014h.a(this.f1144b);
        this.f1144b = true;
        this.f1147e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        a.a.a.a.y.d.a();
        this.f1147e.f1014h.d();
        this.f1147e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1147e.f1014h.b(this.f1143a);
        this.f1143a = true;
        m mVar = this.f1147e;
        TTNativeExpressAd tTNativeExpressAd = this.f1145c;
        mVar.a((m) tTNativeExpressAd, mVar.o.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.y.d.b("onRenderFail message: " + str + ", code: " + i2, new Object[0]);
        this.f1147e.f1014h.a(i2);
        this.f1147e.b(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.y.d.a();
        this.f1147e.f1014h.e();
        this.f1147e.o.put(this.f1145c, this.f1146d);
        m mVar = this.f1147e;
        mVar.a((m) this.f1145c);
        mVar.h();
    }
}
