package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i acH = null;
    private Queue<a> acI = new LinkedList();
    private BdAsyncTaskParallel acJ = null;
    private BdAsyncTaskParallel acK = null;
    private float acL = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long acM;
        public int uL;

        private a() {
            this.uL = 0;
            this.acM = 0L;
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }

    public static i vp() {
        if (acH == null) {
            acH = new i();
        }
        return acH;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.uL = i;
        aVar.acM = j;
        this.acI.offer(aVar);
        if (this.acI.size() > 5) {
            this.acI.poll();
        }
        if (vq()) {
            int i2 = 0;
            for (a aVar2 : this.acI) {
                if (j > 0) {
                    i2 = (int) ((aVar2.uL / aVar2.acM) + i2);
                }
            }
            this.acL = i2 / 5;
        }
    }

    public boolean vq() {
        return this.acI.size() == 5;
    }

    public BdAsyncTaskParallel hd() {
        if (!com.baidu.adp.lib.util.i.iO()) {
            return null;
        }
        if (vq() && this.acL < 20.0f) {
            if (this.acJ == null) {
                this.acJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.acJ;
        }
        if (this.acK == null) {
            this.acK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.acK;
    }
}
