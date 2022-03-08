package c.a.p0.a.v1;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            switch (i2) {
                case 2001:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_not_exist);
                case 2002:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_too_large);
                case 2003:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_io_exception);
                case 2004:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_files_delete_fail);
                case 2005:
                default:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_not_exist);
                case 2006:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_path_invalid);
                case 2007:
                    return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_ab_switch_off);
            }
        }
        return (String) invokeI.objValue;
    }
}
