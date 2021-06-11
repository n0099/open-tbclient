package a.a.a.a.u.a.b;

import a.a.a.a.u.a.b.h;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class i implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1127a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1128b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1129c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h.b f1130d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1131e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ h f1132f;

    public i(h hVar, TTNativeExpressAd tTNativeExpressAd, h.b bVar, String str) {
        this.f1132f = hVar;
        this.f1129c = tTNativeExpressAd;
        this.f1130d = bVar;
        this.f1131e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1132f.f1014h.a(this.f1128b);
        this.f1128b = true;
        this.f1132f.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1132f.f1014h.b(this.f1127a);
        this.f1127a = true;
        h hVar = this.f1132f;
        TTNativeExpressAd tTNativeExpressAd = this.f1129c;
        hVar.a((h) tTNativeExpressAd, hVar.o.remove(tTNativeExpressAd));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        a.a.a.a.y.d.a();
        this.f1132f.f1014h.a(i2);
        h.b bVar = this.f1130d;
        if (bVar.f1125c) {
            return;
        }
        int i3 = bVar.f1123a + 1;
        bVar.f1123a = i3;
        if (i3 == bVar.f1124b) {
            h.this.a(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        a.a.a.a.y.d.a();
        this.f1132f.f1014h.e();
        this.f1132f.o.put(this.f1129c, this.f1131e);
        h.b bVar = this.f1130d;
        TTNativeExpressAd tTNativeExpressAd = this.f1129c;
        if (!bVar.f1125c) {
            h hVar = h.this;
            hVar.a((h) tTNativeExpressAd);
            hVar.h();
            bVar.f1125c = true;
            return;
        }
        h.this.a((h) tTNativeExpressAd);
    }
}
