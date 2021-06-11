package a.a.a.a;

import com.fun.ad.sdk.FunAdInteractionListener;
import java.util.HashMap;
/* loaded from: classes.dex */
public class l<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<K, l<K, V>.a> f1072a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final c<?> f1073b;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1074a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1075b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1076c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1077d;

        /* renamed from: e  reason: collision with root package name */
        public FunAdInteractionListener f1078e;

        public a(String str, V v) {
            this.f1074a = str;
        }
    }

    public l(c<?> cVar) {
        this.f1073b = cVar;
    }

    public final void a(K k) {
        synchronized (this.f1072a) {
            this.f1072a.remove(k);
        }
    }

    public final void a(K k, String str, V v, FunAdInteractionListener funAdInteractionListener) {
        synchronized (this.f1072a) {
            l<K, V>.a aVar = this.f1072a.get(k);
            if (aVar == null) {
                aVar = new a(str, v);
                this.f1072a.put(k, aVar);
            }
            a.a.a.a.y.f.g.c.a(aVar.f1075b, l.this.f1073b.f1014h.f1406a, "sh_start", new Object[0]);
            aVar.f1075b = true;
            aVar.f1078e = funAdInteractionListener;
        }
    }

    public final void b(K k) {
        synchronized (this.f1072a) {
            l<K, V>.a aVar = this.f1072a.get(k);
            if (aVar == null) {
                return;
            }
            l.this.f1073b.f1014h.a(aVar.f1077d);
            aVar.f1077d = true;
            FunAdInteractionListener funAdInteractionListener = aVar.f1078e;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(aVar.f1074a);
            }
        }
    }

    public final void c(K k) {
        synchronized (this.f1072a) {
            l<K, V>.a aVar = this.f1072a.get(k);
            if (aVar == null) {
                return;
            }
            l.this.f1073b.f1014h.b(aVar.f1076c);
            aVar.f1076c = true;
            FunAdInteractionListener funAdInteractionListener = aVar.f1078e;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(aVar.f1074a);
            }
        }
    }
}
