package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public class af<T extends com.baidu.tbadk.core.data.a> extends y.a {
    private ad<T> aeU;
    private w aeV;
    private aj aeW;
    private com.baidu.tieba.card.z<T> aeX;
    private q aeY;
    private ac aeZ;
    private y afa;
    private BdUniqueId mId;

    public af(ad<T> adVar) {
        super(adVar.getView());
        this.aeX = null;
        this.aeU = adVar;
    }

    @Override // com.baidu.adp.widget.ListView.y.a
    public View getView() {
        return this.aeU.getView();
    }

    public ad<T> rD() {
        return this.aeU;
    }

    public w aF(boolean z) {
        if (this.aeV == null) {
            this.aeV = new w(((TbPageContextSupport) this.aeU.getView().getContext()).getPageContext(), z);
            this.aeV.adW.setUniqueId(this.mId);
        }
        this.aeU.a(this.aeV);
        return this.aeV;
    }

    public aj aG(boolean z) {
        if (this.aeW == null) {
            this.aeW = new aj(((TbPageContextSupport) this.aeU.getView().getContext()).getPageContext(), z);
        }
        this.aeU.a(this.aeW);
        return this.aeW;
    }

    public q rE() {
        return aH(true);
    }

    public q aH(boolean z) {
        if (this.aeY == null) {
            this.aeY = new q(this.aeU.getContext());
        }
        this.aeY.g(this.mId);
        this.aeY.aC(z);
        this.aeU.a(this.aeY);
        return this.aeY;
    }

    public ac rF() {
        if (this.aeZ == null) {
            this.aeZ = new ac(((TbPageContextSupport) this.aeU.getView().getContext()).getPageContext());
            this.aeZ.setPageId(this.mId);
        }
        this.aeU.a(this.aeZ);
        return this.aeZ;
    }

    public y bk(int i) {
        if (this.afa == null) {
            this.afa = new y(this.aeU.getView().getContext(), i);
            this.afa.setPageId(this.mId);
        }
        this.aeU.a(this.afa);
        return this.afa;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.aeU.getView().setVisibility(8);
            return;
        }
        this.aeU.getView().setVisibility(0);
        if (this.aeV != null && this.aeV.adW != null) {
            if (!t.isSelf() && t.aIy() != null) {
                this.aeV.A(t.aIy());
                this.aeV.adW.setVisibility(0);
                z = true;
            } else if (this.aeV != null && this.aeV.adW != null) {
                this.aeV.adW.setVisibility(8);
            }
        }
        this.aeU.c((ad<T>) t);
        if (this.aeW != null) {
            this.aeW.A(t.aIw());
        }
        if (this.aeZ != null) {
            this.aeZ.aE(z);
            this.aeZ.A(t.aIw());
        }
        if (this.aeY != null) {
            this.aeY.A(t.aIw());
        }
        if (this.afa != null) {
            this.afa.A(t.aIw());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.z<T> zVar) {
        this.aeU.a(zVar);
    }
}
