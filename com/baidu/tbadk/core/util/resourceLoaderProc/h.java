package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aaB = null;
    private Queue<a> aaC = new LinkedList();
    private BdAsyncTaskParallel aaD = null;
    private BdAsyncTaskParallel aaE = null;
    private float aaF = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int aaG;
        public long aaH;

        private a() {
            this.aaG = 0;
            this.aaH = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h uK() {
        if (aaB == null) {
            aaB = new h();
        }
        return aaB;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.aaG = i;
        aVar.aaH = j;
        this.aaC.offer(aVar);
        if (this.aaC.size() > 5) {
            this.aaC.poll();
        }
        if (uL()) {
            int i2 = 0;
            for (a aVar2 : this.aaC) {
                if (j > 0) {
                    i2 = (int) ((aVar2.aaG / aVar2.aaH) + i2);
                }
            }
            this.aaF = i2 / 5;
        }
    }

    public boolean uL() {
        return this.aaC.size() == 5;
    }

    public BdAsyncTaskParallel dJ() {
        if (!com.baidu.adp.lib.util.i.ft()) {
            return null;
        }
        if (uL() && this.aaF < 20.0f) {
            if (this.aaD == null) {
                this.aaD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aaD;
        }
        if (this.aaE == null) {
            this.aaE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aaE;
    }
}
