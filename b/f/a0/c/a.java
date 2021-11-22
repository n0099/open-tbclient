package b.f.a0.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static c a(Context context, Ssp.Pid pid) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, pid)) == null) {
            String str = pid.type;
            str.hashCode();
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
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1659486968:
                    if (str.equals(FunAdType.JY_DRAW_VIDEO)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -39027267:
                    if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1872382491:
                    if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                        c2 = 4;
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
                            return new j(context.getApplicationContext(), pid.pid);
                        }
                        return new l(context.getApplicationContext(), pid.pid);
                    }
                    return new i(context.getApplicationContext(), pid.pid);
                }
                return new m(context.getApplicationContext(), pid.pid);
            }
            return new k(context.getApplicationContext(), pid.pid);
        }
        return (c) invokeLL.objValue;
    }
}
