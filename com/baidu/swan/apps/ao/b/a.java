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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.ao.e.b<String> dRk;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>> dRh = new HashSet();
    private int dRi = 8192;
    private long mTimeout = -1;
    private TimeUnit dRj = TimeUnit.NANOSECONDS;
    private final c.a dRl = new c.a();
    private float mProgress = 0.0f;

    public a W(Bundle bundle) {
        this.dRl.D(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void W(float f) {
        if (DEBUG) {
            log("updateProgress: progress=" + f);
        }
        this.mProgress = f;
        ut("on_progress");
    }

    private void ut(String str) {
        if (this.dRk != null) {
            this.dRk.N(str);
        }
    }

    public a D(com.baidu.swan.apps.ao.e.b<String> bVar) {
        this.dRk = bVar;
        return this;
    }

    @NonNull
    public a kp(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.dRi = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.dRj = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>... bVarArr) {
        this.dRh.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            ut("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0371a> aOJ = aOJ();
            CountDownLatch countDownLatch = new CountDownLatch(aOJ.size());
            ExecutorService a2 = a(aOJ, countDownLatch);
            a(readableByteChannel, aOJ);
            ut("pump_finish");
            if (DEBUG) {
                log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                if (DEBUG) {
                    log("main await for timeout: " + this.dRj.toMillis(this.mTimeout));
                }
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.dRj)) {
                    z = true;
                }
                if (DEBUG) {
                    log("main await finish by " + (z ? "time's up" : "count down"));
                }
                if (DEBUG) {
                    log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                a(a2);
            } catch (InterruptedException e) {
                if (DEBUG) {
                    log("main await finish by InterruptedException " + e);
                    e.printStackTrace();
                }
                if (DEBUG) {
                    log("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                a(a2);
            }
            ut("finish");
        }
    }

    private List<RunnableC0371a> aOJ() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.ao.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: e */
            public void N(com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0371a(bVar));
                } catch (IOException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.dRh);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0371a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0371a>() { // from class: com.baidu.swan.apps.ao.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(RunnableC0371a runnableC0371a) {
                runnableC0371a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0371a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aOK() {
        float f = this.dRl.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0371a> list) {
        W(0.0f);
        float aOK = aOK();
        int i = 0;
        long j = this.dRl.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.dRi);
        long j2 = 0;
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j2 += read;
                allocate.flip();
                com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0371a>() { // from class: com.baidu.swan.apps.ao.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void N(RunnableC0371a runnableC0371a) {
                        try {
                            if (runnableC0371a.dRt.isOpen() && runnableC0371a.dRs.isOpen()) {
                                allocate.rewind();
                                runnableC0371a.dRt.write(allocate);
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                a.log("connect e:" + e + " line: " + runnableC0371a);
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
                    if (f3 > aOK) {
                        if (DEBUG) {
                            NumberFormat percentInstance = NumberFormat.getPercentInstance();
                            log("pumping: updateProgress granularity:" + percentInstance.format(aOK) + " step:" + percentInstance.format(f3));
                        }
                        W(f2);
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
                com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0371a>() { // from class: com.baidu.swan.apps.ao.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void N(RunnableC0371a runnableC0371a) {
                        a.a(runnableC0371a.dRt, runnableC0371a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        if (DEBUG) {
            log("pumping done: writeCount=" + i + " length: " + j);
        }
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
    /* loaded from: classes8.dex */
    public class RunnableC0371a implements Runnable {
        private final com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> dRq;
        private CountDownLatch dRu;
        private String dRv;
        private final Pipe dRr = Pipe.open();
        private final Pipe.SinkChannel dRt = this.dRr.sink();
        private final Pipe.SourceChannel dRs = this.dRr.source();

        RunnableC0371a(com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.dRq = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.dRu = countDownLatch;
        }

        private void aOL() {
            if (this.dRu != null) {
                this.dRu.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dRv = Thread.currentThread().toString();
            if (a.DEBUG) {
                a.log(" >> run on " + toString());
            }
            try {
                this.dRq.N(this.dRs);
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
            aOL();
        }

        private void close() {
            a.a(this.dRt, "sink for " + toString());
            a.a(this.dRs, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.dRv + " consumer=" + this.dRq.toString();
        }
    }
}
