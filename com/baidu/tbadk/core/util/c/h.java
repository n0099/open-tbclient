package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aiM = null;
    private Queue<a> aiN = new LinkedList();
    private BdAsyncTaskParallel aiO = null;
    private BdAsyncTaskParallel aiP = null;
    private float aiQ = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aiR;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aiR = 0L;
        }
    }

    public static h vZ() {
        if (aiM == null) {
            aiM = new h();
        }
        return aiM;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aiR = j;
        this.aiN.offer(aVar);
        if (this.aiN.size() > 5) {
            this.aiN.poll();
        }
        if (wa()) {
            int i2 = 0;
            for (a aVar2 : this.aiN) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aiR) + i2) : i2;
            }
            this.aiQ = i2 / 5;
        }
    }

    public boolean wa() {
        return this.aiN.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.j.hk()) {
            return null;
        }
        if (wa() && this.aiQ < 20.0f) {
            if (this.aiO == null) {
                this.aiO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aiO;
        }
        if (this.aiP == null) {
            this.aiP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aiP;
    }
}
