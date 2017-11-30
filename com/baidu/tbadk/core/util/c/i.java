package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aju = null;
    private Queue<a> ajv = new LinkedList();
    private BdAsyncTaskParallel ajw = null;
    private BdAsyncTaskParallel ajx = null;
    private float ajy = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajz;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajz = 0L;
        }
    }

    public static i we() {
        if (aju == null) {
            aju = new i();
        }
        return aju;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajz = j;
        this.ajv.offer(aVar);
        if (this.ajv.size() > 5) {
            this.ajv.poll();
        }
        if (wf()) {
            int i2 = 0;
            for (a aVar2 : this.ajv) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajz) + i2) : i2;
            }
            this.ajy = i2 / 5;
        }
    }

    public boolean wf() {
        return this.ajv.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.j.hk()) {
            return null;
        }
        if (wf() && this.ajy < 20.0f) {
            if (this.ajw == null) {
                this.ajw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ajw;
        }
        if (this.ajx == null) {
            this.ajx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajx;
    }
}
