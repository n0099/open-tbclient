package b.a.a.a.t.a.b;

import b.a.a.a.n;
import b.a.a.a.p;
import b.a.a.a.t.a.f.e;
import b.a.a.a.t.a.f.g;
import b.a.a.a.t.a.f.j;
import b.a.a.a.t.a.f.l;
import b.a.a.a.u.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class d implements p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // b.a.a.a.p.a
    public n a(h.a aVar) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String str = aVar.f1449d;
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
                                return new b.a.a.a.t.a.f.a(aVar);
                            }
                            return new j(aVar);
                        }
                        return new b.a.a.a.t.a.f.c(aVar);
                    }
                    return new e(aVar);
                }
                return new l(aVar);
            }
            return new g(aVar);
        }
        return (n) invokeL.objValue;
    }
}
