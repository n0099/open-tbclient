package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bMY = null;
    private Queue<a> bMZ = new LinkedList();
    private BdAsyncTaskParallel bNa = null;
    private BdAsyncTaskParallel bNb = null;
    private float bNc = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bNd;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bNd = 0L;
        }
    }

    public static j adT() {
        if (bMY == null) {
            bMY = new j();
        }
        return bMY;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bNd = j;
        this.bMZ.offer(aVar);
        if (this.bMZ.size() > 5) {
            this.bMZ.poll();
        }
        if (adU()) {
            int i2 = 0;
            for (a aVar2 : this.bMZ) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bNd) + i2) : i2;
            }
            this.bNc = i2 / 5;
        }
    }

    public boolean adU() {
        return this.bMZ.size() == 5;
    }

    public BdAsyncTaskParallel jF() {
        if (!com.baidu.adp.lib.util.j.lb()) {
            return null;
        }
        if (adU() && this.bNc < 20.0f) {
            if (this.bNa == null) {
                this.bNa = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bNa;
        }
        if (this.bNb == null) {
            this.bNb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bNb;
    }
}
