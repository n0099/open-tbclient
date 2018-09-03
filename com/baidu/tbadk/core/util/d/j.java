package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j asZ = null;
    private Queue<a> ata = new LinkedList();
    private BdAsyncTaskParallel atb = null;
    private BdAsyncTaskParallel atc = null;
    private float atd = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ate;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ate = 0L;
        }
    }

    public static j Ac() {
        if (asZ == null) {
            asZ = new j();
        }
        return asZ;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ate = j;
        this.ata.offer(aVar);
        if (this.ata.size() > 5) {
            this.ata.poll();
        }
        if (Ad()) {
            int i2 = 0;
            for (a aVar2 : this.ata) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ate) + i2) : i2;
            }
            this.atd = i2 / 5;
        }
    }

    public boolean Ad() {
        return this.ata.size() == 5;
    }

    public BdAsyncTaskParallel il() {
        if (!com.baidu.adp.lib.util.j.jH()) {
            return null;
        }
        if (Ad() && this.atd < 20.0f) {
            if (this.atb == null) {
                this.atb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.atb;
        }
        if (this.atc == null) {
            this.atc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.atc;
    }
}
