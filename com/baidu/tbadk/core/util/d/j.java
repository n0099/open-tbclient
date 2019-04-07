package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bMX = null;
    private Queue<a> bMY = new LinkedList();
    private BdAsyncTaskParallel bMZ = null;
    private BdAsyncTaskParallel bNa = null;
    private float bNb = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bNc;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bNc = 0L;
        }
    }

    public static j adT() {
        if (bMX == null) {
            bMX = new j();
        }
        return bMX;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bNc = j;
        this.bMY.offer(aVar);
        if (this.bMY.size() > 5) {
            this.bMY.poll();
        }
        if (adU()) {
            int i2 = 0;
            for (a aVar2 : this.bMY) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bNc) + i2) : i2;
            }
            this.bNb = i2 / 5;
        }
    }

    public boolean adU() {
        return this.bMY.size() == 5;
    }

    public BdAsyncTaskParallel jF() {
        if (!com.baidu.adp.lib.util.j.lb()) {
            return null;
        }
        if (adU() && this.bNb < 20.0f) {
            if (this.bMZ == null) {
                this.bMZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bMZ;
        }
        if (this.bNa == null) {
            this.bNa = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bNa;
    }
}
