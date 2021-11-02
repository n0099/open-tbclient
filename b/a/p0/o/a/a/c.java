package b.a.p0.o.a.a;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void validateRequestPermissionsRequestCode(int i2);
    }

    public static boolean a(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, activity, str)) == null) ? activity.shouldShowRequestPermissionRationale(str) : invokeLL.booleanValue;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, activity, strArr, i2) == null) {
            if (activity instanceof a) {
                ((a) activity).validateRequestPermissionsRequestCode(i2);
            }
            activity.requestPermissions(strArr, i2);
        }
    }
}
