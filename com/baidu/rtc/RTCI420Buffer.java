package com.baidu.rtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.webrtc.JniCommon;
import org.webrtc.RefCounted;
import org.webrtc.VideoFrame;
/* loaded from: classes2.dex */
public class RTCI420Buffer implements VideoFrame.I420Buffer {
    public static /* synthetic */ Interceptable $ic;
    public static Class mCropClass;
    public static Method mCropMethod;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer dataU;
    public final ByteBuffer dataV;
    public final ByteBuffer dataY;
    public final int height;
    public final RefCountDelegate refCountDelegate;
    public final int strideU;
    public final int strideV;
    public final int strideY;
    public final int width;

    /* loaded from: classes2.dex */
    public class RefCountDelegate implements RefCounted {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger refCount;
        public final Runnable releaseCallback;
        public final /* synthetic */ RTCI420Buffer this$0;

        public RefCountDelegate(RTCI420Buffer rTCI420Buffer, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rTCI420Buffer, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rTCI420Buffer;
            this.refCount = new AtomicInteger(1);
            this.releaseCallback = runnable;
        }

        @Override // org.webrtc.RefCounted
        public void release() {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.refCount.decrementAndGet() == 0 && (runnable = this.releaseCallback) != null) {
                runnable.run();
            }
        }

        @Override // org.webrtc.RefCounted
        public void retain() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.refCount.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        Method method;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-16397491, "Lcom/baidu/rtc/RTCI420Buffer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-16397491, "Lcom/baidu/rtc/RTCI420Buffer;");
                return;
            }
        }
        Method method2 = null;
        try {
            Class<?> cls = Class.forName("org.webrtc.VideoFrame");
            try {
                mCropClass = cls;
                method = cls.getMethod("cropAndScaleI420", VideoFrame.I420Buffer.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                method = null;
            }
            if (method != null) {
                mCropMethod = method;
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        if (mCropMethod == null) {
            try {
                Class<?> cls2 = Class.forName("org.webrtc.JavaI420Buffer");
                try {
                    mCropClass = cls2;
                    method2 = cls2.getMethod("cropAndScaleI420", VideoFrame.I420Buffer.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                }
                if (method2 != null) {
                    mCropMethod = method2;
                }
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            }
        }
    }

    public RTCI420Buffer(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), byteBuffer2, Integer.valueOf(i4), byteBuffer3, Integer.valueOf(i5), runnable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.width = i;
        this.height = i2;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i3;
        this.strideU = i4;
        this.strideV = i5;
        this.refCountDelegate = new RefCountDelegate(this, runnable);
    }

    public static RTCI420Buffer allocate(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            int i3 = (i2 + 1) / 2;
            int i4 = (i + 1) / 2;
            int i5 = i * i2;
            int i6 = i5 + 0;
            int i7 = i4 * i3;
            int i8 = i6 + i7;
            final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i5 + (i4 * 2 * i3));
            nativeAllocateByteBuffer.position(0);
            nativeAllocateByteBuffer.limit(i6);
            ByteBuffer slice = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i6);
            nativeAllocateByteBuffer.limit(i8);
            ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i8);
            nativeAllocateByteBuffer.limit(i8 + i7);
            return new RTCI420Buffer(i, i2, slice, i, slice2, i4, nativeAllocateByteBuffer.slice(), i4, new Runnable() { // from class: com.repackage.jc1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
                    }
                }
            });
        }
        return (RTCI420Buffer) invokeII.objValue;
    }

    public static void checkCapacity(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, i, i2, i3) == null) || byteBuffer.capacity() >= (i4 = (i3 * (i2 - 1)) + i)) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i4 + " bytes, but was " + byteBuffer.capacity());
    }

    public static RTCI420Buffer wrap(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5, Runnable runnable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), byteBuffer2, Integer.valueOf(i4), byteBuffer3, Integer.valueOf(i5), runnable})) == null) {
            if (byteBuffer != null && byteBuffer2 != null && byteBuffer3 != null) {
                if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
                    ByteBuffer slice = byteBuffer.slice();
                    ByteBuffer slice2 = byteBuffer2.slice();
                    ByteBuffer slice3 = byteBuffer3.slice();
                    int i6 = (i + 1) / 2;
                    int i7 = (i2 + 1) / 2;
                    checkCapacity(slice, i, i2, i3);
                    checkCapacity(slice2, i6, i7, i4);
                    checkCapacity(slice3, i6, i7, i5);
                    return new RTCI420Buffer(i, i2, slice, i3, slice2, i4, slice3, i5, runnable);
                }
                throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
            }
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        return (RTCI420Buffer) invokeCommon.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            try {
                if (mCropMethod != null) {
                    return (VideoFrame.Buffer) mCropMethod.invoke(mCropClass, this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                }
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (VideoFrame.Buffer) invokeCommon.objValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataU.slice() : (ByteBuffer) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dataV.slice() : (ByteBuffer) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.dataY.slice() : (ByteBuffer) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.height : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.strideU : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.strideV : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.strideY : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.width : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.refCountDelegate.release();
        }
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.refCountDelegate.retain();
        }
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            retain();
            return this;
        }
        return (VideoFrame.I420Buffer) invokeV.objValue;
    }
}
