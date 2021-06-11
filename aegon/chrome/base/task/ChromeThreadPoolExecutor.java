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
/* loaded from: classes.dex */
public class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int MAXIMUM_POOL_SIZE;
    public static final BlockingQueue<Runnable> sPoolWorkQueue;
    public static final ThreadFactory sThreadFactory;

    /* renamed from: aegon.chrome.base.task.ChromeThreadPoolExecutor$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ThreadFactory {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public static /* synthetic */ void lambda$newThread$0(Runnable runnable) {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Runnable lambdaFactory$ = ChromeThreadPoolExecutor$1$$Lambda$1.lambdaFactory$(runnable);
            return new Thread(lambdaFactory$, "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    public ChromeThreadPoolExecutor() {
        super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        allowCoreThreadTimeOut(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x006b  */
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(Runnable runnable) {
        Runnable[] runnableArr;
        Object obj;
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
