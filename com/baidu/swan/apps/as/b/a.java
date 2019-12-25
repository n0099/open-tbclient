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
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.apps.as.d.b<String> bUt;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>> bUq = new HashSet();
    private int bUr = 8192;
    private long mTimeout = -1;
    private TimeUnit bUs = TimeUnit.NANOSECONDS;
    private final c.a bUu = new c.a();
    private float mProgress = 0.0f;

    public a Q(Bundle bundle) {
        this.bUu.B(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void W(float f) {
        log("updateProgress: progress=" + f);
        this.mProgress = f;
        mE("on_progress");
    }

    private void mE(String str) {
        if (this.bUt != null) {
            this.bUt.B(str);
        }
    }

    public a k(com.baidu.swan.apps.as.d.b<String> bVar) {
        this.bUt = bVar;
        return this;
    }

    @NonNull
    public a gP(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.bUr = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.bUs = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>... bVarArr) {
        this.bUq.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            mE("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0215a> aeC = aeC();
            CountDownLatch countDownLatch = new CountDownLatch(aeC.size());
            ExecutorService a = a(aeC, countDownLatch);
            a(readableByteChannel, aeC);
            mE("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.bUs.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.bUs)) {
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
            mE("finish");
        }
    }

    private List<RunnableC0215a> aeC() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.as.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: l */
            public void B(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0215a(bVar));
                } catch (IOException e) {
                }
            }
        }, this.bUq);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0215a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0215a>() { // from class: com.baidu.swan.apps.as.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(RunnableC0215a runnableC0215a) {
                runnableC0215a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0215a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aeD() {
        float f = this.bUu.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0215a> list) {
        W(0.0f);
        float aeD = aeD();
        long j = 0;
        int i = 0;
        long j2 = this.bUu.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.bUr);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j += read;
                allocate.flip();
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0215a>() { // from class: com.baidu.swan.apps.as.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(RunnableC0215a runnableC0215a) {
                        try {
                            if (runnableC0215a.bUD.isOpen() && runnableC0215a.bUC.isOpen()) {
                                allocate.rewind();
                                runnableC0215a.bUD.write(allocate);
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
                    if (f2 > aeD) {
                        log("pumping: updateProgress granularity=" + aeD + " step=" + f2);
                        W(f);
                    }
                }
                allocate.clear();
                i = i2;
            } catch (IOException e) {
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0215a>() { // from class: com.baidu.swan.apps.as.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(RunnableC0215a runnableC0215a) {
                        a.a(runnableC0215a.bUD, runnableC0215a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        log("pumping done: writeCount=" + i + " length: " + j2);
        W(1.0f);
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
    /* loaded from: classes9.dex */
    public class RunnableC0215a implements Runnable {
        private final com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bUA;
        private CountDownLatch bUE;
        private String bUF;
        private final Pipe bUB = Pipe.open();
        private final Pipe.SinkChannel bUD = this.bUB.sink();
        private final Pipe.SourceChannel bUC = this.bUB.source();

        RunnableC0215a(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) throws IOException {
            this.bUA = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.bUE = countDownLatch;
        }

        private void aeE() {
            if (this.bUE != null) {
                this.bUE.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bUF = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.bUA.B(this.bUC);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            aeE();
        }

        private void close() {
            a.a(this.bUD, "sink for " + toString());
            a.a(this.bUC, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.bUF + " consumer=" + this.bUA.toString();
        }
    }
}
