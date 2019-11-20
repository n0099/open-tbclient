package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private com.baidu.tieba.card.ab<T> GA;
    private m GB;
    private w GC;
    private x<T> Gy;
    private s Gz;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.GA = null;
        this.Gy = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.Gy.getView();
    }

    public x<T> lV() {
        return this.Gy;
    }

    public s lW() {
        if (this.Gz == null) {
            this.Gz = new s(((TbPageContextSupport) this.Gy.getView().getContext()).getPageContext());
            this.Gz.FI.setUniqueId(this.mId);
        }
        this.Gy.a(this.Gz);
        return this.Gz;
    }

    public m lX() {
        return Y(true);
    }

    public m Y(boolean z) {
        if (this.GB == null) {
            this.GB = new m(this.Gy.getContext());
        }
        this.GB.g(this.mId);
        this.GB.W(z);
        this.Gy.a(this.GB);
        return this.GB;
    }

    public w lY() {
        if (this.GC == null) {
            this.GC = new w(((TbPageContextSupport) this.Gy.getView().getContext()).getPageContext());
            this.GC.setPageId(this.mId);
        }
        this.Gy.a(this.GC);
        return this.GC;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.Gy.getView().setVisibility(8);
            return;
        }
        this.Gy.getView().setVisibility(0);
        if (this.Gz != null && this.Gz.FI != null) {
            if (!t.isSelf() && t.agI() != null) {
                this.Gz.z(t.agI());
                this.Gz.FI.setVisibility(0);
                z = true;
            } else if (this.Gz != null && this.Gz.FI != null) {
                this.Gz.FI.setVisibility(8);
            }
        }
        this.Gy.b((x<T>) t);
        if (this.GC != null) {
            this.GC.X(z);
            this.GC.z(t.agG());
        }
        if (this.GB != null) {
            this.GB.z(t.agG());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.Gy.b(abVar);
    }
}
