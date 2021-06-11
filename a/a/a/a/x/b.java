package a.a.a.a.x;

import a.a.a.a.v.e;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes.dex */
public abstract class b implements a {

    /* renamed from: c  reason: collision with root package name */
    public static a f1362c = new d();

    /* renamed from: d  reason: collision with root package name */
    public static final Random f1363d = new Random();

    /* renamed from: a  reason: collision with root package name */
    public final e.a f1364a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, p> f1365b = new HashMap<>();

    public b(e.a aVar) {
        this.f1364a = aVar;
    }

    @Override // a.a.a.a.x.a
    public final void a(Object obj) {
        synchronized (this.f1365b) {
            this.f1365b.remove(obj);
        }
    }

    @Override // a.a.a.a.x.a
    public void a(Object obj, String str) {
    }

    @Override // a.a.a.a.x.a
    public final p b(Object obj) {
        synchronized (this.f1365b) {
            p pVar = this.f1365b.get(obj);
            if (pVar != null) {
                return pVar;
            }
            p c2 = c(obj);
            if (c2 == null) {
                return null;
            }
            this.f1365b.put(obj, c2);
            return c2;
        }
    }

    @Override // a.a.a.a.x.a
    public final void b(Object obj, String str) {
        p c2;
        if (a.a.a.a.d.f1017a.booleanValue() && obj != null && f1363d.nextFloat() < this.f1364a.f1345f && (c2 = c(obj)) != null) {
            synchronized (this.f1365b) {
                this.f1365b.put(obj, c2);
            }
        }
    }

    public abstract p c(Object obj);
}
