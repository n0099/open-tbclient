package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h adr = null;
    private Queue<a> ads = new LinkedList();
    private BdAsyncTaskParallel adt = null;
    private BdAsyncTaskParallel adu = null;
    private float adv = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int adw;
        public long adx;

        private a() {
            this.adw = 0;
            this.adx = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vP() {
        if (adr == null) {
            adr = new h();
        }
        return adr;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.adw = i;
        aVar.adx = j;
        this.ads.offer(aVar);
        if (this.ads.size() > 5) {
            this.ads.poll();
        }
        if (vQ()) {
            int i2 = 0;
            for (a aVar2 : this.ads) {
                if (j > 0) {
                    i2 = (int) ((aVar2.adw / aVar2.adx) + i2);
                }
            }
            this.adv = i2 / 5;
        }
    }

    public boolean vQ() {
        return this.ads.size() == 5;
    }

    public BdAsyncTaskParallel eE() {
        if (!com.baidu.adp.lib.util.i.gp()) {
            return null;
        }
        if (vQ() && this.adv < 20.0f) {
            if (this.adt == null) {
                this.adt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.adt;
        }
        if (this.adu == null) {
            this.adu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.adu;
    }
}
