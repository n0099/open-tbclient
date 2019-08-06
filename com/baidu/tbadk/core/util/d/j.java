package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class j {
    private static j bVR = null;
    private Queue<a> bVS = new LinkedList();
    private BdAsyncTaskParallel bVT = null;
    private BdAsyncTaskParallel bVU = null;
    private float bVV = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bVW;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.bVW = 0L;
        }
    }

    public static j ajY() {
        if (bVR == null) {
            bVR = new j();
        }
        return bVR;
    }

    public synchronized void o(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.bVW = j;
        this.bVS.offer(aVar);
        if (this.bVS.size() > 5) {
            this.bVS.poll();
        }
        if (ajZ()) {
            int i2 = 0;
            for (a aVar2 : this.bVS) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.bVW) + i2) : i2;
            }
            this.bVV = i2 / 5;
        }
    }

    public boolean ajZ() {
        return this.bVS.size() == 5;
    }

    public BdAsyncTaskParallel iI() {
        if (!com.baidu.adp.lib.util.j.kf()) {
            return null;
        }
        if (ajZ() && this.bVV < 20.0f) {
            if (this.bVT == null) {
                this.bVT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.bVT;
        }
        if (this.bVU == null) {
            this.bVU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.bVU;
    }
}
