package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class g {
    private static g fcU = null;
    private Queue<a> fcV = new LinkedList();
    private BdAsyncTaskParallel fcW = null;
    private BdAsyncTaskParallel fcX = null;
    private float fcY = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int fcZ;
        public long fda;

        private a() {
            this.fcZ = 0;
            this.fda = 0L;
        }
    }

    public static g btr() {
        if (fcU == null) {
            fcU = new g();
        }
        return fcU;
    }

    public synchronized void u(int i, long j) {
        a aVar = new a();
        aVar.fcZ = i;
        aVar.fda = j;
        this.fcV.offer(aVar);
        if (this.fcV.size() > 5) {
            this.fcV.poll();
        }
        if (bts()) {
            int i2 = 0;
            for (a aVar2 : this.fcV) {
                i2 = j > 0 ? (int) ((aVar2.fcZ / aVar2.fda) + i2) : i2;
            }
            this.fcY = i2 / 5;
        }
    }

    public boolean bts() {
        return this.fcV.size() == 5;
    }

    public BdAsyncTaskParallel my() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bts() && this.fcY < 20.0f) {
            if (this.fcW == null) {
                this.fcW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.fcW;
        }
        if (this.fcX == null) {
            this.fcX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.fcX;
    }
}
