package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aXA = null;
    private Queue<a> aXB = new LinkedList();
    private BdAsyncTaskParallel aXC = null;
    private BdAsyncTaskParallel aXD = null;
    private float aXE = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aXF;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aXF = 0L;
        }
    }

    public static i DA() {
        if (aXA == null) {
            aXA = new i();
        }
        return aXA;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aXF = j;
        this.aXB.offer(aVar);
        if (this.aXB.size() > 5) {
            this.aXB.poll();
        }
        if (DB()) {
            int i2 = 0;
            for (a aVar2 : this.aXB) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aXF) + i2) : i2;
            }
            this.aXE = i2 / 5;
        }
    }

    public boolean DB() {
        return this.aXB.size() == 5;
    }

    public BdAsyncTaskParallel np() {
        if (!com.baidu.adp.lib.util.j.oL()) {
            return null;
        }
        if (DB() && this.aXE < 20.0f) {
            if (this.aXC == null) {
                this.aXC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aXC;
        }
        if (this.aXD == null) {
            this.aXD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aXD;
    }
}
