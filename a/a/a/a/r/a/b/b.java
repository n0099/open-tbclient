package a.a.a.a.r.a.b;

import a.a.a.a.k;
import a.a.a.a.m;
import a.a.a.a.r.a.c.f;
import a.a.a.a.r.a.c.i;
import a.a.a.a.r.a.c.p;
import a.a.a.a.r.a.c.q;
import a.a.a.a.r.a.c.s;
import a.a.a.a.r.a.c.t;
import a.a.a.a.s.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class b implements m.a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a.a.a.a.m.a
    public k a(e.a aVar) {
        char c2;
        String str = aVar.f1335d;
        switch (str.hashCode()) {
            case -2105157443:
                if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -1263692214:
                if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -950004865:
                if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 347930415:
                if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 556489085:
                if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1168375858:
                if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1319012390:
                if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1328722634:
                if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1922685617:
                if (str.equals(FunAdType.CSJ_NATIVE)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 2079438081:
                if (str.equals(FunAdType.CSJ_SPLASH)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return new a.a.a.a.r.a.c.d(aVar);
            case 1:
                return new a.a.a.a.r.a.c.a(aVar);
            case 2:
                return new i(aVar);
            case 3:
                return new a.a.a.a.r.a.c.k(aVar);
            case 4:
                return new p(aVar);
            case 5:
                return new a.a.a.a.r.a.c.m(aVar);
            case 6:
                return new q(aVar);
            case 7:
                return new t(aVar);
            case '\b':
                return new s(aVar);
            case '\t':
                return new f(aVar);
            default:
                a.a.a.a.v.d.b("Not supported pid.type:%s", aVar.f1335d);
                return null;
        }
    }
}
