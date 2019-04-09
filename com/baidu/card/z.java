package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> YX;
    private s YY;
    private com.baidu.tieba.card.ab<T> YZ;
    private m Za;
    private w Zb;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.YZ = null;
        this.YX = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.YX.getView();
    }

    public x<T> rx() {
        return this.YX;
    }

    public s ry() {
        if (this.YY == null) {
            this.YY = new s(((TbPageContextSupport) this.YX.getView().getContext()).getPageContext());
            this.YY.Yj.setUniqueId(this.mId);
        }
        this.YX.a(this.YY);
        return this.YY;
    }

    public m rz() {
        return aI(true);
    }

    public m aI(boolean z) {
        if (this.Za == null) {
            this.Za = new m(this.YX.getContext());
        }
        this.Za.g(this.mId);
        this.Za.aG(z);
        this.YX.a(this.Za);
        return this.Za;
    }

    public w rA() {
        if (this.Zb == null) {
            this.Zb = new w(((TbPageContextSupport) this.YX.getView().getContext()).getPageContext());
            this.Zb.setPageId(this.mId);
        }
        this.YX.a(this.Zb);
        return this.Zb;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.YX.getView().setVisibility(8);
            return;
        }
        this.YX.getView().setVisibility(0);
        if (this.YY != null && this.YY.Yj != null) {
            if (!t.isSelf() && t.WQ() != null) {
                this.YY.C(t.WQ());
                this.YY.Yj.setVisibility(0);
                z = true;
            } else if (this.YY != null && this.YY.Yj != null) {
                this.YY.Yj.setVisibility(8);
            }
        }
        this.YX.b((x<T>) t);
        if (this.Zb != null) {
            this.Zb.aH(z);
            this.Zb.C(t.WO());
        }
        if (this.Za != null) {
            this.Za.C(t.WO());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.YX.a(abVar);
    }
}
