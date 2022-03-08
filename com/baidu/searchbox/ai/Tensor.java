package com.baidu.searchbox.ai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class Tensor implements AutoCloseable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataType datatype;
    public long nativeHandle;
    public long[] shapeCopy;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(132136565, "Lcom/baidu/searchbox/ai/Tensor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(132136565, "Lcom/baidu/searchbox/ai/Tensor;");
                return;
            }
        }
        Common.getSDKVersion();
    }

    public Tensor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shapeCopy = null;
    }

    public static void assertArgIsArray(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, obj) == null) && !obj.getClass().isArray()) {
            throw new IllegalArgumentException("object must is array");
        }
    }

    public static native ByteBuffer buffer(long j2, int i2);

    public static Tensor createInstance(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            assertArgIsArray(obj);
            DataType dataTypeOf = DataType.dataTypeOf(obj);
            Tensor tensor = new Tensor();
            tensor.datatype = dataTypeOf;
            long[] jArr = new long[numDimensions(obj, dataTypeOf)];
            tensor.shapeCopy = jArr;
            fillShape(obj, 0, jArr);
            tensor.nativeHandle = createNaTensorAndSetValue(dataTypeOf.value(), flatShape(tensor.shapeCopy), flatObject(obj, tensor.shapeCopy, dataTypeOf));
            return tensor;
        }
        return (Tensor) invokeL.objValue;
    }

    public static native long createNaTensor(int i2, long[] jArr);

    public static native long createNaTensorAndSetValue(int i2, long[] jArr, Object obj);

    public static native void deleteNaTensor(long j2, int i2);

    public static void fillShape(Object obj, int i2, long[] jArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65549, null, obj, i2, jArr) == null) || jArr == null || i2 == jArr.length) {
            return;
        }
        int length = Array.getLength(obj);
        if (length != 0) {
            if (jArr[i2] == 0) {
                jArr[i2] = length;
            } else if (jArr[i2] != length) {
                throw new IllegalArgumentException(String.format("mismatched lengths (%d and %d) in dimension %d", Long.valueOf(jArr[i2]), Integer.valueOf(length), Integer.valueOf(i2)));
            }
            for (int i3 = 0; i3 < length; i3++) {
                fillShape(Array.get(obj, i3), i2 + 1, jArr);
            }
            return;
        }
        throw new IllegalArgumentException("cannot create Tensors with a 0 dimension");
    }

    public static Object flatObject(Object obj, long[] jArr, DataType dataType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, obj, jArr, dataType)) == null) ? Util.flat(obj, jArr, dataType) : invokeLLL.objValue;
    }

    public static long[] flatShape(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, jArr)) == null) {
            long[] jArr2 = new long[1];
            long j2 = 1;
            for (long j3 : jArr) {
                j2 *= j3;
            }
            jArr2[0] = j2;
            return jArr2;
        }
        return (long[]) invokeL.objValue;
    }

    private ByteBuffer getBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) ? buffer(this.nativeHandle, i2).order(ByteOrder.nativeOrder()) : (ByteBuffer) invokeI.objValue;
    }

    public static Tensor innerCreateInstance(DataType dataType, long[] jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, dataType, jArr)) == null) {
            Tensor tensor = new Tensor();
            tensor.datatype = dataType;
            tensor.shapeCopy = Arrays.copyOf(jArr, jArr.length);
            tensor.nativeHandle = createNaTensor(dataType.value(), flatShape(jArr));
            return tensor;
        }
        return (Tensor) invokeLL.objValue;
    }

    public static int numArrayDimensions(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, obj)) == null) {
            Class<?> cls = obj.getClass();
            int i2 = 0;
            while (cls.isArray()) {
                cls = cls.getComponentType();
                i2++;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int numDimensions(Object obj, DataType dataType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, obj, dataType)) == null) {
            int numArrayDimensions = numArrayDimensions(obj);
            return (dataType != DataType.STRING || numArrayDimensions <= 0) ? numArrayDimensions : numArrayDimensions - 1;
        }
        return invokeLL.intValue;
    }

    public static int numElements(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, jArr)) == null) {
            int i2 = 1;
            for (long j2 : jArr) {
                i2 *= (int) j2;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static native long readArray(long j2, int i2, Object obj);

    @Override // java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.nativeHandle;
            if (j2 != 0) {
                deleteNaTensor(j2, this.datatype.value());
                this.nativeHandle = 0L;
            }
        }
    }

    public DataType getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.datatype : (DataType) invokeV.objValue;
    }

    public long getNativeHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nativeHandle : invokeV.longValue;
    }

    public int getNumDimens() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.shapeCopy.length : invokeV.intValue;
    }

    public int getNumElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? numElements(this.shapeCopy) : invokeV.intValue;
    }

    public <T> T read(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            assertArgIsArray(t);
            readArray(this.nativeHandle, this.datatype.value(), t);
            return t;
        }
        return (T) invokeL.objValue;
    }

    public long[] shape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.shapeCopy : (long[]) invokeV.objValue;
    }

    public static Tensor createInstance(long[] jArr, ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jArr, byteBuffer)) == null) {
            Tensor innerCreateInstance = innerCreateInstance(DataType.UINT8, jArr);
            byteBuffer.rewind();
            innerCreateInstance.getBuffer(DataType.UINT8.value()).put(byteBuffer);
            return innerCreateInstance;
        }
        return (Tensor) invokeLL.objValue;
    }

    public static Tensor createInstance(long[] jArr, IntBuffer intBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jArr, intBuffer)) == null) {
            Tensor innerCreateInstance = innerCreateInstance(DataType.INT32, jArr);
            intBuffer.rewind();
            innerCreateInstance.getBuffer(DataType.INT32.value()).asIntBuffer().put(intBuffer);
            return innerCreateInstance;
        }
        return (Tensor) invokeLL.objValue;
    }

    public static Tensor createInstance(long[] jArr, LongBuffer longBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jArr, longBuffer)) == null) {
            Tensor innerCreateInstance = innerCreateInstance(DataType.INT64, jArr);
            longBuffer.rewind();
            innerCreateInstance.getBuffer(DataType.INT64.value()).asLongBuffer().put(longBuffer);
            return innerCreateInstance;
        }
        return (Tensor) invokeLL.objValue;
    }

    public static Tensor createInstance(long[] jArr, FloatBuffer floatBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jArr, floatBuffer)) == null) {
            Tensor innerCreateInstance = innerCreateInstance(DataType.FLOAT, jArr);
            floatBuffer.rewind();
            innerCreateInstance.getBuffer(DataType.FLOAT.value()).asFloatBuffer().put(floatBuffer);
            return innerCreateInstance;
        }
        return (Tensor) invokeLL.objValue;
    }

    public static Tensor createInstance(long[] jArr, DoubleBuffer doubleBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jArr, doubleBuffer)) == null) {
            Tensor innerCreateInstance = innerCreateInstance(DataType.DOUBLE, jArr);
            doubleBuffer.rewind();
            innerCreateInstance.getBuffer(DataType.DOUBLE.value()).asDoubleBuffer().put(doubleBuffer);
            return innerCreateInstance;
        }
        return (Tensor) invokeLL.objValue;
    }
}
