package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ajP = null;
    private Queue<a> ajQ = new LinkedList();
    private BdAsyncTaskParallel ajR = null;
    private BdAsyncTaskParallel ajS = null;
    private float ajT = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajU;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajU = 0L;
        }
    }

    public static h wx() {
        if (ajP == null) {
            ajP = new h();
        }
        return ajP;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajU = j;
        this.ajQ.offer(aVar);
        if (this.ajQ.size() > 5) {
            this.ajQ.poll();
        }
        if (wy()) {
            int i2 = 0;
            for (a aVar2 : this.ajQ) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajU) + i2) : i2;
            }
            this.ajT = i2 / 5;
        }
    }

    public boolean wy() {
        return this.ajQ.size() == 5;
    }

    public BdAsyncTaskParallel fY() {
        if (!com.baidu.adp.lib.util.i.hu()) {
            return null;
        }
        if (wy() && this.ajT < 20.0f) {
            if (this.ajR == null) {
                this.ajR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajR;
        }
        if (this.ajS == null) {
            this.ajS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajS;
    }
}
