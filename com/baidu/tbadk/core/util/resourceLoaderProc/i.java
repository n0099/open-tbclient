package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i WN = null;
    private final int WM = 20;
    private Queue<j> WO = new LinkedList();
    private BdAsyncTaskParallel WP = null;
    private BdAsyncTaskParallel WQ = null;
    private float WR = 0.0f;

    public static i tB() {
        if (WN == null) {
            WN = new i();
        }
        return WN;
    }

    public void c(int i, long j) {
        j jVar = new j(this, null);
        jVar.vF = i;
        jVar.WS = j;
        this.WO.offer(jVar);
        if (this.WO.size() > 5) {
            this.WO.poll();
        }
        if (tC()) {
            int i2 = 0;
            for (j jVar2 : this.WO) {
                if (j > 0) {
                    i2 = (int) ((jVar2.vF / jVar2.WS) + i2);
                }
            }
            this.WR = i2 / 5;
        }
    }

    public boolean tC() {
        return this.WO.size() == 5;
    }

    public BdAsyncTaskParallel hF() {
        if (!com.baidu.adp.lib.util.k.iK()) {
            return null;
        }
        if (tC() && this.WR < 20.0f) {
            if (this.WP == null) {
                this.WP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.WP;
        }
        if (this.WQ == null) {
            this.WQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.WQ;
    }
}
