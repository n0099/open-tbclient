package com.baidu.searchbox.ng.ai.apps.util;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.functions.b;
import rx.functions.f;
import rx.h;
import rx.k;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.c;
/* loaded from: classes2.dex */
public final class AiAppExecutorUtils {
    private static RxExecutor COMPUTATION_EXECUTOR;
    private static final boolean DEBUG = false;
    private static RxExecutor IO_EXECUTOR;
    private static RxExecutor SERIAL_EXECUTOR;
    private static final String TAG = AiAppExecutorUtils.class.getSimpleName();
    private static final b EXECUTE_ACTION = new b<Pair<Runnable, String>>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        public void call(Pair<Runnable, String> pair) {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(name + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((String) pair.second));
            try {
                ((Runnable) pair.first).run();
            } catch (Throwable th) {
            }
            Thread.currentThread().setName(name);
        }
    };

    /* loaded from: classes2.dex */
    public interface IUtilExecutor extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    private AiAppExecutorUtils() {
    }

    public static IUtilExecutor getIoExecutor() {
        if (IO_EXECUTOR == null) {
            synchronized (AiAppExecutorUtils.class) {
                if (IO_EXECUTOR == null) {
                    IO_EXECUTOR = new RxExecutor(PublishSubject.cfj());
                    IO_EXECUTOR.onBackpressureBuffer().flatMap(new f<Pair<Runnable, String>, d<?>>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        public d<?> call(Pair<Runnable, String> pair) {
                            return h.aW(pair).a(Schedulers.io()).b(AiAppExecutorUtils.EXECUTE_ACTION).ccT();
                        }
                    }).retry().subscribe();
                }
            }
        }
        return IO_EXECUTOR;
    }

    public static IUtilExecutor getComputationExecutor() {
        if (COMPUTATION_EXECUTOR == null) {
            synchronized (AiAppExecutorUtils.class) {
                if (COMPUTATION_EXECUTOR == null) {
                    COMPUTATION_EXECUTOR = new RxExecutor(PublishSubject.cfj());
                    COMPUTATION_EXECUTOR.onBackpressureBuffer().flatMap(new f<Pair<Runnable, String>, d<?>>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        public d<?> call(Pair<Runnable, String> pair) {
                            return h.aW(pair).a(Schedulers.computation()).b(AiAppExecutorUtils.EXECUTE_ACTION).ccT();
                        }
                    }).retry().subscribe();
                }
            }
        }
        return COMPUTATION_EXECUTOR;
    }

    public static IUtilExecutor getSerialExecutor() {
        if (SERIAL_EXECUTOR == null) {
            synchronized (AiAppExecutorUtils.class) {
                if (SERIAL_EXECUTOR == null) {
                    SERIAL_EXECUTOR = new RxExecutor(PublishSubject.cfj());
                    SERIAL_EXECUTOR.onBackpressureBuffer().observeOn(Schedulers.io()).doOnNext(EXECUTE_ACTION).retry().subscribe();
                }
            }
        }
        return SERIAL_EXECUTOR;
    }

    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        getIoExecutor().execute(runnable, str);
    }

    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        getComputationExecutor().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        getSerialExecutor().execute(runnable, str);
    }

    public static k delayPostOnIO(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return h.aW(Pair.create(runnable, getStandardThreadName(str))).a(j, timeUnit).b(new b<Pair<Runnable, String>>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Pair<Runnable, String> pair) {
                AiAppExecutorUtils.getIoExecutor().execute((Runnable) pair.first, (String) pair.second);
            }
        }).a(new b<Throwable>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
            }
        }).subscribe();
    }

    public static k delayPostOnComputation(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return h.aW(Pair.create(runnable, getStandardThreadName(str))).a(j, timeUnit).b(new b<Pair<Runnable, String>>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Pair<Runnable, String> pair) {
                AiAppExecutorUtils.getComputationExecutor().execute((Runnable) pair.first, (String) pair.second);
            }
        }).a(new b<Throwable>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
            }
        }).subscribe();
    }

    public static k delayPostOnSerial(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return h.aW(Pair.create(runnable, getStandardThreadName(str))).a(j, timeUnit).b(new b<Pair<Runnable, String>>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Pair<Runnable, String> pair) {
                AiAppExecutorUtils.getSerialExecutor().execute((Runnable) pair.first, (String) pair.second);
            }
        }).a(new b<Throwable>() { // from class: com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
            }
        }).subscribe();
    }

    public static String getStandardThreadName(String str) {
        String str2 = null;
        if (str != null) {
            String str3 = TAG + BaseRequestAction.SPLITE;
            str2 = !str.startsWith(str3) ? str3 + str : str;
        }
        if (str2 == null) {
            str2 = TAG;
        }
        if (str2.length() > 256) {
            return str2.substring(0, 255);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class RxExecutor extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements IUtilExecutor {
        public RxExecutor(c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils.IUtilExecutor
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, AiAppExecutorUtils.getStandardThreadName(str)));
        }
    }
}
