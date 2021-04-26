package a.a.a.a.t.a.c;

import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes.dex */
public class c implements AdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1173a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1174b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f1175c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1176d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f1177e;

    public c(b bVar, NativeExpressADData2 nativeExpressADData2, String str) {
        this.f1177e = bVar;
        this.f1175c = nativeExpressADData2;
        this.f1176d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        a.a.a.a.x.d.a();
        this.f1177e.f1013g.d();
        this.f1177e.f();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        a.a.a.a.x.d.a();
        this.f1177e.f1013g.a(this.f1174b);
        this.f1174b = true;
        this.f1177e.e();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        a.a.a.a.x.d.b();
        this.f1177e.f1013g.b(this.f1173a);
        this.f1173a = true;
        b bVar = this.f1177e;
        NativeExpressADData2 nativeExpressADData2 = this.f1175c;
        bVar.a((b) nativeExpressADData2, bVar.m.remove(nativeExpressADData2));
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        a.a.a.a.x.d.a();
        a.a.a.a.x.f.g.c.a(this.f1177e.f1013g.f1393a, "render_failed", new Object[0]);
        this.f1177e.b(0, "RenderFail");
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        a.a.a.a.x.d.a();
        this.f1177e.f1013g.e();
        this.f1177e.m.put(this.f1175c, this.f1176d);
        b bVar = this.f1177e;
        bVar.a((b) this.f1175c);
        bVar.h();
    }
}
