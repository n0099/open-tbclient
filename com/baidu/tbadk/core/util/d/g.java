package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class g {
    private static g ffn = null;
    private Queue<a> ffo = new LinkedList();
    private BdAsyncTaskParallel ffp = null;
    private BdAsyncTaskParallel ffq = null;
    private float ffr = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ffs;
        public long fft;

        private a() {
            this.ffs = 0;
            this.fft = 0L;
        }
    }

    public static g bwQ() {
        if (ffn == null) {
            ffn = new g();
        }
        return ffn;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.ffs = i;
        aVar.fft = j;
        this.ffo.offer(aVar);
        if (this.ffo.size() > 5) {
            this.ffo.poll();
        }
        if (bwR()) {
            int i2 = 0;
            for (a aVar2 : this.ffo) {
                i2 = j > 0 ? (int) ((aVar2.ffs / aVar2.fft) + i2) : i2;
            }
            this.ffr = i2 / 5;
        }
    }

    public boolean bwR() {
        return this.ffo.size() == 5;
    }

    public BdAsyncTaskParallel mz() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bwR() && this.ffr < 20.0f) {
            if (this.ffp == null) {
                this.ffp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ffp;
        }
        if (this.ffq == null) {
            this.ffq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ffq;
    }
}
