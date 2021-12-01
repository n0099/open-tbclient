package c.a.c0.i;

import android.content.pm.PackageInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PackageInfo a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i2)) == null) {
            if (new File(str).exists()) {
                return ContextHolder.getApplicationContext().getPackageManager().getPackageArchiveInfo(str, i2);
            }
            return null;
        }
        return (PackageInfo) invokeLI.objValue;
    }
}
