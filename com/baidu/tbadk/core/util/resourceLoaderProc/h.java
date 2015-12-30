package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aei = null;
    private Queue<a> aej = new LinkedList();
    private BdAsyncTaskParallel aek = null;
    private BdAsyncTaskParallel ael = null;
    private float aem = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int aen;
        public long aeo;

        private a() {
            this.aen = 0;
            this.aeo = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vE() {
        if (aei == null) {
            aei = new h();
        }
        return aei;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.aen = i;
        aVar.aeo = j;
        this.aej.offer(aVar);
        if (this.aej.size() > 5) {
            this.aej.poll();
        }
        if (vF()) {
            int i2 = 0;
            for (a aVar2 : this.aej) {
                if (j > 0) {
                    i2 = (int) ((aVar2.aen / aVar2.aeo) + i2);
                }
            }
            this.aem = i2 / 5;
        }
    }

    public boolean vF() {
        return this.aej.size() == 5;
    }

    public BdAsyncTaskParallel hh() {
        if (!com.baidu.adp.lib.util.i.iT()) {
            return null;
        }
        if (vF() && this.aem < 20.0f) {
            if (this.aek == null) {
                this.aek = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aek;
        }
        if (this.ael == null) {
            this.ael = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ael;
    }
}
