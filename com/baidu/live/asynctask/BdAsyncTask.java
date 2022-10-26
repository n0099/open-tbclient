package com.baidu.live.asynctask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p90;
import com.baidu.tieba.q90;
import com.baidu.tieba.r90;
import com.baidu.tieba.xc0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class BdAsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public static final p90 k;
    public static final e l;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;
    public final q90 b;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public volatile BdAsyncTaskStatus e;
    public int f;
    public int g;
    public r90 h;
    public boolean i;
    public boolean j;

    public abstract Object f(Object... objArr);

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public abstract void q(Object obj);

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

    public void t(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, objArr) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class BdAsyncTaskStatus {
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
            RUNNING = new BdAsyncTaskStatus(TornadoLiteRuntime.STATE_RUNNING, 1);
            BdAsyncTaskStatus bdAsyncTaskStatus = new BdAsyncTaskStatus("FINISHED", 2);
            FINISHED = bdAsyncTaskStatus;
            $VALUES = new BdAsyncTaskStatus[]{PENDING, RUNNING, bdAsyncTaskStatus};
        }

        public BdAsyncTaskStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BdAsyncTaskStatus) Enum.valueOf(BdAsyncTaskStatus.class, str);
            }
            return (BdAsyncTaskStatus) invokeL.objValue;
        }

        public static BdAsyncTaskStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BdAsyncTaskStatus[]) $VALUES.clone();
            }
            return (BdAsyncTaskStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdAsyncTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdAsyncTask bdAsyncTask) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bdAsyncTask;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.b.b.isCancelled()) {
                    BdAsyncTask bdAsyncTask = this.b;
                    return bdAsyncTask.u(bdAsyncTask.f(this.a));
                }
                return this.b.u(null);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends q90 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdAsyncTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BdAsyncTask bdAsyncTask, Callable callable, BdAsyncTask bdAsyncTask2) {
            super(callable, bdAsyncTask2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask, callable, bdAsyncTask2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Callable) objArr2[0], (BdAsyncTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bdAsyncTask;
        }

        @Override // com.baidu.tieba.q90
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d();
            }
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.b.u(get());
                } catch (InterruptedException unused) {
                } catch (CancellationException unused2) {
                    this.b.u(null);
                } catch (ExecutionException e) {
                    this.b.u(null);
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BdAsyncTaskStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BdAsyncTask a;
        public final Object[] b;

        public d(BdAsyncTask bdAsyncTask, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {bdAsyncTask, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdAsyncTask;
            this.b = objArr;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends Handler {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        dVar.a.t(dVar.b);
                        return;
                    }
                    return;
                }
                dVar.a.i(dVar.b[0]);
            }
        }
    }

    /* loaded from: classes2.dex */
    public abstract class f implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object[] a;

        public f() {
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
        k = p90.e();
        l = new e(Looper.getMainLooper());
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e(true);
        }
    }

    public r90 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (r90) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b.isCancelled();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public BdAsyncTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = BdAsyncTaskStatus.PENDING;
        this.f = 1;
        this.g = 0;
        this.h = null;
        this.i = false;
        this.j = false;
        this.a = new a(this);
        this.b = new b(this, this.a, this);
    }

    public final BdAsyncTask g(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            h(k, objArr);
            return this;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public final void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            if (l()) {
                p(obj);
            } else {
                q(obj);
            }
            this.e = BdAsyncTaskStatus.FINISHED;
        }
    }

    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            o();
        }
    }

    public final Object u(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (this.c.compareAndSet(false, true)) {
                l.obtainMessage(1, new d(this, obj)).sendToTarget();
                return obj;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public synchronized void v(r90 r90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, r90Var) == null) {
            synchronized (this) {
                if (this.e == BdAsyncTaskStatus.PENDING) {
                    this.h = r90Var;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
        }
    }

    public synchronized int w(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            synchronized (this) {
                if (this.e == BdAsyncTaskStatus.PENDING) {
                    i2 = this.f;
                    this.f = i;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public synchronized int x(xc0 xc0Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, xc0Var)) == null) {
            synchronized (this) {
                if (this.e == BdAsyncTaskStatus.PENDING) {
                    i = this.g;
                    if (xc0Var != null) {
                        this.g = xc0Var.b();
                    }
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return i;
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

    public final synchronized boolean e(boolean z) {
        InterceptResult invokeZ;
        boolean cancel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (!this.i) {
                    k.h(this);
                }
                cancel = this.b.cancel(z);
                if (this.d.compareAndSet(false, true)) {
                    r();
                }
            }
            return cancel;
        }
        return invokeZ.booleanValue;
    }

    public final synchronized BdAsyncTask h(Executor executor, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, executor, objArr)) == null) {
            synchronized (this) {
                if (this.e != BdAsyncTaskStatus.PENDING) {
                    int i = c.a[this.e.ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                        }
                    } else {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    }
                }
                this.e = BdAsyncTaskStatus.RUNNING;
                s();
                this.a.a = objArr;
                executor.execute(this.b);
            }
            return this;
        }
        return (BdAsyncTask) invokeLL.objValue;
    }
}
