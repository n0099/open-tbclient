package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ajl = null;
    private Queue<a> ajm = new LinkedList();
    private BdAsyncTaskParallel ajn = null;
    private BdAsyncTaskParallel ajo = null;
    private float ajp = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajq;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajq = 0L;
        }
    }

    public static h wv() {
        if (ajl == null) {
            ajl = new h();
        }
        return ajl;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajq = j;
        this.ajm.offer(aVar);
        if (this.ajm.size() > 5) {
            this.ajm.poll();
        }
        if (ww()) {
            int i2 = 0;
            for (a aVar2 : this.ajm) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajq) + i2) : i2;
            }
            this.ajp = i2 / 5;
        }
    }

    public boolean ww() {
        return this.ajm.size() == 5;
    }

    public BdAsyncTaskParallel fO() {
        if (!com.baidu.adp.lib.util.i.hl()) {
            return null;
        }
        if (ww() && this.ajp < 20.0f) {
            if (this.ajn == null) {
                this.ajn = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajn;
        }
        if (this.ajo == null) {
            this.ajo = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajo;
    }
}
