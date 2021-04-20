package a.a.a.a;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<A> implements k {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f1004a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f1005b;

    /* renamed from: c  reason: collision with root package name */
    public final List<A> f1006c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1007d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1008e;

    /* renamed from: f  reason: collision with root package name */
    public a.a.a.a.u.o f1009f;

    /* renamed from: g  reason: collision with root package name */
    public final a.a.a.a.v.f.g.c f1010g;

    /* renamed from: h  reason: collision with root package name */
    public final e.a f1011h;
    public final boolean i;
    public final boolean j;
    public final a.a.a.a.u.a k;
    public boolean l;

    public b(e.a aVar) {
        this(aVar, true, false);
    }

    public b(e.a aVar, boolean z) {
        this(aVar, z, false);
    }

    public b(e.a aVar, boolean z, boolean z2) {
        this.f1004a = new ArrayList();
        this.f1005b = new ArrayList();
        this.f1006c = new ArrayList();
        this.f1007d = true;
        this.f1008e = true;
        this.f1010g = new a.a.a.a.v.f.g.c();
        if (aVar == null) {
            throw new IllegalArgumentException();
        }
        this.f1011h = aVar;
        this.i = z;
        this.j = z2;
        this.k = a(aVar);
    }

    public a.a.a.a.u.a a(e.a aVar) {
        return a.a.a.a.u.b.f1339c;
    }

    public FunNativeAd a(Context context, String str, A a2) {
        return null;
    }

    @Override // a.a.a.a.k
    public synchronized void a() {
        this.f1007d = true;
        this.f1009f = null;
        Iterator<A> it = this.f1005b.iterator();
        while (it.hasNext()) {
            A next = it.next();
            b(next);
            this.k.a(next);
            it.remove();
        }
        if (!this.i) {
            Iterator<A> it2 = this.f1006c.iterator();
            while (it2.hasNext()) {
                A next2 = it2.next();
                b(next2);
                this.k.a(next2);
                it2.remove();
            }
        }
    }

    public void a(int i, String str) {
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.a(i, str);
            }
        }
    }

    @Override // a.a.a.a.k
    public void a(l lVar) {
        synchronized (this.f1004a) {
            this.f1004a.add(lVar);
        }
    }

    @Override // a.a.a.a.k
    public final synchronized void a(Context context, FunAdSlot funAdSlot) {
        this.f1007d = false;
        if (this.l) {
            return;
        }
        this.f1009f = null;
        this.l = true;
        this.f1005b.addAll(this.f1006c);
        this.f1006c.clear();
        b(context, funAdSlot);
    }

    public final void a(A a2) {
        if (this.i || !this.f1007d) {
            this.f1006c.add(a2);
        } else {
            b(a2);
        }
    }

    public void a(A a2, String str) {
        this.k.a(a2, str);
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.onAdShow();
            }
        }
    }

    @Override // a.a.a.a.k
    public final synchronized boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        if (c()) {
            if (this.f1006c.isEmpty()) {
                return false;
            }
            this.f1009f = null;
            A remove = this.f1006c.remove(0);
            if (remove == null) {
                return false;
            }
            this.f1005b.add(remove);
            if (funNativeAdInflater == null) {
                return a(activity, viewGroup, str, (String) remove);
            }
            return a(activity, str, funNativeAdInflater, (FunNativeAdInflater) remove);
        }
        return false;
    }

    public abstract boolean a(Activity activity, ViewGroup viewGroup, String str, A a2);

    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a2) {
        return false;
    }

    @Override // a.a.a.a.k
    public e.a b() {
        return this.f1011h;
    }

    public void b(int i, String str) {
        this.l = false;
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.onError(i, str);
            }
        }
    }

    public abstract void b(Context context, FunAdSlot funAdSlot);

    public abstract void b(A a2);

    @Override // a.a.a.a.k
    public final synchronized boolean c() {
        boolean z;
        Iterator<A> it = this.f1006c.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (c(it.next())) {
                z = true;
                break;
            } else {
                it.remove();
            }
        }
        return z;
    }

    public boolean c(A a2) {
        return a2 != null;
    }

    @Override // a.a.a.a.k
    public final synchronized a.a.a.a.u.o d() {
        if (this.f1008e) {
            if (c()) {
                if (this.f1006c.isEmpty()) {
                    return null;
                }
                a.a.a.a.u.o oVar = this.f1009f;
                if (oVar != null) {
                    return oVar;
                }
                a.a.a.a.u.o b2 = this.k.b(this.f1006c.get(0));
                if (b2 == null) {
                    this.f1008e = false;
                    return null;
                }
                this.f1009f = b2;
                return b2;
            }
            return null;
        }
        return null;
    }

    public void e() {
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.onAdClicked();
            }
        }
    }

    public void f() {
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.onAdClose();
            }
        }
    }

    public void g() {
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.b();
            }
        }
    }

    @Override // a.a.a.a.k
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        if (this.j) {
            if (c()) {
                if (this.f1006c.isEmpty()) {
                    return null;
                }
                this.f1009f = null;
                A remove = this.f1006c.remove(0);
                if (remove == null) {
                    return null;
                }
                this.f1005b.add(remove);
                return a(context, str, remove);
            }
            return null;
        }
        return null;
    }

    public void h() {
        this.l = false;
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.onLoaded();
            }
        }
    }

    public void i() {
        synchronized (this.f1004a) {
            for (l lVar : this.f1004a) {
                lVar.a();
            }
        }
    }
}
