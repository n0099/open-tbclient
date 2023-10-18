package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ax {
    public static /* synthetic */ Interceptable $ic;
    public static DisplayMetrics a;
    public static float b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833693176, "Lcom/baidu/mobads/sdk/internal/ax;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833693176, "Lcom/baidu/mobads/sdk/internal/ax;");
        }
    }

    public ax() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f)) == null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static int b(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65542, null, context, f)) == null) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static int a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i)) == null) {
            try {
                return (int) (i / e(context));
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static int b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            try {
                return (int) (i * e(context));
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static Rect a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            DisplayMetrics f = f(context);
            try {
                if (f.widthPixels > f.heightPixels) {
                    return new Rect(0, 0, f.heightPixels, f.widthPixels);
                }
                return new Rect(0, 0, f.widthPixels, f.heightPixels);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Rect) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return a(context).width();
        }
        return invokeL.intValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return a(context).height();
        }
        return invokeL.intValue;
    }

    public static Rect d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            DisplayMetrics f = f(context);
            return new Rect(0, 0, f.widthPixels, f.heightPixels);
        }
        return (Rect) invokeL.objValue;
    }

    public static float e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (b < 0.01d) {
                b = f(context).density;
            }
            return b;
        }
        return invokeL.floatValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android"));
        }
        return invokeL.intValue;
    }

    public static DisplayMetrics f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                if (a != null && a.widthPixels > 0) {
                    return a;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (bj.a(context).a() >= 17) {
                    ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
                }
                a = displayMetrics;
            } catch (Throwable th) {
                a = new DisplayMetrics();
                br.a().a(th);
            }
            return a;
        }
        return (DisplayMetrics) invokeL.objValue;
    }
}
