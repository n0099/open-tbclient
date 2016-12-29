package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h adt = null;
    private Queue<a> adu = new LinkedList();
    private BdAsyncTaskParallel adv = null;
    private BdAsyncTaskParallel adw = null;
    private float adx = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int ady;
        public long adz;

        private a() {
            this.ady = 0;
            this.adz = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vR() {
        if (adt == null) {
            adt = new h();
        }
        return adt;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.ady = i;
        aVar.adz = j;
        this.adu.offer(aVar);
        if (this.adu.size() > 5) {
            this.adu.poll();
        }
        if (vS()) {
            int i2 = 0;
            for (a aVar2 : this.adu) {
                if (j > 0) {
                    i2 = (int) ((aVar2.ady / aVar2.adz) + i2);
                }
            }
            this.adx = i2 / 5;
        }
    }

    public boolean vS() {
        return this.adu.size() == 5;
    }

    public BdAsyncTaskParallel eE() {
        if (!com.baidu.adp.lib.util.i.gp()) {
            return null;
        }
        if (vS() && this.adx < 20.0f) {
            if (this.adv == null) {
                this.adv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.adv;
        }
        if (this.adw == null) {
            this.adw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.adw;
    }
}
