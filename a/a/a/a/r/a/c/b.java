package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes4.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f969a;
    public boolean b;
    public final /* synthetic */ String d;
    public final /* synthetic */ TTNativeExpressAd zX;
    public final /* synthetic */ a zY;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        this.zY = aVar;
        this.zX = tTNativeExpressAd;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.zY.zk.a(this.b);
        this.b = true;
        this.zY.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.zY.zk.b(this.f969a);
        this.f969a = true;
        a aVar = this.zY;
        TTNativeExpressAd tTNativeExpressAd = this.zX;
        aVar.a((a) tTNativeExpressAd, aVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.b("onRenderFail message: " + str + ", code = " + i, new Object[0]);
        this.zY.zk.a(i);
        this.zY.l = false;
        this.zY.a(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        a.a.a.a.v.d.a();
        this.zY.zk.e();
        this.zY.n.put(this.zX, this.d);
        a aVar = this.zY;
        aVar.a((a) this.zX);
        aVar.h();
    }
}
