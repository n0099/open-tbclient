package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ZB = null;
    private Queue<a> ZC = new LinkedList();
    private BdAsyncTaskParallel ZD = null;
    private BdAsyncTaskParallel ZE = null;
    private float ZF = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ZG;
        public long ZH;

        private a() {
            this.ZG = 0;
            this.ZH = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h uL() {
        if (ZB == null) {
            ZB = new h();
        }
        return ZB;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.ZG = i;
        aVar.ZH = j;
        this.ZC.offer(aVar);
        if (this.ZC.size() > 5) {
            this.ZC.poll();
        }
        if (uM()) {
            int i2 = 0;
            for (a aVar2 : this.ZC) {
                if (j > 0) {
                    i2 = (int) ((aVar2.ZG / aVar2.ZH) + i2);
                }
            }
            this.ZF = i2 / 5;
        }
    }

    public boolean uM() {
        return this.ZC.size() == 5;
    }

    public BdAsyncTaskParallel dJ() {
        if (!com.baidu.adp.lib.util.i.ft()) {
            return null;
        }
        if (uM() && this.ZF < 20.0f) {
            if (this.ZD == null) {
                this.ZD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ZD;
        }
        if (this.ZE == null) {
            this.ZE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ZE;
    }
}
