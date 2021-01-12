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
    private com.baidu.swan.apps.ao.e.b<String> dND;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>> dNA = new HashSet();
    private int dNB = 8192;
    private long mTimeout = -1;
    private TimeUnit dNC = TimeUnit.NANOSECONDS;
    private final c.a dNE = new c.a();
    private float mProgress = 0.0f;

    public a W(Bundle bundle) {
        this.dNE.D(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void R(float f) {
        if (DEBUG) {
            log("updateProgress: progress=" + f);
        }
        this.mProgress = f;
        tT("on_progress");
    }

    private void tT(String str) {
        if (this.dND != null) {
            this.dND.L(str);
        }
    }

    public a D(com.baidu.swan.apps.ao.e.b<String> bVar) {
        this.dND = bVar;
        return this;
    }

    @NonNull
    public a kl(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.dNB = i;
        return this;
    }

    @NonNull
    public a b(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.dNC = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>... bVarArr) {
        this.dNA.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            tT("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0368a> aOn = aOn();
            CountDownLatch countDownLatch = new CountDownLatch(aOn.size());
            ExecutorService a2 = a(aOn, countDownLatch);
            a(readableByteChannel, aOn);
            tT("pump_finish");
            if (DEBUG) {
                log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                if (DEBUG) {
                    log("main await for timeout: " + this.dNC.toMillis(this.mTimeout));
                }
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.dNC)) {
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
            tT("finish");
        }
    }

    private List<RunnableC0368a> aOn() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.ao.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: e */
            public void L(com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0368a(bVar));
                } catch (IOException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.dNA);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0368a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0368a>() { // from class: com.baidu.swan.apps.ao.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(RunnableC0368a runnableC0368a) {
                runnableC0368a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0368a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aOo() {
        float f = this.dNE.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0368a> list) {
        R(0.0f);
        float aOo = aOo();
        int i = 0;
        long j = this.dNE.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.dNB);
        long j2 = 0;
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j2 += read;
                allocate.flip();
                com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0368a>() { // from class: com.baidu.swan.apps.ao.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(RunnableC0368a runnableC0368a) {
                        try {
                            if (runnableC0368a.dNM.isOpen() && runnableC0368a.dNL.isOpen()) {
                                allocate.rewind();
                                runnableC0368a.dNM.write(allocate);
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                a.log("connect e:" + e + " line: " + runnableC0368a);
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
                    if (f3 > aOo) {
                        if (DEBUG) {
                            NumberFormat percentInstance = NumberFormat.getPercentInstance();
                            log("pumping: updateProgress granularity:" + percentInstance.format(aOo) + " step:" + percentInstance.format(f3));
                        }
                        R(f2);
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
                com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<RunnableC0368a>() { // from class: com.baidu.swan.apps.ao.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(RunnableC0368a runnableC0368a) {
                        a.a(runnableC0368a.dNM, runnableC0368a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        if (DEBUG) {
            log("pumping done: writeCount=" + i + " length: " + j);
        }
        R(1.0f);
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
    /* loaded from: classes8.dex */
    public class RunnableC0368a implements Runnable {
        private final com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> dNJ;
        private CountDownLatch dNN;
        private String dNO;
        private final Pipe dNK = Pipe.open();
        private final Pipe.SinkChannel dNM = this.dNK.sink();
        private final Pipe.SourceChannel dNL = this.dNK.source();

        RunnableC0368a(com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.dNJ = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.dNN = countDownLatch;
        }

        private void aOp() {
            if (this.dNN != null) {
                this.dNN.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dNO = Thread.currentThread().toString();
            if (a.DEBUG) {
                a.log(" >> run on " + toString());
            }
            try {
                this.dNJ.L(this.dNL);
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
            aOp();
        }

        private void close() {
            a.a(this.dNM, "sink for " + toString());
            a.a(this.dNL, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.dNO + " consumer=" + this.dNJ.toString();
        }
    }
}
