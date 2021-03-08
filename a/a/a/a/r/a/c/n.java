package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes4.dex */
public class n implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ m Aq;

    /* renamed from: a  reason: collision with root package name */
    public boolean f977a;
    public boolean b;
    public final /* synthetic */ String d;
    public final /* synthetic */ TTNativeExpressAd zX;

    public n(m mVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.Aq = mVar;
        this.zX = tTNativeExpressAd;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onAdClicked type: " + i, new Object[0]);
        this.Aq.zk.a(this.b);
        this.b = true;
        this.Aq.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onAdShow type: " + i, new Object[0]);
        this.Aq.zk.b(this.f977a);
        this.f977a = true;
        m mVar = this.Aq;
        TTNativeExpressAd tTNativeExpressAd = this.zX;
        mVar.a((m) tTNativeExpressAd, mVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i, new Object[0]);
        this.Aq.zk.a(i);
        this.Aq.b(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        a.a.a.a.v.d.b("CSJNativeExpressAd onRenderSuccess width: " + f + ", height:" + f2, new Object[0]);
        this.Aq.zk.e();
        this.Aq.n.put(this.zX, this.d);
        m mVar = this.Aq;
        mVar.a((m) this.zX);
        mVar.h();
    }
}
