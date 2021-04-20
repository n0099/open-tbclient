package a.a.a.a.r.a.c;

import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes.dex */
public class c implements AdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1156a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1157b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f1158c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1159d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f1160e;

    public c(b bVar, NativeExpressADData2 nativeExpressADData2, String str) {
        this.f1160e = bVar;
        this.f1158c = nativeExpressADData2;
        this.f1159d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        a.a.a.a.v.d.a();
        this.f1160e.f1010g.d();
        this.f1160e.f();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        a.a.a.a.v.d.a();
        this.f1160e.f1010g.a(this.f1157b);
        this.f1157b = true;
        this.f1160e.e();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        a.a.a.a.v.d.b();
        this.f1160e.f1010g.b(this.f1156a);
        this.f1156a = true;
        b bVar = this.f1160e;
        NativeExpressADData2 nativeExpressADData2 = this.f1158c;
        bVar.a((b) nativeExpressADData2, bVar.m.remove(nativeExpressADData2));
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1160e.f1010g.f1377a, "render_failed", new Object[0]);
        this.f1160e.b(0, "RenderFail");
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        a.a.a.a.v.d.a();
        this.f1160e.f1010g.e();
        this.f1160e.m.put(this.f1158c, this.f1159d);
        b bVar = this.f1160e;
        bVar.a((b) this.f1158c);
        bVar.h();
    }
}
