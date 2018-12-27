package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j aEy = null;
    private Queue<a> aEz = new LinkedList();
    private BdAsyncTaskParallel aEA = null;
    private BdAsyncTaskParallel aEB = null;
    private float aEC = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aED;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aED = 0L;
        }
    }

    public static j Ez() {
        if (aEy == null) {
            aEy = new j();
        }
        return aEy;
    }

    public synchronized void h(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aED = j;
        this.aEz.offer(aVar);
        if (this.aEz.size() > 5) {
            this.aEz.poll();
        }
        if (EA()) {
            int i2 = 0;
            for (a aVar2 : this.aEz) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aED) + i2) : i2;
            }
            this.aEC = i2 / 5;
        }
    }

    public boolean EA() {
        return this.aEz.size() == 5;
    }

    public BdAsyncTaskParallel jE() {
        if (!com.baidu.adp.lib.util.j.kY()) {
            return null;
        }
        if (EA() && this.aEC < 20.0f) {
            if (this.aEA == null) {
                this.aEA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aEA;
        }
        if (this.aEB == null) {
            this.aEB = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aEB;
    }
}
