package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h adE = null;
    private Queue<a> adF = new LinkedList();
    private BdAsyncTaskParallel adG = null;
    private BdAsyncTaskParallel adH = null;
    private float adI = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long adJ;
        public int uR;

        private a() {
            this.uR = 0;
            this.adJ = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vU() {
        if (adE == null) {
            adE = new h();
        }
        return adE;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.uR = i;
        aVar.adJ = j;
        this.adF.offer(aVar);
        if (this.adF.size() > 5) {
            this.adF.poll();
        }
        if (vV()) {
            int i2 = 0;
            for (a aVar2 : this.adF) {
                if (j > 0) {
                    i2 = (int) ((aVar2.uR / aVar2.adJ) + i2);
                }
            }
            this.adI = i2 / 5;
        }
    }

    public boolean vV() {
        return this.adF.size() == 5;
    }

    public BdAsyncTaskParallel hh() {
        if (!com.baidu.adp.lib.util.i.iS()) {
            return null;
        }
        if (vV() && this.adI < 20.0f) {
            if (this.adG == null) {
                this.adG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.adG;
        }
        if (this.adH == null) {
            this.adH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.adH;
    }
}
