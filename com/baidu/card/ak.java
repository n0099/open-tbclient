package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes15.dex */
public class ak<T extends AbsThreadDataSupport> extends ad.a {
    private com.baidu.tieba.card.aa<T> afT;
    private ai<T> afU;
    private z afV;
    private ap afW;
    private s afX;
    private ah afY;
    private ab afZ;
    private i aga;
    private BdUniqueId mId;

    public ak(ai<T> aiVar) {
        super(aiVar.getView());
        this.afU = aiVar;
    }

    @Override // com.baidu.adp.widget.ListView.ad.a
    public View getView() {
        return this.afU.getView();
    }

    public ai<T> sg() {
        return this.afU;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.afU.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.rQ() != null) {
            this.afU.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.afV);
            return;
        }
        if (this.afV == null) {
            this.afV = new z(getTbPageContext(), align);
            this.afV.aeR.setUniqueId(this.mId);
            this.afV.a(aVar);
        }
        this.afV.a(align);
        this.afU.b(this.afV);
    }

    public z aK(boolean z) {
        if (this.afV == null) {
            this.afV = new z(getTbPageContext(), z);
            this.afV.aeR.setUniqueId(this.mId);
        }
        this.afU.b(this.afV);
        return this.afV;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.afW);
            return;
        }
        if (this.afW == null) {
            this.afW = new ap(getTbPageContext(), align);
        }
        this.afW.a(align);
        this.afU.b(this.afW);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.aga);
            return;
        }
        if (this.aga == null) {
            this.aga = new i(getTbPageContext(), com.baidu.tbadk.a.d.aRL());
            this.aga.setOnClickEvent(aVar);
        }
        this.aga.setPageUniqueId(this.mId);
        this.afU.b(this.aga);
    }

    public s sh() {
        return aL(true);
    }

    public s aL(boolean z) {
        if (this.afX == null) {
            this.afX = new s(this.afU.getContext());
        }
        this.afX.h(this.mId);
        this.afX.aH(z);
        this.afU.b(this.afX);
        return this.afX;
    }

    public ah si() {
        if (this.afY == null) {
            this.afY = new ah(getTbPageContext());
            this.afY.setPageId(this.mId);
        }
        this.afU.b(this.afY);
        return this.afY;
    }

    public ab bt(int i) {
        if (this.afZ == null) {
            this.afZ = new ab(this.afU.getView().getContext(), i);
            this.afZ.setPageId(this.mId);
        }
        this.afU.b(this.afZ);
        return this.afZ;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.afU.getView().setVisibility(8);
            return;
        }
        if (t.aTN() != null) {
            t.aTN().getTid();
        }
        if (t.aTN() != null && t.aTN().aWl() != null) {
            t.aTN().aWl().getName_show();
        }
        this.afU.getView().setVisibility(0);
        if (this.afV != null && this.afV.aeR != null) {
            if (!t.isSelf() && t.aTP() != null) {
                this.afV.f(t);
                this.afV.D(t.aTP());
                this.afV.aeR.setVisibility(0);
                z = true;
            } else if (this.afV != null && this.afV.aeR != null) {
                this.afV.aeR.setVisibility(8);
            }
        }
        if (this.afW != null) {
            this.afW.f(t);
            this.afW.D(t.aTN());
        }
        if (this.afY != null) {
            this.afY.aJ(z);
            this.afY.D(t.aTN());
        }
        if (this.afX != null) {
            this.afX.D(t.aTN());
        }
        if (this.afZ != null) {
            this.afZ.f(t);
            this.afZ.D(t.aTN());
        }
        if (this.aga != null) {
            this.aga.a(t, z);
            this.aga.D(t.aTN());
        }
        this.afU.g(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.afT = aaVar;
        this.afU.a(aaVar);
    }
}
