package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aXH = null;
    private Queue<a> aXI = new LinkedList();
    private BdAsyncTaskParallel aXJ = null;
    private BdAsyncTaskParallel aXK = null;
    private float aXL = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aXM;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aXM = 0L;
        }
    }

    public static i Dt() {
        if (aXH == null) {
            aXH = new i();
        }
        return aXH;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aXM = j;
        this.aXI.offer(aVar);
        if (this.aXI.size() > 5) {
            this.aXI.poll();
        }
        if (Du()) {
            int i2 = 0;
            for (a aVar2 : this.aXI) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aXM) + i2) : i2;
            }
            this.aXL = i2 / 5;
        }
    }

    public boolean Du() {
        return this.aXI.size() == 5;
    }

    public BdAsyncTaskParallel nq() {
        if (!com.baidu.adp.lib.util.j.oM()) {
            return null;
        }
        if (Du() && this.aXL < 20.0f) {
            if (this.aXJ == null) {
                this.aXJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aXJ;
        }
        if (this.aXK == null) {
            this.aXK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aXK;
    }
}
