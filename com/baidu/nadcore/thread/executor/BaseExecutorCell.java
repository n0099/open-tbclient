package com.baidu.nadcore.thread.executor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d01;
import com.repackage.f01;
import com.repackage.g01;
import com.repackage.h01;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public abstract class BaseExecutorCell {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<ElasticTask> a;
    public int b;
    public ThreadPoolExecutor c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ExecutorType {
        public static final /* synthetic */ ExecutorType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ExecutorType ARTERY;
        public static final ExecutorType DREDGE_DISASTER;
        public static final ExecutorType DREDGE_NORMAL;
        public static final ExecutorType SERIAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1115711316, "Lcom/baidu/nadcore/thread/executor/BaseExecutorCell$ExecutorType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1115711316, "Lcom/baidu/nadcore/thread/executor/BaseExecutorCell$ExecutorType;");
                    return;
                }
            }
            ARTERY = new ExecutorType("ARTERY", 0);
            DREDGE_NORMAL = new ExecutorType("DREDGE_NORMAL", 1);
            DREDGE_DISASTER = new ExecutorType("DREDGE_DISASTER", 2);
            ExecutorType executorType = new ExecutorType("SERIAL", 3);
            SERIAL = executorType;
            $VALUES = new ExecutorType[]{ARTERY, DREDGE_NORMAL, DREDGE_DISASTER, executorType};
        }

        public ExecutorType(String str, int i) {
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

        public static ExecutorType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ExecutorType) Enum.valueOf(ExecutorType.class, str) : (ExecutorType) invokeL.objValue;
        }

        public static ExecutorType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ExecutorType[]) $VALUES.clone() : (ExecutorType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ElasticTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ElasticTask a;
        public final /* synthetic */ BaseExecutorCell b;

        public a(BaseExecutorCell baseExecutorCell, ElasticTask elasticTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseExecutorCell, elasticTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = baseExecutorCell;
            this.a = elasticTask;
        }

        @Override // com.baidu.nadcore.thread.task.ElasticTask.a
        public void afterExecuteTask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.g(this.a);
            }
        }

        @Override // com.baidu.nadcore.thread.task.ElasticTask.a
        public void beforeExecuteTask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.f(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1701166995, "Lcom/baidu/nadcore/thread/executor/BaseExecutorCell$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1701166995, "Lcom/baidu/nadcore/thread/executor/BaseExecutorCell$b;");
                    return;
                }
            }
            int[] iArr = new int[ExecutorType.values().length];
            a = iArr;
            try {
                iArr[ExecutorType.ARTERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ExecutorType.DREDGE_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ExecutorType.DREDGE_DISASTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ExecutorType.SERIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BaseExecutorCell(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
        this.b = i;
    }

    public static BaseExecutorCell b(int i, ExecutorType executorType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, executorType)) == null) {
            int i2 = b.a[executorType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return new g01(i);
                        }
                        return new h01(i);
                    }
                    return new f01(i);
                }
                return new g01(i);
            }
            return new d01(i);
        }
        return (BaseExecutorCell) invokeIL.objValue;
    }

    public abstract boolean a();

    public synchronized boolean c(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, elasticTask)) == null) {
            synchronized (this) {
                if (a()) {
                    elasticTask.h(new a(this, elasticTask));
                    this.a.add(elasticTask);
                    this.c.execute(elasticTask);
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public abstract String d();

    public synchronized int e() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                size = this.a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized void f(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            synchronized (this) {
                elasticTask.g();
                h(elasticTask);
            }
        }
    }

    public synchronized void g(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, elasticTask) == null) {
            synchronized (this) {
                elasticTask.e();
                this.a.remove(elasticTask);
            }
        }
    }

    public final void h(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, elasticTask) == null) {
            int b2 = elasticTask.b();
            Thread currentThread = Thread.currentThread();
            if (b2 == 0) {
                currentThread.setPriority(9);
            } else if (b2 == 1) {
                currentThread.setPriority(7);
            } else if (b2 == 2) {
                currentThread.setPriority(5);
            } else if (b2 == 3) {
                currentThread.setPriority(3);
            } else if (b2 == 4) {
                currentThread.setPriority(7);
            }
            currentThread.setName(elasticTask.a());
        }
    }
}
