package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i asR = null;
    private Queue<a> asS = new LinkedList();
    private BdAsyncTaskParallel asT = null;
    private BdAsyncTaskParallel asU = null;
    private float asV = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long asW;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.asW = 0L;
        }
    }

    public static i zZ() {
        if (asR == null) {
            asR = new i();
        }
        return asR;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.asW = j;
        this.asS.offer(aVar);
        if (this.asS.size() > 5) {
            this.asS.poll();
        }
        if (Aa()) {
            int i2 = 0;
            for (a aVar2 : this.asS) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.asW) + i2) : i2;
            }
            this.asV = i2 / 5;
        }
    }

    public boolean Aa() {
        return this.asS.size() == 5;
    }

    public BdAsyncTaskParallel ik() {
        if (!com.baidu.adp.lib.util.j.jG()) {
            return null;
        }
        if (Aa() && this.asV < 20.0f) {
            if (this.asT == null) {
                this.asT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.asT;
        }
        if (this.asU == null) {
            this.asU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.asU;
    }
}
