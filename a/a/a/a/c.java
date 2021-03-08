package a.a.a.a;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class c<A> implements l {

    /* renamed from: a  reason: collision with root package name */
    public final List<m> f959a;
    public final List<A> b;
    public final List<A> c;
    public boolean d;
    public boolean e;
    public final boolean i;
    public final boolean j;
    public boolean l;
    public a.a.a.a.c.p zj;
    public final a.a.a.a.v.f.g.c zk;
    public final e.a zl;
    public final a.a.a.a.c.a zm;

    public c(e.a aVar) {
        this(aVar, true, false);
    }

    public c(e.a aVar, boolean z) {
        this(aVar, z, false);
    }

    public c(e.a aVar, boolean z, boolean z2) {
        this.f959a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = true;
        this.e = true;
        this.zk = new a.a.a.a.v.f.g.c();
        if (aVar == null) {
            throw new IllegalArgumentException();
        }
        this.zl = aVar;
        this.i = z;
        this.j = z2;
        this.zm = a(aVar);
    }

    public a.a.a.a.c.a a(e.a aVar) {
        return a.a.a.a.c.c.BL;
    }

    public FunNativeAd a(Context context, String str, A a2) {
        return null;
    }

    @Override // a.a.a.a.l
    public synchronized void a() {
        this.d = true;
        this.zj = null;
        Iterator<A> it = this.b.iterator();
        while (it.hasNext()) {
            A next = it.next();
            b(next);
            this.zm.a(next);
            it.remove();
        }
        if (!this.i) {
            Iterator<A> it2 = this.c.iterator();
            while (it2.hasNext()) {
                A next2 = it2.next();
                b(next2);
                this.zm.a(next2);
                it2.remove();
            }
        }
    }

    public void a(int i, String str) {
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.a(i, str);
            }
        }
    }

    @Override // a.a.a.a.l
    public void a(m mVar) {
        synchronized (this.f959a) {
            this.f959a.add(mVar);
        }
    }

    public abstract void a(Context context, FunAdSlot funAdSlot);

    public final void a(A a2) {
        if (this.i || !this.d) {
            this.c.add(a2);
        } else {
            b(a2);
        }
    }

    public void a(A a2, String str) {
        this.zm.a(a2, str);
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.onAdShow();
            }
        }
    }

    @Override // a.a.a.a.l
    public final synchronized boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        boolean z = false;
        synchronized (this) {
            if (c() && !this.c.isEmpty()) {
                this.zj = null;
                A remove = this.c.remove(0);
                if (remove != null) {
                    this.b.add(remove);
                    z = funNativeAdInflater == null ? a(activity, viewGroup, str, (String) remove) : a(activity, str, funNativeAdInflater, (FunNativeAdInflater) remove);
                }
            }
        }
        return z;
    }

    public abstract boolean a(Activity activity, ViewGroup viewGroup, String str, A a2);

    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a2) {
        return false;
    }

    public void b(int i, String str) {
        this.l = false;
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.onError(i, str);
            }
        }
    }

    @Override // a.a.a.a.l
    public final synchronized void b(Context context, FunAdSlot funAdSlot) {
        this.d = false;
        if (!this.l) {
            this.zj = null;
            this.l = true;
            this.b.addAll(this.c);
            this.c.clear();
            a(context, funAdSlot);
        }
    }

    public abstract void b(A a2);

    @Override // a.a.a.a.l
    public final synchronized boolean c() {
        boolean z;
        Iterator<A> it = this.c.iterator();
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

    public void e() {
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.onAdClicked();
            }
        }
    }

    public void f() {
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.onAdClose();
            }
        }
    }

    public void g() {
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.b();
            }
        }
    }

    @Override // a.a.a.a.l
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        FunNativeAd funNativeAd = null;
        synchronized (this) {
            if (this.j && c() && !this.c.isEmpty()) {
                this.zj = null;
                A remove = this.c.remove(0);
                if (remove != null) {
                    this.b.add(remove);
                    funNativeAd = a(context, str, remove);
                }
            }
        }
        return funNativeAd;
    }

    public void h() {
        this.l = false;
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.onLoaded();
            }
        }
    }

    @Override // a.a.a.a.l
    public e.a hq() {
        return this.zl;
    }

    public void i() {
        synchronized (this.f959a) {
            for (m mVar : this.f959a) {
                mVar.a();
            }
        }
    }

    @Override // a.a.a.a.l
    public final synchronized a.a.a.a.c.p hr() {
        a.a.a.a.c.p pVar = null;
        synchronized (this) {
            if (this.e && c() && !this.c.isEmpty()) {
                a.a.a.a.c.p pVar2 = this.zj;
                if (pVar2 != null) {
                    pVar = pVar2;
                } else {
                    a.a.a.a.c.p i = this.zm.i(this.c.get(0));
                    if (i == null) {
                        this.e = false;
                    } else {
                        this.zj = i;
                        pVar = i;
                    }
                }
            }
        }
        return pVar;
    }
}
