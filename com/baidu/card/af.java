package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public class af<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private ad<T> Mf;
    private w Mg;
    private aj Mh;
    private com.baidu.tieba.card.z<T> Mi;
    private q Mj;
    private ac Mk;
    private y Ml;
    private BdUniqueId mId;

    public af(ad<T> adVar) {
        super(adVar.getView());
        this.Mi = null;
        this.Mf = adVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.Mf.getView();
    }

    public ad<T> nk() {
        return this.Mf;
    }

    public w ag(boolean z) {
        if (this.Mg == null) {
            this.Mg = new w(((TbPageContextSupport) this.Mf.getView().getContext()).getPageContext(), z);
            this.Mg.KZ.setUniqueId(this.mId);
        }
        this.Mf.a(this.Mg);
        return this.Mg;
    }

    public aj ah(boolean z) {
        if (this.Mh == null) {
            this.Mh = new aj(((TbPageContextSupport) this.Mf.getView().getContext()).getPageContext(), z);
        }
        this.Mf.a(this.Mh);
        return this.Mh;
    }

    public q nl() {
        return ai(true);
    }

    public q ai(boolean z) {
        if (this.Mj == null) {
            this.Mj = new q(this.Mf.getContext());
        }
        this.Mj.g(this.mId);
        this.Mj.ad(z);
        this.Mf.a(this.Mj);
        return this.Mj;
    }

    public ac nm() {
        if (this.Mk == null) {
            this.Mk = new ac(((TbPageContextSupport) this.Mf.getView().getContext()).getPageContext());
            this.Mk.setPageId(this.mId);
        }
        this.Mf.a(this.Mk);
        return this.Mk;
    }

    public y aY(int i) {
        if (this.Ml == null) {
            this.Ml = new y(this.Mf.getView().getContext(), i);
            this.Ml.setPageId(this.mId);
        }
        this.Mf.a(this.Ml);
        return this.Ml;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.Mf.getView().setVisibility(8);
            return;
        }
        this.Mf.getView().setVisibility(0);
        if (this.Mg != null && this.Mg.KZ != null) {
            if (!t.isSelf() && t.aAi() != null) {
                this.Mg.A(t.aAi());
                this.Mg.KZ.setVisibility(0);
                z = true;
            } else if (this.Mg != null && this.Mg.KZ != null) {
                this.Mg.KZ.setVisibility(8);
            }
        }
        this.Mf.c((ad<T>) t);
        if (this.Mh != null) {
            this.Mh.A(t.aAg());
        }
        if (this.Mk != null) {
            this.Mk.af(z);
            this.Mk.A(t.aAg());
        }
        if (this.Mj != null) {
            this.Mj.A(t.aAg());
        }
        if (this.Ml != null) {
            this.Ml.A(t.aAg());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.z<T> zVar) {
        this.Mf.a(zVar);
    }
}
