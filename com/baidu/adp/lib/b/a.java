package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.b;
/* loaded from: classes.dex */
public abstract class a {
    protected int AA = 0;
    protected int AB = 1;
    protected int AC = 10;
    protected b.a AD = new b.a() { // from class: com.baidu.adp.lib.b.a.1
        @Override // com.baidu.adp.lib.b.b.a
        public void a(String str, int i, boolean z) {
            a.this.Z(i);
        }
    };
    protected String[] Az;
    protected String mName;

    protected abstract void Z(int i);

    protected abstract String getName();

    protected abstract String[] ir();

    protected abstract int is();

    protected abstract int it();

    protected abstract int iu();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] iv() {
        return null;
    }

    protected void iw() {
        b bVar = new b(this.mName, this.AA, this.AD);
        bVar.a(this.AC, this.Az, this.AB);
        bVar.h(iv());
        d.iB().a(bVar);
    }

    public a() {
        initData();
        iw();
    }

    protected void initData() {
        this.mName = getName();
        this.Az = ir();
        this.AA = is();
        this.AB = it();
        this.AC = iu();
    }
}
