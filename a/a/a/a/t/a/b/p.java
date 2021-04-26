package a.a.a.a.t.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class p implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1147a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1148b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1149c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1150d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o f1151e;

    public p(o oVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1151e = oVar;
        this.f1149c = tTNativeExpressAd;
        this.f1150d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.x.d.b("CSJNativeExpressAd onAdClicked type: " + i2, new Object[0]);
        this.f1151e.f1013g.a(this.f1148b);
        this.f1148b = true;
        this.f1151e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.x.d.b("CSJNativeExpressAd onAdShow type: " + i2, new Object[0]);
        this.f1151e.f1013g.b(this.f1147a);
        this.f1147a = true;
        o oVar = this.f1151e;
        TTNativeExpressAd tTNativeExpressAd = this.f1149c;
        oVar.a((o) tTNativeExpressAd, oVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.x.d.b("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i2, new Object[0]);
        this.f1151e.f1013g.a(i2);
        this.f1151e.b(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.x.d.b("CSJNativeExpressAd onRenderSuccess width: " + f2 + ", height:" + f3, new Object[0]);
        this.f1151e.f1013g.e();
        this.f1151e.n.put(this.f1149c, this.f1150d);
        o oVar = this.f1151e;
        oVar.a((o) this.f1149c);
        oVar.h();
    }
}
