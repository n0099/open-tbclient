package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aia = null;
    private Queue<a> aib = new LinkedList();
    private BdAsyncTaskParallel aic = null;
    private BdAsyncTaskParallel aid = null;
    private float aie = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aif;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aif = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wh() {
        if (aia == null) {
            aia = new h();
        }
        return aia;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.aif = j;
        this.aib.offer(aVar);
        if (this.aib.size() > 5) {
            this.aib.poll();
        }
        if (wi()) {
            int i2 = 0;
            for (a aVar2 : this.aib) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.aif) + i2);
                }
            }
            this.aie = i2 / 5;
        }
    }

    public boolean wi() {
        return this.aib.size() == 5;
    }

    public BdAsyncTaskParallel fP() {
        if (!com.baidu.adp.lib.util.i.hm()) {
            return null;
        }
        if (wi() && this.aie < 20.0f) {
            if (this.aic == null) {
                this.aic = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aic;
        }
        if (this.aid == null) {
            this.aid = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aid;
    }
}
