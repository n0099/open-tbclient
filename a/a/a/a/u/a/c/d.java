package a.a.a.a.u.a.c;

import com.qq.e.ads.nativ.express2.MediaEventListener;
/* loaded from: classes.dex */
public class d implements MediaEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1181a;

    public d(b bVar) {
        this.f1181a = bVar;
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoCache() {
        a.a.a.a.y.d.a();
        this.f1181a.f1014h.c();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoComplete() {
        a.a.a.a.y.d.a();
        this.f1181a.f1014h.j();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoError() {
        a.a.a.a.y.d.a();
        this.f1181a.f1014h.k();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoPause() {
        a.a.a.a.y.d.a();
        this.f1181a.f1014h.m();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoResume() {
        a.a.a.a.y.d.a();
        this.f1181a.f1014h.l();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoStart() {
        a.a.a.a.y.d.a();
        this.f1181a.f1014h.o();
    }
}
