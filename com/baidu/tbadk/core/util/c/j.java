package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dBz = null;
    private Queue<a> dBA = new LinkedList();
    private BdAsyncTaskParallel dBB = null;
    private BdAsyncTaskParallel dBC = null;
    private float dBD = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dBE;
        public long dBF;

        private a() {
            this.dBE = 0;
            this.dBF = 0L;
        }
    }

    public static j aPn() {
        if (dBz == null) {
            dBz = new j();
        }
        return dBz;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dBE = i;
        aVar.dBF = j;
        this.dBA.offer(aVar);
        if (this.dBA.size() > 5) {
            this.dBA.poll();
        }
        if (aPo()) {
            int i2 = 0;
            for (a aVar2 : this.dBA) {
                i2 = j > 0 ? (int) ((aVar2.dBE / aVar2.dBF) + i2) : i2;
            }
            this.dBD = i2 / 5;
        }
    }

    public boolean aPo() {
        return this.dBA.size() == 5;
    }

    public BdAsyncTaskParallel kZ() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aPo() && this.dBD < 20.0f) {
            if (this.dBB == null) {
                this.dBB = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dBB;
        }
        if (this.dBC == null) {
            this.dBC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dBC;
    }
}
