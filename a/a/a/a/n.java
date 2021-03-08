package a.a.a.a;

import a.a.a.a.a.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f968a;
    public final Map<e.a, l> b = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        l b(e.a aVar);
    }

    public n(Map<String, a> map) {
        this.f968a = map;
    }

    public l b(e.a aVar) {
        synchronized (this.b) {
            l lVar = this.b.get(aVar);
            if (lVar != null) {
                return lVar;
            }
            a aVar2 = this.f968a.get(aVar.BI.c);
            if (aVar2 == null) {
                a.a.a.a.v.d.a("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", aVar.d);
                return null;
            }
            l b = aVar2.b(aVar);
            if (b == null) {
                a.a.a.a.v.d.a("The creator of ssp:%s should't create null for pid:%s", aVar.BI.c, aVar.d);
                return null;
            }
            d dVar = new d(b);
            this.b.put(aVar, dVar);
            return dVar;
        }
    }
}
