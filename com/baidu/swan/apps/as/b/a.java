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
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.apps.as.d.b<String> bUF;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>> bUC = new HashSet();
    private int bUD = 8192;
    private long mTimeout = -1;
    private TimeUnit bUE = TimeUnit.NANOSECONDS;
    private final c.a bUG = new c.a();
    private float mProgress = 0.0f;

    public a Q(Bundle bundle) {
        this.bUG.B(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void V(float f) {
        log("updateProgress: progress=" + f);
        this.mProgress = f;
        mH("on_progress");
    }

    private void mH(String str) {
        if (this.bUF != null) {
            this.bUF.B(str);
        }
    }

    public a k(com.baidu.swan.apps.as.d.b<String> bVar) {
        this.bUF = bVar;
        return this;
    }

    @NonNull
    public a gP(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.bUD = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.bUE = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>... bVarArr) {
        this.bUC.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            mH("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0217a> aeV = aeV();
            CountDownLatch countDownLatch = new CountDownLatch(aeV.size());
            ExecutorService a = a(aeV, countDownLatch);
            a(readableByteChannel, aeV);
            mH("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.bUE.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.bUE)) {
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
            mH("finish");
        }
    }

    private List<RunnableC0217a> aeV() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.as.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: l */
            public void B(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0217a(bVar));
                } catch (IOException e) {
                }
            }
        }, this.bUC);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0217a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0217a>() { // from class: com.baidu.swan.apps.as.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(RunnableC0217a runnableC0217a) {
                runnableC0217a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0217a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aeW() {
        float f = this.bUG.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0217a> list) {
        V(0.0f);
        float aeW = aeW();
        long j = 0;
        int i = 0;
        long j2 = this.bUG.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.bUD);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j += read;
                allocate.flip();
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0217a>() { // from class: com.baidu.swan.apps.as.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(RunnableC0217a runnableC0217a) {
                        try {
                            if (runnableC0217a.bUP.isOpen() && runnableC0217a.bUO.isOpen()) {
                                allocate.rewind();
                                runnableC0217a.bUP.write(allocate);
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
                    if (f2 > aeW) {
                        log("pumping: updateProgress granularity=" + aeW + " step=" + f2);
                        V(f);
                    }
                }
                allocate.clear();
                i = i2;
            } catch (IOException e) {
            } finally {
                a(readableByteChannel, "connected source");
                com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<RunnableC0217a>() { // from class: com.baidu.swan.apps.as.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(RunnableC0217a runnableC0217a) {
                        a.a(runnableC0217a.bUP, runnableC0217a.toString() + " by[PumpingFinish]");
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
    /* loaded from: classes10.dex */
    public class RunnableC0217a implements Runnable {
        private final com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bUM;
        private CountDownLatch bUQ;
        private String bUR;
        private final Pipe bUN = Pipe.open();
        private final Pipe.SinkChannel bUP = this.bUN.sink();
        private final Pipe.SourceChannel bUO = this.bUN.source();

        RunnableC0217a(com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> bVar) throws IOException {
            this.bUM = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.bUQ = countDownLatch;
        }

        private void aeX() {
            if (this.bUQ != null) {
                this.bUQ.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bUR = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.bUM.B(this.bUO);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            aeX();
        }

        private void close() {
            a.a(this.bUP, "sink for " + toString());
            a.a(this.bUO, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.bUR + " consumer=" + this.bUM.toString();
        }
    }
}
