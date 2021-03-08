package a.a.a.a.r.a.b;

import a.a.a.a.a.e;
import a.a.a.a.l;
import a.a.a.a.n;
import a.a.a.a.r.a.d.g;
import a.a.a.a.r.a.d.m;
import a.a.a.a.r.a.d.o;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes4.dex */
public class c implements n.a {
    @Override // a.a.a.a.n.a
    public l b(e.a aVar) {
        String str = aVar.d;
        char c = 65535;
        switch (str.hashCode()) {
            case -1303381232:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                    c = 3;
                    break;
                }
                break;
            case -942661506:
                if (str.equals(FunAdType.GDT_SPLASH)) {
                    c = 7;
                    break;
                }
                break;
            case -596233886:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                    c = 2;
                    break;
                }
                break;
            case 114133351:
                if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                    c = 0;
                    break;
                }
                break;
            case 125016359:
                if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                    c = 4;
                    break;
                }
                break;
            case 425812868:
                if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                    c = 1;
                    break;
                }
                break;
            case 543046357:
                if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                    c = 6;
                    break;
                }
                break;
            case 1990506825:
                if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new a.a.a.a.r.a.d.n(aVar);
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
                return new a.a.a.a.r.a.d.l(aVar);
            case 7:
                return new m(aVar);
            default:
                return null;
        }
    }
}
