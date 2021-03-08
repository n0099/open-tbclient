package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import com.bytedance.sdk.openadsdk.TTAdNative;
/* loaded from: classes4.dex */
public abstract class e<A> extends a.a.a.a.c<A> {
    public TTAdNative Ae;

    public e(e.a aVar) {
        this(aVar, false);
    }

    public e(e.a aVar, boolean z) {
        super(aVar, false, z);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.d(aVar);
    }

    @Override // a.a.a.a.c, a.a.a.a.l
    public synchronized void a() {
        super.a();
        this.Ae = null;
    }
}
