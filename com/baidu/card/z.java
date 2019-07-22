package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> Xj;
    private s Xk;
    private com.baidu.tieba.card.ab<T> Xl;
    private m Xm;
    private w Xn;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.Xl = null;
        this.Xj = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.Xj.getView();
    }

    public x<T> qP() {
        return this.Xj;
    }

    public s qQ() {
        if (this.Xk == null) {
            this.Xk = new s(((TbPageContextSupport) this.Xj.getView().getContext()).getPageContext());
            this.Xk.Wu.setUniqueId(this.mId);
        }
        this.Xj.a(this.Xk);
        return this.Xk;
    }

    public m qR() {
        return aD(true);
    }

    public m aD(boolean z) {
        if (this.Xm == null) {
            this.Xm = new m(this.Xj.getContext());
        }
        this.Xm.g(this.mId);
        this.Xm.aB(z);
        this.Xj.a(this.Xm);
        return this.Xm;
    }

    public w qS() {
        if (this.Xn == null) {
            this.Xn = new w(((TbPageContextSupport) this.Xj.getView().getContext()).getPageContext());
            this.Xn.setPageId(this.mId);
        }
        this.Xj.a(this.Xn);
        return this.Xn;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.Xj.getView().setVisibility(8);
            return;
        }
        this.Xj.getView().setVisibility(0);
        if (this.Xk != null && this.Xk.Wu != null) {
            if (!t.isSelf() && t.acz() != null) {
                this.Xk.C(t.acz());
                this.Xk.Wu.setVisibility(0);
                z = true;
            } else if (this.Xk != null && this.Xk.Wu != null) {
                this.Xk.Wu.setVisibility(8);
            }
        }
        this.Xj.b((x<T>) t);
        if (this.Xn != null) {
            this.Xn.aC(z);
            this.Xn.C(t.acx());
        }
        if (this.Xm != null) {
            this.Xm.C(t.acx());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.Xj.a(abVar);
    }
}
