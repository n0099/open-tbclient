package a.a.a.a.t.a.c;

import com.qq.e.ads.nativ.express2.MediaEventListener;
/* loaded from: classes.dex */
public class d implements MediaEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1178a;

    public d(b bVar) {
        this.f1178a = bVar;
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoCache() {
        a.a.a.a.x.d.a();
        this.f1178a.f1013g.c();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoComplete() {
        a.a.a.a.x.d.a();
        this.f1178a.f1013g.i();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoError() {
        a.a.a.a.x.d.a();
        this.f1178a.f1013g.j();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoPause() {
        a.a.a.a.x.d.a();
        this.f1178a.f1013g.l();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoResume() {
        a.a.a.a.x.d.a();
        this.f1178a.f1013g.k();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoStart() {
        a.a.a.a.x.d.a();
        this.f1178a.f1013g.n();
    }
}
