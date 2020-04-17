package com.baidu.swan.apps.as.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.x.b.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
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
    private com.baidu.swan.apps.as.d.b<String> cxQ;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>> cxN = new HashSet();
    private int cxO = 8192;
    private long mTimeout = -1;
    private TimeUnit cxP = TimeUnit.NANOSECONDS;
    private final c.a cxR = new c.a();
    private float mProgress = 0.0f;

    public a Q(Bundle bundle) {
        this.cxR.B(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void F(float f) {
        log("updateProgress: progress=" + f);
        this.mProgress = f;
        oj("on_progress");
    }

    private void oj(String str) {
        if (this.cxQ != null) {
            this.cxQ.E(str);
        }
    }

    public a k(com.baidu.swan.apps.as.d.b<String> bVar) {
        this.cxQ = bVar;
        return this;
    }

    @NonNull
    public a hn(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.cxO = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.cxP = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>... bVarArr) {
        this.cxN.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            oj("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0257a> apw = apw();
            CountDownLatch countDownLatch = new CountDownLatch(apw.size());
            ExecutorService a = a(apw, countDownLatch);
            a(readableByteChannel, apw);
            oj("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.cxP.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.cxP)) {
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
            oj("finish");
        }
    }

    private List<RunnableC0257a> apw() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.as.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: l */
            public void E(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0257a(bVar));
                } catch (IOException e) {
                }
            }
        }, this.cxN);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0257a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0257a>() { // from class: com.baidu.swan.apps.as.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(RunnableC0257a runnableC0257a) {
                runnableC0257a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0257a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float apx() {
        float f = this.cxR.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0257a> list) {
        F(0.0f);
        float apx = apx();
        long j = 0;
        int i = 0;
        long j2 = this.cxR.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.cxO);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j += read;
                allocate.flip();
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0257a>() { // from class: com.baidu.swan.apps.as.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void E(RunnableC0257a runnableC0257a) {
                        try {
                            if (runnableC0257a.cya.isOpen() && runnableC0257a.cxZ.isOpen()) {
                                allocate.rewind();
                                runnableC0257a.cya.write(allocate);
                            }
                        } catch (IOException e) {
                        }
                    }
                }, list);
                int i2 = i + 1;
                if (j2 > 0) {
                    float f = ((float) j) / ((float) j2);
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    float f2 = f - this.mProgress;
                    log("pumping: progress=" + f + " read=" + read + " at=" + j);
                    if (f2 > apx) {
                        log("pumping: updateProgress granularity=" + apx + " step=" + f2);
                        F(f);
                    }
                }
                allocate.clear();
                i = i2;
            } catch (IOException e) {
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0257a>() { // from class: com.baidu.swan.apps.as.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void E(RunnableC0257a runnableC0257a) {
                        a.a(runnableC0257a.cya, runnableC0257a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        log("pumping done: writeCount=" + i + " length: " + j2);
        F(1.0f);
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
            com.baidu.swan.d.c.closeSafely(channel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.as.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class RunnableC0257a implements Runnable {
        private final com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> cxX;
        private String cyb;
        private CountDownLatch latch;
        private final Pipe cxY = Pipe.open();
        private final Pipe.SinkChannel cya = this.cxY.sink();
        private final Pipe.SourceChannel cxZ = this.cxY.source();

        RunnableC0257a(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) throws IOException {
            this.cxX = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        private void apy() {
            if (this.latch != null) {
                this.latch.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cyb = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.cxX.E(this.cxZ);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            apy();
        }

        private void close() {
            a.a(this.cya, "sink for " + toString());
            a.a(this.cxZ, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.cyb + " consumer=" + this.cxX.toString();
        }
    }
}
