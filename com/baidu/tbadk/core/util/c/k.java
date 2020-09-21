package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class k {
    private static k epa = null;
    private Queue<a> epb = new LinkedList();
    private BdAsyncTaskParallel epc = null;
    private BdAsyncTaskParallel epd = null;
    private float epe = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int epf;
        public long epg;

        private a() {
            this.epf = 0;
            this.epg = 0L;
        }
    }

    public static k bkH() {
        if (epa == null) {
            epa = new k();
        }
        return epa;
    }

    public synchronized void t(int i, long j) {
        a aVar = new a();
        aVar.epf = i;
        aVar.epg = j;
        this.epb.offer(aVar);
        if (this.epb.size() > 5) {
            this.epb.poll();
        }
        if (bkI()) {
            int i2 = 0;
            for (a aVar2 : this.epb) {
                i2 = j > 0 ? (int) ((aVar2.epf / aVar2.epg) + i2) : i2;
            }
            this.epe = i2 / 5;
        }
    }

    public boolean bkI() {
        return this.epb.size() == 5;
    }

    public BdAsyncTaskParallel mV() {
        if (!com.baidu.adp.lib.util.j.is4GNet()) {
            return null;
        }
        if (bkI() && this.epe < 20.0f) {
            if (this.epc == null) {
                this.epc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.epc;
        }
        if (this.epd == null) {
            this.epd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.epd;
    }
}
