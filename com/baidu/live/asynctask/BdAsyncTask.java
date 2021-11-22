package com.baidu.live.asynctask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class BdAsyncTask<ParamsT, ProgressT, ResultT> {
    public static /* synthetic */ Interceptable $ic;
    public static final b.a.w.a.a k;
    public static final e l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f<ParamsT, ResultT> f39491a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.w.a.b<ResultT> f39492b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f39493c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f39494d;

    /* renamed from: e  reason: collision with root package name */
    public volatile BdAsyncTaskStatus f39495e;

    /* renamed from: f  reason: collision with root package name */
    public int f39496f;

    /* renamed from: g  reason: collision with root package name */
    public int f39497g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.w.a.c f39498h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39499i;
    public boolean j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class BdAsyncTaskStatus {
        public static final /* synthetic */ BdAsyncTaskStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdAsyncTaskStatus FINISHED;
        public static final BdAsyncTaskStatus PENDING;
        public static final BdAsyncTaskStatus RUNNING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1763695150, "Lcom/baidu/live/asynctask/BdAsyncTask$BdAsyncTaskStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1763695150, "Lcom/baidu/live/asynctask/BdAsyncTask$BdAsyncTaskStatus;");
                    return;
                }
            }
            PENDING = new BdAsyncTaskStatus("PENDING", 0);
            RUNNING = new BdAsyncTaskStatus("RUNNING", 1);
            BdAsyncTaskStatus bdAsyncTaskStatus = new BdAsyncTaskStatus("FINISHED", 2);
            FINISHED = bdAsyncTaskStatus;
            $VALUES = new BdAsyncTaskStatus[]{PENDING, RUNNING, bdAsyncTaskStatus};
        }

        public BdAsyncTaskStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BdAsyncTaskStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdAsyncTaskStatus) Enum.valueOf(BdAsyncTaskStatus.class, str) : (BdAsyncTaskStatus) invokeL.objValue;
        }

        public static BdAsyncTaskStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdAsyncTaskStatus[]) $VALUES.clone() : (BdAsyncTaskStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends f<ParamsT, ResultT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BdAsyncTask f39500f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdAsyncTask bdAsyncTask) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39500f = bdAsyncTask;
        }

        @Override // java.util.concurrent.Callable
        public ResultT call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f39500f.f39492b.isCancelled()) {
                    return (ResultT) this.f39500f.u(null);
                }
                BdAsyncTask bdAsyncTask = this.f39500f;
                return (ResultT) bdAsyncTask.u(bdAsyncTask.f(this.f39505e));
            }
            return (ResultT) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends b.a.w.a.b<ResultT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BdAsyncTask f39501f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BdAsyncTask bdAsyncTask, Callable callable, BdAsyncTask bdAsyncTask2) {
            super(callable, bdAsyncTask2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask, callable, bdAsyncTask2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Callable) objArr2[0], (BdAsyncTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39501f = bdAsyncTask;
        }

        @Override // b.a.w.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39501f.d();
            }
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f39501f.u(get());
                } catch (InterruptedException unused) {
                } catch (CancellationException unused2) {
                    this.f39501f.u(null);
                } catch (ExecutionException e2) {
                    this.f39501f.u(null);
                    e2.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39502a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-697730976, "Lcom/baidu/live/asynctask/BdAsyncTask$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-697730976, "Lcom/baidu/live/asynctask/BdAsyncTask$c;");
                    return;
                }
            }
            int[] iArr = new int[BdAsyncTaskStatus.values().length];
            f39502a = iArr;
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39502a[BdAsyncTaskStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d<DataT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final BdAsyncTask f39503a;

        /* renamed from: b  reason: collision with root package name */
        public final DataT[] f39504b;

        public d(BdAsyncTask bdAsyncTask, DataT... datatArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask, datatArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39503a = bdAsyncTask;
            this.f39504b = datatArr;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                d dVar = (d) message.obj;
                int i2 = message.what;
                if (i2 == 1) {
                    dVar.f39503a.i(dVar.f39504b[0]);
                } else if (i2 != 2) {
                } else {
                    dVar.f39503a.t(dVar.f39504b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class f<ParamsT, ResultT> implements Callable<ResultT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ParamsT[] f39505e;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-425306561, "Lcom/baidu/live/asynctask/BdAsyncTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-425306561, "Lcom/baidu/live/asynctask/BdAsyncTask;");
                return;
            }
        }
        k = b.a.w.a.a.e();
        l = new e(Looper.getMainLooper());
    }

    public BdAsyncTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39493c = new AtomicBoolean(false);
        this.f39494d = new AtomicBoolean(false);
        this.f39495e = BdAsyncTaskStatus.PENDING;
        this.f39496f = 1;
        this.f39497g = 0;
        this.f39498h = null;
        this.f39499i = false;
        this.j = false;
        this.f39491a = new a(this);
        this.f39492b = new b(this, this.f39491a, this);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e(true);
        }
    }

    public final synchronized boolean e(boolean z) {
        InterceptResult invokeZ;
        boolean cancel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (!this.f39499i) {
                    k.h(this);
                }
                cancel = this.f39492b.cancel(z);
                if (this.f39494d.compareAndSet(false, true)) {
                    r();
                }
            }
            return cancel;
        }
        return invokeZ.booleanValue;
    }

    public abstract ResultT f(ParamsT... paramstArr);

    public final BdAsyncTask<ParamsT, ProgressT, ResultT> g(ParamsT... paramstArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, paramstArr)) == null) {
            h(k, paramstArr);
            return this;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public final synchronized BdAsyncTask<ParamsT, ProgressT, ResultT> h(Executor executor, ParamsT... paramstArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, executor, paramstArr)) == null) {
            synchronized (this) {
                if (this.f39495e != BdAsyncTaskStatus.PENDING) {
                    int i2 = c.f39502a[this.f39495e.ordinal()];
                    if (i2 == 1) {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    }
                    if (i2 == 2) {
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                }
                this.f39495e = BdAsyncTaskStatus.RUNNING;
                s();
                this.f39491a.f39505e = paramstArr;
                executor.execute(this.f39492b);
            }
            return this;
        }
        return (BdAsyncTask) invokeLL.objValue;
    }

    public final void i(ResultT resultt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, resultt) == null) {
            if (l()) {
                p(resultt);
            } else {
                q(resultt);
            }
            this.f39495e = BdAsyncTaskStatus.FINISHED;
        }
    }

    public b.a.w.a.c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39498h : (b.a.w.a.c) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39496f : invokeV.intValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39492b.isCancelled() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39499i : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void p(ResultT resultt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, resultt) == null) {
            o();
        }
    }

    public abstract void q(ResultT resultt);

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void t(ProgressT... progresstArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, progresstArr) == null) {
        }
    }

    public final ResultT u(ResultT resultt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, resultt)) == null) {
            if (this.f39493c.compareAndSet(false, true)) {
                l.obtainMessage(1, new d(this, resultt)).sendToTarget();
                return resultt;
            }
            return null;
        }
        return (ResultT) invokeL.objValue;
    }

    public synchronized void v(b.a.w.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            synchronized (this) {
                if (this.f39495e == BdAsyncTaskStatus.PENDING) {
                    this.f39498h = cVar;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
        }
    }

    public synchronized int w(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            synchronized (this) {
                if (this.f39495e == BdAsyncTaskStatus.PENDING) {
                    i3 = this.f39496f;
                    this.f39496f = i2;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public synchronized int x(b.a.w.j.b bVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            synchronized (this) {
                if (this.f39495e == BdAsyncTaskStatus.PENDING) {
                    i2 = this.f39497g;
                    if (bVar != null) {
                        this.f39497g = bVar.b();
                    }
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public synchronized void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            synchronized (this) {
                this.j = z;
            }
        }
    }
}
