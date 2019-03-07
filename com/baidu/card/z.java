package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> YV;
    private s YW;
    private com.baidu.tieba.card.ab<T> YX;
    private m YY;
    private w YZ;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.YX = null;
        this.YV = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.YV.getView();
    }

    public x<T> rx() {
        return this.YV;
    }

    public s ry() {
        if (this.YW == null) {
            this.YW = new s(((TbPageContextSupport) this.YV.getView().getContext()).getPageContext());
            this.YW.Yh.setUniqueId(this.mId);
        }
        this.YV.a(this.YW);
        return this.YW;
    }

    public m rz() {
        return aI(true);
    }

    public m aI(boolean z) {
        if (this.YY == null) {
            this.YY = new m(this.YV.getContext());
        }
        this.YY.g(this.mId);
        this.YY.aG(z);
        this.YV.a(this.YY);
        return this.YY;
    }

    public w rA() {
        if (this.YZ == null) {
            this.YZ = new w(((TbPageContextSupport) this.YV.getView().getContext()).getPageContext());
            this.YZ.setPageId(this.mId);
        }
        this.YV.a(this.YZ);
        return this.YZ;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.YV.getView().setVisibility(8);
            return;
        }
        this.YV.getView().setVisibility(0);
        if (this.YW != null && this.YW.Yh != null) {
            if (!t.isSelf() && t.WT() != null) {
                this.YW.C(t.WT());
                this.YW.Yh.setVisibility(0);
                z = true;
            } else if (this.YW != null && this.YW.Yh != null) {
                this.YW.Yh.setVisibility(8);
            }
        }
        this.YV.b((x<T>) t);
        if (this.YZ != null) {
            this.YZ.aH(z);
            this.YZ.C(t.WR());
        }
        if (this.YY != null) {
            this.YY.C(t.WR());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.YV.a(abVar);
    }
}
