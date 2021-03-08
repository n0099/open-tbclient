package a.a.a.a.r.a.d;

import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes4.dex */
public class c implements AdEventListener {
    public final /* synthetic */ b AA;
    public final /* synthetic */ NativeExpressADData2 Az;

    /* renamed from: a  reason: collision with root package name */
    public boolean f983a;
    public boolean b;
    public final /* synthetic */ String d;

    public c(b bVar, NativeExpressADData2 nativeExpressADData2, String str) {
        this.AA = bVar;
        this.Az = nativeExpressADData2;
        this.d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        a.a.a.a.v.d.a();
        this.AA.zk.d();
        this.AA.f();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        a.a.a.a.v.d.a();
        this.AA.zk.a(this.b);
        this.b = true;
        this.AA.e();
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        a.a.a.a.v.d.b();
        this.AA.zk.b(this.f983a);
        this.f983a = true;
        b bVar = this.AA;
        NativeExpressADData2 nativeExpressADData2 = this.Az;
        bVar.a((b) nativeExpressADData2, bVar.m.remove(nativeExpressADData2));
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.AA.zk.BU, "render_failed", new Object[0]);
        this.AA.b(0, "RenderFail");
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        a.a.a.a.v.d.a();
        this.AA.zk.e();
        this.AA.m.put(this.Az, this.d);
        b bVar = this.AA;
        bVar.a((b) this.Az);
        bVar.h();
    }
}
