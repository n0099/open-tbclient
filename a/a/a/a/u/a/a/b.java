package a.a.a.a.u.a.a;

import a.a.a.a.n;
import a.a.a.a.p;
import a.a.a.a.u.a.c.g;
import a.a.a.a.u.a.c.l;
import a.a.a.a.u.a.c.m;
import a.a.a.a.u.a.c.o;
import a.a.a.a.v.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class b implements p.a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a.a.a.a.p.a
    public n a(e.a aVar) {
        char c2;
        String str = aVar.f1343d;
        switch (str.hashCode()) {
            case -1303381232:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -942661506:
                if (str.equals(FunAdType.GDT_SPLASH)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -596233886:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 114133351:
                if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 125016359:
                if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 425812868:
                if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 543046357:
                if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1990506825:
                if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                    c2 = 5;
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
                return new a.a.a.a.u.a.c.n(aVar);
            case 1:
                return new g(aVar);
            case 2:
                return new a.a.a.a.u.a.c.e(aVar);
            case 3:
                return new a.a.a.a.u.a.c.b(aVar);
            case 4:
                return new o(aVar);
            case 5:
                return new a.a.a.a.u.a.c.a(aVar);
            case 6:
                return new l(aVar);
            case 7:
                return new m(aVar);
            default:
                return null;
        }
    }
}
