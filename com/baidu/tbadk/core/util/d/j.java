package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j cXs = null;
    private Queue<a> cXt = new LinkedList();
    private BdAsyncTaskParallel cXu = null;
    private BdAsyncTaskParallel cXv = null;
    private float cXw = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int cXx;
        public long cXy;

        private a() {
            this.cXx = 0;
            this.cXy = 0L;
        }
    }

    public static j aEp() {
        if (cXs == null) {
            cXs = new j();
        }
        return cXs;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.cXx = i;
        aVar.cXy = j;
        this.cXt.offer(aVar);
        if (this.cXt.size() > 5) {
            this.cXt.poll();
        }
        if (aEq()) {
            int i2 = 0;
            for (a aVar2 : this.cXt) {
                i2 = j > 0 ? (int) ((aVar2.cXx / aVar2.cXy) + i2) : i2;
            }
            this.cXw = i2 / 5;
        }
    }

    public boolean aEq() {
        return this.cXt.size() == 5;
    }

    public BdAsyncTaskParallel gw() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aEq() && this.cXw < 20.0f) {
            if (this.cXu == null) {
                this.cXu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.cXu;
        }
        if (this.cXv == null) {
            this.cXv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.cXv;
    }
}
