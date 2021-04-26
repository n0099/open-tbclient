package a.a.a.a;

import a.a.a.a.u.e;
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
public abstract class c<A> implements m {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f1007a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f1008b;

    /* renamed from: c  reason: collision with root package name */
    public final List<A> f1009c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1010d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1011e;

    /* renamed from: f  reason: collision with root package name */
    public a.a.a.a.w.p f1012f;

    /* renamed from: g  reason: collision with root package name */
    public final a.a.a.a.x.f.g.c f1013g;

    /* renamed from: h  reason: collision with root package name */
    public final e.a f1014h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1015i;
    public final boolean j;
    public final a.a.a.a.w.a k;
    public boolean l;

    public c(e.a aVar) {
        this(aVar, true, false);
    }

    public c(e.a aVar, boolean z) {
        this(aVar, z, false);
    }

    public c(e.a aVar, boolean z, boolean z2) {
        this.f1007a = new ArrayList();
        this.f1008b = new ArrayList();
        this.f1009c = new ArrayList();
        this.f1010d = true;
        this.f1011e = true;
        this.f1013g = new a.a.a.a.x.f.g.c();
        if (aVar == null) {
            throw new IllegalArgumentException();
        }
        this.f1014h = aVar;
        this.f1015i = z;
        this.j = z2;
        this.k = a(aVar);
    }

    public a.a.a.a.w.a a(e.a aVar) {
        return a.a.a.a.w.b.f1354c;
    }

    public FunNativeAd a(Context context, String str, A a2) {
        return null;
    }

    @Override // a.a.a.a.m
    public synchronized void a() {
        this.f1010d = true;
        this.f1012f = null;
        Iterator<A> it = this.f1008b.iterator();
        while (it.hasNext()) {
            A next = it.next();
            b(next);
            this.k.a(next);
            it.remove();
        }
        if (!this.f1015i) {
            Iterator<A> it2 = this.f1009c.iterator();
            while (it2.hasNext()) {
                A next2 = it2.next();
                b(next2);
                this.k.a(next2);
                it2.remove();
            }
        }
    }

    public void a(int i2, String str) {
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.a(i2, str);
            }
        }
    }

    @Override // a.a.a.a.m
    public void a(n nVar) {
        synchronized (this.f1007a) {
            this.f1007a.add(nVar);
        }
    }

    public final void a(A a2) {
        if (this.f1015i || !this.f1010d) {
            this.f1009c.add(a2);
        } else {
            b(a2);
        }
    }

    public void a(A a2, String str) {
        this.k.a(a2, str);
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.onAdShow();
            }
        }
    }

    @Override // a.a.a.a.m
    public final synchronized boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        if (c()) {
            if (this.f1009c.isEmpty()) {
                return false;
            }
            this.f1012f = null;
            A remove = this.f1009c.remove(0);
            if (remove == null) {
                return false;
            }
            this.f1008b.add(remove);
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

    @Override // a.a.a.a.m
    public final synchronized boolean a(Context context, FunAdSlot funAdSlot) {
        this.f1010d = false;
        if (this.l) {
            return false;
        }
        this.f1012f = null;
        this.l = true;
        this.f1008b.addAll(this.f1009c);
        this.f1009c.clear();
        b(context, funAdSlot);
        return true;
    }

    @Override // a.a.a.a.m
    public e.a b() {
        return this.f1014h;
    }

    public void b(int i2, String str) {
        this.l = false;
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.onError(i2, str);
            }
        }
    }

    public abstract void b(Context context, FunAdSlot funAdSlot);

    public abstract void b(A a2);

    @Override // a.a.a.a.m
    public final synchronized boolean c() {
        boolean z;
        Iterator<A> it = this.f1009c.iterator();
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

    @Override // a.a.a.a.m
    public final synchronized a.a.a.a.w.p d() {
        if (this.f1011e) {
            if (c()) {
                if (this.f1009c.isEmpty()) {
                    return null;
                }
                a.a.a.a.w.p pVar = this.f1012f;
                if (pVar != null) {
                    return pVar;
                }
                a.a.a.a.w.p b2 = this.k.b(this.f1009c.get(0));
                if (b2 == null) {
                    this.f1011e = false;
                    return null;
                }
                this.f1012f = b2;
                return b2;
            }
            return null;
        }
        return null;
    }

    public void e() {
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.onAdClicked();
            }
        }
    }

    public void f() {
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.onAdClose();
            }
        }
    }

    public void g() {
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.b();
            }
        }
    }

    @Override // a.a.a.a.m
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        if (this.j) {
            if (c()) {
                if (this.f1009c.isEmpty()) {
                    return null;
                }
                this.f1012f = null;
                A remove = this.f1009c.remove(0);
                if (remove == null) {
                    return null;
                }
                this.f1008b.add(remove);
                return a(context, str, remove);
            }
            return null;
        }
        return null;
    }

    public void h() {
        this.l = false;
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.onLoaded();
            }
        }
    }

    public void i() {
        synchronized (this.f1007a) {
            for (n nVar : this.f1007a) {
                nVar.a();
            }
        }
    }
}
