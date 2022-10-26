package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PermissionInfoCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ProtectionFlags {
    }

    public PermissionInfoCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getProtection(PermissionInfo permissionInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, permissionInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return permissionInfo.getProtection();
            }
            return permissionInfo.protectionLevel & 15;
        }
        return invokeL.intValue;
    }

    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, permissionInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return permissionInfo.getProtectionFlags();
            }
            return permissionInfo.protectionLevel & (-16);
        }
        return invokeL.intValue;
    }
}
