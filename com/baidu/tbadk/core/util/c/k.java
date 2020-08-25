package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes2.dex */
public class k {
    private static k emD = null;
    private Queue<a> emE = new LinkedList();
    private BdAsyncTaskParallel emF = null;
    private BdAsyncTaskParallel emG = null;
    private float emH = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public int emI;
        public long emJ;

        private a() {
            this.emI = 0;
            this.emJ = 0L;
        }
    }

    public static k bjM() {
        if (emD == null) {
            emD = new k();
        }
        return emD;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.emI = i;
        aVar.emJ = j;
        this.emE.offer(aVar);
        if (this.emE.size() > 5) {
            this.emE.poll();
        }
        if (bjN()) {
            int i2 = 0;
            for (a aVar2 : this.emE) {
                i2 = j > 0 ? (int) ((aVar2.emI / aVar2.emJ) + i2) : i2;
            }
            this.emH = i2 / 5;
        }
    }

    public boolean bjN() {
        return this.emE.size() == 5;
    }

    public BdAsyncTaskParallel mQ() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bjN() && this.emH < 20.0f) {
            if (this.emF == null) {
                this.emF = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.emF;
        }
        if (this.emG == null) {
            this.emG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.emG;
    }
}
