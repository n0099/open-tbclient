package a.a.a.a.r.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class n implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1130a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1132c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1133d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1134e;

    public n(m mVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1134e = mVar;
        this.f1132c = tTNativeExpressAd;
        this.f1133d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onAdClicked type: " + i, new Object[0]);
        this.f1134e.f1010g.a(this.f1131b);
        this.f1131b = true;
        this.f1134e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onAdShow type: " + i, new Object[0]);
        this.f1134e.f1010g.b(this.f1130a);
        this.f1130a = true;
        m mVar = this.f1134e;
        TTNativeExpressAd tTNativeExpressAd = this.f1132c;
        mVar.a((m) tTNativeExpressAd, mVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i, new Object[0]);
        this.f1134e.f1010g.a(i);
        this.f1134e.b(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onRenderSuccess width: " + f2 + ", height:" + f3, new Object[0]);
        this.f1134e.f1010g.e();
        this.f1134e.n.put(this.f1132c, this.f1133d);
        m mVar = this.f1134e;
        mVar.a((m) this.f1132c);
        mVar.h();
    }
}
