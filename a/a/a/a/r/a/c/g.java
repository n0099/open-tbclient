package a.a.a.a.r.a.c;

import a.a.a.a.r.a.c.f;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class g implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1115a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1117c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f.b f1118d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1119e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f1120f;

    public g(f fVar, TTNativeExpressAd tTNativeExpressAd, f.b bVar, String str) {
        this.f1120f = fVar;
        this.f1117c = tTNativeExpressAd;
        this.f1118d = bVar;
        this.f1119e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1120f.f1010g.a(this.f1116b);
        this.f1116b = true;
        this.f1120f.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1120f.f1010g.b(this.f1115a);
        this.f1115a = true;
        f fVar = this.f1120f;
        TTNativeExpressAd tTNativeExpressAd = this.f1117c;
        fVar.a((f) tTNativeExpressAd, fVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        a.a.a.a.v.d.a();
        this.f1120f.f1010g.a(i);
        f.b bVar = this.f1118d;
        if (bVar.f1113c) {
            return;
        }
        int i2 = bVar.f1111a + 1;
        bVar.f1111a = i2;
        if (i2 == bVar.f1112b) {
            f.this.a(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.v.d.a();
        this.f1120f.f1010g.e();
        this.f1120f.n.put(this.f1117c, this.f1119e);
        f.b bVar = this.f1118d;
        TTNativeExpressAd tTNativeExpressAd = this.f1117c;
        if (!bVar.f1113c) {
            f fVar = f.this;
            fVar.a((f) tTNativeExpressAd);
            fVar.h();
            bVar.f1113c = true;
            return;
        }
        f.this.a((f) tTNativeExpressAd);
    }
}
