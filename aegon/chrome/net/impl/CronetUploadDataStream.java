package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import android.annotation.SuppressLint;
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
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class CronetUploadDataStream extends UploadDataSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CronetUploadDataStream";
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer mByteBuffer;
    public long mByteBufferLimit;
    public final VersionSafeCallbacks$UploadDataProviderWrapper mDataProvider;
    public boolean mDestroyAdapterPostponed;
    public final Executor mExecutor;
    public int mInWhichUserCallback;
    public long mLength;
    public final Object mLock;
    public Runnable mOnDestroyedCallbackForTesting;
    public final Runnable mReadTask;
    public long mRemainingLength;
    public final CronetUrlRequest mRequest;
    public long mUploadDataStreamAdapter;

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uploadDataProvider, executor, cronetUrlRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReadTask = new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUploadDataStream.1
            public static final /* synthetic */ boolean $assertionsDisabled = false;
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CronetUploadDataStream this$0;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(218968869, "Laegon/chrome/net/impl/CronetUploadDataStream$1;")) == null) {
                    return;
                }
                Interceptable interceptable2 = invokeClinit.interceptor;
                if (interceptable2 != null) {
                    $ic = interceptable2;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(218968869, "Laegon/chrome/net/impl/CronetUploadDataStream$1;");
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65537, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65537, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0.mLock) {
                        if (this.this$0.mUploadDataStreamAdapter == 0) {
                            return;
                        }
                        this.this$0.checkState(3);
                        if (this.this$0.mByteBuffer == null) {
                            throw new IllegalStateException("Unexpected readData call. Buffer is null");
                        }
                        this.this$0.mInWhichUserCallback = 0;
                        try {
                            CronetUploadDataStream.access$500(this.this$0);
                            VersionSafeCallbacks$UploadDataProviderWrapper versionSafeCallbacks$UploadDataProviderWrapper = this.this$0.mDataProvider;
                            versionSafeCallbacks$UploadDataProviderWrapper.mWrappedProvider.read(this.this$0, this.this$0.mByteBuffer);
                        } catch (Exception e2) {
                            this.this$0.onError(e2);
                        }
                    }
                }
            }
        };
        this.mLock = new Object();
        this.mInWhichUserCallback = 3;
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

    private native void nativeOnReadSucceeded(long j, int i2, boolean z);

    private native void nativeOnRewindSucceeded(long j);

    public void attachNativeAdapterToRequest(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            synchronized (this.mLock) {
                this.mUploadDataStreamAdapter = nativeAttachUploadDataToRequest(j, this.mLength);
            }
        }
    }

    public final void checkState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.mInWhichUserCallback == i2) {
            return;
        }
        throw new IllegalStateException("Expected " + i2 + ", but was " + this.mInWhichUserCallback);
    }

    public final void destroyAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                    postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUploadDataStream.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CronetUploadDataStream this$0;

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
                                    CronetUploadDataStream.access$500(this.this$0);
                                    this.this$0.mDataProvider.mWrappedProvider.close();
                                } catch (Exception e2) {
                                    Log.e(CronetUploadDataStream.TAG, "Exception thrown when closing", e2);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public final void destroyAdapterIfPostponed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.mLock) {
                if (this.mInWhichUserCallback == 0) {
                    throw new IllegalStateException("Method should not be called when read has not completed.");
                }
                if (this.mDestroyAdapterPostponed) {
                    destroyAdapter();
                }
            }
        }
    }

    public void initializeWithRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.mLock) {
                this.mInWhichUserCallback = 2;
            }
            try {
                this.mRequest.checkCallingThread();
                long length = this.mDataProvider.mWrappedProvider.getLength();
                this.mLength = length;
                this.mRemainingLength = length;
            } catch (Throwable th) {
                onError(th);
            }
            synchronized (this.mLock) {
                this.mInWhichUserCallback = 3;
            }
        }
    }

    public final void onError(Throwable th) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
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
                } catch (Exception e2) {
                    Log.e(TAG, "Failure closing data provider", e2);
                }
            }
            this.mRequest.onUploadException(th);
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    public void onReadError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
            synchronized (this.mLock) {
                checkState(0);
                onError(exc);
            }
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    @SuppressLint({"DefaultLocale"})
    public void onReadSucceeded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            synchronized (this.mLock) {
                checkState(0);
                if (this.mByteBufferLimit != this.mByteBuffer.limit()) {
                    throw new IllegalStateException("ByteBuffer limit changed");
                }
                if (z && this.mLength >= 0) {
                    throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                }
                int position = this.mByteBuffer.position();
                long j = this.mRemainingLength - position;
                this.mRemainingLength = j;
                if (j < 0 && this.mLength >= 0) {
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
    }

    @Override // aegon.chrome.net.UploadDataSink
    public void onRewindSucceeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            destroyAdapter();
        }
    }

    public void postTaskToExecutor(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) {
            try {
                this.mExecutor.execute(runnable);
            } catch (Throwable th) {
                this.mRequest.onUploadException(th);
            }
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
            this.mByteBuffer = byteBuffer;
            this.mByteBufferLimit = byteBuffer.limit();
            postTaskToExecutor(this.mReadTask);
        }
    }

    @CalledByNative
    public void rewind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            postTaskToExecutor(new Runnable(this) { // from class: aegon.chrome.net.impl.CronetUploadDataStream.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CronetUploadDataStream this$0;

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
                        synchronized (this.this$0.mLock) {
                            if (this.this$0.mUploadDataStreamAdapter == 0) {
                                return;
                            }
                            this.this$0.checkState(3);
                            this.this$0.mInWhichUserCallback = 1;
                            try {
                                CronetUploadDataStream.access$500(this.this$0);
                                VersionSafeCallbacks$UploadDataProviderWrapper versionSafeCallbacks$UploadDataProviderWrapper = this.this$0.mDataProvider;
                                versionSafeCallbacks$UploadDataProviderWrapper.mWrappedProvider.rewind(this.this$0);
                            } catch (Exception e2) {
                                this.this$0.onError(e2);
                            }
                        }
                    }
                }
            });
        }
    }
}
