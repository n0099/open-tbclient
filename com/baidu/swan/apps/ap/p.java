package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes10.dex */
public final class p {
    private static volatile b dDE;
    private static volatile b dDF;
    private static volatile b dDG;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b dDH = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ap.p.1
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

    /* loaded from: classes10.dex */
    public interface a extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    private p() {
    }

    public static a aMz() {
        if (dDE == null) {
            synchronized (p.class) {
                if (dDE == null) {
                    dDE = new b(PublishSubject.eGN());
                    dDE.eFq().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.ap.p.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.ce(pair).e(Schedulers.io()).e(p.dDH).eFt();
                        }
                    }).eFs().eFh();
                }
            }
        }
        return dDE;
    }

    public static a aMA() {
        if (dDF == null) {
            synchronized (p.class) {
                if (dDF == null) {
                    dDF = new b(PublishSubject.eGN());
                    dDF.eFq().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.ap.p.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.ce(pair).e(Schedulers.computation()).e(p.dDH).eFt();
                        }
                    }).eFs().eFh();
                }
            }
        }
        return dDF;
    }

    public static a aMB() {
        if (dDG == null) {
            synchronized (p.class) {
                if (dDG == null) {
                    dDG = new b(PublishSubject.eGN());
                    dDG.eFq().c(Schedulers.io()).b(dDH).eFs().eFh();
                }
            }
        }
        return dDG;
    }

    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        aMz().execute(runnable, str);
    }

    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        aMA().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        aMB().execute(runnable, str);
    }

    public static rx.k a(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.ce(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ap.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                p.aMz().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ap.p.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task [" + str + "] fail!", th);
                }
            }
        }).eFh();
    }

    public static rx.k b(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.ce(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ap.p.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                p.aMA().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ap.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task [" + str + "] fail!", th);
                }
            }
        }).eFh();
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
    /* loaded from: classes10.dex */
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
        return rx.h.ce(runnable).d(j, timeUnit).f(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.ap.p.3
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
        }).eFh();
    }
}
