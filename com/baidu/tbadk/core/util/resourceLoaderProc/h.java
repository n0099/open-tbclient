package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aed = null;
    private Queue<a> aee = new LinkedList();
    private BdAsyncTaskParallel aef = null;
    private BdAsyncTaskParallel aeg = null;
    private float aeh = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int aei;
        public long aej;

        private a() {
            this.aei = 0;
            this.aej = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h xe() {
        if (aed == null) {
            aed = new h();
        }
        return aed;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.aei = i;
        aVar.aej = j;
        this.aee.offer(aVar);
        if (this.aee.size() > 5) {
            this.aee.poll();
        }
        if (xf()) {
            int i2 = 0;
            for (a aVar2 : this.aee) {
                if (j > 0) {
                    i2 = (int) ((aVar2.aei / aVar2.aej) + i2);
                }
            }
            this.aeh = i2 / 5;
        }
    }

    public boolean xf() {
        return this.aee.size() == 5;
    }

    public BdAsyncTaskParallel hv() {
        if (!com.baidu.adp.lib.util.i.ji()) {
            return null;
        }
        if (xf() && this.aeh < 20.0f) {
            if (this.aef == null) {
                this.aef = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aef;
        }
        if (this.aeg == null) {
            this.aeg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aeg;
    }
}
