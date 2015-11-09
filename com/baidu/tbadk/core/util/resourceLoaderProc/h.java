package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h acM = null;
    private Queue<a> acN = new LinkedList();
    private BdAsyncTaskParallel acO = null;
    private BdAsyncTaskParallel acP = null;
    private float acQ = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long acR;
        public int uL;

        private a() {
            this.uL = 0;
            this.acR = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vo() {
        if (acM == null) {
            acM = new h();
        }
        return acM;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.uL = i;
        aVar.acR = j;
        this.acN.offer(aVar);
        if (this.acN.size() > 5) {
            this.acN.poll();
        }
        if (vp()) {
            int i2 = 0;
            for (a aVar2 : this.acN) {
                if (j > 0) {
                    i2 = (int) ((aVar2.uL / aVar2.acR) + i2);
                }
            }
            this.acQ = i2 / 5;
        }
    }

    public boolean vp() {
        return this.acN.size() == 5;
    }

    public BdAsyncTaskParallel hf() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            return null;
        }
        if (vp() && this.acQ < 20.0f) {
            if (this.acO == null) {
                this.acO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.acO;
        }
        if (this.acP == null) {
            this.acP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.acP;
    }
}
