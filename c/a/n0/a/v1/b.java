package c.a.n0.a.v1;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            switch (i) {
                case 2001:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01ae);
                case 2002:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b0);
                case 2003:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01ad);
                case 2004:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b1);
                case 2005:
                default:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01ae);
                case 2006:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01af);
                case 2007:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01ac);
            }
        }
        return (String) invokeI.objValue;
    }
}
