package com.baidu.minivideo.arface.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class ThreadPool {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f26963b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4114786347960826192L;
        public transient /* synthetic */ FieldHolder $fh;

        public LIFOLinkedBlockingDeque() {
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

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? super.offerFirst(t) : invokeL.booleanValue;
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
        public T remove() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (T) super.removeFirst() : (T) invokeV.objValue;
        }

        public /* synthetic */ LIFOLinkedBlockingDeque(a aVar) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class QueueProcessingType {
        public static final /* synthetic */ QueueProcessingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final QueueProcessingType FIFO;
        public static final QueueProcessingType LIFO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-521697835, "Lcom/baidu/minivideo/arface/utils/ThreadPool$QueueProcessingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-521697835, "Lcom/baidu/minivideo/arface/utils/ThreadPool$QueueProcessingType;");
                    return;
                }
            }
            FIFO = new QueueProcessingType("FIFO", 0);
            QueueProcessingType queueProcessingType = new QueueProcessingType("LIFO", 1);
            LIFO = queueProcessingType;
            $VALUES = new QueueProcessingType[]{FIFO, queueProcessingType};
        }

        public QueueProcessingType(String str, int i) {
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

        public static QueueProcessingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (QueueProcessingType) Enum.valueOf(QueueProcessingType.class, str) : (QueueProcessingType) invokeL.objValue;
        }

        public static QueueProcessingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (QueueProcessingType[]) $VALUES.clone() : (QueueProcessingType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicInteger f26964e;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f26965b;

        /* renamed from: c  reason: collision with root package name */
        public final String f26966c;

        /* renamed from: d  reason: collision with root package name */
        public final int f26967d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2008763441, "Lcom/baidu/minivideo/arface/utils/ThreadPool$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2008763441, "Lcom/baidu/minivideo/arface/utils/ThreadPool$b;");
                    return;
                }
            }
            f26964e = new AtomicInteger(1);
        }

        public b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f26965b = new AtomicInteger(1);
            this.f26967d = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.f26966c = str + "-" + f26964e.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.a;
                Thread thread = new Thread(threadGroup, runnable, this.f26966c + this.f26965b.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.f26967d);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final int f26968f;

        /* renamed from: g  reason: collision with root package name */
        public static final int f26969g;

        /* renamed from: h  reason: collision with root package name */
        public static final int f26970h;
        public transient /* synthetic */ FieldHolder $fh;
        public ExecutorService a;

        /* renamed from: b  reason: collision with root package name */
        public int f26971b;

        /* renamed from: c  reason: collision with root package name */
        public int f26972c;

        /* renamed from: d  reason: collision with root package name */
        public String f26973d;

        /* renamed from: e  reason: collision with root package name */
        public QueueProcessingType f26974e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2008763472, "Lcom/baidu/minivideo/arface/utils/ThreadPool$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2008763472, "Lcom/baidu/minivideo/arface/utils/ThreadPool$c;");
                    return;
                }
            }
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            f26968f = availableProcessors;
            f26969g = Math.max(2, Math.min(availableProcessors - 1, 4));
            f26970h = f26968f;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
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
                    this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (QueueProcessingType) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ExecutorService executorService = this.a;
                if (!(executorService instanceof ThreadPoolExecutor) || executorService == null || executorService.isShutdown()) {
                    return;
                }
                ((ThreadPoolExecutor) this.a).allowsCoreThreadTimeOut();
            }
        }

        public final ExecutorService d(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), queueProcessingType})) == null) {
                return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(null), new b(str, i2));
            }
            return (ExecutorService) invokeCommon.objValue;
        }

        public void e(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.a.execute(runnable);
            }
        }

        public c(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), queueProcessingType};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f26971b = f26969g;
            this.f26972c = 4;
            this.f26974e = QueueProcessingType.FIFO;
            this.f26973d = str;
            this.f26971b = i;
            this.f26972c = i2;
            this.f26974e = queueProcessingType;
            if (this.a == null) {
                this.a = d(str, i, i2, queueProcessingType);
            }
        }
    }

    public ThreadPool() {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f26963b == null) {
                synchronized (ThreadPool.class) {
                    if (f26963b == null) {
                        c cVar = new c("ComputationThreadPool", c.f26969g);
                        cVar.c();
                        f26963b = cVar;
                    }
                }
            }
            return f26963b;
        }
        return (c) invokeV.objValue;
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (ThreadPool.class) {
                    if (a == null) {
                        c cVar = new c("IOThreadPool", c.f26970h);
                        cVar.c();
                        a = cVar;
                    }
                }
            }
            return a;
        }
        return (c) invokeV.objValue;
    }
}
