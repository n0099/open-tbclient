package c.g.b0.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes9.dex */
public class e implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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
    @Override // com.fun.ad.sdk.internal.api.PidLoaderCreator
    public PidLoader create(Ssp.Pid pid) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) {
            String str = pid.type;
            str.hashCode();
            switch (str.hashCode()) {
                case -2105157443:
                    if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1412451668:
                    if (str.equals(FunAdType.CSJ_INTERSITIAL_2)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1263692214:
                    if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1071311851:
                    if (str.equals(FunAdType.CSJ_DRAW_NATIVE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -950004865:
                    if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 347930415:
                    if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 556489085:
                    if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1168375858:
                    if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1319012390:
                    if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1328722634:
                    if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1922685617:
                    if (str.equals(FunAdType.CSJ_NATIVE)) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2079438081:
                    if (str.equals(FunAdType.CSJ_SPLASH)) {
                        c2 = 11;
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
                    return new t(pid);
                case 1:
                    return new a0(pid);
                case 2:
                    return new y(pid);
                case 3:
                    return new r(pid);
                case 4:
                    return new b0(pid);
                case 5:
                    return new b(pid);
                case 6:
                    return new k(pid);
                case 7:
                    return new g0(pid);
                case '\b':
                    return new w(pid);
                case '\t':
                    return new f(pid);
                case '\n':
                    return new f0(pid);
                case 11:
                    return new d(pid);
                default:
                    LogPrinter.e("Not supported pid.type:%s", pid.type);
                    return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
