package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j aAi = null;
    private Queue<a> aAj = new LinkedList();
    private BdAsyncTaskParallel aAk = null;
    private BdAsyncTaskParallel aAl = null;
    private float aAm = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aAn;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aAn = 0L;
        }
    }

    public static j Do() {
        if (aAi == null) {
            aAi = new j();
        }
        return aAi;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aAn = j;
        this.aAj.offer(aVar);
        if (this.aAj.size() > 5) {
            this.aAj.poll();
        }
        if (Dp()) {
            int i2 = 0;
            for (a aVar2 : this.aAj) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aAn) + i2) : i2;
            }
            this.aAm = i2 / 5;
        }
    }

    public boolean Dp() {
        return this.aAj.size() == 5;
    }

    public BdAsyncTaskParallel jG() {
        if (!com.baidu.adp.lib.util.j.la()) {
            return null;
        }
        if (Dp() && this.aAm < 20.0f) {
            if (this.aAk == null) {
                this.aAk = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aAk;
        }
        if (this.aAl == null) {
            this.aAl = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aAl;
    }
}
