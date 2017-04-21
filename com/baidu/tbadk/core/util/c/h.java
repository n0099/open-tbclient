package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aij = null;
    private Queue<a> aik = new LinkedList();
    private BdAsyncTaskParallel ail = null;
    private BdAsyncTaskParallel aim = null;
    private float ain = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aio;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aio = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wF() {
        if (aij == null) {
            aij = new h();
        }
        return aij;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.aio = j;
        this.aik.offer(aVar);
        if (this.aik.size() > 5) {
            this.aik.poll();
        }
        if (wG()) {
            int i2 = 0;
            for (a aVar2 : this.aik) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.aio) + i2);
                }
            }
            this.ain = i2 / 5;
        }
    }

    public boolean wG() {
        return this.aik.size() == 5;
    }

    public BdAsyncTaskParallel fQ() {
        if (!com.baidu.adp.lib.util.i.hn()) {
            return null;
        }
        if (wG() && this.ain < 20.0f) {
            if (this.ail == null) {
                this.ail = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ail;
        }
        if (this.aim == null) {
            this.aim = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aim;
    }
}
