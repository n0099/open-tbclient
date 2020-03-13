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
    private com.baidu.swan.apps.as.d.b<String> bYL;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>> bYI = new HashSet();
    private int bYJ = 8192;
    private long mTimeout = -1;
    private TimeUnit bYK = TimeUnit.NANOSECONDS;
    private final c.a bYM = new c.a();
    private float mProgress = 0.0f;

    public a Q(Bundle bundle) {
        this.bYM.B(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void V(float f) {
        log("updateProgress: progress=" + f);
        this.mProgress = f;
        mW("on_progress");
    }

    private void mW(String str) {
        if (this.bYL != null) {
            this.bYL.D(str);
        }
    }

    public a k(com.baidu.swan.apps.as.d.b<String> bVar) {
        this.bYL = bVar;
        return this;
    }

    @NonNull
    public a hg(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.bYJ = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.bYK = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>... bVarArr) {
        this.bYI.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            mW("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0227a> ahl = ahl();
            CountDownLatch countDownLatch = new CountDownLatch(ahl.size());
            ExecutorService a = a(ahl, countDownLatch);
            a(readableByteChannel, ahl);
            mW("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.bYK.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.bYK)) {
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
            mW("finish");
        }
    }

    private List<RunnableC0227a> ahl() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.as.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: l */
            public void D(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0227a(bVar));
                } catch (IOException e) {
                }
            }
        }, this.bYI);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0227a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0227a>() { // from class: com.baidu.swan.apps.as.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(RunnableC0227a runnableC0227a) {
                runnableC0227a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0227a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float ahm() {
        float f = this.bYM.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0227a> list) {
        V(0.0f);
        float ahm = ahm();
        long j = 0;
        int i = 0;
        long j2 = this.bYM.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.bYJ);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j += read;
                allocate.flip();
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0227a>() { // from class: com.baidu.swan.apps.as.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void D(RunnableC0227a runnableC0227a) {
                        try {
                            if (runnableC0227a.bYV.isOpen() && runnableC0227a.bYU.isOpen()) {
                                allocate.rewind();
                                runnableC0227a.bYV.write(allocate);
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
                    if (f2 > ahm) {
                        log("pumping: updateProgress granularity=" + ahm + " step=" + f2);
                        V(f);
                    }
                }
                allocate.clear();
                i = i2;
            } catch (IOException e) {
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0227a>() { // from class: com.baidu.swan.apps.as.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void D(RunnableC0227a runnableC0227a) {
                        a.a(runnableC0227a.bYV, runnableC0227a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        log("pumping done: writeCount=" + i + " length: " + j2);
        V(1.0f);
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
    public class RunnableC0227a implements Runnable {
        private final com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bYS;
        private CountDownLatch bYW;
        private String bYX;
        private final Pipe bYT = Pipe.open();
        private final Pipe.SinkChannel bYV = this.bYT.sink();
        private final Pipe.SourceChannel bYU = this.bYT.source();

        RunnableC0227a(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) throws IOException {
            this.bYS = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.bYW = countDownLatch;
        }

        private void ahn() {
            if (this.bYW != null) {
                this.bYW.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bYX = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.bYS.D(this.bYU);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            ahn();
        }

        private void close() {
            a.a(this.bYV, "sink for " + toString());
            a.a(this.bYU, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.bYX + " consumer=" + this.bYS.toString();
        }
    }
}
