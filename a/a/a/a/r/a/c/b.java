package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1094a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1095b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1096c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1097d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1098e;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1098e = aVar;
        this.f1096c = tTNativeExpressAd;
        this.f1097d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1098e.f1010g.a(this.f1095b);
        this.f1095b = true;
        this.f1098e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1098e.f1010g.b(this.f1094a);
        this.f1094a = true;
        a aVar = this.f1098e;
        TTNativeExpressAd tTNativeExpressAd = this.f1096c;
        aVar.a((a) tTNativeExpressAd, aVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("onRenderFail message: " + str + ", code = " + i, new Object[0]);
        this.f1098e.f1010g.a(i);
        this.f1098e.l = false;
        this.f1098e.a(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.a();
        this.f1098e.f1010g.e();
        this.f1098e.n.put(this.f1096c, this.f1097d);
        a aVar = this.f1098e;
        aVar.a((a) this.f1096c);
        aVar.h();
    }
}
