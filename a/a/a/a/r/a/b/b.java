package a.a.a.a.r.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1086a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1087b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1088c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1089d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1090e;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1090e = aVar;
        this.f1088c = tTNativeExpressAd;
        this.f1089d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1090e.f1010g.a(this.f1087b);
        this.f1087b = true;
        this.f1090e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1090e.f1010g.b(this.f1086a);
        this.f1086a = true;
        a aVar = this.f1090e;
        TTNativeExpressAd tTNativeExpressAd = this.f1088c;
        aVar.a((a) tTNativeExpressAd, aVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("onRenderFail message: " + str + ", code = " + i, new Object[0]);
        this.f1090e.f1010g.a(i);
        this.f1090e.l = false;
        this.f1090e.a(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.a();
        this.f1090e.f1010g.e();
        this.f1090e.n.put(this.f1088c, this.f1089d);
        a aVar = this.f1090e;
        aVar.a((a) this.f1088c);
        aVar.h();
    }
}
