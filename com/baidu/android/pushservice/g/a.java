package com.baidu.android.pushservice.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a extends ThreadPoolExecutor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0022a<V> extends FutureTask<V> implements Comparable<C0022a<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
        public Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0022a(a aVar, Runnable runnable, V v) {
            super(runnable, v);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Runnable) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = runnable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0022a(a aVar, Callable<V> callable) {
            super(callable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callable};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Callable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0022a<V> c0022a) {
            InterceptResult invokeL;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0022a)) == null) {
                if (this == c0022a) {
                    return 0;
                }
                if (c0022a == null) {
                    return -1;
                }
                Object obj2 = this.b;
                if (obj2 == null || (obj = c0022a.b) == null || !(obj2 instanceof c) || !(obj instanceof c)) {
                    return 0;
                }
                return ((c) obj).d() - ((c) this.b).d();
            }
            return invokeL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i, int i2, long j, TimeUnit timeUnit, b<Runnable> bVar) {
        super(i, i2, j, timeUnit, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), timeUnit, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), (TimeUnit) objArr2[3], (BlockingQueue) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            synchronized (this) {
                if (getQueue().size() >= 19) {
                    if (getPoolSize() >= getMaximumPoolSize()) {
                        getQueue().clear();
                    } else {
                        getQueue().offer(runnable);
                        runnable = getQueue().poll();
                    }
                }
                super.execute(runnable);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, t)) == null) ? new C0022a(this, runnable, t) : (RunnableFuture) invokeLL.objValue;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callable)) == null) ? new C0022a(this, callable) : (RunnableFuture) invokeL.objValue;
    }
}
