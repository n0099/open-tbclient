package a.a.a.a.t.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1101a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1102b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1103c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1104d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1105e;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1105e = aVar;
        this.f1103c = tTNativeExpressAd;
        this.f1104d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1105e.f1013g.a(this.f1102b);
        this.f1102b = true;
        this.f1105e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1105e.f1013g.b(this.f1101a);
        this.f1101a = true;
        a aVar = this.f1105e;
        TTNativeExpressAd tTNativeExpressAd = this.f1103c;
        aVar.a((a) tTNativeExpressAd, aVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.x.d.b("onRenderFail message: " + str + ", code = " + i2, new Object[0]);
        this.f1105e.f1013g.a(i2);
        this.f1105e.l = false;
        this.f1105e.a(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.x.d.a();
        this.f1105e.f1013g.e();
        this.f1105e.n.put(this.f1103c, this.f1104d);
        a aVar = this.f1105e;
        aVar.a((a) this.f1103c);
        aVar.h();
    }
}
