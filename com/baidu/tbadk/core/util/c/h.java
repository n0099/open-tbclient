package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aii = null;
    private Queue<a> aij = new LinkedList();
    private BdAsyncTaskParallel aik = null;
    private BdAsyncTaskParallel ail = null;
    private float aim = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ain;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ain = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wF() {
        if (aii == null) {
            aii = new h();
        }
        return aii;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.ain = j;
        this.aij.offer(aVar);
        if (this.aij.size() > 5) {
            this.aij.poll();
        }
        if (wG()) {
            int i2 = 0;
            for (a aVar2 : this.aij) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.ain) + i2);
                }
            }
            this.aim = i2 / 5;
        }
    }

    public boolean wG() {
        return this.aij.size() == 5;
    }

    public BdAsyncTaskParallel fP() {
        if (!com.baidu.adp.lib.util.i.hm()) {
            return null;
        }
        if (wG() && this.aim < 20.0f) {
            if (this.aik == null) {
                this.aik = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aik;
        }
        if (this.ail == null) {
            this.ail = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ail;
    }
}
