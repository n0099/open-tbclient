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
/* loaded from: classes5.dex */
public class ThreadPool {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f42585a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f42586b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4114786347960826192L;
        public transient /* synthetic */ FieldHolder $fh;

        public LIFOLinkedBlockingDeque() {
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
    /* loaded from: classes5.dex */
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

        public QueueProcessingType(String str, int i2) {
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: i  reason: collision with root package name */
        public static final AtomicInteger f42587i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ThreadGroup f42588e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f42589f;

        /* renamed from: g  reason: collision with root package name */
        public final String f42590g;

        /* renamed from: h  reason: collision with root package name */
        public final int f42591h;

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
            f42587i = new AtomicInteger(1);
        }

        public b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f42589f = new AtomicInteger(1);
            this.f42591h = i2;
            SecurityManager securityManager = System.getSecurityManager();
            this.f42588e = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.f42590g = str + "-" + f42587i.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.f42588e;
                Thread thread = new Thread(threadGroup, runnable, this.f42590g + this.f42589f.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.f42591h);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final int f42592f;

        /* renamed from: g  reason: collision with root package name */
        public static final int f42593g;

        /* renamed from: h  reason: collision with root package name */
        public static final int f42594h;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ExecutorService f42595a;

        /* renamed from: b  reason: collision with root package name */
        public int f42596b;

        /* renamed from: c  reason: collision with root package name */
        public int f42597c;

        /* renamed from: d  reason: collision with root package name */
        public String f42598d;

        /* renamed from: e  reason: collision with root package name */
        public QueueProcessingType f42599e;

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
            f42592f = availableProcessors;
            f42593g = Math.max(2, Math.min(availableProcessors - 1, 4));
            f42594h = f42592f;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(String str, int i2) {
            this(str, i2, 9, QueueProcessingType.FIFO);
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
                ExecutorService executorService = this.f42595a;
                if (!(executorService instanceof ThreadPoolExecutor) || executorService == null || executorService.isShutdown()) {
                    return;
                }
                ((ThreadPoolExecutor) this.f42595a).allowsCoreThreadTimeOut();
            }
        }

        public final ExecutorService d(String str, int i2, int i3, QueueProcessingType queueProcessingType) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), queueProcessingType})) == null) {
                return new ThreadPoolExecutor(i2, i2, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(null), new b(str, i3));
            }
            return (ExecutorService) invokeCommon.objValue;
        }

        public void e(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.f42595a.execute(runnable);
            }
        }

        public c(String str, int i2, int i3, QueueProcessingType queueProcessingType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), queueProcessingType};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f42596b = f42593g;
            this.f42597c = 4;
            this.f42599e = QueueProcessingType.FIFO;
            this.f42598d = str;
            this.f42596b = i2;
            this.f42597c = i3;
            this.f42599e = queueProcessingType;
            if (this.f42595a == null) {
                this.f42595a = d(str, i2, i3, queueProcessingType);
            }
        }
    }

    public ThreadPool() {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f42586b == null) {
                synchronized (ThreadPool.class) {
                    if (f42586b == null) {
                        c cVar = new c("ComputationThreadPool", c.f42593g);
                        cVar.c();
                        f42586b = cVar;
                    }
                }
            }
            return f42586b;
        }
        return (c) invokeV.objValue;
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f42585a == null) {
                synchronized (ThreadPool.class) {
                    if (f42585a == null) {
                        c cVar = new c("IOThreadPool", c.f42594h);
                        cVar.c();
                        f42585a = cVar;
                    }
                }
            }
            return f42585a;
        }
        return (c) invokeV.objValue;
    }
}
