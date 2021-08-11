package b.a.a.a.t.a.b;

import b.a.a.a.n;
import b.a.a.a.p;
import b.a.a.a.t.a.d.e;
import b.a.a.a.t.a.d.g;
import b.a.a.a.t.a.d.l;
import b.a.a.a.t.a.d.m;
import b.a.a.a.t.a.d.o;
import b.a.a.a.u.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class b implements p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
                    return new b.a.a.a.t.a.d.n(aVar);
                case 1:
                    return new g(aVar);
                case 2:
                    return new e(aVar);
                case 3:
                    return new b.a.a.a.t.a.d.b(aVar);
                case 4:
                    return new o(aVar);
                case 5:
                    return new b.a.a.a.t.a.d.a(aVar);
                case 6:
                    return new l(aVar);
                case 7:
                    return new m(aVar);
                default:
                    return null;
            }
        }
        return (n) invokeL.objValue;
    }
}
