package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i ajr = null;
    private Queue<a> ajs = new LinkedList();
    private BdAsyncTaskParallel ajt = null;
    private BdAsyncTaskParallel aju = null;
    private float ajv = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajw;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajw = 0L;
        }
    }

    public static i wb() {
        if (ajr == null) {
            ajr = new i();
        }
        return ajr;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajw = j;
        this.ajs.offer(aVar);
        if (this.ajs.size() > 5) {
            this.ajs.poll();
        }
        if (wc()) {
            int i2 = 0;
            for (a aVar2 : this.ajs) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajw) + i2) : i2;
            }
            this.ajv = i2 / 5;
        }
    }

    public boolean wc() {
        return this.ajs.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.j.hk()) {
            return null;
        }
        if (wc() && this.ajv < 20.0f) {
            if (this.ajt == null) {
                this.ajt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajt;
        }
        if (this.aju == null) {
            this.aju = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aju;
    }
}
