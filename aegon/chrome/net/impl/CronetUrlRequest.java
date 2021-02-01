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
/* loaded from: classes3.dex */
public final class CronetUrlRequest extends UrlRequestBase {
    public static final /* synthetic */ boolean $assertionsDisabled = !CronetUrlRequest.class.desiredAssertionStatus();
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

    /* loaded from: classes3.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public /* synthetic */ HeadersList(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: classes3.dex */
    private final class OnReadCompletedRunnable implements Runnable {
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
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        VersionSafeCallbacks$UrlRequestCallback versionSafeCallbacks$UrlRequestCallback = CronetUrlRequest.this.mCallback;
                        versionSafeCallbacks$UrlRequestCallback.mWrappedCallback.onReadCompleted(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.onCallbackException(e);
            }
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener) {
        int i4;
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
        switch (i) {
            case 0:
                i4 = 1;
                break;
            case 1:
                i4 = 2;
                break;
            case 2:
                i4 = 3;
                break;
            case 3:
            default:
                i4 = 4;
                break;
            case 4:
                i4 = 5;
                break;
        }
        this.mPriority = i4;
        this.mCallback = new VersionSafeCallbacks$UrlRequestCallback(callback);
        this.mExecutor = executor;
        this.mRequestAnnotations = collection;
        this.mDisableCache = z;
        this.mDisableConnectionMigration = z2;
        this.mTrafficStatsTagSet = z4;
        this.mTrafficStatsTag = i2;
        this.mTrafficStatsUidSet = z5;
        this.mTrafficStatsUid = i3;
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
                } catch (RejectedExecutionException e) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
                }
            }
        }
    }

    public static /* synthetic */ void access$900(CronetUrlRequest cronetUrlRequest) {
        cronetUrlRequest.nativeStart(cronetUrlRequest.mUrlRequestAdapter);
    }

    private native boolean nativeAddRequestHeader(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeCreateRequestAdapter(long j, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3);

    private native void nativeDestroy(long j, boolean z);

    private native void nativeFollowDeferredRedirect(long j);

    private native void nativeGetStatus(long j, VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i, int i2);

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
            failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + str, i, i2, i3));
            return;
        }
        switch (i) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            case 7:
                i = 7;
                break;
            case 8:
                i = 8;
                break;
            case 9:
                i = 9;
                break;
            case 10:
                i = 10;
                break;
            case 11:
                i = 11;
                break;
            default:
                Log.e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + i, new Object[0]);
                break;
        }
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + str, i, i2));
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
                        } catch (Exception e) {
                            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onFailed method", e);
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
                Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.mResponseInfo.mReceivedByteCount.set(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mOnReadCompletedTask == null) {
            this.mOnReadCompletedTask = new OnReadCompletedRunnable(null);
        }
        byteBuffer.position(i2 + i);
        OnReadCompletedRunnable onReadCompletedRunnable = this.mOnReadCompletedTask;
        onReadCompletedRunnable.mByteBuffer = byteBuffer;
        postTaskToExecutor(onReadCompletedRunnable);
    }

    @CalledByNative
    private void onRedirectReceived(final String str, int i, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread = prepareResponseInfoOnNetworkThread(i, str2, strArr, z, str3, str4, j);
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
                    } catch (Exception e) {
                        CronetUrlRequest.this.onCallbackException(e);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(i, str, strArr, z, str2, str3, j);
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
                    } catch (Exception e) {
                        CronetUrlRequest.this.onCallbackException(e);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener, final int i) {
        postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener2 = versionSafeCallbacks$UrlRequestStatusListener;
                int i3 = i;
                if (!UrlRequestBase.$assertionsDisabled && (i3 < 0 || i3 > 15)) {
                    throw new AssertionError();
                }
                switch (i3) {
                    case 0:
                        i2 = 0;
                        break;
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
                    default:
                        throw new IllegalArgumentException("No request status found.");
                    case 6:
                        i2 = 5;
                        break;
                    case 7:
                        i2 = 6;
                        break;
                    case 8:
                        i2 = 7;
                        break;
                    case 9:
                        i2 = 8;
                        break;
                    case 10:
                        i2 = 9;
                        break;
                    case 11:
                        i2 = 10;
                        break;
                    case 12:
                        i2 = 11;
                        break;
                    case 13:
                        i2 = 12;
                        break;
                    case 14:
                        i2 = 13;
                        break;
                    case 15:
                        i2 = 14;
                        break;
                }
                versionSafeCallbacks$UrlRequestStatusListener2.onStatus(i2);
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
                    } catch (Exception e) {
                        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", e);
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

    public final void destroyRequestAdapterLocked(int i) {
        if (!$assertionsDisabled && this.mException != null && i != 1) {
            throw new AssertionError();
        }
        this.mFinishedReason = i;
        if (this.mUrlRequestAdapter == 0) {
            return;
        }
        this.mRequestContext.onRequestDestroyed();
        nativeDestroy(this.mUrlRequestAdapter, i == 2);
        this.mUrlRequestAdapter = 0L;
    }

    public final void failWithException(CronetException cronetException) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (isDoneLocked()) {
                return;
            }
            if (!$assertionsDisabled && this.mException != null) {
                throw new AssertionError();
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
        } catch (RejectedExecutionException e) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
        }
    }

    public final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int i, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        HeadersList headersList = new HeadersList(null);
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
        }
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), i, str, headersList, z, str2, str3, j);
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
        synchronized (this.mUrlRequestAdapterLock) {
            checkNotStarted();
            try {
                try {
                    obj = CronetUrlRequest$$Lambda$1.lambdaFactory$(this).get();
                } catch (UnsatisfiedLinkError e) {
                    try {
                        obj = safeNativeFunctionCaller$Supplier.get();
                    } catch (UnsatisfiedLinkError e2) {
                        obj = safeNativeFunctionCaller$Supplier.get();
                    }
                }
                this.mUrlRequestAdapter = ((Long) obj).longValue();
                this.mRequestContext.onRequestStarted();
                if (this.mInitialMethod != null && !nativeSetHttpMethod(this.mUrlRequestAdapter, this.mInitialMethod)) {
                    throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);
                }
                boolean z = false;
                Iterator<Map.Entry<String, String>> it = this.mRequestHeaders.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    boolean z2 = (!next.getKey().equalsIgnoreCase("Content-Type") || next.getValue().isEmpty()) ? z : true;
                    if (!nativeAddRequestHeader(this.mUrlRequestAdapter, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                    }
                    z = z2;
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
            } catch (RuntimeException e3) {
                destroyRequestAdapterLocked(1);
                throw e3;
            }
        }
    }
}
