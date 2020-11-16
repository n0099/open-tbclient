package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k eOB = null;
    private Queue<a> eOC = new LinkedList();
    private BdAsyncTaskParallel eOD = null;
    private BdAsyncTaskParallel eOE = null;
    private float eOF = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int eOG;
        public long eOH;

        private a() {
            this.eOG = 0;
            this.eOH = 0L;
        }
    }

    public static k bqY() {
        if (eOB == null) {
            eOB = new k();
        }
        return eOB;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.eOG = i;
        aVar.eOH = j;
        this.eOC.offer(aVar);
        if (this.eOC.size() > 5) {
            this.eOC.poll();
        }
        if (bqZ()) {
            int i2 = 0;
            for (a aVar2 : this.eOC) {
                i2 = j > 0 ? (int) ((aVar2.eOG / aVar2.eOH) + i2) : i2;
            }
            this.eOF = i2 / 5;
        }
    }

    public boolean bqZ() {
        return this.eOC.size() == 5;
    }

    public BdAsyncTaskParallel mW() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bqZ() && this.eOF < 20.0f) {
            if (this.eOD == null) {
                this.eOD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.eOD;
        }
        if (this.eOE == null) {
            this.eOE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.eOE;
    }
}
