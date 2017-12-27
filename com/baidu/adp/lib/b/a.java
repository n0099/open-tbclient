package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] ahN;
    protected int ahO = 0;
    protected int ahP = 1;
    protected int ahQ = 10;
    protected b.a ahR = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.cQ(i);
        }
    };
    protected String mName;

    protected abstract void cQ(int i);

    protected abstract String getName();

    protected abstract String[] mq();

    protected abstract int mr();

    protected abstract int ms();

    protected abstract int mt();

    protected String[] mu() {
        return null;
    }

    protected void mv() {
        b bVar = new b(this.mName, this.ahO, this.ahR);
        bVar.a(this.ahQ, this.ahN, this.ahP);
        bVar.g(mu());
        d.mz().a(bVar);
    }

    public a() {
        initData();
        mv();
    }

    protected void initData() {
        this.mName = getName();
        this.ahN = mq();
        this.ahO = mr();
        this.ahP = ms();
        this.ahQ = mt();
    }
}
