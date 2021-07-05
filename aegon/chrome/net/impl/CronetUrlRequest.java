package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.CronetException;
import aegon.chrome.net.InlineExecutionProhibitedException;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UrlRequest;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public final HeadersList mRequestHeaders;
    public UrlResponseInfoImpl mResponseInfo;
    public boolean mStarted;
    public final int mTrafficStatsTag;
    public final boolean mTrafficStatsTagSet;
    public final int mTrafficStatsUid;
    public final boolean mTrafficStatsUidSet;
    public CronetUploadDataStream mUploadDataStream;
    public final List<String> mUrlChain;
    public long mUrlRequestAdapter;
    public final Object mUrlRequestAdapterLock;
    public boolean mWaitingOnRead;
    public boolean mWaitingOnRedirect;

    /* loaded from: classes.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ HeadersList(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: classes.dex */
    public final class OnReadCompletedRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer mByteBuffer;

        public /* synthetic */ OnReadCompletedRunnable(AnonymousClass1 anonymousClass1) {
            CronetUrlRequest.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(911570557, "Laegon/chrome/net/impl/CronetUrlRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(911570557, "Laegon/chrome/net/impl/CronetUrlRequest;");
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, RequestFinishedInfo.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cronetUrlRequestContext, str, Integer.valueOf(i2), callback, executor, collection, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i3), Boolean.valueOf(z5), Integer.valueOf(i4), listener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUrlRequestAdapterLock = new Object();
        this.mUrlChain = new ArrayList();
        this.mRequestHeaders = new HeadersList(null);
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
        int i7 = 4;
        if (i2 == 0) {
            i7 = 1;
        } else if (i2 == 1) {
            i7 = 2;
        } else if (i2 == 2) {
            i7 = 3;
        } else if (i2 == 4) {
            i7 = 5;
        }
        this.mPriority = i7;
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
            RequestFinishedInfoImpl requestFinishedInfoImpl = new RequestFinishedInfoImpl(cronetUrlRequest.mInitialUrl, cronetUrlRequest.mRequestAnnotations, cronetMetrics, cronetUrlRequest.mFinishedReason, cronetUrlRequest.mResponseInfo, cronetUrlRequest.mException);
            cronetUrlRequest.mRequestContext.reportRequestFinished(requestFinishedInfoImpl);
            VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener = cronetUrlRequest.mRequestFinishedListener;
            if (versionSafeCallbacks$RequestFinishedInfoListener != null) {
                try {
                    versionSafeCallbacks$RequestFinishedInfoListener.mWrappedListener.getExecutor().execute(new Runnable(cronetUrlRequest, requestFinishedInfoImpl) { // from class: aegon.chrome.net.impl.CronetUrlRequest.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CronetUrlRequest this$0;
                        public final /* synthetic */ RequestFinishedInfo val$requestInfo;

                        {
                            Interceptable interceptable = $ic;
                            if (interceptable != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {cronetUrlRequest, requestFinishedInfoImpl};
                                interceptable.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = cronetUrlRequest;
                            this.val$requestInfo = requestFinishedInfoImpl;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                VersionSafeCallbacks$RequestFinishedInfoListener versionSafeCallbacks$RequestFinishedInfoListener2 = this.this$0.mRequestFinishedListener;
                                versionSafeCallbacks$RequestFinishedInfoListener2.mWrappedListener.onRequestFinished(this.val$requestInfo);
                            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetUrlRequest this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.mCallback.mWrappedCallback.onCanceled(this.this$0, this.this$0.mResponseInfo);
                            CronetUrlRequest.access$1300(this.this$0);
                        } catch (Exception e2) {
                            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", e2);
                        }
                    }
                }
            });
        }
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j)}) == null) {
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
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Boolean.valueOf(z), Long.valueOf(j14), Long.valueOf(j15)}) == null) {
            synchronized (this.mUrlRequestAdapterLock) {
                if (this.mMetrics != null) {
                    throw new IllegalStateException("Metrics collection should only happen once.");
                }
                this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
            }
        }
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            synchronized (this.mUrlRequestAdapterLock) {
                if (this.mOnDestroyedCallbackForTesting != null) {
                    this.mOnDestroyedCallbackForTesting.run();
                }
                if (this.mException == null) {
                    return;
                }
                try {
                    this.mExecutor.execute(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CronetUrlRequest this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.this$0.mCallback.mWrappedCallback.onFailed(this.this$0, this.this$0.mResponseInfo, this.this$0.mException);
                                    CronetUrlRequest.access$1300(this.this$0);
                                } catch (Exception e2) {
                                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onFailed method", e2);
                                }
                            }
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
                }
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
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
    }

    @CalledByNative
    private void onRedirectReceived(String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, this, new Object[]{str, Integer.valueOf(i2), str2, strArr, Boolean.valueOf(z), str3, str4, Long.valueOf(j)}) == null) {
            UrlResponseInfoImpl prepareResponseInfoOnNetworkThread = prepareResponseInfoOnNetworkThread(i2, str2, strArr, z, str3, str4, j);
            this.mUrlChain.add(str);
            postTaskToExecutor(new Runnable(this, prepareResponseInfoOnNetworkThread, str) { // from class: aegon.chrome.net.impl.CronetUrlRequest.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetUrlRequest this$0;
                public final /* synthetic */ String val$newLocation;
                public final /* synthetic */ UrlResponseInfoImpl val$responseInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, prepareResponseInfoOnNetworkThread, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$responseInfo = prepareResponseInfoOnNetworkThread;
                    this.val$newLocation = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.checkCallingThread();
                        synchronized (this.this$0.mUrlRequestAdapterLock) {
                            if (this.this$0.isDoneLocked()) {
                                return;
                            }
                            this.this$0.mWaitingOnRedirect = true;
                            try {
                                VersionSafeCallbacks$UrlRequestCallback versionSafeCallbacks$UrlRequestCallback = this.this$0.mCallback;
                                versionSafeCallbacks$UrlRequestCallback.mWrappedCallback.onRedirectReceived(this.this$0, this.val$responseInfo, this.val$newLocation);
                            } catch (Exception e2) {
                                this.this$0.onCallbackException(e2);
                            }
                        }
                    }
                }
            });
        }
    }

    @CalledByNative
    private void onResponseStarted(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, this, new Object[]{Integer.valueOf(i2), str, strArr, Boolean.valueOf(z), str2, str3, Long.valueOf(j)}) == null) {
            this.mResponseInfo = prepareResponseInfoOnNetworkThread(i2, str, strArr, z, str2, str3, j);
            postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetUrlRequest this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.checkCallingThread();
                        synchronized (this.this$0.mUrlRequestAdapterLock) {
                            if (this.this$0.isDoneLocked()) {
                                return;
                            }
                            this.this$0.mWaitingOnRead = true;
                            try {
                                VersionSafeCallbacks$UrlRequestCallback versionSafeCallbacks$UrlRequestCallback = this.this$0.mCallback;
                                versionSafeCallbacks$UrlRequestCallback.mWrappedCallback.onResponseStarted(this.this$0, this.this$0.mResponseInfo);
                            } catch (Exception e2) {
                                this.this$0.onCallbackException(e2);
                            }
                        }
                    }
                }
            });
        }
    }

    @CalledByNative
    private void onStatus(VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65568, this, versionSafeCallbacks$UrlRequestStatusListener, i2) == null) {
            postTaskToExecutor(new Runnable(this, versionSafeCallbacks$UrlRequestStatusListener, i2) { // from class: aegon.chrome.net.impl.CronetUrlRequest.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VersionSafeCallbacks$UrlRequestStatusListener val$listener;
                public final /* synthetic */ int val$loadState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, versionSafeCallbacks$UrlRequestStatusListener, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = versionSafeCallbacks$UrlRequestStatusListener;
                    this.val$loadState = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener2 = this.val$listener;
                        int i4 = this.val$loadState;
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
                }
            });
        }
    }

    @CalledByNative
    private void onSucceeded(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65569, this, j) == null) {
            this.mResponseInfo.mReceivedByteCount.set(j);
            postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetUrlRequest this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.mUrlRequestAdapterLock) {
                            if (this.this$0.isDoneLocked()) {
                                return;
                            }
                            this.this$0.destroyRequestAdapterLocked(0);
                            try {
                                this.this$0.mCallback.mWrappedCallback.onSucceeded(this.this$0, this.this$0.mResponseInfo);
                                CronetUrlRequest.access$1300(this.this$0);
                            } catch (Exception e2) {
                                Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", e2);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            checkNotStarted();
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(str, str2));
        }
    }

    public void checkCallingThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.mAllowDirectExecutor && this.mRequestContext.isNetworkThread(Thread.currentThread())) {
            throw new InlineExecutionProhibitedException();
        }
    }

    public final void checkNotStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.mUrlRequestAdapterLock) {
                if (this.mStarted || isDoneLocked()) {
                    throw new IllegalStateException("Request is already started.");
                }
            }
        }
    }

    public final void destroyRequestAdapterLocked(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mFinishedReason = i2;
            if (this.mUrlRequestAdapter == 0) {
                return;
            }
            this.mRequestContext.onRequestDestroyed();
            nativeDestroy(this.mUrlRequestAdapter, i2 == 2);
            this.mUrlRequestAdapter = 0L;
        }
    }

    public final void failWithException(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cronetException) == null) {
            synchronized (this.mUrlRequestAdapterLock) {
                if (isDoneLocked()) {
                    return;
                }
                this.mException = cronetException;
                destroyRequestAdapterLocked(1);
            }
        }
    }

    @Override // aegon.chrome.net.UrlRequest
    public void followRedirect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
    }

    public final boolean isDoneLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStarted && this.mUrlRequestAdapter == 0 : invokeV.booleanValue;
    }

    public final void onCallbackException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", exc);
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
            failWithException(callbackExceptionImpl);
        }
    }

    public void onUploadException(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UploadDataProvider", th);
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", th);
            failWithException(callbackExceptionImpl);
        }
    }

    public final void postTaskToExecutor(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, runnable) == null) {
            try {
                this.mExecutor.execute(runnable);
            } catch (RejectedExecutionException e2) {
                Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
                failWithException(new CronetExceptionImpl("Exception posting task to executor", e2));
            }
        }
    }

    public final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), str, strArr, Boolean.valueOf(z), str2, str3, Long.valueOf(j)})) == null) {
            HeadersList headersList = new HeadersList(null);
            for (int i3 = 0; i3 < strArr.length; i3 += 2) {
                headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i3], strArr[i3 + 1]));
            }
            return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), i2, str, headersList, z, str2, str3, j);
        }
        return (UrlResponseInfoImpl) invokeCommon.objValue;
    }

    @Override // aegon.chrome.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
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
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            checkNotStarted();
            if (str == null) {
                throw new NullPointerException("Method is required.");
            }
            this.mInitialMethod = str;
        }
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, uploadDataProvider, executor) == null) {
            if (uploadDataProvider == null) {
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            if (this.mInitialMethod == null) {
                this.mInitialMethod = "POST";
            }
            this.mUploadDataStream = new CronetUploadDataStream(uploadDataProvider, executor, this);
        }
    }

    @Override // aegon.chrome.net.UrlRequest
    public void start() {
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier;
        Object obj;
        SafeNativeFunctionCaller$Supplier safeNativeFunctionCaller$Supplier2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.mUrlRequestAdapterLock) {
                checkNotStarted();
                try {
                    try {
                        try {
                            obj = CronetUrlRequest$$Lambda$1.$ic.get();
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
                        this.mUploadDataStream.postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUrlRequest.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ CronetUrlRequest this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.mUploadDataStream.initializeWithRequest();
                                    synchronized (this.this$0.mUrlRequestAdapterLock) {
                                        if (this.this$0.isDoneLocked()) {
                                            return;
                                        }
                                        this.this$0.mUploadDataStream.attachNativeAdapterToRequest(this.this$0.mUrlRequestAdapter);
                                        CronetUrlRequest.access$900(this.this$0);
                                    }
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
}
