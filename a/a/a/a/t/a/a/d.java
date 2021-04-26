package a.a.a.a.t.a.a;

import a.a.a.a.m;
import a.a.a.a.o;
import a.a.a.a.t.a.e.g;
import a.a.a.a.t.a.e.j;
import a.a.a.a.t.a.e.l;
import a.a.a.a.u.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class d implements o.a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a.a.a.a.o.a
    public m a(e.a aVar) {
        char c2;
        String str = aVar.f1335d;
        switch (str.hashCode()) {
            case -1377301807:
                if (str.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1291455752:
                if (str.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1187931233:
                if (str.equals(FunAdType.KS_NATIVE)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1106926588:
                if (str.equals(FunAdType.KS_REWARD_VIDEO)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1031178769:
                if (str.equals(FunAdType.KS_SPLASH)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 2017609999:
                if (str.equals(FunAdType.KS_DRAW_VIDEO)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 != 4) {
                            if (c2 != 5) {
                                return null;
                            }
                            return new a.a.a.a.t.a.e.a(aVar);
                        }
                        return new j(aVar);
                    }
                    return new a.a.a.a.t.a.e.c(aVar);
                }
                return new a.a.a.a.t.a.e.e(aVar);
            }
            return new l(aVar);
        }
        return new g(aVar);
    }
}
