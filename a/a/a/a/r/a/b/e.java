package a.a.a.a.r.a.b;

import a.a.a.a.a.e;
import a.a.a.a.l;
import a.a.a.a.n;
import a.a.a.a.r.a.f.g;
import a.a.a.a.r.a.f.h;
import a.a.a.a.r.a.f.j;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes4.dex */
public class e implements n.a {
    @Override // a.a.a.a.n.a
    public l b(e.a aVar) {
        String str = aVar.d;
        char c = 65535;
        switch (str.hashCode()) {
            case -1377301807:
                if (str.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                    c = 2;
                    break;
                }
                break;
            case -1291455752:
                if (str.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                    c = 3;
                    break;
                }
                break;
            case -1187931233:
                if (str.equals(FunAdType.KS_NATIVE)) {
                    c = 0;
                    break;
                }
                break;
            case -1106926588:
                if (str.equals(FunAdType.KS_REWARD_VIDEO)) {
                    c = 4;
                    break;
                }
                break;
            case -1031178769:
                if (str.equals(FunAdType.KS_SPLASH)) {
                    c = 1;
                    break;
                }
                break;
            case 2017609999:
                if (str.equals(FunAdType.KS_DRAW_VIDEO)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new g(aVar);
            case 1:
                return new j(aVar);
            case 2:
                return new a.a.a.a.r.a.f.e(aVar);
            case 3:
                return new a.a.a.a.r.a.f.c(aVar);
            case 4:
                return new h(aVar);
            case 5:
                return new a.a.a.a.r.a.f.a(aVar);
            default:
                return null;
        }
    }
}
