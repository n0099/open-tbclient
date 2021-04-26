package a.a.a.a;

import com.fun.ad.sdk.FunAdInteractionListener;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<K, k<K, V>.a> f1068a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final c<?> f1069b;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1070a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1071b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1072c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1073d;

        /* renamed from: e  reason: collision with root package name */
        public FunAdInteractionListener f1074e;

        public a(String str, V v) {
            this.f1070a = str;
        }
    }

    public k(c<?> cVar) {
        this.f1069b = cVar;
    }

    public final void a(K k) {
        synchronized (this.f1068a) {
            this.f1068a.remove(k);
        }
    }

    public final void a(K k, String str, V v, FunAdInteractionListener funAdInteractionListener) {
        synchronized (this.f1068a) {
            k<K, V>.a aVar = this.f1068a.get(k);
            if (aVar == null) {
                aVar = new a(str, v);
                this.f1068a.put(k, aVar);
            }
            a.a.a.a.x.f.g.c cVar = k.this.f1069b.f1013g;
            a.a.a.a.x.f.g.c.a("ad", cVar.f1393a, "sh_start", aVar.f1071b, new Object[0]);
            aVar.f1071b = true;
            aVar.f1074e = funAdInteractionListener;
        }
    }

    public final void b(K k) {
        synchronized (this.f1068a) {
            k<K, V>.a aVar = this.f1068a.get(k);
            if (aVar == null) {
                return;
            }
            k.this.f1069b.f1013g.a(aVar.f1073d);
            aVar.f1073d = true;
            FunAdInteractionListener funAdInteractionListener = aVar.f1074e;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(aVar.f1070a);
            }
        }
    }

    public final void c(K k) {
        synchronized (this.f1068a) {
            k<K, V>.a aVar = this.f1068a.get(k);
            if (aVar == null) {
                return;
            }
            k.this.f1069b.f1013g.b(aVar.f1072c);
            aVar.f1072c = true;
            FunAdInteractionListener funAdInteractionListener = aVar.f1074e;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(aVar.f1070a);
            }
        }
    }
}
