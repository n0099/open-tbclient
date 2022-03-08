package c.a.p0.a.p2;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (strArr == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
