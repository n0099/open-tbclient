package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bMU = null;
    private Queue<a> bMV = new LinkedList();
    private BdAsyncTaskParallel bMW = null;
    private BdAsyncTaskParallel bMX = null;
    private float bMY = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bMZ;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bMZ = 0L;
        }
    }

    public static j adW() {
        if (bMU == null) {
            bMU = new j();
        }
        return bMU;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bMZ = j;
        this.bMV.offer(aVar);
        if (this.bMV.size() > 5) {
            this.bMV.poll();
        }
        if (adX()) {
            int i2 = 0;
            for (a aVar2 : this.bMV) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bMZ) + i2) : i2;
            }
            this.bMY = i2 / 5;
        }
    }

    public boolean adX() {
        return this.bMV.size() == 5;
    }

    public BdAsyncTaskParallel jF() {
        if (!com.baidu.adp.lib.util.j.lb()) {
            return null;
        }
        if (adX() && this.bMY < 20.0f) {
            if (this.bMW == null) {
                this.bMW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bMW;
        }
        if (this.bMX == null) {
            this.bMX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bMX;
    }
}
