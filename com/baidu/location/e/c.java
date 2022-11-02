package com.baidu.location.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, arrayList)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).get(2).floatValue() > 0.0f) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int b(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).get(2).floatValue() >= 15.0f) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int c(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).get(2).floatValue() >= 20.0f) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int d(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, arrayList)) == null) {
            float f = 0.0f;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).get(2).floatValue() > 0.0f) {
                    f += arrayList.get(i).get(2).floatValue();
                }
            }
            return Math.round(f);
        }
        return invokeL.intValue;
    }

    public static int e(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, arrayList)) == null) ? Math.round(d(arrayList) / a(arrayList)) : invokeL.intValue;
    }

    public static int f(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, arrayList)) == null) {
            float f = 0.0f;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).get(2).floatValue() > 0.0f) {
                    f += arrayList.get(i).get(2).floatValue() * arrayList.get(i).get(1).floatValue();
                }
            }
            return Math.round(f);
        }
        return invokeL.intValue;
    }

    public static int g(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, arrayList)) == null) ? Math.round(f(arrayList) / a(arrayList)) : invokeL.intValue;
    }

    public static int h(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, arrayList)) == null) {
            int[] iArr = new int[37];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i3).get(0).floatValue() < 360.0d) {
                        int ceil = (int) Math.ceil(arrayList.get(i3).get(0).floatValue() / 10.0f);
                        iArr[ceil] = iArr[ceil] + 1;
                    }
                    i3++;
                } catch (Exception unused) {
                    return 0;
                }
            }
            for (i = 1; i <= 36; i++) {
                if (iArr[i] > 0) {
                    i2++;
                }
            }
            return Math.round((i2 / 36.0f) * 1000.0f);
        }
        return invokeL.intValue;
    }
}
