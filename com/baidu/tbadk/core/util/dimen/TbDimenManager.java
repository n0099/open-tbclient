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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static DisplayMetrics getMetricsOnMiui(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            Resources resources = context.getResources();
            if ("MiuiResources".equals(resources.getClass().getSimpleName()) || "XResources".equals(resources.getClass().getSimpleName())) {
                try {
                    Field declaredField = Resources.class.getDeclaredField("mTmpMetrics");
                    declaredField.setAccessible(true);
                    return (DisplayMetrics) declaredField.get(resources);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    private void setDensity(DisplayMetrics displayMetrics, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{displayMetrics, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            TbDimenUtil.setDensity(displayMetrics, f2, i2);
        }
    }

    public void adaptDimen(Context context, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            DisplayMetrics metrics = getMetrics(context);
            DisplayMetrics metrics2 = getMetrics(this.mApplication);
            setDensity(metrics, f2, i2);
            setDensity(metrics2, f2, i2);
            DisplayMetrics metricsOnMiui = getMetricsOnMiui(context);
            DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(this.mApplication);
            setDensity(metricsOnMiui, f2, i2);
            setDensity(metricsOnMiui2, f2, i2);
        }
    }

    public float getDefaultDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDefaultDensity : invokeV.floatValue;
    }

    public int getDefaultDensityDpi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDefaultDensityDpi : invokeV.intValue;
    }

    public void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, application) == null) {
            this.mApplication = application;
            Display defaultDisplay = ((WindowManager) application.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            this.mDefaultDensity = f2;
            this.mDefaultDensityDpi = displayMetrics.densityDpi;
            if (f2 <= 2.5d || f2 >= 3.0f) {
                return;
            }
            adaptDimen(null);
            TbDimenAdaptActivityLifecycle tbDimenAdaptActivityLifecycle = new TbDimenAdaptActivityLifecycle(displayMetrics);
            this.adaptActivityLifecycle = tbDimenAdaptActivityLifecycle;
            this.mApplication.registerActivityLifecycleCallbacks(tbDimenAdaptActivityLifecycle);
        }
    }

    public boolean needAdapt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f2 = this.mDefaultDensity;
            return ((double) f2) > 2.5d && f2 < 3.0f;
        }
        return invokeV.booleanValue;
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
}
