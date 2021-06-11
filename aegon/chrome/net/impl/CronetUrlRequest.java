package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.CronetException;
import aegon.chrome.net.InlineExecutionProhibitedException;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UrlRequest;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes.dex */
public final class CronetUrlRequest extends UrlRequestBase {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final boolean mAllowDirectExecutor;
    public final VersionSafeCallbacks$UrlRequestCallback mCallback;
    public final boolean mDisableCache;
    public final boolean mDisableConnectionMigration;
    public CronetException mException;
    public final Executor mExecutor;
    public int mFinishedReason;
    public String mInitialMethod;
    public final String mInitialUrl;
    public CronetMetrics mMetrics;
    public Runnable mOnDestroyedCallbackForTesting;
    public OnReadCompletedRunnable mOnReadCompletedTask;
    public final int mPriority;
    public final Collection<Object> mRequestAnnotations;
    public final CronetUrlRequestContext mRequestContext;
    public final VersionSafeCallbacks$RequestFinishedInfoListener mRequestFinishedListener;
    public UrlResponseInfoImpl mResponseInfo;
    public boolean mStarted;
    public final int mTrafficStatsTag;
    public final boolean mTrafficStatsTagSet;
    public final int mTrafficStatsUid;
    public final boolean mTrafficStatsUidSet;
    public CronetUploadDataStream mUploadDataStream;
    public long mUrlRequestAdapter;
    public boolean mWaitingOnRead;
    public boolean mWaitingOnRedirect;
    public final Object mUrlRequestAdapterLock = new Object();
    public final List<String> mUrlChain = new ArrayList();
    public final HeadersList mRequestHeaders = new HeadersList(null);

