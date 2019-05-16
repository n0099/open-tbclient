package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> WP;
    private s WQ;
    private com.baidu.tieba.card.ab<T> WR;
    private m WS;
    private w WT;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.WR = null;
        this.WP = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.WP.getView();
    }

    public x<T> qs() {
        return this.WP;
    }

    public s qt() {
        if (this.WQ == null) {
            this.WQ = new s(((TbPageContextSupport) this.WP.getView().getContext()).getPageContext());
            this.WQ.Wa.setUniqueId(this.mId);
        }
        this.WP.a(this.WQ);
        return this.WQ;
    }

    public m qu() {
        return aA(true);
    }

    public m aA(boolean z) {
        if (this.WS == null) {
            this.WS = new m(this.WP.getContext());
        }
        this.WS.g(this.mId);
        this.WS.ay(z);
        this.WP.a(this.WS);
        return this.WS;
    }

    public w qv() {
        if (this.WT == null) {
            this.WT = new w(((TbPageContextSupport) this.WP.getView().getContext()).getPageContext());
            this.WT.setPageId(this.mId);
        }
        this.WP.a(this.WT);
        return this.WT;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.WP.getView().setVisibility(8);
            return;
        }
        this.WP.getView().setVisibility(0);
        if (this.WQ != null && this.WQ.Wa != null) {
            if (!t.isSelf() && t.abx() != null) {
                this.WQ.C(t.abx());
                this.WQ.Wa.setVisibility(0);
                z = true;
            } else if (this.WQ != null && this.WQ.Wa != null) {
                this.WQ.Wa.setVisibility(8);
            }
        }
        this.WP.b((x<T>) t);
        if (this.WT != null) {
            this.WT.az(z);
            this.WT.C(t.abv());
        }
        if (this.WS != null) {
            this.WS.C(t.abv());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.WP.a(abVar);
    }
}
