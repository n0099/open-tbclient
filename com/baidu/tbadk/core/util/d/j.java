package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j aFb = null;
    private Queue<a> aFc = new LinkedList();
    private BdAsyncTaskParallel aFd = null;
    private BdAsyncTaskParallel aFe = null;
    private float aFf = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aFg;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aFg = 0L;
        }
    }

    public static j EM() {
        if (aFb == null) {
            aFb = new j();
        }
        return aFb;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aFg = j;
        this.aFc.offer(aVar);
        if (this.aFc.size() > 5) {
            this.aFc.poll();
        }
        if (EN()) {
            int i2 = 0;
            for (a aVar2 : this.aFc) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aFg) + i2) : i2;
            }
            this.aFf = i2 / 5;
        }
    }

    public boolean EN() {
        return this.aFc.size() == 5;
    }

    public BdAsyncTaskParallel jE() {
        if (!com.baidu.adp.lib.util.j.kY()) {
            return null;
        }
        if (EN() && this.aFf < 20.0f) {
            if (this.aFd == null) {
                this.aFd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aFd;
        }
        if (this.aFe == null) {
            this.aFe = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aFe;
    }
}
