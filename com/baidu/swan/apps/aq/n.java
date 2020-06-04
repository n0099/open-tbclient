package com.baidu.swan.apps.aq;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes11.dex */
public final class n {
    private static volatile b cJR;
    private static volatile b cJS;
    private static volatile b cJT;
    private static final String TAG = n.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b cJU = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.aq.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            long j;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(name + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((String) pair.second));
            try {
                if (!n.DEBUG) {
                    j = 0;
                } else {
                    j = System.currentTimeMillis();
                }
                ((Runnable) pair.first).run();
                if (n.DEBUG) {
                    Log.d(n.TAG, "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - j) + "ms");
                }
            } finally {
                if (z) {
                }
                Thread.currentThread().setName(name);
            }
            Thread.currentThread().setName(name);
        }
    };

    /* loaded from: classes11.dex */
    public interface a extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    private n() {
    }

    public static a atu() {
        if (cJR == null) {
            synchronized (n.class) {
                if (cJR == null) {
                    cJR = new b(PublishSubject.dQX());
                    cJR.dPA().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.aq.n.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bS(pair).e(Schedulers.io()).e(n.cJU).dPD();
                        }
                    }).dPC().dPr();
                }
            }
        }
        return cJR;
    }

    public static a atv() {
        if (cJS == null) {
            synchronized (n.class) {
                if (cJS == null) {
                    cJS = new b(PublishSubject.dQX());
                    cJS.dPA().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.aq.n.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bS(pair).e(Schedulers.computation()).e(n.cJU).dPD();
                        }
                    }).dPC().dPr();
                }
            }
        }
        return cJS;
    }

    public static a atw() {
        if (cJT == null) {
            synchronized (n.class) {
                if (cJT == null) {
                    cJT = new b(PublishSubject.dQX());
                    cJT.dPA().c(Schedulers.io()).b(cJU).dPC().dPr();
                }
            }
        }
        return cJT;
    }

    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        atu().execute(runnable, str);
    }

    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        atv().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        atw().execute(runnable, str);
    }

    public static rx.k a(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bS(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.aq.n.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                n.atu().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.aq.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (n.DEBUG) {
                    Log.wtf(n.TAG, "delay task [" + str + "] fail!", th);
                }
            }
        }).dPr();
    }

    public static rx.k b(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bS(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.aq.n.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                n.atv().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.aq.n.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (n.DEBUG) {
                    Log.wtf(n.TAG, "delay task [" + str + "] fail!", th);
                }
            }
        }).dPr();
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
    /* loaded from: classes11.dex */
    public static class b extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements a {
        public b(rx.subjects.c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // com.baidu.swan.apps.aq.n.a
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, n.getStandardThreadName(str)));
        }
    }

    public static rx.k a(Runnable runnable, long j, TimeUnit timeUnit) {
        return rx.h.bS(runnable).d(j, timeUnit).f(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.aq.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: m */
            public void call(Runnable runnable2) {
                runnable2.run();
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.aq.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (n.DEBUG) {
                    Log.wtf(n.TAG, "delay task fail", th);
                }
            }
        }).dPr();
    }
}
