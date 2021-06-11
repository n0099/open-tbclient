package a.a.a.a.u.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class q implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1150a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1151b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1152c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1153d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f1154e;

    public q(p pVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.f1154e = pVar;
        this.f1152c = tTNativeExpressAd;
        this.f1153d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.y.d.b("CSJNativeExpressAd onAdClicked type: " + i2, new Object[0]);
        this.f1154e.f1014h.a(this.f1151b);
        this.f1151b = true;
        this.f1154e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.y.d.b("CSJNativeExpressAd onAdShow type: " + i2, new Object[0]);
        this.f1154e.f1014h.b(this.f1150a);
        this.f1150a = true;
        p pVar = this.f1154e;
        TTNativeExpressAd tTNativeExpressAd = this.f1152c;
        pVar.a((p) tTNativeExpressAd, pVar.o.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.y.d.b("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i2, new Object[0]);
        this.f1154e.f1014h.a(i2);
        this.f1154e.b(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.y.d.b("CSJNativeExpressAd onRenderSuccess width: " + f2 + ", height:" + f3, new Object[0]);
        this.f1154e.f1014h.e();
        this.f1154e.o.put(this.f1152c, this.f1153d);
        p pVar = this.f1154e;
        pVar.a((p) this.f1152c);
        pVar.h();
    }
}
