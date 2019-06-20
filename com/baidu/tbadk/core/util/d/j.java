package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bUK = null;
    private Queue<a> bUL = new LinkedList();
    private BdAsyncTaskParallel bUM = null;
    private BdAsyncTaskParallel bUN = null;
    private float bUO = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bUP;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bUP = 0L;
        }
    }

    public static j aiS() {
        if (bUK == null) {
            bUK = new j();
        }
        return bUK;
    }

    public synchronized void o(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bUP = j;
        this.bUL.offer(aVar);
        if (this.bUL.size() > 5) {
            this.bUL.poll();
        }
        if (aiT()) {
            int i2 = 0;
            for (a aVar2 : this.bUL) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bUP) + i2) : i2;
            }
            this.bUO = i2 / 5;
        }
    }

    public boolean aiT() {
        return this.bUL.size() == 5;
    }

    public BdAsyncTaskParallel iz() {
        if (!com.baidu.adp.lib.util.j.jV()) {
            return null;
        }
        if (aiT() && this.bUO < 20.0f) {
            if (this.bUM == null) {
                this.bUM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bUM;
        }
        if (this.bUN == null) {
            this.bUN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bUN;
    }
}
