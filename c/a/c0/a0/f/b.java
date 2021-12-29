package c.a.c0.a0.f;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile c.a.c0.a0.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c.a.c0.a0.c.b f1757b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c.a.c0.a0.c.b f1758c;

    /* renamed from: d  reason: collision with root package name */
    public int f1759d;

    /* renamed from: e  reason: collision with root package name */
    public long f1760e;

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
        this.f1759d = 0;
        this.f1760e = 0L;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            double a = c.f().g().a();
            if (a >= c.a.c0.a0.a.f1750j && 3 != this.f1759d) {
                if ((a >= c.a.c0.a0.a.f1751k) || SystemClock.elapsedRealtime() - this.f1760e > c.a.c0.a0.a.m) {
                    g();
                    this.f1760e = SystemClock.elapsedRealtime();
                    c.f().j(c.a.c0.a0.a.m + 10);
                    return 1;
                }
            }
            if (this.f1759d == 0 || a >= c.a.c0.a0.a.l || SystemClock.elapsedRealtime() - this.f1760e <= c.a.c0.a0.a.n) {
                return 0;
            }
            b();
            this.f1760e = SystemClock.elapsedRealtime();
            c.f().j(c.a.c0.a0.a.n + 10);
            return -1;
        }
        return invokeV.intValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f1759d;
            if (1 == i2) {
                e().j();
                this.f1759d = 0;
            } else if (2 == i2) {
                f().j();
                this.f1759d = 1;
            } else if (3 == i2) {
                d().j();
                this.f1759d = 2;
            }
        }
    }

    public boolean c(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, elasticTask)) == null) {
            int i2 = this.f1759d;
            if (i2 == 0) {
                return false;
            }
            if (i2 == 1) {
                return e().c(elasticTask);
            }
            if (i2 == 2) {
                if (e().c(elasticTask)) {
                    return true;
                }
                return f().c(elasticTask);
            } else if (i2 == 3) {
                if (e().c(elasticTask) || f().c(elasticTask)) {
                    return true;
                }
                return d().c(elasticTask);
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public c.a.c0.a0.c.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f1758c == null) {
                synchronized (this) {
                    if (this.f1758c == null) {
                        this.f1758c = (c.a.c0.a0.c.b) BaseExecutorCell.b(c.a.c0.a0.a.f1749i, BaseExecutorCell.ExecutorType.DREDGE_DISASTER);
                    }
                }
            }
            return this.f1758c;
        }
        return (c.a.c0.a0.c.b) invokeV.objValue;
    }

    public c.a.c0.a0.c.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = (c.a.c0.a0.c.b) BaseExecutorCell.b(c.a.c0.a0.a.f1747g, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                    }
                }
            }
            return this.a;
        }
        return (c.a.c0.a0.c.b) invokeV.objValue;
    }

    public c.a.c0.a0.c.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f1757b == null) {
                synchronized (this) {
                    if (this.f1757b == null) {
                        this.f1757b = (c.a.c0.a0.c.b) BaseExecutorCell.b(c.a.c0.a0.a.f1748h, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                    }
                }
            }
            return this.f1757b;
        }
        return (c.a.c0.a0.c.b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f1759d;
            if (i2 == 0) {
                e().i();
                this.f1759d = 1;
            } else if (1 == i2) {
                f().i();
                this.f1759d = 2;
            } else if (2 == i2) {
                d().i();
                this.f1759d = 3;
            }
        }
    }
}
