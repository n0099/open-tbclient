package a.a.a.a.u.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1104a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1106c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1107d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1108e;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1108e = aVar;
        this.f1106c = tTNativeExpressAd;
        this.f1107d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1108e.f1014h.a(this.f1105b);
        this.f1105b = true;
        this.f1108e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1108e.f1014h.b(this.f1104a);
        this.f1104a = true;
        a aVar = this.f1108e;
        TTNativeExpressAd tTNativeExpressAd = this.f1106c;
        aVar.a((a) tTNativeExpressAd, aVar.o.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.y.d.b("onRenderFail message: " + str + ", code = " + i2, new Object[0]);
        this.f1108e.f1014h.a(i2);
        this.f1108e.m = false;
        this.f1108e.a(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.y.d.a();
        this.f1108e.f1014h.e();
        this.f1108e.o.put(this.f1106c, this.f1107d);
        a aVar = this.f1108e;
        aVar.a((a) this.f1106c);
        aVar.h();
    }
}
