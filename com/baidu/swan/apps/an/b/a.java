package com.baidu.swan.apps.an.b;

import android.support.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {
    private ExecutorService aZL;
    private com.baidu.swan.apps.an.d.a<String> axN;
    private final Set<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>> aZK = new HashSet();
    private int aZM = 8192;
    private long mTimeout = -1;
    private TimeUnit aZN = TimeUnit.NANOSECONDS;

    private void it(String str) {
        if (this.axN != null) {
            this.axN.D(str);
        }
    }

    public a j(com.baidu.swan.apps.an.d.a<String> aVar) {
        this.axN = aVar;
        return this;
    }

    @NonNull
    public a eA(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.aZM = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.aZN = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>... aVarArr) {
        this.aZK.addAll(Arrays.asList(aVarArr));
        return this;
    }

    public synchronized void c(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            it(IntentConfig.START);
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0118a> OY = OY();
            CountDownLatch countDownLatch = new CountDownLatch(OY.size());
            ExecutorService a = a(OY, countDownLatch);
            a(readableByteChannel, OY);
            it("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.aZN.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.aZN)) {
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
            it("finish");
        }
    }

    private List<RunnableC0118a> OY() {
        final ArrayList arrayList = new ArrayList();
        a((Set) this.aZK, (com.baidu.swan.apps.an.d.a) new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.an.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: k */
            public void D(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) {
                try {
                    arrayList.add(new RunnableC0118a(aVar));
                } catch (IOException e) {
                }
            }
        });
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0118a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.aZL == null || this.aZL.isShutdown() || this.aZL.isTerminated()) {
            this.aZL = null;
        }
        final ExecutorService newCachedThreadPool = this.aZL == null ? Executors.newCachedThreadPool() : this.aZL;
        a(list, new com.baidu.swan.apps.an.d.a<RunnableC0118a>() { // from class: com.baidu.swan.apps.an.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(RunnableC0118a runnableC0118a) {
                runnableC0118a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0118a);
            }
        });
        return newCachedThreadPool;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0118a> list) {
        int i = 0;
        try {
            final ByteBuffer allocate = ByteBuffer.allocate(this.aZM);
            while (readableByteChannel.read(allocate) != -1) {
                i++;
                allocate.flip();
                a(list, new com.baidu.swan.apps.an.d.a<RunnableC0118a>() { // from class: com.baidu.swan.apps.an.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(RunnableC0118a runnableC0118a) {
                        try {
                            if (runnableC0118a.aZW.isOpen() && runnableC0118a.aZV.isOpen()) {
                                allocate.rewind();
                                runnableC0118a.aZW.write(allocate);
                            }
                        } catch (IOException e) {
                        }
                    }
                });
                allocate.clear();
            }
            log("pumping: writeCount=" + i);
        } catch (IOException e) {
        } finally {
            a(readableByteChannel, "connected source");
            a(list, new com.baidu.swan.apps.an.d.a<RunnableC0118a>() { // from class: com.baidu.swan.apps.an.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void D(RunnableC0118a runnableC0118a) {
                    a.a(runnableC0118a.aZW, runnableC0118a.toString() + " by[PumpingFinish]");
                }
            });
        }
    }

    private void a(@NonNull ExecutorService executorService) {
        if (executorService != this.aZL && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.aZL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Channel channel, String str) {
        if (channel != null && channel.isOpen()) {
            try {
                log("close on " + str);
                channel.close();
            } catch (IOException e) {
                log("close failed on " + str);
            }
        }
    }

    private static <E> void a(Set<E> set, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : set) {
            aVar.D(e);
        }
    }

    private static <E> void a(Collection<E> collection, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : collection) {
            aVar.D(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.an.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0118a implements Runnable {
        private final com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aZT;
        private CountDownLatch aZX;
        private String aZY;
        private final Pipe aZU = Pipe.open();
        private final Pipe.SinkChannel aZW = this.aZU.sink();
        private final Pipe.SourceChannel aZV = this.aZU.source();

        RunnableC0118a(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) throws IOException {
            this.aZT = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.aZX = countDownLatch;
        }

        private void countDown() {
            if (this.aZX != null) {
                this.aZX.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aZY = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.aZT.D(this.aZV);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            countDown();
        }

        private void close() {
            a.a(this.aZW, "sink for " + toString());
            a.a(this.aZV, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.aZY + " consumer=" + this.aZT.toString();
        }
    }
}
