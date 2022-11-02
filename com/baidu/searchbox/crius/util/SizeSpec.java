package com.baidu.searchbox.crius.util;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SizeSpec {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;

    public static int round(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65543, null, f)) == null) {
            return (int) (f > 0.0f ? f + 0.5d : f - 0.5d);
        }
        return invokeF.intValue;
    }

    /* renamed from: com.baidu.searchbox.crius.util.SizeSpec$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$crius$CriusMeasureMode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(68897910, "Lcom/baidu/searchbox/crius/util/SizeSpec$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(68897910, "Lcom/baidu/searchbox/crius/util/SizeSpec$1;");
                    return;
                }
            }
            int[] iArr = new int[CriusMeasureMode.values().length];
            $SwitchMap$com$baidu$crius$CriusMeasureMode = iArr;
            try {
                iArr[CriusMeasureMode.EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusMeasureMode[CriusMeasureMode.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusMeasureMode[CriusMeasureMode.AT_MOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1720740195, "Lcom/baidu/searchbox/crius/util/SizeSpec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1720740195, "Lcom/baidu/searchbox/crius/util/SizeSpec;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public SizeSpec() {
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

    public static int getMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return View.MeasureSpec.getMode(i);
        }
        return invokeI.intValue;
    }

    public static int getSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return View.MeasureSpec.getSize(i);
        }
        return invokeI.intValue;
    }

    public static String toString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            return View.MeasureSpec.toString(i);
        }
        return (String) invokeI.objValue;
    }

    public static int makeSizeSpec(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            return View.MeasureSpec.makeMeasureSpec(i, i2);
        }
        return invokeII.intValue;
    }

    public static int makeSizeSpecFromCssSpec(float f, CriusMeasureMode criusMeasureMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), criusMeasureMode})) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$crius$CriusMeasureMode[criusMeasureMode.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (!DEBUG) {
                            return 0;
                        }
                        throw new IllegalArgumentException("Unexpected YogaMeasureMode: " + criusMeasureMode);
                    }
                    return makeSizeSpec(round(f), Integer.MIN_VALUE);
                }
                return makeSizeSpec(0, 0);
            }
            return makeSizeSpec(round(f), 1073741824);
        }
        return invokeCommon.intValue;
    }

    public static int resolveSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
            int mode = getMode(i);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode != 1073741824) {
                        if (!DEBUG) {
                            return 0;
                        }
                        throw new IllegalStateException("Unexpected size mode: " + getMode(i));
                    }
                    return getSize(i);
                }
                return i2;
            }
            return Math.min(getSize(i), i2);
        }
        return invokeII.intValue;
    }
}
