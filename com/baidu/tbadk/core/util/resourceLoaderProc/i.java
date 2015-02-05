package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i Ll = null;
    private final int Lk = 20;
    private Queue<j> Lm = new LinkedList();
    private BdAsyncTaskParallel Ln = null;
    private BdAsyncTaskParallel Lo = null;
    private float Lp = 0.0f;

    public static i ql() {
        if (Ll == null) {
            Ll = new i();
        }
        return Ll;
    }

    public void c(int i, long j) {
        j jVar = new j(this, null);
        jVar.kq = i;
        jVar.Lq = j;
        this.Lm.offer(jVar);
        if (this.Lm.size() > 5) {
            this.Lm.poll();
        }
        if (qm()) {
            int i2 = 0;
            for (j jVar2 : this.Lm) {
                if (j > 0) {
                    i2 = (int) ((jVar2.kq / jVar2.Lq) + i2);
                }
            }
            this.Lp = i2 / 5;
        }
    }

    public boolean qm() {
        return this.Lm.size() == 5;
    }

    public BdAsyncTaskParallel eg() {
        if (!com.baidu.adp.lib.util.i.fi()) {
            return null;
        }
        if (qm() && this.Lp < 20.0f) {
            if (this.Ln == null) {
                this.Ln = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.Ln;
        }
        if (this.Lo == null) {
            this.Lo = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.Lo;
    }
}
