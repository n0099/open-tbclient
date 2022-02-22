package c.a.d0.d0.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e extends BaseExecutorCell {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 != 1) {
            d();
            String str = "You are creating a SerialExecutorCell with maxThreadNum " + i2 + ". For SerialExecutorCell, maxThreadNum must be 1. So it will be forced to set to 1.";
            this.f37369b = 1;
        }
        this.f37370c = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e() < 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SerialElasticExecutorCell" : (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public synchronized void f(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, elasticTask) == null) {
            synchronized (this) {
                super.f(elasticTask);
                if (c.a.d0.d0.a.f2655b) {
                    c.a.d0.d0.f.c.f().n(c.a.d0.d0.a.f2656c + 10);
                }
            }
        }
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public synchronized void g(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, elasticTask) == null) {
            synchronized (this) {
                super.g(elasticTask);
                c.a.d0.d0.f.c.f().o();
            }
        }
    }

    public final void i(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            elasticTask.h(null);
            this.f37370c.shutdown();
            this.a.clear();
            this.f37370c = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            c.a.d0.d0.f.c.f().o();
        }
    }

    public synchronized boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (c.a.d0.d0.a.f2655b) {
                    ElasticTask k = k();
                    if (k == null) {
                        return false;
                    }
                    if (k.c() >= c.a.d0.d0.a.f2656c) {
                        i(k);
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized ElasticTask k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return null;
                }
                return this.a.get(0);
            }
        }
        return (ElasticTask) invokeV.objValue;
    }
}
