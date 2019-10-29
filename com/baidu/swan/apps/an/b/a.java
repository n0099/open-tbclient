package com.baidu.swan.apps.an.b;

import android.support.annotation.NonNull;
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
    private com.baidu.swan.apps.an.d.a<String> aSi;
    private ExecutorService btS;
    private final Set<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>> btR = new HashSet();
    private int btT = 8192;
    private long mTimeout = -1;
    private TimeUnit btU = TimeUnit.NANOSECONDS;

    private void je(String str) {
        if (this.aSi != null) {
            this.aSi.B(str);
        }
    }

    public a j(com.baidu.swan.apps.an.d.a<String> aVar) {
        this.aSi = aVar;
        return this;
    }

    @NonNull
    public a fz(int i) {
        if (i < 1) {
            i = 8192;
        }
        this.btT = i;
        return this;
    }

    @NonNull
    public a a(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.mTimeout = j;
        this.btU = timeUnit;
        return this;
    }

    @NonNull
    public a a(@NonNull com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>... aVarArr) {
        this.btR.addAll(Arrays.asList(aVarArr));
        return this;
    }

    public synchronized void c(ReadableByteChannel readableByteChannel) {
        boolean z = false;
        synchronized (this) {
            je("start");
            long currentTimeMillis = System.currentTimeMillis();
            List<RunnableC0161a> UI = UI();
            CountDownLatch countDownLatch = new CountDownLatch(UI.size());
            ExecutorService a = a(UI, countDownLatch);
            a(readableByteChannel, UI);
            je("pump_finish");
            log("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
            try {
                log("main await for timeout: " + this.btU.toMillis(this.mTimeout));
                if (this.mTimeout < 0) {
                    countDownLatch.await();
                } else if (!countDownLatch.await(this.mTimeout, this.btU)) {
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
            je("finish");
        }
    }

    private List<RunnableC0161a> UI() {
        final ArrayList arrayList = new ArrayList();
        a((Set) this.btR, (com.baidu.swan.apps.an.d.a) new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a<Pipe.SourceChannel>>() { // from class: com.baidu.swan.apps.an.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: k */
            public void B(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) {
                try {
                    arrayList.add(new RunnableC0161a(aVar));
                } catch (IOException e) {
                }
            }
        });
        return arrayList;
    }

    @NonNull
    private ExecutorService a(@NonNull List<RunnableC0161a> list, @NonNull final CountDownLatch countDownLatch) {
        if (this.btS == null || this.btS.isShutdown() || this.btS.isTerminated()) {
            this.btS = null;
        }
        final ExecutorService newCachedThreadPool = this.btS == null ? Executors.newCachedThreadPool() : this.btS;
        a(list, new com.baidu.swan.apps.an.d.a<RunnableC0161a>() { // from class: com.baidu.swan.apps.an.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(RunnableC0161a runnableC0161a) {
                runnableC0161a.a(countDownLatch);
                newCachedThreadPool.submit(runnableC0161a);
            }
        });
        return newCachedThreadPool;
    }

    private void a(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<RunnableC0161a> list) {
        int i = 0;
        try {
            final ByteBuffer allocate = ByteBuffer.allocate(this.btT);
            while (readableByteChannel.read(allocate) != -1) {
                i++;
                allocate.flip();
                a(list, new com.baidu.swan.apps.an.d.a<RunnableC0161a>() { // from class: com.baidu.swan.apps.an.b.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void B(RunnableC0161a runnableC0161a) {
                        try {
                            if (runnableC0161a.bud.isOpen() && runnableC0161a.buc.isOpen()) {
                                allocate.rewind();
                                runnableC0161a.bud.write(allocate);
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
            a(list, new com.baidu.swan.apps.an.d.a<RunnableC0161a>() { // from class: com.baidu.swan.apps.an.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void B(RunnableC0161a runnableC0161a) {
                    a.a(runnableC0161a.bud, runnableC0161a.toString() + " by[PumpingFinish]");
                }
            });
        }
    }

    private void a(@NonNull ExecutorService executorService) {
        if (executorService != this.btS && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.btS = null;
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
            aVar.B(e);
        }
    }

    private static <E> void a(Collection<E> collection, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : collection) {
            aVar.B(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.an.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0161a implements Runnable {
        private final com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> bua;
        private CountDownLatch bue;
        private String bug;
        private final Pipe bub = Pipe.open();
        private final Pipe.SinkChannel bud = this.bub.sink();
        private final Pipe.SourceChannel buc = this.bub.source();

        RunnableC0161a(com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> aVar) throws IOException {
            this.bua = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CountDownLatch countDownLatch) {
            this.bue = countDownLatch;
        }

        private void UJ() {
            if (this.bue != null) {
                this.bue.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bug = Thread.currentThread().toString();
            a.log(" >> run on " + toString());
            try {
                this.bua.B(this.buc);
            } catch (Exception e) {
            } finally {
                close();
            }
            a.log("countdown by end -> " + toString());
            UJ();
        }

        private void close() {
            a.a(this.bud, "sink for " + toString());
            a.a(this.buc, "source for " + toString());
        }

        public String toString() {
            return "PipeLine: " + this.bug + " consumer=" + this.bua.toString();
        }
    }
}
