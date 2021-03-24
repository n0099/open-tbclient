package a.a.a.a;

import a.a.a.a.s.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f1079a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, k> f1080b = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        k a(e.a aVar);
    }

    public m(Map<String, a> map) {
        this.f1079a = map;
    }

    public k a(e.a aVar) {
        synchronized (this.f1080b) {
            k kVar = this.f1080b.get(aVar);
            if (kVar != null) {
                return kVar;
            }
            a aVar2 = this.f1079a.get(aVar.k.f1331c);
            if (aVar2 == null) {
                a.a.a.a.v.d.a("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", aVar.f1335d);
                return null;
            }
            k a2 = aVar2.a(aVar);
            if (a2 == null) {
                a.a.a.a.v.d.a("The creator of ssp:%s should't create null for pid:%s", aVar.k.f1331c, aVar.f1335d);
                return null;
            }
            c cVar = new c(a2);
            this.f1080b.put(aVar, cVar);
            return cVar;
        }
    }
}
