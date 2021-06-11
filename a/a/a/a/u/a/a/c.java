package a.a.a.a.u.a.a;

import a.a.a.a.n;
import a.a.a.a.p;
import a.a.a.a.v.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class c implements p.a {
    @Override // a.a.a.a.p.a
    public n a(e.a aVar) {
        char c2;
        String str = aVar.f1343d;
        int hashCode = str.hashCode();
        if (hashCode == -1900686778) {
            if (str.equals(FunAdType.JY_NATIVE)) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode == -1743934314) {
            if (str.equals(FunAdType.JY_SPLASH)) {
                c2 = 3;
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
                    if (c2 != 3) {
                        return null;
                    }
                    return new a.a.a.a.u.a.d.d(aVar);
                }
                return new a.a.a.a.u.a.d.c(aVar);
            }
            return new a.a.a.a.u.a.d.a(aVar);
        }
        return new a.a.a.a.u.a.d.b(aVar);
    }
}
