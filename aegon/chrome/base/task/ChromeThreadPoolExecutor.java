package aegon.chrome.base.task;

import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.task.AsyncTask;
import android.os.Process;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    public static /* synthetic */ Interceptable $ic;
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int MAXIMUM_POOL_SIZE;
    public static final BlockingQueue<Runnable> sPoolWorkQueue;
    public static final ThreadFactory sThreadFactory;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: aegon.chrome.base.task.ChromeThreadPoolExecutor$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger mCount;

        public AnonymousClass1() {
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
            this.mCount = new AtomicInteger(1);
        }

        public static /* synthetic */ void lambda$newThread$0(Runnable runnable) {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Runnable runnable2 = ChromeThreadPoolExecutor$1$$Lambda$1.$ic;
                return new Thread(runnable2, "CrAsyncTask #" + this.mCount.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2081432224, "Laegon/chrome/base/task/ChromeThreadPoolExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2081432224, "Laegon/chrome/base/task/ChromeThreadPoolExecutor;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChromeThreadPoolExecutor() {
        super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), (TimeUnit) objArr[3], (BlockingQueue) objArr[4], (ThreadFactory) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        allowCoreThreadTimeOut(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006f  */
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(Runnable runnable) {
        Runnable[] runnableArr;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException e2) {
                HashMap hashMap = new HashMap();
                for (Runnable runnable2 : (Runnable[]) getQueue().toArray(new Runnable[0])) {
                    Class<?> cls = runnable2.getClass();
                    if (cls == AsyncTask.NamedFutureTask.class) {
                        try {
                            obj = ((AsyncTask.NamedFutureTask) runnable2).this$0;
                        } catch (IllegalAccessException e3) {
                            if (BuildConfig.DCHECK_IS_ON) {
                                throw new RuntimeException(e3);
                            }
                            String name = cls.getName();
                            hashMap.put(name, Integer.valueOf((!hashMap.containsKey(name) ? ((Integer) hashMap.get(name)).intValue() : 0) + 1));
                        } catch (NoSuchFieldException e4) {
                            if (BuildConfig.DCHECK_IS_ON) {
                                throw new RuntimeException(e4);
                            }
                            String name2 = cls.getName();
                            hashMap.put(name2, Integer.valueOf((!hashMap.containsKey(name2) ? ((Integer) hashMap.get(name2)).intValue() : 0) + 1));
                        }
                    } else {
                        if (cls.getEnclosingClass() == android.os.AsyncTask.class) {
                            Field declaredField = cls.getDeclaredField("this$0");
                            declaredField.setAccessible(true);
                            obj = declaredField.get(runnable2);
                        }
                        String name22 = cls.getName();
                        hashMap.put(name22, Integer.valueOf((!hashMap.containsKey(name22) ? ((Integer) hashMap.get(name22)).intValue() : 0) + 1));
                    }
                    cls = obj.getClass();
                    String name222 = cls.getName();
                    hashMap.put(name222, Integer.valueOf((!hashMap.containsKey(name222) ? ((Integer) hashMap.get(name222)).intValue() : 0) + 1));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Prominent classes in AsyncTask: ");
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (((Integer) entry.getValue()).intValue() > 32) {
                        sb2.append((String) entry.getKey());
                        sb2.append(' ');
                    }
                }
                sb.append(sb2.length() == 0 ? "NO CLASSES FOUND" : sb2.toString());
                throw new RejectedExecutionException(sb.toString(), e2);
            }
        }
    }
}
