package a.a.a.a.t.a.a;

import a.a.a.a.m;
import a.a.a.a.o;
import a.a.a.a.u.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class c implements o.a {
    @Override // a.a.a.a.o.a
    public m a(e.a aVar) {
        char c2;
        String str = aVar.f1335d;
        int hashCode = str.hashCode();
        if (hashCode == -1900686778) {
            if (str.equals(FunAdType.JY_NATIVE)) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != -39027267) {
            if (hashCode == 1872382491 && str.equals(FunAdType.JY_INTERSTITIAL)) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return null;
                }
                return new a.a.a.a.t.a.d.c(aVar);
            }
            return new a.a.a.a.t.a.d.a(aVar);
        }
        return new a.a.a.a.t.a.d.b(aVar);
    }
}
