package com.baidu.rtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                method = null;
            }
            if (method != null) {
                mCropMethod = method;
            }
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        if (mCropMethod == null) {
            try {
                Class<?> cls2 = Class.forName("org.webrtc.JavaI420Buffer");
                try {
                    mCropClass = cls2;
                    method2 = cls2.getMethod("cropAndScaleI420", VideoFrame.I420Buffer.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                }
                if (method2 != null) {
                    mCropMethod = method2;
                }
            } catch (ClassNotFoundException e5) {
                e5.printStackTrace();
            }
        }
    }

    public RTCI420Buffer(int i2, int i3, ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2, int i5, ByteBuffer byteBuffer3, int i6, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), byteBuffer, Integer.valueOf(i4), byteBuffer2, Integer.valueOf(i5), byteBuffer3, Integer.valueOf(i6), runnable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.width = i2;
        this.height = i3;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i4;
        this.strideU = i5;
        this.strideV = i6;
        this.refCountDelegate = new RefCountDelegate(this, runnable);
    }

    public static RTCI420Buffer allocate(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            int i4 = (i3 + 1) / 2;
            int i5 = (i2 + 1) / 2;
            int i6 = i2 * i3;
            int i7 = i6 + 0;
            int i8 = i5 * i4;
            int i9 = i7 + i8;
            final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i6 + (i5 * 2 * i4));
            nativeAllocateByteBuffer.position(0);
            nativeAllocateByteBuffer.limit(i7);
            ByteBuffer slice = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i7);
            nativeAllocateByteBuffer.limit(i9);
            ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i9);
            nativeAllocateByteBuffer.limit(i9 + i8);
            return new RTCI420Buffer(i2, i3, slice, i2, slice2, i5, nativeAllocateByteBuffer.slice(), i5, new Runnable() { // from class: com.baidu.rtc._$$Lambda$RTCI420Buffer$MVKNXKaN7jHpOaqK1ceHPyNb6Ts
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

    public static void checkCapacity(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65539, null, byteBuffer, i2, i3, i4) == null) || byteBuffer.capacity() >= (i5 = (i4 * (i3 - 1)) + i2)) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i5 + " bytes, but was " + byteBuffer.capacity());
    }

    public static RTCI420Buffer wrap(int i2, int i3, ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2, int i5, ByteBuffer byteBuffer3, int i6, Runnable runnable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), byteBuffer, Integer.valueOf(i4), byteBuffer2, Integer.valueOf(i5), byteBuffer3, Integer.valueOf(i6), runnable})) == null) {
            if (byteBuffer == null || byteBuffer2 == null || byteBuffer3 == null) {
                throw new IllegalArgumentException("Data buffers cannot be null.");
            }
            if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
                ByteBuffer slice = byteBuffer.slice();
                ByteBuffer slice2 = byteBuffer2.slice();
                ByteBuffer slice3 = byteBuffer3.slice();
                int i7 = (i2 + 1) / 2;
                int i8 = (i3 + 1) / 2;
                checkCapacity(slice, i2, i3, i4);
                checkCapacity(slice2, i7, i8, i5);
                checkCapacity(slice3, i7, i8, i6);
                return new RTCI420Buffer(i2, i3, slice, i4, slice2, i5, slice3, i6, runnable);
            }
            throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
        }
        return (RTCI420Buffer) invokeCommon.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            try {
                if (mCropMethod != null) {
                    return (VideoFrame.Buffer) mCropMethod.invoke(mCropClass, this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
                }
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
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
