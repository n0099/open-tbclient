package aegon.chrome.net.impl;

import aegon.chrome.base.ObserverList;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.impl.CronetEngineBuilderImpl;
import android.os.ConditionVariable;
import android.util.Log;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "CronetUrlRequestContext";
    public static final HashSet<String> sInUseStoragePaths;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger mActiveRequestCount;
    public final Object mFinishedListenerLock;
    public final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks$RequestFinishedInfoListener> mFinishedListenerMap;
    public final String mInUseStoragePath;
    public final ConditionVariable mInitCompleted;
    public boolean mIsLogging;
    public final Object mLock;
    public final Object mNetworkQualityLock;
    public Thread mNetworkThread;
    public final ObserverList<VersionSafeCallbacks$NetworkQualityRttListenerWrapper> mRttListenerList;
    public volatile ConditionVariable mStopNetLogCompleted;
    public final ObserverList<VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper> mThroughputListenerList;
    public long mUrlRequestContextAdapter;

    /* renamed from: aegon.chrome.net.impl.CronetUrlRequestContext$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequestContext this$0;

        public AnonymousClass1(CronetUrlRequestContext cronetUrlRequestContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cronetUrlRequestContext;
        }

        public static /* synthetic */ void lambda$run$0(AnonymousClass1 anonymousClass1) {
            synchronized (anonymousClass1.this$0.mLock) {
                anonymousClass1.this$0.nativeInitRequestContextOnInitThread(anonymousClass1.this$0.mUrlRequestContextAdapter);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CronetLibraryLoader.ensureInitializedOnInitThread();
                Runnable runnable = CronetUrlRequestContext$1$$Lambda$1.$ic;
                try {
                    try {
                        runnable.run();
                    } catch (UnsatisfiedLinkError unused) {
                        runnable.run();
                    }
                } catch (UnsatisfiedLinkError unused2) {
                    runnable.run();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1691435018, "Laegon/chrome/net/impl/CronetUrlRequestContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1691435018, "Laegon/chrome/net/impl/CronetUrlRequestContext;");
                return;
            }
        }
        sInUseStoragePaths = new HashSet<>();
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier;
        Object obj;
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cronetEngineBuilderImpl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mRttListenerList = new ObserverList<>();
        this.mThroughputListenerList = new ObserverList<>();
        this.mFinishedListenerMap = new HashMap();
        boolean z = cronetEngineBuilderImpl.mNetworkQualityEstimatorEnabled;
        CronetLibraryLoader.ensureInitialized(cronetEngineBuilderImpl.mApplicationContext, cronetEngineBuilderImpl);
        int i4 = 3;
        if (Log.isLoggable(LOG_TAG, 2)) {
            i4 = -2;
        } else if (Log.isLoggable(LOG_TAG, 3)) {
            i4 = -1;
        }
        nativeSetMinLogLevel(i4);
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
                    obj = CronetUrlRequestContext$$Lambda$1.$ic.get();
                } catch (UnsatisfiedLinkError unused) {
                    obj = safeNativeFunctionCaller$Supplier2.get();
                }
            } catch (UnsatisfiedLinkError unused2) {
                obj = safeNativeFunctionCaller$Supplier.get();
            }
            long longValue = ((Long) obj).longValue();
            this.mUrlRequestContextAdapter = longValue;
            if (longValue == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.postToInitThread(new AnonymousClass1(this));
    }

    @CalledByNative
    private void initNetworkThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mNetworkThread = Thread.currentThread();
            this.mInitCompleted.open();
            Thread.currentThread().setName("ChromiumNet");
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i2) == null) {
            synchronized (this.mNetworkQualityLock) {
            }
        }
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65558, this, i2, i3, i4) == null) {
            synchronized (this.mNetworkQualityLock) {
            }
        }
    }

    @CalledByNative
    private void onRttObservation(int i2, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
            synchronized (this.mNetworkQualityLock) {
                Iterator<VersionSafeCallbacks$NetworkQualityRttListenerWrapper> it = this.mRttListenerList.iterator();
                while (it.hasNext()) {
                    VersionSafeCallbacks$NetworkQualityRttListenerWrapper next = it.next();
                    postObservationTaskToExecutor(next.getExecutor(), new Runnable(this, next, i2, j, i3) { // from class: aegon.chrome.net.impl.CronetUrlRequestContext.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VersionSafeCallbacks$NetworkQualityRttListenerWrapper val$listener;
                        public final /* synthetic */ int val$rttMs;
                        public final /* synthetic */ int val$source;
                        public final /* synthetic */ long val$whenMs;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, next, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$listener = next;
                            this.val$rttMs = i2;
                            this.val$whenMs = j;
                            this.val$source = i3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$listener.onRttObservation(this.val$rttMs, this.val$whenMs, this.val$source);
                            }
                        }
                    });
                }
            }
        }
    }

    @CalledByNative
    private void onThroughputObservation(int i2, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
            synchronized (this.mNetworkQualityLock) {
                Iterator<VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper> it = this.mThroughputListenerList.iterator();
                while (it.hasNext()) {
                    VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper next = it.next();
                    postObservationTaskToExecutor(next.getExecutor(), new Runnable(this, next, i2, j, i3) { // from class: aegon.chrome.net.impl.CronetUrlRequestContext.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper val$listener;
                        public final /* synthetic */ int val$source;
                        public final /* synthetic */ int val$throughputKbps;
                        public final /* synthetic */ long val$whenMs;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, next, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$listener = next;
                            this.val$throughputKbps = i2;
                            this.val$whenMs = j;
                            this.val$source = i3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$listener.onThroughputObservation(this.val$throughputKbps, this.val$whenMs, this.val$source);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void postObservationTaskToExecutor(Executor executor, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, executor, runnable) == null) {
            try {
                executor.execute(runnable);
            } catch (RejectedExecutionException e2) {
                aegon.chrome.base.Log.e(LOG_TAG, "Exception posting task to executor", e2);
            }
        }
    }

    public final void checkHaveAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!(this.mUrlRequestContextAdapter != 0)) {
                throw new IllegalStateException("Engine is shut down.");
            }
        }
    }

    @Override // aegon.chrome.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, RequestFinishedInfo.Listener listener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, callback, executor, Integer.valueOf(i2), collection, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i3), Boolean.valueOf(z5), Integer.valueOf(i4), listener})) != null) {
            return (UrlRequestBase) invokeCommon.objValue;
        }
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
            }
        }
    }

    public long getUrlRequestContextAdapter() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mLock) {
                checkHaveAdapter();
                j = this.mUrlRequestContextAdapter;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public boolean hasRequestFinishedListener() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mFinishedListenerLock) {
                z = !this.mFinishedListenerMap.isEmpty();
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isNetworkThread(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, thread)) == null) ? thread == this.mNetworkThread : invokeL.booleanValue;
    }

    public void onRequestDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mActiveRequestCount.decrementAndGet();
        }
    }

    public void onRequestStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mActiveRequestCount.incrementAndGet();
        }
    }

    public void reportRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, requestFinishedInfo) == null) {
            synchronized (this.mFinishedListenerLock) {
                if (this.mFinishedListenerMap.isEmpty()) {
                    return;
                }
                Iterator it = new ArrayList(this.mFinishedListenerMap.values()).iterator();
                while (it.hasNext()) {
                    VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener = (VersionSafeCallbacks$RequestFinishedInfoListener) it.next();
                    postObservationTaskToExecutor(versionSafeCallbacks$RequestFinishedInfoListener.mWrappedListener.getExecutor(), new Runnable(this, versionSafeCallbacks$RequestFinishedInfoListener, requestFinishedInfo) { // from class: aegon.chrome.net.impl.CronetUrlRequestContext.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VersionSafeCallbacks$RequestFinishedInfoListener val$listener;
                        public final /* synthetic */ RequestFinishedInfo val$requestInfo;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, versionSafeCallbacks$RequestFinishedInfoListener, requestFinishedInfo};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$listener = versionSafeCallbacks$RequestFinishedInfoListener;
                            this.val$requestInfo = requestFinishedInfo;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener2 = this.val$listener;
                                versionSafeCallbacks$RequestFinishedInfoListener2.mWrappedListener.onRequestFinished(this.val$requestInfo);
                            }
                        }
                    });
                }
            }
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    public void stopNetLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mStopNetLogCompleted.open();
        }
    }
}
