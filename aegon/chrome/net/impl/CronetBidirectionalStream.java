package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.CronetException;
import aegon.chrome.net.ExperimentalBidirectionalStream;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.impl.UrlResponseInfoImpl;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes.dex */
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public boolean mEndOfStreamWritten;
    public CronetException mException;
    public final Executor mExecutor;
    public LinkedList<ByteBuffer> mFlushData;
    public final String mInitialMethod;
    public final String mInitialUrl;
    public RequestFinishedInfo.Metrics mMetrics;
    public long mNativeStream;
    public final Object mNativeStreamLock;
    public Runnable mOnDestroyedCallbackForTesting;
    public LinkedList<ByteBuffer> mPendingData;
    public int mReadState;
    public final Collection<Object> mRequestAnnotations;
    public final CronetUrlRequestContext mRequestContext;
    public boolean mRequestHeadersSent;
    public UrlResponseInfoImpl mResponseInfo;
    public int mWriteState;

    /* loaded from: classes.dex */
    public final class OnReadCompletedRunnable implements Runnable {
        public ByteBuffer mByteBuffer;
    }

    /* loaded from: classes.dex */
    public final class OnWriteCompletedRunnable implements Runnable {
        public ByteBuffer mByteBuffer;
        public final boolean mEndOfStream;

        public OnWriteCompletedRunnable(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mEndOfStream = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (CronetBidirectionalStream.this.isDoneLocked()) {
                        return;
                    }
                    if (this.mEndOfStream) {
                        CronetBidirectionalStream.this.mWriteState = 10;
                        int unused = CronetBidirectionalStream.this.mReadState;
                    }
                    CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                    UrlResponseInfoImpl unused2 = CronetBidirectionalStream.this.mResponseInfo;
                    throw null;
                }
            } catch (Exception e2) {
                CronetBidirectionalStream.this.onCallbackException(e2);
            }
        }
    }

    public static /* synthetic */ boolean access$1100(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static /* synthetic */ void access$500(CronetBidirectionalStream cronetBidirectionalStream) {
    }

    public static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
        }
        return arrayList;
    }

    private native long nativeCreateBidirectionalStream(long j, boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3);

    private native void nativeDestroy(long j, boolean z);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeSendRequestHeaders(long j);

    private native int nativeStart(long j, String str, int i2, String str2, String[] strArr, boolean z);

    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                    UrlResponseInfoImpl unused = CronetBidirectionalStream.this.mResponseInfo;
                    throw null;
                } catch (Exception e2) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", e2);
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j) {
        UrlResponseInfoImpl urlResponseInfoImpl = this.mResponseInfo;
        if (urlResponseInfoImpl != null) {
            urlResponseInfoImpl.mReceivedByteCount.set(j);
        }
        if (i2 == 10 || i2 == 3) {
            failWithException(new QuicExceptionImpl("Exception in BidirectionalStream: " + str, i2, i3, i4));
            return;
        }
        failWithException(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + str, i2, i3));
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        synchronized (this.mNativeStreamLock) {
            if (this.mMetrics != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
            this.mRequestContext.reportRequestFinished(new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mReadState == 7 ? 0 : this.mReadState == 5 ? 2 : 1, this.mResponseInfo, this.mException));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        int i5;
        this.mResponseInfo.mReceivedByteCount.set(j);
        OnReadCompletedRunnable onReadCompletedRunnable = null;
        if (byteBuffer.position() != i3 || byteBuffer.limit() != i4) {
            failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        } else if (i2 < 0 || (i5 = i3 + i2) > i4) {
            failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i5);
            onReadCompletedRunnable.mByteBuffer = byteBuffer;
            postTaskToExecutor(null);
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i2, String str, String[] strArr, long j) {
        try {
            this.mResponseInfo = new UrlResponseInfoImpl(Arrays.asList(this.mInitialUrl), i2, "", headersListFromStrings(strArr), false, str, null, j);
            postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                        if (CronetBidirectionalStream.this.isDoneLocked()) {
                            return;
                        }
                        CronetBidirectionalStream.this.mReadState = 2;
                        try {
                            CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                            UrlResponseInfoImpl unused = CronetBidirectionalStream.this.mResponseInfo;
                            throw null;
                        } catch (Exception e2) {
                            CronetBidirectionalStream.this.onCallbackException(e2);
                        }
                    }
                }
            });
        } catch (Exception unused) {
            failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfoImpl.HeaderBlockImpl headerBlockImpl = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(strArr));
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (CronetBidirectionalStream.this.isDoneLocked()) {
                        return;
                    }
                    try {
                        CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                        UrlResponseInfoImpl unused = CronetBidirectionalStream.this.mResponseInfo;
                        throw null;
                    } catch (Exception e2) {
                        CronetBidirectionalStream.this.onCallbackException(e2);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream cronetBidirectionalStream;
                int i2;
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (CronetBidirectionalStream.this.isDoneLocked()) {
                        return;
                    }
                    CronetBidirectionalStream.this.mRequestHeadersSent = z;
                    CronetBidirectionalStream.this.mReadState = 2;
                    if (CronetBidirectionalStream.access$1100(CronetBidirectionalStream.this.mInitialMethod) || !CronetBidirectionalStream.this.mRequestHeadersSent) {
                        cronetBidirectionalStream = CronetBidirectionalStream.this;
                        i2 = 8;
                    } else {
                        cronetBidirectionalStream = CronetBidirectionalStream.this;
                        i2 = 10;
                    }
                    cronetBidirectionalStream.mWriteState = i2;
                    try {
                        CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                        throw null;
                    } catch (Exception e2) {
                        CronetBidirectionalStream.this.onCallbackException(e2);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        synchronized (this.mNativeStreamLock) {
            if (isDoneLocked()) {
                return;
            }
            this.mWriteState = 8;
            if (!this.mFlushData.isEmpty()) {
                sendFlushDataLocked();
            }
            for (int i2 = 0; i2 < byteBufferArr.length; i2++) {
                ByteBuffer byteBuffer = byteBufferArr[i2];
                if (byteBuffer.position() != iArr[i2] || byteBuffer.limit() != iArr2[i2]) {
                    failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
                    return;
                }
                byteBuffer.position(byteBuffer.limit());
                boolean z2 = true;
                if (!z || i2 != byteBufferArr.length - 1) {
                    z2 = false;
                }
                postTaskToExecutor(new OnWriteCompletedRunnable(byteBuffer, z2));
            }
        }
    }

    public final void destroyNativeStreamLocked(boolean z) {
        String str = CronetUrlRequestContext.LOG_TAG;
        Log.i(str, "destroyNativeStreamLocked " + toString(), new Object[0]);
        long j = this.mNativeStream;
        if (j == 0) {
            return;
        }
        nativeDestroy(j, z);
        this.mRequestContext.onRequestDestroyed();
        this.mNativeStream = 0L;
        Runnable runnable = this.mOnDestroyedCallbackForTesting;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void failWithException(final CronetException cronetException) {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.failWithExceptionOnExecutor(cronetException);
            }
        });
    }

    public final void failWithExceptionOnExecutor(CronetException cronetException) {
        this.mException = cronetException;
        synchronized (this.mNativeStreamLock) {
            if (isDoneLocked()) {
                return;
            }
            this.mWriteState = 6;
            this.mReadState = 6;
            destroyNativeStreamLocked(false);
            try {
                throw null;
            } catch (Exception e2) {
                Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", e2);
            }
        }
    }

    public final boolean isDoneLocked() {
        return this.mReadState != 0 && this.mNativeStream == 0;
    }

    public final void onCallbackException(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("CalledByNative method has thrown an exception", exc);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
        failWithExceptionOnExecutor(callbackExceptionImpl);
    }

    public final void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e2) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
            synchronized (this.mNativeStreamLock) {
                this.mWriteState = 6;
                this.mReadState = 6;
                destroyNativeStreamLocked(false);
            }
        }
    }

    public final void sendFlushDataLocked() {
        int size = this.mFlushData.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            ByteBuffer poll = this.mFlushData.poll();
            byteBufferArr[i2] = poll;
            iArr[i2] = poll.position();
            iArr2[i2] = poll.limit();
        }
        this.mWriteState = 9;
        this.mRequestHeadersSent = true;
        if (nativeWritevData(this.mNativeStream, byteBufferArr, iArr, iArr2, this.mEndOfStreamWritten && this.mPendingData.isEmpty())) {
            return;
        }
        this.mWriteState = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    }
}
