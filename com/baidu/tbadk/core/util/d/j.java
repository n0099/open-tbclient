package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j atu = null;
    private Queue<a> atv = new LinkedList();
    private BdAsyncTaskParallel atw = null;
    private BdAsyncTaskParallel atx = null;
    private float aty = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long atz;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.atz = 0L;
        }
    }

    public static j Ao() {
        if (atu == null) {
            atu = new j();
        }
        return atu;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.atz = j;
        this.atv.offer(aVar);
        if (this.atv.size() > 5) {
            this.atv.poll();
        }
        if (Ap()) {
            int i2 = 0;
            for (a aVar2 : this.atv) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.atz) + i2) : i2;
            }
            this.aty = i2 / 5;
        }
    }

    public boolean Ap() {
        return this.atv.size() == 5;
    }

    public BdAsyncTaskParallel ik() {
        if (!com.baidu.adp.lib.util.j.jG()) {
            return null;
        }
        if (Ap() && this.aty < 20.0f) {
            if (this.atw == null) {
                this.atw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.atw;
        }
        if (this.atx == null) {
            this.atx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.atx;
    }
}
