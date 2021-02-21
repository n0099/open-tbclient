package com.baidu.swan.apps.ao;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes9.dex */
public final class p {
    private static volatile b dOS;
    private static volatile b dOT;
    private static volatile b dOU;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b dOV = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ao.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: b */
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

    /* loaded from: classes9.dex */
    public interface a extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    private p() {
    }

    public static a aNP() {
        if (dOS == null) {
            synchronized (p.class) {
                if (dOS == null) {
                    dOS = new b(PublishSubject.eOk());
                    dOS.eML().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.ao.p.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: c */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bY(pair).e(Schedulers.io()).e(p.dOV).eMO();
                        }
                    }).eMN().eMC();
                }
            }
        }
        return dOS;
    }

    public static a aNQ() {
        if (dOT == null) {
            synchronized (p.class) {
                if (dOT == null) {
                    dOT = new b(PublishSubject.eOk());
                    dOT.eML().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.ao.p.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: c */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bY(pair).e(Schedulers.computation()).e(p.dOV).eMO();
                        }
                    }).eMN().eMC();
                }
            }
        }
        return dOT;
    }

    public static a aNR() {
        if (dOU == null) {
            synchronized (p.class) {
                if (dOU == null) {
                    dOU = new b(PublishSubject.eOk());
                    dOU.eML().c(Schedulers.io()).b(dOV).eMN().eMC();
                }
            }
        }
        return dOU;
    }

    public static void a(@NonNull Runnable runnable, @NonNull String str) {
        aNP().execute(runnable, str);
    }

    public static void b(@NonNull Runnable runnable, @NonNull String str) {
        aNQ().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        aNR().execute(runnable, str);
    }

    public static rx.k a(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bY(Pair.create(runnable, tQ(str))).i(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ao.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: b */
            public void call(Pair<Runnable, String> pair) {
                p.aNP().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ao.p.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task [" + str + "] fail!", th);
                }
            }
        }).eMC();
    }

    public static rx.k b(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bY(Pair.create(runnable, tQ(str))).i(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.ao.p.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: b */
            public void call(Pair<Runnable, String> pair) {
                p.aNQ().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ao.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task [" + str + "] fail!", th);
                }
            }
        }).eMC();
    }

    public static String tQ(String str) {
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
    /* loaded from: classes9.dex */
    public static class b extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements a {
        public b(rx.subjects.c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // com.baidu.swan.apps.ao.p.a
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, p.tQ(str)));
        }
    }

    public static rx.k a(Runnable runnable, long j, TimeUnit timeUnit) {
        return rx.h.bY(runnable).i(j, timeUnit).f(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.ao.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: h */
            public void call(Runnable runnable2) {
                runnable2.run();
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.ao.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf("SwanAppExecutorUtils", "delay task fail", th);
                }
            }
        }).eMC();
    }
}
