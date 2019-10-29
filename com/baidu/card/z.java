package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> Ha;
    private s Hb;
    private com.baidu.tieba.card.ab<T> Hc;
    private m Hd;
    private w He;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.Hc = null;
        this.Ha = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.Ha.getView();
    }

    public x<T> lV() {
        return this.Ha;
    }

    public s lW() {
        if (this.Hb == null) {
            this.Hb = new s(((TbPageContextSupport) this.Ha.getView().getContext()).getPageContext());
            this.Hb.Gj.setUniqueId(this.mId);
        }
        this.Ha.a(this.Hb);
        return this.Hb;
    }

    public m lX() {
        return Y(true);
    }

    public m Y(boolean z) {
        if (this.Hd == null) {
            this.Hd = new m(this.Ha.getContext());
        }
        this.Hd.g(this.mId);
        this.Hd.W(z);
        this.Ha.a(this.Hd);
        return this.Hd;
    }

    public w lY() {
        if (this.He == null) {
            this.He = new w(((TbPageContextSupport) this.Ha.getView().getContext()).getPageContext());
            this.He.setPageId(this.mId);
        }
        this.Ha.a(this.He);
        return this.He;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.Ha.getView().setVisibility(8);
            return;
        }
        this.Ha.getView().setVisibility(0);
        if (this.Hb != null && this.Hb.Gj != null) {
            if (!t.isSelf() && t.agK() != null) {
                this.Hb.z(t.agK());
                this.Hb.Gj.setVisibility(0);
                z = true;
            } else if (this.Hb != null && this.Hb.Gj != null) {
                this.Hb.Gj.setVisibility(8);
            }
        }
        this.Ha.b((x<T>) t);
        if (this.He != null) {
            this.He.X(z);
            this.He.z(t.agI());
        }
        if (this.Hd != null) {
            this.Hd.z(t.agI());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.Ha.b(abVar);
    }
}
