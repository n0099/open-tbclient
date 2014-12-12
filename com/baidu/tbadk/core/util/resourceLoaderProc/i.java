package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i KU = null;
    private final int KT = 20;
    private Queue<j> KV = new LinkedList();
    private BdAsyncTaskParallel KW = null;
    private BdAsyncTaskParallel KX = null;
    private float KY = 0.0f;

    public static i qh() {
        if (KU == null) {
            KU = new i();
        }
        return KU;
    }

    public void c(int i, long j) {
        j jVar = new j(this, null);
        jVar.km = i;
        jVar.KZ = j;
        this.KV.offer(jVar);
        if (this.KV.size() > 5) {
            this.KV.poll();
        }
        if (qi()) {
            int i2 = 0;
            for (j jVar2 : this.KV) {
                if (j > 0) {
                    i2 = (int) ((jVar2.km / jVar2.KZ) + i2);
                }
            }
            this.KY = i2 / 5;
        }
    }

    public boolean qi() {
        return this.KV.size() == 5;
    }

    public BdAsyncTaskParallel ei() {
        if (!com.baidu.adp.lib.util.i.fj()) {
            return null;
        }
        if (qi() && this.KY < 20.0f) {
            if (this.KW == null) {
                this.KW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.KW;
        }
        if (this.KX == null) {
            this.KX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.KX;
    }
}
