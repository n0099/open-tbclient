package a.a.a.a.u.a.c;

import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes.dex */
public class c implements AdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1176a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f1178c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1179d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f1180e;

    public c(b bVar, NativeExpressADData2 nativeExpressADData2, String str) {
        this.f1180e = bVar;
        this.f1178c = nativeExpressADData2;
        this.f1179d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        a.a.a.a.y.d.a();
        this.f1180e.f1014h.d();
        this.f1180e.f();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        a.a.a.a.y.d.a();
        this.f1180e.f1014h.a(this.f1177b);
        this.f1177b = true;
        this.f1180e.e();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        a.a.a.a.y.d.b();
        this.f1180e.f1014h.b(this.f1176a);
        this.f1176a = true;
        b bVar = this.f1180e;
        NativeExpressADData2 nativeExpressADData2 = this.f1178c;
        bVar.a((b) nativeExpressADData2, bVar.n.remove(nativeExpressADData2));
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        a.a.a.a.y.d.a();
        a.a.a.a.y.f.g.c.a(this.f1180e.f1014h.f1406a, "render_failed", new Object[0]);
        this.f1180e.b(0, "RenderFail");
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        a.a.a.a.y.d.a();
        this.f1180e.f1014h.e();
        this.f1180e.n.put(this.f1178c, this.f1179d);
        b bVar = this.f1180e;
        bVar.a((b) this.f1178c);
        bVar.h();
    }
}
