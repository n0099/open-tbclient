package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.CronetException;
import aegon.chrome.net.ExperimentalBidirectionalStream;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlResponseInfo;
import aegon.chrome.net.impl.UrlResponseInfoImpl;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes.dex */
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer mByteBuffer;
    }

    /* loaded from: classes.dex */
    public final class OnWriteCompletedRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer mByteBuffer;
        public final boolean mEndOfStream;
        public final /* synthetic */ CronetBidirectionalStream this$0;

        public OnWriteCompletedRunnable(CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer byteBuffer, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, byteBuffer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cronetBidirectionalStream;
            this.mByteBuffer = byteBuffer;
            this.mEndOfStream = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.mByteBuffer = null;
                    synchronized (this.this$0.mNativeStreamLock) {
                        if (this.this$0.isDoneLocked()) {
                            return;
                        }
                        if (this.mEndOfStream) {
                            this.this$0.mWriteState = 10;
                            int unused = this.this$0.mReadState;
                        }
                        CronetBidirectionalStream.access$500(this.this$0);
                        UrlResponseInfoImpl unused2 = this.this$0.mResponseInfo;
                        throw null;
                    }
                } catch (Exception e2) {
                    this.this$0.onCallbackException(e2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1452845098, "Laegon/chrome/net/impl/CronetBidirectionalStream;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1452845098, "Laegon/chrome/net/impl/CronetBidirectionalStream;");
        }
    }

    public static /* synthetic */ boolean access$1100(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static /* synthetic */ void access$500(CronetBidirectionalStream cronetBidirectionalStream) {
    }

    public static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, strArr)) == null) {
            ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private native long nativeCreateBidirectionalStream(long j, boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3);

    private native void nativeDestroy(long j, boolean z);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeSendRequestHeaders(long j);

    private native int nativeStart(long j, String str, int i2, String str2, String[] strArr, boolean z);

    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetBidirectionalStream this$0;

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
                            CronetBidirectionalStream.access$500(this.this$0);
                            UrlResponseInfoImpl unused = this.this$0.mResponseInfo;
                            throw null;
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
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j)}) == null) {
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
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Boolean.valueOf(z), Long.valueOf(j14), Long.valueOf(j15)}) == null) {
            synchronized (this.mNativeStreamLock) {
                if (this.mMetrics != null) {
                    throw new IllegalStateException("Metrics collection should only happen once.");
                }
                this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
                this.mRequestContext.reportRequestFinished(new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mReadState == 7 ? 0 : this.mReadState == 5 ? 2 : 1, this.mResponseInfo, this.mException));
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
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
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i2, String str, String[] strArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, this, new Object[]{Integer.valueOf(i2), str, strArr, Long.valueOf(j)}) == null) {
            try {
                this.mResponseInfo = new UrlResponseInfoImpl(Arrays.asList(this.mInitialUrl), i2, "", headersListFromStrings(strArr), false, str, null, j);
                postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CronetBidirectionalStream this$0;

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
                            synchronized (this.this$0.mNativeStreamLock) {
                                if (this.this$0.isDoneLocked()) {
                                    return;
                                }
                                this.this$0.mReadState = 2;
                                try {
                                    CronetBidirectionalStream.access$500(this.this$0);
                                    UrlResponseInfoImpl unused = this.this$0.mResponseInfo;
                                    throw null;
                                } catch (Exception e2) {
                                    this.this$0.onCallbackException(e2);
                                }
                            }
                        }
                    }
                });
            } catch (Exception unused) {
                failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
            }
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, strArr) == null) {
            postTaskToExecutor(new Runnable(this, new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(strArr))) { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetBidirectionalStream this$0;
                public final /* synthetic */ UrlResponseInfo.HeaderBlock val$trailersBlock;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
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
                    this.val$trailersBlock = r7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.mNativeStreamLock) {
                            if (this.this$0.isDoneLocked()) {
                                return;
                            }
                            try {
                                CronetBidirectionalStream.access$500(this.this$0);
                                UrlResponseInfoImpl unused = this.this$0.mResponseInfo;
                                throw null;
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
    private void onStreamReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65563, this, z) == null) {
            postTaskToExecutor(new Runnable(this, z) { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetBidirectionalStream this$0;
                public final /* synthetic */ boolean val$requestHeadersSent;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
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
                    this.val$requestHeadersSent = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CronetBidirectionalStream cronetBidirectionalStream;
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.mNativeStreamLock) {
                            if (this.this$0.isDoneLocked()) {
                                return;
                            }
                            this.this$0.mRequestHeadersSent = this.val$requestHeadersSent;
                            this.this$0.mReadState = 2;
                            if (CronetBidirectionalStream.access$1100(this.this$0.mInitialMethod) || !this.this$0.mRequestHeadersSent) {
                                cronetBidirectionalStream = this.this$0;
                                i2 = 8;
                            } else {
                                cronetBidirectionalStream = this.this$0;
                                i2 = 10;
                            }
                            cronetBidirectionalStream.mWriteState = i2;
                            try {
                                CronetBidirectionalStream.access$500(this.this$0);
                                throw null;
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
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{byteBufferArr, iArr, iArr2, Boolean.valueOf(z)}) == null) {
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
                    postTaskToExecutor(new OnWriteCompletedRunnable(this, byteBuffer, z2));
                }
            }
        }
    }

    public final void destroyNativeStreamLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
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
    }

    public final void failWithException(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cronetException) == null) {
            postTaskToExecutor(new Runnable(this, cronetException) { // from class: aegon.chrome.net.impl.CronetBidirectionalStream.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetBidirectionalStream this$0;
                public final /* synthetic */ CronetException val$exception;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cronetException};
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
                    this.val$exception = cronetException;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.failWithExceptionOnExecutor(this.val$exception);
                    }
                }
            });
        }
    }

    public final void failWithExceptionOnExecutor(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cronetException) == null) {
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
    }

    public final boolean isDoneLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mReadState != 0 && this.mNativeStream == 0 : invokeV.booleanValue;
    }

    public final void onCallbackException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("CalledByNative method has thrown an exception", exc);
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
            failWithExceptionOnExecutor(callbackExceptionImpl);
        }
    }

    public final void postTaskToExecutor(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
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
    }

    public final void sendFlushDataLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
}
