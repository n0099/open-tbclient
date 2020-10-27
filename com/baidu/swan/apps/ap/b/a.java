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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.ap.e.b<String> dyx;
    private ExecutorService mExecutorService;
    private final Set<com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>> dyu = new HashSet();
    private int dyv = 8192;
    private long mTimeout = -1;
    private TimeUnit dyw = TimeUnit.NANOSECONDS;
    private final c.a dyy = new c.a();
    private float mProgress = 0.0f;

    public a W(Bundle bundle) {
        this.dyy.D(bundle);
        return this;
    }

    public float getProgress() {
        return this.mProgress;
    }

    private void O(float f) {
        if (DEBUG) {
            log("updateProgress: progress=" + f);
        }
        this.mProgress = f;
        up("on_progress");
    }

    private void up(String str) {
        if (this.dyx != null) {
            this.dyx.M(str);
        }
    }

    public a D(com.baidu.swan.apps.ap.e.b<String> bVar) {
        this.dyx = bVar;
        return this;
    }

    @NonNull
    public a li(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.dyv = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.dyw = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>... bVarArr) {
        this.dyu.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public synchronized void b(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            up("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0371a> aKQ = aKQ();
            CountDownLatch countDownLatch = new CountDownLatch(aKQ.size());
            ExecutorService a2 = a(aKQ, countDownLatch);
            a(readableByteChannel, aKQ);
            up("pump_finish");
            if (DEBUG) {
                log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                if (DEBUG) {
                    log("main await for timeout: " + this.dyw.toMillis(this.mTimeout));
                }
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.dyw)) {
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
            up("finish");
        }
    }

    private List<RunnableC0371a> aKQ() {
        final ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.ap.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: e */
            public void M(com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> bVar) {
                try {
                    arrayList.add(new RunnableC0371a(bVar));
                } catch (IOException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.dyu);
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0371a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.mExecutorService == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            this.mExecutorService = null;
        }
        final ExecutorService newCachedThreadPool = this.mExecutorService == null ? Executors.newCachedThreadPool() : this.mExecutorService;
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0371a>() { // from class: com.baidu.swan.apps.ap.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(RunnableC0371a runnableC0371a) {
                runnableC0371a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0371a);
            }
        }, list);
        return newCachedThreadPool;
    }

    private float aKR() {
        float f = this.dyy.getFloat("progress_granularity", 0.01f);
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0371a> list) {
        O(0.0f);
        float aKR = aKR();
        long j = 0;
        int i = 0;
        long j2 = this.dyy.getLong("length");
        final ByteBuffer allocate = ByteBuffer.allocate(this.dyv);
        while (true) {
            try {
                long read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                long j3 = j + read;
                allocate.flip();
                com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0371a>() { // from class: com.baidu.swan.apps.ap.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(RunnableC0371a runnableC0371a) {
                        try {
                            if (runnableC0371a.dyG.isOpen() && runnableC0371a.dyF.isOpen()) {
                                allocate.rewind();
                                runnableC0371a.dyG.write(allocate);
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
                    if (f3 > aKR) {
                        if (DEBUG) {
                            NumberFormat percentInstance = NumberFormat.getPercentInstance();
                            log("pumping: updateProgress granularity:" + percentInstance.format(aKR) + " step:" + percentInstance.format(f3));
                        }
                        O(f2);
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
                com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<RunnableC0371a>() { // from class: com.baidu.swan.apps.ap.b.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(RunnableC0371a runnableC0371a) {
                        a.a(runnableC0371a.dyG, runnableC0371a.toString() + " by[PumpingFinish]");
                    }
                }, list);
            }
        }
        if (DEBUG) {
            log("pumping done: writeCount=" + i + " length: " + j2);
        }
        O(1.0f);
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
    /* loaded from: classes10.dex */
    public class RunnableC0371a implements Runnable {
        private final com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> dyD;
        private String dyH;
        private CountDownLatch latch;
        private final Pipe dyE = Pipe.open();
        private final Pipe.SinkChannel dyG = this.dyE.sink();
        private final Pipe.SourceChannel dyF = this.dyE.source();

        RunnableC0371a(com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> bVar) throws IOException {
            this.dyD = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        private void aKS() {
            if (this.latch != null) {
                this.latch.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dyH = Thread.currentThread().toString();
            if (a.DEBUG) {
                a.log(" >> run on " + toString());
            }
            try {
                this.dyD.M(this.dyF);
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
            aKS();
        }

        private void close() {
            a.a(this.dyG, "sink for " + toString());
            a.a(this.dyF, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.dyH + " consumer=" + this.dyD.toString();
        }
    }
}
