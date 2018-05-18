package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i akJ = null;
    private Queue<a> akK = new LinkedList();
    private BdAsyncTaskParallel akL = null;
    private BdAsyncTaskParallel akM = null;
    private float akN = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long akO;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.akO = 0L;
        }
    }

    public static i wy() {
        if (akJ == null) {
            akJ = new i();
        }
        return akJ;
    }

    public synchronized void e(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.akO = j;
        this.akK.offer(aVar);
        if (this.akK.size() > 5) {
            this.akK.poll();
        }
        if (wz()) {
            int i2 = 0;
            for (a aVar2 : this.akK) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.akO) + i2) : i2;
            }
            this.akN = i2 / 5;
        }
    }

    public boolean wz() {
        return this.akK.size() == 5;
    }

    public BdAsyncTaskParallel fu() {
        if (!com.baidu.adp.lib.util.j.gS()) {
            return null;
        }
        if (wz() && this.akN < 20.0f) {
            if (this.akL == null) {
                this.akL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.akL;
        }
        if (this.akM == null) {
            this.akM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.akM;
    }
}
