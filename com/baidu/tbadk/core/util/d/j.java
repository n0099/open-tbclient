package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j aFa = null;
    private Queue<a> aFb = new LinkedList();
    private BdAsyncTaskParallel aFc = null;
    private BdAsyncTaskParallel aFd = null;
    private float aFe = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aFf;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aFf = 0L;
        }
    }

    public static j EM() {
        if (aFa == null) {
            aFa = new j();
        }
        return aFa;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aFf = j;
        this.aFb.offer(aVar);
        if (this.aFb.size() > 5) {
            this.aFb.poll();
        }
        if (EN()) {
            int i2 = 0;
            for (a aVar2 : this.aFb) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aFf) + i2) : i2;
            }
            this.aFe = i2 / 5;
        }
    }

    public boolean EN() {
        return this.aFb.size() == 5;
    }

    public BdAsyncTaskParallel jE() {
        if (!com.baidu.adp.lib.util.j.kY()) {
            return null;
        }
        if (EN() && this.aFe < 20.0f) {
            if (this.aFc == null) {
                this.aFc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aFc;
        }
        if (this.aFd == null) {
            this.aFd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aFd;
    }
}
