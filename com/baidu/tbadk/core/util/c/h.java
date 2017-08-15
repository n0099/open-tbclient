package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ajR = null;
    private Queue<a> ajS = new LinkedList();
    private BdAsyncTaskParallel ajT = null;
    private BdAsyncTaskParallel ajU = null;
    private float ajV = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajW;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajW = 0L;
        }
    }

    public static h wx() {
        if (ajR == null) {
            ajR = new h();
        }
        return ajR;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajW = j;
        this.ajS.offer(aVar);
        if (this.ajS.size() > 5) {
            this.ajS.poll();
        }
        if (wy()) {
            int i2 = 0;
            for (a aVar2 : this.ajS) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajW) + i2) : i2;
            }
            this.ajV = i2 / 5;
        }
    }

    public boolean wy() {
        return this.ajS.size() == 5;
    }

    public BdAsyncTaskParallel fY() {
        if (!com.baidu.adp.lib.util.i.hu()) {
            return null;
        }
        if (wy() && this.ajV < 20.0f) {
            if (this.ajT == null) {
                this.ajT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajT;
        }
        if (this.ajU == null) {
            this.ajU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajU;
    }
}
