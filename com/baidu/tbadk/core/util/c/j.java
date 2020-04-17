package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dBv = null;
    private Queue<a> dBw = new LinkedList();
    private BdAsyncTaskParallel dBx = null;
    private BdAsyncTaskParallel dBy = null;
    private float dBz = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dBA;
        public long dBB;

        private a() {
            this.dBA = 0;
            this.dBB = 0L;
        }
    }

    public static j aPq() {
        if (dBv == null) {
            dBv = new j();
        }
        return dBv;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dBA = i;
        aVar.dBB = j;
        this.dBw.offer(aVar);
        if (this.dBw.size() > 5) {
            this.dBw.poll();
        }
        if (aPr()) {
            int i2 = 0;
            for (a aVar2 : this.dBw) {
                i2 = j > 0 ? (int) ((aVar2.dBA / aVar2.dBB) + i2) : i2;
            }
            this.dBz = i2 / 5;
        }
    }

    public boolean aPr() {
        return this.dBw.size() == 5;
    }

    public BdAsyncTaskParallel kZ() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aPr() && this.dBz < 20.0f) {
            if (this.dBx == null) {
                this.dBx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dBx;
        }
        if (this.dBy == null) {
            this.dBy = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dBy;
    }
}
