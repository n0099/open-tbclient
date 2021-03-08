package a.a.a.a.r.a.b;

import a.a.a.a.a.e;
import a.a.a.a.l;
import a.a.a.a.n;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes4.dex */
public class a implements n.a {
    @Override // a.a.a.a.n.a
    public l b(e.a aVar) {
        if (FunAdType.BAIDU_NATIVE_CPU.equals(aVar.d)) {
            return new a.a.a.a.r.a.a.a(aVar);
        }
        a.a.a.a.v.d.b("Not supported pid.type:%s", aVar.d);
        return null;
    }
}
