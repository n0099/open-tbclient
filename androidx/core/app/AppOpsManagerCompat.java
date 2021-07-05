package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public AppOpsManagerCompat() {
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

    public static int noteOp(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, context, str, i2, str2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i2, str2);
            }
            return 1;
        }
        return invokeLLIL.intValue;
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65538, null, context, str, i2, str2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i2, str2);
            }
            return 1;
        }
        return invokeLLIL.intValue;
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
            }
            return 1;
        }
        return invokeLLL.intValue;
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, context, str, str2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
            }
            return 1;
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public static String permissionToOp(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return AppOpsManager.permissionToOp(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
