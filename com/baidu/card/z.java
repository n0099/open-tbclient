package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class z<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private x<T> WO;
    private s WP;
    private com.baidu.tieba.card.ab<T> WQ;
    private m WR;
    private w WS;
    private BdUniqueId mId;

    public z(x<T> xVar) {
        super(xVar.getView());
        this.WQ = null;
        this.WO = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.WO.getView();
    }

    public x<T> qs() {
        return this.WO;
    }

    public s qt() {
        if (this.WP == null) {
            this.WP = new s(((TbPageContextSupport) this.WO.getView().getContext()).getPageContext());
            this.WP.VZ.setUniqueId(this.mId);
        }
        this.WO.a(this.WP);
        return this.WP;
    }

    public m qu() {
        return aA(true);
    }

    public m aA(boolean z) {
        if (this.WR == null) {
            this.WR = new m(this.WO.getContext());
        }
        this.WR.g(this.mId);
        this.WR.ay(z);
        this.WO.a(this.WR);
        return this.WR;
    }

    public w qv() {
        if (this.WS == null) {
            this.WS = new w(((TbPageContextSupport) this.WO.getView().getContext()).getPageContext());
            this.WS.setPageId(this.mId);
        }
        this.WO.a(this.WS);
        return this.WS;
    }

    public void a(T t) {
        boolean z = false;
        if (t == null) {
            this.WO.getView().setVisibility(8);
            return;
        }
        this.WO.getView().setVisibility(0);
        if (this.WP != null && this.WP.VZ != null) {
            if (!t.isSelf() && t.abx() != null) {
                this.WP.C(t.abx());
                this.WP.VZ.setVisibility(0);
                z = true;
            } else if (this.WP != null && this.WP.VZ != null) {
                this.WP.VZ.setVisibility(8);
            }
        }
        this.WO.b((x<T>) t);
        if (this.WS != null) {
            this.WS.az(z);
            this.WS.C(t.abv());
        }
        if (this.WR != null) {
            this.WR.C(t.abv());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void c(com.baidu.tieba.card.ab<T> abVar) {
        this.WO.a(abVar);
    }
}
