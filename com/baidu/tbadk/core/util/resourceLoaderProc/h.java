package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h GK = null;
    private final int GJ = 20;
    private Queue<i> GL = new LinkedList();
    private BdAsyncTaskParallel GM = null;
    private BdAsyncTaskParallel GN = null;
    private float GO = 0.0f;

    public static h nm() {
        if (GK == null) {
            GK = new h();
        }
        return GK;
    }

    public void a(int i, long j) {
        i iVar = new i(this, null);
        iVar.kl = i;
        iVar.GP = j;
        this.GL.offer(iVar);
        if (this.GL.size() > 5) {
            this.GL.poll();
        }
        if (nn()) {
            int i2 = 0;
            for (i iVar2 : this.GL) {
                if (j > 0) {
                    i2 = (int) ((iVar2.kl / iVar2.GP) + i2);
                }
            }
            this.GO = i2 / 5;
        }
    }

    public boolean nn() {
        return this.GL.size() == 5;
    }

    public BdAsyncTaskParallel ei() {
        if (!com.baidu.adp.lib.util.j.fk()) {
            return null;
        }
        if (nn() && this.GO < 20.0f) {
            if (this.GM == null) {
                this.GM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.GM;
        }
        if (this.GN == null) {
            this.GN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.GN;
    }
}
