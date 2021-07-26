package a.a.a.a.r.a.a;

import a.a.a.a.m;
import a.a.a.a.o;
import a.a.a.a.r.a.d.e;
import a.a.a.a.s.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class c implements o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
    @Override // a.a.a.a.o.a
    public m a(h.a aVar) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String str = aVar.f1362d;
            switch (str.hashCode()) {
                case -1900686778:
                    if (str.equals(FunAdType.JY_NATIVE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1743934314:
                    if (str.equals(FunAdType.JY_SPLASH)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1659486968:
                    if (str.equals(FunAdType.JY_DRAW_VIDEO)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -39027267:
                    if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1872382491:
                    if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                        c2 = 1;
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
                                return null;
                            }
                            return new a.a.a.a.r.a.d.a(aVar);
                        }
                        return new e(aVar);
                    }
                    return new a.a.a.a.r.a.d.d(aVar);
                }
                return new a.a.a.a.r.a.d.b(aVar);
            }
            return new a.a.a.a.r.a.d.c(aVar);
        }
        return (m) invokeL.objValue;
    }
}
