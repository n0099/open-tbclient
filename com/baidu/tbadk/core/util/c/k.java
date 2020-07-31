package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k ecU = null;
    private Queue<a> ecV = new LinkedList();
    private BdAsyncTaskParallel ecW = null;
    private BdAsyncTaskParallel ecX = null;
    private float ecY = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ecZ;
        public long eda;

        private a() {
            this.ecZ = 0;
            this.eda = 0L;
        }
    }

    public static k bbn() {
        if (ecU == null) {
            ecU = new k();
        }
        return ecU;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.ecZ = i;
        aVar.eda = j;
        this.ecV.offer(aVar);
        if (this.ecV.size() > 5) {
            this.ecV.poll();
        }
        if (bbo()) {
            int i2 = 0;
            for (a aVar2 : this.ecV) {
                i2 = j > 0 ? (int) ((aVar2.ecZ / aVar2.eda) + i2) : i2;
            }
            this.ecY = i2 / 5;
        }
    }

    public boolean bbo() {
        return this.ecV.size() == 5;
    }

    public BdAsyncTaskParallel lr() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bbo() && this.ecY < 20.0f) {
            if (this.ecW == null) {
                this.ecW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ecW;
        }
        if (this.ecX == null) {
            this.ecX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ecX;
    }
}
