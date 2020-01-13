package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j cXC = null;
    private Queue<a> cXD = new LinkedList();
    private BdAsyncTaskParallel cXE = null;
    private BdAsyncTaskParallel cXF = null;
    private float cXG = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int cXH;
        public long cXI;

        private a() {
            this.cXH = 0;
            this.cXI = 0L;
        }
    }

    public static j aEI() {
        if (cXC == null) {
            cXC = new j();
        }
        return cXC;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.cXH = i;
        aVar.cXI = j;
        this.cXD.offer(aVar);
        if (this.cXD.size() > 5) {
            this.cXD.poll();
        }
        if (aEJ()) {
            int i2 = 0;
            for (a aVar2 : this.cXD) {
                i2 = j > 0 ? (int) ((aVar2.cXH / aVar2.cXI) + i2) : i2;
            }
            this.cXG = i2 / 5;
        }
    }

    public boolean aEJ() {
        return this.cXD.size() == 5;
    }

    public BdAsyncTaskParallel gv() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aEJ() && this.cXG < 20.0f) {
            if (this.cXE == null) {
                this.cXE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.cXE;
        }
        if (this.cXF == null) {
            this.cXF = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.cXF;
    }
}
