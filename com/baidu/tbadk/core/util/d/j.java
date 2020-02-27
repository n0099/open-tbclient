package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dbF = null;
    private Queue<a> dbG = new LinkedList();
    private BdAsyncTaskParallel dbH = null;
    private BdAsyncTaskParallel dbI = null;
    private float dbJ = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dbK;
        public long dbL;

        private a() {
            this.dbK = 0;
            this.dbL = 0L;
        }
    }

    public static j aGU() {
        if (dbF == null) {
            dbF = new j();
        }
        return dbF;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dbK = i;
        aVar.dbL = j;
        this.dbG.offer(aVar);
        if (this.dbG.size() > 5) {
            this.dbG.poll();
        }
        if (aGV()) {
            int i2 = 0;
            for (a aVar2 : this.dbG) {
                i2 = j > 0 ? (int) ((aVar2.dbK / aVar2.dbL) + i2) : i2;
            }
            this.dbJ = i2 / 5;
        }
    }

    public boolean aGV() {
        return this.dbG.size() == 5;
    }

    public BdAsyncTaskParallel gv() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aGV() && this.dbJ < 20.0f) {
            if (this.dbH == null) {
                this.dbH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dbH;
        }
        if (this.dbI == null) {
            this.dbI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dbI;
    }
}
