package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ahB = null;
    private Queue<a> ahC = new LinkedList();
    private BdAsyncTaskParallel ahD = null;
    private BdAsyncTaskParallel ahE = null;
    private float ahF = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ahG;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ahG = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vT() {
        if (ahB == null) {
            ahB = new h();
        }
        return ahB;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.ahG = j;
        this.ahC.offer(aVar);
        if (this.ahC.size() > 5) {
            this.ahC.poll();
        }
        if (vU()) {
            int i2 = 0;
            for (a aVar2 : this.ahC) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.ahG) + i2);
                }
            }
            this.ahF = i2 / 5;
        }
    }

    public boolean vU() {
        return this.ahC.size() == 5;
    }

    public BdAsyncTaskParallel fQ() {
        if (!com.baidu.adp.lib.util.i.hn()) {
            return null;
        }
        if (vU() && this.ahF < 20.0f) {
            if (this.ahD == null) {
                this.ahD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ahD;
        }
        if (this.ahE == null) {
            this.ahE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ahE;
    }
}
