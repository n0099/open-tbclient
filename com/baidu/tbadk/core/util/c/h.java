package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class h {
    private static h ahs = null;
    private Queue<a> aht = new LinkedList();
    private BdAsyncTaskParallel ahu = null;
    private BdAsyncTaskParallel ahv = null;
    private float ahw = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long ahx;
        public int downloadSize;

        private a() {
            this.downloadSize = 0;
            this.ahx = 0L;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public static h vQ() {
        if (ahs == null) {
            ahs = new h();
        }
        return ahs;
    }

    public synchronized void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.downloadSize = i;
        aVar.ahx = j;
        this.aht.offer(aVar);
        if (this.aht.size() > 5) {
            this.aht.poll();
        }
        if (vR()) {
            int i2 = 0;
            for (a aVar2 : this.aht) {
                if (j > 0) {
                    i2 = (int) ((aVar2.downloadSize / aVar2.ahx) + i2);
                }
            }
            this.ahw = i2 / 5;
        }
    }

    public boolean vR() {
        return this.aht.size() == 5;
    }

    public BdAsyncTaskParallel fQ() {
        if (!com.baidu.adp.lib.util.i.hn()) {
            return null;
        }
        if (vR() && this.ahw < 20.0f) {
            if (this.ahu == null) {
                this.ahu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.ahu;
        }
        if (this.ahv == null) {
            this.ahv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.ahv;
    }
}
