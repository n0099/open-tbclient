package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i aiY = null;
    private Queue<a> aiZ = new LinkedList();
    private BdAsyncTaskParallel aja = null;
    private BdAsyncTaskParallel ajb = null;
    private float ajc = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ajd;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ajd = 0L;
        }
    }

    public static i wb() {
        if (aiY == null) {
            aiY = new i();
        }
        return aiY;
    }

    public synchronized void c(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.ajd = j;
        this.aiZ.offer(aVar);
        if (this.aiZ.size() > 5) {
            this.aiZ.poll();
        }
        if (wc()) {
            int i2 = 0;
            for (a aVar2 : this.aiZ) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.ajd) + i2) : i2;
            }
            this.ajc = i2 / 5;
        }
    }

    public boolean wc() {
        return this.aiZ.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.j.hk()) {
            return null;
        }
        if (wc() && this.ajc < 20.0f) {
            if (this.aja == null) {
                this.aja = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aja;
        }
        if (this.ajb == null) {
            this.ajb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ajb;
    }
}
