package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ZS = null;
    private Queue<a> ZT = new LinkedList();
    private BdAsyncTaskParallel ZU = null;
    private BdAsyncTaskParallel ZV = null;
    private float ZW = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ZX;
        public long ZY;

        private a() {
            this.ZX = 0;
            this.ZY = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h uK() {
        if (ZS == null) {
            ZS = new h();
        }
        return ZS;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.ZX = i;
        aVar.ZY = j;
        this.ZT.offer(aVar);
        if (this.ZT.size() > 5) {
            this.ZT.poll();
        }
        if (uL()) {
            int i2 = 0;
            for (a aVar2 : this.ZT) {
                if (j > 0) {
                    i2 = (int) ((aVar2.ZX / aVar2.ZY) + i2);
                }
            }
            this.ZW = i2 / 5;
        }
    }

    public boolean uL() {
        return this.ZT.size() == 5;
    }

    public BdAsyncTaskParallel dK() {
        if (!com.baidu.adp.lib.util.i.fu()) {
            return null;
        }
        if (uL() && this.ZW < 20.0f) {
            if (this.ZU == null) {
                this.ZU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ZU;
        }
        if (this.ZV == null) {
            this.ZV = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ZV;
    }
}
