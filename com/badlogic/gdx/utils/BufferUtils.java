package com.badlogic.gdx.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.o6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes.dex */
public final class BufferUtils {
    public static /* synthetic */ Interceptable $ic;
    public static o6<ByteBuffer> a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    public static native void clear(ByteBuffer byteBuffer, int i);

    public static native void copyJni(Buffer buffer, int i, Buffer buffer2, int i2, int i3);

    public static native void copyJni(byte[] bArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(char[] cArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(double[] dArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(float[] fArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(float[] fArr, Buffer buffer, int i, int i2);

    public static native void copyJni(int[] iArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(long[] jArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(short[] sArr, int i, Buffer buffer, int i2, int i3);

    public static native long find(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4);

    public static native long find(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4, float f);

    public static native long find(Buffer buffer, int i, int i2, float[] fArr, int i3, int i4);

    public static native long find(Buffer buffer, int i, int i2, float[] fArr, int i3, int i4, float f);

    public static native long find(float[] fArr, int i, int i2, Buffer buffer, int i3, int i4);

    public static native long find(float[] fArr, int i, int i2, Buffer buffer, int i3, int i4, float f);

    public static native long find(float[] fArr, int i, int i2, float[] fArr2, int i3, int i4);

    public static native long find(float[] fArr, int i, int i2, float[] fArr2, int i3, int i4, float f);

    public static native void freeMemory(ByteBuffer byteBuffer);

    public static native long getBufferAddress(Buffer buffer);

    public static native ByteBuffer newDisposableByteBuffer(int i);

    public static native void transformV2M3Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV2M3Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV2M4Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV2M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV3M3Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV3M3Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV3M4Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV3M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV4M4Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV4M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1197477400, "Lcom/badlogic/gdx/utils/BufferUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1197477400, "Lcom/badlogic/gdx/utils/BufferUtils;");
                return;
            }
        }
        a = new o6<>();
        b = 0;
    }

    public BufferUtils() {
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

    public static void a(float[] fArr, Buffer buffer, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65538, null, fArr, buffer, i, i2) == null) {
            if (buffer instanceof ByteBuffer) {
                buffer.limit(i << 2);
            } else if (buffer instanceof FloatBuffer) {
                buffer.limit(i);
            }
            copyJni(fArr, buffer, i, i2);
            buffer.position(0);
        }
    }

    public static void b(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, byteBuffer) == null) {
            int capacity = byteBuffer.capacity();
            synchronized (a) {
                if (!a.i(byteBuffer, true)) {
                    throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
                }
            }
            b -= capacity;
            freeMemory(byteBuffer);
        }
    }

    public static FloatBuffer c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            return allocateDirect.asFloatBuffer();
        }
        return (FloatBuffer) invokeI.objValue;
    }

    public static IntBuffer d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            return allocateDirect.asIntBuffer();
        }
        return (IntBuffer) invokeI.objValue;
    }

    public static ByteBuffer e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            ByteBuffer newDisposableByteBuffer = newDisposableByteBuffer(i);
            newDisposableByteBuffer.order(ByteOrder.nativeOrder());
            b += i;
            synchronized (a) {
                a.a(newDisposableByteBuffer);
            }
            return newDisposableByteBuffer;
        }
        return (ByteBuffer) invokeI.objValue;
    }
}
