package com.baidu.android.util.media;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public class PreloadUIResUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final LongSparseArray<Drawable.ConstantState> PRELOADED_DRAWABLE_CS;
    public static final String TAG = "PreloadUIResUtil";
    public static volatile boolean hasSubmitPrepareToDraw;
    public static final Object mAccessLock;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1940250700, "Lcom/baidu/android/util/media/PreloadUIResUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1940250700, "Lcom/baidu/android/util/media/PreloadUIResUtil;");
                return;
            }
        }
        PRELOADED_DRAWABLE_CS = new LongSparseArray<>(50);
        mAccessLock = new Object();
        hasSubmitPrepareToDraw = false;
    }

    public static void prepareDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (mAccessLock) {
                for (int i = 0; i < PRELOADED_DRAWABLE_CS.size(); i++) {
                    try {
                        prepareToDraw(PRELOADED_DRAWABLE_CS.valueAt(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                hasSubmitPrepareToDraw = true;
            }
        }
    }

    public PreloadUIResUtil() {
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

    public static void cleanPreloadedDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (mAccessLock) {
                PRELOADED_DRAWABLE_CS.clear();
            }
        }
    }

    public static Drawable getPreloadedDrawable(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            Drawable.ConstantState constantState = PRELOADED_DRAWABLE_CS.get(i);
            if (constantState != null) {
                return constantState.newDrawable(AppRuntime.getAppContext().getResources());
            }
            return null;
        }
        return (Drawable) invokeI.objValue;
    }

    public static void preloadDrawable(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            preloadDrawable(i, false);
        }
    }

    public static void preloadDrawable(@DrawableRes int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, str) == null) {
            preloadDrawable(i);
        }
    }

    public static void preloadDrawable(@DrawableRes int i, boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                if (z) {
                    Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(i);
                    if (drawable2 != null) {
                        synchronized (mAccessLock) {
                            Drawable.ConstantState constantState = drawable2.getConstantState();
                            if (constantState != null) {
                                PRELOADED_DRAWABLE_CS.put(i, constantState);
                                if (hasSubmitPrepareToDraw) {
                                    prepareToDraw(constantState);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                long j = i;
                if (PRELOADED_DRAWABLE_CS.get(j) == null && (drawable = AppRuntime.getAppContext().getResources().getDrawable(i)) != null) {
                    synchronized (mAccessLock) {
                        Drawable.ConstantState constantState2 = drawable.getConstantState();
                        if (constantState2 != null) {
                            PRELOADED_DRAWABLE_CS.put(j, constantState2);
                            if (hasSubmitPrepareToDraw) {
                                prepareToDraw(constantState2);
                            }
                        }
                    }
                }
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void prepareToDraw(Drawable.ConstantState constantState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, constantState) == null) && constantState != null) {
            Drawable newDrawable = constantState.newDrawable(AppRuntime.getAppContext().getResources());
            String name = BitmapDrawable.class.getName();
            if (newDrawable != null && TextUtils.equals(name, newDrawable.getClass().getName())) {
                ((BitmapDrawable) newDrawable).getBitmap().prepareToDraw();
            }
        }
    }
}
