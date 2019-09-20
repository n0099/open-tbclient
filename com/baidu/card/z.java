package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> Xi;
    private s Xj;
    private com.baidu.tieba.card.ab<T> Xk;
    private m Xl;
    private w Xm;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.Xk = null;
        this.Xi = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.Xi.getView();
    }

    public x<T> qQ() {
        return this.Xi;
    }

    public s qR() {
        if (this.Xj == null) {
            this.Xj = new s(((TbPageContextSupport) this.Xi.getView().getContext()).getPageContext());
            this.Xj.Wt.setUniqueId(this.mId);
        }
        this.Xi.a(this.Xj);
        return this.Xj;
    }

    public m qS() {
        return aD(true);
    }

    public m aD(boolean z) {
        if (this.Xl == null) {
            this.Xl = new m(this.Xi.getContext());
        }
        this.Xl.g(this.mId);
        this.Xl.aB(z);
        this.Xi.a(this.Xl);
        return this.Xl;
    }

    public w qT() {
        if (this.Xm == null) {
            this.Xm = new w(((TbPageContextSupport) this.Xi.getView().getContext()).getPageContext());
            this.Xm.setPageId(this.mId);
        }
        this.Xi.a(this.Xm);
        return this.Xm;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.Xi.getView().setVisibility(8);
            return;
        }
        this.Xi.getView().setVisibility(0);
        if (this.Xj != null && this.Xj.Wt != null) {
            if (!t.isSelf() && t.acE() != null) {
                this.Xj.C(t.acE());
                this.Xj.Wt.setVisibility(0);
                z = true;
            } else if (this.Xj != null && this.Xj.Wt != null) {
                this.Xj.Wt.setVisibility(8);
            }
        }
        this.Xi.b((x<T>) t);
        if (this.Xm != null) {
            this.Xm.aC(z);
            this.Xm.C(t.acC());
        }
        if (this.Xl != null) {
            this.Xl.C(t.acC());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.Xi.a(abVar);
    }
}
