package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes8.dex */
public final class p {
    private static volatile b daY;
    private static volatile b daZ;
    private static volatile b dba;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b dbb = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ap.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            long j;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(name + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((String) pair.second));
            try {
                if (!p.DEBUG) {
                    j = 0;
                } else {
                    j = System.currentTimeMillis();
                }
                ((Runnable) pair.first).run();
                if (p.DEBUG) {
                    Log.d("SwanAppExecutorUtils", "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - j) + "ms");
                }
            } finally {
                if (z) {
                }
                Thread.currentThread().setName(name);
            }
            Thread.currentThread().setName(name);
        }
    };

    /* loaded from: classes8.dex */
    public interface a extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    private p() {
    }

    public static a aEM() {
        if (daY == null) {
            synchronized (p.class) {
                if (daY == null) {
                    daY = new b(PublishSubject.eli());
                    daY.ejL().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.ap.p.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bX(pair).e(Schedulers.io()).e(p.dbb).ejO();
                        }
                    }).ejN().ejC();
                }
            }
        }
        return daY;
    }

    public static a aEN() {
        if (daZ == null) {
            synchronized (p.class) {
                if (daZ == null) {
                    daZ = new b(PublishSubject.eli());
                    daZ.ejL().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.ap.p.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bX(pair).e(Schedulers.computation()).e(p.dbb).ejO();
                        }
                    }).ejN().ejC();
                }
            }
        }
        return daZ;
    }

    public static a aEO() {
        if (dba == null) {
            synchronized (p.class) {
                if (dba == null) {
                    dba = new b(PublishSubject.eli());
                    dba.ejL().c(Schedulers.io()).b(dbb).ejN().ejC();
                }
            }
        }
        return dba;
    }

    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        aEM().execute(runnable, str);
    }

    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        aEN().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        aEO().execute(runnable, str);
    }

    public static rx.k a(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bX(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ap.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                p.aEM().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ap.p.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task [" + str + "] fail!", th);
                }
            }
        }).ejC();
    }

    public static rx.k b(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bX(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ap.p.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                p.aEN().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ap.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task [" + str + "] fail!", th);
                }
            }
        }).ejC();
    }

    public static String getStandardThreadName(String str) {
        String str2 = null;
        if (str != null) {
            str2 = !str.startsWith("SwanAppExecutorUtils_") ? "SwanAppExecutorUtils_" + str : str;
        }
        if (str2 == null) {
            str2 = "SwanAppExecutorUtils";
        }
        if (str2.length() > 256) {
            return str2.substring(0, 255);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements a {
        public b(rx.subjects.c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // com.baidu.swan.apps.ap.p.a
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, p.getStandardThreadName(str)));
        }
    }

    public static rx.k a(Runnable runnable, long j, TimeUnit timeUnit) {
        return rx.h.bX(runnable).d(j, timeUnit).f(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.ap.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: j */
            public void call(Runnable runnable2) {
                runnable2.run();
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ap.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task fail", th);
                }
            }
        }).ejC();
    }
}
