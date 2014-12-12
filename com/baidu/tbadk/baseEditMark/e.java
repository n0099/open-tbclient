package com.baidu.tbadk.baseEditMark;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    private boolean AW;
    private MarkData AX;
    private f AY;
    private g AZ;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.AW = false;
        this.AX = null;
        this.AY = null;
        this.AZ = null;
        this.AX = new MarkData();
    }

    public boolean li() {
        return this.AW;
    }

    public MarkData lj() {
        return this.AX;
    }

    public void a(g gVar) {
        this.AZ = gVar;
    }

    public void b(MarkData markData) {
        this.AX = markData;
    }

    public void Y(boolean z) {
        this.AW = z;
    }

    public String lk() {
        if (this.AX != null) {
            return this.AX.getPostId();
        }
        return null;
    }

    public void ll() {
        if (this.AY != null) {
            this.AY.cancel();
        }
        this.AY = new f(this, true);
        this.AY.setPriority(3);
        this.AY.execute(new Boolean[0]);
    }

    public void lm() {
        if (this.AY != null) {
            this.AY.cancel();
        }
        this.AY = new f(this, false);
        this.AY.setPriority(3);
        this.AY.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.AY != null) {
            this.AY.cancel();
            return false;
        }
        return false;
    }
}
