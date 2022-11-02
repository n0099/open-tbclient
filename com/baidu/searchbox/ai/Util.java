package com.baidu.searchbox.ai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Util {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.ai.Util$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ai$DataType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1444177279, "Lcom/baidu/searchbox/ai/Util$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1444177279, "Lcom/baidu/searchbox/ai/Util$1;");
                    return;
                }
            }
            int[] iArr = new int[DataType.values().length];
            $SwitchMap$com$baidu$searchbox$ai$DataType = iArr;
            try {
                iArr[DataType.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ai$DataType[DataType.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ai$DataType[DataType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ai$DataType[DataType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ai$DataType[DataType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ai$DataType[DataType.BOOL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public Util() {
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

    public static byte[] concat(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static double[] concat(double[] dArr, double[] dArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dArr, dArr2)) == null) {
            double[] dArr3 = new double[dArr.length + dArr2.length];
            System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
            System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
            return dArr3;
        }
        return (double[]) invokeLL.objValue;
    }

    public static float[] concat(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, fArr, fArr2)) == null) {
            float[] fArr3 = new float[fArr.length + fArr2.length];
            System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
            System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
            return fArr3;
        }
        return (float[]) invokeLL.objValue;
    }

    public static int[] concat(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, iArr2)) == null) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            return iArr3;
        }
        return (int[]) invokeLL.objValue;
    }

    public static long[] concat(long[] jArr, long[] jArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jArr, jArr2)) == null) {
            long[] jArr3 = new long[jArr.length + jArr2.length];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
            return jArr3;
        }
        return (long[]) invokeLL.objValue;
    }

    public static String[] concat(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, strArr, strArr2)) == null) {
            String[] strArr3 = new String[strArr.length + strArr2.length];
            System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
            System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
            return strArr3;
        }
        return (String[]) invokeLL.objValue;
    }

    public static Object createArray(DataType dataType, int i, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, dataType, i, obj)) == null) {
            switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ai$DataType[dataType.ordinal()]) {
                case 1:
                    int[] iArr = new int[i];
                    iArr[0] = ((Integer) obj).intValue();
                    return iArr;
                case 2:
                    long[] jArr = new long[i];
                    jArr[0] = ((Long) obj).longValue();
                    return jArr;
                case 3:
                    float[] fArr = new float[i];
                    fArr[0] = ((Float) obj).floatValue();
                    return fArr;
                case 4:
                    double[] dArr = new double[i];
                    dArr[0] = ((Double) obj).doubleValue();
                    return dArr;
                case 5:
                    String[] strArr = new String[i];
                    strArr[0] = (String) obj;
                    return strArr;
                case 6:
                    byte[] bArr = new byte[i];
                    bArr[0] = ((Byte) obj).byteValue();
                    return bArr;
                default:
                    throw new IllegalArgumentException("dataType=" + dataType.value());
            }
        }
        return invokeLIL.objValue;
    }

    public static Object flat(Object obj, long[] jArr, DataType dataType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, jArr, dataType)) == null) {
            if (obj != null) {
                if (jArr.length == 0) {
                    return createArray(dataType, 1, obj);
                }
                switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ai$DataType[dataType.ordinal()]) {
                    case 1:
                        return flatIntArray(obj, jArr.length);
                    case 2:
                        return flatLongArray(obj, jArr.length);
                    case 3:
                        return flatFloatArray(obj, jArr.length);
                    case 4:
                        return flatDoubleArray(obj, jArr.length);
                    case 5:
                        return flatDoubleArray(obj, jArr.length);
                    case 6:
                        return flatByteArray(obj, jArr.length);
                    default:
                        throw new IllegalArgumentException("dataType=" + dataType.value());
                }
            }
            throw new IllegalArgumentException("object is null");
        }
        return invokeLLL.objValue;
    }

    public static byte[] flatByteArray(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, obj, i)) == null) {
            if (i == 1) {
                return (byte[]) obj;
            }
            byte[] bArr = new byte[0];
            for (Object obj2 : (Object[]) obj) {
                bArr = concat(bArr, flatByteArray(obj2, i - 1));
            }
            return bArr;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static double[] flatDoubleArray(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, obj, i)) == null) {
            if (i == 1) {
                return (double[]) obj;
            }
            double[] dArr = new double[0];
            for (Object obj2 : (Object[]) obj) {
                dArr = concat(dArr, flatDoubleArray(obj2, i - 1));
            }
            return dArr;
        }
        return (double[]) invokeLI.objValue;
    }

    public static float[] flatFloatArray(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, obj, i)) == null) {
            if (i == 1) {
                return (float[]) obj;
            }
            float[] fArr = new float[0];
            for (Object obj2 : (Object[]) obj) {
                fArr = concat(fArr, flatFloatArray(obj2, i - 1));
            }
            return fArr;
        }
        return (float[]) invokeLI.objValue;
    }

    public static int[] flatIntArray(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, obj, i)) == null) {
            if (i == 1) {
                return (int[]) obj;
            }
            int[] iArr = new int[0];
            for (Object obj2 : (Object[]) obj) {
                iArr = concat(iArr, flatIntArray(obj2, i - 1));
            }
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static long[] flatLongArray(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, obj, i)) == null) {
            if (i == 1) {
                return (long[]) obj;
            }
            long[] jArr = new long[0];
            for (Object obj2 : (Object[]) obj) {
                jArr = concat(jArr, flatLongArray(obj2, i - 1));
            }
            return jArr;
        }
        return (long[]) invokeLI.objValue;
    }

    public static String[] flatStringArray(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, obj, i)) == null) {
            if (i == 1) {
                return (String[]) obj;
            }
            String[] strArr = new String[0];
            for (Object obj2 : (Object[]) obj) {
                strArr = concat(strArr, flatStringArray(obj2, i - 1));
            }
            return strArr;
        }
        return (String[]) invokeLI.objValue;
    }
}
