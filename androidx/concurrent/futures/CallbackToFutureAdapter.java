package androidx.concurrent.futures;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Resolver {
        Object attachCompleter(Completer completer) throws Exception;
    }

    /* loaded from: classes.dex */
    public static final class Completer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean attemptedSetting;
        public ResolvableFuture<Void> cancellationFuture;
        public SafeFuture<T> future;
        public Object tag;

        public Completer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cancellationFuture = ResolvableFuture.create();
        }

        private void setCompletedNormally() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.tag = null;
                this.future = null;
                this.cancellationFuture = null;
            }
        }

        public void fireCancellationListeners() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.tag = null;
                this.future = null;
                this.cancellationFuture.set(null);
            }
        }

        public boolean setCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean z = true;
                this.attemptedSetting = true;
                SafeFuture<T> safeFuture = this.future;
                z = (safeFuture == null || !safeFuture.cancelWithoutNotifyingCompleter(true)) ? false : false;
                if (z) {
                    setCompletedNormally();
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public void addCancellationListener(Runnable runnable, Executor executor) {
            ResolvableFuture<Void> resolvableFuture;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) && (resolvableFuture = this.cancellationFuture) != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SafeFuture<T> safeFuture = this.future;
                if (safeFuture != null && !safeFuture.isDone()) {
                    safeFuture.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
                }
                if (!this.attemptedSetting && (resolvableFuture = this.cancellationFuture) != null) {
                    resolvableFuture.set(null);
                }
            }
        }

        public boolean set(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
                boolean z = true;
                this.attemptedSetting = true;
                SafeFuture<T> safeFuture = this.future;
                z = (safeFuture == null || !safeFuture.set(t)) ? false : false;
                if (z) {
                    setCompletedNormally();
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public boolean setException(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, th)) == null) {
                boolean z = true;
                this.attemptedSetting = true;
                SafeFuture<T> safeFuture = this.future;
                z = (safeFuture == null || !safeFuture.setException(th)) ? false : false;
                if (z) {
                    setCompletedNormally();
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class FutureGarbageCollectedException extends Throwable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FutureGarbageCollectedException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                }
                return this;
            }
            return (Throwable) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class SafeFuture<T> implements ListenableFuture<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<Completer<T>> completerWeakReference;
        public final AbstractResolvableFuture<T> delegate;

        public SafeFuture(Completer<T> completer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = new AbstractResolvableFuture<T>(this) { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SafeFuture this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.concurrent.futures.AbstractResolvableFuture
                public String pendingToString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Completer<T> completer2 = this.this$0.completerWeakReference.get();
                        if (completer2 == null) {
                            return "Completer object has been garbage collected, future will fail soon";
                        }
                        return "tag=[" + completer2.tag + PreferencesUtil.RIGHT_MOUNT;
                    }
                    return (String) invokeV.objValue;
                }
            };
            this.completerWeakReference = new WeakReference<>(completer);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) {
                this.delegate.addListener(runnable, executor);
            }
        }

        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, timeUnit)) == null) {
                return this.delegate.get(j, timeUnit);
            }
            return (T) invokeJL.objValue;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                Completer<T> completer = this.completerWeakReference.get();
                boolean cancel = this.delegate.cancel(z);
                if (cancel && completer != null) {
                    completer.fireCancellationListeners();
                }
                return cancel;
            }
            return invokeZ.booleanValue;
        }

        public boolean cancelWithoutNotifyingCompleter(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                return this.delegate.cancel(z);
            }
            return invokeZ.booleanValue;
        }

        public boolean set(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
                return this.delegate.set(t);
            }
            return invokeL.booleanValue;
        }

        public boolean setException(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th)) == null) {
                return this.delegate.setException(th);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.delegate.get();
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.delegate.isCancelled();
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.delegate.isDone();
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.delegate.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public CallbackToFutureAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> ListenableFuture<T> getFuture(Resolver<T> resolver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, resolver)) == null) {
            Completer completer = new Completer();
            SafeFuture<T> safeFuture = new SafeFuture<>(completer);
            completer.future = safeFuture;
            completer.tag = resolver.getClass();
            try {
                Object attachCompleter = resolver.attachCompleter(completer);
                if (attachCompleter != null) {
                    completer.tag = attachCompleter;
                }
            } catch (Exception e) {
                safeFuture.setException(e);
            }
            return safeFuture;
        }
        return (ListenableFuture) invokeL.objValue;
    }
}
