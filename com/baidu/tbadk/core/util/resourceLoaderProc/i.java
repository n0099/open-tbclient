package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class i {
    private static i acx = null;
    private Queue<a> acy = new LinkedList();
    private BdAsyncTaskParallel acz = null;
    private BdAsyncTaskParallel acA = null;
    private float acB = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long acC;
        public int uN;

        private a() {
            this.uN = 0;
            this.acC = 0L;
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }

    public static i vk() {
        if (acx == null) {
            acx = new i();
        }
        return acx;
    }

    public void b(int i, long j) {
        a aVar = new a(this, null);
        aVar.uN = i;
        aVar.acC = j;
        this.acy.offer(aVar);
        if (this.acy.size() > 5) {
            this.acy.poll();
        }
        if (vl()) {
            int i2 = 0;
            for (a aVar2 : this.acy) {
                if (j > 0) {
                    i2 = (int) ((aVar2.uN / aVar2.acC) + i2);
                }
            }
            this.acB = i2 / 5;
        }
    }

    public boolean vl() {
        return this.acy.size() == 5;
    }

    public BdAsyncTaskParallel hg() {
        if (!com.baidu.adp.lib.util.i.iR()) {
            return null;
        }
        if (vl() && this.acB < 20.0f) {
            if (this.acz == null) {
                this.acz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
            }
            return this.acz;
        }
        if (this.acA == null) {
            this.acA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
        }
        return this.acA;
    }
}
