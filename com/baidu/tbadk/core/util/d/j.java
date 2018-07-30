package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j asY = null;
    private Queue<a> asZ = new LinkedList();
    private BdAsyncTaskParallel ata = null;
    private BdAsyncTaskParallel atb = null;
    private float atc = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long atd;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.atd = 0L;
        }
    }

    public static j Ae() {
        if (asY == null) {
            asY = new j();
        }
        return asY;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.atd = j;
        this.asZ.offer(aVar);
        if (this.asZ.size() > 5) {
            this.asZ.poll();
        }
        if (Af()) {
            int i2 = 0;
            for (a aVar2 : this.asZ) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.atd) + i2) : i2;
            }
            this.atc = i2 / 5;
        }
    }

    public boolean Af() {
        return this.asZ.size() == 5;
    }

    public BdAsyncTaskParallel il() {
        if (!com.baidu.adp.lib.util.j.jH()) {
            return null;
        }
        if (Af() && this.atc < 20.0f) {
            if (this.ata == null) {
                this.ata = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ata;
        }
        if (this.atb == null) {
            this.atb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.atb;
    }
}
