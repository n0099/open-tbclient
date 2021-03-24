package a.a.a.a.r.a.d;

import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes.dex */
public class c implements AdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1164a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1165b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f1166c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1167d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f1168e;

    public c(b bVar, NativeExpressADData2 nativeExpressADData2, String str) {
        this.f1168e = bVar;
        this.f1166c = nativeExpressADData2;
        this.f1167d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        a.a.a.a.v.d.a();
        this.f1168e.f1010g.d();
        this.f1168e.f();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        a.a.a.a.v.d.a();
        this.f1168e.f1010g.a(this.f1165b);
        this.f1165b = true;
        this.f1168e.e();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        a.a.a.a.v.d.b();
        this.f1168e.f1010g.b(this.f1164a);
        this.f1164a = true;
        b bVar = this.f1168e;
        NativeExpressADData2 nativeExpressADData2 = this.f1166c;
        bVar.a((b) nativeExpressADData2, bVar.m.remove(nativeExpressADData2));
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1168e.f1010g.f1391a, "render_failed", new Object[0]);
        this.f1168e.b(0, "RenderFail");
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        a.a.a.a.v.d.a();
        this.f1168e.f1010g.e();
        this.f1168e.m.put(this.f1166c, this.f1167d);
        b bVar = this.f1168e;
        bVar.a((b) this.f1166c);
        bVar.h();
    }
}
