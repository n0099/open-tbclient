package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class l implements TTNativeExpressAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1131a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1133c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1134d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1135e;

    public l(k kVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1135e = kVar;
        this.f1133c = tTNativeExpressAd;
        this.f1134d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1135e.f1010g.a(this.f1132b);
        this.f1132b = true;
        this.f1135e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        a.a.a.a.v.d.a();
        this.f1135e.f1010g.d();
        this.f1135e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1135e.f1010g.b(this.f1131a);
        this.f1131a = true;
        k kVar = this.f1135e;
        TTNativeExpressAd tTNativeExpressAd = this.f1133c;
        kVar.a((k) tTNativeExpressAd, kVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("onRenderFail message: " + str + ", code: " + i, new Object[0]);
        this.f1135e.f1010g.a(i);
        this.f1135e.b(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.a();
        this.f1135e.f1010g.e();
        this.f1135e.n.put(this.f1133c, this.f1134d);
        k kVar = this.f1135e;
        kVar.a((k) this.f1133c);
        kVar.h();
    }
}
