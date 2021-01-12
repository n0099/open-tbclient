package aegon.chrome.base.task;

import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.task.AsyncTask;
import android.os.Process;
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
/* loaded from: classes4.dex */
public class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    public static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    public static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
    public static final ThreadFactory sThreadFactory = new AnonymousClass1();
    public static final BlockingQueue<Runnable> sPoolWorkQueue = new ArrayBlockingQueue(128);

    /* renamed from: aegon.chrome.base.task.ChromeThreadPoolExecutor$1 */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements ThreadFactory {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public static /* synthetic */ void lambda$newThread$0(Runnable runnable) {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(ChromeThreadPoolExecutor$1$$Lambda$1.lambdaFactory$(runnable), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    public ChromeThreadPoolExecutor() {
        super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        allowCoreThreadTimeOut(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0084  */
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(Runnable runnable) {
        Runnable[] runnableArr;
        Class<?> cls;
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e) {
            HashMap hashMap = new HashMap();
            for (Runnable runnable2 : (Runnable[]) getQueue().toArray(new Runnable[0])) {
                Class<?> cls2 = runnable2.getClass();
                if (cls2 == AsyncTask.NamedFutureTask.class) {
                    try {
                        cls = ((AsyncTask.NamedFutureTask) runnable2).this$0.getClass();
                    } catch (IllegalAccessException e2) {
                        if (BuildConfig.DCHECK_IS_ON) {
                            throw new RuntimeException(e2);
                        }
                        cls = cls2;
                        String name = cls.getName();
                        hashMap.put(name, Integer.valueOf((hashMap.containsKey(name) ? ((Integer) hashMap.get(name)).intValue() : 0) + 1));
                    } catch (NoSuchFieldException e3) {
                        if (BuildConfig.DCHECK_IS_ON) {
                            throw new RuntimeException(e3);
                        }
                        cls = cls2;
                        String name2 = cls.getName();
                        hashMap.put(name2, Integer.valueOf((hashMap.containsKey(name2) ? ((Integer) hashMap.get(name2)).intValue() : 0) + 1));
                    }
                } else {
                    if (cls2.getEnclosingClass() == android.os.AsyncTask.class) {
                        Field declaredField = cls2.getDeclaredField("this$0");
                        declaredField.setAccessible(true);
                        cls = declaredField.get(runnable2).getClass();
                    }
                    cls = cls2;
                }
                String name22 = cls.getName();
                hashMap.put(name22, Integer.valueOf((hashMap.containsKey(name22) ? ((Integer) hashMap.get(name22)).intValue() : 0) + 1));
            }
            StringBuilder append = new StringBuilder().append("Prominent classes in AsyncTask: ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (((Integer) entry.getValue()).intValue() > 32) {
                    sb.append((String) entry.getKey()).append(' ');
                }
            }
            throw new RejectedExecutionException(append.append(sb.length() == 0 ? "NO CLASSES FOUND" : sb.toString()).toString(), e);
        }
    }
}
