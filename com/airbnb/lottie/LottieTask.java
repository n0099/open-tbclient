package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes4.dex */
public class LottieTask<T> {
    public static /* synthetic */ Interceptable $ic;
    public static Executor EXECUTOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<LottieListener<Throwable>> failureListeners;
    public final Handler handler;
    @Nullable
    public volatile LottieResult<T> result;
    public final Set<LottieListener<T>> successListeners;

    /* loaded from: classes4.dex */
    public class LottieFutureTask extends FutureTask<LottieResult<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LottieFutureTask(LottieTask lottieTask, Callable<LottieResult<T>> callable) {
            super(callable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lottieTask, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Callable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lottieTask;
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || isCancelled()) {
                return;
            }
            try {
                this.this$0.setResult(get());
            } catch (InterruptedException | ExecutionException e2) {
                this.this$0.setResult(new LottieResult(e2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-356654224, "Lcom/airbnb/lottie/LottieTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-356654224, "Lcom/airbnb/lottie/LottieTask;");
                return;
            }
        }
        EXECUTOR = Executors.newCachedThreadPool();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Callable) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyFailureListeners(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, th) == null) {
            synchronized (this) {
                ArrayList<LottieListener> arrayList = new ArrayList(this.failureListeners);
                if (arrayList.isEmpty()) {
                    Logger.warning("Lottie encountered an error but no failure listener was added:", th);
                    return;
                }
                for (LottieListener lottieListener : arrayList) {
                    lottieListener.onResult(th);
                }
            }
        }
    }

    private void notifyListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.handler.post(new Runnable(this) { // from class: com.airbnb.lottie.LottieTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LottieTask this$0;

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
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.result == null) {
                        return;
                    }
                    LottieResult lottieResult = this.this$0.result;
                    if (lottieResult.getValue() != null) {
                        this.this$0.notifySuccessListeners(lottieResult.getValue());
                    } else {
                        this.this$0.notifyFailureListeners(lottieResult.getException());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifySuccessListeners(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, t) == null) {
            synchronized (this) {
                for (LottieListener lottieListener : new ArrayList(this.successListeners)) {
                    lottieListener.onResult(t);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(@Nullable LottieResult<T> lottieResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, lottieResult) == null) {
            if (this.result == null) {
                this.result = lottieResult;
                notifyListeners();
                return;
            }
            throw new IllegalStateException("A task may only be set once.");
        }
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lottieListener)) == null) {
            synchronized (this) {
                if (this.result != null && this.result.getException() != null) {
                    lottieListener.onResult(this.result.getException());
                }
                this.failureListeners.add(lottieListener);
            }
            return this;
        }
        return (LottieTask) invokeL.objValue;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieListener)) == null) {
            synchronized (this) {
                if (this.result != null && this.result.getValue() != null) {
                    lottieListener.onResult(this.result.getValue());
                }
                this.successListeners.add(lottieListener);
            }
            return this;
        }
        return (LottieTask) invokeL.objValue;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lottieListener)) == null) {
            synchronized (this) {
                this.failureListeners.remove(lottieListener);
            }
            return this;
        }
        return (LottieTask) invokeL.objValue;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lottieListener)) == null) {
            synchronized (this) {
                this.successListeners.remove(lottieListener);
            }
            return this;
        }
        return (LottieTask) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new LottieResult<>(th));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(this, callable));
    }
}
