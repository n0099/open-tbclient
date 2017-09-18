package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ajk = null;
    private Queue<a> ajl = new LinkedList();
    private BdAsyncTaskParallel ajm = null;
    private BdAsyncTaskParallel ajn = null;
    private float ajo = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajp;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajp = 0L;
        }
    }

    public static h wv() {
        if (ajk == null) {
            ajk = new h();
        }
        return ajk;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajp = j;
        this.ajl.offer(aVar);
        if (this.ajl.size() > 5) {
            this.ajl.poll();
        }
        if (ww()) {
            int i2 = 0;
            for (a aVar2 : this.ajl) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajp) + i2) : i2;
            }
            this.ajo = i2 / 5;
        }
    }

    public boolean ww() {
        return this.ajl.size() == 5;
    }

    public BdAsyncTaskParallel fO() {
        if (!com.baidu.adp.lib.util.i.hl()) {
            return null;
        }
        if (ww() && this.ajo < 20.0f) {
            if (this.ajm == null) {
                this.ajm = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajm;
        }
        if (this.ajn == null) {
            this.ajn = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajn;
    }
}
