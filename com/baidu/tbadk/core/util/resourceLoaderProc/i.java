package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i XA = null;
    private final int Xz = 20;
    private Queue<j> XB = new LinkedList();
    private BdAsyncTaskParallel XC = null;
    private BdAsyncTaskParallel XD = null;
    private float XE = 0.0f;

    public static i ug() {
        if (XA == null) {
            XA = new i();
        }
        return XA;
    }

    public void c(int i, long j) {
        j jVar = new j(this, null);
        jVar.uR = i;
        jVar.XF = j;
        this.XB.offer(jVar);
        if (this.XB.size() > 5) {
            this.XB.poll();
        }
        if (uh()) {
            int i2 = 0;
            for (j jVar2 : this.XB) {
                if (j > 0) {
                    i2 = (int) ((jVar2.uR / jVar2.XF) + i2);
                }
            }
            this.XE = i2 / 5;
        }
    }

    public boolean uh() {
        return this.XB.size() == 5;
    }

    public BdAsyncTaskParallel hp() {
        if (!com.baidu.adp.lib.util.k.ja()) {
            return null;
        }
        if (uh() && this.XE < 20.0f) {
            if (this.XC == null) {
                this.XC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.XC;
        }
        if (this.XD == null) {
            this.XD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.XD;
    }
}