    /* loaded from: classes.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public /* synthetic */ HeadersList(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: classes.dex */
    public final class OnReadCompletedRunnable implements Runnable {
        public ByteBuffer mByteBuffer;

        public /* synthetic */ OnReadCompletedRunnable(AnonymousClass1 anonymousClass1) {
            CronetUrlRequest.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.checkCallingThread();
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.mWaitingOnRead = true;
                    VersionSafeCallbacks$UrlRequestCallback versionSafeCallbacks$UrlRequestCallback = CronetUrlRequest.this.mCallback;
                    versionSafeCallbacks$UrlRequestCallback.mWrappedCallback.onReadCompleted(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo, byteBuffer);
                }
            } catch (Exception e2) {
                CronetUrlRequest.this.onCallbackException(e2);
            }
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, RequestFinishedInfo.Listener listener) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        this.mAllowDirectExecutor = z3;
        this.mRequestContext = cronetUrlRequestContext;
        this.mInitialUrl = str;
        this.mUrlChain.add(str);
        int i5 = 4;
        if (i2 == 0) {
            i5 = 1;
        } else if (i2 == 1) {
            i5 = 2;
        } else if (i2 == 2) {
            i5 = 3;
        } else if (i2 == 4) {
            i5 = 5;
        }
        this.mPriority = i5;
        this.mCallback = new VersionSafeCallbacks$UrlRequestCallback(callback);
        this.mExecutor = executor;
        this.mRequestAnnotations = collection;
        this.mDisableCache = z;
        this.mDisableConnectionMigration = z2;
        this.mTrafficStatsTagSet = z4;
        this.mTrafficStatsTag = i3;
        this.mTrafficStatsUidSet = z5;
        this.mTrafficStatsUid = i4;
        this.mRequestFinishedListener = listener != null ? new VersionSafeCallbacks$RequestFinishedInfoListener(listener) : null;
    }

    public static /* synthetic */ void access$1300(CronetUrlRequest cronetUrlRequest) {
        CronetMetrics cronetMetrics = cronetUrlRequest.mMetrics;
        if (cronetMetrics != null) {
            final RequestFinishedInfoImpl requestFinishedInfoImpl = new RequestFinishedInfoImpl(cronetUrlRequest.mInitialUrl, cronetUrlRequest.mRequestAnnotations, cronetMetrics, cronetUrlRequest.mFinishedReason, cronetUrlRequest.mResponseInfo, cronetUrlRequest.mException);
            cronetUrlRequest.mRequestContext.reportRequestFinished(requestFinishedInfoImpl);
            VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener = cronetUrlRequest.mRequestFinishedListener;
            if (versionSafeCallbacks$RequestFinishedInfoListener != null) {
                try {
                    versionSafeCallbacks$RequestFinishedInfoListener.mWrappedListener.getExecutor().execute(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.9
                        {
                            CronetUrlRequest.this = cronetUrlRequest;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener2 = CronetUrlRequest.this.mRequestFinishedListener;
                            versionSafeCallbacks$RequestFinishedInfoListener2.mWrappedListener.onRequestFinished(requestFinishedInfoImpl);
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
                }
            }
        }
    }

    public static /* synthetic */ void access$900(CronetUrlRequest cronetUrlRequest) {
        cronetUrlRequest.nativeStart(cronetUrlRequest.mUrlRequestAdapter);
    }

    private native boolean nativeAddRequestHeader(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeCreateRequestAdapter(long j, String str, int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4);

    private native void nativeDestroy(long j, boolean z);

    private native void nativeFollowDeferredRedirect(long j);

    private native void nativeGetStatus(long j, VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    private native boolean nativeSetHttpMethod(long j, String str);

    private native void nativeStart(long j);

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.6
            {
                CronetUrlRequest.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetUrlRequest.this.mCallback.mWrappedCallback.onCanceled(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo);
                    CronetUrlRequest.access$1300(CronetUrlRequest.this);
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
            failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + str, i2, i3, i4));
            return;
        }
        switch (i2) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 7;
                break;
            case 8:
                i2 = 8;
                break;
            case 9:
                i2 = 9;
                break;
            case 10:
                i2 = 10;
                break;
            case 11:
                i2 = 11;
                break;
            default:
                String str2 = CronetUrlRequestContext.LOG_TAG;
                Log.e(str2, "Unknown error code: " + i2, new Object[0]);
                break;
        }
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + str, i2, i3));
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mMetrics != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
        }
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mOnDestroyedCallbackForTesting != null) {
                this.mOnDestroyedCallbackForTesting.run();
            }
            if (this.mException == null) {
                return;
            }
            try {
                this.mExecutor.execute(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.8
                    {
                        CronetUrlRequest.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUrlRequest.this.mCallback.mWrappedCallback.onFailed(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo, CronetUrlRequest.this.mException);
                            CronetUrlRequest.access$1300(CronetUrlRequest.this);
                        } catch (Exception e2) {
                            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onFailed method", e2);
                        }
                    }
                });
            } catch (RejectedExecutionException e2) {
                Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        this.mResponseInfo.mReceivedByteCount.set(j);
        if (byteBuffer.position() != i3 || byteBuffer.limit() != i4) {
            failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mOnReadCompletedTask == null) {
            this.mOnReadCompletedTask = new OnReadCompletedRunnable(null);
        }
        byteBuffer.position(i3 + i2);
        OnReadCompletedRunnable onReadCompletedRunnable = this.mOnReadCompletedTask;
        onReadCompletedRunnable.mByteBuffer = byteBuffer;
        postTaskToExecutor(onReadCompletedRunnable);
    }

    @CalledByNative
    private void onRedirectReceived(final String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread = prepareResponseInfoOnNetworkThread(i2, str2, strArr, z, str3, str4, j);
        this.mUrlChain.add(str);
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.3
            {
                CronetUrlRequest.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CronetUrlRequest.this.checkCallingThread();
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.mWaitingOnRedirect = true;
                    try {
                        VersionSafeCallbacks$UrlRequestCallback versionSafeCallbacks$UrlRequestCallback = CronetUrlRequest.this.mCallback;
                        versionSafeCallbacks$UrlRequestCallback.mWrappedCallback.onRedirectReceived(CronetUrlRequest.this, prepareResponseInfoOnNetworkThread, str);
                    } catch (Exception e2) {
                        CronetUrlRequest.this.onCallbackException(e2);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(i2, str, strArr, z, str2, str3, j);
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.4
            {
                CronetUrlRequest.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CronetUrlRequest.this.checkCallingThread();
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.mWaitingOnRead = true;
                    try {
                        VersionSafeCallbacks$UrlRequestCallback versionSafeCallbacks$UrlRequestCallback = CronetUrlRequest.this.mCallback;
                        versionSafeCallbacks$UrlRequestCallback.mWrappedCallback.onResponseStarted(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo);
                    } catch (Exception e2) {
                        CronetUrlRequest.this.onCallbackException(e2);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener, final int i2) {
        postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener2 = versionSafeCallbacks$UrlRequestStatusListener;
                int i4 = i2;
                if (!UrlRequestBase.$assertionsDisabled && (i4 < 0 || i4 > 15)) {
                    throw new AssertionError();
                }
                switch (i4) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 1;
                        break;
                    case 2:
                        i3 = 2;
                        break;
                    case 3:
                        i3 = 3;
                        break;
                    case 4:
                        i3 = 4;
                        break;
                    case 5:
                    default:
                        throw new IllegalArgumentException("No request status found.");
                    case 6:
                        i3 = 5;
                        break;
                    case 7:
                        i3 = 6;
                        break;
                    case 8:
                        i3 = 7;
                        break;
                    case 9:
                        i3 = 8;
                        break;
                    case 10:
                        i3 = 9;
                        break;
                    case 11:
                        i3 = 10;
                        break;
                    case 12:
                        i3 = 11;
                        break;
                    case 13:
                        i3 = 12;
                        break;
                    case 14:
                        i3 = 13;
                        break;
                    case 15:
                        i3 = 14;
                        break;
                }
                versionSafeCallbacks$UrlRequestStatusListener2.onStatus(i3);
            }
        });
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mResponseInfo.mReceivedByteCount.set(j);
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.5
            {
                CronetUrlRequest.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.destroyRequestAdapterLocked(0);
                    try {
                        CronetUrlRequest.this.mCallback.mWrappedCallback.onSucceeded(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo);
                        CronetUrlRequest.access$1300(CronetUrlRequest.this);
                    } catch (Exception e2) {
                        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", e2);
                    }
                }
            }
        });
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    public void checkCallingThread() {
        if (!this.mAllowDirectExecutor && this.mRequestContext.isNetworkThread(Thread.currentThread())) {
            throw new InlineExecutionProhibitedException();
        }
    }

    public final void checkNotStarted() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mStarted || isDoneLocked()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    public final void destroyRequestAdapterLocked(int i2) {
        this.mFinishedReason = i2;
        if (this.mUrlRequestAdapter == 0) {
            return;
        }
        this.mRequestContext.onRequestDestroyed();
        nativeDestroy(this.mUrlRequestAdapter, i2 == 2);
        this.mUrlRequestAdapter = 0L;
    }

    public final void failWithException(CronetException cronetException) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (isDoneLocked()) {
                return;
            }
            this.mException = cronetException;
            destroyRequestAdapterLocked(1);
        }
    }

    @Override // aegon.chrome.net.UrlRequest
    public void followRedirect() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRedirect) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mWaitingOnRedirect = false;
            if (isDoneLocked()) {
                return;
            }
            nativeFollowDeferredRedirect(this.mUrlRequestAdapter);
        }
    }

    public final boolean isDoneLocked() {
        return this.mStarted && this.mUrlRequestAdapter == 0;
    }

    public final void onCallbackException(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", exc);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
        failWithException(callbackExceptionImpl);
    }

    public void onUploadException(Throwable th) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UploadDataProvider", th);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", th);
        failWithException(callbackExceptionImpl);
    }

    public final void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e2) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
            failWithException(new CronetExceptionImpl("Exception posting task to executor", e2));
        }
    }

    public final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        HeadersList headersList = new HeadersList(null);
        for (int i3 = 0; i3 < strArr.length; i3 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i3], strArr[i3 + 1]));
        }
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), i2, str, headersList, z, str2, str3, j);
    }

    @Override // aegon.chrome.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("ByteBuffer is already full.");
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
        }
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRead) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mWaitingOnRead = false;
            if (isDoneLocked()) {
                return;
            }
            if (nativeReadData(this.mUrlRequestAdapter, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                return;
            }
            this.mWaitingOnRead = true;
            throw new IllegalArgumentException("Unable to call native read");
        }
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mInitialMethod = str;
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.mUploadDataStream = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // aegon.chrome.net.UrlRequest
    public void start() {
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier;
        Object obj;
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier2;
        synchronized (this.mUrlRequestAdapterLock) {
            checkNotStarted();
            try {
                try {
                    try {
                        obj = CronetUrlRequest$$Lambda$1.lambdaFactory$(this).get();
                    } catch (UnsatisfiedLinkError unused) {
                        obj = safeNativeFunctionCaller$Supplier2.get();
                    }
                } catch (UnsatisfiedLinkError unused2) {
                    obj = safeNativeFunctionCaller$Supplier.get();
                }
                this.mUrlRequestAdapter = ((Long) obj).longValue();
                this.mRequestContext.onRequestStarted();
                if (this.mInitialMethod != null && !nativeSetHttpMethod(this.mUrlRequestAdapter, this.mInitialMethod)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid http method ");
                    sb.append(this.mInitialMethod);
                    throw new IllegalArgumentException(sb.toString());
                }
                boolean z = false;
                Iterator<Map.Entry<String, String>> it = this.mRequestHeaders.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next.getKey().equalsIgnoreCase("Content-Type") && !next.getValue().isEmpty()) {
                        z = true;
                    }
                    if (!nativeAddRequestHeader(this.mUrlRequestAdapter, next.getKey(), next.getValue())) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid header ");
                        sb2.append(next.getKey());
                        sb2.append("=");
                        sb2.append(next.getValue());
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                if (this.mUploadDataStream == null) {
                    this.mStarted = true;
                    nativeStart(this.mUrlRequestAdapter);
                } else if (!z) {
                    throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                } else {
                    this.mStarted = true;
                    this.mUploadDataStream.postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUrlRequest.1
                        {
                            CronetUrlRequest.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mUploadDataStream.initializeWithRequest();
                            synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                                if (CronetUrlRequest.this.isDoneLocked()) {
                                    return;
                                }
                                CronetUrlRequest.this.mUploadDataStream.attachNativeAdapterToRequest(CronetUrlRequest.this.mUrlRequestAdapter);
                                CronetUrlRequest.access$900(CronetUrlRequest.this);
                            }
                        }
                    });
                }
            } catch (RuntimeException e2) {
                destroyRequestAdapterLocked(1);
                throw e2;
            }
        }
    }
}
