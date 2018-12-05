package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j aEx = null;
    private Queue<a> aEy = new LinkedList();
    private BdAsyncTaskParallel aEz = null;
    private BdAsyncTaskParallel aEA = null;
    private float aEB = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aEC;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aEC = 0L;
        }
    }

    public static j Ez() {
        if (aEx == null) {
            aEx = new j();
        }
        return aEx;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aEC = j;
        this.aEy.offer(aVar);
        if (this.aEy.size() > 5) {
            this.aEy.poll();
        }
        if (EA()) {
            int i2 = 0;
            for (a aVar2 : this.aEy) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aEC) + i2) : i2;
            }
            this.aEB = i2 / 5;
        }
    }

    public boolean EA() {
        return this.aEy.size() == 5;
    }

    public BdAsyncTaskParallel jE() {
        if (!com.baidu.adp.lib.util.j.kY()) {
            return null;
        }
        if (EA() && this.aEB < 20.0f) {
            if (this.aEz == null) {
                this.aEz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aEz;
        }
        if (this.aEA == null) {
            this.aEA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aEA;
    }
}
