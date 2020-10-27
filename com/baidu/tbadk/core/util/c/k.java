package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k eJI = null;
    private Queue<a> eJJ = new LinkedList();
    private BdAsyncTaskParallel eJK = null;
    private BdAsyncTaskParallel eJL = null;
    private float eJM = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int eJN;
        public long eJO;

        private a() {
            this.eJN = 0;
            this.eJO = 0L;
        }
    }

    public static k bpk() {
        if (eJI == null) {
            eJI = new k();
        }
        return eJI;
    }

    public synchronized void u(int i, long j) {
        a aVar = new a();
        aVar.eJN = i;
        aVar.eJO = j;
        this.eJJ.offer(aVar);
        if (this.eJJ.size() > 5) {
            this.eJJ.poll();
        }
        if (bpl()) {
            int i2 = 0;
            for (a aVar2 : this.eJJ) {
                i2 = j > 0 ? (int) ((aVar2.eJN / aVar2.eJO) + i2) : i2;
            }
            this.eJM = i2 / 5;
        }
    }

    public boolean bpl() {
        return this.eJJ.size() == 5;
    }

    public BdAsyncTaskParallel mW() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bpl() && this.eJM < 20.0f) {
            if (this.eJK == null) {
                this.eJK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.eJK;
        }
        if (this.eJL == null) {
            this.eJL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.eJL;
    }
}
