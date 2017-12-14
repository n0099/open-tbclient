package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i ajo = null;
    private Queue<a> ajp = new LinkedList();
    private BdAsyncTaskParallel ajq = null;
    private BdAsyncTaskParallel ajr = null;
    private float ajs = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajt;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajt = 0L;
        }
    }

    public static i wb() {
        if (ajo == null) {
            ajo = new i();
        }
        return ajo;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajt = j;
        this.ajp.offer(aVar);
        if (this.ajp.size() > 5) {
            this.ajp.poll();
        }
        if (wc()) {
            int i2 = 0;
            for (a aVar2 : this.ajp) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajt) + i2) : i2;
            }
            this.ajs = i2 / 5;
        }
    }

    public boolean wc() {
        return this.ajp.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.j.hk()) {
            return null;
        }
        if (wc() && this.ajs < 20.0f) {
            if (this.ajq == null) {
                this.ajq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajq;
        }
        if (this.ajr == null) {
            this.ajr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajr;
    }
}
