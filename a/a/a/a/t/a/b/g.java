package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import com.bytedance.sdk.openadsdk.TTAdNative;
/* loaded from: classes.dex */
public abstract class g<A> extends a.a.a.a.c<A> {
    public TTAdNative m;

    public g(e.a aVar) {
        this(aVar, false);
    }

    public g(e.a aVar, boolean z) {
        super(aVar, false, z);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.c(aVar);
    }

    @Override // a.a.a.a.c, a.a.a.a.m
    public synchronized void a() {
        super.a();
        this.m = null;
    }
}
