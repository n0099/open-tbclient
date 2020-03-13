package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dbT = null;
    private Queue<a> dbU = new LinkedList();
    private BdAsyncTaskParallel dbV = null;
    private BdAsyncTaskParallel dbW = null;
    private float dbX = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dbY;
        public long dbZ;

        private a() {
            this.dbY = 0;
            this.dbZ = 0L;
        }
    }

    public static j aGX() {
        if (dbT == null) {
            dbT = new j();
        }
        return dbT;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dbY = i;
        aVar.dbZ = j;
        this.dbU.offer(aVar);
        if (this.dbU.size() > 5) {
            this.dbU.poll();
        }
        if (aGY()) {
            int i2 = 0;
            for (a aVar2 : this.dbU) {
                i2 = j > 0 ? (int) ((aVar2.dbY / aVar2.dbZ) + i2) : i2;
            }
            this.dbX = i2 / 5;
        }
    }

    public boolean aGY() {
        return this.dbU.size() == 5;
    }

    public BdAsyncTaskParallel gv() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aGY() && this.dbX < 20.0f) {
            if (this.dbV == null) {
                this.dbV = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dbV;
        }
        if (this.dbW == null) {
            this.dbW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dbW;
    }
}
