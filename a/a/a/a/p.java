package a.a.a.a;

import a.a.a.a.v.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f1097a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, n> f1098b = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        n a(e.a aVar);
    }

    public p(Map<String, a> map) {
        this.f1097a = map;
    }

    public n a(e.a aVar) {
        synchronized (this.f1098b) {
            n nVar = this.f1098b.get(aVar);
            if (nVar != null) {
                return nVar;
            }
            a aVar2 = this.f1097a.get(aVar.k.f1339c);
            if (aVar2 == null) {
                a.a.a.a.y.d.a("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", aVar.f1343d);
                return null;
            }
            n a2 = aVar2.a(aVar);
            if (a2 == null) {
                a.a.a.a.y.d.a("The creator of ssp:%s should't create null for pid:%s", aVar.k.f1339c, aVar.f1343d);
                return null;
            }
            e eVar = new e(a2);
            this.f1098b.put(aVar, eVar);
            return eVar;
        }
    }
}
