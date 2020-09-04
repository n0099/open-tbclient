package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k emH = null;
    private Queue<a> emI = new LinkedList();
    private BdAsyncTaskParallel emJ = null;
    private BdAsyncTaskParallel emK = null;
    private float emL = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int emM;
        public long emN;

        private a() {
            this.emM = 0;
            this.emN = 0L;
        }
    }

    public static k bjM() {
        if (emH == null) {
            emH = new k();
        }
        return emH;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.emM = i;
        aVar.emN = j;
        this.emI.offer(aVar);
        if (this.emI.size() > 5) {
            this.emI.poll();
        }
        if (bjN()) {
            int i2 = 0;
            for (a aVar2 : this.emI) {
                i2 = j > 0 ? (int) ((aVar2.emM / aVar2.emN) + i2) : i2;
            }
            this.emL = i2 / 5;
        }
    }

    public boolean bjN() {
        return this.emI.size() == 5;
    }

    public BdAsyncTaskParallel mQ() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bjN() && this.emL < 20.0f) {
            if (this.emJ == null) {
                this.emJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.emJ;
        }
        if (this.emK == null) {
            this.emK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.emK;
    }
}
