package com.baidu.permissionhelper.context;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ContextCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContextCompat";
    public transient /* synthetic */ FieldHolder $fh;

    public ContextCompat() {
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

    public static boolean checkPermissionDenied(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? checkSelfPermission(context, str) == -1 : invokeLL.booleanValue;
    }

    public static boolean checkPermissionGranted(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? checkSelfPermission(context, str) == 0 : invokeLL.booleanValue;
    }

    public static int checkSelfPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (str != null) {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            }
            throw new IllegalArgumentException("permission is null");
        }
        return invokeLL.intValue;
    }

    public static final int getColor(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ContextCompatApi23.getColor(context, i);
            }
            return context.getResources().getColor(i);
        }
        return invokeLI.intValue;
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ContextCompatApi23.getColorStateList(context, i);
            }
            return context.getResources().getColorStateList(i);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static final Drawable getDrawable(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ContextCompatApi21.getDrawable(context, i);
            }
            return context.getResources().getDrawable(i);
        }
        return (Drawable) invokeLI.objValue;
    }

    public static boolean verifyPermissions(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iArr)) == null) {
            if (iArr == null || iArr.length < 1) {
                return false;
            }
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
