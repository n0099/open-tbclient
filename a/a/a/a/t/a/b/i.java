package a.a.a.a.t.a.b;

import a.a.a.a.t.a.b.h;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class i implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1124a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1125b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1126c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h.b f1127d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1128e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ h f1129f;

    public i(h hVar, TTNativeExpressAd tTNativeExpressAd, h.b bVar, String str) {
        this.f1129f = hVar;
        this.f1126c = tTNativeExpressAd;
        this.f1127d = bVar;
        this.f1128e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1129f.f1013g.a(this.f1125b);
        this.f1125b = true;
        this.f1129f.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1129f.f1013g.b(this.f1124a);
        this.f1124a = true;
        h hVar = this.f1129f;
        TTNativeExpressAd tTNativeExpressAd = this.f1126c;
        hVar.a((h) tTNativeExpressAd, hVar.n.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.x.d.a();
        this.f1129f.f1013g.a(i2);
        h.b bVar = this.f1127d;
        if (bVar.f1122c) {
            return;
        }
        int i3 = bVar.f1120a + 1;
        bVar.f1120a = i3;
        if (i3 == bVar.f1121b) {
            h.this.a(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.x.d.a();
        this.f1129f.f1013g.e();
        this.f1129f.n.put(this.f1126c, this.f1128e);
        h.b bVar = this.f1127d;
        TTNativeExpressAd tTNativeExpressAd = this.f1126c;
        if (!bVar.f1122c) {
            h hVar = h.this;
            hVar.a((h) tTNativeExpressAd);
            hVar.h();
            bVar.f1122c = true;
            return;
        }
        h.this.a((h) tTNativeExpressAd);
    }
}
