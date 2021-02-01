package com.baidu.swan.apps.ao.b;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.ao.e.b<String> dPJ;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>> dPG = new HashSet();
    private int dPH = 8192;
    private long mTimeout = -1;
    private TimeUnit dPI = TimeUnit.NANOSECONDS;
    private final c.a dPK = new c.a();
    private float mProgress = 0.0f;

    public a W(Bundle bundle) {
        this.dPK.D(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void S(float f) {
        if (DEBUG) {
            log("updateProgress: progress=" + f);
        }
        this.mProgress = f;
        um("on_progress");
    }

    private void um(String str) {
        if (this.dPJ != null) {
            this.dPJ.L(str);
        }
    }

    public a D(com.baidu.swan.apps.ao.e.b<String> bVar) {
        this.dPJ = bVar;
        return this;
    }

    @NonNull
    public a ko(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.dPH = i;
        return this;
    }

    @NonNull
    public a b(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.dPI = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>... bVarArr) {
        this.dPG.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            um("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0365a> aOG = aOG();
            CountDownLatch countDownLatch = new CountDownLatch(aOG.size());
            ExecutorService a2 = a(aOG, countDownLatch);
            a(readableByteChannel, aOG);
            um("pump_finish");
            if (DEBUG) {
                log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                if (DEBUG) {
                    log("main await for timeout: " + this.dPI.toMillis(this.mTimeout));
                }
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.dPI)) {
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
            um("finish");
        }
    }

    private List<RunnableC0365a> aOG() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.ao.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: e */
            public void L(com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0365a(bVar));
                } catch (IOException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.dPG);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0365a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0365a>() { // from class: com.baidu.swan.apps.ao.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(RunnableC0365a runnableC0365a) {
                runnableC0365a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0365a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aOH() {
        float f = this.dPK.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0365a> list) {
        S(0.0f);
        float aOH = aOH();
        int i = 0;
        long j = this.dPK.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.dPH);
        long j2 = 0;
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j2 += read;
                allocate.flip();
                com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0365a>() { // from class: com.baidu.swan.apps.ao.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(RunnableC0365a runnableC0365a) {
                        try {
                            if (runnableC0365a.dPS.isOpen() && runnableC0365a.dPR.isOpen()) {
                                allocate.rewind();
                                runnableC0365a.dPS.write(allocate);
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                a.log("connect e:" + e + " line: " + runnableC0365a);
                                e.printStackTrace();
                            }
                        }
                    }
                }, list);
                int i2 = i + 1;
                if (j > 0) {
                    float f = ((float) j2) / ((float) j);
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
                        log(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f2), sb, Long.valueOf(read), Long.valueOf(j2)));
                    }
                    if (f3 > aOH) {
                        if (DEBUG) {
                            NumberFormat percentInstance = NumberFormat.getPercentInstance();
                            log("pumping: updateProgress granularity:" + percentInstance.format(aOH) + " step:" + percentInstance.format(f3));
                        }
                        S(f2);
                    }
                }
                allocate.clear();
                i = i2;
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0365a>() { // from class: com.baidu.swan.apps.ao.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(RunnableC0365a runnableC0365a) {
                        a.a(runnableC0365a.dPS, runnableC0365a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        if (DEBUG) {
            log("pumping done: writeCount=" + i + " length: " + j);
        }
        S(1.0f);
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
    /* renamed from: com.baidu.swan.apps.ao.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC0365a implements Runnable {
        private final com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> dPP;
        private CountDownLatch dPT;
        private String dPU;
        private final Pipe dPQ = Pipe.open();
        private final Pipe.SinkChannel dPS = this.dPQ.sink();
        private final Pipe.SourceChannel dPR = this.dPQ.source();

        RunnableC0365a(com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.dPP = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.dPT = countDownLatch;
        }

        private void aOI() {
            if (this.dPT != null) {
                this.dPT.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dPU = Thread.currentThread().toString();
            if (a.DEBUG) {
                a.log(" >> run on " + toString());
            }
            try {
                this.dPP.L(this.dPR);
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
            aOI();
        }

        private void close() {
            a.a(this.dPS, "sink for " + toString());
            a.a(this.dPR, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.dPU + " consumer=" + this.dPP.toString();
        }
    }
}
