package c.a.r0.r.a.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (str != null) {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            }
            throw new IllegalArgumentException("permission is null");
        }
        return invokeLL.intValue;
    }

    public static final int b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return c.a(context, i2);
            }
            return context.getResources().getColor(i2);
        }
        return invokeLI.intValue;
    }

    public static final ColorStateList c(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return c.b(context, i2);
            }
            return context.getResources().getColorStateList(i2);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static final Drawable d(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return b.a(context, i2);
            }
            return context.getResources().getDrawable(i2);
        }
        return (Drawable) invokeLI.objValue;
    }
}
