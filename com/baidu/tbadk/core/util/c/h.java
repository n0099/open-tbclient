package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aiA = null;
    private Queue<a> aiB = new LinkedList();
    private BdAsyncTaskParallel aiC = null;
    private BdAsyncTaskParallel aiD = null;
    private float aiE = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aiF;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aiF = 0L;
        }
    }

    public static h vS() {
        if (aiA == null) {
            aiA = new h();
        }
        return aiA;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aiF = j;
        this.aiB.offer(aVar);
        if (this.aiB.size() > 5) {
            this.aiB.poll();
        }
        if (vT()) {
            int i2 = 0;
            for (a aVar2 : this.aiB) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aiF) + i2) : i2;
            }
            this.aiE = i2 / 5;
        }
    }

    public boolean vT() {
        return this.aiB.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.j.hk()) {
            return null;
        }
        if (vT() && this.aiE < 20.0f) {
            if (this.aiC == null) {
                this.aiC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aiC;
        }
        if (this.aiD == null) {
            this.aiD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aiD;
    }
}
