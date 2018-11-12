package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j aAX = null;
    private Queue<a> aAY = new LinkedList();
    private BdAsyncTaskParallel aAZ = null;
    private BdAsyncTaskParallel aBa = null;
    private float aBb = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aBc;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aBc = 0L;
        }
    }

    public static j Dv() {
        if (aAX == null) {
            aAX = new j();
        }
        return aAX;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aBc = j;
        this.aAY.offer(aVar);
        if (this.aAY.size() > 5) {
            this.aAY.poll();
        }
        if (Dw()) {
            int i2 = 0;
            for (a aVar2 : this.aAY) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aBc) + i2) : i2;
            }
            this.aBb = i2 / 5;
        }
    }

    public boolean Dw() {
        return this.aAY.size() == 5;
    }

    public BdAsyncTaskParallel jE() {
        if (!com.baidu.adp.lib.util.j.kY()) {
            return null;
        }
        if (Dw() && this.aBb < 20.0f) {
            if (this.aAZ == null) {
                this.aAZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aAZ;
        }
        if (this.aBa == null) {
            this.aBa = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aBa;
    }
}
