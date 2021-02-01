package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.CronetException;
import aegon.chrome.net.ExperimentalBidirectionalStream;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlResponseInfo;
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
import org.apache.http.client.methods.HttpHead;
/* loaded from: classes3.dex */
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    public static final /* synthetic */ boolean $assertionsDisabled = !CronetBidirectionalStream.class.desiredAssertionStatus();
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

    /* loaded from: classes3.dex */
    private final class OnReadCompletedRunnable implements Runnable {
        public ByteBuffer mByteBuffer;
    }

    /* loaded from: classes3.dex */
    private final class OnWriteCompletedRunnable implements Runnable {
        public ByteBuffer mByteBuffer;
        public final boolean mEndOfStream;

        public OnWriteCompletedRunnable(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mEndOfStream = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
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
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    UrlResponseInfoImpl unused2 = CronetBidirectionalStream.this.mResponseInfo;
                    boolean z = this.mEndOfStream;
                    throw null;
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.onCallbackException(e);
            }
        }
    }

    public static /* synthetic */ boolean access$1100(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    public static /* synthetic */ void access$500(CronetBidirectionalStream cronetBidirectionalStream) {
    }

    public static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private native long nativeCreateBidirectionalStream(long j, boolean z, boolean z2, boolean z3, int i, boolean z4, int i2);

    private native void nativeDestroy(long j, boolean z);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i, int i2);

    private native void nativeSendRequestHeaders(long j);

    private native int nativeStart(long j, String str, int i, String str2, String[] strArr, boolean z);

    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    UrlResponseInfoImpl unused = CronetBidirectionalStream.this.mResponseInfo;
                    throw null;
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        UrlResponseInfoImpl urlResponseInfoImpl = this.mResponseInfo;
        if (urlResponseInfoImpl != null) {
            urlResponseInfoImpl.mReceivedByteCount.set(j);
        }
        if (i == 10 || i == 3) {
            failWithException(new QuicExceptionImpl("Exception in BidirectionalStream: " + str, i, i2, i3));
        } else {
            failWithException(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        synchronized (this.mNativeStreamLock) {
            if (this.mMetrics != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
            if (!$assertionsDisabled && this.mReadState != this.mWriteState) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && this.mReadState != 7 && this.mReadState != 6 && this.mReadState != 5) {
                throw new AssertionError();
            }
            this.mRequestContext.reportRequestFinished(new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mReadState == 7 ? 0 : this.mReadState == 5 ? 2 : 1, this.mResponseInfo, this.mException));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        int i4;
        OnReadCompletedRunnable onReadCompletedRunnable = null;
        this.mResponseInfo.mReceivedByteCount.set(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        } else if (i < 0 || (i4 = i2 + i) > i3) {
            failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i4);
            if (!$assertionsDisabled && onReadCompletedRunnable.mByteBuffer != null) {
                throw new AssertionError();
            }
            onReadCompletedRunnable.mByteBuffer = byteBuffer;
            postTaskToExecutor(null);
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.mResponseInfo = new UrlResponseInfoImpl(Arrays.asList(this.mInitialUrl), i, "", headersListFromStrings(strArr), false, str, null, j);
            postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                        if (CronetBidirectionalStream.this.isDoneLocked()) {
                            return;
                        }
                        CronetBidirectionalStream.this.mReadState = 2;
                    }
                    try {
                        CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                        CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                        UrlResponseInfoImpl unused = CronetBidirectionalStream.this.mResponseInfo;
                        throw null;
                    } catch (Exception e) {
                        CronetBidirectionalStream.this.onCallbackException(e);
                    }
                }
            });
        } catch (Exception e) {
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
                }
                try {
                    CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    UrlResponseInfoImpl unused = CronetBidirectionalStream.this.mResponseInfo;
                    UrlResponseInfo.HeaderBlock headerBlock = headerBlockImpl;
                    throw null;
                } catch (Exception e) {
                    CronetBidirectionalStream.this.onCallbackException(e);
                }
            }
        });
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (CronetBidirectionalStream.this.isDoneLocked()) {
                        return;
                    }
                    CronetBidirectionalStream.this.mRequestHeadersSent = z;
                    CronetBidirectionalStream.this.mReadState = 2;
                    if (CronetBidirectionalStream.access$1100(CronetBidirectionalStream.this.mInitialMethod) || !CronetBidirectionalStream.this.mRequestHeadersSent) {
                        CronetBidirectionalStream.this.mWriteState = 8;
                    } else {
                        CronetBidirectionalStream.this.mWriteState = 10;
                    }
                }
                try {
                    CronetBidirectionalStream.access$500(CronetBidirectionalStream.this);
                    CronetBidirectionalStream cronetBidirectionalStream = CronetBidirectionalStream.this;
                    throw null;
                } catch (Exception e) {
                    CronetBidirectionalStream.this.onCallbackException(e);
                }
            }
        });
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        if (!$assertionsDisabled && byteBufferArr.length != iArr.length) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length != iArr2.length) {
            throw new AssertionError();
        }
        synchronized (this.mNativeStreamLock) {
            if (isDoneLocked()) {
                return;
            }
            this.mWriteState = 8;
            if (!this.mFlushData.isEmpty()) {
                sendFlushDataLocked();
            }
            int i = 0;
            while (i < byteBufferArr.length) {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer.position() != iArr[i] || byteBuffer.limit() != iArr2[i]) {
                    failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
                    return;
                }
                byteBuffer.position(byteBuffer.limit());
                postTaskToExecutor(new OnWriteCompletedRunnable(byteBuffer, z && i == byteBufferArr.length + (-1)));
                i++;
            }
        }
    }

    public final void destroyNativeStreamLocked(boolean z) {
        Log.i(CronetUrlRequestContext.LOG_TAG, "destroyNativeStreamLocked " + toString(), new Object[0]);
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
        }
        try {
            UrlResponseInfoImpl urlResponseInfoImpl = this.mResponseInfo;
            throw null;
        } catch (Exception e) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", e);
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
        } catch (RejectedExecutionException e) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            synchronized (this.mNativeStreamLock) {
                this.mWriteState = 6;
                this.mReadState = 6;
                destroyNativeStreamLocked(false);
            }
        }
    }

    public final void sendFlushDataLocked() {
        boolean z = true;
        if (!$assertionsDisabled && this.mWriteState != 8) {
            throw new AssertionError();
        }
        int size = this.mFlushData.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.mFlushData.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.mFlushData.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.mWriteState = 9;
        this.mRequestHeadersSent = true;
        if (nativeWritevData(this.mNativeStream, byteBufferArr, iArr, iArr2, (this.mEndOfStreamWritten && this.mPendingData.isEmpty()) ? false : false)) {
            return;
        }
        this.mWriteState = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    }
}
