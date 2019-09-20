package com.baidu.tbadk.core.util.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bWI = null;
    private Queue<a> bWJ = new LinkedList();
    private BdAsyncTaskParallel bWK = null;
    private BdAsyncTaskParallel bWL = null;
    private float bWM = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bWN;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bWN = 0L;
        }
    }

    public static j akk() {
        if (bWI == null) {
            bWI = new j();
        }
        return bWI;
    }

    public synchronized void o(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bWN = j;
        this.bWJ.offer(aVar);
        if (this.bWJ.size() > 5) {
            this.bWJ.poll();
        }
        if (akl()) {
            int i2 = 0;
            for (a aVar2 : this.bWJ) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bWN) + i2) : i2;
            }
            this.bWM = i2 / 5;
        }
    }

    public boolean akl() {
        return this.bWJ.size() == 5;
    }

    public BdAsyncTaskParallel iI() {
        if (!com.baidu.adp.lib.util.j.kf()) {
            return null;
        }
        if (akl() && this.bWM < 20.0f) {
            if (this.bWK == null) {
                this.bWK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bWK;
        }
        if (this.bWL == null) {
            this.bWL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bWL;
    }
}
