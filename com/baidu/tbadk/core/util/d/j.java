package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dbG = null;
    private Queue<a> dbH = new LinkedList();
    private BdAsyncTaskParallel dbI = null;
    private BdAsyncTaskParallel dbJ = null;
    private float dbK = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dbL;
        public long dbM;

        private a() {
            this.dbL = 0;
            this.dbM = 0L;
        }
    }

    public static j aGW() {
        if (dbG == null) {
            dbG = new j();
        }
        return dbG;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dbL = i;
        aVar.dbM = j;
        this.dbH.offer(aVar);
        if (this.dbH.size() > 5) {
            this.dbH.poll();
        }
        if (aGX()) {
            int i2 = 0;
            for (a aVar2 : this.dbH) {
                i2 = j > 0 ? (int) ((aVar2.dbL / aVar2.dbM) + i2) : i2;
            }
            this.dbK = i2 / 5;
        }
    }

    public boolean aGX() {
        return this.dbH.size() == 5;
    }

    public BdAsyncTaskParallel gv() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aGX() && this.dbK < 20.0f) {
            if (this.dbI == null) {
                this.dbI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dbI;
        }
        if (this.dbJ == null) {
            this.dbJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dbJ;
    }
}
