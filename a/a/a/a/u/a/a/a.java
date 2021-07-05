package a.a.a.a.u.a.a;

import a.a.a.a.n;
import a.a.a.a.p;
import a.a.a.a.u.a.b.h;
import a.a.a.a.u.a.b.k;
import a.a.a.a.u.a.b.m;
import a.a.a.a.u.a.b.o;
import a.a.a.a.u.a.b.s;
import a.a.a.a.u.a.b.t;
import a.a.a.a.u.a.b.v;
import a.a.a.a.u.a.b.w;
import a.a.a.a.v.e;
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
    @Override // a.a.a.a.p.a
    public n a(e.a aVar) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String str = aVar.f1346d;
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
                        c2 = '\n';
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
                    return new a.a.a.a.u.a.b.d(aVar);
                case 1:
                    return new a.a.a.a.u.a.b.a(aVar);
                case 2:
                    return new k(aVar);
                case 3:
                    return new m(aVar);
                case 4:
                    return new s(aVar);
                case 5:
                    return new a.a.a.a.u.a.b.p(aVar);
                case 6:
                    return new t(aVar);
                case 7:
                    return new w(aVar);
                case '\b':
                    return new v(aVar);
                case '\t':
                    return new h(aVar);
                case '\n':
                    return new o(aVar);
                default:
                    a.a.a.a.y.d.b("Not supported pid.type:%s", aVar.f1346d);
                    return null;
            }
        }
        return (n) invokeL.objValue;
    }
}
