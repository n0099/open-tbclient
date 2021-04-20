package a.a.a.a.r.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class l implements TTNativeExpressAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1123a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1124b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1125c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1126d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1127e;

    public l(k kVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1127e = kVar;
        this.f1125c = tTNativeExpressAd;
        this.f1126d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1127e.f1010g.a(this.f1124b);
        this.f1124b = true;
        this.f1127e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        a.a.a.a.v.d.a();
        this.f1127e.f1010g.d();
        this.f1127e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1127e.f1010g.b(this.f1123a);
        this.f1123a = true;
        k kVar = this.f1127e;
        TTNativeExpressAd tTNativeExpressAd = this.f1125c;
        kVar.a((k) tTNativeExpressAd, kVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("onRenderFail message: " + str + ", code: " + i, new Object[0]);
        this.f1127e.f1010g.a(i);
        this.f1127e.b(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.a();
        this.f1127e.f1010g.e();
        this.f1127e.n.put(this.f1125c, this.f1126d);
        k kVar = this.f1127e;
        kVar.a((k) this.f1125c);
        kVar.h();
    }
}
