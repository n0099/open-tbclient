package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i Lo = null;
    private final int Ln = 20;
    private Queue<j> Lp = new LinkedList();
    private BdAsyncTaskParallel Lq = null;
    private BdAsyncTaskParallel Lr = null;
    private float Ls = 0.0f;

    public static i qs() {
        if (Lo == null) {
            Lo = new i();
        }
        return Lo;
    }

    public void c(int i, long j) {
        j jVar = new j(this, null);
        jVar.kq = i;
        jVar.Lt = j;
        this.Lp.offer(jVar);
        if (this.Lp.size() > 5) {
            this.Lp.poll();
        }
        if (qt()) {
            int i2 = 0;
            for (j jVar2 : this.Lp) {
                if (j > 0) {
                    i2 = (int) ((jVar2.kq / jVar2.Lt) + i2);
                }
            }
            this.Ls = i2 / 5;
        }
    }

    public boolean qt() {
        return this.Lp.size() == 5;
    }

    public BdAsyncTaskParallel eg() {
        if (!com.baidu.adp.lib.util.i.fi()) {
            return null;
        }
        if (qt() && this.Ls < 20.0f) {
            if (this.Lq == null) {
                this.Lq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.Lq;
        }
        if (this.Lr == null) {
            this.Lr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.Lr;
    }
}
