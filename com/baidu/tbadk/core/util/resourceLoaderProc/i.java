package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i WP = null;
    private final int WO = 20;
    private Queue<j> WQ = new LinkedList();
    private BdAsyncTaskParallel WR = null;
    private BdAsyncTaskParallel WS = null;
    private float WT = 0.0f;

    public static i tB() {
        if (WP == null) {
            WP = new i();
        }
        return WP;
    }

    public void c(int i, long j) {
        j jVar = new j(this, null);
        jVar.vF = i;
        jVar.WU = j;
        this.WQ.offer(jVar);
        if (this.WQ.size() > 5) {
            this.WQ.poll();
        }
        if (tC()) {
            int i2 = 0;
            for (j jVar2 : this.WQ) {
                if (j > 0) {
                    i2 = (int) ((jVar2.vF / jVar2.WU) + i2);
                }
            }
            this.WT = i2 / 5;
        }
    }

    public boolean tC() {
        return this.WQ.size() == 5;
    }

    public BdAsyncTaskParallel hF() {
        if (!com.baidu.adp.lib.util.k.iK()) {
            return null;
        }
        if (tC() && this.WT < 20.0f) {
            if (this.WR == null) {
                this.WR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.WR;
        }
        if (this.WS == null) {
            this.WS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.WS;
    }
}
