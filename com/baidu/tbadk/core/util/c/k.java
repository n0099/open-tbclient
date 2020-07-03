package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k dWz = null;
    private Queue<a> dWA = new LinkedList();
    private BdAsyncTaskParallel dWB = null;
    private BdAsyncTaskParallel dWC = null;
    private float dWD = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dWE;
        public long dWF;

        private a() {
            this.dWE = 0;
            this.dWF = 0L;
        }
    }

    public static k aXm() {
        if (dWz == null) {
            dWz = new k();
        }
        return dWz;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.dWE = i;
        aVar.dWF = j;
        this.dWA.offer(aVar);
        if (this.dWA.size() > 5) {
            this.dWA.poll();
        }
        if (aXn()) {
            int i2 = 0;
            for (a aVar2 : this.dWA) {
                i2 = j > 0 ? (int) ((aVar2.dWE / aVar2.dWF) + i2) : i2;
            }
            this.dWD = i2 / 5;
        }
    }

    public boolean aXn() {
        return this.dWA.size() == 5;
    }

    public BdAsyncTaskParallel lr() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aXn() && this.dWD < 20.0f) {
            if (this.dWB == null) {
                this.dWB = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dWB;
        }
        if (this.dWC == null) {
            this.dWC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dWC;
    }
}
