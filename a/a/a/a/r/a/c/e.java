package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
import com.bytedance.sdk.openadsdk.TTAdNative;
/* loaded from: classes.dex */
public abstract class e<A> extends a.a.a.a.b<A> {
    public TTAdNative m;

    public e(e.a aVar) {
        this(aVar, false);
    }

    public e(e.a aVar, boolean z) {
        super(aVar, false, z);
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.d(aVar);
    }

    @Override // a.a.a.a.b, a.a.a.a.k
    public synchronized void a() {
        super.a();
        this.m = null;
    }
}
