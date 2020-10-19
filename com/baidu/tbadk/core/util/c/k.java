package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k eBm = null;
    private Queue<a> eBn = new LinkedList();
    private BdAsyncTaskParallel eBo = null;
    private BdAsyncTaskParallel eBp = null;
    private float eBq = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int eBr;
        public long eBs;

        private a() {
            this.eBr = 0;
            this.eBs = 0L;
        }
    }

    public static k bnr() {
        if (eBm == null) {
            eBm = new k();
        }
        return eBm;
    }

    public synchronized void u(int i, long j) {
        a aVar = new a();
        aVar.eBr = i;
        aVar.eBs = j;
        this.eBn.offer(aVar);
        if (this.eBn.size() > 5) {
            this.eBn.poll();
        }
        if (bns()) {
            int i2 = 0;
            for (a aVar2 : this.eBn) {
                i2 = j > 0 ? (int) ((aVar2.eBr / aVar2.eBs) + i2) : i2;
            }
            this.eBq = i2 / 5;
        }
    }

    public boolean bns() {
        return this.eBn.size() == 5;
    }

    public BdAsyncTaskParallel mW() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bns() && this.eBq < 20.0f) {
            if (this.eBo == null) {
                this.eBo = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.eBo;
        }
        if (this.eBp == null) {
            this.eBp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.eBp;
    }
}
