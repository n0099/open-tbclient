package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h GJ = null;
    private final int GI = 20;
    private Queue<i> GK = new LinkedList();
    private BdAsyncTaskParallel GL = null;
    private BdAsyncTaskParallel GM = null;
    private float GN = 0.0f;

    public static h nm() {
        if (GJ == null) {
            GJ = new h();
        }
        return GJ;
    }

    public void a(int i, long j) {
        i iVar = new i(this, null);
        iVar.kl = i;
        iVar.GO = j;
        this.GK.offer(iVar);
        if (this.GK.size() > 5) {
            this.GK.poll();
        }
        if (nn()) {
            int i2 = 0;
            for (i iVar2 : this.GK) {
                if (j > 0) {
                    i2 = (int) ((iVar2.kl / iVar2.GO) + i2);
                }
            }
            this.GN = i2 / 5;
        }
    }

    public boolean nn() {
        return this.GK.size() == 5;
    }

    public BdAsyncTaskParallel ei() {
        if (!com.baidu.adp.lib.util.j.fk()) {
            return null;
        }
        if (nn() && this.GN < 20.0f) {
            if (this.GL == null) {
                this.GL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.GL;
        }
        if (this.GM == null) {
            this.GM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.GM;
    }
}
