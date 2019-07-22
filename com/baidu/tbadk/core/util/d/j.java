package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bVL = null;
    private Queue<a> bVM = new LinkedList();
    private BdAsyncTaskParallel bVN = null;
    private BdAsyncTaskParallel bVO = null;
    private float bVP = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bVQ;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bVQ = 0L;
        }
    }

    public static j ajW() {
        if (bVL == null) {
            bVL = new j();
        }
        return bVL;
    }

    public synchronized void o(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bVQ = j;
        this.bVM.offer(aVar);
        if (this.bVM.size() > 5) {
            this.bVM.poll();
        }
        if (ajX()) {
            int i2 = 0;
            for (a aVar2 : this.bVM) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bVQ) + i2) : i2;
            }
            this.bVP = i2 / 5;
        }
    }

    public boolean ajX() {
        return this.bVM.size() == 5;
    }

    public BdAsyncTaskParallel iI() {
        if (!com.baidu.adp.lib.util.j.kf()) {
            return null;
        }
        if (ajX() && this.bVP < 20.0f) {
            if (this.bVN == null) {
                this.bVN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bVN;
        }
        if (this.bVO == null) {
            this.bVO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bVO;
    }
}
