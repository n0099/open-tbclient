package com.badlogic.gdx.utils;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.a;
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
/* loaded from: classes8.dex */
public final class BufferUtils {
    public static /* synthetic */ Interceptable $ic;
    public static a<ByteBuffer> a;

    /* renamed from: b  reason: collision with root package name */
    public static int f31628b;
    public transient /* synthetic */ FieldHolder $fh;

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
        a = new a<>();
        f31628b = 0;
    }

    public BufferUtils() {
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

    public static void a(float[] fArr, Buffer buffer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65538, null, fArr, buffer, i2, i3) == null) {
            if (buffer instanceof ByteBuffer) {
                buffer.limit(i2 << 2);
            } else if (buffer instanceof FloatBuffer) {
                buffer.limit(i2);
            }
            copyJni(fArr, buffer, i2, i3);
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
            f31628b -= capacity;
            freeMemory(byteBuffer);
        }
    }

    public static FloatBuffer c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            return allocateDirect.asFloatBuffer();
        }
        return (FloatBuffer) invokeI.objValue;
    }

    public static native void clear(ByteBuffer byteBuffer, int i2);

    public static native void copyJni(Buffer buffer, int i2, Buffer buffer2, int i3, int i4);

    public static native void copyJni(byte[] bArr, int i2, Buffer buffer, int i3, int i4);

    public static native void copyJni(char[] cArr, int i2, Buffer buffer, int i3, int i4);

    public static native void copyJni(double[] dArr, int i2, Buffer buffer, int i3, int i4);

    public static native void copyJni(float[] fArr, int i2, Buffer buffer, int i3, int i4);

    public static native void copyJni(float[] fArr, Buffer buffer, int i2, int i3);

    public static native void copyJni(int[] iArr, int i2, Buffer buffer, int i3, int i4);

    public static native void copyJni(long[] jArr, int i2, Buffer buffer, int i3, int i4);

    public static native void copyJni(short[] sArr, int i2, Buffer buffer, int i3, int i4);

    public static IntBuffer d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            return allocateDirect.asIntBuffer();
        }
        return (IntBuffer) invokeI.objValue;
    }

    public static ByteBuffer e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) {
            ByteBuffer newDisposableByteBuffer = newDisposableByteBuffer(i2);
            newDisposableByteBuffer.order(ByteOrder.nativeOrder());
            f31628b += i2;
            synchronized (a) {
                a.a(newDisposableByteBuffer);
            }
            return newDisposableByteBuffer;
        }
        return (ByteBuffer) invokeI.objValue;
    }

    public static native long find(Buffer buffer, int i2, int i3, Buffer buffer2, int i4, int i5);

    public static native long find(Buffer buffer, int i2, int i3, Buffer buffer2, int i4, int i5, float f2);

    public static native long find(Buffer buffer, int i2, int i3, float[] fArr, int i4, int i5);

    public static native long find(Buffer buffer, int i2, int i3, float[] fArr, int i4, int i5, float f2);

    public static native long find(float[] fArr, int i2, int i3, Buffer buffer, int i4, int i5);

    public static native long find(float[] fArr, int i2, int i3, Buffer buffer, int i4, int i5, float f2);

    public static native long find(float[] fArr, int i2, int i3, float[] fArr2, int i4, int i5);

    public static native long find(float[] fArr, int i2, int i3, float[] fArr2, int i4, int i5, float f2);

    public static native void freeMemory(ByteBuffer byteBuffer);

    public static native long getBufferAddress(Buffer buffer);

    public static native ByteBuffer newDisposableByteBuffer(int i2);

    public static native void transformV2M3Jni(Buffer buffer, int i2, int i3, float[] fArr, int i4);

    public static native void transformV2M3Jni(float[] fArr, int i2, int i3, float[] fArr2, int i4);

    public static native void transformV2M4Jni(Buffer buffer, int i2, int i3, float[] fArr, int i4);

    public static native void transformV2M4Jni(float[] fArr, int i2, int i3, float[] fArr2, int i4);

    public static native void transformV3M3Jni(Buffer buffer, int i2, int i3, float[] fArr, int i4);

    public static native void transformV3M3Jni(float[] fArr, int i2, int i3, float[] fArr2, int i4);

    public static native void transformV3M4Jni(Buffer buffer, int i2, int i3, float[] fArr, int i4);

    public static native void transformV3M4Jni(float[] fArr, int i2, int i3, float[] fArr2, int i4);

    public static native void transformV4M4Jni(Buffer buffer, int i2, int i3, float[] fArr, int i4);

    public static native void transformV4M4Jni(float[] fArr, int i2, int i3, float[] fArr2, int i4);
}
