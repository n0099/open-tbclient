package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aea = null;
    private Queue<a> aeb = new LinkedList();
    private BdAsyncTaskParallel aec = null;
    private BdAsyncTaskParallel aed = null;
    private float aee = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int aef;
        public long aeg;

        private a() {
            this.aef = 0;
            this.aeg = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h wh() {
        if (aea == null) {
            aea = new h();
        }
        return aea;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.aef = i;
        aVar.aeg = j;
        this.aeb.offer(aVar);
        if (this.aeb.size() > 5) {
            this.aeb.poll();
        }
        if (wi()) {
            int i2 = 0;
            for (a aVar2 : this.aeb) {
                if (j > 0) {
                    i2 = (int) ((aVar2.aef / aVar2.aeg) + i2);
                }
            }
            this.aee = i2 / 5;
        }
    }

    public boolean wi() {
        return this.aeb.size() == 5;
    }

    public BdAsyncTaskParallel eE() {
        if (!com.baidu.adp.lib.util.i.gp()) {
            return null;
        }
        if (wi() && this.aee < 20.0f) {
            if (this.aec == null) {
                this.aec = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aec;
        }
        if (this.aed == null) {
            this.aed = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aed;
    }
}
