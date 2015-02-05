package com.baidu.tbadk.baseEditMark;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    private boolean AT;
    private MarkData AU;
    private f AV;
    private g AW;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.AT = false;
        this.AU = null;
        this.AV = null;
        this.AW = null;
        this.AU = new MarkData();
    }

    public boolean lb() {
        return this.AT;
    }

    public MarkData lc() {
        return this.AU;
    }

    public void a(g gVar) {
        this.AW = gVar;
    }

    public void b(MarkData markData) {
        this.AU = markData;
    }

    public void Y(boolean z) {
        this.AT = z;
    }

    public String ld() {
        if (this.AU != null) {
            return this.AU.getPostId();
        }
        return null;
    }

    public void le() {
        if (this.AV != null) {
            this.AV.cancel();
        }
        this.AV = new f(this, true);
        this.AV.setPriority(3);
        this.AV.execute(new Boolean[0]);
    }

    public void lf() {
        if (this.AV != null) {
            this.AV.cancel();
        }
        this.AV = new f(this, false);
        this.AV.setPriority(3);
        this.AV.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.AV != null) {
            this.AV.cancel();
            return false;
        }
        return false;
    }
}
