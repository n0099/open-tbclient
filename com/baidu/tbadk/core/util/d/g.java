package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class g {
    private static g faE = null;
    private Queue<a> faF = new LinkedList();
    private BdAsyncTaskParallel faG = null;
    private BdAsyncTaskParallel faH = null;
    private float faI = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int faJ;
        public long faK;

        private a() {
            this.faJ = 0;
            this.faK = 0L;
        }
    }

    public static g bsX() {
        if (faE == null) {
            faE = new g();
        }
        return faE;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.faJ = i;
        aVar.faK = j;
        this.faF.offer(aVar);
        if (this.faF.size() > 5) {
            this.faF.poll();
        }
        if (bsY()) {
            int i2 = 0;
            for (a aVar2 : this.faF) {
                i2 = j > 0 ? (int) ((aVar2.faJ / aVar2.faK) + i2) : i2;
            }
            this.faI = i2 / 5;
        }
    }

    public boolean bsY() {
        return this.faF.size() == 5;
    }

    public BdAsyncTaskParallel mz() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bsY() && this.faI < 20.0f) {
            if (this.faG == null) {
                this.faG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.faG;
        }
        if (this.faH == null) {
            this.faH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.faH;
    }
}
