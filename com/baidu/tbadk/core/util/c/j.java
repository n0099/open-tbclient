package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dPG = null;
    private Queue<a> dPH = new LinkedList();
    private BdAsyncTaskParallel dPI = null;
    private BdAsyncTaskParallel dPJ = null;
    private float dPK = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dPL;
        public long dPM;

        private a() {
            this.dPL = 0;
            this.dPM = 0L;
        }
    }

    public static j aVs() {
        if (dPG == null) {
            dPG = new j();
        }
        return dPG;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dPL = i;
        aVar.dPM = j;
        this.dPH.offer(aVar);
        if (this.dPH.size() > 5) {
            this.dPH.poll();
        }
        if (aVt()) {
            int i2 = 0;
            for (a aVar2 : this.dPH) {
                i2 = j > 0 ? (int) ((aVar2.dPL / aVar2.dPM) + i2) : i2;
            }
            this.dPK = i2 / 5;
        }
    }

    public boolean aVt() {
        return this.dPH.size() == 5;
    }

    public BdAsyncTaskParallel lb() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aVt() && this.dPK < 20.0f) {
            if (this.dPI == null) {
                this.dPI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dPI;
        }
        if (this.dPJ == null) {
            this.dPJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dPJ;
    }
}
