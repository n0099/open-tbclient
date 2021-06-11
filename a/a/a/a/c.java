package a.a.a.a;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<A> implements n {

    /* renamed from: a  reason: collision with root package name */
    public final List<o> f1007a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f1008b;

    /* renamed from: c  reason: collision with root package name */
    public final List<A> f1009c;

    /* renamed from: d  reason: collision with root package name */
    public final c<A>.b f1010d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1011e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1012f;

    /* renamed from: g  reason: collision with root package name */
    public a.a.a.a.x.p f1013g;

    /* renamed from: h  reason: collision with root package name */
    public final a.a.a.a.y.f.g.c f1014h;

    /* renamed from: i  reason: collision with root package name */
    public final e.a f1015i;
    public final boolean j;
    public final boolean k;
    public final a.a.a.a.x.a l;
    public boolean m;

    /* loaded from: classes.dex */
    public class b {
        public b() {
        }
    }

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
        this.f1010d = new b();
        this.f1011e = true;
        this.f1012f = true;
        this.f1014h = new a.a.a.a.y.f.g.c();
        if (aVar == null) {
            throw new IllegalArgumentException();
        }
        this.f1015i = aVar;
        this.j = z;
        this.k = z2;
        this.l = a(aVar);
    }

    public a.a.a.a.x.a a(e.a aVar) {
        return a.a.a.a.x.b.f1362c;
    }

    public FunNativeAd a(Context context, String str, A a2) {
        return null;
    }

    @Override // a.a.a.a.n
    public synchronized void a() {
        this.f1011e = true;
        this.f1013g = null;
        Iterator<A> it = this.f1008b.iterator();
        while (it.hasNext()) {
            A next = it.next();
            b(next);
            this.l.a(next);
            it.remove();
        }
        if (!this.j) {
            Iterator<A> it2 = this.f1009c.iterator();
            while (it2.hasNext()) {
                A next2 = it2.next();
                b(next2);
                this.l.a(next2);
                it2.remove();
            }
        }
    }

    public void a(int i2, String str) {
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdShowError(aVar.f1343d, aVar.f1342c, aVar.k.f1338b, i2, str);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.a(i2, str);
                }
            }
            return;
        }
        throw null;
    }

    @Override // a.a.a.a.n
    public void a(o oVar) {
        synchronized (this.f1007a) {
            this.f1007a.add(oVar);
        }
    }

    public final void a(A a2) {
        if (this.j || !this.f1011e) {
            this.f1009c.add(a2);
        } else {
            b(a2);
        }
    }

    public final void a(List<A> list) {
        for (A a2 : list) {
            a((c<A>) a2);
        }
        h();
    }

    @Override // a.a.a.a.n
    public final synchronized boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        if (c()) {
            if (this.f1009c.isEmpty()) {
                return false;
            }
            this.f1013g = null;
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

    @Override // a.a.a.a.n
    public final synchronized boolean a(Context context, FunAdSlot funAdSlot) {
        this.f1011e = false;
        if (this.m) {
            return false;
        }
        this.f1013g = null;
        this.m = true;
        this.f1008b.addAll(this.f1009c);
        this.f1009c.clear();
        b(context, funAdSlot);
        return true;
    }

    @Override // a.a.a.a.n
    public e.a b() {
        return this.f1015i;
    }

    public void b(int i2, String str) {
        this.m = false;
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdLoadError(aVar.f1343d, aVar.f1342c, aVar.k.f1338b, i2, str);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.onError(i2, str);
                }
            }
            return;
        }
        throw null;
    }

    public abstract void b(Context context, FunAdSlot funAdSlot);

    public abstract void b(A a2);

    @Override // a.a.a.a.n
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

    @Override // a.a.a.a.n
    public final synchronized a.a.a.a.x.p d() {
        if (this.f1012f) {
            if (c()) {
                if (this.f1009c.isEmpty()) {
                    return null;
                }
                a.a.a.a.x.p pVar = this.f1013g;
                if (pVar != null) {
                    return pVar;
                }
                a.a.a.a.x.p b2 = this.l.b(this.f1009c.get(0));
                if (b2 == null) {
                    this.f1012f = false;
                    return null;
                }
                this.f1013g = b2;
                return b2;
            }
            return null;
        }
        return null;
    }

    public void e() {
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdClicked(aVar.f1343d, aVar.f1342c, aVar.k.f1338b);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.onAdClicked();
                }
            }
            return;
        }
        throw null;
    }

    public void f() {
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdClose(aVar.f1343d, aVar.f1342c, aVar.k.f1338b);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.onAdClose();
                }
            }
            return;
        }
        throw null;
    }

    public void g() {
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdLoad(aVar.f1343d, aVar.f1342c, aVar.k.f1338b);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.b();
                }
            }
            return;
        }
        throw null;
    }

    @Override // a.a.a.a.n
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        if (this.k) {
            if (c()) {
                if (this.f1009c.isEmpty()) {
                    return null;
                }
                this.f1013g = null;
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
        this.m = false;
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdLoaded(aVar.f1343d, aVar.f1342c, aVar.k.f1338b);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.onLoaded();
                }
            }
            return;
        }
        throw null;
    }

    public void i() {
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onRewardedVideo(aVar.f1343d, aVar.f1342c, aVar.k.f1338b);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.a();
                }
            }
            return;
        }
        throw null;
    }

    public void a(A a2, String str) {
        this.l.a(a2, str);
        c<A>.b bVar = this.f1010d;
        if (bVar != null) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                e.a aVar = c.this.f1015i;
                adCallback.onAdShow(aVar.f1343d, aVar.f1342c, aVar.k.f1338b);
            }
            synchronized (this.f1007a) {
                for (o oVar : this.f1007a) {
                    oVar.onAdShow();
                }
            }
            return;
        }
        throw null;
    }
}
