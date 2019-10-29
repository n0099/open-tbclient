package com.baidu.swan.apps.an;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public final class j {
    private static volatile b btq;
    private static volatile b btr;
    private static volatile b bts;
    private static final String TAG = j.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final rx.functions.b btt = new rx.functions.b<Pair<Runnable, String>>() { // from class: com.baidu.swan.apps.an.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            long j;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(name + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((String) pair.second));
            try {
                if (!j.DEBUG) {
                    j = 0;
                } else {
                    j = System.currentTimeMillis();
                }
                ((Runnable) pair.first).run();
                if (j.DEBUG) {
                    Log.d(j.TAG, "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - j) + "ms");
                }
            } finally {
                if (z) {
                }
                Thread.currentThread().setName(name);
            }
            Thread.currentThread().setName(name);
        }
    };

    /* loaded from: classes2.dex */
    public interface a extends Executor {
        void d(@NonNull Runnable runnable, @NonNull String str);
    }

    private j() {
    }

    public static a Ui() {
        if (btq == null) {
            synchronized (j.class) {
                if (btq == null) {
                    btq = new b(PublishSubject.cPU());
                    btq.cOk().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.an.j.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bi(pair).c(Schedulers.io()).e(j.btt).cOn();
                        }
                    }).cOm().cOa();
                }
            }
        }
        return btq;
    }

    public static a Uj() {
        if (btr == null) {
            synchronized (j.class) {
                if (btr == null) {
                    btr = new b(PublishSubject.cPU());
                    btr.cOk().c(new rx.functions.f<Pair<Runnable, String>, rx.d<?>>() { // from class: com.baidu.swan.apps.an.j.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.f
                        /* renamed from: b */
                        public rx.d<?> call(Pair<Runnable, String> pair) {
                            return rx.h.bi(pair).c(Schedulers.computation()).e(j.btt).cOn();
                        }
                    }).cOm().cOa();
                }
            }
        }
        return btr;
    }

    public static a Uk() {
        if (bts == null) {
            synchronized (j.class) {
                if (bts == null) {
                    bts = new b(PublishSubject.cPU());
                    bts.cOk().a(Schedulers.io()).b(btt).cOm().cOa();
                }
            }
        }
        return bts;
    }

    public static void a(@NonNull Runnable runnable, @NonNull String str) {
        Ui().d(runnable, str);
    }

    public static void b(@NonNull Runnable runnable, @NonNull String str) {
        Uj().d(runnable, str);
    }

    public static void c(@NonNull Runnable runnable, @NonNull String str) {
        Uk().d(runnable, str);
    }

    public static String iP(String str) {
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
    /* loaded from: classes2.dex */
    public static class b extends rx.subjects.b<Pair<Runnable, String>, Pair<Runnable, String>> implements a {
        public b(rx.subjects.c cVar) {
            super(cVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            d(runnable, "");
        }

        @Override // com.baidu.swan.apps.an.j.a
        public void d(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, j.iP(str)));
        }
    }

    public static rx.k a(Runnable runnable, long j, TimeUnit timeUnit) {
        return rx.h.bi(runnable).b(j, timeUnit).d(Schedulers.immediate()).e(new rx.functions.b<Runnable>() { // from class: com.baidu.swan.apps.an.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: f */
            public void call(Runnable runnable2) {
                runnable2.run();
            }
        }).d(new rx.functions.b<Throwable>() { // from class: com.baidu.swan.apps.an.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                if (j.DEBUG) {
                    Log.wtf(j.TAG, "delay task fail", th);
                }
            }
        }).cOa();
    }
}
