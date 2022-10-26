package com.baidu.tbadk.core.util.dimen;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class TbDimenManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile TbDimenManager sInstance = null;
    public static final int targetDensity = 3;
    public static final int targetDensityDpi = 480;
    public static final int targetWidthDp = 360;
    public transient /* synthetic */ FieldHolder $fh;
    public TbDimenAdaptActivityLifecycle adaptActivityLifecycle;
    public Application mApplication;
    public float mDefaultDensity;
    public int mDefaultDensityDpi;

    public TbDimenManager() {
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

    public static TbDimenManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (TbDimenManager.class) {
                    if (sInstance == null) {
                        sInstance = new TbDimenManager();
                    }
                }
            }
            return sInstance;
        }
        return (TbDimenManager) invokeV.objValue;
    }

    public float getDefaultDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDefaultDensity;
        }
        return invokeV.floatValue;
    }

    public int getDefaultDensityDpi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDefaultDensityDpi;
        }
        return invokeV.intValue;
    }

    public boolean needAdapt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.mDefaultDensity;
            if (f > 2.5d && f < 3.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static DisplayMetrics getMetrics(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return context.getResources().getDisplayMetrics();
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public void adaptThisDimen(DisplayMetrics displayMetrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, displayMetrics) == null) {
            setDensity(displayMetrics, 3.0f, 480);
        }
    }

    public boolean needAdapt(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, displayMetrics)) == null) {
            if (displayMetrics == null) {
                return false;
            }
            float f = displayMetrics.density;
            if (f <= 2.5d || f >= 3.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static DisplayMetrics getMetricsOnMiui(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            Resources resources = context.getResources();
            if (!"MiuiResources".equals(resources.getClass().getSimpleName()) && !"XResources".equals(resources.getClass().getSimpleName())) {
                return null;
            }
            try {
                Field declaredField = Resources.class.getDeclaredField("mTmpMetrics");
                declaredField.setAccessible(true);
                return (DisplayMetrics) declaredField.get(resources);
            } catch (Exception unused) {
                return null;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, application) == null) {
            this.mApplication = application;
            Display defaultDisplay = ((WindowManager) application.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            float f = displayMetrics.density;
            this.mDefaultDensity = f;
            this.mDefaultDensityDpi = displayMetrics.densityDpi;
            if (f > 2.5d && f < 3.0f) {
                adaptDimen(null);
                TbDimenAdaptActivityLifecycle tbDimenAdaptActivityLifecycle = new TbDimenAdaptActivityLifecycle(displayMetrics);
                this.adaptActivityLifecycle = tbDimenAdaptActivityLifecycle;
                this.mApplication.registerActivityLifecycleCallbacks(tbDimenAdaptActivityLifecycle);
            }
        }
    }

    private void setDensity(DisplayMetrics displayMetrics, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{displayMetrics, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            TbDimenUtil.setDensity(displayMetrics, f, i);
        }
    }

    public void adaptDimen(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            DisplayMetrics metrics = getMetrics(context);
            DisplayMetrics metrics2 = getMetrics(this.mApplication);
            setDensity(metrics, 3.0f, 480);
            setDensity(metrics2, 3.0f, 480);
            DisplayMetrics metricsOnMiui = getMetricsOnMiui(context);
            DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(this.mApplication);
            setDensity(metricsOnMiui, 3.0f, 480);
            setDensity(metricsOnMiui2, 3.0f, 480);
        }
    }

    public void adaptDimen(Context context, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            DisplayMetrics metrics = getMetrics(context);
            DisplayMetrics metrics2 = getMetrics(this.mApplication);
            setDensity(metrics, f, i);
            setDensity(metrics2, f, i);
            DisplayMetrics metricsOnMiui = getMetricsOnMiui(context);
            DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(this.mApplication);
            setDensity(metricsOnMiui, f, i);
            setDensity(metricsOnMiui2, f, i);
        }
    }
}
