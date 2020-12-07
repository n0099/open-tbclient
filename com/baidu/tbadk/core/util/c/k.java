package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k eVQ = null;
    private Queue<a> eVR = new LinkedList();
    private BdAsyncTaskParallel eVS = null;
    private BdAsyncTaskParallel eVT = null;
    private float eVU = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int eVV;
        public long eVW;

        private a() {
            this.eVV = 0;
            this.eVW = 0L;
        }
    }

    public static k buv() {
        if (eVQ == null) {
            eVQ = new k();
        }
        return eVQ;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.eVV = i;
        aVar.eVW = j;
        this.eVR.offer(aVar);
        if (this.eVR.size() > 5) {
            this.eVR.poll();
        }
        if (buw()) {
            int i2 = 0;
            for (a aVar2 : this.eVR) {
                i2 = j > 0 ? (int) ((aVar2.eVV / aVar2.eVW) + i2) : i2;
            }
            this.eVU = i2 / 5;
        }
    }

    public boolean buw() {
        return this.eVR.size() == 5;
    }

    public BdAsyncTaskParallel mW() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (buw() && this.eVU < 20.0f) {
            if (this.eVS == null) {
                this.eVS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.eVS;
        }
        if (this.eVT == null) {
            this.eVT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.eVT;
    }
}
