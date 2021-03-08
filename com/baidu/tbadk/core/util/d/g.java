package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class g {
    private static g fet = null;
    private Queue<a> feu = new LinkedList();
    private BdAsyncTaskParallel fev = null;
    private BdAsyncTaskParallel few = null;
    private float fex = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int fey;
        public long fez;

        private a() {
            this.fey = 0;
            this.fez = 0L;
        }
    }

    public static g btu() {
        if (fet == null) {
            fet = new g();
        }
        return fet;
    }

    public synchronized void u(int i, long j) {
        a aVar = new a();
        aVar.fey = i;
        aVar.fez = j;
        this.feu.offer(aVar);
        if (this.feu.size() > 5) {
            this.feu.poll();
        }
        if (btv()) {
            int i2 = 0;
            for (a aVar2 : this.feu) {
                i2 = j > 0 ? (int) ((aVar2.fey / aVar2.fez) + i2) : i2;
            }
            this.fex = i2 / 5;
        }
    }

    public boolean btv() {
        return this.feu.size() == 5;
    }

    public BdAsyncTaskParallel my() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (btv() && this.fex < 20.0f) {
            if (this.fev == null) {
                this.fev = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.fev;
        }
        if (this.few == null) {
            this.few = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.few;
    }
}
