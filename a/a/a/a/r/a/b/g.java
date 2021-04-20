package a.a.a.a.r.a.b;

import a.a.a.a.r.a.b.f;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class g implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1107a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1108b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1109c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f.b f1110d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1111e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f1112f;

    public g(f fVar, TTNativeExpressAd tTNativeExpressAd, f.b bVar, String str) {
        this.f1112f = fVar;
        this.f1109c = tTNativeExpressAd;
        this.f1110d = bVar;
        this.f1111e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1112f.f1010g.a(this.f1108b);
        this.f1108b = true;
        this.f1112f.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1112f.f1010g.b(this.f1107a);
        this.f1107a = true;
        f fVar = this.f1112f;
        TTNativeExpressAd tTNativeExpressAd = this.f1109c;
        fVar.a((f) tTNativeExpressAd, fVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.a();
        this.f1112f.f1010g.a(i);
        f.b bVar = this.f1110d;
        if (bVar.f1105c) {
            return;
        }
        int i2 = bVar.f1103a + 1;
        bVar.f1103a = i2;
        if (i2 == bVar.f1104b) {
            f.this.a(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.a();
        this.f1112f.f1010g.e();
        this.f1112f.n.put(this.f1109c, this.f1111e);
        f.b bVar = this.f1110d;
        TTNativeExpressAd tTNativeExpressAd = this.f1109c;
        if (!bVar.f1105c) {
            f fVar = f.this;
            fVar.a((f) tTNativeExpressAd);
            fVar.h();
            bVar.f1105c = true;
            return;
        }
        f.this.a((f) tTNativeExpressAd);
    }
}
