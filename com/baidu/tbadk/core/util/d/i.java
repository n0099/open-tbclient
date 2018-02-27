package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aZe = null;
    private Queue<a> aZf = new LinkedList();
    private BdAsyncTaskParallel aZg = null;
    private BdAsyncTaskParallel aZh = null;
    private float aZi = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aZj;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aZj = 0L;
        }
    }

    public static i DM() {
        if (aZe == null) {
            aZe = new i();
        }
        return aZe;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aZj = j;
        this.aZf.offer(aVar);
        if (this.aZf.size() > 5) {
            this.aZf.poll();
        }
        if (DN()) {
            int i2 = 0;
            for (a aVar2 : this.aZf) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aZj) + i2) : i2;
            }
            this.aZi = i2 / 5;
        }
    }

    public boolean DN() {
        return this.aZf.size() == 5;
    }

    public BdAsyncTaskParallel nq() {
        if (!com.baidu.adp.lib.util.j.oM()) {
            return null;
        }
        if (DN() && this.aZi < 20.0f) {
            if (this.aZg == null) {
                this.aZg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aZg;
        }
        if (this.aZh == null) {
            this.aZh = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aZh;
    }
}
