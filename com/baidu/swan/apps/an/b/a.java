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
    private com.baidu.swan.apps.an.d.a<String> ayS;
    private ExecutorService baT;
    private final Set<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>> baS = new HashSet();
    private int baU = 8192;
    private long mTimeout = -1;
    private TimeUnit baV = TimeUnit.NANOSECONDS;

    private void iB(String str) {
        if (this.ayS != null) {
            this.ayS.D(str);
        }
    }

    public a j(com.baidu.swan.apps.an.d.a<String> aVar) {
        this.ayS = aVar;
        return this;
    }

    @NonNull
    public a eE(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.baU = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.baV = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>... aVarArr) {
        this.baS.addAll(Arrays.asList(aVarArr));
        return this;
    }

    public synchronized void c(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            iB(IntentConfig.START);
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0129a> PS = PS();
            CountDownLatch countDownLatch = new CountDownLatch(PS.size());
            ExecutorService a = a(PS, countDownLatch);
            a(readableByteChannel, PS);
            iB("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.baV.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.baV)) {
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
            iB("finish");
        }
    }

    private List<RunnableC0129a> PS() {
        final ArrayList arrayList = new ArrayList();
        a((Set) this.baS, (com.baidu.swan.apps.an.d.a) new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.an.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: k */
            public void D(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) {
                try {
                    arrayList.add(new RunnableC0129a(aVar));
                } catch (IOException e) {
                }
            }
        });
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0129a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.baT == null || this.baT.isShutdown() || this.baT.isTerminated()) {
            this.baT = null;
        }
        final ExecutorService newCachedThreadPool = this.baT == null ? Executors.newCachedThreadPool() : this.baT;
        a(list, new com.baidu.swan.apps.an.d.a<RunnableC0129a>() { // from class: com.baidu.swan.apps.an.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(RunnableC0129a runnableC0129a) {
                runnableC0129a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0129a);
            }
        });
        return newCachedThreadPool;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0129a> list) {
        int i = 0;
        try {
            final ByteBuffer allocate = ByteBuffer.allocate(this.baU);
            while (readableByteChannel.read(allocate) != -1) {
                i++;
                allocate.flip();
                a(list, new com.baidu.swan.apps.an.d.a<RunnableC0129a>() { // from class: com.baidu.swan.apps.an.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(RunnableC0129a runnableC0129a) {
                        try {
                            if (runnableC0129a.bbe.isOpen() && runnableC0129a.bbd.isOpen()) {
                                allocate.rewind();
                                runnableC0129a.bbe.write(allocate);
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
            a(list, new com.baidu.swan.apps.an.d.a<RunnableC0129a>() { // from class: com.baidu.swan.apps.an.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void D(RunnableC0129a runnableC0129a) {
                    a.a(runnableC0129a.bbe, runnableC0129a.toString() + " by[PumpingFinish]");
                }
            });
        }
    }

    private void a(@NonNull ExecutorService executorService) {
        if (executorService != this.baT && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.baT = null;
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
    public class RunnableC0129a implements Runnable {
        private final com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> bbb;
        private CountDownLatch bbf;
        private String bbg;
        private final Pipe bbc = Pipe.open();
        private final Pipe.SinkChannel bbe = this.bbc.sink();
        private final Pipe.SourceChannel bbd = this.bbc.source();

        RunnableC0129a(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) throws IOException {
            this.bbb = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.bbf = countDownLatch;
        }

        private void PT() {
            if (this.bbf != null) {
                this.bbf.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bbg = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.bbb.D(this.bbd);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            PT();
        }

        private void close() {
            a.a(this.bbe, "sink for " + toString());
            a.a(this.bbd, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.bbg + " consumer=" + this.bbb.toString();
        }
    }
}
