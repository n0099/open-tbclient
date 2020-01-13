package com.baidu.swan.apps.as;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes10.dex */
public final class m {
    private static volatile b bUj;
    private static volatile b bUk;
    private static volatile b bUl;
    private static final String TAG = m.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b bUm = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.as.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            long j;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(name + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((String) pair.second));
            try {
                if (!m.DEBUG) {
                    j = 0;
                } else {
                    j = System.currentTimeMillis();
                }
                ((Runnable) pair.first).run();
                if (m.DEBUG) {
                    Log.d(m.TAG, "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - j) + "ms");
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

    private m() {
    }

    public static a aev() {
        if (bUj == null) {
            synchronized (m.class) {
                if (bUj == null) {
                    bUj = new b(PublishSubject.dOa());
                    bUj.dMD().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.as.m.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.cb(pair).e(Schedulers.io()).e(m.bUm).dMG();
                        }
                    }).dMF().dMv();
                }
            }
        }
        return bUj;
    }

    public static a aew() {
        if (bUk == null) {
            synchronized (m.class) {
                if (bUk == null) {
                    bUk = new b(PublishSubject.dOa());
                    bUk.dMD().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.as.m.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.cb(pair).e(Schedulers.computation()).e(m.bUm).dMG();
                        }
                    }).dMF().dMv();
                }
            }
        }
        return bUk;
    }

    public static a aex() {
        if (bUl == null) {
            synchronized (m.class) {
                if (bUl == null) {
                    bUl = new b(PublishSubject.dOa());
                    bUl.dMD().c(Schedulers.io()).b(bUm).dMF().dMv();
                }
            }
        }
        return bUl;
    }

    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        aev().execute(runnable, str);
    }

    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        aew().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        aex().execute(runnable, str);
    }

    public static rx.k a(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.cb(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.as.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                m.aev().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.as.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (m.DEBUG) {
                    Log.wtf(m.TAG, "delay task [" + str + "] fail!", th);
                }
            }
        }).dMv();
    }

    public static rx.k b(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.cb(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.as.m.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                m.aew().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.as.m.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (m.DEBUG) {
                    Log.wtf(m.TAG, "delay task [" + str + "] fail!", th);
                }
            }
        }).dMv();
    }

    public static String getStandardThreadName(String str) {
        String str2 = null;
        if (str != null) {
            String str3 = TAG + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
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
    /* loaded from: classes10.dex */
    public static class b extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements a {
        public b(rx.subjects.c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // com.baidu.swan.apps.as.m.a
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, m.getStandardThreadName(str)));
        }
    }

    public static rx.k a(Runnable runnable, long j, TimeUnit timeUnit) {
        return rx.h.cb(runnable).d(j, timeUnit).f(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.as.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: i */
            public void call(Runnable runnable2) {
                runnable2.run();
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.as.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (m.DEBUG) {
                    Log.wtf(m.TAG, "delay task fail", th);
                }
            }
        }).dMv();
    }
}
