package com.baidu.tbadk.core.util.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j ckU = null;
    private Queue<a> ckV = new LinkedList();
    private BdAsyncTaskParallel ckW = null;
    private BdAsyncTaskParallel ckX = null;
    private float ckY = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ckZ;
        public long cla;

        private a() {
            this.ckZ = 0;
            this.cla = 0L;
        }
    }

    public static j ank() {
        if (ckU == null) {
            ckU = new j();
        }
        return ckU;
    }

    public synchronized void m(int i, long j) {
        a aVar = new a();
        aVar.ckZ = i;
        aVar.cla = j;
        this.ckV.offer(aVar);
        if (this.ckV.size() > 5) {
            this.ckV.poll();
        }
        if (anl()) {
            int i2 = 0;
            for (a aVar2 : this.ckV) {
                i2 = j > 0 ? (int) ((aVar2.ckZ / aVar2.cla) + i2) : i2;
            }
            this.ckY = i2 / 5;
        }
    }

    public boolean anl() {
        return this.ckV.size() == 5;
    }

    public BdAsyncTaskParallel fX() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (anl() && this.ckY < 20.0f) {
            if (this.ckW == null) {
                this.ckW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ckW;
        }
        if (this.ckX == null) {
            this.ckX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ckX;
    }
}
