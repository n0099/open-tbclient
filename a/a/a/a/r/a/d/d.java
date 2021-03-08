package a.a.a.a.r.a.d;

import com.qq.e.ads.nativ.express2.MediaEventListener;
/* loaded from: classes4.dex */
public class d implements MediaEventListener {
    public final /* synthetic */ b AB;

    public d(b bVar) {
        this.AB = bVar;
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoCache() {
        a.a.a.a.v.d.a();
        this.AB.zk.c();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoComplete() {
        a.a.a.a.v.d.a();
        this.AB.zk.i();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoError() {
        a.a.a.a.v.d.a();
        this.AB.zk.j();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoPause() {
        a.a.a.a.v.d.a();
        this.AB.zk.l();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoResume() {
        a.a.a.a.v.d.a();
        this.AB.zk.k();
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoStart() {
        a.a.a.a.v.d.a();
        this.AB.zk.n();
    }
}
