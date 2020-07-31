package com.baidu.swan.apps.aq.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.u.c.a.c;
import com.baidu.swan.d.d;
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
/* loaded from: classes7.dex */
public class a {
    private com.baidu.swan.apps.aq.e.b<String> cSK;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel>> cSH = new HashSet();
    private int cSI = 8192;
    private long mTimeout = -1;
    private TimeUnit cSJ = TimeUnit.NANOSECONDS;
    private final c.a cSL = new c.a();
    private float mProgress = 0.0f;

    public a Y(Bundle bundle) {
        this.cSL.F(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void G(float f) {
        log("updateProgress: progress=" + f);
        this.mProgress = f;
        qO("on_progress");
    }

    private void qO(String str) {
        if (this.cSK != null) {
            this.cSK.H(str);
        }
    }

    public a w(com.baidu.swan.apps.aq.e.b<String> bVar) {
        this.cSK = bVar;
        return this;
    }

    @NonNull
    public a ih(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.cSI = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.cSJ = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel>... bVarArr) {
        this.cSH.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            qO("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0322a> axu = axu();
            CountDownLatch countDownLatch = new CountDownLatch(axu.size());
            ExecutorService a = a(axu, countDownLatch);
            a(readableByteChannel, axu);
            qO("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.cSJ.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.cSJ)) {
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
            qO("finish");
        }
    }

    private List<RunnableC0322a> axu() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.aq.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: e */
            public void H(com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0322a(bVar));
                } catch (IOException e) {
                }
            }
        }, this.cSH);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0322a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<RunnableC0322a>() { // from class: com.baidu.swan.apps.aq.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(RunnableC0322a runnableC0322a) {
                runnableC0322a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0322a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float axv() {
        float f = this.cSL.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0322a> list) {
        NumberFormat percentInstance;
        G(0.0f);
        float axv = axv();
        long j = 0;
        int i = 0;
        long j2 = this.cSL.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.cSI);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                long j3 = j + read;
                allocate.flip();
                com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<RunnableC0322a>() { // from class: com.baidu.swan.apps.aq.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(RunnableC0322a runnableC0322a) {
                        try {
                            if (runnableC0322a.cSU.isOpen() && runnableC0322a.cST.isOpen()) {
                                allocate.rewind();
                                runnableC0322a.cSU.write(allocate);
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
                    if (com.baidu.swan.apps.performance.b.b.aoo()) {
                        if (f3 > axv) {
                            G(f2);
                        }
                    } else {
                        log(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f2), sb, Long.valueOf(read), Long.valueOf(j3)));
                        if (f3 > axv) {
                            log("pumping: updateProgress granularity:" + percentInstance.format(axv) + " step:" + percentInstance.format(f3));
                            G(f2);
                        }
                    }
                }
                allocate.clear();
                i = i2;
                j = j3;
            } catch (IOException e) {
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<RunnableC0322a>() { // from class: com.baidu.swan.apps.aq.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(RunnableC0322a runnableC0322a) {
                        a.a(runnableC0322a.cSU, runnableC0322a.toString() + " by[PumpingFinish]");
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
    /* loaded from: classes7.dex */
    public class RunnableC0322a implements Runnable {
        private final com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> cSR;
        private String cSV;
        private CountDownLatch latch;
        private final Pipe cSS = Pipe.open();
        private final Pipe.SinkChannel cSU = this.cSS.sink();
        private final Pipe.SourceChannel cST = this.cSS.source();

        RunnableC0322a(com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.cSR = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        private void axw() {
            if (this.latch != null) {
                this.latch.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cSV = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.cSR.H(this.cST);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            axw();
        }

        private void close() {
            a.a(this.cSU, "sink for " + toString());
            a.a(this.cST, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.cSV + " consumer=" + this.cSR.toString();
        }
    }
}
