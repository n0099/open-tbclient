package com.baidu.tbadk.BdToken;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long byH;

    public l(b bVar) {
        super(bVar);
        this.byH = System.currentTimeMillis();
    }

    public synchronized long YI() {
        this.byH = System.currentTimeMillis() + 60000;
        return this.byH;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.byH >= 60000;
    }
}
