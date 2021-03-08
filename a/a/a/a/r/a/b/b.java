package a.a.a.a.r.a.b;

import a.a.a.a.a.e;
import a.a.a.a.l;
import a.a.a.a.n;
import a.a.a.a.r.a.c.f;
import a.a.a.a.r.a.c.i;
import a.a.a.a.r.a.c.k;
import a.a.a.a.r.a.c.m;
import a.a.a.a.r.a.c.p;
import a.a.a.a.r.a.c.q;
import a.a.a.a.r.a.c.s;
import a.a.a.a.r.a.c.t;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes4.dex */
public class b implements n.a {
    @Override // a.a.a.a.n.a
    public l b(e.a aVar) {
        String str = aVar.d;
        char c = 65535;
        switch (str.hashCode()) {
            case -2105157443:
                if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
                    c = '\t';
                    break;
                }
                break;
            case -1263692214:
                if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                    c = 3;
                    break;
                }
                break;
            case -950004865:
                if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                    c = 5;
                    break;
                }
                break;
            case 347930415:
                if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                    c = '\b';
                    break;
                }
                break;
            case 556489085:
                if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                    c = 0;
                    break;
                }
                break;
            case 1168375858:
                if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                    c = 6;
                    break;
                }
                break;
            case 1319012390:
                if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                    c = 2;
                    break;
                }
                break;
            case 1328722634:
                if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                    c = 1;
                    break;
                }
                break;
            case 1922685617:
                if (str.equals(FunAdType.CSJ_NATIVE)) {
                    c = 4;
                    break;
                }
                break;
            case 2079438081:
                if (str.equals(FunAdType.CSJ_SPLASH)) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new a.a.a.a.r.a.c.d(aVar);
            case 1:
                return new a.a.a.a.r.a.c.a(aVar);
            case 2:
                return new i(aVar);
            case 3:
                return new k(aVar);
            case 4:
                return new p(aVar);
            case 5:
                return new m(aVar);
            case 6:
                return new q(aVar);
            case 7:
                return new t(aVar);
            case '\b':
                return new s(aVar);
            case '\t':
                return new f(aVar);
            default:
                a.a.a.a.v.d.b("Not supported pid.type:%s", aVar.d);
                return null;
        }
    }
}
