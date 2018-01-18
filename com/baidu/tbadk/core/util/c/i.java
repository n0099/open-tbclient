package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aXz = null;
    private Queue<a> aXA = new LinkedList();
    private BdAsyncTaskParallel aXB = null;
    private BdAsyncTaskParallel aXC = null;
    private float aXD = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aXE;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aXE = 0L;
        }
    }

    public static i Dr() {
        if (aXz == null) {
            aXz = new i();
        }
        return aXz;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aXE = j;
        this.aXA.offer(aVar);
        if (this.aXA.size() > 5) {
            this.aXA.poll();
        }
        if (Ds()) {
            int i2 = 0;
            for (a aVar2 : this.aXA) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aXE) + i2) : i2;
            }
            this.aXD = i2 / 5;
        }
    }

    public boolean Ds() {
        return this.aXA.size() == 5;
    }

    public BdAsyncTaskParallel np() {
        if (!com.baidu.adp.lib.util.j.oL()) {
            return null;
        }
        if (Ds() && this.aXD < 20.0f) {
            if (this.aXB == null) {
                this.aXB = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aXB;
        }
        if (this.aXC == null) {
            this.aXC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aXC;
    }
}
