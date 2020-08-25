package com.baidu.swan.apps.ap.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.u.c.a.c;
import com.baidu.swan.c.d;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.ap.e.b<String> dbJ;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>> dbG = new HashSet();
    private int dbH = 8192;
    private long mTimeout = -1;
    private TimeUnit dbI = TimeUnit.NANOSECONDS;
    private final c.a dbK = new c.a();
    private float mProgress = 0.0f;

    public a W(Bundle bundle) {
        this.dbK.D(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void K(float f) {
        if (DEBUG) {
            log("updateProgress: progress=" + f);
        }
        this.mProgress = f;
        sQ("on_progress");
    }

    private void sQ(String str) {
        if (this.dbJ != null) {
            this.dbJ.I(str);
        }
    }

    public a D(com.baidu.swan.apps.ap.e.b<String> bVar) {
        this.dbJ = bVar;
        return this;
    }

    @NonNull
    public a kp(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.dbH = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.dbI = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>... bVarArr) {
        this.dbG.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            sQ("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0345a> aFD = aFD();
            CountDownLatch countDownLatch = new CountDownLatch(aFD.size());
            ExecutorService a = a(aFD, countDownLatch);
            a(readableByteChannel, aFD);
            sQ("pump_finish");
            if (DEBUG) {
                log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                if (DEBUG) {
                    log("main await for timeout: " + this.dbI.toMillis(this.mTimeout));
                }
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.dbI)) {
                    z = true;
                }
                if (DEBUG) {
                    log("main await finish by " + (z ? "time's up" : "count down"));
                }
                if (DEBUG) {
                    log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                b(a);
            } catch (InterruptedException e) {
                if (DEBUG) {
                    log("main await finish by InterruptedException " + e);
                    e.printStackTrace();
                }
                if (DEBUG) {
                    log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                b(a);
            }
            sQ("finish");
        }
    }

    private List<RunnableC0345a> aFD() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.ap.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: e */
            public void I(com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0345a(bVar));
                } catch (IOException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.dbG);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0345a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0345a>() { // from class: com.baidu.swan.apps.ap.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(RunnableC0345a runnableC0345a) {
                runnableC0345a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0345a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aFE() {
        float f = this.dbK.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0345a> list) {
        K(0.0f);
        float aFE = aFE();
        long j = 0;
        int i = 0;
        long j2 = this.dbK.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.dbH);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                long j3 = j + read;
                allocate.flip();
                com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0345a>() { // from class: com.baidu.swan.apps.ap.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void I(RunnableC0345a runnableC0345a) {
                        try {
                            if (runnableC0345a.dbT.isOpen() && runnableC0345a.dbS.isOpen()) {
                                allocate.rewind();
                                runnableC0345a.dbT.write(allocate);
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                a.log("connect e:" + e + " line: " + runnableC0345a);
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
                        sb.append(i3 > round ? ETAG.EQUAL : "#");
                        i3++;
                    }
                    if (DEBUG) {
                        log(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f2), sb, Long.valueOf(read), Long.valueOf(j3)));
                    }
                    if (f3 > aFE) {
                        if (DEBUG) {
                            NumberFormat percentInstance = NumberFormat.getPercentInstance();
                            log("pumping: updateProgress granularity:" + percentInstance.format(aFE) + " step:" + percentInstance.format(f3));
                        }
                        K(f2);
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
                com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0345a>() { // from class: com.baidu.swan.apps.ap.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void I(RunnableC0345a runnableC0345a) {
                        a.a(runnableC0345a.dbT, runnableC0345a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        if (DEBUG) {
            log("pumping done: writeCount=" + i + " length: " + j2);
        }
        K(1.0f);
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
    /* loaded from: classes8.dex */
    public class RunnableC0345a implements Runnable {
        private final com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> dbQ;
        private String dbU;
        private CountDownLatch latch;
        private final Pipe dbR = Pipe.open();
        private final Pipe.SinkChannel dbT = this.dbR.sink();
        private final Pipe.SourceChannel dbS = this.dbR.source();

        RunnableC0345a(com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.dbQ = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        private void aFF() {
            if (this.latch != null) {
                this.latch.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dbU = Thread.currentThread().toString();
            if (a.DEBUG) {
                a.log(" >> run on " + toString());
            }
            try {
                this.dbQ.I(this.dbS);
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
            aFF();
        }

        private void close() {
            a.a(this.dbT, "sink for " + toString());
            a.a(this.dbS, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.dbU + " consumer=" + this.dbQ.toString();
        }
    }
}
