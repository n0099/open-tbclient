package a.a.a.a.u.a.a;

import a.a.a.a.n;
import a.a.a.a.p;
import a.a.a.a.v.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes.dex */
public class c implements p.a {
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

    @Override // a.a.a.a.p.a
    public n a(e.a aVar) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String str = aVar.f1346d;
            int hashCode = str.hashCode();
            if (hashCode == -1900686778) {
                if (str.equals(FunAdType.JY_NATIVE)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == -1743934314) {
                if (str.equals(FunAdType.JY_SPLASH)) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode != -39027267) {
                if (hashCode == 1872382491 && str.equals(FunAdType.JY_INTERSTITIAL)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return null;
                        }
                        return new a.a.a.a.u.a.d.d(aVar);
                    }
                    return new a.a.a.a.u.a.d.c(aVar);
                }
                return new a.a.a.a.u.a.d.a(aVar);
            }
            return new a.a.a.a.u.a.d.b(aVar);
        }
        return (n) invokeL.objValue;
    }
}
