package a.a.a.a.r.a.b;

import a.a.a.a.k;
import a.a.a.a.m;
import a.a.a.a.r.a.d.g;
import a.a.a.a.r.a.d.l;
import a.a.a.a.r.a.d.n;
import a.a.a.a.r.a.d.o;
import a.a.a.a.s.e;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class c implements m.a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a.a.a.a.m.a
    public k a(e.a aVar) {
        char c2;
        String str = aVar.f1335d;
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
                return new n(aVar);
            case 1:
                return new g(aVar);
            case 2:
                return new a.a.a.a.r.a.d.e(aVar);
            case 3:
                return new a.a.a.a.r.a.d.b(aVar);
            case 4:
                return new o(aVar);
            case 5:
                return new a.a.a.a.r.a.d.a(aVar);
            case 6:
                return new l(aVar);
            case 7:
                return new a.a.a.a.r.a.d.m(aVar);
            default:
                return null;
        }
    }
}
