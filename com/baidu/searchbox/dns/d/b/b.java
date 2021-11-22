package com.baidu.searchbox.dns.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int Z;
    public int aa;
    public final Queue<a> ab;
    public final Queue<a> ac;
    public ExecutorService ad;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Z = 15;
        this.aa = 1;
        this.ab = E();
        this.ac = F();
    }

    private synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (this.ac.size() >= this.Z) {
                    return;
                }
                if (this.ab.isEmpty()) {
                    return;
                }
                Iterator<a> it = this.ab.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (c(next) < this.aa) {
                        it.remove();
                        this.ac.add(next);
                        H().execute(next);
                    }
                    if (this.ac.size() >= this.Z) {
                        return;
                    }
                }
            }
        }
    }

    private int c(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            int i2 = 0;
            for (a aVar2 : this.ac) {
                if (aVar2.n().equals(aVar.n())) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public abstract Queue<a> E();

    public abstract Queue<a> F();

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Searchbox Dispatcher #" : (String) invokeV.objValue;
    }

    public synchronized ExecutorService H() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.ad == null) {
                    this.ad = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c(G(), false));
                }
                executorService = this.ad;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            synchronized (this) {
                if (this.ac.size() < this.Z && c(aVar) < this.aa) {
                    this.ac.add(aVar);
                    H().execute(aVar);
                } else {
                    this.ab.add(aVar);
                }
            }
        }
    }

    public synchronized void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this) {
                this.ac.remove(aVar);
                I();
            }
        }
    }

    private ThreadFactory c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, str, z)) == null) ? new ThreadFactory(this, str, z) { // from class: com.baidu.searchbox.dns.d.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final AtomicInteger ae;
            public final /* synthetic */ String af;
            public final /* synthetic */ boolean ag;
            public final /* synthetic */ b ah;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.ah = this;
                this.af = str;
                this.ag = z;
                this.ae = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    Thread thread = new Thread(runnable, this.af + this.ae.getAndIncrement());
                    thread.setDaemon(this.ag);
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        } : (ThreadFactory) invokeLZ.objValue;
    }
}
