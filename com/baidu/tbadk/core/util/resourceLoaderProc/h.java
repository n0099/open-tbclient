package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ahU = null;
    private Queue<a> ahV = new LinkedList();
    private BdAsyncTaskParallel ahW = null;
    private BdAsyncTaskParallel ahX = null;
    private float ahY = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ahZ;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ahZ = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wi() {
        if (ahU == null) {
            ahU = new h();
        }
        return ahU;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.ahZ = j;
        this.ahV.offer(aVar);
        if (this.ahV.size() > 5) {
            this.ahV.poll();
        }
        if (wj()) {
            int i2 = 0;
            for (a aVar2 : this.ahV) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.ahZ) + i2);
                }
            }
            this.ahY = i2 / 5;
        }
    }

    public boolean wj() {
        return this.ahV.size() == 5;
    }

    public BdAsyncTaskParallel fK() {
        if (!com.baidu.adp.lib.util.i.hh()) {
            return null;
        }
        if (wj() && this.ahY < 20.0f) {
            if (this.ahW == null) {
                this.ahW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ahW;
        }
        if (this.ahX == null) {
            this.ahX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ahX;
    }
}
