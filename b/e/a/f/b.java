package b.e.a.f;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@TargetApi(23)
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2) : invokeLLL.intValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? AppOpsManager.permissionToOp(str) : (String) invokeL.objValue;
    }
}
