package a.a.a.a.r.a.d;

import com.qq.e.ads.nativ.express2.MediaEventListener;
/* loaded from: classes.dex */
public class d implements MediaEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1169a;

    public d(b bVar) {
        this.f1169a = bVar;
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoCache() {
        a.a.a.a.v.d.a();
        this.f1169a.f1010g.c();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.f1169a.f1010g.i();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoError() {
        a.a.a.a.v.d.a();
        this.f1169a.f1010g.j();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoPause() {
        a.a.a.a.v.d.a();
        this.f1169a.f1010g.l();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoResume() {
        a.a.a.a.v.d.a();
        this.f1169a.f1010g.k();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoStart() {
        a.a.a.a.v.d.a();
        this.f1169a.f1010g.n();
    }
}
