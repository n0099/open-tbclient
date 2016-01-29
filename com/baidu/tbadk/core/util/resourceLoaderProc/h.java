package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aeI = null;
    private Queue<a> aeJ = new LinkedList();
    private BdAsyncTaskParallel aeK = null;
    private BdAsyncTaskParallel aeL = null;
    private float aeM = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int aeN;
        public long aeO;

        private a() {
            this.aeN = 0;
            this.aeO = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wL() {
        if (aeI == null) {
            aeI = new h();
        }
        return aeI;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.aeN = i;
        aVar.aeO = j;
        this.aeJ.offer(aVar);
        if (this.aeJ.size() > 5) {
            this.aeJ.poll();
        }
        if (wM()) {
            int i2 = 0;
            for (a aVar2 : this.aeJ) {
                if (j > 0) {
                    i2 = (int) ((aVar2.aeN / aVar2.aeO) + i2);
                }
            }
            this.aeM = i2 / 5;
        }
    }

    public boolean wM() {
        return this.aeJ.size() == 5;
    }

    public BdAsyncTaskParallel hp() {
        if (!com.baidu.adp.lib.util.i.jc()) {
            return null;
        }
        if (wM() && this.aeM < 20.0f) {
            if (this.aeK == null) {
                this.aeK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aeK;
        }
        if (this.aeL == null) {
            this.aeL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aeL;
    }
}
