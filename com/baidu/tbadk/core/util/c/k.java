package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k ePx = null;
    private Queue<a> ePy = new LinkedList();
    private BdAsyncTaskParallel ePz = null;
    private BdAsyncTaskParallel ePA = null;
    private float ePB = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ePC;
        public long ePD;

        private a() {
            this.ePC = 0;
            this.ePD = 0L;
        }
    }

    public static k brK() {
        if (ePx == null) {
            ePx = new k();
        }
        return ePx;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.ePC = i;
        aVar.ePD = j;
        this.ePy.offer(aVar);
        if (this.ePy.size() > 5) {
            this.ePy.poll();
        }
        if (brL()) {
            int i2 = 0;
            for (a aVar2 : this.ePy) {
                i2 = j > 0 ? (int) ((aVar2.ePC / aVar2.ePD) + i2) : i2;
            }
            this.ePB = i2 / 5;
        }
    }

    public boolean brL() {
        return this.ePy.size() == 5;
    }

    public BdAsyncTaskParallel mW() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (brL() && this.ePB < 20.0f) {
            if (this.ePz == null) {
                this.ePz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ePz;
        }
        if (this.ePA == null) {
            this.ePA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ePA;
    }
}
