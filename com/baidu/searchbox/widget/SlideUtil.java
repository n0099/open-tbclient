package com.baidu.searchbox.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class SlideUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SlideUtil() {
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

    public static void convertActivityToTranslucentAfterL(Activity activity, OnTranslucentListener onTranslucentListener) {
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, activity, onTranslucentListener) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(activity, new Object[0]);
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Object newProxyInstance = Proxy.newProxyInstance(Activity.class.getClassLoader(), new Class[]{cls}, new TranslucentInvocationHandler(onTranslucentListener));
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(activity, newProxyInstance, invoke);
            } catch (Throwable unused) {
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(false);
                }
            }
        }
    }

    public static void convertActivityToTranslucentBeforeL(Activity activity, OnTranslucentListener onTranslucentListener) {
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, activity, onTranslucentListener) == null) {
            try {
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, null);
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(true);
                }
            } catch (Throwable unused) {
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(false);
                }
            }
        }
    }

    public static void convertFromTranslucent(Activity activity, OnTranslucentListener onTranslucentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, onTranslucentListener) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(false);
                }
            } catch (Throwable th) {
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(true);
                }
                th.printStackTrace();
            }
        }
    }

    public static void convertToTranslucent(Activity activity, OnTranslucentListener onTranslucentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onTranslucentListener) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    convertActivityToTranslucentAfterL(activity, onTranslucentListener);
                } else {
                    convertActivityToTranslucentBeforeL(activity, onTranslucentListener);
                }
            } catch (Throwable unused) {
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(false);
                }
            }
        }
    }

    public static Drawable getImageFromFile(Context context, String str) {
        InterceptResult invokeLL;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
                return null;
            }
            byte[] ninePatchChunk = decodeFile.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(context.getResources(), decodeFile, ninePatchChunk, new Rect(), null);
            }
            return new BitmapDrawable(context.getResources(), decodeFile);
        }
        return (Drawable) invokeLL.objValue;
    }
}
