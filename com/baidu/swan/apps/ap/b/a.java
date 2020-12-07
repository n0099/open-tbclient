package com.baidu.swan.apps.ap.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.u.c.a.c;
import com.baidu.swan.c.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.ap.e.b<String> dJG;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>> dJD = new HashSet();
    private int dJE = 8192;
    private long mTimeout = -1;
    private TimeUnit dJF = TimeUnit.NANOSECONDS;
    private final c.a dJH = new c.a();
    private float mProgress = 0.0f;

    public a W(Bundle bundle) {
        this.dJH.D(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void P(float f) {
        if (DEBUG) {
            log("updateProgress: progress=" + f);
        }
        this.mProgress = f;
        vf("on_progress");
    }

    private void vf(String str) {
        if (this.dJG != null) {
            this.dJG.M(str);
        }
    }

    public a D(com.baidu.swan.apps.ap.e.b<String> bVar) {
        this.dJG = bVar;
        return this;
    }

    @NonNull
    public a lM(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.dJE = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.dJF = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>... bVarArr) {
        this.dJD.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            vf("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0393a> aPO = aPO();
            CountDownLatch countDownLatch = new CountDownLatch(aPO.size());
            ExecutorService a2 = a(aPO, countDownLatch);
            a(readableByteChannel, aPO);
            vf("pump_finish");
            if (DEBUG) {
                log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                if (DEBUG) {
                    log("main await for timeout: " + this.dJF.toMillis(this.mTimeout));
                }
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.dJF)) {
                    z = true;
                }
                if (DEBUG) {
                    log("main await finish by " + (z ? "time's up" : "count down"));
                }
                if (DEBUG) {
                    log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                b(a2);
            } catch (InterruptedException e) {
                if (DEBUG) {
                    log("main await finish by InterruptedException " + e);
                    e.printStackTrace();
                }
                if (DEBUG) {
                    log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                b(a2);
            }
            vf("finish");
        }
    }

    private List<RunnableC0393a> aPO() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.ap.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: e */
            public void M(com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0393a(bVar));
                } catch (IOException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.dJD);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0393a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0393a>() { // from class: com.baidu.swan.apps.ap.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(RunnableC0393a runnableC0393a) {
                runnableC0393a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0393a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aPP() {
        float f = this.dJH.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0393a> list) {
        P(0.0f);
        float aPP = aPP();
        long j = 0;
        int i = 0;
        long j2 = this.dJH.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.dJE);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                long j3 = j + read;
                allocate.flip();
                com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0393a>() { // from class: com.baidu.swan.apps.ap.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(RunnableC0393a runnableC0393a) {
                        try {
                            if (runnableC0393a.dJP.isOpen() && runnableC0393a.dJO.isOpen()) {
                                allocate.rewind();
                                runnableC0393a.dJP.write(allocate);
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                a.log("connect e:" + e + " line: " + runnableC0393a);
                                e.printStackTrace();
                            }
                        }
                    }
                }, list);
                int i2 = i + 1;
                if (j2 > 0) {
                    float f = ((float) j3) / ((float) j2);
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    float f2 = f > 1.0f ? 1.0f : f;
                    float f3 = f2 - this.mProgress;
                    int round = Math.round(100.0f * f2);
                    StringBuilder sb = new StringBuilder();
                    int i3 = 0;
                    while (i3 < 100) {
                        sb.append(i3 > round ? "=" : "#");
                        i3++;
                    }
                    if (DEBUG) {
                        log(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f2), sb, Long.valueOf(read), Long.valueOf(j3)));
                    }
                    if (f3 > aPP) {
                        if (DEBUG) {
                            NumberFormat percentInstance = NumberFormat.getPercentInstance();
                            log("pumping: updateProgress granularity:" + percentInstance.format(aPP) + " step:" + percentInstance.format(f3));
                        }
                        P(f2);
                    }
                }
                allocate.clear();
                i = i2;
                j = j3;
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0393a>() { // from class: com.baidu.swan.apps.ap.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(RunnableC0393a runnableC0393a) {
                        a.a(runnableC0393a.dJP, runnableC0393a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        if (DEBUG) {
            log("pumping done: writeCount=" + i + " length: " + j2);
        }
        P(1.0f);
    }

    private void b(@NonNull ExecutorService executorService) {
        if (executorService != this.mExecutorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.mExecutorService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Channel channel, String str) {
        if (channel != null && channel.isOpen()) {
            d.closeSafely(channel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        if (DEBUG) {
            Log.i("PipeHub", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ap.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class RunnableC0393a implements Runnable {
        private final com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> dJM;
        private String dJQ;
        private CountDownLatch latch;
        private final Pipe dJN = Pipe.open();
        private final Pipe.SinkChannel dJP = this.dJN.sink();
        private final Pipe.SourceChannel dJO = this.dJN.source();

        RunnableC0393a(com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.dJM = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        private void aPQ() {
            if (this.latch != null) {
                this.latch.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dJQ = Thread.currentThread().toString();
            if (a.DEBUG) {
                a.log(" >> run on " + toString());
            }
            try {
                this.dJM.M(this.dJO);
            } catch (Exception e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                    a.log("catch Exception on " + toString() + " :\n  " + e.toString());
                }
            } finally {
                close();
            }
            if (a.DEBUG) {
                a.log("countdown by end -> " + toString());
            }
            aPQ();
        }

        private void close() {
            a.a(this.dJP, "sink for " + toString());
            a.a(this.dJO, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.dJQ + " consumer=" + this.dJM.toString();
        }
    }
}
