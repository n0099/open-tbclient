package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes4.dex */
public class l implements TTNativeExpressAd.AdInteractionListener {
    public final /* synthetic */ k Ao;

    /* renamed from: a  reason: collision with root package name */
    public boolean f976a;
    public boolean b;
    public final /* synthetic */ String d;
    public final /* synthetic */ TTNativeExpressAd zX;

    public l(k kVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.Ao = kVar;
        this.zX = tTNativeExpressAd;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.Ao.zk.a(this.b);
        this.b = true;
        this.Ao.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        a.a.a.a.v.d.a();
        this.Ao.zk.d();
        this.Ao.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.Ao.zk.b(this.f976a);
        this.f976a = true;
        k kVar = this.Ao;
        TTNativeExpressAd tTNativeExpressAd = this.zX;
        kVar.a((k) tTNativeExpressAd, kVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("onRenderFail message: " + str + ", code: " + i, new Object[0]);
        this.Ao.zk.a(i);
        this.Ao.b(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        a.a.a.a.v.d.a();
        this.Ao.zk.e();
        this.Ao.n.put(this.zX, this.d);
        k kVar = this.Ao;
        kVar.a((k) this.zX);
        kVar.h();
    }
}
