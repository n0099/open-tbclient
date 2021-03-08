package a.a.a.a.r.a.c;

import a.a.a.a.r.a.c.f;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes4.dex */
public class g implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ f.b Ah;
    public final /* synthetic */ f Ai;

    /* renamed from: a  reason: collision with root package name */
    public boolean f974a;
    public boolean b;
    public final /* synthetic */ String e;
    public final /* synthetic */ TTNativeExpressAd zX;

    public g(f fVar, TTNativeExpressAd tTNativeExpressAd, f.b bVar, String str) {
        this.Ai = fVar;
        this.zX = tTNativeExpressAd;
        this.Ah = bVar;
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.Ai.zk.a(this.b);
        this.b = true;
        this.Ai.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.Ai.zk.b(this.f974a);
        this.f974a = true;
        f fVar = this.Ai;
        TTNativeExpressAd tTNativeExpressAd = this.zX;
        fVar.a((f) tTNativeExpressAd, fVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.a();
        this.Ai.zk.a(i);
        f.b bVar = this.Ah;
        if (!bVar.c) {
            int i2 = bVar.f973a + 1;
            bVar.f973a = i2;
            if (i2 == bVar.b) {
                f.this.a(i, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        a.a.a.a.v.d.a();
        this.Ai.zk.e();
        this.Ai.n.put(this.zX, this.e);
        f.b bVar = this.Ah;
        TTNativeExpressAd tTNativeExpressAd = this.zX;
        if (!bVar.c) {
            f fVar = f.this;
            fVar.a((f) tTNativeExpressAd);
            fVar.h();
            bVar.c = true;
            return;
        }
        f.this.a((f) tTNativeExpressAd);
    }
}
