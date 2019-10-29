package com.baidu.tbadk.core.util.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j clL = null;
    private Queue<a> clM = new LinkedList();
    private BdAsyncTaskParallel clN = null;
    private BdAsyncTaskParallel clO = null;
    private float clP = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int clQ;
        public long clR;

        private a() {
            this.clQ = 0;
            this.clR = 0L;
        }
    }

    public static j anm() {
        if (clL == null) {
            clL = new j();
        }
        return clL;
    }

    public synchronized void o(int i, long j) {
        a aVar = new a();
        aVar.clQ = i;
        aVar.clR = j;
        this.clM.offer(aVar);
        if (this.clM.size() > 5) {
            this.clM.poll();
        }
        if (ann()) {
            int i2 = 0;
            for (a aVar2 : this.clM) {
                i2 = j > 0 ? (int) ((aVar2.clQ / aVar2.clR) + i2) : i2;
            }
            this.clP = i2 / 5;
        }
    }

    public boolean ann() {
        return this.clM.size() == 5;
    }

    public BdAsyncTaskParallel fX() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (ann() && this.clP < 20.0f) {
            if (this.clN == null) {
                this.clN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.clN;
        }
        if (this.clO == null) {
            this.clO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.clO;
    }
}
