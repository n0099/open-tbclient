package com.badlogic.gdx.utils;

import com.baidu.tieba.r2;
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
        new r2();
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

    public static FloatBuffer a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            return allocateDirect.asFloatBuffer();
        }
        return (FloatBuffer) invokeI.objValue;
    }

    public static IntBuffer b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            return allocateDirect.asIntBuffer();
        }
        return (IntBuffer) invokeI.objValue;
    }
}
