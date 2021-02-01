package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import android.annotation.SuppressLint;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class CronetUploadDataStream extends UploadDataSink {
    public static final String TAG = "CronetUploadDataStream";
    public ByteBuffer mByteBuffer;
    public long mByteBufferLimit;
    public final VersionSafeCallbacks$UploadDataProviderWrapper mDataProvider;
    public boolean mDestroyAdapterPostponed;
    public final Executor mExecutor;
    public long mLength;
    public Runnable mOnDestroyedCallbackForTesting;
    public long mRemainingLength;
    public final CronetUrlRequest mRequest;
    public long mUploadDataStreamAdapter;
    public final Runnable mReadTask = new Runnable() { // from class: aegon.chrome.net.impl.CronetUploadDataStream.1
        public static final /* synthetic */ boolean $assertionsDisabled = !CronetUploadDataStream.class.desiredAssertionStatus();

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mUploadDataStreamAdapter == 0) {
                    return;
                }
                CronetUploadDataStream.this.checkState(3);
                if (CronetUploadDataStream.this.mByteBuffer == null) {
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
                CronetUploadDataStream.this.mInWhichUserCallback = 0;
                try {
                    CronetUploadDataStream.access$500(CronetUploadDataStream.this);
                    if (!$assertionsDisabled && CronetUploadDataStream.this.mByteBuffer.position() != 0) {
                        throw new AssertionError();
                    }
                    VersionSafeCallbacks$UploadDataProviderWrapper versionSafeCallbacks$UploadDataProviderWrapper = CronetUploadDataStream.this.mDataProvider;
                    versionSafeCallbacks$UploadDataProviderWrapper.mWrappedProvider.read(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
                } catch (Exception e) {
                    CronetUploadDataStream.this.onError(e);
                }
            }
        }
    };
    public final Object mLock = new Object();
    public int mInWhichUserCallback = 3;

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.mExecutor = executor;
        this.mDataProvider = new VersionSafeCallbacks$UploadDataProviderWrapper(uploadDataProvider);
        this.mRequest = cronetUrlRequest;
    }

    public static /* synthetic */ void access$500(CronetUploadDataStream cronetUploadDataStream) {
        cronetUploadDataStream.mRequest.checkCallingThread();
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    public static native void nativeDestroy(long j);

    private native void nativeOnReadSucceeded(long j, int i, boolean z);

    private native void nativeOnRewindSucceeded(long j);

    public void attachNativeAdapterToRequest(long j) {
        synchronized (this.mLock) {
            this.mUploadDataStreamAdapter = nativeAttachUploadDataToRequest(j, this.mLength);
        }
    }

    public final void checkState(int i) {
        if (this.mInWhichUserCallback != i) {
            throw new IllegalStateException("Expected " + i + ", but was " + this.mInWhichUserCallback);
        }
    }

    public final void destroyAdapter() {
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == 0) {
                this.mDestroyAdapterPostponed = true;
            } else if (this.mUploadDataStreamAdapter == 0) {
            } else {
                nativeDestroy(this.mUploadDataStreamAdapter);
                this.mUploadDataStreamAdapter = 0L;
                if (this.mOnDestroyedCallbackForTesting != null) {
                    this.mOnDestroyedCallbackForTesting.run();
                }
                postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.access$500(CronetUploadDataStream.this);
                            CronetUploadDataStream.this.mDataProvider.mWrappedProvider.close();
                        } catch (Exception e) {
                            Log.e(CronetUploadDataStream.TAG, "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    public final void destroyAdapterIfPostponed() {
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == 0) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mDestroyAdapterPostponed) {
                destroyAdapter();
            }
        }
    }

    public void initializeWithRequest() {
        synchronized (this.mLock) {
            this.mInWhichUserCallback = 2;
        }
        try {
            this.mRequest.checkCallingThread();
            this.mLength = this.mDataProvider.mWrappedProvider.getLength();
            this.mRemainingLength = this.mLength;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mInWhichUserCallback = 3;
        }
    }

    public final void onError(Throwable th) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == 3) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            z = this.mInWhichUserCallback == 2;
            this.mInWhichUserCallback = 3;
            this.mByteBuffer = null;
            destroyAdapterIfPostponed();
        }
        if (z) {
            try {
                this.mDataProvider.mWrappedProvider.close();
            } catch (Exception e) {
                Log.e(TAG, "Failure closing data provider", e);
            }
        }
        this.mRequest.onUploadException(th);
    }

    @Override // aegon.chrome.net.UploadDataSink
    public void onReadError(Exception exc) {
        synchronized (this.mLock) {
            checkState(0);
            onError(exc);
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    @SuppressLint({"DefaultLocale"})
    public void onReadSucceeded(boolean z) {
        synchronized (this.mLock) {
            checkState(0);
            if (this.mByteBufferLimit != this.mByteBuffer.limit()) {
                throw new IllegalStateException("ByteBuffer limit changed");
            }
            if (z && this.mLength >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mRemainingLength -= position;
            if (this.mRemainingLength < 0 && this.mLength >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)));
            }
            this.mByteBuffer.position(0);
            this.mByteBuffer = null;
            this.mInWhichUserCallback = 3;
            destroyAdapterIfPostponed();
            if (this.mUploadDataStreamAdapter == 0) {
                return;
            }
            nativeOnReadSucceeded(this.mUploadDataStreamAdapter, position, z);
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    public void onRewindSucceeded() {
        synchronized (this.mLock) {
            checkState(1);
            this.mInWhichUserCallback = 3;
            this.mRemainingLength = this.mLength;
            if (this.mUploadDataStreamAdapter == 0) {
                return;
            }
            nativeOnRewindSucceeded(this.mUploadDataStreamAdapter);
        }
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    public void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.mRequest.onUploadException(th);
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        this.mByteBufferLimit = byteBuffer.limit();
        postTaskToExecutor(this.mReadTask);
    }

    @CalledByNative
    public void rewind() {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mUploadDataStreamAdapter == 0) {
                        return;
                    }
                    CronetUploadDataStream.this.checkState(3);
                    CronetUploadDataStream.this.mInWhichUserCallback = 1;
                    try {
                        CronetUploadDataStream.access$500(CronetUploadDataStream.this);
                        VersionSafeCallbacks$UploadDataProviderWrapper versionSafeCallbacks$UploadDataProviderWrapper = CronetUploadDataStream.this.mDataProvider;
                        versionSafeCallbacks$UploadDataProviderWrapper.mWrappedProvider.rewind(CronetUploadDataStream.this);
                    } catch (Exception e) {
                        CronetUploadDataStream.this.onError(e);
                    }
                }
            }
        });
    }
}
