package b.a.a.a.t.a.b;

import b.a.a.a.n;
import b.a.a.a.p;
import b.a.a.a.t.a.c.j;
import b.a.a.a.t.a.c.m;
import b.a.a.a.t.a.c.o;
import b.a.a.a.t.a.c.q;
import b.a.a.a.t.a.c.r;
import b.a.a.a.t.a.c.u;
import b.a.a.a.t.a.c.v;
import b.a.a.a.t.a.c.x;
import b.a.a.a.t.a.c.y;
import b.a.a.a.u.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class a implements p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
                case -2105157443:
                    if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1412451668:
                    if (str.equals(FunAdType.CSJ_INTERSITIAL_2)) {
                        c2 = 11;
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
                case -1071311851:
                    if (str.equals(FunAdType.CSJ_DRAW_NATIVE)) {
                        c2 = '\n';
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
                    return new b.a.a.a.t.a.c.d(aVar);
                case 1:
                    return new b.a.a.a.t.a.c.a(aVar);
                case 2:
                    return new m(aVar);
                case 3:
                    return new o(aVar);
                case 4:
                    return new u(aVar);
                case 5:
                    return new r(aVar);
                case 6:
                    return new v(aVar);
                case 7:
                    return new y(aVar);
                case '\b':
                    return new x(aVar);
                case '\t':
                    return new j(aVar);
                case '\n':
                    return new b.a.a.a.t.a.c.h(aVar);
                case 11:
                    return new q(aVar);
                default:
                    b.a.a.a.x.d.f("Not supported pid.type:%s", aVar.f1449d);
                    return null;
            }
        }
        return (n) invokeL.objValue;
    }
}
