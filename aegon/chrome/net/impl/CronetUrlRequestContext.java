package aegon.chrome.net.impl;

import aegon.chrome.base.ObserverList;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.impl.CronetEngineBuilderImpl;
import android.os.ConditionVariable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class CronetUrlRequestContext extends CronetEngineBase {
    public static final String LOG_TAG = "CronetUrlRequestContext";
    public static final HashSet<String> sInUseStoragePaths = new HashSet<>();
    public final String mInUseStoragePath;
    public boolean mIsLogging;
    public Thread mNetworkThread;
    public volatile ConditionVariable mStopNetLogCompleted;
    public long mUrlRequestContextAdapter;
    public final Object mLock = new Object();
    public final ConditionVariable mInitCompleted = new ConditionVariable(false);
    public final AtomicInteger mActiveRequestCount = new AtomicInteger(0);
    public final Object mNetworkQualityLock = new Object();
    public final Object mFinishedListenerLock = new Object();
    public final ObserverList<VersionSafeCallbacks$NetworkQualityRttListenerWrapper> mRttListenerList = new ObserverList<>();
    public final ObserverList<VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper> mThroughputListenerList = new ObserverList<>();
    public final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks$RequestFinishedInfoListener> mFinishedListenerMap = new HashMap();

    /* renamed from: aegon.chrome.net.impl.CronetUrlRequestContext$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
            CronetUrlRequestContext.this = r1;
        }

        public static /* synthetic */ void lambda$run$0(AnonymousClass1 anonymousClass1) {
            synchronized (CronetUrlRequestContext.this.mLock) {
                CronetUrlRequestContext.this.nativeInitRequestContextOnInitThread(CronetUrlRequestContext.this.mUrlRequestContextAdapter);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.ensureInitializedOnInitThread();
            Runnable lambdaFactory$ = CronetUrlRequestContext$1$$Lambda$1.lambdaFactory$(this);
            try {
                try {
                    lambdaFactory$.run();
                } catch (UnsatisfiedLinkError unused) {
                    lambdaFactory$.run();
                }
            } catch (UnsatisfiedLinkError unused2) {
                lambdaFactory$.run();
            }
        }
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier;
        Object obj;
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier2;
        boolean z = cronetEngineBuilderImpl.mNetworkQualityEstimatorEnabled;
        CronetLibraryLoader.ensureInitialized(cronetEngineBuilderImpl.mApplicationContext, cronetEngineBuilderImpl);
        int i2 = 3;
        if (Log.isLoggable(LOG_TAG, 2)) {
            i2 = -2;
        } else if (Log.isLoggable(LOG_TAG, 3)) {
            i2 = -1;
        }
        nativeSetMinLogLevel(i2);
        if (cronetEngineBuilderImpl.mHttpCacheMode == 1) {
            this.mInUseStoragePath = cronetEngineBuilderImpl.mStoragePath;
            synchronized (sInUseStoragePaths) {
                if (!sInUseStoragePaths.add(this.mInUseStoragePath)) {
                    throw new IllegalStateException("Disk cache storage path already in use");
                }
            }
        } else {
            this.mInUseStoragePath = null;
        }
        synchronized (this.mLock) {
            try {
                try {
                    obj = CronetUrlRequestContext$$Lambda$1.lambdaFactory$(cronetEngineBuilderImpl).get();
                } catch (UnsatisfiedLinkError unused) {
                    obj = safeNativeFunctionCaller$Supplier.get();
                }
            } catch (UnsatisfiedLinkError unused2) {
                obj = safeNativeFunctionCaller$Supplier2.get();
            }
            long longValue = ((Long) obj).longValue();
            this.mUrlRequestContextAdapter = longValue;
            if (longValue == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.postToInitThread(new AnonymousClass1());
    }

    @CalledByNative
    private void initNetworkThread() {
        this.mNetworkThread = Thread.currentThread();
        this.mInitCompleted.open();
        Thread.currentThread().setName("ChromiumNet");
    }

    public static /* synthetic */ Long lambda$new$0(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        String str = cronetEngineBuilderImpl.mUserAgent;
        String str2 = cronetEngineBuilderImpl.mStoragePath;
        boolean z = cronetEngineBuilderImpl.mQuicEnabled;
        String quicUserAgentIdFrom = z ? UserAgent.getQuicUserAgentIdFrom(cronetEngineBuilderImpl.mApplicationContext) : "";
        boolean z2 = cronetEngineBuilderImpl.mHttp2Enabled;
        boolean z3 = cronetEngineBuilderImpl.mBrotiEnabled;
        boolean z4 = cronetEngineBuilderImpl.mDisableCache;
        int httpCacheMode = cronetEngineBuilderImpl.httpCacheMode();
        long j = cronetEngineBuilderImpl.mHttpCacheMaxSize;
        String str3 = cronetEngineBuilderImpl.mExperimentalOptions;
        long j2 = cronetEngineBuilderImpl.mMockCertVerifier;
        boolean networkQualityEstimatorEnabled = cronetEngineBuilderImpl.networkQualityEstimatorEnabled();
        boolean z5 = cronetEngineBuilderImpl.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        int i2 = cronetEngineBuilderImpl.mThreadPriority;
        long nativeCreateRequestContextConfig = nativeCreateRequestContextConfig(str, str2, z, quicUserAgentIdFrom, z2, z3, z4, httpCacheMode, j, str3, j2, networkQualityEstimatorEnabled, z5, i2 != 20 ? i2 : 10);
        for (CronetEngineBuilderImpl.QuicHint quicHint : cronetEngineBuilderImpl.mQuicHints) {
            nativeAddQuicHint(nativeCreateRequestContextConfig, quicHint.mHost, quicHint.mPort, quicHint.mAlternatePort);
        }
        for (CronetEngineBuilderImpl.Pkp pkp : cronetEngineBuilderImpl.mPkps) {
            nativeAddPkp(nativeCreateRequestContextConfig, pkp.mHost, pkp.mHashes, pkp.mIncludeSubdomains, pkp.mExpirationDate.getTime());
        }
        return Long.valueOf(nativeCreateRequestContextAdapter(nativeCreateRequestContextConfig));
    }

    public static native void nativeAddPkp(long j, String str, byte[][] bArr, boolean z, long j2);

    public static native void nativeAddQuicHint(long j, String str, int i2, int i3);

    private native void nativeConfigureNetworkQualityEstimatorForTesting(long j, boolean z, boolean z2, boolean z3);

    public static native long nativeCreateRequestContextAdapter(long j);

    public static native long nativeCreateRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i2, long j, String str4, long j2, boolean z5, boolean z6, int i3);

    private native void nativeDestroy(long j);

    public static native byte[] nativeGetHistogramDeltas();

    public native void nativeInitRequestContextOnInitThread(long j);

    private native void nativeProvideRTTObservations(long j, boolean z);

    private native void nativeProvideThroughputObservations(long j, boolean z);

    public static native int nativeSetMinLogLevel(int i2);

    private native void nativeStartNetLogToDisk(long j, String str, boolean z, int i2);

    private native boolean nativeStartNetLogToFile(long j, String str, boolean z);

    private native void nativeStopNetLog(long j);

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int i2) {
        synchronized (this.mNetworkQualityLock) {
        }
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int i2, int i3, int i4) {
        synchronized (this.mNetworkQualityLock) {
        }
    }

    @CalledByNative
    private void onRttObservation(final int i2, final long j, final int i3) {
        synchronized (this.mNetworkQualityLock) {
            Iterator<VersionSafeCallbacks$NetworkQualityRttListenerWrapper> it = this.mRttListenerList.iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks$NetworkQualityRttListenerWrapper next = it.next();
                postObservationTaskToExecutor(next.getExecutor(), new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequestContext.2
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onRttObservation(i2, j, i3);
                    }
                });
            }
        }
    }

    @CalledByNative
    private void onThroughputObservation(final int i2, final long j, final int i3) {
        synchronized (this.mNetworkQualityLock) {
            Iterator<VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper> it = this.mThroughputListenerList.iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper next = it.next();
                postObservationTaskToExecutor(next.getExecutor(), new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequestContext.3
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onThroughputObservation(i2, j, i3);
                    }
                });
            }
        }
    }

    public static void postObservationTaskToExecutor(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e2) {
            aegon.chrome.base.Log.e(LOG_TAG, "Exception posting task to executor", e2);
        }
    }

    public final void checkHaveAdapter() {
        if (!(this.mUrlRequestContextAdapter != 0)) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    @Override // aegon.chrome.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, RequestFinishedInfo.Listener listener) {
        synchronized (this.mLock) {
            try {
                try {
                    checkHaveAdapter();
                    return new CronetUrlRequest(this, str, i2, callback, executor, collection, z, z2, z3, z4, i3, z5, i4, listener);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public long getUrlRequestContextAdapter() {
        long j;
        synchronized (this.mLock) {
            checkHaveAdapter();
            j = this.mUrlRequestContextAdapter;
        }
        return j;
    }

    public boolean hasRequestFinishedListener() {
        boolean z;
        synchronized (this.mFinishedListenerLock) {
            z = !this.mFinishedListenerMap.isEmpty();
        }
        return z;
    }

    public boolean isNetworkThread(Thread thread) {
        return thread == this.mNetworkThread;
    }

    public void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    public void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    public void reportRequestFinished(final RequestFinishedInfo requestFinishedInfo) {
        synchronized (this.mFinishedListenerLock) {
            if (this.mFinishedListenerMap.isEmpty()) {
                return;
            }
            Iterator it = new ArrayList(this.mFinishedListenerMap.values()).iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener = (VersionSafeCallbacks$RequestFinishedInfoListener) it.next();
                postObservationTaskToExecutor(versionSafeCallbacks$RequestFinishedInfoListener.mWrappedListener.getExecutor(), new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequestContext.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener2 = versionSafeCallbacks$RequestFinishedInfoListener;
                        versionSafeCallbacks$RequestFinishedInfoListener2.mWrappedListener.onRequestFinished(requestFinishedInfo);
                    }
                });
            }
        }
    }

    public void shutdown() {
        if (this.mInUseStoragePath != null) {
            synchronized (sInUseStoragePaths) {
                sInUseStoragePaths.remove(this.mInUseStoragePath);
            }
        }
        synchronized (this.mLock) {
            checkHaveAdapter();
            if (this.mActiveRequestCount.get() != 0) {
                throw new IllegalStateException("Cannot shutdown with active requests.");
            }
            if (Thread.currentThread() == this.mNetworkThread) {
                throw new IllegalThreadStateException("Cannot shutdown from network thread.");
            }
        }
        this.mInitCompleted.block();
        stopNetLog();
        synchronized (this.mLock) {
            if (this.mUrlRequestContextAdapter != 0) {
                nativeDestroy(this.mUrlRequestContextAdapter);
                this.mUrlRequestContextAdapter = 0L;
            }
        }
    }

    public void stopNetLog() {
        synchronized (this.mLock) {
            if (this.mIsLogging) {
                checkHaveAdapter();
                this.mStopNetLogCompleted = new ConditionVariable();
                nativeStopNetLog(this.mUrlRequestContextAdapter);
                this.mIsLogging = false;
                this.mStopNetLogCompleted.block();
            }
        }
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }
}
