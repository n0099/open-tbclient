package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j avx = null;
    private Queue<a> avy = new LinkedList();
    private BdAsyncTaskParallel avz = null;
    private BdAsyncTaskParallel avA = null;
    private float avB = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long avC;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.avC = 0L;
        }
    }

    public static j Bh() {
        if (avx == null) {
            avx = new j();
        }
        return avx;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.avC = j;
        this.avy.offer(aVar);
        if (this.avy.size() > 5) {
            this.avy.poll();
        }
        if (Bi()) {
            int i2 = 0;
            for (a aVar2 : this.avy) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.avC) + i2) : i2;
            }
            this.avB = i2 / 5;
        }
    }

    public boolean Bi() {
        return this.avy.size() == 5;
    }

    public BdAsyncTaskParallel jr() {
        if (!com.baidu.adp.lib.util.j.kN()) {
            return null;
        }
        if (Bi() && this.avB < 20.0f) {
            if (this.avz == null) {
                this.avz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.avz;
        }
        if (this.avA == null) {
            this.avA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.avA;
    }
}
