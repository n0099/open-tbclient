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
    private com.baidu.swan.apps.an.d.a<String> ayu;
    private ExecutorService bav;
    private final Set<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>> bau = new HashSet();
    private int baw = 8192;
    private long mTimeout = -1;
    private TimeUnit bax = TimeUnit.NANOSECONDS;

    private void iz(String str) {
        if (this.ayu != null) {
            this.ayu.D(str);
        }
    }

    public a j(com.baidu.swan.apps.an.d.a<String> aVar) {
        this.ayu = aVar;
        return this;
    }

    @NonNull
    public a eD(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.baw = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.bax = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>... aVarArr) {
        this.bau.addAll(Arrays.asList(aVarArr));
        return this;
    }

    public synchronized void c(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            iz(IntentConfig.START);
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0120a> PO = PO();
            CountDownLatch countDownLatch = new CountDownLatch(PO.size());
            ExecutorService a = a(PO, countDownLatch);
            a(readableByteChannel, PO);
            iz("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.bax.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.bax)) {
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
            iz("finish");
        }
    }

    private List<RunnableC0120a> PO() {
        final ArrayList arrayList = new ArrayList();
        a((Set) this.bau, (com.baidu.swan.apps.an.d.a) new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.an.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: k */
            public void D(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) {
                try {
                    arrayList.add(new RunnableC0120a(aVar));
                } catch (IOException e) {
                }
            }
        });
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0120a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.bav == null || this.bav.isShutdown() || this.bav.isTerminated()) {
            this.bav = null;
        }
        final ExecutorService newCachedThreadPool = this.bav == null ? Executors.newCachedThreadPool() : this.bav;
        a(list, new com.baidu.swan.apps.an.d.a<RunnableC0120a>() { // from class: com.baidu.swan.apps.an.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(RunnableC0120a runnableC0120a) {
                runnableC0120a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0120a);
            }
        });
        return newCachedThreadPool;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0120a> list) {
        int i = 0;
        try {
            final ByteBuffer allocate = ByteBuffer.allocate(this.baw);
            while (readableByteChannel.read(allocate) != -1) {
                i++;
                allocate.flip();
                a(list, new com.baidu.swan.apps.an.d.a<RunnableC0120a>() { // from class: com.baidu.swan.apps.an.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(RunnableC0120a runnableC0120a) {
                        try {
                            if (runnableC0120a.baG.isOpen() && runnableC0120a.baF.isOpen()) {
                                allocate.rewind();
                                runnableC0120a.baG.write(allocate);
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
            a(list, new com.baidu.swan.apps.an.d.a<RunnableC0120a>() { // from class: com.baidu.swan.apps.an.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void D(RunnableC0120a runnableC0120a) {
                    a.a(runnableC0120a.baG, runnableC0120a.toString() + " by[PumpingFinish]");
                }
            });
        }
    }

    private void a(@NonNull ExecutorService executorService) {
        if (executorService != this.bav && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.bav = null;
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
    public class RunnableC0120a implements Runnable {
        private final com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> baD;
        private CountDownLatch baH;
        private String baI;
        private final Pipe baE = Pipe.open();
        private final Pipe.SinkChannel baG = this.baE.sink();
        private final Pipe.SourceChannel baF = this.baE.source();

        RunnableC0120a(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) throws IOException {
            this.baD = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.baH = countDownLatch;
        }

        private void PP() {
            if (this.baH != null) {
                this.baH.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.baI = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.baD.D(this.baF);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            PP();
        }

        private void close() {
            a.a(this.baG, "sink for " + toString());
            a.a(this.baF, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.baI + " consumer=" + this.baD.toString();
        }
    }
}
