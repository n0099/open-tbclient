package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes5.dex */
public class af<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private com.baidu.tieba.card.z<T> LA;
    private q LB;
    private ac LC;
    private y LD;
    private ad<T> Lx;
    private w Ly;
    private aj Lz;
    private BdUniqueId mId;

    public af(ad<T> adVar) {
        super(adVar.getView());
        this.LA = null;
        this.Lx = adVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.Lx.getView();
    }

    public ad<T> mT() {
        return this.Lx;
    }

    public w ad(boolean z) {
        if (this.Ly == null) {
            this.Ly = new w(((TbPageContextSupport) this.Lx.getView().getContext()).getPageContext(), z);
            this.Ly.Ky.setUniqueId(this.mId);
        }
        this.Lx.a(this.Ly);
        return this.Ly;
    }

    public aj ae(boolean z) {
        if (this.Lz == null) {
            this.Lz = new aj(((TbPageContextSupport) this.Lx.getView().getContext()).getPageContext(), z);
        }
        this.Lx.a(this.Lz);
        return this.Lz;
    }

    public q mU() {
        return af(true);
    }

    public q af(boolean z) {
        if (this.LB == null) {
            this.LB = new q(this.Lx.getContext());
        }
        this.LB.g(this.mId);
        this.LB.aa(z);
        this.Lx.a(this.LB);
        return this.LB;
    }

    public ac mV() {
        if (this.LC == null) {
            this.LC = new ac(((TbPageContextSupport) this.Lx.getView().getContext()).getPageContext());
            this.LC.setPageId(this.mId);
        }
        this.Lx.a(this.LC);
        return this.LC;
    }

    public y aU(int i) {
        if (this.LD == null) {
            this.LD = new y(this.Lx.getView().getContext(), i);
            this.LD.setPageId(this.mId);
        }
        this.Lx.a(this.LD);
        return this.LD;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.Lx.getView().setVisibility(8);
            return;
        }
        this.Lx.getView().setVisibility(0);
        if (this.Ly != null && this.Ly.Ky != null) {
            if (!t.isSelf() && t.axz() != null) {
                this.Ly.A(t.axz());
                this.Ly.Ky.setVisibility(0);
                z = true;
            } else if (this.Ly != null && this.Ly.Ky != null) {
                this.Ly.Ky.setVisibility(8);
            }
        }
        this.Lx.c((ad<T>) t);
        if (this.Lz != null) {
            this.Lz.A(t.axx());
        }
        if (this.LC != null) {
            this.LC.ac(z);
            this.LC.A(t.axx());
        }
        if (this.LB != null) {
            this.LB.A(t.axx());
        }
        if (this.LD != null) {
            this.LD.A(t.axx());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.z<T> zVar) {
        this.Lx.a(zVar);
    }
}
