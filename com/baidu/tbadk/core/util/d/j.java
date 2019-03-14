package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bMV = null;
    private Queue<a> bMW = new LinkedList();
    private BdAsyncTaskParallel bMX = null;
    private BdAsyncTaskParallel bMY = null;
    private float bMZ = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bNa;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bNa = 0L;
        }
    }

    public static j adW() {
        if (bMV == null) {
            bMV = new j();
        }
        return bMV;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bNa = j;
        this.bMW.offer(aVar);
        if (this.bMW.size() > 5) {
            this.bMW.poll();
        }
        if (adX()) {
            int i2 = 0;
            for (a aVar2 : this.bMW) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bNa) + i2) : i2;
            }
            this.bMZ = i2 / 5;
        }
    }

    public boolean adX() {
        return this.bMW.size() == 5;
    }

    public BdAsyncTaskParallel jF() {
        if (!com.baidu.adp.lib.util.j.lb()) {
            return null;
        }
        if (adX() && this.bMZ < 20.0f) {
            if (this.bMX == null) {
                this.bMX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bMX;
        }
        if (this.bMY == null) {
            this.bMY = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bMY;
    }
}
