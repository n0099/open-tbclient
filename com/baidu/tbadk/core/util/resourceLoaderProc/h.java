package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h acE = null;
    private Queue<a> acF = new LinkedList();
    private BdAsyncTaskParallel acG = null;
    private BdAsyncTaskParallel acH = null;
    private float acI = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long acJ;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.acJ = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vL() {
        if (acE == null) {
            acE = new h();
        }
        return acE;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.acJ = j;
        this.acF.offer(aVar);
        if (this.acF.size() > 5) {
            this.acF.poll();
        }
        if (vM()) {
            int i2 = 0;
            for (a aVar2 : this.acF) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.acJ) + i2);
                }
            }
            this.acI = i2 / 5;
        }
    }

    public boolean vM() {
        return this.acF.size() == 5;
    }

    public BdAsyncTaskParallel eC() {
        if (!com.baidu.adp.lib.util.i.gn()) {
            return null;
        }
        if (vM() && this.acI < 20.0f) {
            if (this.acG == null) {
                this.acG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.acG;
        }
        if (this.acH == null) {
            this.acH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.acH;
    }
}
