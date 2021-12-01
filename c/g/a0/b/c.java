package c.g.a0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes7.dex */
public class c implements PidLoaderCreator {
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
    @Override // com.fun.ad.sdk.internal.api.PidLoaderCreator
    public PidLoader create(Ssp.Pid pid) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) {
            String str = pid.type;
            str.hashCode();
            switch (str.hashCode()) {
                case -1303381232:
                    if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -942661506:
                    if (str.equals(FunAdType.GDT_SPLASH)) {
                        c2 = 1;
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
                        c2 = 3;
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
                        c2 = 5;
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
                    return new f(pid);
                case 1:
                    return new w(pid);
                case 2:
                    return new l(pid);
                case 3:
                    return new x(pid);
                case 4:
                    return new y(pid);
                case 5:
                    return new o(pid);
                case 6:
                    return new v(pid);
                case 7:
                    return new e(pid);
                default:
                    return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
