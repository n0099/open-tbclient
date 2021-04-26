package com.baidu.rtc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.webrtc.JniCommon;
import org.webrtc.RefCounted;
import org.webrtc.VideoFrame;
/* loaded from: classes2.dex */
public class RTCI420Buffer implements VideoFrame.I420Buffer {
    public static Class mCropClass;
    public static Method mCropMethod;
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
        public final AtomicInteger refCount = new AtomicInteger(1);
        public final Runnable releaseCallback;

        public RefCountDelegate(Runnable runnable) {
            this.releaseCallback = runnable;
        }

        @Override // org.webrtc.RefCounted
        public void release() {
            Runnable runnable;
            if (this.refCount.decrementAndGet() != 0 || (runnable = this.releaseCallback) == null) {
                return;
            }
            runnable.run();
        }

        @Override // org.webrtc.RefCounted
        public void retain() {
            this.refCount.incrementAndGet();
        }
    }

    static {
        Method method;
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
        this.width = i2;
        this.height = i3;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i4;
        this.strideU = i5;
        this.strideV = i6;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static RTCI420Buffer allocate(int i2, int i3) {
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
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public static void checkCapacity(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int i5 = (i4 * (i3 - 1)) + i2;
        if (byteBuffer.capacity() >= i5) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i5 + " bytes, but was " + byteBuffer.capacity());
    }

    public static RTCI420Buffer wrap(int i2, int i3, ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2, int i5, ByteBuffer byteBuffer3, int i6, Runnable runnable) {
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

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
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

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }
}
