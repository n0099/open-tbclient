package com.baidu.swan.apps.aq.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.v.b.a.c;
import com.baidu.swan.e.d;
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
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.apps.aq.e.b<String> cPj;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel>> cPg = new HashSet();
    private int cPh = 8192;
    private long mTimeout = -1;
    private TimeUnit cPi = TimeUnit.NANOSECONDS;
    private final c.a cPk = new c.a();
    private float mProgress = 0.0f;

    public a X(Bundle bundle) {
        this.cPk.E(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void G(float f) {
        log("updateProgress: progress=" + f);
        this.mProgress = f;
        pZ("on_progress");
    }

    private void pZ(String str) {
        if (this.cPj != null) {
            this.cPj.H(str);
        }
    }

    public a t(com.baidu.swan.apps.aq.e.b<String> bVar) {
        this.cPj = bVar;
        return this;
    }

    @NonNull
    public a hW(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.cPh = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.cPi = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel>... bVarArr) {
        this.cPg.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            pZ("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0321a> avg = avg();
            CountDownLatch countDownLatch = new CountDownLatch(avg.size());
            ExecutorService a = a(avg, countDownLatch);
            a(readableByteChannel, avg);
            pZ("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.cPi.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.cPi)) {
                    z = true;
                }
                log("main await finish by " + (z ? "time's up" : "count down"));
                log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                a(a);
            } catch (InterruptedException e) {
                log("main await finish by InterruptedException " + e);
                log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                a(a);
            }
            pZ("finish");
        }
    }

    private List<RunnableC0321a> avg() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.aq.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: d */
            public void H(com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0321a(bVar));
                } catch (IOException e) {
                }
            }
        }, this.cPg);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0321a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<RunnableC0321a>() { // from class: com.baidu.swan.apps.aq.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(RunnableC0321a runnableC0321a) {
                runnableC0321a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0321a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float avh() {
        float f = this.cPk.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0321a> list) {
        NumberFormat percentInstance;
        G(0.0f);
        float avh = avh();
        long j = 0;
        int i = 0;
        long j2 = this.cPk.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.cPh);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                long j3 = j + read;
                allocate.flip();
                com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<RunnableC0321a>() { // from class: com.baidu.swan.apps.aq.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(RunnableC0321a runnableC0321a) {
                        try {
                            if (runnableC0321a.cPt.isOpen() && runnableC0321a.cPs.isOpen()) {
                                allocate.rewind();
                                runnableC0321a.cPt.write(allocate);
                            }
                        } catch (IOException e) {
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
                    log(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f2), sb, Long.valueOf(read), Long.valueOf(j3)));
                    if (f3 > avh) {
                        log("pumping: updateProgress granularity:" + percentInstance.format(avh) + " step:" + percentInstance.format(f3));
                        G(f2);
                    }
                }
                allocate.clear();
                i = i2;
                j = j3;
            } catch (IOException e) {
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<RunnableC0321a>() { // from class: com.baidu.swan.apps.aq.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(RunnableC0321a runnableC0321a) {
                        a.a(runnableC0321a.cPt, runnableC0321a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        log("pumping done: writeCount=" + i + " length: " + j2);
        G(1.0f);
    }

    private void a(@NonNull ExecutorService executorService) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.aq.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class RunnableC0321a implements Runnable {
        private final com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> cPq;
        private String cPu;
        private CountDownLatch latch;
        private final Pipe cPr = Pipe.open();
        private final Pipe.SinkChannel cPt = this.cPr.sink();
        private final Pipe.SourceChannel cPs = this.cPr.source();

        RunnableC0321a(com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.cPq = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        private void avi() {
            if (this.latch != null) {
                this.latch.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cPu = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.cPq.H(this.cPs);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            avi();
        }

        private void close() {
            a.a(this.cPt, "sink for " + toString());
            a.a(this.cPs, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.cPu + " consumer=" + this.cPq.toString();
        }
    }
}
