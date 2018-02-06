package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aZq = null;
    private Queue<a> aZr = new LinkedList();
    private BdAsyncTaskParallel aZs = null;
    private BdAsyncTaskParallel aZt = null;
    private float aZu = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aZv;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aZv = 0L;
        }
    }

    public static i DN() {
        if (aZq == null) {
            aZq = new i();
        }
        return aZq;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aZv = j;
        this.aZr.offer(aVar);
        if (this.aZr.size() > 5) {
            this.aZr.poll();
        }
        if (DO()) {
            int i2 = 0;
            for (a aVar2 : this.aZr) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aZv) + i2) : i2;
            }
            this.aZu = i2 / 5;
        }
    }

    public boolean DO() {
        return this.aZr.size() == 5;
    }

    public BdAsyncTaskParallel nq() {
        if (!com.baidu.adp.lib.util.j.oM()) {
            return null;
        }
        if (DO() && this.aZu < 20.0f) {
            if (this.aZs == null) {
                this.aZs = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aZs;
        }
        if (this.aZt == null) {
            this.aZt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aZt;
    }
}
