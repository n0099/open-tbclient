package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes6.dex */
public class af<T extends com.baidu.tbadk.core.data.a> extends v.a {
    private ad<T> LC;
    private w LD;
    private aj LE;
    private com.baidu.tieba.card.z<T> LH;
    private q LI;
    private ac LJ;
    private y LK;
    private BdUniqueId mId;

    public af(ad<T> adVar) {
        super(adVar.getView());
        this.LH = null;
        this.LC = adVar;
    }

    @Override // com.baidu.adp.widget.ListView.v.a
    public View getView() {
        return this.LC.getView();
    }

    public ad<T> mU() {
        return this.LC;
    }

    public w ad(boolean z) {
        if (this.LD == null) {
            this.LD = new w(((TbPageContextSupport) this.LC.getView().getContext()).getPageContext(), z);
            this.LD.KE.setUniqueId(this.mId);
        }
        this.LC.a(this.LD);
        return this.LD;
    }

    public aj ae(boolean z) {
        if (this.LE == null) {
            this.LE = new aj(((TbPageContextSupport) this.LC.getView().getContext()).getPageContext(), z);
        }
        this.LC.a(this.LE);
        return this.LE;
    }

    public q mV() {
        return af(true);
    }

    public q af(boolean z) {
        if (this.LI == null) {
            this.LI = new q(this.LC.getContext());
        }
        this.LI.g(this.mId);
        this.LI.aa(z);
        this.LC.a(this.LI);
        return this.LI;
    }

    public ac mW() {
        if (this.LJ == null) {
            this.LJ = new ac(((TbPageContextSupport) this.LC.getView().getContext()).getPageContext());
            this.LJ.setPageId(this.mId);
        }
        this.LC.a(this.LJ);
        return this.LJ;
    }

    public y aU(int i) {
        if (this.LK == null) {
            this.LK = new y(this.LC.getView().getContext(), i);
            this.LK.setPageId(this.mId);
        }
        this.LC.a(this.LK);
        return this.LK;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.LC.getView().setVisibility(8);
            return;
        }
        this.LC.getView().setVisibility(0);
        if (this.LD != null && this.LD.KE != null) {
            if (!t.isSelf() && t.axS() != null) {
                this.LD.A(t.axS());
                this.LD.KE.setVisibility(0);
                z = true;
            } else if (this.LD != null && this.LD.KE != null) {
                this.LD.KE.setVisibility(8);
            }
        }
        this.LC.c((ad<T>) t);
        if (this.LE != null) {
            this.LE.A(t.axQ());
        }
        if (this.LJ != null) {
            this.LJ.ac(z);
            this.LJ.A(t.axQ());
        }
        if (this.LI != null) {
            this.LI.A(t.axQ());
        }
        if (this.LK != null) {
            this.LK.A(t.axQ());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.z<T> zVar) {
        this.LC.a(zVar);
    }
}
