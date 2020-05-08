package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public class af<T extends com.baidu.tbadk.core.data.a> extends y.a {
    private ad<T> aeX;
    private w aeY;
    private aj aeZ;
    private com.baidu.tieba.card.z<T> afa;
    private q afb;
    private ac afc;
    private y afd;
    private BdUniqueId mId;

    public af(ad<T> adVar) {
        super(adVar.getView());
        this.afa = null;
        this.aeX = adVar;
    }

    @Override // com.baidu.adp.widget.ListView.y.a
    public View getView() {
        return this.aeX.getView();
    }

    public ad<T> rD() {
        return this.aeX;
    }

    public w aF(boolean z) {
        if (this.aeY == null) {
            this.aeY = new w(((TbPageContextSupport) this.aeX.getView().getContext()).getPageContext(), z);
            this.aeY.adZ.setUniqueId(this.mId);
        }
        this.aeX.a(this.aeY);
        return this.aeY;
    }

    public aj aG(boolean z) {
        if (this.aeZ == null) {
            this.aeZ = new aj(((TbPageContextSupport) this.aeX.getView().getContext()).getPageContext(), z);
        }
        this.aeX.a(this.aeZ);
        return this.aeZ;
    }

    public q rE() {
        return aH(true);
    }

    public q aH(boolean z) {
        if (this.afb == null) {
            this.afb = new q(this.aeX.getContext());
        }
        this.afb.g(this.mId);
        this.afb.aC(z);
        this.aeX.a(this.afb);
        return this.afb;
    }

    public ac rF() {
        if (this.afc == null) {
            this.afc = new ac(((TbPageContextSupport) this.aeX.getView().getContext()).getPageContext());
            this.afc.setPageId(this.mId);
        }
        this.aeX.a(this.afc);
        return this.afc;
    }

    public y bk(int i) {
        if (this.afd == null) {
            this.afd = new y(this.aeX.getView().getContext(), i);
            this.afd.setPageId(this.mId);
        }
        this.aeX.a(this.afd);
        return this.afd;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.aeX.getView().setVisibility(8);
            return;
        }
        this.aeX.getView().setVisibility(0);
        if (this.aeY != null && this.aeY.adZ != null) {
            if (!t.isSelf() && t.aIw() != null) {
                this.aeY.B(t.aIw());
                this.aeY.adZ.setVisibility(0);
                z = true;
            } else if (this.aeY != null && this.aeY.adZ != null) {
                this.aeY.adZ.setVisibility(8);
            }
        }
        this.aeX.c((ad<T>) t);
        if (this.aeZ != null) {
            this.aeZ.B(t.aIu());
        }
        if (this.afc != null) {
            this.afc.aE(z);
            this.afc.B(t.aIu());
        }
        if (this.afb != null) {
            this.afb.B(t.aIu());
        }
        if (this.afd != null) {
            this.afd.B(t.aIu());
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.z<T> zVar) {
        this.aeX.a(zVar);
    }
}
