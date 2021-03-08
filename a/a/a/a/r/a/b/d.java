package a.a.a.a.r.a.b;

import a.a.a.a.a.e;
import a.a.a.a.l;
import a.a.a.a.n;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes4.dex */
public class d implements n.a {
    @Override // a.a.a.a.n.a
    public l b(e.a aVar) {
        String str = aVar.d;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1900686778) {
            if (hashCode != -39027267) {
                if (hashCode == 1872382491 && str.equals(FunAdType.JY_INTERSTITIAL)) {
                    c = 1;
                }
            } else if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                c = 2;
            }
        } else if (str.equals(FunAdType.JY_NATIVE)) {
            c = 0;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return null;
                }
                return new a.a.a.a.r.a.e.c(aVar);
            }
            return new a.a.a.a.r.a.e.a(aVar);
        }
        return new a.a.a.a.r.a.e.b(aVar);
    }
}
