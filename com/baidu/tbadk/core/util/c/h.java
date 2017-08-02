package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h aiw = null;
    private Queue<a> aix = new LinkedList();
    private BdAsyncTaskParallel aiy = null;
    private BdAsyncTaskParallel aiz = null;
    private float aiA = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long aiB;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.aiB = 0L;
        }
    }

    public static h wn() {
        if (aiw == null) {
            aiw = new h();
        }
        return aiw;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a();
        aVar.downloadSize = i;
        aVar.aiB = j;
        this.aix.offer(aVar);
        if (this.aix.size() > 5) {
            this.aix.poll();
        }
        if (wo()) {
            int i2 = 0;
            for (a aVar2 : this.aix) {
                i2 = j > 0 ? (int) ((aVar2.downloadSize / aVar2.aiB) + i2) : i2;
            }
            this.aiA = i2 / 5;
        }
    }

    public boolean wo() {
        return this.aix.size() == 5;
    }

    public BdAsyncTaskParallel fN() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            return null;
        }
        if (wo() && this.aiA < 20.0f) {
            if (this.aiy == null) {
                this.aiy = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.aiy;
        }
        if (this.aiz == null) {
            this.aiz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.aiz;
    }
}
