package com.baidu.android.util.bitmap;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.LongSparseArray;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PreloadUIResUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "PreloadUIResUtils";
    public static final Object mAccessLock;
    public static final LongSparseArray<Drawable.ConstantState> mPreloadedDrawableCS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401431058, "Lcom/baidu/android/util/bitmap/PreloadUIResUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-401431058, "Lcom/baidu/android/util/bitmap/PreloadUIResUtils;");
                return;
            }
        }
        mPreloadedDrawableCS = new LongSparseArray<>(30);
        mAccessLock = new Object();
    }

    public PreloadUIResUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void cleanPreloadedDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (mAccessLock) {
                mPreloadedDrawableCS.clear();
            }
        }
    }

    public static Drawable getPreloadedDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            Drawable.ConstantState constantState = mPreloadedDrawableCS.get(i2);
            if (constantState != null) {
                return constantState.newDrawable(AppRuntime.getAppContext().getResources());
            }
            return null;
        }
        return (Drawable) invokeI.objValue;
    }

    public static void preloadDrawable(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) {
            preloadDrawable(i2, false);
        }
    }

    public static void preloadDrawable(@DrawableRes int i2, boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                if (z) {
                    Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(i2);
                    if (drawable2 != null) {
                        synchronized (mAccessLock) {
                            Drawable.ConstantState constantState = drawable2.getConstantState();
                            if (constantState != null) {
                                mPreloadedDrawableCS.put(i2, constantState);
                            }
                        }
                        return;
                    }
                    return;
                }
                long j = i2;
                if (mPreloadedDrawableCS.get(j) != null || (drawable = AppRuntime.getAppContext().getResources().getDrawable(i2)) == null) {
                    return;
                }
                synchronized (mAccessLock) {
                    Drawable.ConstantState constantState2 = drawable.getConstantState();
                    if (constantState2 != null) {
                        mPreloadedDrawableCS.put(j, constantState2);
                    }
                }
            } catch (Resources.NotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
