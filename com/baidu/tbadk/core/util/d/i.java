package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aZg = null;
    private Queue<a> aZh = new LinkedList();
    private BdAsyncTaskParallel aZi = null;
    private BdAsyncTaskParallel aZj = null;
    private float aZk = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aZl;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aZl = 0L;
        }
    }

    public static i DN() {
        if (aZg == null) {
            aZg = new i();
        }
        return aZg;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aZl = j;
        this.aZh.offer(aVar);
        if (this.aZh.size() > 5) {
            this.aZh.poll();
        }
        if (DO()) {
            int i2 = 0;
            for (a aVar2 : this.aZh) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aZl) + i2) : i2;
            }
            this.aZk = i2 / 5;
        }
    }

    public boolean DO() {
        return this.aZh.size() == 5;
    }

    public BdAsyncTaskParallel nq() {
        if (!com.baidu.adp.lib.util.j.oM()) {
            return null;
        }
        if (DO() && this.aZk < 20.0f) {
            if (this.aZi == null) {
                this.aZi = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aZi;
        }
        if (this.aZj == null) {
            this.aZj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aZj;
    }
}
