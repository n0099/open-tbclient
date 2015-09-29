package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i acG = null;
    private Queue<a> acH = new LinkedList();
    private BdAsyncTaskParallel acI = null;
    private BdAsyncTaskParallel acJ = null;
    private float acK = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long acL;
        public int uL;

        private a() {
            this.uL = 0;
            this.acL = 0L;
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }

    public static i vn() {
        if (acG == null) {
            acG = new i();
        }
        return acG;
    }

    public void c(int i, long j) {
        a aVar = new a(this, null);
        aVar.uL = i;
        aVar.acL = j;
        this.acH.offer(aVar);
        if (this.acH.size() > 5) {
            this.acH.poll();
        }
        if (vo()) {
            int i2 = 0;
            for (a aVar2 : this.acH) {
                if (j > 0) {
                    i2 = (int) ((aVar2.uL / aVar2.acL) + i2);
                }
            }
            this.acK = i2 / 5;
        }
    }

    public boolean vo() {
        return this.acH.size() == 5;
    }

    public BdAsyncTaskParallel he() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            return null;
        }
        if (vo() && this.acK < 20.0f) {
            if (this.acI == null) {
                this.acI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.acI;
        }
        if (this.acJ == null) {
            this.acJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.acJ;
    }
}
