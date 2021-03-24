package a.a.a.a.r.a.b;

import a.a.a.a.k;
import a.a.a.a.m;
import a.a.a.a.s.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class a implements m.a {
    @Override // a.a.a.a.m.a
    public k a(e.a aVar) {
        if (FunAdType.BAIDU_NATIVE_CPU.equals(aVar.f1335d)) {
            return new a.a.a.a.r.a.a.a(aVar);
        }
        a.a.a.a.v.d.b("Not supported pid.type:%s", aVar.f1335d);
        return null;
    }
}
