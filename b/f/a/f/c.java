package b.f.a.f;

import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) ? b(context, str, Process.myPid(), Process.myUid(), context.getPackageName()) : invokeLL.intValue;
    }

    public static int b(@NonNull Context context, @NonNull String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            if (context.checkPermission(str, i2, i3) == -1) {
                return -1;
            }
            String b2 = a.b(str);
            if (b2 == null) {
                return 0;
            }
            if (str2 == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            return a.a(context, b2, str2) != 0 ? -2 : 0;
        }
        return invokeCommon.intValue;
    }
}
