package a.a.a.a;

import a.a.a.a.u.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f1094a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, m> f1095b = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        m a(e.a aVar);
    }

    public o(Map<String, a> map) {
        this.f1094a = map;
    }

    public m a(e.a aVar) {
        synchronized (this.f1095b) {
            m mVar = this.f1095b.get(aVar);
            if (mVar != null) {
                return mVar;
            }
            a aVar2 = this.f1094a.get(aVar.k.f1331c);
            if (aVar2 == null) {
                a.a.a.a.x.d.a("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", aVar.f1335d);
                return null;
            }
            m a2 = aVar2.a(aVar);
            if (a2 == null) {
                a.a.a.a.x.d.a("The creator of ssp:%s should't create null for pid:%s", aVar.k.f1331c, aVar.f1335d);
                return null;
            }
            d dVar = new d(a2);
            this.f1095b.put(aVar, dVar);
            return dVar;
        }
    }
}
