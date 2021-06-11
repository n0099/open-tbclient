package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
import com.bytedance.sdk.openadsdk.TTAdNative;
/* loaded from: classes.dex */
public abstract class g<A> extends a.a.a.a.c<A> {
    public TTAdNative n;

    public g(e.a aVar) {
        this(aVar, false);
    }

    public g(e.a aVar, boolean z) {
        super(aVar, false, z);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.c(aVar);
    }

    @Override // a.a.a.a.c, a.a.a.a.n
    public synchronized void a() {
        super.a();
        this.n = null;
    }
}
