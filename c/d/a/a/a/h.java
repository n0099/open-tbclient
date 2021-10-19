package c.d.a.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f31727a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            c(context);
            return f31727a.heightPixels;
        }
        return invokeL.intValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            c(context);
            return f31727a.widthPixels;
        }
        return invokeL.intValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, context) == null) && f31727a == null) {
            f31727a = context.getResources().getDisplayMetrics();
        }
    }
}
