package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bUJ = null;
    private Queue<a> bUK = new LinkedList();
    private BdAsyncTaskParallel bUL = null;
    private BdAsyncTaskParallel bUM = null;
    private float bUN = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bUO;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bUO = 0L;
        }
    }

    public static j aiS() {
        if (bUJ == null) {
            bUJ = new j();
        }
        return bUJ;
    }

    public synchronized void o(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bUO = j;
        this.bUK.offer(aVar);
        if (this.bUK.size() > 5) {
            this.bUK.poll();
        }
        if (aiT()) {
            int i2 = 0;
            for (a aVar2 : this.bUK) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bUO) + i2) : i2;
            }
            this.bUN = i2 / 5;
        }
    }

    public boolean aiT() {
        return this.bUK.size() == 5;
    }

    public BdAsyncTaskParallel iz() {
        if (!com.baidu.adp.lib.util.j.jV()) {
            return null;
        }
        if (aiT() && this.bUN < 20.0f) {
            if (this.bUL == null) {
                this.bUL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bUL;
        }
        if (this.bUM == null) {
            this.bUM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bUM;
    }
}
