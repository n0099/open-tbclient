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
/* loaded from: classes7.dex */
public final class p {
    private static volatile b cRY;
    private static volatile b cRZ;
    private static volatile b cSa;
    private static final String TAG = p.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b cSb = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.aq.p.1
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
                    Log.d(p.TAG, "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - j) + "ms");
                }
            } finally {
                if (z) {
                }
                Thread.currentThread().setName(name);
            }
            Thread.currentThread().setName(name);
        }
    };

    /* loaded from: classes7.dex */
    public interface a extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    private p() {
    }

    public static a awC() {
        if (cRY == null) {
            synchronized (p.class) {
                if (cRY == null) {
                    cRY = new b(PublishSubject.dZd());
                    cRY.dXG().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.aq.p.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bT(pair).e(Schedulers.io()).e(p.cSb).dXJ();
                        }
                    }).dXI().dXx();
                }
            }
        }
        return cRY;
    }

    public static a awD() {
        if (cRZ == null) {
            synchronized (p.class) {
                if (cRZ == null) {
                    cRZ = new b(PublishSubject.dZd());
                    cRZ.dXG().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.aq.p.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bT(pair).e(Schedulers.computation()).e(p.cSb).dXJ();
                        }
                    }).dXI().dXx();
                }
            }
        }
        return cRZ;
    }

    public static a awE() {
        if (cSa == null) {
            synchronized (p.class) {
                if (cSa == null) {
                    cSa = new b(PublishSubject.dZd());
                    cSa.dXG().c(Schedulers.io()).b(cSb).dXI().dXx();
                }
            }
        }
        return cSa;
    }

    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        awC().execute(runnable, str);
    }

    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        awD().execute(runnable, str);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        awE().execute(runnable, str);
    }

    public static rx.k a(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bT(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.aq.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                p.awC().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.aq.p.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf(p.TAG, "delay task [" + str + "] fail!", th);
                }
            }
        }).dXx();
    }

    public static rx.k b(@NonNull Runnable runnable, @NonNull final String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return rx.h.bT(Pair.create(runnable, getStandardThreadName(str))).d(j, timeUnit).e(new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.aq.p.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(Pair<Runnable, String> pair) {
                p.awD().execute((Runnable) pair.first, (String) pair.second);
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.aq.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf(p.TAG, "delay task [" + str + "] fail!", th);
                }
            }
        }).dXx();
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
    /* loaded from: classes7.dex */
    public static class b extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements a {
        public b(rx.subjects.c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // com.baidu.swan.apps.aq.p.a
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, p.getStandardThreadName(str)));
        }
    }

    public static rx.k a(Runnable runnable, long j, TimeUnit timeUnit) {
        return rx.h.bT(runnable).d(j, timeUnit).f(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.aq.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: m */
            public void call(Runnable runnable2) {
                runnable2.run();
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.aq.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (p.DEBUG) {
                    Log.wtf(p.TAG, "delay task fail", th);
                }
            }
        }).dXx();
    }
}
