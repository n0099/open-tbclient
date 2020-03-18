package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j dcg = null;
    private Queue<a> dch = new LinkedList();
    private BdAsyncTaskParallel dci = null;
    private BdAsyncTaskParallel dcj = null;
    private float dck = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int dcl;
        public long dcm;

        private a() {
            this.dcl = 0;
            this.dcm = 0L;
        }
    }

    public static j aHb() {
        if (dcg == null) {
            dcg = new j();
        }
        return dcg;
    }

    public synchronized void s(int i, long j) {
        a aVar = new a();
        aVar.dcl = i;
        aVar.dcm = j;
        this.dch.offer(aVar);
        if (this.dch.size() > 5) {
            this.dch.poll();
        }
        if (aHc()) {
            int i2 = 0;
            for (a aVar2 : this.dch) {
                i2 = j > 0 ? (int) ((aVar2.dcl / aVar2.dcm) + i2) : i2;
            }
            this.dck = i2 / 5;
        }
    }

    public boolean aHc() {
        return this.dch.size() == 5;
    }

    public BdAsyncTaskParallel gv() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (aHc() && this.dck < 20.0f) {
            if (this.dci == null) {
                this.dci = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.dci;
        }
        if (this.dcj == null) {
            this.dcj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.dcj;
    }
}
