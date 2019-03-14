package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> YW;
    private s YX;
    private com.baidu.tieba.card.ab<T> YY;
    private m YZ;
    private w Za;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.YY = null;
        this.YW = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.YW.getView();
    }

    public x<T> rx() {
        return this.YW;
    }

    public s ry() {
        if (this.YX == null) {
            this.YX = new s(((TbPageContextSupport) this.YW.getView().getContext()).getPageContext());
            this.YX.Yi.setUniqueId(this.mId);
        }
        this.YW.a(this.YX);
        return this.YX;
    }

    public m rz() {
        return aI(true);
    }

    public m aI(boolean z) {
        if (this.YZ == null) {
            this.YZ = new m(this.YW.getContext());
        }
        this.YZ.g(this.mId);
        this.YZ.aG(z);
        this.YW.a(this.YZ);
        return this.YZ;
    }

    public w rA() {
        if (this.Za == null) {
            this.Za = new w(((TbPageContextSupport) this.YW.getView().getContext()).getPageContext());
            this.Za.setPageId(this.mId);
        }
        this.YW.a(this.Za);
        return this.Za;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.YW.getView().setVisibility(8);
            return;
        }
        this.YW.getView().setVisibility(0);
        if (this.YX != null && this.YX.Yi != null) {
            if (!t.isSelf() && t.WT() != null) {
                this.YX.C(t.WT());
                this.YX.Yi.setVisibility(0);
                z = true;
            } else if (this.YX != null && this.YX.Yi != null) {
                this.YX.Yi.setVisibility(8);
            }
        }
        this.YW.b((x<T>) t);
        if (this.Za != null) {
            this.Za.aH(z);
            this.Za.C(t.WR());
        }
        if (this.YZ != null) {
            this.YZ.C(t.WR());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.YW.a(abVar);
    }
}
