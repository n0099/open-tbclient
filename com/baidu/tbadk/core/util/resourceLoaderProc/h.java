package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h adC = null;
    private Queue<a> adD = new LinkedList();
    private BdAsyncTaskParallel adE = null;
    private BdAsyncTaskParallel adF = null;
    private float adG = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int adH;
        public long adI;

        private a() {
            this.adH = 0;
            this.adI = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wd() {
        if (adC == null) {
            adC = new h();
        }
        return adC;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.adH = i;
        aVar.adI = j;
        this.adD.offer(aVar);
        if (this.adD.size() > 5) {
            this.adD.poll();
        }
        if (we()) {
            int i2 = 0;
            for (a aVar2 : this.adD) {
                if (j > 0) {
                    i2 = (int) ((aVar2.adH / aVar2.adI) + i2);
                }
            }
            this.adG = i2 / 5;
        }
    }

    public boolean we() {
        return this.adD.size() == 5;
    }

    public BdAsyncTaskParallel eE() {
        if (!com.baidu.adp.lib.util.i.gp()) {
            return null;
        }
        if (we() && this.adG < 20.0f) {
            if (this.adE == null) {
                this.adE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.adE;
        }
        if (this.adF == null) {
            this.adF = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.adF;
    }
}
